package org.cgic.platform.hr.dto;

import org.cgic.commons.dto.SysRole;

import java.util.List;

/**
 * @Description
 * @Author: charleyZZZZ
 * @Date: 2019/11/6 16:18
 * @Version 1.0
 */
public class UserInfoDTO {

    private String username;
    private String password;
    private String displayName;
    private String email;
    private String phone;
    private Long userId;
    private Long employeeId;
    private Long clientId;
    private String clientName;
    private Boolean isAdmin;
    private List<Long> rolesId;
    private List<SysRole> roles;
}
