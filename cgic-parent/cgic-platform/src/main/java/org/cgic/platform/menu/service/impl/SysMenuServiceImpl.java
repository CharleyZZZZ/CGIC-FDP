package org.cgic.platform.menu.service.impl;

import org.cgic.platform.menu.dto.SysMenu;
import org.cgic.platform.menu.mapper.SysMenuMapper;
import org.cgic.platform.menu.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author: charleyZZZZ
 * @Date: 2019/10/11 16:30
 * @Version 1.0
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;


    @Override
    public SysMenu getMenu(Long menuId) {
        return sysMenuMapper.selectByPrimaryKey(new SysMenu(menuId));
    }
}
