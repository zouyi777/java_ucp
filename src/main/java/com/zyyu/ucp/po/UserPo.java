package com.zyyu.ucp.po;

import com.zyyu.ucp.enums.GenderEnum;
import com.zyyu.ucp.enums.UserStateEnum;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 用户
 */
public class UserPo {
    /**用户id*/
    private Long userId;
    /**用户名*/
    private String userName;
    /**密码*/
    private String password;
    /**用户状态*/
    private UserStateEnum state;
    /**昵称*/
    private String nickName;
    /**身份证号码*/
    private String idNumber;
    /**真实名字*/
    private String realName;
    /**头像*/
    private String avatar;
    /**年龄*/
    private Integer age;
    /**生日*/
    private Date birthday;
    /**性别*/
    private GenderEnum gender;
    /**手机号码*/
    private String mobilePhone;
    /**邮箱*/
    private String email;
    /**个性签名*/
    private String slefWord;
    /**创建时间*/
    private Timestamp createTime;
    /**更新时间*/
    private Timestamp updateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public UserStateEnum getState() {
        return state;
    }

    public void setState(UserStateEnum state) {
        this.state = state;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getSlefWord() {
        return slefWord;
    }

    public void setSlefWord(String slefWord) {
        this.slefWord = slefWord;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
