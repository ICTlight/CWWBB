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
		    width: 800px
		}
		
     </style>
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
             <form class="form-horizontal"  id="validate-2">
             	<input type="hidden" id="labour_id" name = "labour_id"/>
				<input type="hidden" id="acquirer_id" name = "acquirer_id"/> 
	            <div class="modal-body">	                    	
                           <br>
                                <div class="row">
									<div class="col-md-4" >
										<div>
										     <div class="form-group">
						                      <label class="col-md-5 control-label">员工id:</label>
						                      <div class="col-md-7">
						                        <input type="text" class="form-control required" name="userid"  id="userid" />
						                      </div>
						                    </div>
						                    <div class="form-group">
						                      <label class="col-md-5 control-label">基本工资:</label>
						                      <div class="col-md-7">
						                        <input type="text" class="form-control required" name="usid"  id="usid" />
						                      </div>
						                    </div> 
						                    <div class="form-group">
						                      <label class="col-md-5 control-label">岗位工资:</label>
						                      <div class="col-md-7">
						                        <input type="text" class="form-control required" name=""  id="" />
						                      </div>
						                    </div>
										</div>
									</div>
				
					<div class="col-md-4" >
						<div >

		                     <div class="form-group">
		                      <label class="col-md-5 control-label">用户名:</label>
		                       <div class="col-md-7">
		                       <input type="text" class="form-control required" name="username"  id="username"/>
		           
		                      </div> 
		                    </div>
		                    <div class="form-group">
		                      <label class="col-md-5 control-label">差补:</label>
		                      <div class="col-md-7">
		                        <input type="text" class="form-control required" name=""  id="" />
		                      </div>
		                    </div>
		                    <div class="form-group">
		                      <label class="col-md-5 control-label">通讯补助:</label>
		                      <div class="col-md-7">
		                        <input type="text" class="form-control required" name=""  id="" />
		                      </div>
		                    </div>
		                    		                        
						</div>
					</div>
					
					<div class="col-md-4" >
						<div >
						<div class="form-group">
		                      <label class="col-md-5 control-label">住房补助:</label>
		                      <div class="col-md-7">
		                        <input type="text" class="form-control required" name=""  id="" />
		                      </div>
		                    </div>
		                    <div class="form-group">
		                      <label class="col-md-5 control-label">餐补:</label>
		                      <div class="col-md-7">
		                        <input type="text" class="form-control required" name=""  id="" />
		                      </div>
		                    </div>
		                    <div class="form-group">
		                      <label class="col-md-5 control-label">交通补助:</label>
		                      <div class="col-md-7">
		                        <input type="text" class="form-control required" name=""  id="" />
		                      </div>
		                    </div>
							<%-- <div class="form-group">
		                      <label class="col-md-5 control-label">工程量:</label>
		                      <div class="col-md-7">
		                        <input type="text" class="form-control" name="project_quantity"  id="project_quantity"/>
		                      </div>
		                    </div>
		                    <div class="form-group">
		                      <label class="col-md-5 control-label">供应商注册资金:</label>
		                      <div class="col-md-7">
		                        <input type="text" class="form-control" name="supplier_capital"  id="supplier_capital"/>
		                      </div>
		                    </div>
		                      <div class="form-group">
		                      <label class="col-md-5 control-label">协作队伍业绩:</label>
		                      <div class="col-md-7">
		                        <input type="text" class="form-control" name="supplier_performance"  id="supplier_performance"/>
		                      </div>
		                    </div>
		                     <div class="form-group">
		                      <label class="col-md-5 control-label">队伍规模要求:</label>
		                       <div class="col-md-7">
		                       
		                        <select class="form-control required" id="team_size" name="team_size">
		                        <option value="">请选择</option>
				                    <option value="<10">10以下</option>
				                    <option value="10~50">10~50</option>
				                    <option value="50~100">50~100</option>
				                    <option value=">100">100以上</option>
				                  </select>
		                      </div> 
		                    </div> --%>
							 <!-- <div class="form-group">
		                      <label class="col-md-5 control-label">证书附件url列表</label>
		                      <div class="col-md-7">
		                        <input type="text" class="form-control" name="fileurl_list"  id="fileurl_list" />
		                      </div>
		                    </div>  -->
		                         
						</div>
					</div>
				</div>	
                      <!-- </div>
                   </div> 
                                    
	                                     
	            </div>
	            </div> -->
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
        	$("#addsalpelModel").modal("hide");
           <%-- $.ajax({ 
                 type: "POST", 
                 url: "<%=request.getContextPath() %>/saveLabourac",
                 async : false, 
                 data: $("#validate-2").serialize(),
                 success: function(mes) { 
                 	if(mes.message=="success") {
			 			jQuery("#pbEmpTablelw").trigger("reloadGrid");   			
			 			$("#addsalpelModel").modal("hide");
			 			$("#addsalpelModel").empty();
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
