package com.app.user.controller;

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
import com.app.user.domain.Company;
import com.app.user.domain.User;
import com.app.user.service.ICompanyService;
import com.app.user.service.IUserService;
import com.app.utils.MailUtils;

/**
	 * 企业用户相关操作
	 *  
	 * liutuo
	 */
@Controller
public class CompanyController {

	@Autowired
	private ICompanyService companyService;
	
	@Autowired
	private IUserService userService;
	/**
   	 * 创建企业用户信息
   	 *  
   	 * liutuo
   	 */
	@RequestMapping("/addcompany")
	public ModelAndView addCompany(Company company,HttpServletRequest request) throws Exception {
		String ips= request.getRequestURL().toString();
    	ips = ips.substring(0, ips.length()-10);
    	System.out.println("ips......"+ ips);
    	
    	String msg="";
        Long s = Math.round(Math.random()*8999+1000);
        
		ModelMap modelMap = new ModelMap();
		String status = "已申请";
		String usertype = "企业用户";
		Long userid = userService.getuserid();
		company.setUserid(userid);
		company.setStatus(status);
		company.setUsertype(usertype);
		company.setValidate_code(s.toString());
		User user = new User();
		if(companyService.saveCompany(company)){
			user.setUserid(userid);
			user.setUsername(company.getUsername());
			user.setEmail(company.getEmail());
			user.setPassword(company.getPassword());
			user.setUsertype(usertype);
			user.setStatus(status);
			if(userService.saveUser(user)){
				StringBuffer sb=new StringBuffer("亲爱的" + company.getEmail() + "您好！\n");
	            sb.append("     感谢您注册财务外包系统，请您点击下面的链接以完成注册!\n");
	            sb.append("<a href=\"" +ips+"activeCompany?userid=");
	            sb.append(userid);
	            sb.append("&email=");
	            sb.append(company.getEmail());
	            sb.append("&validate_code=");
	            sb.append(s.toString());
	            sb.append("\"</a>");
	            sb.append("\n");
	            sb.append("     若无法点击，请将链接复制到浏览器地址栏进行激活，谢谢");

	            MailUtils mailUtils = new MailUtils();
	            msg = mailUtils.sendCode(userid.toString(),company.getEmail(), sb.toString());
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
	
	/**
	 * 激活企业注册
	 * */
    @RequestMapping(value = "/activeCompany")
    public ModelAndView activeSupplier(Long userid,String email, String validate_code,HttpServletRequest request){
    	Company company = companyService.findCompanyByUserId(userid);
    	String status = "已验证";
    	if(company.getEmail().equals(email)&&company.getValidate_code().equals(validate_code)){
    		company.setStatus(status);
    		if(companyService.updateCompany(company)){
    			User user = new User();
    			user.setUserid(userid);
    			user.setUsername(company.getUsername());
    			user.setEmail(company.getEmail());
    			user.setPassword(company.getPassword());
    			user.setStatus(status);
    			if(userService.updateUser(user)){
    				return new ModelAndView("firstpage");
    			}
    		}
    	}        
        return  new ModelAndView("regist");
    }
    
    /**
	 * 唯一性校验
	 * */
    @RequestMapping("/validatecompanyid")
	public @ResponseBody Map<String,Object> validatecompanyid(@RequestParam("companyid") String companyid, HttpServletResponse resp) throws Exception {		
		Map<String,Object> map = new HashMap<String,Object>();
		Company company = companyService.findCompanyByCompanyId(companyid);
		String result="";
		if(company != null){
			result = company.getCompanyname();
			map.put("info", "fail");
			map.put("companyidInfo", "该公司已完成注册！");
		}else{
			map.put("info", "success");
			map.put("companyidInfo", result);
		}
		return map;
	}
    
    /**
	 * 唯一性校验
	 * */
	@RequestMapping("/validatecompanyids")
	public @ResponseBody Map<String,Object> validatecompanyids(@RequestParam("companyids") String companyids, HttpServletResponse resp) throws Exception {		
		Map<String,Object> map = new HashMap<String,Object>();
		Company company = companyService.findCompanyByCompanyId(companyids);
		String result="";
		if(company != null){
			result = company.getCompanyname();
			map.put("info", "fail");
			map.put("companyidsInfo", result);
		}else{
			map.put("info", "success");
			map.put("companyidsInfo", "该公司还未注册！");
		}
		return map;
	}
}
