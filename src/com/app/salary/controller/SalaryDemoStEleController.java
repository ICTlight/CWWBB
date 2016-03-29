package com.app.salary.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import com.app.salary.domain.SalaryDemo;
import com.app.salary.domain.SalaryDemoStEle;
import com.app.salary.domain.SalaryItem;
import com.app.salary.domain.SalaryLocalStand;
import com.app.salary.domain.SalaryStandEle;
import com.app.salary.service.ISalaryDemoService;
import com.app.salary.service.ISalaryDemoStEleService;
import com.app.salary.service.ISalaryItemService;
import com.app.salary.service.ISalaryLocalStandService;
import com.app.salary.service.ISalaryStandEleService;
import com.app.utils.Constants;

/**
 * 社保公积金项相关操作
 * 
 * liutuo
 * */
@Controller
public class SalaryDemoStEleController {

	@Autowired
	private ISalaryDemoStEleService demosteleservice;
	@Autowired
	private ISalaryDemoService demoservice;
	@Autowired
	private ISalaryStandEleService standservice;
	@Autowired
	private ISalaryItemService salitemservice;
	@Autowired
	private ISalaryLocalStandService localstandservice;
	
	/** 
	 *  获取工资项列表
	 * */
	@RequestMapping("/getSalDemosteleLists")
	public @ResponseBody List getSalDemosteleLists(@RequestParam("demoid_st") String demoid_st,HttpServletRequest request,Model model) throws Exception {
		Long demoid = Long.valueOf(demoid_st);
		List<SalaryDemoStEle> list = new ArrayList<SalaryDemoStEle>();
		try {	            
            list = demosteleservice.findSaldemosteleBydemoid(demoid);
		} catch (Exception e) {			
			System.out.println(e);
		}
		return list;
	}
	/**
	 * 增加工资项页面
	 */
	@RequestMapping("/addsalsteleInfo")
	public ModelAndView addsaleleInfo(@RequestParam("demoid_st") String demoid_st)  throws Exception{ 
		ModelMap modelMap = new ModelMap();
		SalaryDemoStEle demoele = new SalaryDemoStEle();		
		Long demoid = Long.valueOf(demoid_st);
		SalaryDemo demo = demoservice.findSaldemoBySaldemoid(demoid);
		String demoname = demo.getSaldemoname();
		demoele.setDemoid(demoid);
		demoele.setDemoname(demoname);
		modelMap.put("salaryDemoStEle", demoele);
		return new ModelAndView("salary/adddemostandele",modelMap);
	}
	
	/**
	 * 配置社保项比例页面
	 */
	@RequestMapping("/upcpvalueInfo")
	public ModelAndView upcpvalueInfo(String standidlist,String areacode)  throws Exception{ 
	//public ModelAndView upcpvalueInfo(@RequestParam("standlist") String standlist,@RequestParam("areacode") String areacode)  throws Exception{ 
		ModelMap modelMap = new ModelMap();
		modelMap.put("standidlist", standidlist);
		modelMap.put("areacode", areacode);
		return new ModelAndView("salary/updemostelecp",modelMap);
	}
	
	/** 
	 *  获取工资项列表
	 * */
	@RequestMapping("/getLocalStByareacode")
	public @ResponseBody List getLocalStByareacode(@RequestParam("areacode") String areacode,HttpServletRequest request,Model model) throws Exception {
		SalaryLocalStand localst = new SalaryLocalStand();;
		ArrayList list = new ArrayList();
		try {	            
			localst = localstandservice.findSalLocalStandByAreacode(areacode);	
		} catch (Exception e) {			
			System.out.println(e);
		}
		list.add(0,localst);
		return list;
	}
	
	
   /**
	* 保存模板项    之前的版本 修改日期：2015-12-8 11:07:35  刘佗
	*/
	@RequestMapping("/saveSalstEleDemo")
	public ModelAndView saveSalDemo(@RequestParam("standlist") String standlist,@RequestParam("demoname") String demoname ,
			@RequestParam("demoid_st") String demoid_st ,
			@RequestParam("standvaluelist") String standvaluelist,			
			@RequestParam("areacode") String areacode ,HttpServletRequest request) throws Exception {
		
		ModelMap modelMap = new ModelMap();
		SalaryDemoStEle salarydemostele= new SalaryDemoStEle();
		HttpSession session = request.getSession();
		Long coid = (Long)session.getAttribute(Constants.USERID);
		String coname = (String)session.getAttribute(Constants.USERNAME);
		Long demoid = Long.valueOf(demoid_st);
		salarydemostele.setCoid(coid);
		salarydemostele.setConame(coname);
		salarydemostele.setDemoid(demoid);
		salarydemostele.setDemoname(demoname);
		salarydemostele.setStatu("0");
		Date date = new Date();
		salarydemostele.setCreatetime(new java.sql.Date(date.getTime()));
		salarydemostele.setCreateby(coname);
		
		demosteleservice.deleteSaldemosteleBydemoid(demoid);
		
		System.out.println("得到的standlist为："+standlist);
		if(standlist!=null){
			String[] standlistArr = standlist.split(",");
			String[] valuelistArr = standvaluelist.split(",");
			int successcount = 0;
			int sum = standlistArr.length;
			for(int i=0;i<standlistArr.length;i++){
				String currentelename = standlistArr[i];
				String cpvalue = valuelistArr[i];
				System.out.println("最后，currentelename为：。。。。。"+currentelename+"....cpvalue:..."+cpvalue);
				SalaryStandEle salaryStandEle = standservice.findStandEleByElename(currentelename);
				Long eleid = demosteleservice.getsaldemosteleid();
				salarydemostele.setEleid(eleid);
				salarydemostele.setElename(currentelename);
				salarydemostele.setFixedcode(salaryStandEle.getFixedcode());
				salarydemostele.setCptype(salaryStandEle.getCptype());
				salarydemostele.setIsshow(salaryStandEle.getIsshow());
				salarydemostele.setPrecisions(salaryStandEle.getPrecisions());
				salarydemostele.setBasecode(salaryStandEle.getBasecode());
				salarydemostele.setAreacode(areacode);
				salarydemostele.setCpvalue(new BigDecimal(cpvalue));
				if(demosteleservice.saveSaldemostele(salarydemostele)){
					successcount++;				
				}	
			}
			if(successcount==sum){
				modelMap.put("message", "success");	
			}else{
				modelMap.put("message", "failure");
				demosteleservice.deleteSaldemosteleBydemoid(demoid);
			}
		}else{
			modelMap.put("message", "success");	
		}
		return new ModelAndView(new MappingJacksonJsonView(),modelMap);
	}
	
	/**
	* 删除对象 
	 */
	@RequestMapping("/delstele")
	public ModelAndView delstele(@RequestParam("thisid") Long thisid,HttpServletRequest request) throws Exception {
		
		ModelMap modelMap = new ModelMap();		
		SalaryDemoStEle stele = new SalaryDemoStEle();
		try {
			HttpSession session = request.getSession();
			String coname = (String)session.getAttribute(Constants.USERNAME);
			stele.setEleid(thisid);
			stele.setStatu("1");
			Date date = new Date();
			stele.setUpdateby(coname);
			stele.setUpdatetime(new java.sql.Date(date.getTime()));
			boolean yeah = demosteleservice.updateSaldemostelebyid(stele);
			
			
			if(yeah){
				SalaryItem salaryItem = new SalaryItem();
				salaryItem.setEleid(thisid);
				salaryItem.setStatu("1");
				salaryItem.setUpdateby(coname);
				salaryItem.setUpdatetime(new java.sql.Date(date.getTime()));
				boolean yeahpel = salitemservice.deleteDemopelbyeleid(salaryItem);
				if(yeahpel){
					modelMap.put("message", "success");
				}else{
					modelMap.put("message", "error");	
					System.out.println("员工薪资记录删除失败。。。。。");
				}}
			else{modelMap.put("message", "error");	System.out.println("社保公积金项记录删除失败。。。。。");}
		} catch (Exception e) {			
			System.out.println(e);
			modelMap.put("message", "error");	
		}
		return new ModelAndView(new MappingJacksonJsonView(),modelMap);
	}
	//获取计算值
	public String getCpvalue(String elename,String areacode){
		String cpvalue = "0";
		SalaryLocalStand salstand = localstandservice.findSalLocalStandByAreacode(areacode);
		if(elename.equals("住房个人")){
			cpvalue = salstand.getZhufg().toString();
		}else if(elename.equals("住房公司")){
			cpvalue = salstand.getZhufc().toString();
		}
		else if(elename.equals("养老公司")){
			cpvalue = salstand.getYanglc().toString();
		}
		else if(elename.equals("养老个人")){
			cpvalue = salstand.getYanglg().toString();
		}
		else if(elename.equals("医疗公司")){
			cpvalue = salstand.getYilc().toString();
		}
		else if(elename.equals("医疗个人")){
			cpvalue = salstand.getYilg().toString();
		}
		else if(elename.equals("失业公司")){
			cpvalue = salstand.getShiyc().toString();
		}
		else if(elename.equals("失业个人")){
			cpvalue = salstand.getShiyg().toString();
		}
		else if(elename.equals("生育公司")){
			cpvalue = salstand.getShengyc().toString();
		}
		else if(elename.equals("工伤公司")){
			cpvalue = salstand.getGongsc().toString();
		}
		return cpvalue;
	}
}
