package com.app.controller.salary;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.app.domain.salary.SalaryDemo;
import com.app.domain.salary.SalaryDemoEle;
import com.app.domain.salary.SalaryDemoStEle;
import com.app.domain.salary.SalaryItem;
import com.app.domain.salary.SalaryStandEle;
import com.app.service.salary.ISalaryDemoEleService;
import com.app.service.salary.ISalaryDemoService;
import com.app.service.salary.ISalaryDemoStEleService;
import com.app.service.salary.ISalaryItemService;
import com.app.utils.Constants;

@Controller
public class SalaryItemController {

	@Autowired
	private ISalaryDemoService saldemoservice;
	@Autowired
	private ISalaryItemService salItemService;
	@Autowired
	private ISalaryDemoEleService saldemoeleservice;
	@Autowired
	private ISalaryDemoStEleService saldemosteleservice;
	
	
	/*
	 * 
	 *  获取员工列表
	 * */
	@RequestMapping("/getSalPelLists")
	public @ResponseBody List getSalPelLists(@RequestParam("demoid_st") String demoid_st,HttpServletRequest request,Model model) throws Exception {
		Long demoid = Long.valueOf(demoid_st);
		List<SalaryItem> list = new ArrayList<SalaryItem>();
		try {	            
            list = salItemService.findPellistByDemoid(demoid);
		} catch (Exception e) {			
			System.out.println(e);
		}
		return list;
	}
	/*
	 * 
	 *  获取员工薪酬信息列表
	 * */
	@RequestMapping("/getSpelLists")
	public @ResponseBody List getSpelLists(@RequestParam("peid_st") Long peid,HttpServletRequest request,Model model) throws Exception {
		List<SalaryItem> peldelist = new ArrayList<SalaryItem>();
		try {	            
            peldelist = salItemService.findPeldelistByPeid(peid);
		} catch (Exception e) {			
			System.out.println(e);
		}
		ArrayList list = new ArrayList();
		list.add(0, peldelist);
		list.add(1,peldelist.size());		
		return list;
	}
	/*
	 * 
	 *  获取工资项列表
	 * */
	@RequestMapping("/getSeleLists")
	public @ResponseBody List getSeleLists(@RequestParam("demoid_st") String demoid_st,HttpServletRequest request,Model model) throws Exception {
		Long demoid = Long.valueOf(demoid_st);
		ArrayList list = new ArrayList();
		int elesum = 0;
		List<SalaryDemoEle> demoelelist = new ArrayList<SalaryDemoEle>();
		List<SalaryDemoStEle> demostelelist = new ArrayList<SalaryDemoStEle>();
		try {	            
			demoelelist = saldemoeleservice.findSaldemoeleBydemoid(demoid);		
		} catch (Exception e) {			
			System.out.println(e);
		}
		try {	            
			demostelelist = saldemosteleservice.findSaldemosteleBydemoid(demoid);
		} catch (Exception e) {			
			System.out.println(e);
		}
		elesum = demostelelist.size()+demoelelist.size();
		list.add(0,demoelelist);
		list.add(1, demostelelist);
		list.add(2, elesum);
		return list;
	}
	
	/*
	 * 
	 *  获取工资项列表
	 * */
	@RequestMapping("/getSsteleLists")
	public @ResponseBody List getSsteleLists(@RequestParam("demoid_st") String demoid_st,HttpServletRequest request,Model model) throws Exception {
		Long demoid = Long.valueOf(demoid_st);
		List<SalaryDemoStEle> demostelelist = new ArrayList<SalaryDemoStEle>();
		try {	            	
			demostelelist = saldemosteleservice.findSaldemosteleBydemoid(demoid);
		} catch (Exception e) {			
			System.out.println(e);
		}
		return demostelelist;
	}
	/**
	 * 增加员工页面
	 */
	@RequestMapping("/addsalpelInfo")
	public ModelAndView addsalpelInfo(@RequestParam("demoid_st") String demoid_st)  throws Exception{ 
		ModelMap modelMap = new ModelMap();
		Long demoid = Long.valueOf(demoid_st);
		SalaryDemo demo = saldemoservice.findSaldemoBySaldemoid(demoid);
		String demoname = demo.getSaldemoname();
		modelMap.put("demoname", demoname);
		modelMap.put("demoid", demoid);
		return new ModelAndView("salary/addsalpelDemo",modelMap);			
	}
	
	
	/**
	 * 更新员工页面
	 */
	@RequestMapping("/updatesalpelInfo")
	public ModelAndView updatesalpelInfo(@RequestParam("peid") Long peid)  throws Exception {
		ModelMap modelMap = new ModelMap();
		modelMap.put("peid", peid);
		String pename = salItemService.findPenameByPeid(peid);
		modelMap.put("pename", pename);
		return new ModelAndView("salary/updatesalpelDemo",modelMap);
	}
	
	/**
	* 保存员工工资信息
	 */
	@RequestMapping("/saveDemopel")
	public ModelAndView saveDemopel(@RequestParam("demoid_st") String demoid_st ,
			@RequestParam("demoname") String demoname ,HttpServletRequest req) throws Exception {
		ModelMap modelMap = new ModelMap();
		SalaryItem salaryItem= new SalaryItem();
		HttpSession session = req.getSession();
		Long coid = (Long)session.getAttribute(Constants.USERID);
		String coname = (String)session.getAttribute(Constants.USERNAME);
		Long demoid = Long.valueOf(demoid_st);
		salaryItem.setCoid(coid);
		salaryItem.setConame(coname);
		salaryItem.setDemoid(demoid);
		salaryItem.setDemoname(demoname);
		Date date = new Date();
		salaryItem.setCreatetime(new java.sql.Date(date.getTime()));
		salaryItem.setCreateby(coname);
		String peid = req.getParameter("peid");
		salaryItem.setPeid(Long.valueOf(peid));
		salaryItem.setPename(req.getParameter("pename"));
		salaryItem.setIsstop("0");
		Long salitemid;
		Long eleid;
		String elename;
		String basevalue;
		String fixedcode;
		
		
		List<SalaryDemoEle> demoelelist = getEleListByDemoid(demoid);
		int count = 0;
		if(demoelelist!=null || demoelelist.size()!=0){
			for(int i=0;i<demoelelist.size();i++){
				 salitemid = salItemService.getsalitemid();
				 eleid = demoelelist.get(i).getEleid();
				 basevalue = req.getParameter(demoelelist.get(i).getEleid().toString());
				 elename = demoelelist.get(i).getElename();
				 fixedcode = demoelelist.get(i).getFixedcode();
				 salaryItem.setSalitemid(salitemid);
				 salaryItem.setEleid(eleid);
				 salaryItem.setElename(elename);
				 salaryItem.setBasevalue(basevalue);
				 salaryItem.setFixedcode(fixedcode);
				 if(salItemService.saveSalItem(salaryItem)){
					 count++;
				 }
			}
		}
		List<SalaryDemoStEle> demostelelist = getStEleListByDemoid(demoid);
		if(demostelelist!=null || demostelelist.size()!=0){
			for(int i=0;i<demostelelist.size();i++){
				 salitemid = salItemService.getsalitemid();
				 eleid = demoelelist.get(i).getEleid();
				 basevalue = req.getParameter(demoelelist.get(i).getEleid().toString());
				 elename = demoelelist.get(i).getElename();
				 fixedcode = demoelelist.get(i).getFixedcode();
				 salaryItem.setSalitemid(salitemid);
				 salaryItem.setEleid(eleid);
				 salaryItem.setElename(elename);
				 salaryItem.setBasevalue(basevalue);
				 salaryItem.setFixedcode(fixedcode);
				 if(salItemService.saveSalItem(salaryItem)){
					 count++;
				 }
			}
		}
		if(count==demostelelist.size()+demoelelist.size()){
			modelMap.put("message", "success");	
		}else{
			modelMap.put("message", "failure");
		}
		return new ModelAndView(new MappingJacksonJsonView(),modelMap);
	}
	
	/**
	* 修改员工工资信息
	 */
	@RequestMapping("/updateDemopel")
	public ModelAndView updateDemopel(@RequestParam("demoid_st") String demoid_st ,
			@RequestParam("demoname") String demoname ,HttpServletRequest req) throws Exception {
		ModelMap modelMap = new ModelMap();
		SalaryItem salaryItem= new SalaryItem();
		HttpSession session = req.getSession();
		Long coid = (Long)session.getAttribute(Constants.USERID);
		String coname = (String)session.getAttribute(Constants.USERNAME);
		Long demoid = Long.valueOf(demoid_st);
		salaryItem.setCoid(coid);
		salaryItem.setConame(coname);
		salaryItem.setDemoid(demoid);
		salaryItem.setDemoname(demoname);
		Date date = new Date();
		salaryItem.setCreatetime(new java.sql.Date(date.getTime()));
		salaryItem.setCreateby(coname);
		String peid = req.getParameter("peid");
		salaryItem.setPeid(Long.valueOf(peid));
		salaryItem.setPename(req.getParameter("pename"));
		salaryItem.setIsstop("0");
		Long salitemid;
		Long eleid;
		String elename;
		String basevalue;
		String fixedcode;
		
		
		List<SalaryDemoEle> demoelelist = getEleListByDemoid(demoid);
		int count = 0;
		if(demoelelist!=null || demoelelist.size()!=0){
			for(int i=0;i<demoelelist.size();i++){
				 salitemid = salItemService.getsalitemid();
				 eleid = demoelelist.get(i).getEleid();
				 basevalue = req.getParameter(demoelelist.get(i).getEleid().toString());
				 elename = demoelelist.get(i).getElename();
				 fixedcode = demoelelist.get(i).getFixedcode();
				 salaryItem.setSalitemid(salitemid);
				 salaryItem.setEleid(eleid);
				 salaryItem.setElename(elename);
				 salaryItem.setBasevalue(basevalue);
				 salaryItem.setFixedcode(fixedcode);
				 if(salItemService.saveSalItem(salaryItem)){
					 count++;
				 }
			}
		}
		List<SalaryDemoStEle> demostelelist = getStEleListByDemoid(demoid);
		if(demostelelist!=null || demostelelist.size()!=0){
			for(int i=0;i<demostelelist.size();i++){
				 salitemid = salItemService.getsalitemid();
				 eleid = demoelelist.get(i).getEleid();
				 basevalue = req.getParameter(demoelelist.get(i).getEleid().toString());
				 elename = demoelelist.get(i).getElename();
				 fixedcode = demoelelist.get(i).getFixedcode();
				 salaryItem.setSalitemid(salitemid);
				 salaryItem.setEleid(eleid);
				 salaryItem.setElename(elename);
				 salaryItem.setBasevalue(basevalue);
				 salaryItem.setFixedcode(fixedcode);
				 if(salItemService.saveSalItem(salaryItem)){
					 count++;
				 }
			}
		}
		if(count==demostelelist.size()+demoelelist.size()){
			modelMap.put("message", "success");	
		}else{
			modelMap.put("message", "failure");
		}
		return new ModelAndView(new MappingJacksonJsonView(),modelMap);
	}
	public List<SalaryDemoEle> getEleListByDemoid(Long demoid){
		List<SalaryDemoEle> demoelelist = new ArrayList<SalaryDemoEle>();
		try {	            
			demoelelist = saldemoeleservice.findSaldemoeleBydemoid(demoid);		
		} catch (Exception e) {			
			System.out.println(e);
		}
		return demoelelist;
	}
	public List<SalaryDemoStEle> getStEleListByDemoid(Long demoid){
		List<SalaryDemoStEle> demostelelist = new ArrayList<SalaryDemoStEle>();
		try {	            
			demostelelist = saldemosteleservice.findSaldemosteleBydemoid(demoid);
		} catch (Exception e) {			
			System.out.println(e);
		}
		return demostelelist;
	}
}
