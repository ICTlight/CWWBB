<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@include file="/jsp/utils/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <%@include file="/jsp/utils/meta.jsp" %> 
  <%@include file="/jsp/utils/common_css.jsp" %> 
  <%@include file="/jsp/utils/common_js.jsp" %> 
  <%@include file="/jsp/utils/firpage_js.jsp" %> 
  <title>财务外包--首页</title>    
    <style>
        @media only screen and (min-width : 992px) {
            .smartling-fr .product-intro .section-heading-text h3 {
                font-size: 28px;
                line-height: 1.2;
            }
            .smartling-fr .customer-logos-row .customer-logos__button {
                margin-top: 12px;
            }
            .smartling-fr .customer-logos__button .button {
                height: auto;
            }
            .smartling-fr .customer-logos__button .buttonTxt {
                line-height: 1.2;
                padding-top: 2px;
                padding-bottom: 2px;
            }
        }
    </style>
<script type="text/javascript">
    function check_data(){
        if(document.getElementById('username').value==""){
            document.getElementById("loginmsg").innerHTML="用户名不能为空。";
            document.getElementById('username').focus();
            return false;
        }

        if(document.getElementById('password').value==""){
            document.getElementById("loginmsg").innerHTML="密码不能为空。";
            document.getElementById('password').focus();
            return false;
        }
           $.ajax( {   
       	      type : "POST",   
       	      url : "<%=request.getContextPath()%>/login", 
       	      data : {
       	        'username' :$("#username").val(),
       	        'password' :$("#password").val()
       	       },  
       	      dataType: "json",   
       	      success : function(data) { 
     	          if(data.info=="success"){       	        	  
     	        	document.getElementById("loginmsg").innerHTML=""; 
     	        	if(data.usertype=="个人用户"){
     	        		document.getElementById("tomypage").href="/CWWBB/jsp/pemypage.jsp"
     	        	}
     	        	var torefresh = document.getElementById("tomypage");
      	        	torefresh.click();
     	          }   
     	          else if(data.info=="noemailexam"){
     	        	alert("您的邮箱未激活，请先激活您的邮箱！");
     	        	document.getElementById("loginmsg").innerHTML="";
     	        	if(data.usertype=="个人用户"){
     	        		document.getElementById("tomypage").href="/CWWBB/jsp/pemypage.jsp"
     	        	}
     	        	var torefresh = document.getElementById("tomypage");
      	        	torefresh.click();
     	          }
     	          else{
     	        	  //alert("请确认用户名、密码是否有误！");
     	        	document.getElementById("loginmsg").innerHTML="请确认用户名、密码是否有误";
     	          }   
     	      }
       	  });		
    }
    
    function cancellogin(){
    	var torefresh = document.getElementById("logotorefresh");
      	torefresh.click();
        
    }
  </script>
    
	
</head>
<body id="products" class=" jira en">
<%session = request.getSession();   %>
 	 <h1 id="usertype" style="display:none" ><%=session.getAttribute("usertype")%></h1> 
<div id="container" class="container">
	<header id="header">
        <jsp:include page="/jsp/utils/head.jsp"></jsp:include>
    </header>
	<div id="contentContainer">
       <div class="row">
    	<div class="col-sm-8">
    		<img src="<%=request.getContextPath() %>/assets/img/wall.jpg" alt="" />
        </div> 
      <div id="logindiv" class="col-sm-4">
        <div class="span4">
        	
          <div >
          <p></p>
          <p></p>
            <form id="login-form" class="login-form">
            <p></p>
            <p></p>
            <p></p>
              <h3>用户登录</h3>
              	<p></p>
              	<p></p>
              	<p></p>
              	<p></p>
		<br>
				<div id="loginmsg" style="text-align: center; color:#FF0000">${msg}</div>
				<br>
				<p></p>
                <div class="alert fade in alert-danger" style="display: none;">
                  <i class="icon-remove close" data-dismiss="alert"></i>请输入用户名和密码</div>
                  <div class="input-prepend">
                  <span class="add-on"> <i class="icon-user " ></i></span>
                  <input type="text" name="username" id="username" value="" class="form-control required" placeholder="用户名" />
                </div>
                <br>
                <p></p>
                <div class="input-prepend">
				         <span class="add-on"><i class="icon-lock">
                                        </i></span>

                  <input type="password" name="password" id="password" class="form-control required" placeholder="密码" />

                </div>
<p></p>
                <div class="row">
                  <div class="col-md-6">
                    <label class="col-md-12 checkbox pull-left">
                      <input type="checkbox" id="rememberMe" name="rememberMe">记住密码</label>
                  </div>
                </div>
                <br>
<p></p><p></p>
                  <div class="row">
                    <h4 class="col-md-2"></h4>
                    <div class="col-md-4">
                      <button  class="btn btn-info btn-large" type="button" onclick="check_data();">登录</button>                     
                    </div>
                    <h4 class="col-md-1"></h4>
                    <div class="col-md-4">
                      <button  class="btn btn-info btn-large" type="button" onclick="cancellogin();">取消</button>
                    </div>
                  </div>
                  <br>
                  <div style="padding:3em 1em 1em 2.2em" class="form-actions">
                    <div class="row pull-right">
                      <ul class="nav navbar-nav navbar-right">
                        <li><a href='#' title='0'>忘记密码？</a></li>
                        <li><a href='#' title='0'>立即注册</a></li>
                      </ul>
                    </div>
                  </div>
            </form>
          </div>
        
      </div>
    </div>
    </div>
</div>
	<footer id="wac-desktop-footer" class="desktop-footer SL_swap" style="height:60px">
         <jsp:include page="/jsp/utils/foot.jsp"></jsp:include>
    </footer>
</div>
</body>
</html>