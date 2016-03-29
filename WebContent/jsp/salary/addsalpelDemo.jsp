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
		    width: 1100px
		}
		
     </style>
     <script type="text/javascript">
     $(function(){
    	 $("#addsalpelModel").on("hidden.bs.modal", function() {
    		 $(this).remove(".modal");   
    	});
     });
     </script>
     <script type="text/javascript">     
     
       $(function(){
    	   var demoid_st = document.getElementById('demoid').value;    	   
			  $.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getSeleLists?demoid_st=" + demoid_st,
		 		async : false,
		 		dataType : "json",
		 		success : function(result){
		 			if(result != null && result.length > 0) {
		 				var elesum =result[2];
						var eveles = (parseInt(elesum)+2)/3;
						var shengyu = (parseInt(elesum)+2)%3;						
	 			       for(var i = 0; i<result[0].length; i++) {
	 			    	   var infos = result[0];
	 			    	   var id = infos[i].eleid;
	 					   var name = infos[i].elename;
	 					   
	 					   brick = '<div class="form-group"><label class="col-md-5 control-label">'+name+':</label><div class="col-md-7"><input type="text" class="form-control" name="'+id+'" id="'+id+'"/></div></div>';
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
	 			       if(result[1]!=null && result[1].length>0){
	 			    	  brick = '<div class="form-group"><label class="col-md-5 control-label">社保缴纳基数:</label><div class="col-md-7"><select class="form-control" id="cpbase" name="cpbase" onchange="changeSBbase()"><option value="2">以最低基数为准</option><option value="0">以实际收入为准</option><option value="1">以本市平均工资为准</option><option value="3">自定义基数</option></select></div></div>';
	 			    	  var areacode = result[4];
	 			    	  document.getElementById('areacode').innerHTML = areacode;	
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
	 			       
	 			       //社保项添加
	 			       for(var i = 0; i<result[1].length; i++) {
	 			    	   var infos = result[1];
	 			    	   var id = infos[i].basecode;
	 					   var name;
	 					   if(id=="zhufb"){
	 						   name = "住房基数";
	 					   }else if(id == "yilb"){
	 						   name = "医保基数";
	 					   }else if(id == "gongsb"){
	 						   name = "工伤基数";
	 					   }else if(id == "shengyb"){
	 						   name = "生育基数";
	 					   }else if(id == "shiyb"){
	 						   name = "失业基数";
	 					   }else if(id == "yanglb"){
	 						   name = "养老基数";
	 					   }
	 					   var cpvalue = result[3][id];
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
		 			}	 			
		 		}
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
       function lostidnumber()
       {
         var input=document.getElementById("idnumber");
         var input_value=input.value;
         if(input_value==""){
         	document.getElementById("idnumberInfo").innerHTML="身份证号不能为空";
         	document.getElementById("peid").value="";
           }else if(input_value.length!=18&&input_value.length!=15){
         	  document.getElementById("idnumberInfo").innerHTML="请您输入正确的身份证号";
        	   document.getElementById("peid").value="";
           }
         else{
         	  $.ajax( {   
           	      type : "POST",   
           	      url : "<%=request.getContextPath()%>/validateIdnumber", 
           	      data : {
           	        'idnumber' :$("#idnumber").val()
           	       },  
           	      dataType: "json",   
           	      success : function(data) {   
         	          if(data.info=="success"){   
         	        	document.getElementById("idnumberInfo").innerHTML=data.idnumberInfo;
         	        	if(data.idnumberInfo==""){
         	        		document.getElementById("peid").value=data.peid;
         	        	}         	        	
         	          }   
         	          else{
         	        	document.getElementById("idnumberInfo").innerHTML="该身份证号还未被注册，请先注册";
         	        	document.getElementById("peid").value="";
         	          }   
         	      }
           	  });
           }
       }
       
       function lostpename()
       {
         var input=document.getElementById("pename");
         var input_value=input.value;
         if(input_value==""){
         	document.getElementById("penameInfo").innerHTML="姓名不能为空";
         	document.getElementById("peid2").innerHTML=data.peid;
           }
         else{
         	  $.ajax( {   
           	      type : "POST",   
           	      url : "<%=request.getContextPath()%>/validatePename", 
           	      data : {
           	        'pename' :$("#pename").val()
           	       },  
           	      dataType: "json",   
           	      success : function(data) {   
         	          if(data.info=="success"){           	        	
         	        	document.getElementById("peid2").innerHTML= data.peid;
         	        	document.getElementById("penameInfo").innerHTML= "";
         	          }   
         	          else{
         	        	document.getElementById("idnumberInfo").innerHTML="该身份证号还未被注册，请更换";
         	        	document.getElementById("peid2").innerHTML=data.peid;
         	          }   
         	      }
           	  });
           }
       }
       </script>
  </head>
  <body>
    <div class="modal fade" data-backdrop='static' id="addsalpelModel">
        <div class="modal-dialo">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                &times;
              </button>
              <h4 class="modal-title">
               	 <i class="icon-reorder"></i> 添加员工薪酬信息
              </h4>
            </div>
            <h1 id="peid2" style="display:none" ></h1>
            <h2 style="display:none" id="areacode"> </h2>
            <h2 style="display:none" id="averagesal"> </h2>
             <form class="form-horizontal"  id="validate-2">
             	<input type="hidden" id="demoid" name = "demoid_st" value="${demoid}"/>
				<input type="hidden" id="demoname" name ="demoname" value="${demoname}"/> 				
				<input type="hidden" id="peid" name ="peid" value=""/> 
	            <div class="modal-body" style="overflow:scroll;">	                    	
                     <br>
                     <div  class="row">
				         <div id="fcolumn" class="col-md-4" >
					     	<div class="form-group"><label class="col-md-5 control-label">身份证号:</label><div class="col-md-7"><input type="text" class="form-control required" name="idnumber"  id="idnumber" onblur="lostidnumber()" />
                                <small id="idnumberInfo" style="color:#FF0000"></small>
					     	</div></div>
					     </div>				
						<div id="scolumn" class="col-md-4" >
		                     <div class="form-group">
			                    <label class="col-md-5 control-label">姓名:</label>
			                    <div class="col-md-7">
			                    	<input type="text" class="form-control required" name="pename"  id="pename"onblur="lostpename()" />
                                <small id="penameInfo" style="color:#FF0000"></small>	           
			                    </div> 
			                 </div>	                    		                    		                        
					    </div>					
						<div id="tcolumn" class="col-md-4" >
						</div>						
					</div>
					<div id="focolumn"  style="display:none" >
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
        	var peid1 = document.getElementById("peid").value;
        	var peid2 = document.getElementById("peid2").innerHTML;
        	if(document.getElementById("pename").value==null){
	        		document.getElementById("penameInfo").innerHTML= "姓名不能为空";
	        		return false;
	        	}else{
	        		document.getElementById("penameInfo").innerHTML= "";
	        }
        	if(document.getElementById("idnumber").value==null){
        		document.getElementById("idnumberInfo").innerHTML= "身份证号不能为空";
        		return false;
        	}else{
        		document.getElementById("idnumberInfo").innerHTML= "";
        }
        	if(peid1==peid2){
        		document.getElementById("penameInfo").innerHTML= "";
        	}else{
        		document.getElementById("peid2").innerHTML= "";
        		document.getElementById("penameInfo").innerHTML= "身份证号与姓名不符，请检查";
        		return false;
        	}

            $.ajax({ 
                 type: "POST", 
                 url: "<%=request.getContextPath() %>/saveDemopel",
                 async : true, 
                 data: $("#validate-2").serialize(),
                 success: function(mes) { 
                 	if(mes.message=="success") {   			
			 			$("#addsalpelModel").modal("hide");
			 			//$("#addsalpelModel").empty();
			 			toadddemopels();
			 			alert("员工薪资添加成功");
					}else if(mes.message=="error"){
						alert("员工薪资添加失败");
					} 
                 } 
             }); 
        }    
	    });
	 });
    </script>  
	
  </body>
</html>
