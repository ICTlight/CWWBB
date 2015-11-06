<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
  <head>

    <style type="text/css">    
       .modal-dialo {
		    position: fixed; 
		  text-align: center; 
		  margin: 0px auto; 
		 top: 0px; left: 0px; 
		 bottom: 0px; 
		 right: 0px; 
		  z-index: 1050; 
		    width: 900px
		}
		
     </style>
     <script type="text/javascript">
     $(function(){
	     $(document).on("hidden.bs.modal", function (e) {
	 	    $(e.target).removeData("bs.modal").find(".modal-content").empty();
	 	});
     });
     </script>
     <script type="text/javascript">     
     
       $(function(){
    	   var peid = document.getElementById('peid').value;    	   
			  $.ajax({  
		     	type : "POST",
		 		url : "<%=request.getContextPath() %>/getSpelLists?peid_st=" + peid,
		 		async : false,
		 		dataType : "json",
		 		success : function(result){
		 			if(result != null && result.length > 0) {
		 				var elesum =result[1];
						var eveles = (parseInt(elesum)+2)/3;
						var shengyu = (parseInt(elesum)+2)%3;						
	 			       for(var i = 0; i<result[0].length; i++) {
	 			    	   var infos = result[0];
	 			    	   var id = infos[i].salitemid;
	 					   var name = infos[i].elename;
	 					   var bvalue = infos[i].basevalue;
	 					   brick = '<div class="form-group"><label class="col-md-5 control-label">'+name+':</label><div class="col-md-7"><input type="text" class="form-control required" name="'+id+'" id="'+id+'" value="'+bvalue+'"/></div></div>';
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
	 			      /* for(var i = 0; i<result[1].length; i++) {
	 			    	   var infos = result[1];
	 			    	   var id = infos[i].eleid;
	 					    var name = infos[i].elename; 	 					    
	 					   brick = '<div class="form-group"><label class="col-md-5 control-label">'+name+':</label><div class="col-md-7"><input type="text" class="form-control required" name="'+id+'" id="'+id+'" /></div></div>';
 						   if(parseInt(eveles)>=i){
 							  $('#tcolumn').append(brick);
 						   }else if(parseInt(eveles)<i && 2*(parseInt(eveles))>=i){
 							  $('#scolumn').append(brick);
 						   }else{
 							  $('#fcolumn').append(brick);
 						   }	 					   
			       		} */
		 			}	 			
		 		}
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
              <h4 class="modal-title">
               	 <i class="icon-reorder"></i> 修改员工薪酬信息
              </h4>
            </div>
             <form class="form-horizontal"  id="validate-2">
             	<!-- <input type="hidden" id="peid" name = "peid_st" value="${peid}"/> -->
	            <div class="modal-body">	                    	
                     <br>
                     <div  class="row">
				         <div id="fcolumn" class="col-md-4" >
					     	<div class="form-group"><label class="col-md-5 control-label">员工ID:</label><div class="col-md-7"><input type="text" class="form-control required" name="peid"  id="peid" value="${peid}" readonly/></div></div>
					     </div>				
						<div id="scolumn" class="col-md-4" >
		                     <div class="form-group">
			                    <label class="col-md-5 control-label">用户名:</label>
			                    <div class="col-md-7">
			                    	<input type="text" class="form-control required" name="pename"  id="pename" value="${pename}"/>		           
			                    </div> 
			                 </div>		                    		                    		                        
					    </div>					
						<div id="tcolumn" class="col-md-4" ></div>
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
                 async : false, 
                 data: $("#validate-2").serialize(),
                 success: function(mes) { 
                 	if(mes.message=="success") {   			
			 			$("#updatesalpelModel").modal("hide");
			 			$("#updatesalpelModel").empty();
			 			torefreshdemo();
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
