<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0"/>
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
  
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/normalize-water.css" />
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/default-water.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/styles-water.css">
  <title>财务外包--首页</title>    


    
	
</head>
<body id="products" class=" jira en">
<div id="container" class="container">
	<header id="header">
        <jsp:include page="/jsp/utils/head.jsp"></jsp:include>
    </header>
	<div id="contentContainer">
		<main class='container'>
	      <div class='wrap'>
	      	<input type='checkbox' id='checking' style='display:none;' />
	      	<button class='blob'>我</button>
	      	<button class='blob'>&#x2709;</button>
	      	<button class='blob'>&#x2699;</button>
	      	<button class='blob'>&#x2764;</button>
	      	<button class='blob'>&#x270C;</button>
	      	<button class='blob'>&#x270E;</button>
	      	<button class='blob'>&#x266B;</button>
	      	<button class='blob'>&#x2706;</button>
	      	<label class='blob' for='checking'>
	          <span class='bar'></span>      
	          <span class='bar'></span>
	          <span class='bar'></span>
	        </label>
	      </div>
	      <div class='writingshit'>
	        
	      </div>
	    </main>
	    <svg>
			<defs>
				<filter id="filt">
					<feGaussianBlur in="SourceGraphic" result="blur" stdDeviation="10" />
					<feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7" result="filt" />
					<feBlend in2="filt" in="SourceGraphic" result="mix" />
				</filter>
			</defs>
		</svg>
	</div>
	<footer id="wac-desktop-footer" class="desktop-footer SL_swap" style="height:60px">
         <jsp:include page="/jsp/utils/foot.jsp"></jsp:include>
    </footer>
</div>
</body>
</html>