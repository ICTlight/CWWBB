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
		    width: 700px
		}		
     </style>
	<script type="text/javascript">
	$(function(){
		$("#addsaleleModel").on("hidden.bs.modal", function() {
			$(this).remove(".modal");  	 
		});
	});
     </script>
     <script type="text/javascript">     
     
       $(function(){
	       //默认选择tab
          $("#demoeleupTab a:first").tab('show');//初始化显示哪个tab   
          //tab点击事件
          $("#demoeleupTab a").click(function (e) {
         	      	  
         	  if($(this).attr("href") =="#tab_1_10"){	 
	         	  $(this).tab('show');	
         	  }		   				   		
                              
              if($(this).attr("href") =="#tab_1_11") { 
            	  $(this).tab('show');                  
              }
              
          }); 
        }); 
       </script>
  </head>
  <body>
    <div class="modal fade" data-backdrop='static' id="addsaleleModel">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                &times;
              </button>
              <h4 class="modal-title">
               	 <i class="icon-reorder"></i> 创建模板项信息
              </h4>
            </div>
             <form class="form-horizontal"  id="validate-2">
             	<input type="hidden" id="demoid" name = "demoid_st" value="${salaryDemoEle.demoid}"/>
				<input type="hidden" id="demoname" name ="demoname" value="${salaryDemoEle.demoname}"/> 
	            <div class="modal-body">	                
                         <br>
                                <div class="row">
									<div class="col-md-6" >
										<div>
										     <div class="form-group">
						                      <label class="col-md-5 control-label">属性名称:</label>
						                      <div class="col-md-7">
						                        <input type="text" class="form-control required" name="elename"  id="elename"  value=""/>
						                      </div>
						                    </div>
						                    <!-- <div class="form-group">
						                      <label class="col-md-5 control-label">固定代码:</label>
						                      <div class="col-md-7">
						                        <input type="text" class="form-control required" name="fixedcode"  id="fixedcode"  value=""/>
						                      </div>
						                    </div> -->
						                    <div class="form-group">
						                      <label class="col-md-5 control-label">显示项:</label>
						                       <div class="col-md-7">			                       
						                        <select class="form-control" id="isshow" name="isshow">
						                            <option value="0">否</option>
								                    <option value="1">是</option>
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
		                        <select class="form-control" id="cptype" name="cptype">
				                    <option value="0">税无关</option>
				                    <option value="1">税前加</option>
				                    <option value="2">税前减</option>
				                    <option value="3">税后加</option>
				                    <option value="4">税后减</option>
				                    <option value="5">应纳税所得额调整加</option>
				                    <option value="6">应纳税所得额调整减</option>
				                    <option value="7">税调整加</option>
				                    <option value="8">税调整减</option>
				                    <option value="9">税后推税（税后发公司付税）</option>
				                    <option value="10">税后推税（税后不发公司付税）</option>
				                  </select>
		                      </div> 
		                    </div>
			          		<div class="form-group">
			                	<label class="col-md-5 control-label">精确度:</label>
			                 	<div class="col-md-7">
				                  <select class="form-control" id="precisions" name="precisions">
				                    <option value="0">分位</option>
				                	<option value="1">角位</option>
				                	<option value="2">元位</option>		
				              	</select>
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
            $.ajax({ 
                 type: "POST", 
                 url: "<%=request.getContextPath() %>/saveSalEleDemo",
                 async : true, 
                 data: $("#validate-2").serialize(),
                 success: function(mes) { 
                 	if(mes.message=="success") {			
			 			$("#addsaleleModel").modal("hide");
			 			//$("#addsaleleModel").empty();			 			
			 			alert("模板项创建成功");
			 			toadddemoeles();
					}else{
						alert("模板项创建失败");
					} 
                 } 
             }); 
        }    
	    });
	 });
    </script>  
	
  </body>
</html>
