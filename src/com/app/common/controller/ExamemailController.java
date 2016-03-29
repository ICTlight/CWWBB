package com.app.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 验证  liutuo
 * */
@Controller
public class ExamemailController {

	//跳转到邮箱验证页面
    @RequestMapping(value = "/exam_email")
    public String toAcquirer(String email,ModelMap model) throws Exception {
    	
        model.put("email",email);
        return  "exam_email";
    }
}
