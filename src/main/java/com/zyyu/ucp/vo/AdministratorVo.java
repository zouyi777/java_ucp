package com.zyyu.ucp.vo;


import com.zyyu.ucp.enums.AccountStateEnum;
import com.zyyu.ucp.po.BasePo;
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
    private Long roleId;
    private Long adminMobilePhone;
    private Long adminEmail;

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

}
