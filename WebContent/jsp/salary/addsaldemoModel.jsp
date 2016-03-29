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
		    width: 500px
		}		
     </style>
      <script type="text/javascript">
      $(function(){
    	  /*   $(document).on("hidden.bs.modal", function (e) {
	 	    $(e.target).removeData("bs.modal").find(".modal-content").empty();
	 	}); */   
	      /* $("#addsaldemoModel").on("hidden.bs.modal", function() {
	    	  alert("1");
	    	    $(this).removeData("bs.modal");
	    	}); */ 
	    /* $('body').on('hidden.bs.modal', '.modal', function () { 
	    	   alert("1");
	    	   $(this).removeData('bs.modal'); 
	    });  */
    	 /* $('body').on('hidden.bs.modal', '.modal', function (e) {
    		 alert("1");
    		 $(e.target).removeData("bs.modal").find(".modal-content").empty();
 	 	}); */
	      /* $("#addsaldemoModel").on("hidden", function() {
	    	  alert("1");
	    	    $(this).removeData("modal");
	    	}); */
    	$("#addsaldemoModel").on("hidden.bs.modal", function() {
    		 $(this).remove(".modal");   		 
    	}); 
	    	
    	 
     });
     /* function closedemoModel(){
		 alert("3");
   	  $("#addsaldemoModel").modal("hide");
   	//$("#href_addsal").html("");
     } */
     </script>
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
	            <div class="modal-body">	                    		                                          
                    <div class="row">
                    <br>
                    <div class="col-md-1"></div>
                    <div class="col-md-9" >
					     <div class="form-group">
		                     <label class="col-md-5 control-label">模板名称:</label>
		                     <div class="col-md-7">
		                       <input type="text" class="form-control required" name="saldemoname"  id="saldemoname" />
		                     </div>
		                 </div>
		                 <div class="form-group">
		                     <label class="col-md-5 control-label">英文名称:</label>
		                     <div class="col-md-7">
		                       <input type="text" class="form-control" name="saldemoen"  id="saldemoen" />
		                     </div>
		                 </div> 
		                 <div class="form-group">
		                     <label class="col-md-5 control-label">模板简称:</label>
		                     <div class="col-md-7">
		                       <input type="text" class="form-control" name="saldemost"  id="saldemost" />
		                     </div>
		                 </div>
		                 <div class="form-group">
		                     <label class="col-md-5 control-label">模板描述:</label>
		                     <div class="col-md-7">
		                       <input type="text" class="form-control" name="saldemods"  id="saldemods" />
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
            $.ajax({ 
                 type: "POST", 
                 url: "<%=request.getContextPath() %>/saveSalDemo",
                 async : true, 
                 data: $("#validate-2").serialize(),
                 success: function(mes) { 
                 	if(mes.message=="success") {  			
			 			$("#addsaldemoModel").modal("hide");
			 			//$("#addsaldemoModel").empty();
			 			toadddemos();
			 			alert("模板添加成功");
					}else if(mes.message=="error"){
						alert("模板添加失败");
					} 
                 } 
             }); 
        }    
	    });
	 });
      
    </script>  	
  </body>
</html>
