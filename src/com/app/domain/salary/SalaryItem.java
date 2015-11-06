package com.app.domain.salary;

import java.io.Serializable;
import java.sql.Date;

public class SalaryItem  implements Serializable {

	private static final long serialVersionUID = -4182728934813117860L;
	private Long salitemid;
	private String salitemid_st;
	private Long eleid;
	private String elename;
	private Long peid;
	private String pename;
	private String basevalue;
	private String fixedcode;
	private String isstop;
	private Long demoid;
	private String demoname;
	private String coname;
	private Long coid;
	private Date createtime;
	private Date updatetime;
	private String createby;
	private String updateby;
	public Long getSalitemid() {
		return salitemid;
	}
	public void setSalitemid(Long salitemid) {
		this.salitemid = salitemid;
	}
	public String getSalitemid_st() {
		return salitemid_st;
	}
	public void setSalitemid_st(String salitemid_st) {
		this.salitemid_st = salitemid_st;
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
	public Long getPeid() {
		return peid;
	}
	public void setPeid(Long peid) {
		this.peid = peid;
	}
	public String getPename() {
		return pename;
	}
	public void setPename(String pename) {
		this.pename = pename;
	}
	public String getBasevalue() {
		return basevalue;
	}
	public void setBasevalue(String basevalue) {
		this.basevalue = basevalue;
	}
	public String getFixedcode() {
		return fixedcode;
	}
	public void setFixedcode(String fixedcode) {
		this.fixedcode = fixedcode;
	}
	public String getIsstop() {
		return isstop;
	}
	public void setIsstop(String isstop) {
		this.isstop = isstop;
	}
	public Long getDemoid() {
		return demoid;
	}
	public void setDemoid(Long demoid) {
		this.demoid = demoid;
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
