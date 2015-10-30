package com.app.domain.salary;

import java.io.Serializable;
import java.sql.Date;

public class SalaryDemoEle implements Serializable {

	private static final long serialVersionUID = -5909344793834765434L;
	private Long eleid;
	private String elename;
	private String fixedcode;
	private String isshow;
	private String cptype;
	private String precision;
	private Long demoid;
	private String demoname;
	private String coname;
	private Long coid;
	private Date createtime;
	private Date updatetime;
	private String createby;
	private String updateby;
	private String ot;
	public String getOt() {
		return ot;
	}
	public void setOt(String ot) {
		this.ot = ot;
	}
	public String getDemoname() {
		return demoname;
	}
	public void setDemoname(String demoname) {
		this.demoname = demoname;
	}
	public String getConame() {
		return coname;
	}
	public void setConame(String coname) {
		this.coname = coname;
	}
	public Long getEleid() {
		return eleid;
	}
	public void setEleid(Long eleid) {
		this.eleid = eleid;
	}
	public String getElename() {
		return elename;
	}
	public void setElename(String elename) {
		this.elename = elename;
	}
	public String getFixedcode() {
		return fixedcode;
	}
	public void setFixedcode(String fixedcode) {
		this.fixedcode = fixedcode;
	}
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	public String getCptype() {
		return cptype;
	}
	public void setCptype(String cptype) {
		this.cptype = cptype;
	}
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	public Long getDemoid() {
		return demoid;
	}
	public void setDemoid(Long demoid) {
		this.demoid = demoid;
	}
	public Long getCoid() {
		return coid;
	}
	public void setCoid(Long coid) {
		this.coid = coid;
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
	public String getCreateby() {
		return createby;
	}
	public void setCreateby(String createby) {
		this.createby = createby;
	}
	public String getUpdateby() {
		return updateby;
	}
	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
