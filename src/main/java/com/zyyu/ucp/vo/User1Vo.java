package com.zyyu.ucp.vo;

import com.zyyu.ucp.enums.GenderEnum;
import org.dozer.Mapping;

public class User1Vo {
	/**用户名*/
	@Mapping("username")
	private String name;
	/**密码*/
	@Mapping("password")
	private String pass;
	/**性别*/
	@Mapping("gender")
	private GenderEnum gen;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public GenderEnum getGen() {
		return gen;
	}

	public void setGen(GenderEnum gen) {
		this.gen = gen;
	}

}
