<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/registstyle.css" type="text/css" media="screen"/>
  <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap-3.0.3.min.css" rel="stylesheet" type="text/css"/>
  <script src="<%=request.getContextPath() %>/bootstrap/js/jquery-2.1.4.min.js"></script>
  <script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap-3.0.3.min.js"></script> 
  <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/jira.css" type="text/css" media="all">
  <script src="<%=request.getContextPath() %>/assets/js/1096093.js"></script>
  <script src="<%=request.getContextPath() %>/assets/js/atl-analytics.min.js"></script>
  <script src="<%=request.getContextPath() %>/assets/js/global.js"></script>
  <script src="<%=request.getContextPath() %>/assets/js/jquery-waypoints.js"></script>
  <script src="<%=request.getContextPath() %>/assets/js/product-tour-template.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/conversion.js"></script>
  <title>财务外包--注册</title>    
    <style>
        span.reference{
            position:fixed;
            left:5px;
            top:5px;
            font-size:10px;
            text-shadow:1px 1px 1px #fff;
        }
        span.reference a{
            color:#555;
            text-decoration:none;
			text-transform:uppercase;
        }
        span.reference a:hover{
            color:#000;
            
        }
        h1{
            color:#ccc;
            font-size:36px;
            text-shadow:1px 1px 1px #fff;
            padding:20px;
        }
    </style>

	<script type="text/javascript">
	$(document).ready(function(){
  		var emailaddress = document.getElementById('email').innerHTML;
  		if(emailaddress.indexOf("qq.com")!=-1){
  			document.getElementById("toemailweb").href="http://mail.qq.com/";
  		}
  		else if(emailaddress.indexOf("126.com")!=-1){
  			document.getElementById("toemailweb").href="http://email.163.com/";
  		}
  		else if(emailaddress.indexOf("163.com")!=-1){
  			document.getElementById("toemailweb").href="http://email.163.com/";
  		}
  		else if(emailaddress.indexOf("139.com")!=-1){
  			document.getElementById("toemailweb").href="http://mail.10086.cn/";
  		}
  		else if(emailaddress.indexOf("hotmail.com")!=-1){
  			document.getElementById("toemailweb").href="https://login.live.com/";
  		}
  		else if(emailaddress.indexOf("sohu.com")!=-1){
  			document.getElementById("toemailweb").href="http://mail.sohu.com/";
  		}
  		else if(emailaddress.indexOf("sina.com")!=-1){
  			document.getElementById("toemailweb").href="http://mail.sina.com.cn/";
  		}
  		else if(emailaddress.indexOf("yeah.net")!=-1){
  			document.getElementById("toemailweb").href="http://email.163.com/";
  		}
  		else{
  			document.getElementById("toemailweb").href="http://www.hao123.com/mail";
  		}
  });
    
    </script>
</head>
<body id="products" class=" jira en">
<div id="container" class="container">
	<header id="header">
        <jsp:include page="/jsp/utils/head.jsp"></jsp:include>
    </header>
	<div id="contentContainer">
			 <div id="wrapper">
			 <p></p>
          <h3>注册财务外包系统,体验互联网化HR共享服务！</h3>
          <div class="progress">
            <div class="progress-bar progress-bar-success" style="width: 34%">1.填写注册信息
              <span class="sr-only">34% Complete (success)</span>
            </div>
            <div class="progress-bar progress-bar-warning progress-bar-striped" style="width: 33%">2.邮箱验证
              <span class="sr-only">33% Complete </span>
            </div>
            <div class="progress-bar progress-bar-danger" style="width: 33%">3.完善信息
              <span class="sr-only">33% Complete (danger)</span>
            </div>
          </div>
          <div class="row">
            <div style="padding:1em 1em 1em 2.2em">
              <div class="col-lg-1"></div>
              <div class="col-lg-10">
                <div class="row">
                  <div class="col-lg-4">
                    <img src="<%=request.getContextPath() %>/assets/img/email.png" alt="邮箱图标" />
                  </div>
                  <div class="col-lg-8">
                    <h2>就差一步了，快去激活您的账号！</h2>
                    <h2>开启您的HR共享之旅！</h2>
                  </div>
                </div>
                <p id="email" style="text-align: center;">${email} 收到了激活邮件，请尽快激活</p>
                <br>
                <div class="row">
                  <h4 class="col-md-5"></h4>
                  <div class="col-md-4">
                    <button  class="btn btn-success btn-lg" type="submit" onclick="gotoexamemail()"><a id="toemailweb" href="http://www.yeah.net">登录邮箱</a></button>
                  </div>
                  <h4 class="col-md-4"></h4>
                </div>
                <br>

                <div class="container-fluid">
                  <strong>&nbsp;&nbsp;&nbsp;&nbsp;没有收到邮件？</strong>
                  <div class="row-fluid">
                    <div class="col-md-4">
                      <p>确认邮件是否被您提供的邮件系统自动拦截，或被误认为垃圾邮件放到垃圾箱了。</p>
                    </div>
                    <div class="col-md-4">
                      <p>如果超过十分钟仍未收到激活信，请您<button  class="btn btn-link" type="button" onclick="">重新获取激活邮件</button></p>
                    </div>
                    <div class="col-md-4">
                      <p>如果再次发送激活信还没收到，请尝试：<button  class="btn btn-link" type="button" onclick="">更换邮箱注册</button></p>
                    </div>
                  </div>
                  <br>
                </div>
                <br>
              </div>
              <br>
            </div>
            <br>
          </div>
          <br>
        </div>
      </div>
    <footer id="wac-desktop-footer" class="desktop-footer SL_swap" style="height:60px">
        <jsp:include page="/jsp/utils/foot.jsp"></jsp:include>
    </footer>
</div>
</body>
</html>