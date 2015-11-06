package com.app.controller.salary;

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

import com.app.domain.salary.SalaryDemo;
import com.app.domain.salary.SalaryDemoEle;
import com.app.domain.salary.SalaryDemoStEle;
import com.app.domain.salary.SalaryStandEle;
import com.app.service.salary.ISalaryDemoEleService;
import com.app.service.salary.ISalaryDemoService;
import com.app.service.salary.ISalaryDemoStEleService;
import com.app.service.salary.ISalaryStandEleService;
import com.app.utils.Constants;

@Controller
public class SalaryDemoStEleController {

	@Autowired
	private ISalaryDemoStEleService demosteleservice;
	@Autowired
	private ISalaryDemoService demoservice;
	@Autowired
	private ISalaryStandEleService standservice;
	
	
	/*
	 * 
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
	* 保存模板项   
	 */
	@RequestMapping("/saveSalstEleDemo")
	public ModelAndView saveSalDemo(@RequestParam("standlist") String standlist,@RequestParam("demoid_st") String demoid_st ,
			@RequestParam("demoname") String demoname ,HttpServletRequest request) throws Exception {
		
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
		Date date = new Date();
		salarydemostele.setCreatetime(new java.sql.Date(date.getTime()));
		salarydemostele.setCreateby(coname);
		
		demosteleservice.deleteSaldemosteleBydemoid(demoid);
		
		System.out.println("得到的standlist为："+standlist);
		if(standlist!=null){
			String[] standlistArr = standlist.split(",");
			int successcount = 0;
			int sum = standlistArr.length;
			for(int i=0;i<standlistArr.length;i++){
				String currentelename = standlistArr[i];
				System.out.println("最后，currentelename为：。。。。。"+currentelename);
				SalaryStandEle salaryStandEle = standservice.findStandEleByElename(currentelename);
				Long eleid = demosteleservice.getsaldemosteleid();
				salarydemostele.setEleid(eleid);
				salarydemostele.setElename(currentelename);
				salarydemostele.setFixedcode(salaryStandEle.getFixedcode());
				salarydemostele.setCptype(salaryStandEle.getCptype());
				salarydemostele.setIsshow(salaryStandEle.getIsshow());
				salarydemostele.setPrecisions(salaryStandEle.getPrecisions());
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
}
