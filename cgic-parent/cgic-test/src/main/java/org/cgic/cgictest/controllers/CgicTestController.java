package org.cgic.cgictest.controllers;


import org.apache.ibatis.annotations.Mapper;
import org.cgic.commons.dto.BaseResponseDTO;
import org.cgic.commons.dto.SysUser;
import org.cgic.commons.oauth.DetailsHelper;
import org.cgic.commons.service.ISysUserService;
import org.cgic.commons.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author: charleyZZZZ
 * @Date: 2019/10/11 18:15
 * @Version 1.0
 */
@Controller
@RequestMapping("/api/test")
public class CgicTestController extends BaseController {

    private static final String PREFIX_URL = "http://localhost:8080/cgic-platform";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @RequestMapping("/menu/{menuId}")
    @ResponseBody
    public BaseResponseDTO test(@PathVariable(value = "menuId") Long menuId) {
        return (BaseResponseDTO) this.restTemplate.getForObject(PREFIX_URL + "/api/menu/info/" + menuId, BaseResponseDTO.class, new Object[0]);
    }

    @GetMapping("/menu/info")
    @ResponseBody
    public BaseResponseDTO testMenu(HttpServletRequest req, HttpServletResponse resp) {
        return new BaseResponseDTO(DetailsHelper.getUserDetails());
    }

    @GetMapping("/user/info")
    @ResponseBody
    public BaseResponseDTO testUser(HttpServletRequest req, HttpServletResponse resp) {
        SysUser zhangsan = this.sysUserService.selectUserByUserName("zhangsan");
        return new BaseResponseDTO(zhangsan);
    }


    @GetMapping("/token/info")
    @ResponseBody
    public BaseResponseDTO token() {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        Boolean aBoolean = redisTemplate.hasKey("jwt_token:e5bda8fd-ad84-4973-bff1-0a4447621676");
        return new BaseResponseDTO(aBoolean == true ? "HAS_KEY" : "HAVENT_KEY");
    }


}
