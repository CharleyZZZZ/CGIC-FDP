package org.cgic.platform.menu.dto;

import com.pubud.commons.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description 菜单角色关系表
 * @Author: charleyZZZZ
 * @Date: 2019/10/10 14:50
 * @Version 1.0
 */
@Getter
@Setter
@ApiModel("菜单角色关系表")
@Table(name = "sys_menu")
public class SysMenuRole extends BaseDTO{


    @Id
    private Long menuRoleId;

    @Column
    @NotEmpty
    private Long menuId;

    @Column
    @NotEmpty
    private Long roleId;

    @Column
    @NotEmpty
    private String isEnabled;


}
