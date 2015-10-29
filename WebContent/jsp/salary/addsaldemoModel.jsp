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
		    width: 500px
		}
		
     </style>
  </head>
  <body>
    <div class="modal fade" data-backdrop='static' id="addsaldemoModel">
        <div class="modal-dialo">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                &times;
              </button>
              <h4 class="modal-title">
               	 <i class="icon-reorder"></i><span>添加工资模板</span> 
              </h4>
            </div>
             <form class="form-horizontal"  id="validate-2">
             	<input type="hidden" id="labour_id" name = "labour_id"/>
				<input type="hidden" id="acquirer_id" name = "acquirer_id"/> 
	            <div class="modal-body">	                    		                                          
                    <div class="row">
                    <br>
                    <div class="col-md-1"></div>
                    <div class="col-md-9" >
					     <div class="form-group">
		                     <label class="col-md-5 control-label">模板名称:</label>
		                     <div class="col-md-7">
		                       <input type="text" class="form-control required" name="userid"  id="userid" />
		                     </div>
		                 </div>
		                 <div class="form-group">
		                     <label class="col-md-5 control-label">英文名称:</label>
		                     <div class="col-md-7">
		                       <input type="text" class="form-control required" name="usid"  id="usid" />
		                     </div>
		                 </div> 
		                 <div class="form-group">
		                     <label class="col-md-5 control-label">模板简称:</label>
		                     <div class="col-md-7">
		                       <input type="text" class="form-control required" name=""  id="" />
		                     </div>
		                 </div>
		                 <div class="form-group">
		                     <label class="col-md-5 control-label">模板描述:</label>
		                     <div class="col-md-7">
		                       <input type="text" class="form-control required" name=""  id="" />
		                     </div>
		                 </div>	
		                 </div>	
		               <div class="col-md-2"></div>						
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
        	alert("添加成功");
        	$("#addsaldemoModel").modal("hide");
           <%-- $.ajax({ 
                 type: "POST", 
                 url: "<%=request.getContextPath() %>/saveLabourac",
                 async : false, 
                 data: $("#validate-2").serialize(),
                 success: function(mes) { 
                 	if(mes.message=="success") {
			 			jQuery("#pbEmpTablelw").trigger("reloadGrid");   			
			 			$("#addsaldemoModel").modal("hide");
			 			$("#addsaldemoModel").empty();
			 			reloadlw();
			 			alert("需求发布成功");
					}else if(mes.message=="error"){
						alert("需求发布失败");
					} 
                 } 
             }); --%>
        }    
	    });
	 });
    </script>  	
  </body>
</html>