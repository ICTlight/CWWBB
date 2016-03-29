package com.app.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class MailUtils {
	 public static String sendCode(final String acquirer_id,final String email,final String text) {
//       AsyncUtils.start(new AsyncUtils.Start {
//       public void start(){
//           return ;
//           //ValidateCode validateCode = new ValidateCode(email,code,CodeType.email);
//
       try {
    	   
//    	   @SuppressWarnings("resource")
//		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("application-common.xml","applicationContext.xml");   
//    	   BeanFactory factory = (BeanFactory) appContext;   
    	   @SuppressWarnings("resource")
    	   WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
    	   wac.getBean("mailSender");
    	   
           JavaMailSender javaMailSender = (JavaMailSender)wac.getBean("mailSender");
           SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
           simpleMailMessage.setTo(email);
           simpleMailMessage.setFrom("934261905@qq.com");
           simpleMailMessage.setText(text);
           simpleMailMessage.setSubject("财务外包注册--账号激活邮件");
           javaMailSender.send(simpleMailMessage);
           return "邮件发送成功";
           }catch (Exception e){
               System.out.println(e.toString());
               return "邮件发送失败";
           }
       }
}
