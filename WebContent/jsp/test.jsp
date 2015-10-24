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
    
    <style type="text/css">
		/* body { font-family:Arial; font-size:12pt; padding:20px; width:820px; margin:20px auto; border:solid 1px black; } */
		h1 { font-size:16pt; }
		h2 { font-size:13pt; }
		ul { margin:0px; padding:0px; margin-left:20px; }
		#list1, #list2 { width:350px; list-style-type:none; margin:0px; }
		#list1 li, #list2 li { float:left; padding:5px; width:100px; height:100px; }
		#list1 div, #list2 div { width:90px; height:50px; border:solid 1px black; background-color:#E0E0E0; text-align:center; padding-top:40px; }
		#list2 { float:right; }
		.placeHolder div { background-color:white !important; border:dashed 1px gray !important; }
	</style>
	
    <!-- <script type="text/javascript" src="js/jquery-1.11.1.js"></script> -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/jquery.dragsort-0.5.1.js"></script>

	
	<script type="text/javascript">
		$("ul:first").dragsort();
	</script>
	
	<script>
		function storagechecked(){
			var lists2=document.getElementById("list2");
			alert(lists2);
		}
	</script>
</head>
<body id="products" class=" jira en">
<div id="container" class="container">
	<header id="header">
        <jsp:include page="/jsp/utils/head.jsp"></jsp:include>
    </header>
	<div id="contentContainer">
       

		<h2>产品项设置</h2>
	
	<ul id="list2">
		<li><div>10</div></li>
		<li><div>11</div></li>
		<li><div>12</div></li>
		<li><div>13</div></li>
		<li><div>14</div></li>
		<li><div>15</div></li>
		<li><div>16</div></li>
		<li><div>17</div></li>
		<li><div>18</div></li>
	</ul>
	
	<ul id="list1">
		<li><div>1</div></li>
		<li><div>2</div></li>
		<li><div>3</div></li>
		<li><div>4</div></li>
		<li><div>5</div></li>
		<li><div>6</div></li>
		<li><div>7</div></li>
		<li><div>8</div></li>
		<li><div>9</div></li>
	</ul>
	
	<!-- save sort order here which can be retrieved on server on postback -->
	<input name="list1SortOrder" type="hidden" />

	<script type="text/javascript">
		$("#list1, #list2").dragsort({ dragSelector: "div", dragBetween: true, dragEnd: saveOrder, placeHolderTemplate: "<li class='placeHolder'><div></div></li>" });
		
		function saveOrder() {
			var data = $("#list1 li").map(function() { return $(this).children().html(); }).get();
			$("input[name=list1SortOrder]").val(data.join("|"));
		};
	</script>

	<div style="clear:both;"></div>
	<button onclick="storagechecked()">保存</button>
    </div>
    <footer id="wac-desktop-footer" class="desktop-footer SL_swap" style="height:60px">
         <jsp:include page="/jsp/utils/foot.jsp"></jsp:include>
    </footer>
</div>
</body>
</html>