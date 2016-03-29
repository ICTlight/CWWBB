package com.app.salary.domain;

import java.io.Serializable;

public class SalaryStandEle implements Serializable {

	private static final long serialVersionUID = 8084774732463854780L;
	private Long eleid;
	private String eleid_st;
	private String elename;
	private String fixedcode;
	private String isshow;
	private String cptype;
	private String precisions;
	private String statu;
	private String basecode;
	public Long getEleid() {
		return eleid;
	}
	public void setEleid(Long eleid) {
		this.eleid = eleid;
	}
	public String getEleid_st() {
		return eleid_st;
	}
	public void setEleid_st(String eleid_st) {
		this.eleid_st = eleid_st;
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
	public String getPrecisions() {
		return precisions;
	}
	public void setPrecisions(String precisions) {
		this.precisions = precisions;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getBasecode() {
		return basecode;
	}
	public void setBasecode(String basecode) {
		this.basecode = basecode;
	}

}
