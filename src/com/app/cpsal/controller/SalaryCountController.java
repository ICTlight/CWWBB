package com.app.cpsal.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.app.cpsal.domain.SalaryCount;
import com.app.cpsal.domain.SalaryPayItems;
import com.app.cpsal.service.ISalaryCountService;
import com.app.cpsal.service.ISalaryPayItemsService;
import com.app.salary.domain.SalaryDemoStEle;
import com.app.salary.domain.SalaryItem;
import com.app.salary.domain.SalaryLocalStand;
import com.app.salary.service.ISalaryDemoStEleService;
import com.app.salary.service.ISalaryItemService;
import com.app.salary.service.ISalaryLocalStandService;

/**
 * 薪资数据预处理
 * 员工、模板项信息添加或修改后会调用，预处理数据，以加快薪酬计算时的运算速度
 * 
 * liutuo  
 * 
 * */
@Controller
public class SalaryCountController {
	
	@Autowired
	private ISalaryItemService itemservice;
	@Autowired
	private ISalaryCountService countservice;
	@Autowired
	private ISalaryDemoStEleService stservice;
	@Autowired
	private ISalaryLocalStandService localservice;
	@Autowired
	private ISalaryPayItemsService payitemservice;
	
	/**
	 * 获取模板的地方标准信息
	 * 
	 * */
	public SalaryLocalStand getSBbseval(Long demoid){
		List<SalaryDemoStEle> stelelist = stservice.findSaldemosteleBydemoid(demoid);
		SalaryLocalStand localstand = new SalaryLocalStand();
		if(stelelist!=null && stelelist.size()>0){
			String areacode = stelelist.get(0).getAreacode();
			localstand = localservice.findSalLocalStandByAreacode(areacode);
		}
		return localstand;
	}
	
	
	public boolean countSal(Long demoid,Long peid,Long coid){
		boolean yeah = true;
		SalaryPayItems payitem = new SalaryPayItems();
	
		payitem.setCoid(coid);
		payitem.setDemoid(demoid);
		payitem.setStatu("0");
		Date date = new Date();
		payitem.setCreatetime(new java.sql.Date(date.getTime()));
		
		payitem.setPeid(Long.valueOf(peid));
		payitem.setIsstop("0");
		
		//将sa_items中的基本项保存到pp_period_items
		List<SalaryItem> baseitemlist = itemservice.findPeldelistByPeid(peid);
		if(baseitemlist!=null && baseitemlist.size()>0){	
			payitem.setCreateby(baseitemlist.get(0).getCreateby());
			payitem.setDemoname(baseitemlist.get(0).getDemoname());
			payitem.setIdnumber(baseitemlist.get(0).getIdnumber());
			payitem.setPename(baseitemlist.get(0).getPename());
			payitem.setConame(baseitemlist.get(0).getConame());
			payitem.setIsstand("1");
			//循环计算并保存每一条记录
			for(int i=0;i<baseitemlist.size();i++){
				payitem.setBasevalue(baseitemlist.get(i).getBasevalue());
				payitem.setEleid(baseitemlist.get(i).getEleid());
				payitem.setElename(baseitemlist.get(i).getElename());
				payitem.setSalitemid(payitemservice.getsalpayitemid());//
				payitem.setCptype(baseitemlist.get(i).getCptype());
				payitem.setIsshow("0");
				payitemservice.saveSalpayItem(payitem);
			}				
		}
		
		//先获取模板的社保项信息，上下限、平均工资
		List<SalaryDemoStEle> stelelist = stservice.findSaldemosteleBydemoid(demoid);
		SalaryLocalStand localstand = new SalaryLocalStand();
		if(stelelist!=null && stelelist.size()>0){
			//有社保公积金项
			String areacode = stelelist.get(0).getAreacode();
			localstand = localservice.findSalLocalStandByAreacode(areacode);
			
			BigDecimal uplimit = localstand.getUplimit();//19389
			BigDecimal lowlimit = localstand.getLowlimit();//2585
			List<SalaryItem> standitemlist = itemservice.findSalstlistByPeid(peid);
			String standval = standitemlist.get(0).getStandval();
			BigDecimal sbbase = new BigDecimal("0");
			payitem.setIsstand("0");
			payitem.setCptype("2");			
			payitem.setCreateby(stelelist.get(0).getCreateby());
			payitem.setDemoname(stelelist.get(0).getDemoname());
			
		   /*1.分实际收入为准跟非实际，实际得先算基数，非实际则直接取值
			*2.将计算结果保存到pp_period_items中
			*3.从pp_period_items中取数，计算
			*/
			
			if(standval.equals("0")){
				//sbbase等于实际的税前收入
				sbbase = getCpbase(demoid,peid);
				//循环计算并保存每一条记录
				for(int i=0;i<stelelist.size();i++){
					BigDecimal cpvalue = stelelist.get(i).getCpvalue();					
					BigDecimal value = new BigDecimal("0");
					if(stelelist.get(i).getFixedcode().equals("yilg")){
						value = getCpvalue(uplimit,lowlimit,sbbase).multiply(cpvalue).add(new BigDecimal("3"));
					}else{
						value = getCpvalue(uplimit,lowlimit,sbbase).multiply(cpvalue);
					}
					payitem.setBasevalue(value.toString());
					payitem.setEleid(stelelist.get(i).getEleid());
					payitem.setElename(stelelist.get(i).getElename());
					payitem.setSalitemid(payitemservice.getsalpayitemid());//
					payitem.setIsshow(stelelist.get(i).getIsshow());
					payitemservice.saveSalpayItem(payitem);
				}
			}else {
				//循环计算并保存每一条记录
				for(int i=0;i<stelelist.size();i++){
					String basecode = stelelist.get(i).getBasecode();
					BigDecimal cpvalue = stelelist.get(i).getCpvalue();
					BigDecimal bavalue = new BigDecimal("0") ;//= standitemlist.get(index)
					for(int j=0;j<standitemlist.size();j++){
						if(standitemlist.get(j).getFixedcode().equals(basecode)){
							bavalue = new BigDecimal(standitemlist.get(j).getBasevalue());
						}
					}
					BigDecimal value = new BigDecimal("0");
					if(stelelist.get(i).getFixedcode().equals("yilg")){
						value = getCpvalue(uplimit,lowlimit,bavalue).multiply(cpvalue).add(new BigDecimal("3"));
					}else{
						value = getCpvalue(uplimit,lowlimit,bavalue).multiply(cpvalue);
					}
					payitem.setIsshow(stelelist.get(i).getIsshow());
					payitem.setBasevalue(value.toString());
					payitem.setEleid(stelelist.get(i).getEleid());
					payitem.setElename(stelelist.get(i).getElename());
					payitem.setSalitemid(payitemservice.getsalpayitemid());//					
					payitemservice.saveSalpayItem(payitem);
				}
				
			}
		}
		countSalary(demoid,peid);				
		return yeah;
	}
	//计算薪酬
	public void countSalary(Long demoid,Long peid){
		SalaryPayItems item = new SalaryPayItems();
		SalaryCount salcount = new SalaryCount();
		List<SalaryPayItems> salitem;
		List<SalaryPayItems> cptyptitem;
		List<SalaryPayItems> countitem;
		Long countid;
		Date date = new Date();
		salcount.setCreatetime(new java.sql.Date(date.getTime()));
		salcount.setDemoid(demoid);
		salitem = payitemservice.findPeldelistByPeid(peid);
		if(salitem!=null){
			item.setDemoid(demoid);
			item.setPeid(peid);
			item.setStatu("0");
			cptyptitem = payitemservice.findCptypelist(demoid);//获取非公积金项计算方式
			if(cptyptitem!=null){
				for(int m=0;m<cptyptitem.size();m++){
					String type = cptyptitem.get(m).getCptype();
					if(type.equals("0")){
						item.setCptype("0");
						countitem = payitemservice.findSallistByType(item);//按计算方式获取非公积金项list
						double sum = 0;
						for(int j=0;j<countitem.size();j++){
							String value = countitem.get(j).getBasevalue();
							if(value!=null&&!value.equals("")&&value!=""){
								sum += Double.parseDouble(value);
							}								
						}
						BigDecimal bd=new BigDecimal(String.valueOf(sum));
						salcount.setTAX_NO(bd);
					}
					if(type.equals("1")){
						item.setCptype("1");
						countitem = payitemservice.findSallistByType(item);
						double sum = 0;
						for(int j=0;j<countitem.size();j++){
							String value = countitem.get(j).getBasevalue();
							if(value!=null&&!value.equals("")&&value!=""){
								sum += Double.parseDouble(value);
							}								
						}
						BigDecimal bd=new BigDecimal(String.valueOf(sum));
						salcount.setTAX_BEF_PLUS(bd);
					}
					if(type.equals("2")){
						item.setCptype("2");
						countitem = payitemservice.findSallistByType(item);
						double sum = 0;
						for(int j=0;j<countitem.size();j++){
							String value = countitem.get(j).getBasevalue();
							if(value!=null&&!value.equals("")&&value!=""){
								sum += Double.parseDouble(value);
							}								
						}
						BigDecimal bd=new BigDecimal(String.valueOf(sum));
						salcount.setTAX_BEF_MINUS(bd);
					}
					if(type.equals("3")){
						item.setCptype("3");
						countitem = payitemservice.findSallistByType(item);
						double sum = 0;
						for(int j=0;j<countitem.size();j++){
							String value = countitem.get(j).getBasevalue();
							if(value!=null&&!value.equals("")&&value!=""){
								sum += Double.parseDouble(value);
							}						
						}
						BigDecimal bd=new BigDecimal(String.valueOf(sum));
						salcount.setTAX_AFT_PLUS(bd);
					}
					if(type.equals("4")){
						item.setCptype("4");
						countitem = payitemservice.findSallistByType(item);
						double sum = 0;
						for(int j=0;j<countitem.size();j++){
							String value = countitem.get(j).getBasevalue();
							if(value!=null&&!value.equals("")&&value!=""){
								sum += Double.parseDouble(value);
							}						
						}
						BigDecimal bd=new BigDecimal(String.valueOf(sum));
						salcount.setTAX_AFT_MINUS(bd);
					}
					if(type.equals("5")){
						item.setCptype("5");
						countitem = payitemservice.findSallistByType(item);
						double sum = 0;
						for(int j=0;j<countitem.size();j++){
							String value = countitem.get(j).getBasevalue();
							if(value!=null&&!value.equals("")&&value!=""){
								sum += Double.parseDouble(value);
							}						
						}
						BigDecimal bd=new BigDecimal(String.valueOf(sum));
						salcount.setTAX_INCOME_PLUS(bd);
					}
					if(type.equals("6")){
						item.setCptype("6");
						countitem = payitemservice.findSallistByType(item);
						double sum = 0;
						for(int j=0;j<countitem.size();j++){
							String value = countitem.get(j).getBasevalue();
							if(value!=null&&!value.equals("")&&value!=""){
								sum += Double.parseDouble(value);
							}						
						}
						BigDecimal bd=new BigDecimal(String.valueOf(sum));
						salcount.setTAX_INCOME_MINUS(bd);
					}
					if(type.equals("7")){
						item.setCptype("7");
						countitem = payitemservice.findSallistByType(item);
						double sum = 0;
						for(int j=0;j<countitem.size();j++){
							String value = countitem.get(j).getBasevalue();
							if(value!=null&&!value.equals("")&&value!=""){
								sum += Double.parseDouble(value);
							}						
						}
						BigDecimal bd=new BigDecimal(String.valueOf(sum));
						salcount.setTAX_PLUS(bd);
					}
					if(type.equals("8")){
						item.setCptype("8");
						countitem = payitemservice.findSallistByType(item);
						double sum = 0;
						for(int j=0;j<countitem.size();j++){
							String value = countitem.get(j).getBasevalue();
							if(value!=null&&!value.equals("")&&value!=""){
								sum += Double.parseDouble(value);
							}						
						}
						BigDecimal bd=new BigDecimal(String.valueOf(sum));
						salcount.setTAX_MINUS(bd);
					}
					if(type.equals("9")){
						item.setCptype("9");
						countitem = payitemservice.findSallistByType(item);
						double sum = 0;
						for(int j=0;j<countitem.size();j++){
							String value = countitem.get(j).getBasevalue();
							if(value!=null&&!value.equals("")&&value!=""){
								sum += Double.parseDouble(value);
							}						
						}
						BigDecimal bd=new BigDecimal(String.valueOf(sum));
						salcount.setAFT_TAX_ENVP(bd);
					}
					if(type.equals("10")){
						item.setCptype("10");
						countitem = payitemservice.findSallistByType(item);
						double sum = 0;
						for(int j=0;j<countitem.size();j++){
							String value = countitem.get(j).getBasevalue();
							if(value!=null&&!value.equals("")&&value!=""){
								sum += Double.parseDouble(value);
							}						
						}
						BigDecimal bd=new BigDecimal(String.valueOf(sum));
						salcount.setAFT_TAX_ENVN(bd);
					}
					
				}
				
				countid = countservice.getsalcountid();
				salcount.setTAX_BASE(new BigDecimal(String.valueOf(3500)));
				salcount.setCountid(countid);
				salcount.setPeid(peid);
				salcount.setCoid(salitem.get(0).getCoid());
				salcount.setIdnumber(salitem.get(0).getIdnumber());
				salcount.setStatu("0");		
				countservice.saveSalCount(salcount);
			}
		}
	}
	
	//卡上下限
	public BigDecimal getCpvalue(BigDecimal up,BigDecimal low,BigDecimal value ){
		if(up.compareTo(value)<0){
			return up;
		}else if(low.compareTo(value)>=0){
			return low;
		}else{
			return value;
		}
	}
	
	//获取计算基数
	public BigDecimal getCpbase(Long demoid,Long peid){
		SalaryItem item = new SalaryItem();
		List<SalaryItem> salitem;
		List<SalaryItem> cptyptitem;
		List<SalaryItem> countitem;
		BigDecimal plus = new BigDecimal("0");
		BigDecimal minus = new BigDecimal("0");
		item.setDemoid(demoid);
		item.setPeid(peid);
		salitem = itemservice.findPeldelistByPeid(peid);
		if(salitem!=null){
			cptyptitem = itemservice.findCptypelist(demoid);//获取非公积金项计算方式
			if(cptyptitem!=null){
				for(int m=0;m<cptyptitem.size();m++){
					String type = cptyptitem.get(m).getCptype();					
					if(type.equals("1")){
						item.setCptype("1");
						countitem = itemservice.findSallistByType(item);
						double sum = 0;
						for(int j=0;j<countitem.size();j++){
							String value = countitem.get(j).getBasevalue();
							if(value!=null&&!value.equals("")&&value!=""){
								sum += Double.parseDouble(value);
							}								
						}
						plus=new BigDecimal(String.valueOf(sum));
					}
					if(type.equals("2")){
						item.setCptype("2");
						countitem = itemservice.findSallistByType(item);
						double sum = 0;
						for(int j=0;j<countitem.size();j++){
							String value = countitem.get(j).getBasevalue();
							if(value!=null&&!value.equals("")&&value!=""){
								sum += Double.parseDouble(value);
							}								
						}
						minus=new BigDecimal(String.valueOf(sum));
					}										
				}	
			}
		}
		return plus.subtract(minus);
	}
}
