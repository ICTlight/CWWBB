package com.app.user.domain;

import java.io.Serializable;
import java.sql.Date;

public class Company implements Serializable {

	private static final long serialVersionUID = -5645769288005234756L;
	private Long userid;
	private String username;
	private String email;
	private String validate_code;
	private String usertype;
	private String companyid;
	private String companyname;
	private String connectphone;
	private String connectname;	
	private String address;
	private String password;
	private String status;
	private Date createtime;
	private Date updatetime;
	public String getValidate_code() {
		return validate_code;
	}
	public void setValidate_code(String validate_code) {
		this.validate_code = validate_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getConnectphone() {
		return connectphone;
	}
	public void setConnectphone(String connectphone) {
		this.connectphone = connectphone;
	}
	public String getConnectname() {
		return connectname;
	}
	public void setConnectname(String connectname) {
		this.connectname = connectname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
