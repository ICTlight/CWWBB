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
	<script src="<%=request.getContextPath() %>/assets/js/jquery.gridly.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath() %>/assets/js/rainbow-gridly.js" type="text/javascript"></script>
	<link href="<%=request.getContextPath() %>/assets/css/jquery.gridly.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/assets/css/sample-gridly.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/common.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/plugins.form-components.js"></script>  
	<script type="text/javascript" src="<%=request.getContextPath() %>/plugins/validation/jquery.validate.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/plugins/validation/jquery.validate.message_cn.js"></script> 
    <script type="text/javascript" src="<%=request.getContextPath() %>/plugins/validation/additional-methods.min.js"></script> 
	<script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/jquery.dragsort-0.5.1.js"></script>		
	<style>
		#myheads{
		    width:100%;
		    height:108px;
			background: #ffffff;
		}
	</style>
	<script type="text/javascript">
	
		$(function() {
			$(document).on("hidden.bs.modal", function (e) {
			    $(e.target).removeData("bs.modal").find(".modal-content").empty();
			});
			//默认选择tab
	          $("#salTab a:first").tab('show');//初始化显示哪个tab   
	          //tab点击事件
	          $("#salTab a").click(function (e) {
	        	//以下tab为薪酬计算用   	  
	         	  if($(this).attr("href") =="#tab_1_1"){	 
		         	  $(this).tab('show');	
	         	  }		   				   		
	                              
	              if($(this).attr("href") =="#tab_1_2") { 
	            	  $(this).tab('show');                  
	              }
	              
	              //以下tab为打卡用
	              if($(this).attr("href") =="#tab_2_1"){	 
		         	  $(this).tab('show');	
	         	  }		   				   		
	                              
	              if($(this).attr("href") =="#tab_2_2") { 
	            	  $(this).tab('show');                  
	              }
	          }); 
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
	<script type="text/javascript">
	$(document).ready(function(){
		//动态添加现有工资模板
		$.ajax({  
	     	type : "POST",
	 		url : "<%=request.getContextPath() %>/getSalDemoLists",
	 		async : false,
	 		dataType : "json",
	 		success : function(result){
	 			if(result != null && result.length > 0) {
 			       for(var i = 0; i<result.length; i++) {
 			    	   var name = result[i].saldemoname;
 					    var id = result[i].saldemoid; 					    
 					    brick = '<div id="'+id+'" class="brick small demos"><a class="delete" href="#"">&times;</a>'+name+'</div>';
 				      event.preventDefault();
 				      event.stopPropagation();
 				      $('.gridly').append(brick);
		       		}
 			      return $('.gridly').gridly();
	 			}	 			
	 		}
	      }); 
	});
	</script>
	
	<!-- 工资模板相关 -->
	<script type="text/javascript">
		  $(function() {
		    var brick;
		    $(document).on("click", ".gridly .brick", function(event) {
		      var $this, size,$thisid;
		      event.preventDefault();
		      event.stopPropagation();
		      $this = $(this);
		      $thisid = this.getAttribute('id');
		      $this.toggleClass('small');
		      $this.toggleClass('large');
		      if ($this.hasClass('small')) {
		        size = 140;
		        document.getElementById('currentdemoid').value = "";
		        torefresh();
		      }
		      if ($this.hasClass('large')) {
		    	  for(var i=0;i<document.getElementsByClassName("demos").length;){		    		  
		    		  var currentid = document.getElementsByClassName("demos")[i].getAttribute('id');
		    		 if(currentid!=$thisid){		    			 
		    			 document.getElementById(currentid).remove();
		    		 }else{i++;}
		    	  }
		    	  document.getElementById('currentdemoid').value = $thisid;
		    	  $('.adddemosbt').attr("style","display:none");
		    	  $("#productdemo").addClass("col-md-4");
		    	  $('#productdetail').attr("style","display:");
		    	  $('#productpel').attr("style","display:");
		          size = 300;
		          toadddemoeles();
		          toadddemosteles();
		          toadddemopels();
		      }
		      $this.data('width', size);
		      $this.data('height', size);
		      return $('.gridly').gridly('layout');
		    });
		    $(document).on("click", ".gridly .delete", function(event) {
		      var $this;
		      event.preventDefault();
		      event.stopPropagation();
		      $this = $(this);
		      $this.closest('.brick').remove();		      
		      torefresh();
		      return $('.gridly').gridly('layout');
		    });
		     $(document).on("click", ".add", function(event) {
		    	 openadddemo();		    	  
		    }); 
		    return $('.gridly').gridly();
		  });
	</script>
	
		<!-- 工资模板项相关 -->
	<script type="text/javascript">
		  $(function() {
		    var brick;

		    $(document).on("click", ".elegridly .delete", function(event) {
		      var $this;
		      event.preventDefault();
		      event.stopPropagation();
		      $this = $(this);
		      $this.closest('.brick').remove();		      
		      torefresh();
		      return $('.elegridly').gridly('layout');
		    });
		    $(document).on("click", ".addele", function(event) {
		    	openaddele();
		    });
		    return $('.elegridly').gridly(); 
		  });
	</script>
	
	<!-- 社保公积金项相关 -->
	<script type="text/javascript">
		  $(function() {
		    var brick;
		    $(document).on("click", ".standgridly .delete", function(event) {
		      var $this;
		      event.preventDefault();
		      event.stopPropagation();
		      $this = $(this);
		      $this.closest('.brick').remove();		      
		      torefresh();
		      return $('.standgridly').gridly('layout');
		    });
		    $(document).on("click", ".addstandele", function(event) {
		    	openaddstele();
		    });
		    return $('.standgridly').gridly(); 
		  });
	</script>
	
	<!-- 员工相关 -->
	<script type="text/javascript">
		  $(function() {
		    var brick;
		    $(".pelgridly .brick").dblclick( function () { 
		    	openupdatepel();		    	
		    });
		    $(document).on("click", ".pelgridly .delete", function(event) {
		      var $this;
		      event.preventDefault();
		      event.stopPropagation();
		      $this = $(this);
		      $this.closest('.brick').remove();		      
		      torefresh();
		      return $('.pelgridly').gridly('layout');
		    });
		    $(document).on("click", ".addpel", function(event) {
		    	opeaddpel();
		    });
		    return $('.pelgridly').gridly(); 
		  });
	</script>
	<script type="text/javascript">
		function torefresh(){
			var torefresh = document.getElementById("togongzipage");
	      	torefresh.click();
		}
		function torefreshdemo(){
			var currentdemo = document.getElementById('currentdemoid'); 
			torefresh();
			currentdemo.click();
		}
		function openadddemo(){
			$("#href_addsal").html("");
	    	openAddModal("addsaldemoModel","<%=request.getContextPath() %>/addsaldemoInfo","href_addsal");
		}
		
		//动态添加模板项 
		function toadddemoeles(){
			//动态添加现有工资模板
			var demoid_st = document.getElementById('currentdemoid').value; 
			
			$.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getSalDemoeleLists?demoid_st=" + demoid_st,
		 		async : false,
		 		dataType : "json",
		 		success : function(result){
		 			if(result != null && result.length > 0) {
	 			       for(var i = 0; i<result.length; i++) {
	 			    	   var id = result[i].eleid;
	 					    var name = result[i].elename; 	 					    
	 					    brick = '<div id="'+id+'" class="brick small eles" ondblclick="openupdateele('+id+')'+'"><a class="delete" href="">&times;</a>'+name+'</div>';
	 					    event.preventDefault();
	 				      event.stopPropagation();
	 				      $('.elegridly').append(brick);
			       		}
	 			      return $('.elegridly').gridly();
		 			}	 			
		 		}
		      }); 
		}

		//动态添加社保公积金项 
		function toadddemosteles(){
			//动态添加现有工资模板
			var demoid_st = document.getElementById('currentdemoid').value; 
			
			$.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getSalDemosteleLists?demoid_st=" + demoid_st,
		 		async : false,
		 		dataType : "json",
		 		success : function(result){
		 			if(result != null && result.length > 0) {
	 			       for(var i = 0; i<result.length; i++) {
	 			    	   var id = result[i].eleid;
	 					    var name = result[i].elename; 	 					    
	 					    brick = '<div id="'+id+'" class="brick small eles"><a class="delete" href="">&times;</a>'+name+'</div>';
	 					    event.preventDefault();
	 				      event.stopPropagation();
	 				      $('.standgridly').append(brick);
			       		}
	 			      return $('.standgridly').gridly();
		 			}	 			
		 		}
		      }); 
		}
		
		//动态添加员工
		function toadddemopels(){
			//动态添加现有工资模板
			var demoid_st = document.getElementById('currentdemoid').value; 
			
			$.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getSalPelLists?demoid_st=" + demoid_st,
		 		async : false,
		 		dataType : "json",
		 		success : function(result){
		 			if(result != null && result.length > 0) {
	 			       for(var i = 0; i<result.length; i++) {
	 			    	   var id = result[i].peid;
	 					    var name = result[i].pename; 	 					    
	 					    brick = '<div id="'+id+'" class="brick small pels" ondblclick="openupdatepel('+id+')'+'"><a class="delete" href="">&times;</a>'+name+'</div>';
	 					    event.preventDefault();
	 				      event.stopPropagation();
	 				      $('.pelgridly').append(brick);
			       		}
	 			      return $('.pelgridly').gridly();
		 			}	 			
		 		}
		      }); 
		}
		function openaddele(){
			var demoid_st = document.getElementById('currentdemoid').value; 
			$("#href_addele").html("");
			$.ajax({
				type : "POST",
				url : "<%=request.getContextPath() %>/addsaleleInfo?demoid_st=" + demoid_st,	
				async : false,
				dataType : "html",
				success : function(result){
					$("#href_addele").html(result);
					$("#addsaleleModel").modal("show");
				}
			});  				
		}
		function openaddstele(){
			var demoid_st = document.getElementById('currentdemoid').value; 
			$("#href_addele").html("");
			$.ajax({
				type : "POST",
				url : "<%=request.getContextPath() %>/addsalsteleInfo?demoid_st=" + demoid_st,	
				async : false,
				dataType : "html",
				success : function(result){
					$("#href_addele").html(result);
					$("#addsalsteleModel").modal("show");
				}
			});  				
		}
		
		function opeaddpel(){
			var demoid_st = document.getElementById('currentdemoid').value; 
			$("#href_addpel").html("");
			$.ajax({
				type : "POST",
				url : "<%=request.getContextPath() %>/addsalpelInfo?demoid_st=" + demoid_st,	
				async : false,
				dataType : "html",
				success : function(result){
					$("#href_addpel").html(result);
					$("#addsalpelModel").modal("show");
				}
			});  	
		}
		function openupdatepel(id){
			var peid = id; 
			$("#href_addpel").html("");
			$.ajax({
				type : "POST",
				url : "<%=request.getContextPath() %>/updatesalpelInfo?peid=" + peid,	
				async : false,
				dataType : "html",
				success : function(result){
					$("#href_addpel").html(result);
					$("#updatesalpelModel").modal("show");
				}
			});  
			
	  		<%-- $("#href_addpel").html("");
	    	openAddModal("updatesalpelModel","<%=request.getContextPath() %>/updatesalpelInfo","href_addpel");	 --%>
		}
		function openupdateele(id){			
			var eleid = id; 
			alert("eleid....."+eleid);
			$("#href_addele").html("");
			$.ajax({
				type : "POST",
				url : "<%=request.getContextPath() %>/updatesaleleInfo?eleid=" + eleid,	
				async : false,
				dataType : "html",
				success : function(result){
					$("#href_addele").html(result);
					$("#updatesaleleModel").modal("show");
				}
			});   	  			
		}
	</script>
</head>

<body>
	<%session = request.getSession();%>
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
		<a id="togongzipage" href="/CWWBB/jsp/mypage.jsp" style="display:none"></a>
		<!-- <h1 id="currentdemoid" style="display:none" ></h1> -->
		<input type="text" style="display:none" name="currentdemoid"  id="currentdemoid" />
		<div id="myheads" class="row-fluid">
			<div class="col-lg-1"></div>
			<div class="col-lg-11">
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;工作台</h2>
                 <div class="tabbable tabbable-custom">
                     <ul class="nav nav-tabs" id="salTab">
                          <li><a href="#tab_1_1">&nbsp;&nbsp;&nbsp;&nbsp;薪酬模板&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
                          <li><a href="#tab_1_2">&nbsp;&nbsp;&nbsp;&nbsp;薪酬计算&nbsp;&nbsp;&nbsp;&nbsp;</a></li>                          
                     </ul>
                     <br>
                     <div class="tab-content">
                         <div class="tab-pane" id="tab_1_1"> 
                         	<div id="gzpdbody" class="row-fluid">
			<!-- <div class="col-lg-1"></div> -->
			<div class="col-lg-9">
				<div  class='content row'>			      
			      <div id="productdemo" class='example'>
			        <div class='gridly'>
			        </div>
			        <p class='actions adddemosbt'>
			          <button id="adddemobt"  class="add button" data-target="#addsaldemoModel" data-toggle="modal" >添加工资模板</button>        
			        </p>
			        <div id="href_addsal"></div>
			      </div>
			      
			      <div id="productdetail" class="col-md-7" style="display:none">
				      <div id="productele" class="exampleele row" >
				    	<div class='elegridly'>
				           <!-- <div id="ele1" class='brick small eles' ondblclick="openupdateele('10000000')"><a class='delete' href='#'>&times;</a>基本工资</div>
				          <div id="ele2" class='brick small eles'>
				            <a class='delete' href='#'>&times;</a>绩效</div>
				          <div id="ele3" class='brick small eles'>
				            <a class='delete' href='#'>&times;</a>差补</div>
				          <div id="ele4" class='brick small eles'><a class='delete' href='#'>&times;</a>房补</div>
				          <div id="ele5" class='brick small eles'><a class='delete' href='#'>&times;</a>交通补助</div> --> 
				        </div>
				        <p class='actions addelebt'>
				          <!-- <a class='button addele' data-target="#addsaleleModel" data-toggle="modal">添加模板项</a> -->
				          <button class="addele button" data-target="#addsaleleModel" data-toggle="modal" >添加基本项</button>	
				        </p>
				        <button id="updateelebt" style="display:none" class="btn" data-target="#updatesaleleModel" data-toggle="modal" onclick="openaddele()" ></button>
				        <div id="href_addele"></div>
				    </div>
				    <div id="standsalele" class="exampleele row" >
				    	<div class='standgridly'>
				          <!-- <div id="ele1" class='brick small eles' ondblclick="openupdateele('10000000')"><a class='delete' href='#'>&times;</a>基本工资</div>
				          <div id="ele2" class='brick small eles'>
				            <a class='delete' href='#'>&times;</a>绩效</div>
				          <div id="ele3" class='brick small eles'>
				            <a class='delete' href='#'>&times;</a>差补</div>
				          <div id="ele4" class='brick small eles'><a class='delete' href='#'>&times;</a>房补</div>
				          <div id="ele5" class='brick small eles'><a class='delete' href='#'>&times;</a>交通补助</div> --> 
				        </div>
				        <p class='actions addelebt'>
				          <button class="addstandele button" data-target="#addsalsteleModel" data-toggle="modal" >添加社保公积金项</button>	
				        </p>
				        <!-- <button id="updatestelebt" style="display:none" class="btn" data-target="#updatesaleleModel" data-toggle="modal" onclick="openaddele()" ></button> -->
				        <div id="href_addele"></div>
				    </div>
				      
			    </div>
			    </div>
			    <div id="productpel" class="examplepel row" style="display:none">
				    	<div class='pelgridly'>
				          <!-- <div id="pel1" class='brick small pels'>
				            <a class='delete' href='#'>&times;</a>张三</div>
				          <div id="pel2" class='brick small pels'>
				            <a class='delete' href='#'>&times;</a>李四</div>
				          <div id="pel3" class='brick small pels'>
				            <a class='delete' href='#'>&times;</a>王五</div>
				          <div id="pel4" class='brick small pels'><a class='delete' href='#'>&times;</a>赵六</div>
				          <div id="pel5" class='brick small pels'><a class='delete' href='#'>&times;</a>大七子</div> -->
				        </div>
				        <p class='actions addpelbt'>
				          <button class="addpel button" data-target="#addsalpelModel" data-toggle="modal">添加员工</button>
				        </p>
				        <button id="addpelbt" style="display:none" class="btn btn-primary btn-large" data-target="#updatesalpelModel" data-toggle="modal" onclick="openaddpel()" ></button>
				        <div id="href_addpel"></div>
				         
				    </div>
		    </div>
		    <div class="col-lg-2"></div>
		</div>                               
                         </div>                             
                         <div class="tab-pane active" id="tab_1_2">
                         	<h2>敬请期待！！！</h2>
	            		 </div>
	            	</div>
	            </div> 
			</div>
		</div>				
	</div>
	<div id="daka" class="htmleaf-container"  style="display:none">
		<div id="myheads" class="row-fluid">
			<div class="col-lg-1"></div>
			<div class="col-lg-11">
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;工作台</h2>
				<div class="tabbable tabbable-custom">
                     <ul class="nav nav-tabs" id="salTab">
                          <li><a href="#tab_2_1">&nbsp;&nbsp;&nbsp;&nbsp;打卡功能1&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
                          <li><a href="#tab_2_2">&nbsp;&nbsp;&nbsp;&nbsp;打卡功能2&nbsp;&nbsp;&nbsp;&nbsp;</a></li>                          
                     </ul>
                     <br>
                     <div class="tab-content">
                         <div class="tab-pane" id="tab_2_1"> 
                         	<h2>敬请期待！！！</h2>    
                         </div>                             
                         <div class="tab-pane active" id="tab_2_2">
                         	<h2>敬请期待！！！</h2>
	            		 </div>
	            	</div>
	            </div>	
			</div>
		</div>		
		<div>
		</div>
	</div>
	
</body>
</html>