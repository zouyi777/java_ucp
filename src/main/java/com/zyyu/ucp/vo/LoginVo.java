package com.zyyu.ucp.vo;

import org.dozer.Mapping;

public class LoginVo {
	/**用户名*/
	@Mapping("userName")
	private String username;
	/**密码*/
	private String password;


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

}
