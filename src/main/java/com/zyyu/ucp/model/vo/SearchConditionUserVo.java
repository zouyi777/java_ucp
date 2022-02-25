package com.zyyu.ucp.model.vo;

/**
 * 用户查询条件
 */
public class SearchConditionUserVo extends SearchConditionBaseVo{

    //用户名
    private String userName;
    //手机号
    private String mobilePhone;
    //邮箱
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
