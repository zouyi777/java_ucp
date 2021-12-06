package com.zyyu.ucp.po;


import com.zyyu.ucp.enums.AccountStateEnum;

/**
 * 管理员
 */
public class AdministratorPo extends BasePo{
    private String adminName;
    private String adminPassword;
    private String adminNickName;
    private AccountStateEnum adminState;
    private Long roleId;
    private Long adminMobilePhone;
    private Long adminEmail;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
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

}
