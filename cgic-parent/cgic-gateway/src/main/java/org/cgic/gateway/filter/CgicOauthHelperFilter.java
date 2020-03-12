package org.cgic.gateway.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.cgic.commons.dto.BaseResponseDTO;
import org.cgic.commons.oauth.UserDetailImpl;
import org.cgic.gateway.config.CgicGatewayProperties;
import org.cgic.gateway.exception.ExtractJwtTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.*;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description 鉴权
 * @Author: charleyZZZZ
 * @Date: 2019/10/14 16:22
 * @Version 1.0
 */
@Component
public class CgicOauthHelperFilter extends ZuulFilter {

    private static final String JWT_TOKEN = "jwt_token:";
    private static final BASE64Encoder encoder = new BASE64Encoder();
    private static final String USER_ID = "userId";
    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String DISPLAY_NAME = "displayName";
    private static final String EMPLOYEE_ID = "employeeId";
    private static final String ROLE_IDS = "roleIds";

    @Autowired
    private Signer jwtSigner;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private ValueOperations<String, Object> operations = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(CgicOauthHelperFilter.class);
    @Autowired
    private CgicGatewayProperties gatewayHelperProperties;

    private final AntPathMatcher matcher = new AntPathMatcher();
    private final String[] headers = new String[]{"server", "host", "x-application-context", "transfer-encoding"};

    public CgicOauthHelperFilter() {

    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        this.operations = redisTemplate.opsForValue();
//    }

//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        LOGGER.info("============ CgicOauthHelperFilter doFilter ===================");
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        // 匹配是否放行请求
//        boolean releasedPath = Arrays.stream(this.gatewayHelperProperties.getReleasedPath()).anyMatch((t) -> {
//            return this.matcher.match(t, req.getRequestURI());
//        });
//        // 构造请求oauth服务的header
//        HttpEntity entity = getHttpEntity(req);
//
//        if (releasedPath) {
//            filterChain.doFilter(req, resp);
//        } else {
////            String tokenBody = processToken(token);
////            Boolean hasKey = redisTemplate.hasKey(JWT_TOKEN + tokenBody);
////            if (!hasKey) {
////                resp.setStatus(401);
////                this.setGatewayHelperFailureResponse(resp);
////                return;
////            }
//            // redis 中获取jwtToken
////            String redisJwtToken = getJwtTokenFromRedis(tokenBody);
////            if (redisJwtToken == null) {
//            ResponseEntity<BaseResponseDTO> responseEntity = null;
//            try {
//                responseEntity = this.restTemplate.exchange(this.gatewayHelperProperties.getUserInfoUri(), HttpMethod.GET, entity, BaseResponseDTO.class, new Object[0]);
//                if (null != responseEntity && responseEntity.getStatusCode().is2xxSuccessful()) {
//                    BaseResponseDTO responseDTO = responseEntity.getBody();
//                    if (!"200".equals(responseDTO.getCode())) {
//                        this.setGatewayHelperFailureResponse(responseEntity, resp);
//                        return;
//                    }
//                    UserDetailImpl userDetail = this.extractUserDetail((Map) responseDTO.getRows().get(0));
//                    String jwtToken = extractJwtToken(userDetail);
//                    request.setAttribute("Jwt_Token",jwtToken);
//                    //                        refreshRedis(jwtToken, tokenBody);
//                } else {
//                    throw new GatewayAuthenticationException("400401", "鉴权失败");
//                }
//            } catch (Exception e) {
//                this.setGatewayHelperFailureResponse(responseEntity, resp);
//                return;
//            }
////            }
//            filterChain.doFilter(request, resp);
//        }
//    }

    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * 过滤器主体
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        HttpServletResponse resp = ctx.getResponse();
        // 跨域处理
        processAccessControl(req, resp);
            //只过滤OPTIONS 请求
        if(req.getMethod().equals(RequestMethod.OPTIONS.name())){
            //不再路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(200);
            return null;
        }
        // 匹配是否放行请求
        boolean releasedPath = Arrays.stream(this.gatewayHelperProperties.getReleasedPath()).anyMatch((t) -> {
            return this.matcher.match(t, req.getRequestURI());
        });
        // 构造请求oauth服务的header
        HttpEntity entity = getHttpEntity(req);

        if (releasedPath) {
            return null;
        } else {
//            String tokenBody = processToken(token);
//            Boolean hasKey = redisTemplate.hasKey(JWT_TOKEN + tokenBody);
//            if (!hasKey) {
//                resp.setStatus(401);
//                this.setGatewayHelperFailureResponse(resp);
//                return;
//            }
            // redis 中获取jwtToken
//            String redisJwtToken = getJwtTokenFromRedis(tokenBody);
//            if (redisJwtToken == null) {
            ResponseEntity<BaseResponseDTO> responseEntity = null;
            try {
                responseEntity = this.restTemplate.exchange(this.gatewayHelperProperties.getUserInfoUri(), HttpMethod.GET, entity, BaseResponseDTO.class, new Object[0]);
                if (null != responseEntity && responseEntity.getStatusCode().is2xxSuccessful()) {
                    BaseResponseDTO responseDTO = responseEntity.getBody();
                    if (!"200".equals(responseDTO.getCode())) {
                        setGatewayHelperFailureResponse(ctx,401);
                        return null;
                    }
                    UserDetailImpl userDetail = this.extractUserDetail((Map) responseDTO.getRows().get(0));
                    String jwtToken = extractJwtToken(userDetail);
                    ctx.setSendZuulResponse(true);
                    ctx.setResponseStatusCode(200);
                    ctx.addZuulRequestHeader("Jwt_Token", jwtToken);
                } else {
                    setGatewayHelperFailureResponse(ctx,401);
                }
            } catch (Exception e) {
                setGatewayHelperFailureResponse(ctx,401);
            }
            return null;
        }
    }

    /**
     * 处理跨域问题
     * @param req
     * @param resp
     */
    private void processAccessControl(HttpServletRequest req, HttpServletResponse resp) {
//        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Access-Control-Allow-Origin",req.getHeader("Origin"));
        resp.setHeader("Access-Control-Allow-Credentials","true");
        resp.setHeader("Access-Control-Allow-Headers","authorization, content-type");
        resp.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS");
        resp.setHeader("Access-Control-Expose-Headers","X-forwared-port, X-forwarded-host");
        resp.setHeader("Vary","Origin,Access-Control-Request-Method,Access-Control-Request-Headers");
    }


    private HttpEntity getHttpEntity(HttpServletRequest req) {
        HttpHeaders headers = new HttpHeaders();
        String token = req.getHeader("Authorization");
        headers.set("Authorization", token);
        return new HttpEntity("", headers);
    }

    private UserDetailImpl extractUserDetail(Map<String, Object> map) {
        if (map.containsKey("userId")) {
            UserDetailImpl userDetail = new UserDetailImpl((String) map.get("username"), "unknow", Collections.emptyList());
            if (map.get(USER_ID) != null) {
                userDetail.setUserId((long) ((Integer) map.get(USER_ID)).intValue());
                userDetail.setDisplayName((String) map.get(DISPLAY_NAME));
                userDetail.setEmployeeId(Long.valueOf(map.get(EMPLOYEE_ID).toString()));
                if (map.get(EMAIL) != null) {
                    userDetail.setEmail((String) map.get(EMAIL));
                }
                if (map.get(PHONE) != null) {
                    userDetail.setPhone((String) map.get(PHONE));
                }
                List roleIdList;
                if (map.get(ROLE_IDS) != null) {
                    Object roleIds = map.get(ROLE_IDS);
                    if (roleIds instanceof List) {
                        roleIdList = (List) roleIds;
                        userDetail.setRoleIds((List) roleIdList.stream().map((item) -> {
                            return Long.valueOf(String.valueOf(item));
                        }).collect(Collectors.toList()));
                    }
                }
            }
            return userDetail;
        }
        return null;
    }

    private String extractJwtToken(UserDetailImpl userDetail) throws ExtractJwtTokenException {
        try {
            String token = this.objectMapper.writeValueAsString(userDetail);
            String jwt = "Bearer " + JwtHelper.encode(token, this.jwtSigner).getEncoded();
            return jwt;
        } catch (Exception e) {
            throw new ExtractJwtTokenException("400001", "导出jwt_token异常...");
        }
    }


    /**
     * 设置出错响应
     *
     * @param ctx
     */
    private void setGatewayHelperFailureResponse(RequestContext ctx, int statusCode)  {
        String message;
        ctx.setResponseStatusCode(statusCode);
        ctx.setSendZuulResponse(false);
        if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
            message = "<oauth>\n\t<error_code>" + statusCode + "</error_code>\n\t<error_message>unauthorized</error_message>\n</oauth>";
            LOGGER.warn("gateway-helper response unauthorized, {}", statusCode);
        } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
            message = "<oauth>\n\t<error_code>" + statusCode + "</error_code>\n\t<error_message>forbidden</error_message>\n</oauth>";
            LOGGER.warn("gateway-helper response forbidden, {}", statusCode);
        } else {
            message = "<oauth>\n\t<error_code>" + statusCode + "</error_code>\n\t<error_message>error</error_message>\n</oauth>";
            LOGGER.warn("gateway-helper response error, {}", statusCode);
        }
        ctx.setResponseBody(message);
    }


    private void refreshRedis(String jwtToken, String tokenBody) {
        Long expire = redisTemplate.getExpire(JWT_TOKEN + tokenBody);
        redisTemplate.opsForValue().set(JWT_TOKEN + tokenBody, jwtToken, expire);
    }

    private String processToken(String token) {
        return token.substring("bearer".length()).trim();
    }

    private UserDetailImpl extractPrincipal(Map<String, Object> map) {
        boolean isClientOnly = false;
        if (map.get("oauth2Request") != null) {
            Map<String, Object> oauth2request = (Map) map.get("oauth2Request");
            if (oauth2request.get("grantType").equals("client_credentials")) {
                isClientOnly = true;
            }
        }

        if (map.get("principal") != null) {
            map = (Map) map.get("principal");
        }

        return this.setUserDetails(map, isClientOnly);
    }

    /**
     * 获取JwtToken
     *
     * @param token
     * @return
     */
    private String getJwtTokenFromRedis(String token) {
        return (String) redisTemplate.opsForValue().get(JWT_TOKEN + token);
    }

    /**
     * 修改请求头信息
     *
     * @param headerses
     * @param request
     */
    private void modifyHeaders(HttpServletRequest request, Map<String, String> headerses) {
        if (headerses == null || headerses.isEmpty()) {
            return;
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private UserDetailImpl setUserDetails(Map<String, Object> map, boolean isClientOnly) {
//        if (map.containsKey("userId")) {
//            CustomUserDetails user = new CustomUserDetails((String)map.get("username"), "unknown password", Collections.emptyList());
//            user.setOrganizationId((long)((Integer)map.get("organizationId")).intValue());
//            if (map.get("userId") != null) {
//                user.setUserId((long)((Integer)map.get("userId")).intValue());
//                user.setLanguage((String)map.get("language"));
//                user.setAdmin((Boolean)map.get("admin"));
//                user.setTimeZone((String)map.get("timeZone"));
//                if (map.get("email") != null) {
//                    user.setEmail((String)map.get("email"));
//                }
//            }
//
//            if (isClientOnly) {
//                user.setClientId((long)((Integer)map.get("clientId")).intValue());
//                user.setClientName((String)map.get("clientName"));
//                user.setClientAccessTokenValiditySeconds((Integer)map.get("clientAccessTokenValiditySeconds"));
//                user.setClientRefreshTokenValiditySeconds((Integer)map.get("clientRefreshTokenValiditySeconds"));
//                user.setClientAuthorizedGrantTypes((Collection)map.get("clientAuthorizedGrantTypes"));
//                user.setClientAutoApproveScopes((Collection)map.get("clientAutoApproveScopes"));
//                user.setClientRegisteredRedirectUri((Collection)map.get("clientRegisteredRedirectUri"));
//                user.setClientResourceIds((Collection)map.get("clientResourceIds"));
//                user.setClientScope((Collection)map.get("clientScope"));
//            }
//
//            try {
//                if (map.get("additionInfo") != null) {
//                    user.setAdditionInfo((Map)map.get("additionInfo"));
//                }
//            } catch (exception var5) {
//                LOGGER.warn("Parser addition info error:{}", var5);
//            }
//
//            return user;
//        } else {
        return null;
//        }
    }




}
