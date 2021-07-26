package com.zyyu.ucp.vo;

import com.zyyu.ucp.enums.GenderEnum;

public class LoginVo {
	/**用户名*/
	private String username;
	/**密码*/
	private String password;
	/**性别*/
	private GenderEnum gender;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
}
