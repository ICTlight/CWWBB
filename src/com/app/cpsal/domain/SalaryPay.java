package com.app.cpsal.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class SalaryPay implements Serializable {

	private static final long serialVersionUID = -1291871644265388034L;
	private Long payid;//工资模板员工计算统计ID
	private Long peid;
	private String pename;
	private Long demoid;
	private String demoname;
	private String idnumber;
	private BigDecimal tax_bef_plus_tol;//纳税标准
	private BigDecimal tax_bef_plusmin_tol;//税无关
	private BigDecimal tax_bef_tol;//税前加
	private BigDecimal tax_tol;//税前减
	private BigDecimal tax_value;	//税后加
	private BigDecimal tax_rate;//税后减
	private BigDecimal tax_deduction;//应纳税所得额加
	private BigDecimal tax_aft_salary;//应纳税数额减
	private BigDecimal aft_tax_pay_sum;	//税调整加
	private BigDecimal aft_tax_nopay_sum;//税调整减
	private BigDecimal tax_cpay_sum;//税后推税_税后发公司付税
	private BigDecimal tax_aft_sum;//税后推税_税后不发公司付税	
	private BigDecimal salary_pay;	//税调整加
	private BigDecimal aft_tax_tol_sum;//税调整减
	private BigDecimal tax_epay_sum;//税后推税_税后发公司付税
	private BigDecimal tax_cpay_nopay_sum;//税后推税_税后不发公司付税
	private Date createtime;
	private Date updatetime;
	private String createby;
	private String updateby;
	private String statu;
	
	public Long getPayid() {
		return payid;
	}
	public void setPayid(Long payid) {
		this.payid = payid;
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
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public BigDecimal getTax_bef_plus_tol() {
		return tax_bef_plus_tol;
	}
	public void setTax_bef_plus_tol(BigDecimal tax_bef_plus_tol) {
		this.tax_bef_plus_tol = tax_bef_plus_tol;
	}
	public BigDecimal getTax_bef_plusmin_tol() {
		return tax_bef_plusmin_tol;
	}
	public void setTax_bef_plusmin_tol(BigDecimal tax_bef_plusmin_tol) {
		this.tax_bef_plusmin_tol = tax_bef_plusmin_tol;
	}
	public BigDecimal getTax_bef_tol() {
		return tax_bef_tol;
	}
	public void setTax_bef_tol(BigDecimal tax_bef_tol) {
		this.tax_bef_tol = tax_bef_tol;
	}
	public BigDecimal getTax_tol() {
		return tax_tol;
	}
	public void setTax_tol(BigDecimal tax_tol) {
		this.tax_tol = tax_tol;
	}
	public BigDecimal getTax_value() {
		return tax_value;
	}
	public void setTax_value(BigDecimal tax_value) {
		this.tax_value = tax_value;
	}
	public BigDecimal getTax_rate() {
		return tax_rate;
	}
	public void setTax_rate(BigDecimal tax_rate) {
		this.tax_rate = tax_rate;
	}
	public BigDecimal getTax_deduction() {
		return tax_deduction;
	}
	public void setTax_deduction(BigDecimal tax_deduction) {
		this.tax_deduction = tax_deduction;
	}
	public BigDecimal getTax_aft_salary() {
		return tax_aft_salary;
	}
	public void setTax_aft_salary(BigDecimal tax_aft_salary) {
		this.tax_aft_salary = tax_aft_salary;
	}
	public BigDecimal getAft_tax_pay_sum() {
		return aft_tax_pay_sum;
	}
	public void setAft_tax_pay_sum(BigDecimal aft_tax_pay_sum) {
		this.aft_tax_pay_sum = aft_tax_pay_sum;
	}
	public BigDecimal getAft_tax_nopay_sum() {
		return aft_tax_nopay_sum;
	}
	public void setAft_tax_nopay_sum(BigDecimal aft_tax_nopay_sum) {
		this.aft_tax_nopay_sum = aft_tax_nopay_sum;
	}
	public BigDecimal getTax_cpay_sum() {
		return tax_cpay_sum;
	}
	public void setTax_cpay_sum(BigDecimal tax_cpay_sum) {
		this.tax_cpay_sum = tax_cpay_sum;
	}
	public BigDecimal getTax_aft_sum() {
		return tax_aft_sum;
	}
	public void setTax_aft_sum(BigDecimal tax_aft_sum) {
		this.tax_aft_sum = tax_aft_sum;
	}
	public BigDecimal getSalary_pay() {
		return salary_pay;
	}
	public void setSalary_pay(BigDecimal salary_pay) {
		this.salary_pay = salary_pay;
	}
	public BigDecimal getAft_tax_tol_sum() {
		return aft_tax_tol_sum;
	}
	public void setAft_tax_tol_sum(BigDecimal aft_tax_tol_sum) {
		this.aft_tax_tol_sum = aft_tax_tol_sum;
	}
	public BigDecimal getTax_epay_sum() {
		return tax_epay_sum;
	}
	public void setTax_epay_sum(BigDecimal tax_epay_sum) {
		this.tax_epay_sum = tax_epay_sum;
	}
	public BigDecimal getTax_cpay_nopay_sum() {
		return tax_cpay_nopay_sum;
	}
	public void setTax_cpay_nopay_sum(BigDecimal tax_cpay_nopay_sum) {
		this.tax_cpay_nopay_sum = tax_cpay_nopay_sum;
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
