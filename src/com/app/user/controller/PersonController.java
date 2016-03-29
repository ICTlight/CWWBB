package com.app.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.salary.domain.SalaryItem;
import com.app.salary.service.ISalaryItemService;
import com.app.user.domain.Company;
import com.app.user.domain.Person;
import com.app.user.domain.User;
import com.app.user.service.ICompanyService;
import com.app.user.service.IPersonService;
import com.app.user.service.IUserService;
import com.app.utils.BankUtils;
import com.app.utils.MailUtils;
import com.app.utils.Constants;
/**
 * @ file_name UserController.java
 * @ author LiuTuo
 * @ description  
 */
@Controller
public class PersonController {

	@Autowired
	private IPersonService personService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ICompanyService companyService;
	@Autowired
	private ISalaryItemService salitemService;
	
	public Person findPersonByIdnumber(String idnumber){
		return personService.finduserbyidnumber(idnumber);
	}
	public Person findPersonByRealname(String realname){
		return personService.finduserbyRealname(realname);
	}
	/**
   	 * 创建用户信息
   	 * @param 
   	 * @return 用户分页列表
   	 */
	@RequestMapping("/addperson")
	public ModelAndView addPerson(Person person,HttpServletRequest request) throws Exception {
		String ips= request.getRequestURL().toString();
    	ips = ips.substring(0, ips.length()-9);
    	System.out.println("ips......"+ ips);
    	
    	String msg="";
        Long s = Math.round(Math.random()*8999+1000);
        
		ModelMap modelMap = new ModelMap();
		String status = "已申请";
		String usertype = "个人用户";
		Long userid = userService.getuserid();
		person.setUserid(userid);
		person.setStatus(status);
		person.setUsertype(usertype);
		person.setValidate_code(s.toString());
		User user = new User();
		if(personService.savePerson(person)){
			user.setUserid(userid);
			user.setUsername(person.getUsername());
			user.setEmail(person.getEmail());
			user.setPassword(person.getPassword());
			user.setUsertype(usertype);
			user.setStatus(status);
			if(userService.saveUser(user)){
				
				StringBuffer sb=new StringBuffer("亲爱的" + person.getEmail() + "您好！\n");
	            sb.append("     感谢您注册财务外包系统，请您点击下面的链接以完成注册!\n");
	            sb.append("<a href=\"" +ips+"activePersonnal?userid=");
	            sb.append(userid);
	            sb.append("&email=");
	            sb.append(person.getEmail());
	            sb.append("&validate_code=");
	            sb.append(s.toString());
	            sb.append("\"</a>");
	            sb.append("\n");
	            sb.append("     若无法点击，请将链接复制到浏览器地址栏进行激活，谢谢");

	            MailUtils mailUtils = new MailUtils();
	            msg = mailUtils.sendCode(userid.toString(),person.getEmail(), sb.toString());
	            System.out.println(msg);
				modelMap.put("message", "success");
				return new ModelAndView("forward:/exam_email?email");
			}else{
				modelMap.put("message", "failure");
			}						
		}else{
			modelMap.put("message", "failure");
		}	
		return  new ModelAndView("regist");		
	}
	
	
	@RequestMapping("/getDemoid")
	public @ResponseBody Map<String,Object> getDemoid(@RequestParam("peid") String peid_st, HttpServletResponse resp) throws Exception {		
		Map<String,Object> map = new HashMap<String,Object>();
		SalaryItem salitem = salitemService.findDemoByPeid(Long.valueOf(peid_st));
		
		if(salitem!=null){
			System.out.println("查询的结果为：。。。。。。。"+salitem.getDemoid());
			Long demoid = salitem.getDemoid();
			if(demoid==null||demoid.toString().equalsIgnoreCase("")){
				map.put("info", "fail");
				map.put("finfo", "暂无您的薪酬信息！");
			}else{
				map.put("info", "success");
				map.put("finfo", demoid);
			}}
		else{
			map.put("info", "fail");
			map.put("finfo", "暂无您的薪酬信息！");
		}
		return map;
	}
	@RequestMapping("/validateIdnumber")
	public @ResponseBody Map<String,Object> validateIdnumber(@RequestParam("idnumber") String idnumber,HttpServletRequest req, HttpServletResponse resp) throws Exception {		
		Map<String,Object> map = new HashMap<String,Object>();
		Person pe = findPersonByIdnumber(idnumber);
		if(pe!=null){
			System.out.println("查询的结果为：。。。。。。。"+pe.getRealname());
			if(pe.getEmail()==null||pe.getEmail().equalsIgnoreCase("")){
				map.put("info", "fail");
				map.put("idnumberInfo", "该身份证号未被注册，请确认");
			}else{
				SalaryItem item = new SalaryItem();
				List<SalaryItem> list = new ArrayList<SalaryItem>();	            
				HttpSession session = req.getSession();
				Long coid =(Long)session.getAttribute(Constants.USERID);
				item.setCoid(coid);
				item.setIdnumber(idnumber);
	            list = salitemService.findDemoIdnumber(item);
	            String info = "";
	            if(list!=null && list.size()>=1){
	            	info = "该员工已在模板："+list.get(0).getDemoname()+"下，不能重复添加";
	            }
				map.put("info", "success");
				map.put("idnumberInfo", info);
				map.put("peid", pe.getUserid());
			}}
		else{
			map.put("info", "fail");
			map.put("idnumberInfo", "该身份证号未被注册，请确认");
		}
		return map;
	}
	
	@RequestMapping("/validatePename")
	public @ResponseBody Map<String,Object> validatePename(@RequestParam("pename") String pename, HttpServletResponse resp) throws Exception {		
		Map<String,Object> map = new HashMap<String,Object>();
		Person pe = findPersonByRealname(pename);
		if(pe!=null){
		System.out.println("查询的结果为：。。。。。。。"+pe.getRealname());
		if(pe.getEmail()==null||pe.getEmail().equalsIgnoreCase("")){
			map.put("info", "fail");
			map.put("realnameInfo", "该姓名未被注册，请确认");
		}else{
			map.put("info", "success");
			map.put("realnameInfo", "");
			map.put("peid", pe.getUserid());
		}}else{
			map.put("info", "fail");
			map.put("realnameInfo", "该姓名未被注册，请确认");
		}
		return map;
	}
	
	@RequestMapping("/validatebankaccount")
	public @ResponseBody Map<String,Object> validateUsername(@RequestParam("bankaccount") String bankaccount, HttpServletResponse resp) throws Exception {		
		Map<String,Object> map = new HashMap<String,Object>();
		BankUtils bankUtils = new BankUtils();
		String result = bankUtils.getNameOfBank(bankaccount);
		System.out.println("查询银行卡的结果为：。。。。。。。"+result);
		if(result.startsWith("您")||result.startsWith("国外")){
			map.put("info", "fail");
			map.put("bankInfo", result);
		}else{
			map.put("info", "success");
			map.put("bankInfo", result);
		}
		return map;
	}
	
	
	/*
	 * 激活企业注册
	 * */
    @RequestMapping(value = "/activePersonnal")
    public ModelAndView activePersonnal(Long userid,String email, String validate_code,HttpServletRequest request){
    	Person person = personService.findPersonByUserId(userid);
    	String status = "已验证";
    	if(person.getEmail().equals(email)&&person.getValidate_code().equals(validate_code)){
    		person.setStatus(status);
    		if(personService.updatePerson(person)){
    			User user = new User();
    			user.setUserid(userid);
    			user.setUsername(person.getUsername());
    			user.setEmail(person.getEmail());
    			user.setPassword(person.getPassword());
    			user.setStatus(status);
    			if(userService.updateUser(user)){
    				return new ModelAndView("firstpage");
    			}
    		}
    	}       
        return  new ModelAndView("regist");
    }
}
