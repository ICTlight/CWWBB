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
		    width: 700px
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
        }); 
       </script>
  </head>
  <body>
    <div class="modal fade" data-backdrop='static' id="updatesaleleModel">
        <div class="modal-dialo">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                &times;
              </button>
              <h4 class="modal-title">
               	 <i class="icon-reorder"></i> 修改模板项信息
              </h4>
            </div>
             <form class="form-horizontal"  id="validate-2">
             	<input type="hidden" id="eleid" name = "eleid_st" value="${salaryDemoEle.eleid}"/>
	            <div class="modal-body">	                
                      
                         <br>
                         
                                <div class="row">
									<div class="col-md-6" >
										<div>
										     <div class="form-group">
						                      <label class="col-md-5 control-label">属性名称:</label>
						                      <div class="col-md-7">
						                        <input type="text" class="form-control required" name="elename"  id="elename"  value="${salaryDemoEle.elename}"/>
						                      </div>
						                    </div>
						                    <div class="form-group">
						                      <label class="col-md-5 control-label">固定代码:</label>
						                      <div class="col-md-7">
						                        <input type="text" class="form-control required" name="fixedcode"  id="fixedcode"  value="${salaryDemoEle.fixedcode}"/>
						                      </div>
						                    </div>
						                    <div class="form-group">
						                      <label class="col-md-5 control-label">是否显示:</label>
						                       <div class="col-md-7">			                       
						                        <select class="form-control required" id="isshow" name="isshow">
						                            <option <c:if test="${'显示'==salaryDemoEle.isshow}">selected</c:if> value="<c:out value="显示"></c:out>" ><c:out value="显示"></c:out></option>
				                                    <option <c:if test="${'不显示'==salaryDemoEle.isshow}">selected</c:if> value="<c:out value="不显示"></c:out>" ><c:out value="不显示"></c:out></option>					
								                  </select>
						                      </div> 
						                    </div> 
										</div>
									</div>
				
					<div class="col-md-6" >
						<div >
		                     <div class="form-group">
		                      <label class="col-md-5 control-label">税前后加减项:</label>
		                       <div class="col-md-7">		                       
		                        <select class="form-control required" id="cptype" name="cptype">
				                    <option <c:if test="${'税无关'==salaryDemoEle.cptype}">selected</c:if> value="<c:out value="税无关"></c:out>" ><c:out value="税无关"></c:out></option>
				                    <option <c:if test="${'税前加'==salaryDemoEle.cptype}">selected</c:if> value="<c:out value="税前加"></c:out>" ><c:out value="税前加"></c:out></option>	
				                    <option <c:if test="${'税前减'==salaryDemoEle.cptype}">selected</c:if> value="<c:out value="税前减"></c:out>" ><c:out value="税前减"></c:out></option>	
				                    <option <c:if test="${'税后加'==salaryDemoEle.cptype}">selected</c:if> value="<c:out value="税后加"></c:out>" ><c:out value="税后加"></c:out></option>
				                    <option <c:if test="${'税后减'==salaryDemoEle.cptype}">selected</c:if> value="<c:out value="税后减"></c:out>" ><c:out value="税后减"></c:out></option>	
				                    <option <c:if test="${'应纳税所得额调整加'==salaryDemoEle.cptype}">selected</c:if> value="<c:out value="应纳税所得额调整加"></c:out>" ><c:out value="应纳税所得额调整加"></c:out></option>	
				                    <option <c:if test="${'应纳税所得额调整减'==salaryDemoEle.cptype}">selected</c:if> value="<c:out value="应纳税所得额调整减"></c:out>" ><c:out value="应纳税所得额调整减"></c:out></option>
				                    <option <c:if test="${'税调整加'==salaryDemoEle.cptype}">selected</c:if> value="<c:out value="税调整加"></c:out>" ><c:out value="税调整加"></c:out></option>	
				                    <option <c:if test="${'税调整减'==salaryDemoEle.cptype}">selected</c:if> value="<c:out value="税调整减"></c:out>" ><c:out value="税调整减"></c:out></option>	
				                    <option <c:if test="${'税后推税（税后发公司付税）'==salaryDemoEle.cptype}">selected</c:if> value="<c:out value="税后推税（税后发公司付税）"></c:out>" ><c:out value="税后推税（税后发公司付税）"></c:out></option>	
				                    <option <c:if test="${'税后推税（税后不发公司付税）'==salaryDemoEle.cptype}">selected</c:if> value="<c:out value="税后推税（税后不发公司付税）"></c:out>" ><c:out value="税后推税（税后不发公司付税）"></c:out></option>	
				                  </select>
		                      </div> 
		                    </div>
			          		<div class="form-group">
			                	<label class="col-md-5 control-label">精确度:</label>
			                 	<div class="col-md-7">
				                  <select class="form-control required" id="precisions" name="precisions">
				                    <option <c:if test="${'分位'==salaryDemoEle.precisions}">selected</c:if> value="<c:out value="分位"></c:out>" ><c:out value="分位"></c:out></option>
				                    <option <c:if test="${'角位'==salaryDemoEle.precisions}">selected</c:if> value="<c:out value="角位"></c:out>" ><c:out value="角位"></c:out></option>	
				                    <option <c:if test="${'元位'==salaryDemoEle.precisions}">selected</c:if> value="<c:out value="元位"></c:out>" ><c:out value="元位"></c:out></option>																	                    
				              	</select>
			                	</div> 
			              </div>		                    		                        
						</div>
					</div>									
				</div>	
	            <!-- </div> -->
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
                 url: "<%=request.getContextPath() %>/updatedemoele",
                 async : false, 
                 data: $("#validate-2").serialize(),
                 success: function(mes) { 
                 	if(mes.message=="success") {			
			 			$("#updatesaleleModel").modal("hide");
			 			$("#updatesaleleModel").empty();
			 			torefreshdemo();
			 			alert("模板项修改成功");
					}else{
						alert("模板项修改失败");
					} 
                 } 
             }); 
        }    
	    });
	 });
    </script>  
	
  </body>
</html>
