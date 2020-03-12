package org.cgic.platform.menu.service;

import org.cgic.platform.menu.dto.SysMenu;

/**
 * @Description
 * @Author: charleyZZZZ
 * @Date: 2019/10/11 16:29
 * @Version 1.0
 */
public interface SysMenuService {

    SysMenu getMenu(Long menuId);
}
