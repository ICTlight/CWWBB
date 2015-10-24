<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0"/>
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
	$(function() {
    	document.getElementById('personal').style.backgroundImage = 'url(<%=request.getContextPath() %>/assets/img/right.png)';
    	var fieldsetCount = $('#formElem').children().length;
    	var current = 1;
    	var stepsWidth	= 0;
        var widths	= new Array();
    	$('#steps .step').each(function(i){
            var $step = $(this);
    		widths[i] = stepsWidth;
            stepsWidth += $step.width();
        });
    	$('#steps').width(stepsWidth);
    	$('#formElem').children(':first').find(':input:first').focus();	
    	
    	$('#renavigation').show();
        $('#tonext').bind('click',function(e){
    		var $this	= $(this);
    		current = document.getElementById("currentpages").value;
    		var prev	= current;
    		$this.closest('ul').find('li').removeClass('selected');
            $this.parent().addClass('selected');
            if(parseInt(current)<4){
    			current = parseInt(current) + 1;
            }else{
            	current = parseInt(current);
            }
    		document.getElementById("currentpages").value = current;
    		if(current !=1){
        		document.getElementById("goback").style.display="";      		  
        	}else{
        		document.getElementById("goback").style.display="none";
        	}
            $('#steps').stop().animate({
                marginLeft: '-' + widths[current-1] + 'px'
            },900,function(){
    			if(current == fieldsetCount)
    				validateSteps();
    			else
    				validateStep(prev);
    			$('#formElem').children(':nth-child('+ parseInt(current) +')').find(':input:first').focus();	
    		});
            e.preventDefault();
        });
    	
        $('#skipdetail').bind('click',function(e){
        	current = 3;
    		var prev	= current;
    		$('#detail').removeClass('selected');
    		current = 4;
    		document.getElementById("currentpages").value = current;
    		
            $('#steps').stop().animate({
                marginLeft: '-' + widths[current-1] + 'px'
            },500,function(){
    			if(current == fieldsetCount)
    				validateSteps();
    			else
    				validateStep(prev);
    			$('#formElem').children(':nth-child('+ parseInt(current) +')').find(':input:first').focus();	
    		});
            e.preventDefault();
        });  
        
         $('#goback').bind('click',function(e){
    		var $this	= $(this);
    		current = document.getElementById("currentpages").value;
    		var prev	= current;
    		$this.closest('ul').find('li').removeClass('selected');
            $this.parent().addClass('selected');
            if(parseInt(current)>1){
    			current = parseInt(current) - 1;
            }else{
            	current = parseInt(current);
            }
    		
    		document.getElementById("currentpages").value = current;
    		
    		if(current !=1){
        		document.getElementById("goback").style.display="";      		  
        	}else{
        		document.getElementById("goback").style.display="none";
        	}
            $('#steps').stop().animate({
                marginLeft: '-' + widths[current-1] + 'px'
            },900,function(){
    			if(current == fieldsetCount)
    				validateSteps();
    			else
    				validateStep(prev);
    			$('#formElem').children(':nth-child('+ parseInt(current) +')').find(':input:first').focus();	
    		});
            e.preventDefault();
        });  
    	
    	$('#formElem > fieldset').each(function(){
    		var $fieldset = $(this);
    		$fieldset.children(':last').find(':input').keydown(function(e){
    			if (e.which == 9){
    				$('#renavigation li:nth-child(' + (parseInt(current)+1) + ') a').click();
    				$(this).blur();
    				e.preventDefault();
    			}
    		});
    	});
    	
    	function validateSteps(){
    		var FormErrors = false;
    		for(var i = 1; i < fieldsetCount; ++i){
    			var error = validateStep(i);
    			if(error == -1)
    				FormErrors = true;
    		}
    		$('#formElem').data('errors',FormErrors);	
    	}
    	
    	function validateStep(step){
    		if(step == fieldsetCount) return;
    		
    		var error = 1;
    		var hasError = false;
    		$('#formElem').children(':nth-child('+ parseInt(step) +')').find(':input:not(button)').each(function(){
    			var $this 		= $(this);
    			var valueLength = jQuery.trim($this.val()).length;
    			
    			if(valueLength == ''){
    				hasError = true;
    				$this.css('background-color','#FFEDEF');
    			}
    			else
    				$this.css('background-color','#FFFFFF');	
    		});
    		var $link = $('#renavigation li:nth-child(' + parseInt(step) + ') a');
    		$link.parent().find('.error,.checked').remove();
    		
    		var valclass = 'checked';
    		if(hasError){
    			error = -1;
    			valclass = 'error';
    		}
    		$('<span class="'+valclass+'"></span>').insertAfter($link);
    		
    		return error;
    	}
    	
    	/* $('#registerButton').bind('click',function(){
    		if($('#formElem').data('errors')){
    			//alert('Please correct the errors in the Form');
    			return false;
    		}	
    	}); */
    });
    function isperson(){
    	var times = document.getElementById("peindex").innerHTML;
		
		if(times == "1"){
			document.getElementById('personal').style.backgroundImage = "none";
			document.getElementById('companal').style.backgroundImage = 'url(<%=request.getContextPath() %>/assets/img/right.png)';
			document.getElementById("peindex").innerHTML="0";
			document.getElementById("role").value="co";
			document.getElementById("codetaildiv").style.display="";//显
       		document.getElementById("pedetaildiv").style.display="none";//
    	}else{
    		document.getElementById('personal').style.backgroundImage = 'url(<%=request.getContextPath() %>/assets/img/right.png)';
    		document.getElementById('companal').style.backgroundImage = "none";
			document.getElementById("peindex").innerHTML="1";
			document.getElementById("role").value="pe";
			document.getElementById("codetaildiv").style.display="none";//显
       		document.getElementById("pedetaildiv").style.display="";//
    	}        	
    }
    function iscompany(){
		var times = document.getElementById("coindex").innerHTML;    		
		if(times == "1"){
			document.getElementById('personal').style.backgroundImage = 'url(<%=request.getContextPath() %>/assets/img/right.png)';
			document.getElementById('companal').style.backgroundImage= "none";
			document.getElementById("coindex").innerHTML=0;
			document.getElementById("role").value="pe";
			document.getElementById("codetaildiv").style.display="none";//显
       		document.getElementById("pedetaildiv").style.display="";//
    	}else{
    		document.getElementById('personal').style.backgroundImage= "none";
    		document.getElementById('companal').style.backgroundImage= 'url(<%=request.getContextPath() %>/assets/img/right.png)';
			document.getElementById("coindex").innerHTML=1;
			document.getElementById("role").value="co";
			document.getElementById("codetaildiv").style.display="";//显
       		document.getElementById("pedetaildiv").style.display="none";//
    	}
    }
    
    </script>
    <script>
    
    function lostusername()
    {
      var input=document.getElementById("username");
      var input_value=input.value;
      if(input_value==""){
      	document.getElementById("usernameInfo").innerHTML="用户名不能为空";
        }else if(input_value.length>20||input_value.length<4){
      	  document.getElementById("usernameInfo").innerHTML="用户名为4-15个位的中文/字母/数字";
        }
      else{
      	  $.ajax( {   
        	      type : "POST",   
        	      url : "<%=request.getContextPath()%>/validateUsername", 
        	      data : {
        	        'username' :$("#username").val()
        	       },  
        	      dataType: "json",   
        	      success : function(data) {   
      	          if(data.info=="success"){   
      	        	document.getElementById("usernameInfo").innerHTML=""; 
      	          }   
      	          else{
      	        	document.getElementById("usernameInfo").innerHTML="该用户名已被注册，请更换";
      	          }   
      	      }
        	  });
        }
    }
    
    function lostemail()
    {
  	  	  var emailformat=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/
            var email_arr = ["qq.com","vip.qq.com","gmail.com","126.com","163.com","139.com","hotmail.com","sohu.com","sina.com","yeah.net"];
  	  	  var input=document.getElementById("email");
  	      var input_value=input.value;
            var loping = input_value.indexOf("@");
            var email_ext = input_value.substr(loping+1);
            //email
            if(document.getElementById('email').value==""){
          	  document.getElementById("emailInfo").innerHTML="邮箱不能为空";
            }
            else if(!emailformat.test(document.getElementById('email').value)){
          	  document.getElementById("emailInfo").innerHTML="请填写有效邮箱，以确保能找回密码";
            }
            else {
  	          $.ajax( {   
  	      	      type : "POST",   
  	      	      url : "<%=request.getContextPath()%>/validateEmail", 
  	      	      data : {
  	      	        'email' :$("#email").val()
  	      	       },  
  	      	      dataType: "json",   
  	      	    success : function(data) {   
  	    	          if(data.info=="success"){   
  	    	        	document.getElementById("emailInfo").innerHTML=""; 
  	    	          }   
  	    	          else{
  	    	        	document.getElementById("emailInfo").innerHTML="该邮箱已被注册，请更换";
  	    	          }   
  	    	      }
  	      	  });
     		}
    }
    function lostpassword()
    {
  	  	  var input=document.getElementById("password");
  	      var input_value=input.value;
            if(document.getElementById('password').value==""){
          	  document.getElementById("passwordInfo").innerHTML="请输入6-15位密码";
            }else if(input_value.length>15||input_value.length<6){
          	  document.getElementById("passwordInfo").innerHTML="请输入6-15位密码";
            }else{document.getElementById("passwordInfo").innerHTML="";}
    }
    function lostidnumber()
    {
  	  	  var input=document.getElementById("idnumber");
  	      var input_value=input.value;
  	    alert("0");
            if(document.getElementById('idnumber').value==""){
            	alert("1");
          	  document.getElementById("idnumberInfo").innerHTML="请输入有效的身份证号码";
            }else if(input_value.length!=0&&input_value.length!=15&&input_value.length!=18){
            	alert("2");
          	  document.getElementById("idnumberInfo").innerHTML="请输入有效的身份证号码";
            }else{alert("3");document.getElementById("idnumberInfo").innerHTML="";}
    }
    
    function lostphone()
    {
  	  	  var phoneformat=/^1[3|4|5|7|8][0-9]\d{4,8}$/
  	  	  var input=document.getElementById("phone");
  	      var input_value=input.value;
            if(document.getElementById('phone').value==""){
            }
            else if(!phoneformat.test(document.getElementById('phone').value)){
          	  document.getElementById("phoneInfo").innerHTML="请填写有效的手机号!";
            }
            else {
            	document.getElementById("phoneInfo").innerHTML=""; 
     		}
    }
    function lostconnectphone()
    {
  	  	  var phoneformat=/^1[3|4|5|7|8][0-9]\d{4,8}$/
  	  	  var input=document.getElementById("connectphone");
  	      var input_value=input.value;
            if(document.getElementById('connectphone').value==""){
            }
            else if(!phoneformat.test(document.getElementById('connectphone').value)){
          	  document.getElementById("connectphonephoneInfo").innerHTML="请填写有效的手机号!";
            }
            else {
            	document.getElementById("connectphoneInfo").innerHTML=""; 
     		}
    }
    function lostphone()
    {
  	  	  var phoneformat=/^1[3|4|5|7|8][0-9]\d{4,8}$/
  	  	  var input=document.getElementById("phone");
  	      var input_value=input.value;
            if(document.getElementById('phone').value==""){
          	  document.getElementById("phoneInfo").innerHTML="手机号不能为空";
            }
            else if(!phoneformat.test(document.getElementById('phone').value)){
          	  document.getElementById("phoneInfo").innerHTML="请填写有效的手机号，以确保能找回密码";
            }
            else {
            	document.getElementById("phoneInfo").innerHTML=""; 
     		}
    }
    
     function lostbank()
    {
      var input=document.getElementById("bankaccount");
      var input_value=input.value;
      if(input_value==""){
    	  document.getElementById("bankInfo").innerHTML="请输入正确的银行卡号";
      }
      else if(input_value!=""&&input_value.length!=19&&input_value.length!=16){
      	  document.getElementById("bankInfo").innerHTML="请输入正确的银行卡号";
        }
      else{
      	  $.ajax( {   
        	      type : "POST",   
        	      url : "<%=request.getContextPath()%>/validatebankaccount", 
        	      data : {
        	        'bankaccount' :$("#bankaccount").val()
        	       },  
        	      dataType: "json",   
        	      success : function(data) {   
      	          if(data.info=="success"){   
      	        	document.getElementById("bankInfo").innerHTML=data.bankInfo;
      	        	document.getElementById("bankname").value=data.bankInfo;
      	          }   
      	          else{
      	        	document.getElementById("bankInfo").innerHTML=data.bankInfo;
      	          }   
      	      }
        	  });
        }
    } 
     
     function lostcompanyids()
     {
       var input=document.getElementById("companyids");
       var input_value=input.value;
       if(input_value==""){
     	  document.getElementById("companyidsInfo").innerHTML="请输入正确的营业执照代码";
       }
       else if(input_value!=""&&input_value.length!=13){
    	   document.getElementById("companyidsInfo").innerHTML="请输入正确的营业执照代码";
         }
       else{
       	  $.ajax( {   
         	      type : "POST",   
         	      url : "<%=request.getContextPath()%>/validatecompanyids", 
         	      data : {
         	        'companyids' :$("#companyids").val()
         	       },  
         	      dataType: "json",   
         	      success : function(data) {   
       	          if(data.info=="success"){  
       	        	document.getElementById("companyidsInfo").innerHTML=data.companyidsInfo;
       	          }   
       	          else{
       	        	document.getElementById("companyidsInfo").innerHTML=data.companyidsInfo;
       	          }   
       	      }
         	  });
         }
     } 
     
     function lostcompanyid()
     {
    	 alert("1");
       var input=document.getElementById("companyid");
       var input_value=input.value;
       if(input_value==""){
    	   alert("2");
     	  document.getElementById("companyidInfo").innerHTML="请输入正确的营业执照代码";
       }
       else if(input_value!=""&&input_value.length!=13){
    	   alert("4");
    	   document.getElementById("companyid").innerHTML="请输入正确的营业执照代码";
         }
       else{
    	   alert("5");
       	  $.ajax( {   
         	      type : "POST",   
         	      url : "<%=request.getContextPath()%>/validatecompanyid", 
         	      data : {
         	        'companyid' :$("#companyid").val()
         	       },  
         	      dataType: "json",   
         	      success : function(data) {   
       	          if(data.info=="success"){  
       	        	document.getElementById("companyidInfo").innerHTML=data.companyidInfo;
       	          }   
       	          else{
       	        	document.getElementById("companyidInfo").innerHTML=data.companyidInfo;
       	          }   
       	      }
         	  });
         }
     } 
    
    function check_data(){
    	var role = document.getElementById('role').value;
    	if(document.getElementById('email').value==""){
            document.getElementById("emailInfo").innerHTML="邮箱不能为空"; 
            return false;
        }
    	if(document.getElementById('username').value==""){
            document.getElementById("usernameInfo").innerHTML="用户名不能为空"; 
            return false;
        }
    	if(document.getElementById('password').value==""){
            document.getElementById("passwordInfo").innerHTML="手机号不能为空"; 
            return false;
        }
    	if(role=="pe"){ 
            var form = document.getElementById("formElem");
            form.action = "${pageContext.request.contextPath}/addperson";   
            form.method = "post";  
            form.submit();  
    	}else{
            var form = document.getElementById("formElem");
            form.action = "${pageContext.request.contextPath}/addcompany";   
            form.method = "post";  
            form.submit();  
    	}    	
        
    }
    </script>
</head>
<body id="products" class=" jira en">
<div id="container" class="container">
	<header id="header">
        <jsp:include page="/jsp/utils/head.jsp"></jsp:include>
    </header>
	<div id="contentContainer">
        <div id="wrapper">
                <div id="steps">
                   <!--  <form id="formElem" name="formElem" action="" method="post"> -->
                    <form id="formElem" name="formElem">
                        <fieldset class="step">
                            <legend>账户</legend>
                            <div class="row"><br></div>
                            <div class="row"><br></div>
                            <p>
                                <label for="username">用户名：</label>
                                <input id="username" name="username" placeholder="请输入4-15位的中文/字母/数字" onblur="lostusername()"/>
                                <small id="usernameInfo" style="color:#FF0000"></small>
                            </p>
                            <div class="row"><br></div>
                            <div class="row"><br></div>
                            <p>
                                <label for="email">邮箱：</label>
                                <input id="email" name="email" placeholder="xxx@yeah.net" type="text" onblur="lostemail()" />
                                <small id="emailInfo" style="color:#FF0000"></small>
                            </p>
                            <div class="row"><br></div>
                            <div class="row"><br></div>
                            <p>
                                <label for="password">密码：</label>
                                <input id="password" name="password" type="password" placeholder="请输入6-15位密码" onblur="lostpassword()" />
                                <small id="passwordInfo" style="color:#FF0000"></small>
                            </p>
                        </fieldset>
                        <fieldset class="step">
                            <legend>角色</legend>
                            <div class="row"><br></div>
                            <div class="row"><br></div>
                            <div class="row"><br></div>
                            <div class="row"><br></div>
                            <input id="role" style="display:none" value="pe"/>
                            <p id="peindex" style="display:none">1</p>
                            <p id="coindex" style="display:none">0</p>
                            <p  onclick="isperson()">
                                <label for="person">个&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人 </label>
                                <label id="personal" style="float:right;right:1px;width:30px; height:30px;"></label>  
                            </p>
                            <div class="row"><br></div>
                            <div class="row"><br></div>
                            <div class="row"><br></div>
                            <div class="row"><br></div>
                            <p  onclick="iscompany()">
                                <label for="company">企&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业</label>
                                <label id="companal" style="float:right;right:1px;width:30px; height:30px;"></label>                                
                            </p>
                            <br>
                        </fieldset>
                        <fieldset id="detail" class="step">
                            <legend>详细信息</legend>  <span><a id="skipdetail" style="margin-right:150px;float:right">跳过&nbsp;&nbsp;&nbsp;&nbsp;</a></span>
                            <div class="row"></div>
                            <div id="pedetaildiv">
                            	<p>
	                                <label for="realname">姓名</label>
	                                <input id="realname" name="realname" type="text"/>
	                                <small id="realnameInfo" style="color:#FF0000"></small>
                            	</p>
                            	<p>
	                                <label for="phone">手机号</label>
	                                <input id="phone" name="phone" type="text" onblur="lostphone()"/>
	                                <small id="phoneInfo" style="color:#FF0000"></small>
                            	</p>
                            	<p>
	                                <label for="idnumber">身份证号</label>
	                                <input id="idnumber" name="idnumber" type="text" onblur="lostidnumber()"/>
	                                <small id="idnumberInfo" style="color:#FF0000"></small>
                            	</p>                            	
                            	<p>
	                                <label for="bankaccount">银行账号</label>
	                                <input id="bankaccount" name="bankaccount" type="text" onblur="lostbank()"/>
	                                <input id="bankname" name="bankname" type="text" style="display:none"/>
	                                <small id="bankInfo" style="color:#FF0000"></small>
                            	</p>
                            	<p>
	                                <label for="companyids">所属公司代码</label>
	                                <input id="companyids" name="companyids" type="text" onblur="lostcompanyids()"/>
	                                <small id="companyidsInfo" style="color:#FF0000"></small>
                            	</p>
                            </div>
                            <div id="codetaildiv" style="display:none">
                            	<p>
	                                <label for="companyname">公司名称</label>
	                                <input id="companyname" name="companyname" type="text" />
	                                <small id="companynameInfo" style="color:#FF0000"></small>
                            	</p>
                            	<p>
	                                <label for="companyid">营业代码</label>
	                                <input id="companyid" name="companyid" type="text" onblur="lostcompanyid()"/>
	                                <small id="companyidInfo" style="color:#FF0000"></small>
                            	</p>
                            	<p>
	                                <label for="address">公司地址</label>
	                                <input id="address" name="address" type="text"/>
	                                <small id="addressInfo" style="color:#FF0000"></small>
                            	</p>
                            	<p>
	                                <label for="connectname">联系人姓名</label>
	                                <input id="connectname" name="connectname" type="text"/>
	                                <small id="connectnameInfo" style="color:#FF0000"></small>
                            	</p>
                            	<p>
	                                <label for="connectphone">联系人电话</label>
	                                <input id="connectphone" name="connectphone" type="text" onblur="lostconnectphone()"/>
	                                <small id="connectphoneInfo" style="color:#FF0000"></small>
                            	</p>
                            </div>
                        </fieldset>
						<fieldset class="step">
                            <legend>确认</legend>
                            <div class="row"><br></div>
                            <div class="row"><br></div>
							<p>
								<strong>HR共享服务</strong><br>
								您的HR团队<br>
								您将拥有一个高效的HR系统<br>
								您将省去应对员工大量的服务请求和重复的问题<br>
								您将省去为完善内部的HR管理流程和手续而消耗脑力<br>
								您将告别为应付繁冗的各类手续、薪资计算直到深夜的日子<br>
							</p>
							<div class="row"><br></div>
                            <div class="row"><br></div>
                            <div class="row"><br></div>
                            <div class="row"><br></div>
                            <p class="submit">
                                 <!-- <button id="registerButton" type="submit">注册</button>  -->
                                 <button id="registerButton" type="button" onclick="check_data();">注册</button> 
                                <!-- <input type="button" value="注册" class="btn btn-info btn-large" onclick="check_data();"> -->
                            </p>
                        </fieldset>
                    </form>
                </div>
                <div id="renavigation" style="display:none;">
                <input id="currentpages" style="display:none" value="1"/>
                    <ul>
                        <li id="goback" style="display:none;">
                            <a href="#">上一步</a>
                        </li>
						<li id="tonext">
                            <a href="#">下一步</a>
                        </li>
                    </ul>
        </div>
    </div>
    
</div>
	<footer id="wac-desktop-footer" class="desktop-footer SL_swap" style="height:60px">
        <jsp:include page="/jsp/utils/foot.jsp"></jsp:include>
    </footer>
    </div>
</body>
</html>