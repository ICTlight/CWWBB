package com.app.controller.salary;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.domain.salary.SalaryDemo;

@Controller
public class SalaryDemoController {

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
