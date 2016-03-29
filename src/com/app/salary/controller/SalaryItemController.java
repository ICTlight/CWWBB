package com.app.salary.controller;

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
import com.app.cpsal.controller.SalaryCountController;
import com.app.cpsal.domain.SalaryCount;
import com.app.cpsal.domain.SalaryPay;
import com.app.cpsal.domain.SalaryPayItems;
import com.app.cpsal.service.ISalaryCountService;
import com.app.cpsal.service.ISalaryPayItemsService;
import com.app.cpsal.service.ISalaryPayService;
import com.app.salary.domain.SalaryDemo;
import com.app.salary.domain.SalaryDemoEle;
import com.app.salary.domain.SalaryDemoStEle;
import com.app.salary.domain.SalaryItem;
import com.app.salary.domain.SalaryLocalStand;
import com.app.salary.service.ISalaryDemoEleService;
import com.app.salary.service.ISalaryDemoService;
import com.app.salary.service.ISalaryDemoStEleService;
import com.app.salary.service.ISalaryItemService;
import com.app.salary.service.ISalaryLocalStandService;
import com.app.user.controller.PersonController;
import com.app.user.domain.Person;
import com.app.utils.Constants;

/**
 * 模板下的员工信息相关操作
 * 
 * liutuo
 * */
@Controller
public class SalaryItemController {

	@Autowired
	private ISalaryDemoService saldemoservice;
	@Autowired
	private PersonController personController;
	@Autowired
	private ISalaryItemService salItemService;
	@Autowired
	private ISalaryDemoEleService saldemoeleservice;
	@Autowired
	private ISalaryDemoStEleService saldemosteleservice;
	@Autowired
	private SalaryCountController salCountController;
	@Autowired
	private ISalaryCountService countService;
	@Autowired
	private ISalaryLocalStandService localService;
	@Autowired
	private ISalaryPayItemsService payitemService;
	@Autowired
	private ISalaryPayService payService;
	
	/** 
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
	/** 
	 *  获取员工薪酬信息列表
	 * */
	@RequestMapping("/getSpelLists")
	public @ResponseBody List getSpelLists(@RequestParam("peid_st") Long peid,HttpServletRequest request,Model model) throws Exception {
		List<SalaryItem> peldelist = new ArrayList<SalaryItem>();
		List<SalaryItem> pelstlist = new ArrayList<SalaryItem>();
		try {	            
            peldelist = salItemService.findPeldelistByPeid(peid);
            pelstlist = salItemService.findSalstlistByPeid(peid);
		} catch (Exception e) {			
			System.out.println(e);
		}
		ArrayList list = new ArrayList();
		list.add(0, peldelist);
		list.add(1,peldelist.size());
		list.add(2,pelstlist);
		return list;
	}
	/** 
	 *  获取工资项列表
	 * */
	@RequestMapping("/getSeleLists")
	public @ResponseBody List getSeleLists(@RequestParam("demoid_st") String demoid_st,HttpServletRequest request,Model model) throws Exception {
		Long demoid = Long.valueOf(demoid_st);
		ArrayList list = new ArrayList();
		int elesum = 0;
		String areacode = "";
		List<SalaryDemoEle> demoelelist = new ArrayList<SalaryDemoEle>();
		List<SalaryDemoStEle> demostelelist = new ArrayList<SalaryDemoStEle>();
		SalaryLocalStand localstand = new SalaryLocalStand();
		try {	            
			demoelelist = saldemoeleservice.findSaldemoeleBydemoid(demoid);		
		} catch (Exception e) {			
			System.out.println(e);
		}
		try {	            
			demostelelist = saldemosteleservice.findSaldemosteleBydemoid(demoid);
			areacode = demostelelist.get(0).getAreacode();
			demostelelist = saldemosteleservice.findBasecodeBydemoid(demoid);
			localstand = localService.findSalLocalStandByAreacode(areacode);
		} catch (Exception e) {			
			System.out.println(e);
		}
		elesum = demoelelist.size();
		list.add(0,demoelelist);
		list.add(1, demostelelist);
		list.add(2, elesum);
		list.add(3, localstand);
		list.add(4, areacode);
		return list;
	}
	
	/** 
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
	public ModelAndView updatesalpelInfo(@RequestParam("peid") Long peid,@RequestParam("demoid_st") String demoid_st,HttpServletRequest req)  throws Exception {
		ModelMap modelMap = new ModelMap();
		modelMap.put("peid", peid);
		String areacode = saldemosteleservice.findSaldemosteleBydemoid(Long.valueOf(demoid_st)).get(0).getAreacode();
		String averagesal = localService.findSalLocalStandByAreacode(areacode).getAveragesal().toString();
		String pename = salItemService.findPenameByPeid(peid);
		Person pe = personController.findPersonByRealname(pename);
		modelMap.put("pename", pename);
		modelMap.put("idnumber", pe.getIdnumber());
		modelMap.put("areacode", areacode);
		modelMap.put("averagesal", averagesal);
		return new ModelAndView("salary/updatesalpelDemo",modelMap);
	}
	
	/**
	* 保存员工工资信息
	 */
	@SuppressWarnings("null")
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
		salaryItem.setStatu("0");
		Date date = new Date();
		salaryItem.setCreatetime(new java.sql.Date(date.getTime()));
		salaryItem.setCreateby(coname);
		String peid = req.getParameter("peid");
		
		salaryItem.setPeid(Long.valueOf(peid));
		salaryItem.setPename(req.getParameter("pename"));
		salaryItem.setIdnumber(req.getParameter("idnumber"));
		salaryItem.setIsstop("0");
		Long salitemid;
		Long eleid;
		String elename;
		String basevalue;
		String fixedcode;
		String cptype;
		
		List<SalaryDemoEle> demoelelist = getEleListByDemoid(demoid);
		int count = 0;
		if(demoelelist!=null || demoelelist.size()!=0){
			for(int i=0;i<demoelelist.size();i++){
				 salitemid = salItemService.getsalitemid();
				 eleid = demoelelist.get(i).getEleid();
				 basevalue = req.getParameter(demoelelist.get(i).getEleid().toString());
				 elename = demoelelist.get(i).getElename();
				 fixedcode = demoelelist.get(i).getFixedcode();
				 cptype = demoelelist.get(i).getCptype();
				 salaryItem.setSalitemid(salitemid);
				 salaryItem.setEleid(eleid);
				 salaryItem.setElename(elename);
				 salaryItem.setBasevalue(basevalue);
				 salaryItem.setFixedcode(fixedcode);
				 salaryItem.setCptype(cptype);
				 salaryItem.setIsstand("1");
				 if(salItemService.saveSalItem(salaryItem)){
					 count++;
				 }
			}
		}
		List<SalaryDemoStEle> demostelelist = saldemosteleservice.findBasecodeBydemoid(demoid);//getStEleListByDemoid(demoid);
		
		if(demostelelist!=null || demostelelist.size()!=0){			
			String cpbase = req.getParameter("cpbase");
			for(int i=0;i<demostelelist.size();i++){
				 salitemid = salItemService.getsalitemid();
				 //eleid = demostelelist.get(i).getEleid();
				 fixedcode = demostelelist.get(i).getBasecode();
				 basevalue = req.getParameter(fixedcode);
				 elename = getSBBname(fixedcode);
				 cptype = demostelelist.get(i).getCptype();
				 salaryItem.setSalitemid(salitemid);
				 salaryItem.setEleid(Long.valueOf("0"));
				 salaryItem.setElename(elename);
				 salaryItem.setBasevalue(basevalue);
				 salaryItem.setFixedcode(fixedcode);
				 salaryItem.setCptype(cptype);
				 salaryItem.setIsstand("0");
				 salaryItem.setStandval(cpbase);
				 if(salItemService.saveSalItem(salaryItem)){
					 count++;
				 }
			}
		}		
		
		if(count==demostelelist.size()+demoelelist.size()){
			//salCountController.countSal(demoid,Long.valueOf(peid),coid);
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
	public ModelAndView updateDemopel(@RequestParam("peid_st") String peid_st,HttpServletRequest req) throws Exception {
		ModelMap modelMap = new ModelMap();
		SalaryItem salaryItem= new SalaryItem();
		Long peid = Long.valueOf(peid_st);
		HttpSession session = req.getSession();
		String coname = (String)session.getAttribute(Constants.USERNAME);
		Long coid = (Long)session.getAttribute(Constants.USERID);
		Date date = new Date();
		salaryItem.setUpdatetime(new java.sql.Date(date.getTime()));
		salaryItem.setUpdateby(coname);
		Long salitemid;
		String basevalue;
		String standval=req.getParameter("cpbase").toString();//存储社保基数方式
		List<SalaryItem> itemlist = salItemService.findPeldelistByPeid(peid);//得到基本项
		Long demoid = Long.valueOf("0");
		int count = 0;
		if(itemlist!=null || itemlist.size()!=0){
			demoid = itemlist.get(0).getDemoid();
			for(int i=0;i<itemlist.size();i++){
				 basevalue = req.getParameter(itemlist.get(i).getSalitemid().toString());
				 salaryItem.setSalitemid(itemlist.get(i).getSalitemid());
				 salaryItem.setBasevalue(basevalue);
				 if(salItemService.updateSalItembyid(salaryItem)){
					 count++;
				 }
			}
		}
		
		List<SalaryItem> itemstlist = salItemService.findSalstlistByPeid(peid);//得到shebao项
		if(itemstlist!=null || itemstlist.size()!=0){
			for(int i=0;i<itemstlist.size();i++){
				 basevalue = req.getParameter(itemstlist.get(i).getFixedcode().toString());
				 salaryItem.setSalitemid(itemstlist.get(i).getSalitemid());
				 salaryItem.setBasevalue(basevalue);
				 salaryItem.setStandval(standval);
				 if(salItemService.updateSalItembyid(salaryItem)){
					 count++;
				 }
			}
		}
		
		
		if(count==itemlist.size()+itemstlist.size()){
			modelMap.put("message", "success");	
			//salCountController.countSalary(demoid,Long.valueOf(peid));
			SalaryPayItems payitem = new SalaryPayItems();
			payitem.setPeid(peid);
			payitem.setStatu("1");
			payitemService.deletePayitembypeid(payitem);
			SalaryPay pay = new SalaryPay();
			pay.setPeid(peid);
			pay.setStatu("1");
			payService.deletePaybypeid(pay);
			SalaryCount salcount =new SalaryCount();
			salcount.setPeid(Long.valueOf(peid));
			salcount.setStatu("1");
			countService.deletePaycountbypeid(salcount);
			salCountController.countSal(demoid,Long.valueOf(peid),coid);
		}else{
			modelMap.put("message", "failure");
		}
		return new ModelAndView(new MappingJacksonJsonView(),modelMap);
	}
	
	//获取基本项list
	public List<SalaryDemoEle> getEleListByDemoid(Long demoid){
		List<SalaryDemoEle> demoelelist = new ArrayList<SalaryDemoEle>();
		try {	            
			demoelelist = saldemoeleservice.findSaldemoeleBydemoid(demoid);		
		} catch (Exception e) {			
			System.out.println(e);
		}
		return demoelelist;
	}
	
	//获取社保项list
	public List<SalaryDemoStEle> getStEleListByDemoid(Long demoid){
		List<SalaryDemoStEle> demostelelist = new ArrayList<SalaryDemoStEle>();
		try {	            
			demostelelist = saldemosteleservice.findSaldemosteleBydemoid(demoid);
		} catch (Exception e) {			
			System.out.println(e);
		}
		return demostelelist;
	}
	
	/**
	* 删除对象 
	 */
	@RequestMapping("/delpel")
	public ModelAndView delpel(@RequestParam("thisid") Long thisid,HttpServletRequest request) throws Exception {
		
		ModelMap modelMap = new ModelMap();		
		SalaryItem salitem = new SalaryItem();
		try {
			HttpSession session = request.getSession();
			String coname = (String)session.getAttribute(Constants.USERNAME);
			Date date = new Date();
			salitem.setUpdateby(coname);
			salitem.setUpdatetime(new java.sql.Date(date.getTime()));
			salitem.setPeid(thisid);
			salitem.setStatu("1");
			boolean yeah = salItemService.deleteDemopel(salitem);
			if(yeah){modelMap.put("message", "success");}
			else{modelMap.put("message", "error");	}
		} catch (Exception e) {			
			System.out.println(e);
			modelMap.put("message", "error");	
		}
		return new ModelAndView(new MappingJacksonJsonView(),modelMap);
	}
	
	public String getSBBname(String id){
		String name = "";
		if(id.equalsIgnoreCase("zhufb")){
			name = "住房基数";
		}else if(id.equalsIgnoreCase("yilb")){
			name = "医疗基数";
		}else if(id.equalsIgnoreCase("gongsb")){
			name = "工伤基数";
		}else if(id.equalsIgnoreCase("shengyb")){
			name = "生育基数";
		}else if(id.equalsIgnoreCase("shiyb")){
			name = "失业基数";
		}else if(id.equalsIgnoreCase("yanglb")){
			name = "养老基数";
		}
		return name;
	}
}
