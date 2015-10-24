package com.app.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.domain.user.User;
import com.app.service.user.ICompanyService;
import com.app.service.user.IPersonService;
import com.app.service.user.IUserService;
import com.app.utils.Constants;

@Controller
public class LoginController {

	@Autowired
	private ICompanyService companyService;
	@Autowired
	private IPersonService personService;
	@Autowired
	private IUserService userService;
	@RequestMapping("/login")
   	public @ResponseBody Map<String,Object> pelogin(@RequestParam("username") String username,@RequestParam("password") String password,HttpServletRequest req,HttpServletResponse resp) throws Exception {
   		Map<String,Object> map = new HashMap<String,Object>();
   		User user = userService.findUserByuserame(username);
   		String pass = user.getPassword();
   		if(pass.equals(password)){
   			HttpSession session = req.getSession(); 
   		    System.out.println("userid" + "...." + user.getUserid());
   			session.setAttribute(Constants.USERID, user.getUserid());
   			session.setAttribute(Constants.USERTYPE, user.getUsertype());
   			session.setAttribute(Constants.USERNAME, user.getUsername());
   			session.setAttribute(Constants.EMAIL, user.getEmail());
   			session.setAttribute(Constants.STATUS, user.getStatus());
   			map.put("info","success");      		
     		return map;
   		}
    	map.put("info", "fail");
		return map;
   	}
	
	@RequestMapping("/validateUsername")
	public @ResponseBody Map<String,Object> validateUsername(@RequestParam("username") String username, HttpServletResponse resp) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
   		int count =userService.findUsernameCount(username);
   		if(count==0){
   			map.put("info","success");      		
     		return map;
   		}
    	map.put("info", "fail");
		return map;
	}
	
	@RequestMapping("/validateEmail")
	public @ResponseBody Map<String,Object> validateEmail(@RequestParam("email") String email, HttpServletResponse resp) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
   		int count =userService.findEmailCount(email);
   		if(count==0){
   			map.put("info","success");      		
     		return map;
   		}
    	map.put("info", "fail");
		return map;
	}
}
