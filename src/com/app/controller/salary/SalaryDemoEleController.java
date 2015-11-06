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
import com.app.service.salary.ISalaryDemoEleService;
import com.app.service.salary.ISalaryDemoService;
import com.app.utils.Constants;

@Controller
public class SalaryDemoEleController {

	@Autowired
	private ISalaryDemoEleService demoleservice;
	@Autowired
	private ISalaryDemoService demoservice;
	
	/*
	 * 
	 *  获取工资项列表
	 * */
	@RequestMapping("/getSalDemoeleLists")
	public @ResponseBody List getSalDemoLists(@RequestParam("demoid_st") String demoid_st,HttpServletRequest request,Model model) throws Exception {
		Long demoid = Long.valueOf(demoid_st);
		List<SalaryDemoEle> list = new ArrayList<SalaryDemoEle>();
		try {	            
            list = demoleservice.findSaldemoeleBydemoid(demoid);
		} catch (Exception e) {			
			System.out.println(e);
		}
			return list;
	}
	/**
	 * 增加工资项页面
	 */
	@RequestMapping("/addsaleleInfo")
	public ModelAndView addsaleleInfo(@RequestParam("demoid_st") String demoid_st)  throws Exception{ 
		ModelMap modelMap = new ModelMap();
		SalaryDemoEle demoele = new SalaryDemoEle();		
		Long demoid = Long.valueOf(demoid_st);
		SalaryDemo demo = demoservice.findSaldemoBySaldemoid(demoid);
		String demoname = demo.getSaldemoname();
		demoele.setDemoid(demoid);
		demoele.setDemoname(demoname);
		modelMap.put("salaryDemoEle", demoele);
		return new ModelAndView("salary/addsaleleDemo",modelMap);
	}

	/**
	* 保存模板项   
	 */
	@RequestMapping("/saveSalEleDemo")
	public ModelAndView saveSalDemo(SalaryDemoEle demoele,HttpServletRequest request) throws Exception { 
		ModelMap modelMap = new ModelMap();
		HttpSession session = request.getSession();
		Long coid = (Long)session.getAttribute(Constants.USERID);
		String coname = (String)session.getAttribute(Constants.USERNAME);
		Long demoid = Long.valueOf(demoele.getDemoid_st());
		Long eleid = demoleservice.getsaldemoeleid();		
		demoele.setEleid(eleid);
		demoele.setCoid(coid);
		demoele.setConame(coname);
		demoele.setDemoid(demoid);
		Date date = new Date();
		demoele.setCreatetime(new java.sql.Date(date.getTime()));
		demoele.setCreateby(coname);
		if(demoleservice.saveSaldemoEle(demoele)){
			modelMap.put("message", "success");					
		}else{
			modelMap.put("message", "failure");
		}	
		return new ModelAndView(new MappingJacksonJsonView(),modelMap);
	}
	
	/**
	 * 修改工资项页面
	 */
	@RequestMapping("/updatesaleleInfo")
	public ModelAndView updatesaleleInfo(@RequestParam("eleid") String eleid) {
		ModelMap modelMap = new ModelMap();
		Long id = Long.valueOf(eleid);		
		SalaryDemoEle salaryDemoEle = demoleservice.findSaldemoEleByEleid(id);
		modelMap.put("salaryDemoEle", salaryDemoEle);
		
		return new ModelAndView("salary/updatesaleleDemo",modelMap);
	}
	
	/**
	* 保存模板项   
	 */
	@RequestMapping("/updatedemoele")
	public ModelAndView updatedemoele(SalaryDemoEle demoele,HttpServletRequest request) throws Exception { 
		ModelMap modelMap = new ModelMap();
		HttpSession session = request.getSession();
		String coname = (String)session.getAttribute(Constants.USERNAME);
		Long eleid = Long.valueOf(demoele.getEleid_st());
		demoele.setEleid(eleid);
		Date date = new Date();
		demoele.setUpdateby(coname);
		demoele.setUpdatetime(new java.sql.Date(date.getTime()));
		if(demoleservice.updateSalDemoelebyid(demoele)){
			modelMap.put("message", "success");					
		}else{
			modelMap.put("message", "failure");
		}	
		return new ModelAndView(new MappingJacksonJsonView(),modelMap);
	}
}
