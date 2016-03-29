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
		    height:68px;
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
		var peid = document.getElementById("userid").innerHTML
		 $.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getDemoid?peid=" + peid,
		 		async : false,
		 		dataType : "json",
		 		success : function(result){
		 			if(result.info=="success"){
		 				var demoid = result.finfo;
		 				findpay(demoid);
		 			}else{
		 				document.getElementById("getInfo").innerHTML="暂无您的薪酬信息，请耐心等待！"
		 			}	 			
		 		}
		      }); 
	});
	</script>	
	
	<script type="text/javascript">
		function findpay(demoid){
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
	 			        	var peid = document.getElementById("userid").innerHTML
	 			    	   var pays = result[0][k];
	 			    	   if(peid==pays.peid){
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
		 		}
		      });  
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
	          <span>我的打卡</span>
	        </a>
	      </li>
	      <li>
	        <a  onclick="isGongzi()">
	          <i class="fa fa-fw fa-lg fa-comments-o"></i> 
	          <span>我的薪酬</span>
	        </a>
	      </li>
	      <li>
	        <a href="">
	          <i class="fa fa-fw fa-lg fa-desktop"></i> 
	          <span>设置</span>
	        </a>
	      </li>
	    </ul>
	</nav>
	<div id="gongzi" class="htmleaf-container">
		<a id="togongzipage" href="/CWWBB/jsp/pemypage.jsp" style="display:none"></a>
		<!-- <h1 id="currentdemoid" style="display:none" ></h1> -->
		<input type="text" style="display:none" name="currentdemoid"  id="currentdemoid" />
		<input type="text" style="display:none" name="cpcurrentdemoid"  id="cpcurrentdemoid" />
		<div id="myheads" class="row-fluid">
			<div class="col-sm-1"></div>
			<div class="col-sm-11">
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;工作台</h2>					                 
			</div>
	    </div>	
	    <div>
	    <div class="col-sm-1"></div>
	    <div id="gzpdbody" class="row col-sm-11">
					<div class="col-sm-10">									
    					<div id="computedetail" class="row" style="overflow:auto">
    					     <h1 id="getInfo"></h1>
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
	<div id="daka" class="htmleaf-container"  style="display:none">
		<div id="myheads" class="row-fluid">
			<div class="col-sm-1"></div>
			<div class="col-sm-11">
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;工作台</h2>				
			</div>
		</div>
		<div class="col-sm-1"></div>
	    <div id="gzpdbody" class="row col-sm-11">
					<div class="col-sm-10">									
    					<h1>暂无数据,敬请期待！</h1>
					    				    					
    				</div>
    				<div class="col-sm-1"></div>
    			</div>		
		<div>
		</div>
	</div>
	</div>
</body>
</html>