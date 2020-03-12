package org.cgic.oauth.mapper;

import org.cgic.commons.dto.SysRole;
import org.cgic.commons.dto.SysRoleResource;
import org.apache.ibatis.annotations.Mapper;
import org.cgic.commons.mapper.BaseMapper;

import java.util.List;

/**
 * 角色资源关系表Mapper
 *
 * @author charleyZZZZ 2019-07-02 14:09:54
 */
@Mapper
public interface SysRoleResourceMapper extends BaseMapper<SysRoleResource> {


    /**
     * 根据资源查询角色列表
     * @param requestUrl
     * @return
     */
    List<SysRole> selectRolesByResourceUrl(String requestUrl);
}



