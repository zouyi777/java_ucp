package com.zyyu.ucp.vo;

import com.zyyu.ucp.enums.GenderEnum;
import com.zyyu.ucp.enums.AccountStateEnum;
import org.dozer.Mapping;

import java.util.Date;

public class UserVo extends BaseVo{
	/**用户id*/
	@Mapping("id")
	private String userId;
	/**用户名*/
	private String userName;
	/**用户状态*/
	private AccountStateEnum state;
	/**昵称*/
	private String nickName;
	/**身份证号码*/
	private String idNumber;
	/**真实名字*/
	private String realName;
	/**头像*/
	private String avatar;
	/**生日*/
	private Date birthday;
	/**性别*/
	private GenderEnum gender;
	/**手机号码*/
	private String mobilePhone;
	/**邮箱*/
	private String email;
	/**地址*/
	private String address;
	/**个性签名*/
	private String slefWord;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public AccountStateEnum getState() {
		return state;
	}

	public void setState(AccountStateEnum state) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSlefWord() {
		return slefWord;
	}

	public void setSlefWord(String slefWord) {
		this.slefWord = slefWord;
	}

}
