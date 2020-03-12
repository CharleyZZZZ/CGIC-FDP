package org.cgic.oauth.controller;

import org.cgic.commons.dto.BaseResponseDTO;
import org.cgic.commons.service.ISysUserService;
import org.cgic.commons.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author: charleyZZZZ
 * @Date: 2019/10/12 17:15
 * @Version 1.0
 */
@Controller
@RequestMapping("/test")
public class MyTestController extends BaseController {


    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/user/{username}")
    @ResponseBody
    public BaseResponseDTO getUserInfo(@PathVariable(value = "username", required = true) String username) {
        return new BaseResponseDTO(sysUserService.selectUserByUserName(username));
    }


    @GetMapping("/user/info")
    @ResponseBody
    public BaseResponseDTO getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        return new BaseResponseDTO(principal);
    }
}
