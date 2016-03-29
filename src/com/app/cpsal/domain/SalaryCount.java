package com.app.cpsal.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class SalaryCount implements Serializable {

	private static final long serialVersionUID = -274733926450939378L;
	private Long countid;//工资模板员工计算统计ID
	private Long peid;
	private String pename;
	private Long demoid;
	private String demoname;
	private Long coid;
	private String coname;
	private String idnumber;
	private BigDecimal TAX_BASE;//纳税标准
	private BigDecimal TAX_NO;//税无关
	private BigDecimal TAX_BEF_PLUS;//税前加
	private BigDecimal TAX_BEF_MINUS;//税前减
	private BigDecimal TAX_AFT_PLUS;	//税后加
	private BigDecimal TAX_AFT_MINUS;//税后减
	private BigDecimal TAX_INCOME_PLUS;//应纳税所得额加
	private BigDecimal TAX_INCOME_MINUS;//应纳税数额减
	private BigDecimal TAX_PLUS;	//税调整加
	private BigDecimal TAX_MINUS;//税调整减
	private BigDecimal AFT_TAX_ENVP;//税后推税_税后发公司付税
	private BigDecimal AFT_TAX_ENVN;//税后推税_税后不发公司付税
	private Date createtime;
	private Date updatetime;
	private String createby;
	private String updateby;
	private String statu;
	public BigDecimal getTAX_NO() {
		return TAX_NO;
	}
	public void setTAX_NO(BigDecimal tAX_NO) {
		TAX_NO = tAX_NO;
	}
	public BigDecimal getTAX_BASE() {
		return TAX_BASE;
	}
	public void setTAX_BASE(BigDecimal tAX_BASE) {
		TAX_BASE = tAX_BASE;
	}
	public BigDecimal getTAX_BEF_PLUS() {
		return TAX_BEF_PLUS;
	}
	public void setTAX_BEF_PLUS(BigDecimal tAX_BEF_PLUS) {
		TAX_BEF_PLUS = tAX_BEF_PLUS;
	}
	public BigDecimal getTAX_BEF_MINUS() {
		return TAX_BEF_MINUS;
	}
	public void setTAX_BEF_MINUS(BigDecimal tAX_BEF_MINUS) {
		TAX_BEF_MINUS = tAX_BEF_MINUS;
	}
	public BigDecimal getTAX_AFT_PLUS() {
		return TAX_AFT_PLUS;
	}
	public void setTAX_AFT_PLUS(BigDecimal tAX_AFT_PLUS) {
		TAX_AFT_PLUS = tAX_AFT_PLUS;
	}
	public BigDecimal getTAX_AFT_MINUS() {
		return TAX_AFT_MINUS;
	}
	public void setTAX_AFT_MINUS(BigDecimal tAX_AFT_MINUS) {
		TAX_AFT_MINUS = tAX_AFT_MINUS;
	}
	public BigDecimal getTAX_INCOME_PLUS() {
		return TAX_INCOME_PLUS;
	}
	public void setTAX_INCOME_PLUS(BigDecimal tAX_INCOME_PLUS) {
		TAX_INCOME_PLUS = tAX_INCOME_PLUS;
	}
	public BigDecimal getTAX_INCOME_MINUS() {
		return TAX_INCOME_MINUS;
	}
	public void setTAX_INCOME_MINUS(BigDecimal tAX_INCOME_MINUS) {
		TAX_INCOME_MINUS = tAX_INCOME_MINUS;
	}
	public BigDecimal getTAX_PLUS() {
		return TAX_PLUS;
	}
	public void setTAX_PLUS(BigDecimal tAX_PLUS) {
		TAX_PLUS = tAX_PLUS;
	}
	public BigDecimal getTAX_MINUS() {
		return TAX_MINUS;
	}
	public void setTAX_MINUS(BigDecimal tAX_MINUS) {
		TAX_MINUS = tAX_MINUS;
	}
	public BigDecimal getAFT_TAX_ENVP() {
		return AFT_TAX_ENVP;
	}
	public void setAFT_TAX_ENVP(BigDecimal aFT_TAX_ENVP) {
		AFT_TAX_ENVP = aFT_TAX_ENVP;
	}
	public BigDecimal getAFT_TAX_ENVN() {
		return AFT_TAX_ENVN;
	}
	public void setAFT_TAX_ENVN(BigDecimal aFT_TAX_ENVN) {
		AFT_TAX_ENVN = aFT_TAX_ENVN;
	}
	public Long getCountid() {
		return countid;
	}
	public void setCountid(Long countid) {
		this.countid = countid;
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
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
