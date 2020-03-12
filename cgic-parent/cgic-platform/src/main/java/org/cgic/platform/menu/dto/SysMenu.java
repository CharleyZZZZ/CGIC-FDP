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
 * @Description 菜单DTO
 * @Author: charleyZZZZ
 * @Date: 2019/10/10 14:50
 * @Version 1.0
 */
@Getter
@Setter
@ApiModel("菜单表")
@Table(name = "sys_menu")
public class SysMenu extends BaseDTO{

    public static final String FIELD_MENU_ID = "menuId";
    public static final String FIELD_MENU_CODE = "menuCode";
    public static final String FIELD_MENU_NAME = "menuName";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_RESOURCE_ID = "resourceId";
    public static final String FIELD_PARENT_ID = "parentId";
    public static final String FIELD_MENU_ORDER = "menuOrder";
    public static final String FIELD_IS_ENABLED = "isEnabled";


    public SysMenu() {
    }

    public SysMenu(Long menuId) {
        this.menuId = menuId;
    }

    @Id
    private Long menuId;

    @Column
    @NotEmpty
    private String menuCode;

    @Column
    @NotEmpty
    private String menuName;

    @Column
    private String description;

    @Column
    private Long resourceId;

    @Column
    private Long parentId;

    @Column
    private Long menuOrder;

    @Column
    @NotEmpty
    private String isEnabled;


}
