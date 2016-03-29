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
		 width: 1100px;
		}
		
     </style>
     <script type="text/javascript">
     $(function(){
    	 $("#updatesalpelModel").on("hidden.bs.modal", function() {
    		 $(this).remove(".modal");  	 
    	});
     });
     
     function changeSBbase(){  	  
  	   var bsvalue = document.getElementById('cpbase').value;
  	   if(bsvalue == 3){//自定义
  		   $('.sbgroup').removeAttr("style");    		   
  	   }else if(bsvalue==1){//平均工资
  		   $('.sbgroup').attr("style","display:none"); 
  		   var areacode = document.getElementById('areacode').innerHTML;
  		   $.ajax({  
  		     	type : "POST",
  		 		url : "<%=request.getContextPath() %>/getLocalStByareacode?areacode=" + areacode,
  		 		async : false,
  		 		dataType : "json",
  		 		success : function(result){
  		 			if(result != null && result.length > 0) {
  		 				document.getElementById('averagesal').innerHTML = result[0].averagesal;
  		 				for(var j=0;j<$('.sbgroup').length;j++){
  		 	  			   document.getElementsByClassName("sbgroup")[j].children[1].children[0].value=document.getElementById('averagesal').innerHTML;
  		 	  		   }
  		 			}	 			
  		 		}
  		      });
  	   }else if(bsvalue==0){//实际收入
  		   $('.sbgroup').attr("style","display:none");   		   
  		   for(var j=0;j<$('.sbgroup').length;j++){
  			 document.getElementsByClassName("sbgroup")[j].children[1].children[0].value=0;
  		   }
  	   }
  	   else{//最低工资
  		 $('.sbgroup').attr("style","display:none"); 
		   var areacode = document.getElementById('areacode').innerHTML;
		   $.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getLocalStByareacode?areacode=" + areacode,
		 		async : false,
		 		dataType : "json",
		 		success : function(result){
		 			if(result != null && result.length > 0) {
		 				document.getElementById('averagesal').innerHTML = result[0].averagesal;
		 				for(var j=0;j<$('.sbgroup').length;j++){
 		     			   var id = document.getElementsByClassName("sbgroup")[j].children[1].children[0].id;
 		     			   document.getElementsByClassName("sbgroup")[j].children[1].children[0].value=result[0][id];
 		     		   }
		 			}	 			
		 		}
		      });
  	   }
     }
     </script>
     <script type="text/javascript">     
     
       $(function(){
    	      var peid = document.getElementById('peid').value;    	   
			  $.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getSpelLists?peid_st=" + peid,
		 		async : true,
		 		dataType : "json",
		 		success : function(result){
		 			if(result != null && result.length > 0) {
		 				var elesum =result[1];
						var eveles = (parseInt(elesum)+2)/3;
						var shengyu = (parseInt(elesum)+2)%3;	
						
						//添加社保基数下来
						if(result[2]!=null && result[2].length>0){
							var standval =result[2][0].standval;
							//brick = '<div class="form-group"><label class="col-md-5 control-label">社保缴纳基数:</label><div class="col-md-7"><select class="form-control" id="cpbase" name="cpbase"><option value="1">以实际收入为准</option><option value="2">以本市平均工资为准</option><option value="3">以最低基数为准</option></select></div></div>';
							brick = '<div class="form-group"><label class="col-md-5 control-label">社保缴纳基数:</label><div class="col-md-7"><select class="form-control" id="cpbase" name="cpbase" onchange="changeSBbase()"><option value="2">以最低基数为准</option><option value="0">以实际收入为准</option><option value="1">以本市平均工资为准</option><option value="3">自定义基数</option></select></div></div>';
							$('#tcolumn').append(brick);
							$(document.getElementById("cpbase")).val(result[2][0].standval);
						} 
						
						//添加基本项
	 			       for(var i = 0; i<result[0].length; i++) {
	 			    	   var infos = result[0];
	 			    	   var id = infos[i].salitemid;
	 					   var name = infos[i].elename;
	 					   var bvalue = infos[i].basevalue;
	 					   brick = '<div class="form-group"><label class="col-md-5 control-label">'+name+':</label><div class="col-md-7"><input type="text" class="form-control" name="'+id+'" id="'+id+'" value="'+bvalue+'"/></div></div>';
 						   if(parseInt(shengyu)>0){
 							  if(parseInt(eveles)>=i+1){
 	 							  $('#fcolumn').append(brick);
 	 						   }else if(parseInt(eveles)<i+1 && 2*(parseInt(eveles))>=i+1){
 	 							  $('#scolumn').append(brick);
 	 						   }else{
 	 							  $('#tcolumn').append(brick);
 	 						   }
 						   }else{
 							  if(parseInt(eveles)>=i+2){
 	 							  $('#fcolumn').append(brick);
 	 						   }else if(parseInt(eveles)<i+2 && 2*(parseInt(eveles))>=i+3){
 	 							  $('#scolumn').append(brick);
 	 						   }else{
 	 							  $('#tcolumn').append(brick);
 	 						   }
 						   }	 					   	 					   	 					  	 				     
			       		}
						
	 			    //社保项添加
	 			       for(var i = 0; i<result[2].length; i++) {
	 			    	   var infos = result[2];
	 			    	   var id = infos[i].fixedcode;
	 					   var name=infos[i].elename;
	 					   var cpvalue = infos[i].basevalue;
	 					   brick = '<div class="form-group sbgroup" style="display:none"><label class="col-md-5 control-label">'+name+':</label><div class="col-md-7"><input type="text" class="form-control" name="'+id+'" id="'+id+'" value="'+cpvalue+'"/></div></div>';
 						   var a =$('#fcolumn').children().length;
 						   var b =$('#scolumn').children().length;
 						   var c =$('#tcolumn').children().length;
	 					   if(a <= b && a <= c){
 							  $('#fcolumn').append(brick);
 						   }else if(b <= a && b <= c){
 							  $('#scolumn').append(brick);
 						   }else{
 							  $('#tcolumn').append(brick);
 						   }	 					   
			       		}
	 			    
	 			    	//是否显示社保项
		 			   var sbplay = result[2][0].standval;
		 			   if(sbplay == 3){
		 	    		   $('.sbgroup').removeAttr("style");    		   
		 	    	   }else{
		 	    		   $('.sbgroup').attr("style","display:none");   
		 	    	   }	 			
		 		}}
		      });  
        }); 		
       </script>
  </head>
  <body>
    <div class="modal fade" data-backdrop='static' id="updatesalpelModel">
        <div class="modal-dialo">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                &times;
              </button>
              <h4 class="modal-title">修改员工薪酬信息</h4>
            </div>
             <form class="form-horizontal"  id="validate-2">
             	 <input type="hidden" id="peid" name = "peid_st" value="${peid}"/>
             	 <h2 style="display:none" id="areacode">${areacode}</h2>
            	<h2 style="display:none" id="averagesal">${averagesal}</h2> 
	            <div class="modal-body">	                    	
                     <br>
                     <div  class="row">
				         <div id="fcolumn" class="col-md-4" >
					     	<div class="form-group"><label class="col-md-5 control-label">身份证号:</label><div class="col-md-7"><input type="text" class="form-control required" name="idnumber"  id="idnumber" value="${idnumber}" readonly/></div></div>
					     </div>				
						<div id="scolumn" class="col-md-4" >
		                     <div class="form-group">
			                    <label class="col-md-5 control-label">姓名:</label>
			                    <div class="col-md-7">
			                    	<input type="text" class="form-control required" name="pename"  id="pename" value="${pename}" readonly/>		           
			                    </div> 
			                 </div>		                    		                    		                        
					    </div>					
						<div id="tcolumn" class="col-md-4" >
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
            $.ajax({ 
                 type: "POST", 
                 url: "<%=request.getContextPath() %>/updateDemopel",
                 async : true, 
                 data: $("#validate-2").serialize(),
                 success: function(mes) { 
                 	if(mes.message=="success") {   			
			 			$("#updatesalpelModel").modal("hide");
			 			//$("#updatesalpelModel").empty();
			 			toadddemopels();
			 			alert("员工薪资修改成功");
					}else if(mes.message=="error"){
						alert("员工薪资修改失败");
					} 
                 } 
             }); 
        }    
	    });
	 });
    </script>  
	
  </body>
</html>
