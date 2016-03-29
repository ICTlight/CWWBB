package com.app.salary.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.app.salary.domain.SalaryDemo;
import com.app.salary.domain.SalaryDemoEle;
import com.app.salary.domain.SalaryDemoStEle;
import com.app.salary.domain.SalaryItem;
import com.app.salary.service.ISalaryDemoEleService;
import com.app.salary.service.ISalaryDemoService;
import com.app.salary.service.ISalaryDemoStEleService;
import com.app.salary.service.ISalaryItemService;
import com.app.utils.Constants;

@Controller
public class SalaryDemoController {

	@Autowired
	private ISalaryDemoService saldemoService;
	@Autowired
	private ISalaryItemService salItemService;
	@Autowired
	private ISalaryDemoEleService saldemoeleservice;
	@Autowired
	private ISalaryDemoStEleService saldemosteleservice;
	/*
	 * 
	 *  获取工资模板列表
	 * */
	@RequestMapping("/getSalDemoLists")
	public @ResponseBody List getSalDemoLists(HttpServletRequest request,Model model) throws Exception {
		HttpSession session = request.getSession();
		Long coid = (Long)session.getAttribute(Constants.USERID);		
		List<SalaryDemo> list = new ArrayList<SalaryDemo>();
		try {	            
            list = saldemoService.findSaldemoByCoid(coid);
		} catch (Exception e) {			
			System.out.println(e);
		}
			return list;
	}
	
	/**
	 * 增加工资模板页面
	 * 2015-10-29 13:53:28
	 */
	@RequestMapping("/addsaldemoInfo")
	public ModelAndView addsaldemoInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		SalaryDemo salaryDemo = new SalaryDemo();
		map.put("salaryDemo", salaryDemo);
		
		return new ModelAndView("salary/addsaldemoModel",map);
	}
	
	/**
	 * 
	* @Description: 保存物料需求 
	* @return ModelAndView      
	 */
	@RequestMapping("/saveSalDemo")
	public ModelAndView saveSalDemo(SalaryDemo salaryDemo,HttpServletRequest request) throws Exception { 
		ModelMap modelMap = new ModelMap();
		HttpSession session = request.getSession();
		Long coid = (Long)session.getAttribute(Constants.USERID);
		String coname = (String)session.getAttribute(Constants.USERNAME);
		Long saldemoid = saldemoService.getsaldemoid();
		salaryDemo.setSaldemoid(saldemoid);
		salaryDemo.setCoid(coid);
		salaryDemo.setConame(coname);
		salaryDemo.setStatu("0");
		Date date = new Date();
		salaryDemo.setCreatetime(new java.sql.Date(date.getTime()));
		salaryDemo.setCreateby(coname);
		if(saldemoService.saveSaldemo(salaryDemo)){
			modelMap.put("message", "success");					
		}else{
			modelMap.put("message", "failure");
		}	
		return new ModelAndView(new MappingJacksonJsonView(),modelMap);
	}
	/**
	* 删除对象 
	 */
	@RequestMapping("/deldemo")
	public ModelAndView deldemo(@RequestParam("thisid") Long thisid,HttpServletRequest request) throws Exception {
		
		ModelMap modelMap = new ModelMap();		
		SalaryDemo salaryDemo = new SalaryDemo();
		try {
			HttpSession session = request.getSession();
			String coname = (String)session.getAttribute(Constants.USERNAME);
			salaryDemo.setSaldemoid(thisid);
			salaryDemo.setStatu("1");
			Date date = new Date();
			salaryDemo.setUpdateby(coname);
			salaryDemo.setUpdatetime(new java.sql.Date(date.getTime()));
			boolean yeah = saldemoService.delsaldemobyid(salaryDemo);
			
			
			if(yeah){
				SalaryDemoStEle stele = new SalaryDemoStEle();
				stele.setStatu("1");
				stele.setUpdateby(coname);
				stele.setUpdatetime(new java.sql.Date(date.getTime()));
				stele.setDemoid(thisid);
				boolean yeahstele = saldemosteleservice.delstelebydemoid(stele);
				System.out.println("社保公积金删除状态。。。。。。"+yeahstele);
				
				SalaryDemoEle ele = new SalaryDemoEle();
				ele.setStatu("1");
				ele.setUpdateby(coname);
				ele.setUpdatetime(new java.sql.Date(date.getTime()));
				ele.setDemoid(thisid);
				boolean yeahele = saldemoeleservice.delelebydemoid(ele);
				System.out.println("基本项删除状态。。。。。。"+yeahele);
				
				SalaryItem salaryItem = new SalaryItem();
				salaryItem.setDemoid(thisid);
				salaryItem.setUpdateby(coname);
				salaryItem.setStatu("1");
				salaryItem.setUpdatetime(new java.sql.Date(date.getTime()));
				boolean yeahpel = salItemService.deleteDemopelbydemoid(salaryItem);
				System.out.println("工资信息删除状态。。。。。。"+yeahpel);
				
				if(yeahstele&&yeahele&&yeahpel){
					modelMap.put("message", "success");
					System.out.println("工资模板删除成功。。。。。");
				}else{
					modelMap.put("message", "error");	
					System.out.println("工资模板记录删除失败。。。。。");
				}}
			else{modelMap.put("message", "error");	System.out.println("工资模板删除失败。。。。。");}
		} catch (Exception e) {			
			System.out.println(e);
			System.out.println("工资模板删除失败。。。。。");
			modelMap.put("message", "error");	
		}
		return new ModelAndView(new MappingJacksonJsonView(),modelMap);
	}
}
