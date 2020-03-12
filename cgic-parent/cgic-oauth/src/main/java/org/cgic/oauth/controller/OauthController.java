package org.cgic.oauth.controller;

import com.alibaba.fastjson.JSONObject;
import org.cgic.commons.dto.BaseResponseDTO;
import org.cgic.commons.oauth.CustomUserDetailsServiceImpl;
import org.cgic.commons.oauth.UserDetailImpl;
import org.cgic.commons.service.ISysUserService;
import org.cgic.commons.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.Collections;

/**
 * @Description
 * @Author: charleyZZZZ
 * @Date: 2019/10/17 15:29
 * @Version 1.0
 */
@Controller
@RequestMapping("/api")
public class OauthController extends BaseController {


    final BASE64Encoder encoder = new BASE64Encoder();

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private CustomUserDetailsServiceImpl customUserDetailsService;

    @GetMapping("/user/info")
    @ResponseBody
    public BaseResponseDTO getJwtToken() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetailImpl) {
            UserDetailImpl userDetail = (UserDetailImpl) principal;
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(userDetail.getUsername());
            return new BaseResponseDTO(userDetails);
        }
        // 客户端模式
        UserDetailImpl clientUser = new UserDetailImpl("client_user", "unknow", Collections.emptyList());
        return new BaseResponseDTO(clientUser);
    }


    private BaseResponseDTO getBaseResponseDTO(BaseResponseDTO baseResponseDTO, UserDetailImpl userDetail) throws UnsupportedEncodingException {
        String jwtToken;
        String json = JSONObject.toJSONString(userDetail);
        jwtToken = encoder.encode(json.getBytes("UTF-8"));
        baseResponseDTO.setMessage(jwtToken);
        return baseResponseDTO;
    }
}
