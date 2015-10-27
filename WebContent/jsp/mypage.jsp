<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap-3.0.3.min.css" rel="stylesheet" type="text/css"/>
    <script src="<%=request.getContextPath() %>/bootstrap/js/jquery-2.1.4.min.js"></script>
    <script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap-3.0.3.min.js"></script> 
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/default-test3.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/bootstrap-vertical-menu.css">
</head>
<style>
#myheads{
    width:100%;
    height:105px;
	background: #ffffff;
}
</style>
<script type="text/javascript">
$(function() {
});
function isDaka(){
	document.getElementById("daka").style.display="";
	document.getElementById("gongzi").style.display="none";
}
function isGongzi(){
	document.getElementById("gongzi").style.display="";
	document.getElementById("daka").style.display="none";
}
</script>
<body>
	<%session = request.getSession();   %>
 	<h1 id="usertype" style="display:none" ><%=session.getAttribute("usertype")%></h1>
	<h1 id="userid" style="display:none" ><%=session.getAttribute("userid")%></h1>
	<h1 id="username" style="display:none" ><%=session.getAttribute("username")%></h1>
	<h1 id="status" style="display:none" ><%=session.getAttribute("status")%></h1>
	<h1 id="email" style="display:none" ><%=session.getAttribute("email")%></h1> 
	
	<nav class="navbar navbar-vertical-left">
	    <ul class="nav navbar-nav">
	      <li>
	        <a href="">
	          <i class="fa fa-fw fa-lg fa-home"></i> 
	          <span>我的</span>
	        </a>
	      </li>
	      <li>
	        <a  onclick="isDaka()">
	          <i class="fa fa-fw fa-lg fa-comments-o"></i> 
	          <span>打卡</span>
	        </a>
	      </li>
	      <li>
	        <a  onclick="isGongzi()">
	          <i class="fa fa-fw fa-lg fa-comments-o"></i> 
	          <span>薪酬计算</span>
	        </a>
	      </li>
	      <li>
	        <a href="">
	          <i class="fa fa-fw fa-lg fa-desktop"></i> 
	          <span>公司人员</span>
	        </a>
	      </li>
	    </ul>
	</nav>
	<div id="gongzi" class="htmleaf-container">
		<div id="myheads" class="row-fluid">
			<div class="col-lg-1"></div>
			<div class="col-lg-11">
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;工作台</h2>
				<ul class="breadcrumb" style="background: #ffffff;">
					<li>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="">工资模板</a> &nbsp;&nbsp;&nbsp;&nbsp;
					</li>
					<li>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="">工资计算</a> <!-- <span class="divider"></span> -->
					</li>
				</ul>
			</div>
		</div>		
		<div>
		</div>
	</div>
	<div id="daka" class="htmleaf-container"  style="display:none">
		<div id="myheads" class="row-fluid">
			<div class="col-lg-1"></div>
			<div class="col-lg-11">
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;工作台</h2>
				<ul class="breadcrumb" style="background: #ffffff;">
					<li>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="">打卡功能1</a> &nbsp;&nbsp;&nbsp;&nbsp;
					</li>
					<li>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="">打卡功能2</a>
					</li>
				</ul>
			</div>
		</div>		
		<div>
		</div>
	</div>
	
</body>
</html>