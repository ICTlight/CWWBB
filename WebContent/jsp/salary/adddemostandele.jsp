<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
  <head>
  <%@include file="/jsp/utils/meta.jsp" %> 
  <%@include file="/jsp/utils/common_css.jsp" %> 
  <%@include file="/jsp/utils/common_js.jsp" %> 
  <%@include file="/jsp/utils/mypage_js.jsp" %>	
    <style type="text/css">    
       .modal-dialo {
		    position: fixed; 
		  text-align: center; 
		  margin: 0px auto; 
		 top: 0px; left: 0px; 
		 bottom: 0px; 
		 right: 0px; 
		  z-index: 1050; 
		    width: 800px
		}		
     </style>
     <style type="text/css">
		ul { margin:0px; padding:0px; margin-left:20px; }
		#list1, #list2 { width:350px; list-style-type:none; margin:0px; }
		#list1 li, #list2 li { float:left; padding:5px; width:100px; height:100px; }
		#list1 div, #list2 div { width:90px; height:90px; border:solid 1px black; background-color:#E0E0E0; text-align:center; padding-top:40px; }
		#list2 { float:right; }
		.placeHolder div { background-color:white !important; border:dashed 1px gray !important; }
	</style>
 	<script type="text/javascript">
     $(function(){
    	  $("#addsalsteleModel").on("hidden.bs.modal", function() {
    		  $(this).remove(".modal");  		 
    	}); 
     });
     </script> 
     <script type="text/javascript">     
     
       $(function(){
    	   var demoid_st = document.getElementById('demoid').value; 
			$.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getSalDemosteleLists?demoid_st=" + demoid_st,
		 		async : true,
		 		dataType : "json",
		 		success : function(result){
		 			if(result != null && result.length > 0) {
		 				var standlist = $("#standlist").val();
		 				var standidlist = $("#standidlist").val();
		 				var sum = result.length;
	 			       for(var i = 0; i<result.length; i++) {
	 			    	   var id = result[i].fixedcode;
	 					    var name = result[i].elename;
	 					    var cpvalue = result[i].cpvalue;
	 					    brick = '<li id="'+id+'"><div>'+name+'</div></li>';	 					  
	 					   standlist =standlist + ','+name;
	 					   standidlist =standidlist + ','+id;
	 					   $("#"+id).remove();	 					   
	 				       $('#list1').append(brick);
	 				      
	 				     	cpbrick = '<div id="'+id+"2"+'" class="form-group"><label class="col-md-5 control-label">'+name+':</label><div class="col-md-7"><input type="text" class="form-control shebaos" name="'+id+"1"+'" id="'+id+"1"+'" value="'+cpvalue+'"/></div></div>';
	 	    	   			if(i < sum/2){
	 	    	   				$('#fcolumn').append(cpbrick);
	 	    	   			}else{
	 	    	   			$('#scolumn').append(cpbrick);
	 	    	   			}
	 				     
			       		}
	 			      document.getElementById("standlist").value= standlist.substring(1,standlist.length) ;
	 			      document.getElementById("standidlist").value= standidlist.substring(1,standidlist.length) ;
		 			}	 			
		 		}
		      }); 
        });     
       </script>
       
       
       <script type="text/javascript">  
          function getCpvaluList(){
        	  var standidlist = document.getElementById('standidlist').value;
        	  var standvaluelist = document.getElementById('standvaluelist').value;
        	  if(standidlist!=null&&standidlist.length>0){
	    	   		var standidarr = standidlist.split(","); 
	    	   		var sum = standidarr.length;	 	    	   		
	    	   		for(var i=0;i<standidarr.length;i++){
	    	   			var cp = document.getElementById(standidarr[i]+"1").value;
	    	   			standvaluelist = standvaluelist+","+cp;
	    	   		}
	    	   		document.getElementById("standvaluelist").value= standvaluelist.substring(1,standvaluelist.length) ;
        	  }
          }
          
          //监听社保项list变化，
          function upIdList(){//upIdList()
        	  upCpvaluList();
          }
           function upCpvaluList(){
        	  var standidlist = document.getElementById('standidlist').value;
        	  var standvaluelist = document.getElementById('standidlist').value;
        	  if(standidlist != null && standidlist.length > 0) {
	 				var standlist = $("#standlist").val();
	 				var standidlist = $("#standidlist").val();
	 				var sum = result.length;
			       for(var i = 0; i<result.length; i++) {
			    	   var id = result[i].fixedcode;
					    var name = result[i].elename;
					    var cpvalue = result[i].cpvalue;
					    brick = '<li id="'+id+'"><div>'+name+'</div></li>';	 					  
					   standlist =standlist + ','+name;
					   standidlist =standidlist + ','+id;
					   $("#"+id).remove();	 					   
				       $('#list1').append(brick);
				      
				     	cpbrick = '<div id="'+id+"2"+'" class="form-group"><label class="col-md-5 control-label">'+name+':</label><div class="col-md-7"><input type="text" class="form-control shebaos" name="'+id+"1"+'" id="'+id+"1"+'" value="'+cpvalue+'"/></div></div>';
	    	   			if(i < sum/2){
	    	   				$('#fcolumn').append(cpbrick);
	    	   			}else{
	    	   			$('#scolumn').append(cpbrick);
	    	   			}
				     
		       		}
			      document.getElementById("standlist").value= standlist.substring(1,standlist.length) ;
			      document.getElementById("standidlist").value= standidlist.substring(1,standidlist.length) ;
	 			}
          } 
          
          function changeArea(){
    	   var standidlist = document.getElementById('standidlist').value; 
    	   var areacode = document.getElementById('areacode').value;
		   $.ajax({  
	     	type : "POST",
	 		url : "<%=request.getContextPath() %>/getLocalStByareacode?areacode=" + areacode,
	 		async : false,
	 		dataType : "json",
	 		success : function(result){
	 			if(result != null && result.length > 0) {
	 				if(standidlist!=null&&standidlist.length>0){
	 	    	   		var standidarr = standidlist.split(","); 
	 	    	   		var sum = standidarr.length;
	 	    	   		$("#fcolumn").html("");
	 	    	   		$("#scolumn").html("");
	 	    	   		for(var i=0;i<standidarr.length;i++){
	 	    	   			var cp = getElenameandvalue(standidarr[i]);
	 	    	   			var name = cp.split(",")[0];
	 	    	   			var cpval = cp.split(",")[1];
	 	    	   			var val = eval("result[0]."+cpval);	 	    	   			
	 	    	   			brick = '<div id="'+cpval+"2"+'" class="form-group"><label class="col-md-5 control-label">'+name+':</label><div class="col-md-7"><input type="text" class="form-control shebaos" name="'+cpval+"1"+'" id="'+cpval+"1"+'" value="'+val+'"/></div></div>';
	 	    	   			if(i < sum/2){
	 	    	   				$('#fcolumn').append(brick);
	 	    	   			}else{
	 	    	   			$('#scolumn').append(brick);
	 	    	   			}
	 	    	   		}
	 	    	   }		 					 					 				
 			      
	 			}	 			
	 		}
	      });    
          }
       function getElenameandvalue(id){
    	   var name = "";
    	   var cpval = "";
    	   if(id=="zhufc"){
    		   name = "住房公司";
    		   cpval = "zhufc";
    	   }else if(id=="zhufg"){
    		   name = "住房个人";
    		   cpval = "zhufg";
    	   }
    	   else if(id=="yanglc"){
    		   name = "养老公司";
    		   cpval = "yanglc";
    	   }
    	   else if(id=="yanglg"){
    		   name = "养老个人";
    		   cpval = "yanglg";
    	   }
    	   else if(id=="yilc"){
    		   name = "医疗公司";
    		   cpval = "yilc";
    	   }
    	   else if(id=="yilg"){
    		   name = "医疗个人";
    		   cpval = "yilg";
    	   }
    	   else if(id=="shiyc"){
    		   name = "失业公司";
    		   cpval = "shiyc";
    	   }
    	   else if(id=="shiyg"){
    		   name = "失业个人";
    		   cpval = "shiyg";
    	   }
    	   else if(id=="shengyc"){
    		   name = "生育公司";
    		   cpval = "shengyc";
    	   }
    	   else if(id=="gongsc"){
    		   name = "工伤公司";
    		   cpval = "gongsc";
    	   }
    	   return name+","+cpval;    	   
       } 
       
       function getIdbyName(name){
    	   var id = "";
    	   if(name=="住房公司"){
    		   id = "zhufc";
    	   }else if(name=="住房个人"){
    		   id = "zhufg";
    	   }
    	   else if(name=="养老公司"){
    		   id = "yanglc";
    	   }
    	   else if(name=="养老个人"){
    		   id = "yanglg";
    	   }
    	   else if(name=="医疗公司"){
    		   id = "yilc";
    	   }
    	   else if(name=="医疗个人"){
    		   id = "yilg";
    	   }
    	   else if(name=="失业公司"){
    		   id = "shiyc";
    	   }
    	   else if(name=="失业个人"){
    		   id = "shiyg";
    	   }
    	   else if(name=="生育公司"){
    		   id = "shengyc";
    	   }
    	   else if(name=="工伤公司"){
    		   id = "gongsc";
    	   }
    	   return id;    	   
       } 
       </script>
       
       
  </head>
  <body>
    <div class="modal fade" data-backdrop='static' id="addsalsteleModel">
        <div class="modal-dialo">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                &times;
              </button>
              <h4 class="modal-title">
               	 <i class="icon-reorder"></i> 编辑社保公积金项信息
              </h4>
            </div>
             <form class="form-horizontal"  id="validate-2">
             	<input type="hidden" id="demoid" name = "demoid_st" value="${salaryDemoStEle.demoid}" onchange="getelelist()"/>
				<input type="hidden" id="demoname" name ="demoname" value="${salaryDemoStEle.demoname}"/> 
				<input type="hidden" id="cpvalstr" name ="cpvalstr" value=""/> 
	            <div class="modal-body">	
	            
	            
	            
	            <div>	            
            	<div class="widget-content">
                  <div id="accordion" class="panel-group">
                    <div class="panel panel-default">
                      <div class="panel-heading" href="#collapseOne" data-parent="#accordion" data-toggle="collapse">                        
                          <h3 class="panel-title">
                           	 社保基本信息
                          </h3>
                      </div>
                      <div class="panel-collapse collapse in" id="collapseOne">
                        <div class="panel-body">
                        
                        
                        
	            <div class="row">
	               <label class="col-md-2 control-label">地方标准:</label>
	               <div class="col-md-4">		                       
	                <select class="form-control" id="areacode" name="areacode" onchange="changeArea()">
		              <option value="010">北京市</option>
		              <option value="021">上海市</option>
		              <option value="020">广州市</option>
		            </select>
	              </div> 
	            </div>                                       
                 <div>
					<script type="text/javascript">
						$("ul:first").dragsort();
					</script>	
					<ul id="list2">
						<li id="zhufc"><div>住房公司</div></li>
						<li id="zhufg"><div>住房个人</div></li>
						<li id="gongsc"><div>工伤公司</div></li>
						<li id="shiyc"><div>失业公司</div></li>
						<li id="yanglc"><div>养老公司</div></li>
						<li id="yanglg"><div>养老个人</div></li>
						<li id="shengyc"><div>生育公司</div></li>
						<li id="shiyg"><div>失业个人</div></li>
						<li id="yilc"><div>医疗公司</div></li>
						<li id="yilg"><div>医疗个人</div></li>						
					</ul>
	
					<ul id="list1">
						
					</ul>
					<input id="standlist" name="list1SortOrder" type="hidden" onchange="upIdList()"/>
					<input id="standidlist" name="standidlist" type="hidden" />
					<input id="standvaluelist" name="standvaluelist" type="hidden" />
					<div id="href_addcpvalue"></div>	
					<script type="text/javascript">
						$("#list1, #list2").dragsort({ dragSelector: "div", dragBetween: true, dragEnd: saveOrder, placeHolderTemplate: "<li class='placeHolder'><div></div></li>" });
						
						function saveOrder() {
							var data = $("#list1 li").map(function() { return $(this).children().html(); }).get();
							var standidlist = "";
							$("input[name=list1SortOrder]").val(data.join(","));
							
							var standlist = $("#standlist").val();
							var hidlist = document.getElementById("standidlist").value;
							 if(standlist!=null){
								var standnamearr = standlist.split(",");
								for(var i=0;i<standnamearr.length;i++){
									var thisid = getIdbyName(standnamearr[i]);
									standidlist = standidlist +","+ thisid;									
								}
								//判断去掉的：循环旧的list,判断是否在新的中
								var hidarr = hidlist.split(",");
								for(var j=0;j<hidarr.length;j++){
									var thisid = hidarr[j];
									if(standidlist.indexOf(thisid)<0){
										$("#"+thisid+"2").hide();
									}
								}
								
								//判断新增的：循环新的list,判断是否在旧的中
								var newidarr = standidlist.split(",");
								for(var k=0;k<newidarr.length;k++){
									var thisid = newidarr[k];
									if(hidlist.indexOf(thisid)<0){
									   var areacode = document.getElementById('areacode').value;
									   $.ajax({  
								     	type : "POST",
								 		url : "<%=request.getContextPath() %>/getLocalStByareacode?areacode=" + areacode,
								 		async : false,
								 		dataType : "json",
								 		success : function(result){
								 			if(result != null && result.length > 0) {
								 	    	     	var cp = getElenameandvalue(thisid);
						 	    	   			    var name = cp.split(",")[0];
							 	    	   			var val = eval("result[0]."+thisid);	 	    	   			
							 	    	   			brick = '<div id="'+thisid+"2"+'" class="form-group"><label class="col-md-5 control-label">'+name+':</label><div class="col-md-7"><input type="text" class="form-control shebaos" name="'+thisid+"1"+'" id="'+thisid+"1"+'" value="'+val+'"/></div></div>';
							 	    	   			 if($('#scolumn').children().length > $('#fcolumn').children().length){
							 	    	   				$('#fcolumn').append(brick);
							 	    	   			}else{
							 	    	   				$('#scolumn').append(brick);
							 	    	   			}
								 	    	   	}		 					 					 												 			      
								 			}	 			
								      });    
									}
								}
							}
							document.getElementById("standidlist").value = standidlist.substring(1,standidlist.length);
						};
					</script>
					<div style="clear:both;"></div>
				</div>
				</div>
                      </div>
                    </div>
                    <div class="panel panel-default">
                      <div class="panel-heading" href="#collapseTwo" data-toggle="collapse" data-parent="#accordion">
	                      <h3 class="panel-title"> 缴纳比例信息</h3>
                      </div>
                      <div class="panel-collapse collapse" id="collapseTwo">
                        <div class="panel-body" >
                        	<div class="row">
                        	<div class="col-md-6" id="fcolumn" >								                    	
							</div>
							<div class="col-md-6" id="scolumn">	 
							</div>
							</div>
                        </div>
                      </div>
                    </div>
                    </div>
                </div>			
			</div>			
	            </div>   
	            <div class="modal-footer">
				    <button data-dismiss="modal" class="btn btn-default" type="button">关闭  </button>
                    <input type="submit" value="保存" class="btn btn-primary">                   
                </div>
	        </form>
	     </div>
	   </div>
	</div>
 <script>
      $(document).ready(function(){
      	FormComponents.init();
		$("#validate-2").validate({	

        submitHandler:function(form){
        	var standlist = $("#standidlist").val();
        	getCpvaluList();
            $.ajax({ 
                 type: "POST", 
                 url: "<%=request.getContextPath() %>/saveSalstEleDemo",
                 async : true, 
                 //data: $("#validate-2").serialize(),
                  data : {
	        	        'standlist' :$("#standlist").val(),
	        	        'demoname' :$("#demoname").val(),
	        	        'demoid_st' :$("#demoid").val(),
	        	        'standvaluelist':$("#standvaluelist").val(),
	        	        'areacode' :$("#areacode").val()
	        	       },   
	        	      dataType: "json", 
                 success: function(mes) { 
                 	if(mes.message=="success") {
			 			$("#addsalsteleModel").modal("hide");
			 			//$("#addsalsteleModel").empty();			 			
			 			alert("社保公积金项编辑成功");
			 			toadddemosteles();
					}else{
						alert("社保公积金项编辑失败");
					} 
                 } 
             }); 
        }    
	    });
	 });
    </script>  
	
  </body>
</html>
