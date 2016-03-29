package com.app.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.user.domain.User;
import com.app.user.service.ICompanyService;
import com.app.user.service.IPersonService;
import com.app.user.service.IUserService;
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
   		if(user!=null){
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
	   			map.put("usertype",user.getUsertype()); 
	     		return map;
	   		}
   		}
    	map.put("info", "fail");
		return map;
   	}
	@RequestMapping("/appLogin")
	public @ResponseBody String appLogin(@RequestParam("username") String username,@RequestParam("password") String password,HttpServletRequest request, HttpServletResponse response) throws Exception {
   		Map<String,Object> map = new HashMap<String,Object>();
   		String callback = request.getParameter("callback");
   		User user = userService.findUserByuserame(username);
   		if(user!=null){
   			String pass = user.getPassword();
	   		if(pass.equals(password)){	   			
	   		    System.out.println("userid" + "...." + user.getUsername());
	   		    map.put("user",objectToJson(user).toString());
	   		    System.out.println(objectToJson(user).toString());
	   		    map.put("info", "success");
	   		 JSONObject jsonObject = objectToJson(map);
	 		return callback+"("+jsonObject.toString()+");";
	   		}
   		}
   		map.put("user",""); 
   		map.put("info", "fail");
   		JSONObject jsonObject = objectToJson(map);
   		
   		return callback+"("+jsonObject.toString()+");";
   	}
	
	public static<T> JSONObject objectToJson(T obj) throws JSONException, IOException {
        ObjectMapper mapper = new ObjectMapper();  
        // Convert object to JSON string  
        String jsonStr = "";
        try {
             jsonStr =  mapper.writeValueAsString(obj);
        } catch (IOException e) {
            System.out.println("app登陆异常。。。。。。。。。。"+e.toString());
        }
        System.out.println(jsonStr.toString());
        return new JSONObject(jsonStr);
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
