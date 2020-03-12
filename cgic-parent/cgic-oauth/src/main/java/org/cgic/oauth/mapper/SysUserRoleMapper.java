package org.cgic.oauth.mapper;

import org.cgic.commons.dto.SysRole;
import org.cgic.commons.dto.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.cgic.commons.mapper.BaseMapper;

import java.util.List;

/**
 * 用户角色关系表Mapper
 *
 * @author charleyZZZZ 2019-07-02 14:09:54
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * @Description: 根据userId获取角色列表
     * @param userId
     * @return java.util.List<com.putech.oauth.entity.SysRole>
     *
     * Modification History
     * Date            Author           Description
     * ----------------------------------------------------
     * 2019/7/4      charleyZZZZ      create/modify
     */
    List<SysRole> selectRolesByUserId(Long userId);
}

