package com.zyyu.ucp.model.vo;


import com.zyyu.ucp.enums.AccountStateEnum;
import org.dozer.Mapping;

/**
 * 管理员
 */
public class AdministratorVo extends BaseVo{

    @Mapping("id")
    private String adminId;
    private String adminName;
    private String adminNickName;
    private AccountStateEnum adminState;
    private Long adminMobilePhone;
    private Long adminEmail;
    private Long roleId;
    private String roleName;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminNickName() {
        return adminNickName;
    }

    public void setAdminNickName(String adminNickName) {
        this.adminNickName = adminNickName;
    }
    public AccountStateEnum getAdminState() {
        return adminState;
    }

    public void setAdminState(AccountStateEnum adminState) {
        this.adminState = adminState;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAdminMobilePhone() {
        return adminMobilePhone;
    }

    public void setAdminMobilePhone(Long adminMobilePhone) {
        this.adminMobilePhone = adminMobilePhone;
    }

    public Long getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(Long adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
