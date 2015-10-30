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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.app.domain.salary.SalaryDemo;
import com.app.service.salary.ISalaryDemoService;
import com.app.utils.Constants;

@Controller
public class SalaryDemoController {

	@Autowired
	private ISalaryDemoService saldemoService;
	
	/*
	 * 
	 *  获取物料列表
	 * */
	@RequestMapping("/getSalDemoLists")
	public @ResponseBody List getSalDemoLists(HttpServletRequest request,Model model) throws Exception {
		HttpSession session = request.getSession();
		//Long coid = (Long)session.getAttribute(Constants.USERID);
		Long coid = Long.valueOf("1000000000");
				
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
	 * 增加工资项页面
	 */
	@RequestMapping("/addsaleleInfo")
	public ModelAndView addsaleleInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		SalaryDemo salaryDemo = new SalaryDemo();
		map.put("salaryDemo", salaryDemo);
		
		return new ModelAndView("salary/addsaleleDemo",map);
	}
	/**
	 * 增加员工页面
	 */
	@RequestMapping("/addsalpelInfo")
	public ModelAndView addsalpelInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		SalaryDemo salaryDemo = new SalaryDemo();
		map.put("salaryDemo", salaryDemo);
		
		return new ModelAndView("salary/addsalpelDemo",map);
	}
	
	/**
	 * 修改工资项页面
	 */
	@RequestMapping("/updatesaleleInfo")
	public ModelAndView updatesaleleInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		SalaryDemo salaryDemo = new SalaryDemo();
		map.put("salaryDemo", salaryDemo);
		
		return new ModelAndView("salary/updatesaleleDemo",map);
	}
	/**
	 * 增加员工页面
	 */
	@RequestMapping("/updatesalpelInfo")
	public ModelAndView updatesalpelInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		SalaryDemo salaryDemo = new SalaryDemo();
		map.put("salaryDemo", salaryDemo);
		
		return new ModelAndView("salary/updatesalpelDemo",map);
	}
}
