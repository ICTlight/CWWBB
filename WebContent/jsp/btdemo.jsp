<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap-3.0.3.min.css" rel="stylesheet" type="text/css"/>
  <script src="<%=request.getContextPath() %>/bootstrap/js/jquery-2.1.4.min.js"></script>
  <script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap-3.0.3.min.js"></script> 
  <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/jira.css" type="text/css" media="all">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/common.css" type="text/css">
  <script src="<%=request.getContextPath() %>/assets/js/1096093.js"></script>
  <script src="<%=request.getContextPath() %>/assets/js/atl-analytics.min.js"></script>
  <script src="<%=request.getContextPath() %>/assets/js/global.js"></script>
  <script src="<%=request.getContextPath() %>/assets/js/jquery-waypoints.js"></script>
  <script src="<%=request.getContextPath() %>/assets/js/product-tour-template.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/conversion.js"></script>
  
  <title>财务外包--首页</title>    


    
	
</head>
<body id="products" class=" jira en">
<div id="container" class="container-fluid">
	<header id="header">
        <jsp:include page="/jsp/utils/head.jsp"></jsp:include>
    </header>
	<div id="contentContainer">

	</div>
	<footer id="wac-desktop-footer" class="desktop-footer SL_swap" style="height:60px">
         <jsp:include page="/jsp/utils/foot.jsp"></jsp:include>
    </footer>
</div>
</body>
</html>