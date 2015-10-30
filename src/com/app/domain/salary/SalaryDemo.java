package com.app.domain.salary;

import java.io.Serializable;
import java.sql.Date;

public class SalaryDemo implements Serializable {

	private static final long serialVersionUID = -8684417292641431407L;
	private Long saldemoid;
	private String saldemoname;
	private String saldemoen;
	private String saldemost;
	private String saldemods;
	private Long coid;
	private String coname;
	private Date createtime;
	private Date updatetime;
	private String createby;
	private String updateby;
	public Long getSaldemoid() {
		return saldemoid;
	}
	public void setSaldemoid(Long saldemoid) {
		this.saldemoid = saldemoid;
	}
	public String getSaldemoname() {
		return saldemoname;
	}
	public void setSaldemoname(String saldemoname) {
		this.saldemoname = saldemoname;
	}
	public String getSaldemoen() {
		return saldemoen;
	}
	public void setSaldemoen(String saldemoen) {
		this.saldemoen = saldemoen;
	}
	public String getSaldemost() {
		return saldemost;
	}
	public void setSaldemost(String saldemost) {
		this.saldemost = saldemost;
	}
	public String getSaldemods() {
		return saldemods;
	}
	public void setSaldemods(String saldemods) {
		this.saldemods = saldemods;
	}
	public Long getCoid() {
		return coid;
	}
	public void setCoid(Long coid) {
		this.coid = coid;
	}
	public String getConame() {
		return coname;
	}
	public void setConame(String coname) {
		this.coname = coname;
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
