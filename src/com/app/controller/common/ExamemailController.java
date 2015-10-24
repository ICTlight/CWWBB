package com.app.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExamemailController {

    @RequestMapping(value = "/exam_email")
    public String toAcquirer(String email,ModelMap model) throws Exception {

        ModelAndView modelAndView = new ModelAndView("exam_email");
        model.put("email",email);
        return  "exam_email";
    }
}
