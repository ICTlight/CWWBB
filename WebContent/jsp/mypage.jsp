<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@include file="/jsp/utils/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <%@include file="/jsp/utils/meta.jsp" %> 
  <%@include file="/jsp/utils/common_css.jsp" %> 
  <%@include file="/jsp/utils/common_js.jsp" %> 
  <%@include file="/jsp/utils/mypage_js.jsp" %>	 
    	
	<style>
		#myheads{
		    width:100%;
		    height:108px;
			background: #ffffff;
		}
	</style>
	<script type="text/javascript">
		$(function() {
			
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
 					    brick = '<div id="'+id+'" class="brick small demos"><a class="delete" onclick="deldemo('+id+')">&times;</a><h4>'+name+'</h4></div>';
 				      event.preventDefault();
 				      event.stopPropagation();
 				      $('.gridly').append(brick);
		       		}
 			      return $('.gridly').gridly();
	 			}	 			
	 		}
	      }); 
		
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
 					    brick = '<div id="cp'+id+'" class="brick small cpdemos"><h4>'+name+'</h4></div>';
 				      event.preventDefault();
 				      event.stopPropagation();
 				      $('.cpgridly').append(brick);
		       		}
 			      return $('.cpgridly').gridly();
	 			}	 			
	 		}
	      }); 
	});
	</script>
	<!-- 薪酬计算tab相关 -->
	<script type="text/javascript">
		  $(function() {
		    var brick;
		    $(".cpgridly .brick").dblclick( function(event) { 
		    	var $this, size,$thisid;
			      event.preventDefault();
			      event.stopPropagation();
			      $this = $(this);
			      $thisid = this.getAttribute('id');
			      $this.toggleClass('small');
			      $this.toggleClass('large');
			      if ($this.hasClass('small')) {
			        size = 140;
			        document.getElementById('cpcurrentdemoid').value = "";
			        torefreshcp();
			      }
			      if ($this.hasClass('large')) {
			    	  for(var i=0;i<document.getElementsByClassName("cpdemos").length;){		    		  
			    		  var currentid = document.getElementsByClassName("cpdemos")[i].getAttribute('id');
			    		 if(currentid!=$thisid){		    			 
			    			 document.getElementById(currentid).remove();
			    		 }else{i++;}
			    	  }
			    	  document.getElementById('cpcurrentdemoid').value = $thisid;
			    	  $("#computedemo").addClass("col-md-4");
			    	  //$('#computedetail').attr("style","display:");
			    	  $('#computepeizhi').attr("style","display:");
			          size = 300;
			          //toaddcpeles($thisid);
			          findpay($thisid);
			      }
			      $this.data('width', size);
			      $this.data('height', size);
			      return $('.cpgridly').gridly('layout');
		    }); 
		    return $('.cpgridly').gridly();
		  });
	</script>
	<!-- 工资模板相关 -->
	<script type="text/javascript">
		  $(function() {
		    var brick;
		    $(".gridly .brick").dblclick( function(event) { 
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
		    $(document).on("click", ".addpel", function(event) {
		    	opeaddpel();
		    });
		    return $('.pelgridly').gridly(); 
		  });
	</script>
	<script type="text/javascript">
		function torefreshcp(){
			var torefresh = document.getElementById("togongzipage");
	      	torefresh.click();  
		}
		function gotocompute(){
			var demoid_st = document.getElementById('cpcurrentdemoid').value;
			demoid = demoid_st.substr(2,demoid_st.length);
	    	$.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getSalPayLists?demoid_st=" + demoid,
		 		async : false,
		 		dataType : "json",
		 		success : function(result){
		 			findpay(demoid_st);	
		 			alert("计算成功！");
		 		}
		      });  
		}
		function findpay(demoid_st){
			$("#cpbody").html("");
			$("#cpheads").html("");			
			var demoid = demoid_st.substr(2,demoid_st.length);
			  $.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getPayLists?demoid_st=" + demoid,
		 		async : false,
		 		dataType : "json",
		 		success : function(result){
		 			if(result != null && result.length > 0) {
		 									
	 			        for(var i = 0; i<result[1].length; i++) {
	 			    	   var infos = result[1][i].substr(1,result[1].length-1).split(",");
	 			    	   var id = infos[1].substr(1,infos[1].length-1);
	 					   var name = infos[0].substr(1,infos[0].length-2); 	 					    
	 					   var colhead = '<th id="'+id+'" data-sortable="true">'+name+'</th>';
	 					  $('#cpheads').append(colhead);
			       		}
	 			       var elelist =result[2];	
	 			        for(var k = 0; k<result[0].length; k++) {
	 			    	   
	 			    	   var pays = result[0][k];
	 			    	   var rowitem = '<tr id="'+result[0][k].peid+'">';
	 			    	   for(var j = 0;j<result[2].length;j++){
	 			    		   var its = elelist[j];
	 			    		   var itss = its.toLocaleLowerCase();
	 			    		  rowitem += '<td>'+result[0][k][itss]+'</td>';
	 			    	   }
	 			    	  rowitem += '</tr>';	 					    
	 					  $('#cpbody').append(rowitem);
			       		}	 			        
		 			}	 			
		 		}
		      });  
		}
		function torefresh(){
			var torefresh = document.getElementById("togongzipage");
	      	torefresh.click();
		}
		 
		function openadddemo(){
			$("#href_addsal").html("");
	    	openAddModal("addsaldemoModel","<%=request.getContextPath() %>/addsaldemoInfo","href_addsal");
		}
		function toadddemos(){
			$("#productarea").html("");
			//动态添加现有工资模板
			$.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getSalDemoLists",
		 		async : true,
		 		dataType : "json",
		 		success : function(result){
		 			if(result != null && result.length > 0) {
	 			       for(var i = 0; i<result.length; i++) {
	 			    	   var name = result[i].saldemoname;
	 					    var id = result[i].saldemoid; 					    
	 					    brick = '<div id="'+id+'" class="brick small demos"><a class="delete" onclick="deldemo('+id+')">&times;</a><h4>'+name+'</h4></div>';
	 				      event.preventDefault();
	 				      event.stopPropagation();
	 				      $('.gridly').append(brick);
			       		}
	 			      return $('.gridly').gridly();
		 			}	 			
		 		}
		      }); 
		}
		//动态添加模板项 
		function toadddemoeles(){
			
			$("#productelearea").html("");
			//动态添加现有工资模板
			var demoid_st = document.getElementById('currentdemoid').value; 
			$.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getSalDemoeleLists?demoid_st=" + demoid_st,
		 		async : true,
		 		dataType : "json",
		 		success : function(result){
		 			if(result != null && result.length > 0) {
	 			       for(var i = 0; i<result.length; i++) {
	 			    	   var id = result[i].eleid;
	 					    var name = result[i].elename; 	 					    
	 					    brick = '<div id="'+id+'" class="brick small eles" ondblclick="openupdateele('+id+')'+'"><a class="delete" onclick="delele('+id+')">&times;</a><h5>'+name+'</h5></div>';	   
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
			$("#productstelearea").html("");
			//动态添加现有工资模板
			var demoid_st = document.getElementById('currentdemoid').value; 			
			$.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getSalDemosteleLists?demoid_st=" + demoid_st,
		 		async : true,
		 		dataType : "json",
		 		success : function(result){
		 			if(result != null && result.length > 0) {
	 			       for(var i = 0; i<result.length; i++) {
	 			    	   var id = result[i].eleid;
	 					    var name = result[i].elename; 	 					    
	 					    brick = '<div id="'+id+'" class="brick small eles"><a class="delete"  onclick="delstele('+id+')">&times;</a><h5>'+name+'</h5></div>';
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
			$("#productpelarea").html("");
			//动态添加现有工资模板
			var demoid_st = document.getElementById('currentdemoid').value; 			
			$.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getSalPelLists?demoid_st=" + demoid_st,
		 		async : true,
		 		dataType : "json",
		 		success : function(result){
		 			if(result != null && result.length > 0) {
	 			       for(var i = 0; i<result.length; i++) {
	 			    	   var id = result[i].peid;
	 					    var name = result[i].pename; 	 					    
	 					    brick = '<div id="'+id+'" class="brick small pels" ondblclick="openupdatepel('+id+')'+'"><a class="delete"  onclick="delpel('+id+')">&times;</a><h5>'+name+'</h5></div>';
	 					    event.preventDefault();
	 				      event.stopPropagation();
	 				      $('.pelgridly').append(brick);
			       		}
	 			      return $('.pelgridly').gridly();
		 			}	 			
		 		}
		      }); 
		}
		
		/*========================= 添加基本项、社保公积金项、员工相关 ================================*/
		function openaddele(){
			var demoid_st = document.getElementById('currentdemoid').value; 
			$("#href_addele").html("");
			$.ajax({
				type : "POST",
				url : "<%=request.getContextPath() %>/addsaleleInfo?demoid_st=" + demoid_st,	
				async : true,
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
				async : true,
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
				async : true,
				dataType : "html",
				success : function(result){
					$("#href_addpel").html(result);
					$("#addsalpelModel").modal("show");
				}
			});  	
		}
		/*========================= 基本项、员工修改相关 ================================*/
		function openupdatepel(id){
			var peid = id; 
			var demoid_st = document.getElementById('currentdemoid').value;
			$("#href_addpel").html("");
			$.ajax({
				type : "POST",
				url : "<%=request.getContextPath() %>/updatesalpelInfo?peid=" + peid+"&demoid_st="+demoid_st,	
				async : true,
				dataType : "html",
				success : function(result){
					$("#href_addpel").html(result);
					$("#updatesalpelModel").modal("show");
				}
			});  
		}
		function openupdateele(id){			
			var eleid = id; 
			$("#href_addele").html("");
			$.ajax({
				type : "POST",
				url : "<%=request.getContextPath() %>/updatesaleleInfo?eleid=" + eleid,	
				async : true,
				dataType : "html",
				success : function(result){
					$("#href_addele").html(result);
					$("#updatesaleleModel").modal("show");
				}
			});   	  			
		}
		
		/*========================= 删除模板、基本项、社保公积金项、员工相关 ================================*/
		function deldemo(id){
			var sure = window.confirm("确定要删除该记录吗?");
     	   	 if(sure){
			var thisid=id;
			var $this = document.getElementById(thisid);
				$.ajax({
					type : "POST",
					url : "<%=request.getContextPath() %>/deldemo",
					data: {"thisid" : thisid},
					async : true,
					dataType : "json",
					success : function(result) {
					    if(result.message == "success") {
					    	   alert("删除成功");
						       $this.closest('.brick').remove();		      
							    return $('.gridly').gridly('layout');
					    } else {
					    	 alert("删除失败");
					    	 return false;
					   }
					}						
				});
  		}}
		function delele(id){
			var sure = window.confirm("确定要删除该记录吗?");
     	   	if(sure){
				var thisid=id;
				var $this = document.getElementById(thisid);
				$.ajax({
					type : "POST",
					url : "<%=request.getContextPath() %>/delele",
					data: {"thisid" : thisid},
					async : true,
					dataType : "json",
					success : function(result) {
					    if(result.message == "success") {
					    	   alert("删除成功");
						       $this.closest('.brick').remove();		      
							    return $('.elegridly').gridly('layout');
					    } else {
					    	 alert("删除失败");
					    	 return false;
					   }
					}						
				});
  			}
  		}
		function delstele(id){
			var sure = window.confirm("确定要删除该记录吗?");
     	   	if(sure){
				var thisid=id;
				var $this = document.getElementById(thisid);
				$.ajax({
					type : "POST",
					url : "<%=request.getContextPath() %>/delstele",
					data: {"thisid" : thisid},
					async : true,
					dataType : "json",
					success : function(result) {
					    if(result.message == "success") {
					    	   alert("删除成功");
						       $this.closest('.brick').remove();		      
							    return $('.standgridly').gridly('layout');
					    } else {
					    	 alert("删除失败");
					    	 return false;
					   }
					}						
				});
  			}
     	}
		function delpel(id){
			var sure = window.confirm("确定要删除该记录吗?");
     	   	if(sure){
				var thisid=id;
				var $this = document.getElementById(thisid);
				$.ajax({
					type : "POST",
					url : "<%=request.getContextPath() %>/delpel",
					data: {"thisid" : thisid},
					async : true,
					dataType : "json",
					success : function(result) {
					    if(result.message == "success") {
					    	  alert("删除成功");
						      $this.closest('.brick').remove();		      
							  return $('.pelgridly').gridly('layout');
					    } else {
					    	 alert("删除失败");
					    	 return false;
					   }
					}						
				}); 
  			}
     	}
	</script>
</head>

<body>
<div class="container-fluid">
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
		<input type="text" style="display:none" name="currentdemoid"  id="currentdemoid" />
		<input type="text" style="display:none" name="cpcurrentdemoid"  id="cpcurrentdemoid" />
		<div id="myheads" class="row-fluid">
			<div class="col-sm-1"></div>
			<div class="col-sm-11">
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;工作台</h2>
                 <div class="tabbable tabbable-custom">
                     <ul class="nav nav-tabs" id="salTab">
                          <li><a href="#tab_1_1">&nbsp;&nbsp;&nbsp;&nbsp;薪酬模板&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
                          <li><a href="#tab_1_2">&nbsp;&nbsp;&nbsp;&nbsp;薪酬计算&nbsp;&nbsp;&nbsp;&nbsp;</a></li>                          
                     </ul>
                     <div class="tab-content">
                         <div class="tab-pane active" id="tab_1_1"> 
                         	<div id="gzpdbody" class="row">
								<div class="col-sm-10">
									<div  class='content row-fluid'>			      
								      <div id="productdemo" class='example'>
								      		<div>
										        <div class='gridly' id="productarea"></div>
										        <p class='actions adddemosbt'>
										          <button id="adddemobt"  class="add button" data-target="#addsaldemoModel" data-toggle="modal" >添加工资模板</button>        
										        </p>
										        <div id="href_addsal"></div>
									        </div>								        
								      </div>
			      
								      <div id="productdetail" class="col-md-6" style="display:none">
									      <div id="productele" class="exampleele row-fluid" >
									    		<div class='elegridly' id="productelearea"></div>
									        	<p class='actions addelebt'>
									          		<button class="addele button" data-target="#addsaleleModel" data-toggle="modal" >添加基本项</button>
									        	</p>
									        	<button id="updateelebt" style="display:none" class="btn" data-target="#updatesaleleModel" data-toggle="modal" onclick="openaddele()" ></button>
									        	<div id="href_addele"></div>
									    	</div>
										    <div id="standsalele" class="exampleele row" >
										    	<div class='standgridly' id="productstelearea"></div>
										        <p class='actions addelebt'>
										        	<button class="addstandele button" data-target="#addsalsteleModel" data-toggle="modal" >添加社保公积金项</button>
										        </p>
									        	<div id="href_addele"></div>
										    </div>
								    	</div>
								    	<div class="col-sm-2"></div>
			    					</div>			    					
			    				</div>
			    				<div class="col-sm-1"></div>
			    			</div>
			    			<div id="productpel" class="examplepel row" style="display:none">
				    			<div class='pelgridly' id="productpelarea"></div>
						        <p class='actions addpelbt'>
						          	<button class="addpel button" data-target="#addsalpelModel" data-toggle="modal">添加员工</button>
						        </p>
						        <button id="addpelbt" style="display:none" class="btn btn-primary btn-large" data-target="#updatesalpelModel" data-toggle="modal" onclick="openaddpel()" ></button>
						        <div id="href_addpel"></div>				         
						     </div>                         
		                 </div> 
                                                     
                         <div class="tab-pane" id="tab_1_2">
                         	<div id="gzpdbody" class="row">
								<div class="col-sm-10">
									<div  class='content row-fluid'>			      
								      <div id="computedemo" class='example'>
								      		<div>
										        <div class='cpgridly' id="cparea"></div>
									        </div>								        
								      </div>
			      
								       <div id="computepeizhi" class="col-md-6" style="display:none">
										    <p class='actions cpbts'>
										          <button id="cpbt"  class="button" onclick="gotocompute()" >计算工资</button>        
										    </p>								    
								      </div> 
								    	<div class="col-sm-2"></div>
			    					</div>								    				    					
			    				</div>
			    				<div class="col-sm-1"></div>
			    			</div>
			    			<div class="row">
								<!-- <div class="col-sm-1"></div> -->
								<div class="col-sm-11">									
									<div id="computedetail" class="row" style="overflow:auto">
								      <table id="cpTable"  data-show-columns="true" class="table table-hover table-striped table-condensed" style="overflow:scroll;">
								          	<thead>
								          		<tr class="onmouse tb-hd" id="cpheads">
								          		</tr>
								                </thead>
								                <tbody id="cpbody"></tbody>
								        	</table>										    
								    </div>								    				    					
								</div>
								<div class="col-sm-1"></div>
						  </div>				    			   
	            		 </div>
	            	</div>
	            </div> 
			</div>
		</div>				
	</div>
	<div id="daka" class="htmleaf-container"  style="display:none">
		<div id="myheads" class="row-fluid">
			<div class="col-sm-1"></div>
			<div class="col-sm-11">
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;工作台</h2>
				<div class="tabbable tabbable-custom">
                     <ul class="nav nav-tabs" id="salTab">
                          <li><a href="#tab_2_1">&nbsp;&nbsp;&nbsp;&nbsp;打卡功能1&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
                          <li><a href="#tab_2_2">&nbsp;&nbsp;&nbsp;&nbsp;打卡功能2&nbsp;&nbsp;&nbsp;&nbsp;</a></li>                          
                     </ul>
                     <br>
                     <div class="tab-content">
                         <div class="tab-pane active" id="tab_2_1"> 
                         	<h2>敬请期待！！！</h2>    
                         </div>                             
                         <div class="tab-pane " id="tab_2_2">
                         	<h2>敬请期待！！！</h2>
	            		 </div>
	            	</div>
	            </div>	
			</div>
		</div>		
		<div>
		</div>
	</div>
	</div>
</body>
</html>