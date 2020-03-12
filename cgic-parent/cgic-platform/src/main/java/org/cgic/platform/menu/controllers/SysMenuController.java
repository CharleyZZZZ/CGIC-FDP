package org.cgic.platform.menu.controllers;

import org.cgic.platform.menu.service.SysMenuService;
import com.pubud.commons.dto.BaseResponseDTO;
import com.pubud.commons.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author: charleyZZZZ
 * @Date: 2019/10/11 16:25
 * @Version 1.0
 */
@Controller
@RequestMapping("/api/menu")
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/info/{menuId}")
    @ResponseBody
    public BaseResponseDTO query(@PathVariable(value = "menuId") Long menuId) {
        return new BaseResponseDTO(sysMenuService.getMenu(menuId));
    }


}
