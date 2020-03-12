package org.cgic.oauth.mapper;

import org.cgic.commons.dto.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.cgic.commons.mapper.BaseMapper;

/**
 * @Description
 * @Author: charleyZZZZ
 * @Date: 2019/7/1 16:13
 * @Version 1.0
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SysUser selectByUserName(String username);
}
