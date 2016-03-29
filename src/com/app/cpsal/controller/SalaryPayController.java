package com.app.cpsal.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.app.cpsal.domain.SalaryCount;
import com.app.cpsal.domain.SalaryPay;
import com.app.cpsal.domain.SalaryPayItems;
import com.app.cpsal.service.ISalaryCountService;
import com.app.cpsal.service.ISalaryPayItemsService;
import com.app.cpsal.service.ISalaryPayService;
import com.app.salary.domain.SalaryItem;
import com.app.salary.service.ISalaryItemService;
import com.app.utils.Constants;

/**
 * 计算薪酬
 *  
 *  直接调用之前的预处理结果完成薪资计算及展示
 *  
 *  liutuo
 * */
@Controller
public class SalaryPayController {

	@Autowired
	private ISalaryPayItemsService itemservice;
	@Autowired
	private ISalaryCountService countservice;
	@Autowired
	private ISalaryPayService payservice;
	@Autowired
	private SalaryCountController salCountController;
	@Autowired
	private ISalaryItemService salitemservice;
	/*
	 * 
	 *  获取结果列表
	 * */
	@RequestMapping("/getSalPayLists")
	public @ResponseBody List getSalPayLists(@RequestParam("demoid_st") String demoid_st,HttpServletRequest request,Model model) throws Exception {
		Long demoid = Long.valueOf(demoid_st);
		
		HttpSession session = request.getSession();
		Long coid = (Long)session.getAttribute(Constants.USERID);
		List<SalaryItem> item = salitemservice.findPellistByDemoid(demoid);
		if(item!=null && item.size()>0){
			for(int j=0;j<item.size();j++){
				Long peid = item.get(j).getPeid();
			salCountController.countSal(demoid,peid,coid);
			}
		}
		
		ArrayList list = new ArrayList();
		int elesum = 0;
		List<SalaryPay> paylist = new ArrayList<SalaryPay>();
		List<SalaryPayItems> itemlist = new ArrayList<SalaryPayItems>();
		try {
			boolean yeah = toCompute(demoid);
			
			if(yeah){
				paylist = payservice.findSalPayByDemoid(demoid);
				itemlist = itemservice.findSalItemByDemoid(demoid);
			}
		} catch (Exception e) {			
			System.out.println(e);
		}
		elesum = paylist.size();
		list.add(0,paylist);
		list.add(1, elesum);
		list.add(2,itemlist);
		return list;
	}
	
	//获取计算显示项目
	@RequestMapping("/getPayLists")
	public @ResponseBody List getPayLists(@RequestParam("demoid_st") String demoid_st,HttpServletRequest req,HttpServletRequest request,Model model) throws Exception {
		
		ArrayList list = new ArrayList();
		List<Map<String, Object>> dataList = null;
		String colModel = null;
		StringBuffer fieldStr = new StringBuffer("peid,pename");
		StringBuffer strModel = new StringBuffer("");
		StringBuffer groupby = new StringBuffer("");

		strModel.append("{\"员工ID\",\"peid\"}");
		strModel.append(";{\"姓名\",\"pename\"}");
		Long demoid = Long.valueOf(demoid_st);
		List<SalaryPayItems> itemlist = itemservice.findSalItemByDemoid(demoid);
		List<SalaryPay> paylist = payservice.findSalPayByDemoid(demoid);
		StringBuffer sqlBuf = new StringBuffer("");
		if(itemlist.size()>0){
			SalaryPayItems salitem = null;
			for(int i=0;i<itemlist.size();i++){
				salitem = itemlist.get(i);
				
				fieldStr.append(",ITEM" + i);
				strModel.append(";{\"" + salitem.getElename() + "\",\"ITEM" + i +"\"}");
				sqlBuf.append(",SUM(IF(elename='"+salitem.getElename()+"', basevalue, 0)) AS item"+i);
			}
			fieldStr.append(",tax_bef_plus_tol,tax_bef_plusmin_tol,tax_bef_tol,tax_tol,tax_value,tax_rate,tax_deduction,tax_aft_salary,salary_pay");
			sqlBuf.append(",tax_bef_plus_tol,tax_bef_plusmin_tol,tax_bef_tol,tax_tol,tax_value,tax_rate,tax_deduction,tax_aft_salary,salary_pay");
			groupby.append(",tax_bef_plus_tol,tax_bef_plusmin_tol,tax_bef_tol,tax_tol,tax_value,tax_rate,tax_deduction,tax_aft_salary,salary_pay");		
			strModel.append(";{\"收入合计\",\"tax_bef_plus_tol\"}");
			strModel.append(";{\"税前收入合计\",\"tax_bef_plusmin_tol\"}");
			
			strModel.append(";{\"应税收入合计\",\"tax_bef_tol\"}");
			strModel.append(";{\"应纳税所得额合计\",\"tax_tol\"}");
			strModel.append(";{\"税\",\"tax_value\"}");
			strModel.append(";{\"工资税率\",\"tax_rate\"}");
			strModel.append(";{\"工资速算扣除数\",\"tax_deduction\"}");
			strModel.append(";{\"税后工资\",\"tax_aft_salary\"}");
			strModel.append(";{\"工资实发\",\"salary_pay\"}");
		
			colModel = strModel.toString();
			
			dataList = payservice.findSalComputeInfo(sqlBuf.toString(),groupby.toString(), demoid);
			
			System.out.println("huaha:最后返回的查询结果：-----------: "+ dataList.toString());
			
		}
		list.add(0,dataList);
		list.add(1, colModel.toString().split(";"));
		list.add(2,fieldStr.toString().split(","));
		return list;
	}
	
	
	//薪酬计算
	public boolean toCompute(Long demoid){
		
		//============之前的计算================
		SalaryPay touppay = new SalaryPay();
		touppay.setDemoid(demoid);
		Date date = new Date();
		touppay.setUpdatetime(new java.sql.Date(date.getTime()));
		touppay.setStatu("1");
		if(payservice.updateSPstatubydemoid(touppay));
		{
			List<SalaryPayItems> peitem = itemservice.findPellistByDemoid(demoid);
			List taxlist = new ArrayList();
			SalaryCount salCount;
			SalaryPay salPay = new SalaryPay();
			Long payid;
			
			salPay.setCreatetime(new java.sql.Date(date.getTime()));
			salPay.setDemoid(demoid);
			int pesum;
			int count = 0;
			if(peitem!=null){
				pesum = peitem.size();
				for(int i=0;i<pesum;i++){
					Long peid = peitem.get(i).getPeid();
					salPay.setPeid(peid);
					salPay.setIdnumber(peitem.get(i).getIdnumber());
					salCount = countservice.findSalCountByPeid(peid);
					if(salCount!=null){
						
						//===================================================税前相关计算============================================
						
						//TAX_BEF_PLUS_TOL     收入合计 = 税前+项和
						salPay.setTax_bef_plus_tol(salCount.getTAX_BEF_PLUS());
						
						//TAX_BEF_PLUSMIN_TOL 税前收入合计： 税前加项和-税前减项目和
						BigDecimal bp = salCount.getTAX_BEF_PLUS();
						BigDecimal bm = salCount.getTAX_BEF_MINUS();
						BigDecimal bpm;
						if(bm!=null){
							salPay.setTax_bef_plusmin_tol(bp.subtract(bm));
							bpm = bp.subtract(bm);
						}else{
							salPay.setTax_bef_plusmin_tol(bp);
							bpm = bp;
						}
						
						//TAX_BEF_TOL    应税收入合计： 应税收入合计+应纳税调整加项-应纳税调整减项
						BigDecimal bip = salCount.getTAX_INCOME_PLUS();//应纳税调整加项
						BigDecimal bim = salCount.getTAX_INCOME_MINUS();//应纳税调整减项
						BigDecimal tax_bef_tol;
						if(bip!=null&&bim!=null){
							tax_bef_tol = bpm.add(bip).subtract(bim);
						}else if(bip==null&&bim!=null){
							tax_bef_tol = bpm.subtract(bim);
						}
						else if(bip==null&&bim!=null){
							tax_bef_tol = bpm.add(bip);
						}else{
							tax_bef_tol = bpm;
						}
						
						salPay.setTax_bef_tol(tax_bef_tol);
						//======================================================================================================
						
						
						//=========================================个人缴税相关计算===================================================
						BigDecimal tax_base = salCount.getTAX_BASE();
						BigDecimal tax_value = new BigDecimal("0");
						BigDecimal rate = new BigDecimal("0");
						BigDecimal ndeduction = new BigDecimal("0");
						BigDecimal  tax_cpay_sum = new BigDecimal("0");				
						//判断是否大于3500
						if(tax_bef_tol.compareTo(tax_base)>=0){
							
							//TAX_TOL 应纳税所得额合计 ：应税收入合计-3500
							salPay.setTax_tol(tax_bef_tol.subtract(tax_base));
							taxlist = getTaxValue(salPay.getTax_tol());
							tax_value = (BigDecimal)taxlist.get(0);
							rate = (BigDecimal)taxlist.get(1);
							ndeduction = (BigDecimal)taxlist.get(2);
							salPay.setTax_value(tax_value);
							salPay.setTax_rate(rate);
							salPay.setTax_deduction(ndeduction);
							//税后工资 = 应税收入合计-税
							BigDecimal tax_aft_salary = tax_bef_tol.subtract(tax_value);
							salPay.setTax_aft_salary(tax_aft_salary);	
							tax_cpay_sum = salPay.getTax_tol().multiply(rate).subtract(ndeduction).subtract(tax_value);
						}else{
							//税后工资 = 应税收入合计
							salPay.setTax_aft_salary(tax_bef_tol);
							salPay.setTax_rate(rate);
							salPay.setTax_deduction(ndeduction);
						}
						
						//合计个人赋税
						salPay.setTax_epay_sum(tax_value);
						salPay.setTax_cpay_sum(tax_cpay_sum);
						
						//====================================================================================================
						
						//==================================================税后调整合计===========================================
						BigDecimal tax_aft_plus = salCount.getTAX_AFT_PLUS();
						BigDecimal tax_aft_minus = salCount.getTAX_AFT_MINUS();
						//税后调整合计
						BigDecimal tax_aft_sum = new BigDecimal("0");
						if(tax_aft_plus!=null&&tax_aft_minus!=null){
							tax_aft_sum = tax_aft_plus.subtract(tax_aft_minus);
						}else if(tax_aft_minus==null&&tax_aft_plus!=null){
							tax_aft_sum = tax_aft_plus;
						}
						else if(bip==tax_aft_plus&&tax_aft_minus!=null){
							tax_aft_sum = tax_aft_sum.subtract(tax_aft_minus);;
						}else{}
						salPay.setTax_aft_sum(tax_aft_sum);
						//======================================================================================================
						
						
						//========================================(税后推税前)税后发合计/(税后推税前)税后不发合计==============================
						BigDecimal aft_tax_pay_sum = new BigDecimal("0");
						BigDecimal aft_tax_nopay_sum = new BigDecimal("0");					
						//(税后推税前)税后发合计
						salPay.setAft_tax_pay_sum(aft_tax_pay_sum);
						//(税后推税前)税后不发合计
						salPay.setAft_tax_nopay_sum(aft_tax_nopay_sum);
						//======================================================================================================
						
						//================================================公司赋税=================================================
						
						//bpm:税前收入合计
						BigDecimal salary_pay = new BigDecimal("0");
					    BigDecimal tax_cpay_nopay_sum = new BigDecimal("0");
					    BigDecimal aft_tax_tol_sum = new BigDecimal("0");
					    salPay.setTax_cpay_nopay_sum(tax_cpay_nopay_sum);
					    salPay.setAft_tax_tol_sum(aft_tax_tol_sum);
						salary_pay = bpm.subtract(tax_value).add(tax_cpay_nopay_sum).add(tax_cpay_sum).add(aft_tax_pay_sum).add(tax_aft_sum);
						
						
						salPay.setSalary_pay(salary_pay);
						payid = payservice.getsalpayid();
						salPay.setPayid(payid);
						salPay.setStatu("0");
						boolean yeah = payservice.saveSalPay(salPay);
						if(yeah){
							System.out.println("compute success...........................");
							count++;
						}else{
							System.out.println("compute fail...........................");
						}
					}
				}
				if(count==pesum){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}
	
	//获取税率，可直接取数据库表
	public List getTaxValue(BigDecimal tax_tol){
		ArrayList taxlist = new ArrayList();
		double tax_tol_d = tax_tol.doubleValue();
		BigDecimal tax_value = new BigDecimal("0");
		BigDecimal rate = new BigDecimal("0");
		BigDecimal ndeduction = new BigDecimal("0");
		if(tax_tol_d<=0){
			taxlist.add(0,tax_value);
			taxlist.add(1, rate);
			taxlist.add(2, ndeduction);
			return taxlist;
		}else if(tax_tol_d>0&&tax_tol_d<1500){
			rate = new BigDecimal("0.03");
			ndeduction = new BigDecimal("0");
		}else if(tax_tol_d>=1500&&tax_tol_d<4500){
			rate = new BigDecimal("0.10");
			ndeduction = new BigDecimal("105");
		}
		else if(tax_tol_d>=4500&&tax_tol_d<9000){
			rate = new BigDecimal("0.20");
			ndeduction = new BigDecimal("555");
		}
		else if(tax_tol_d>=9000&&tax_tol_d<35000){
			rate = new BigDecimal("0.25");
			ndeduction = new BigDecimal("1005");
		}
		else if(tax_tol_d>=35000&&tax_tol_d<55000){
			rate = new BigDecimal("0.30");
			ndeduction = new BigDecimal("2755");
		}
		else if(tax_tol_d>=55000&&tax_tol_d<80000){
			rate = new BigDecimal("0.35");
			ndeduction = new BigDecimal("5505");
		}
		else{
			rate = new BigDecimal("0.45");
			ndeduction = new BigDecimal("13505");
		}
		tax_value = tax_tol.multiply(rate).subtract(ndeduction);
		taxlist.add(0,tax_value);
		taxlist.add(1, rate);
		taxlist.add(2, ndeduction);
		return taxlist;
	}
}
