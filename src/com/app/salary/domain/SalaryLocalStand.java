package com.app.salary.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class SalaryLocalStand implements Serializable {

	private static final long serialVersionUID = 1314719048334799845L;
	private Long standid;
	private String standname;
	private BigDecimal yanglc;
	private BigDecimal yanglg;
	private BigDecimal yilc;
	private BigDecimal yilg;
	private BigDecimal shiyc;
	private BigDecimal shiyg;
	private BigDecimal gongsc;
	private BigDecimal shengyc;
	private BigDecimal zhufc;
	private BigDecimal zhufg;
	private BigDecimal lowlimit;	
	private BigDecimal uplimit;
	private BigDecimal averagesal;
	private String statu;
	private String areacode;
	private String areaname;
	private Date createtime;
	private Date updatetime;
	private String createby;
	private String updateby;
	private BigDecimal yanglb;
	private BigDecimal yilb;
	private BigDecimal zhufb;
	private BigDecimal shiyb;
	private BigDecimal shengyb;
	private BigDecimal gongsb;
	private String usedate;
	public BigDecimal getYanglb() {
		return yanglb;
	}
	public void setYanglb(BigDecimal yanglb) {
		this.yanglb = yanglb;
	}
	public BigDecimal getYilb() {
		return yilb;
	}
	public void setYilb(BigDecimal yilb) {
		this.yilb = yilb;
	}
	public BigDecimal getZhufb() {
		return zhufb;
	}
	public void setZhufb(BigDecimal zhufb) {
		this.zhufb = zhufb;
	}
	public BigDecimal getShiyb() {
		return shiyb;
	}
	public void setShiyb(BigDecimal shiyb) {
		this.shiyb = shiyb;
	}
	public BigDecimal getShengyb() {
		return shengyb;
	}
	public void setShengyb(BigDecimal shengyb) {
		this.shengyb = shengyb;
	}
	public String getUsedate() {
		return usedate;
	}
	public void setUsedate(String usedate) {
		this.usedate = usedate;
	}
	public Long getStandid() {
		return standid;
	}
	public void setStandid(Long standid) {
		this.standid = standid;
	}
	public String getStandname() {
		return standname;
	}
	public void setStandname(String standname) {
		this.standname = standname;
	}
	public BigDecimal getYanglc() {
		return yanglc;
	}
	public void setYanglc(BigDecimal yanglc) {
		this.yanglc = yanglc;
	}
	public BigDecimal getYanglg() {
		return yanglg;
	}
	public void setYanglg(BigDecimal yanglg) {
		this.yanglg = yanglg;
	}
	public BigDecimal getYilc() {
		return yilc;
	}
	public void setYilc(BigDecimal yilc) {
		this.yilc = yilc;
	}
	public BigDecimal getYilg() {
		return yilg;
	}
	public void setYilg(BigDecimal yilg) {
		this.yilg = yilg;
	}
	public BigDecimal getShiyc() {
		return shiyc;
	}
	public void setShiyc(BigDecimal shiyc) {
		this.shiyc = shiyc;
	}
	public BigDecimal getShiyg() {
		return shiyg;
	}
	public void setShiyg(BigDecimal shiyg) {
		this.shiyg = shiyg;
	}
	public BigDecimal getGongsc() {
		return gongsc;
	}
	public void setGongsc(BigDecimal gongsc) {
		this.gongsc = gongsc;
	}
	public BigDecimal getShengyc() {
		return shengyc;
	}
	public void setShengyc(BigDecimal shengyc) {
		this.shengyc = shengyc;
	}
	public BigDecimal getZhufc() {
		return zhufc;
	}
	public void setZhufc(BigDecimal zhufc) {
		this.zhufc = zhufc;
	}
	public BigDecimal getZhufg() {
		return zhufg;
	}
	public void setZhufg(BigDecimal zhufg) {
		this.zhufg = zhufg;
	}
	public BigDecimal getLowlimit() {
		return lowlimit;
	}
	public void setLowlimit(BigDecimal lowlimit) {
		this.lowlimit = lowlimit;
	}
	public BigDecimal getUplimit() {
		return uplimit;
	}
	public void setUplimit(BigDecimal uplimit) {
		this.uplimit = uplimit;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
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
	public BigDecimal getAveragesal() {
		return averagesal;
	}
	public void setAveragesal(BigDecimal averagesal) {
		this.averagesal = averagesal;
	}
	public BigDecimal getGongsb() {
		return gongsb;
	}
	public void setGongsb(BigDecimal gongsb) {
		this.gongsb = gongsb;
	}
}
