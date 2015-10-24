package com.app.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.domain.user.Company;
import com.app.domain.user.Person;
import com.app.domain.user.User;
import com.app.service.user.ICompanyService;
import com.app.service.user.IPersonService;
import com.app.service.user.IUserService;
import com.app.utils.BankUtils;
import com.app.utils.MailUtils;

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
