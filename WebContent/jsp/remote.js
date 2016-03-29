appLogins({
	"userid":1000000013,
	"username":"Leo1",
	"email":"ittliu@yeah.net",
	"usertype":"个人用户",
	"password":"heihei",
	"status":"已验证",
	"createtime":"2015-11-25",
	"updatetime":"2015-11-25"
});
function flightHandler(username,password) {  
	alert("username....."+username);
	   var dictInfos="";   		  
		$.ajax({
				type : "POST",
				url : "./../appLogin",
				data: {"username" : username,"password":password},
				async : false,
				dataType : "json",
				success : function(result) {
				   dictInfos = result.user;  				   	  
				}						
			});
	   return dictInfos;
}