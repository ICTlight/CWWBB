package com.app.domain.salary;

import java.io.Serializable;

public class SalaryDemo implements Serializable {

	private static final long serialVersionUID = -8684417292641431407L;
	private Long userid;
	private String username;
	private String email;
	private String phone;
	private String realname;
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
