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
	     $(document).on("hidden.bs.modal", function (e) {
	 	    $(e.target).removeData("bs.modal").find(".modal-content").empty();
	 	});
     });
     </script>
     <script type="text/javascript">     
       $(function(){
    	   
	       //默认选择tab
          $("#demoeleTab a:first").tab('show');//初始化显示哪个tab   
          //tab点击事件
          $("#demoeleTab a").click(function (e) {
         	      	  
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
        <div class="modal-dialo">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                &times;
              </button>
              <h4 class="modal-title">
               	 <i class="icon-reorder"></i> 添加模板项信息
              </h4>
            </div>
             <form class="form-horizontal"  id="validate-2">
             	<input type="hidden" id="labour_id" name = "labour_id"/>
				<input type="hidden" id="acquirer_id" name = "acquirer_id"/> 
	            <div class="modal-body">	                
                      <div class="tabbable tabbable-custom">
                        <ul class="nav nav-tabs" id="demoeleTab">
                          <li><a href="#tab_1_10">基本项</a></li>
                          <li><a href="#tab_1_11"> 社保公积金项</a></li>                          
                         </ul>
                         <br>
                         <div class="tab-content">
                            <div class="tab-pane" id="tab_1_10">
                                <div class="row">
									<div class="col-md-6" >
										<div>
										     <div class="form-group">
						                      <label class="col-md-5 control-label">属性名称:</label>
						                      <div class="col-md-7">
						                        <input type="text" class="form-control required" name="userid"  id="userid" />
						                      </div>
						                    </div>
						                    <div class="form-group">
						                      <label class="col-md-5 control-label">固定代码:</label>
						                      <div class="col-md-7">
						                        <input type="text" class="form-control required" name="usid"  id="usid" />
						                      </div>
						                    </div>
						                    <div class="form-group">
						                      <label class="col-md-5 control-label">是否显示:</label>
						                       <div class="col-md-7">			                       
						                        <select class="form-control required" id="team_size" name="team_size">
						                        <option value="">请选择</option>
								                    <option value="显示">显示</option>
								                    <option value="不显示">不显示</option>					
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
		                       
		                        <select class="form-control required" id="team_size" name="team_size">
		                        <option value="">请选择</option>
				                    <option value="税无关">税无关</option>
				                    <option value="税前加">税前加</option>
				                    <option value="税前减">税前减</option>
				                    <option value="税后加">税后加</option>
				                    <option value="税后减">税后减</option>
				                    <option value="应纳税所得额调整加">应纳税所得额调整加</option>
				                    <option value="应纳税所得额调整减">应纳税所得额调整减</option>
				                    <option value="税调整加">税调整加</option>
				                    <option value="税调整减">税调整减</option>
				                    <option value="税后推税（税后发公司付税）">税后推税（税后发公司付税）</option>
				                    <option value="税后推税（税后不发公司付税）">税后推税（税后不发公司付税）</option>
				                  </select>
		                      </div> 
		                    </div>
			          		<div class="form-group">
			                	<label class="col-md-5 control-label">精确度:</label>
			                 	<div class="col-md-7">
				                  <select class="form-control required" id="team_size" name="team_size">
				                	<option value="分位">分位</option>
				                	<option value="角位">角位</option>
				                	<option value="元位">元位</option>								                    
				              	</select>
			                	</div> 
			              </div>		                    		                        
						</div>
					</div>									
				</div>	
              </div>
              <div class="tab-pane active" id="tab_1_11">
                  <div>
					<script type="text/javascript">
						$("ul:first").dragsort();
					</script>	
					<ul id="list2">
						<li><div>大病公司</div></li>
						<li><div>大病个人</div></li>
						<li><div>住房公司</div></li>
						<li><div>住房个人</div></li>
						<li><div>工伤公司</div></li>
						<li><div>失业公司</div></li>						
					</ul>					
					<ul id="list1">
						<li><div>养老公司</div></li>
						<li><div>养老个人</div></li>
						<li><div>生育公司</div></li>
						<li><div>失业个人</div></li>
						<li><div>医疗公司</div></li>
						<li><div>医疗个人</div></li>
					</ul>					
					<input name="list1SortOrder" type="hidden" />
					<script type="text/javascript">
						$("#list1, #list2").dragsort({ dragSelector: "div", dragBetween: true, dragEnd: saveOrder, placeHolderTemplate: "<li class='placeHolder'><div></div></li>" });
						function saveOrder() {
							var data = $("#list1 li").map(function() { return $(this).children().html(); }).get();
							$("input[name=list1SortOrder]").val(data.join("|"));
						};
					</script>				
					<div style="clear:both;"></div>
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
        	alert("添加成功");
        	$("#addsaleleModel").modal("hide");
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
