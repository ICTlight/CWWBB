<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/normalize-water.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/default-water.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/styles-water.css">
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
</head>
<body>
	<main class='container'>
      <div class='wrap'>
      	<input type='checkbox' id='checking' style='display:none;' />
      	<button class='blob'>&#x2605;</button>
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
	
</body>
</html>