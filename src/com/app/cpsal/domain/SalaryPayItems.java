package com.app.cpsal.domain;

import java.io.Serializable;
import java.sql.Date;

public class SalaryPayItems  implements Serializable {

	private static final long serialVersionUID = 2635112454120114632L;
	private Long salitemid;
	private Long eleid;
	private String elename;
	private Long peid;
	private String pename;
	private String basevalue;
	private String isstop;
	private Long demoid;
	private String demoname;
	private String coname;
	private Long coid;
	private Date createtime;
	private Date updatetime;
	private String createby;
	private String updateby;
	private String statu;
	private String idnumber;
	private String cptype;
	private String isstand;
	private String standval;
	private String isshow;
	public Long getSalitemid() {
		return salitemid;
	}
	public void setSalitemid(Long salitemid) {
		this.salitemid = salitemid;
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
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getCptype() {
		return cptype;
	}
	public void setCptype(String cptype) {
		this.cptype = cptype;
	}
	public String getIsstand() {
		return isstand;
	}
	public void setIsstand(String isstand) {
		this.isstand = isstand;
	}
	public String getStandval() {
		return standval;
	}
	public void setStandval(String standval) {
		this.standval = standval;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
}
