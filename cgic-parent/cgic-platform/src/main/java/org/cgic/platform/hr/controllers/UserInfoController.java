package org.cgic.platform.hr.controllers;

import org.cgic.commons.dto.BaseResponseDTO;
import org.cgic.commons.dto.UserDetailImpl;
import org.cgic.commons.web.BaseController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 获取用户信息
 * @Author: charleyZZZZ
 * @Date: 2019/11/6 16:15
 * @Version 1.0
 */
@Controller("/api/login")
public class UserInfoController extends BaseController{


    @RequestMapping("/user/info")
    @ResponseBody
    public BaseResponseDTO getLoginUserInfo(){
        UserDetailImpl principal = (UserDetailImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new BaseResponseDTO(principal);
    }


}
