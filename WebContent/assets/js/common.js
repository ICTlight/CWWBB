/*
 * MAP对象，实现MAP功能
 *
 * 接口：
 * size()     获取MAP元素个数
 * isEmpty()    判断MAP是否为空
 * clear()     删除MAP所有元素
 * put(key, value)   向MAP中增加元素（key, value) 
 * remove(key)    删除指定KEY的元素，成功返回True，失败返回False
 * get(key)    获取指定KEY的元素值VALUE，失败返回NULL
 * element(index)   获取指定索引的元素（使用element.key，element.value获取KEY和VALUE），失败返回NULL
 * containsKey(key)  判断MAP中是否含有指定KEY的元素
 * containsValue(value) 判断MAP中是否含有指定VALUE的元素
 * values()    获取MAP中所有VALUE的数组（ARRAY）
 * keys()     获取MAP中所有KEY的数组（ARRAY）
 *
 * 例子：
 * var map = new Map();
 *
 * map.put("key", "value");
 * var val = map.get("key")
 * ……
 *
 */
function Map() {
    this.elements = new Array();

    //获取MAP元素个数
    this.size = function() {
        return this.elements.length;
    };

    //判断MAP是否为空
    this.isEmpty = function() {
        return (this.elements.length < 1);
    };

    //删除MAP所有元素
    this.clear = function() {
        this.elements = new Array();
    };

    //向MAP中增加元素（key, value) 
    this.put = function(_key, _value) {
        this.elements.push( {
            key : _key,
            value : _value
        });
    };

    //删除指定KEY的元素，成功返回True，失败返回False
    this.remove = function(_key) {
        var bln = false;
        try {
            for (i = 0; i < this.elements.length; i++) {
                if (this.elements[i].key == _key) {
                    this.elements.splice(i, 1);
                    return true;
                }
            }
        } catch (e) {
            bln = false;
        }
        return bln;
    };

    //获取指定KEY的元素值VALUE，失败返回NULL
    this.get = function(_key) {
        try {
            for (i = 0; i < this.elements.length; i++) {
                if (this.elements[i].key == _key) {
                    return this.elements[i].value;
                }
            }
        } catch (e) {
            return null;
        }
    };

    //获取指定索引的元素（使用element.key，element.value获取KEY和VALUE），失败返回NULL
    this.element = function(_index) {
        if (_index < 0 || _index >= this.elements.length) {
            return null;
        }
        return this.elements[_index];
    };

    //判断MAP中是否含有指定KEY的元素
    this.containsKey = function(_key) {
        var bln = false;
        try {
            for (i = 0; i < this.elements.length; i++) {
                if (this.elements[i].key == _key) {
                    bln = true;
                }
            }
        } catch (e) {
            bln = false;
        }
        return bln;
    };

    //判断MAP中是否含有指定VALUE的元素
    this.containsValue = function(_value) {
        var bln = false;
        try {
            for (i = 0; i < this.elements.length; i++) {
                if (this.elements[i].value == _value) {
                    bln = true;
                }
            }
        } catch (e) {
            bln = false;
        }
        return bln;
    };

    //获取MAP中所有VALUE的数组（ARRAY）
    this.values = function() {
        var arr = new Array();
        for (i = 0; i < this.elements.length; i++) {
            arr.push(this.elements[i].value);
        }
        return arr;
    };

    //获取MAP中所有KEY的数组（ARRAY）
    this.keys = function() {
        var arr = new Array();
        for (i = 0; i < this.elements.length; i++) {
            arr.push(this.elements[i].key);
        }
        return arr;
    };
}

/**
 * 表格插件jqgrid字典显示数据
 * code 为dict表的 dict_code字段值
 * 例子：jqgrid中colModel的配置
 * {name:'status_',index:'status_',sorttype:"String", edittype:'select', stype:'select', editable: true,formatter:'select', editoptions:{value:getDict("status")}}
 */
function getDict(code) {   		  
	   var dictInfos="";   		  
		$.ajax({
				type : "POST",
				url : "./../dict/getDictInfos.do",
				data: {"code" : code},
				async : false,
				dataType : "json",
				success : function(result) {
				   dictInfos = result.editoption;  
				   	  
				}						
			});
	   return dictInfos;
}

/**
 * 表格插件jqgrid字典显示数据
 * code 为dict表的 dict_code字段值
 * 例子：jqgrid中colModel的配置
 * {name:'status_',index:'status_',sorttype:"String", edittype:'select', stype:'select', editable: true,formatter:'select', editoptions:{value:getDict("status")}}
 */
function getDictForSt(code) {   		  
   var dictInfos="";   		  
	$.ajax({
			type : "POST",
			url : "./../dict/getDictInfos.do",
			data: {"code" : code},
			async : false,
			dataType : "json",
			success : function(result) {				
				var opObject=result.editoption;
				opObject = opObject.substring((opObject.indexOf(';')+1),opObject.length);
			   dictInfos = opObject;   	  
			}						
		});
   return dictInfos;
}

/**
 * 此表格第一行有查询功能、显示行号、分业
 * @param tableName 表格id
 * @param pager 分页div的id
 * @param colNames 表头展现的名称与colmodel数量对应
 * @param colModel 表格数据展示，
 * @param multiselect 是否多选
 * @param sortname 默认排序列
 * @param title 表格上的title
 * @param url 查询url
 */
function loadTable(tableName,pager,colNames,colModel,multiselect,sortname,title,url) {
    jQuery("#" + tableName).jqGrid({
			 datatype: "json",//请求的数据类型
			 mtype : "POST",
			 url:url,	   						
      	 height: 250,	
      	 async : false,	       					       				
      	 loadtext: "Loading...",
      	 altRows:true,//隔行换色
      	 autowidth:true,//自适应宽度
      	 autoScroll: true,
		 altclass:'altclass',//隔行变色样式
      	 rownumbers: true,//显示行号
	     colNames:colNames,	   	        			
	   	 colModel:colModel,
	   	 pager:'#' + pager, //分页工具栏  
		 multiselect: multiselect,//多选
		 rowNum:10, //每页显示记录数  
		 viewrecords: true, //是否显示行数  
		 rowList:[10,30,50,300], //可调整每页显示的记录数        			
		 recordpos:'right',        					
			 sortname: sortname,	
			 sortorder: "desc",  					   
			 jsonReader:{root:"list",repeatitems:false},
			 caption: "<i class='icon-reorder'></i> " + title//标题
	});	 
						
	    jQuery("#" + tableName).jqGrid('navGrid','#' + pager,{edit:false,add:false,del:false,search:false,refresh:false}); 
		jQuery("#" + tableName).jqGrid('filterToolbar',{stringResult: true,searchOnEnter : false});

}

function loadTableByFixed(tableName,pager,colNames,colModel,multiselect,sortname,title,url) {
    jQuery("#" + tableName).jqGrid({
			 datatype: "json",//请求的数据类型
			 mtype : "POST",
			 url:url,	   						
      	 height: 250,	
      	 async : false,	       					       				
      	 loadtext: "Loading...",
      	 //altRows:true,//隔行换色
      	 shrinkToFit:false,
      	 autowidth:true,//自适应宽度
      	 width:1,
      	 autoScroll: true,
		 altclass:'altclass',//隔行变色样式
      	 rownumbers: true,//显示行号
	     colNames:colNames,	   	        			
	   	 colModel:colModel,
	   	 pager:'#' + pager, //分页工具栏  
		 multiselect: multiselect,//多选
		 rowNum:10, //每页显示记录数  
		 viewrecords: true, //是否显示行数  
		 rowList:[10,30,50,500], //可调整每页显示的记录数        			
		 recordpos:'right',        					
			 sortname: sortname,	
			 sortorder: "desc",  					   
			 jsonReader:{root:"list",repeatitems:false},
			 caption: "<i class='icon-reorder'></i> " + title//标题
	});	 
						
	    jQuery("#" + tableName).jqGrid('navGrid','#' + pager,{edit:false,add:false,del:false,search:false,refresh:false}); 
		jQuery("#" + tableName).jqGrid('filterToolbar',{stringResult: true,searchOnEnter : false});

}

function loadTableMore(tableName,pager,colNames,colModel,multiselect,sortname,title,url,rowNum_,rowList_) {
    jQuery("#" + tableName).jqGrid({
			 datatype: "json",//请求的数据类型
			 mtype : "POST",
			 url:url,	   						
      	 height: 250,	
      	 async : false,	       					       				
      	 loadtext: "Loading...",
      	 altRows:true,//隔行换色
      	 autowidth:true,//自适应宽度
      	 autoScroll: true,
		 altclass:'altclass',//隔行变色样式
      	 rownumbers: true,//显示行号
	     colNames:colNames,	   	        			
	   	 colModel:colModel,
	   	 pager:'#' + pager, //分页工具栏  
		 multiselect: multiselect,//多选
		 rowNum:rowNum_, //每页显示记录数  
		 viewrecords: true, //是否显示行数  
		 rowList:rowList_, //可调整每页显示的记录数        			
		 recordpos:'right',        					
			 sortname: sortname,	
			 sortorder: "desc",  					   
			 jsonReader:{root:"list",repeatitems:false},
			 caption: "<i class='icon-reorder'></i> " + title//标题
	});	 
						
	    jQuery("#" + tableName).jqGrid('navGrid','#' + pager,{edit:false,add:false,del:false,search:false,refresh:false}); 
		jQuery("#" + tableName).jqGrid('filterToolbar',{stringResult: true,searchOnEnter : false});

}

function loadTableForSt(tableName,pager,colNames,colModel,multiselect,sortname,title,url) {
    jQuery("#" + tableName).jqGrid({
			 datatype: "json",//请求的数据类型
			 mtype : "POST",
			 url:url,	   						
      	 height: 250,	
      	 async : false,	       					       				
      	 loadtext: "Loading...",
      	 altRows:true,//隔行换色
      	 shrinkToFit:false,
      	 autowidth:true,//自适应宽度
      	 width:1,
      	 autoScroll: true,
		 altclass:'altclass',//隔行变色样式
      	 rownumbers: true,//显示行号
	     colNames:colNames,	   	        			
	   	 colModel:colModel,
	   	 pager:'#' + pager, //分页工具栏  
		 multiselect: multiselect,//多选
		 rowNum:10, //每页显示记录数  
		 viewrecords: true, //是否显示行数  
		 rowList:[10,30,50,500], //可调整每页显示的记录数        			
		 recordpos:'right',        					
			 sortname: sortname,	
			 sortorder: "desc",  					   
			 jsonReader:{root:"list",repeatitems:false},
			 caption: "<i class='icon-reorder'></i> " + title//标题
	});	 
						
	    jQuery("#" + tableName).jqGrid('navGrid','#' + pager,{edit:false,add:false,del:false,search:false,refresh:false}); 
		jQuery("#" + tableName).jqGrid('filterToolbar',{stringResult: true,searchOnEnter : false});

}


/**
 * 增加数据时打开的页面
 * @param modal 打开对话框的id
 * @param url 
 */
function openAddModal(modal,url,addDivId) {
	$("#" + modal).modal({
  		show: false
	});
	$("#" + addDivId).html("");
	$.ajax({
		type : "POST",
		url : url,
		async : true,
		dataType : "html",
		success : function(result){
			$("#" + addDivId).html(result);
			$("#" + modal).modal("show");
		}
	});
}

/**
 * 打开更新页面
 * @param table 表格id
 * @param modal modelid
 * @param url
 * @param param 传递的参数
 * @param colName ，如role_Id
 * @returns {Boolean}
 */
function openUpdateModal(table,modal,url,param,colName,divId) {

	var	selectRowIds = jQuery("#" + table).jqGrid('getGridParam','selarrrow');
    
	if(selectRowIds.length == 1) {
	    var rowDatas = $("#" + table).jqGrid('getRowData', selectRowIds[0]);
	    $("#" + modal).modal({
	  		show: false
		});
	  
		$("#" + divId).html("");		
		$.ajax({
			type : "POST",
			url : url + "?" + param + "=" + rowDatas[colName],										
			async : true,
			dataType : "html",
			success : function(result){
				$("#" + divId).html(result);
				$("#" + modal).modal("show");
		   }
	    });
	} else {
	    alert("请选择一条数据");
	    $("#" +divId).html("");
		return false;
    }
}


function deleteObj(table,colname,url, param) {
	var	selectRowIds = jQuery("#" + table).jqGrid('getGridParam','selarrrow');//selrow 单选；selarrow 可以多选行	
		
	if(selectRowIds.length > 0) {
		var rowIds = selectRowIds.toString().split(",");	
	    var paramValues = "";		
		for(var i = 0; i < selectRowIds.length; i++) {
		   
		    var rowDatas = $("#" + table).jqGrid('getRowData', rowIds[i]);
		    
		    paramValues = paramValues + rowDatas[colname] + ",";			    
		}			
		var value = {param :  paramValues.substring(0, paramValues.length - 1)};
		
		$.ajax({
			type : "POST",
			url : url + "?" + param + "=" + paramValues.substring(0, paramValues.length - 1),
			data: value,
			async : true,
			dataType : "json",
			success : function(result) {
			    if(result.message == "success") {
			       jQuery("#" + table).trigger("reloadGrid");   
			    }
			    if(result.message == "error") {
			    	 alert("删除失败");
			    }
			}						
		});
		
    } else {
	    alert("请选择数据");
	}
}

//停用
function stopObj(table,colname,url, param) {
	var	selectRowIds = jQuery("#" + table).jqGrid('getGridParam','selarrrow');//selrow 单选；selarrow 可以多选行	
		
	if(selectRowIds.length > 0) {
		var rowIds = selectRowIds.toString().split(",");	
	    var paramValues = "";		
		for(var i = 0; i < selectRowIds.length; i++) {
		   
		    var rowDatas = $("#" + table).jqGrid('getRowData', rowIds[i]);
		    
		    paramValues = paramValues + rowDatas[colname] + ",";			    
		}			
		var value = {param :  paramValues.substring(0, paramValues.length - 1)};
		
		$.ajax({
			type : "POST",
			url : url + "?" + param + "=" + paramValues.substring(0, paramValues.length - 1),
			data: value,
			async : true,
			dataType : "json",
			success : function(result) {
			    if(result.message == "success") {
			    	alert("停用成功");
			       jQuery("#" + table).trigger("reloadGrid");
			       
			    }
			    if(result.message == "error") {
			    	 alert("停用失败");
			    }
			}						
		});
		
    } else {
	    alert("请选择数据");
	}
}

//启用
function startObj(table,colname,url, param) {
	var	selectRowIds = jQuery("#" + table).jqGrid('getGridParam','selarrrow');//selrow 单选；selarrow 可以多选行	
		
	if(selectRowIds.length > 0) {
		var rowIds = selectRowIds.toString().split(",");	
	    var paramValues = "";		
		for(var i = 0; i < selectRowIds.length; i++) {
		   
		    var rowDatas = $("#" + table).jqGrid('getRowData', rowIds[i]);
		    
		    paramValues = paramValues + rowDatas[colname] + ",";			    
		}			
		var value = {param :  paramValues.substring(0, paramValues.length - 1)};
		
		$.ajax({
			type : "POST",
			url : url + "?" + param + "=" + paramValues.substring(0, paramValues.length - 1),
			data: value,
			async : true,
			dataType : "json",
			success : function(result) {
			    if(result.message == "success") {
			    	 alert("启用成功");
			       jQuery("#" + table).trigger("reloadGrid");
			      
			    }
			    if(result.message == "error") {
			    	 alert("启用用失败");
			    }
			}						
		});
		
    } else {
	    alert("请选择数据");
	}
}

function disPlayPbServiceName() {   		  
	   var dictInfos="";   		  
		$.ajax({
				type : "POST",
				url : "./../serviceItems/pbServiceItemsList/pbServiceDisplay.do",				
				async : false,
				dataType : "json",
				success : function(result) {
				   dictInfos = result.editoption;  
				   	  
				}						
			});
	   return dictInfos;
}


//附件产品版本信息
function disPlayVersionName(){
	var dictInfos="";   		  
	$.ajax({
		type : "POST",
		url : "./../stVersion/stVersionList/versionDisplay.do",				
		async : false,
		dataType : "json",
		success : function(result) {
		   dictInfos = result.editoption;  
		   	  
		}						
	});
   return dictInfos;
}
//附件name信息
function disPlayStName(){
	var dictInfos="";   
	
	$.ajax({
		type : "POST",
		url : "./../st/stList/stDisplay.do",				
		async : false,
		dataType : "json",
		success : function(result) {
		   dictInfos = result.editoption;  
		   	  
		}						
	});
   return dictInfos;
}
//社保公积金产品项
function disPlaySiItemName(){
	var dictInfos="";   		  
	$.ajax({
		type : "POST",
		url : "./../pbSiStandards/pbSiStandardList/siItemDisplay.do",				
		async : false,
		dataType : "json",
		success : function(result) {
		   dictInfos = result.editoption;  
		   	  
		}						
	});
   return dictInfos;
}
//工资产品项
function disPlayGzItemName(){
	var dictInfos="";   		  
	$.ajax({
		type : "POST",
		url : "./../serviceItems/pbServiceItemsList/gzItemDisplay.do",				
		async : false,
		dataType : "json",
		success : function(result) {
		   dictInfos = result.editoption;  
		   	  
		}						
	});
   return dictInfos;
}
//产品组合页面中使用
var pbServiceId = 0,pbServiceName = "";

//获取客户列表
function getCustomer_() {   		  
   var customers="";   		  
	$.ajax({
		type : "POST",
		url : "../customer/customerList/getCustomers.do",
		async : false,
		dataType : "json",
		success : function(result) {
		   customers = result.editoption; 				   	  
		}						
	});
   return customers;
} 
	
	//加载公司的字典
	function loadCustomerDict(customerId) {
		
		var customers="";
		var custurl = "../customer/customerList/getCustomers.do";
		if(customerId) {
			custurl = "../customer/customerList/getCustomerJson.do?customer_Id=" + customerId;
		}
		
		$.ajax({
			type : "POST",
			url:custurl,
			async : false,
			dataType : "json",
			success : function(result) {
			   customers = result.editoption; 
			}						
		});
		return customers;
	}
	//获取合同列表
	function getContract_() {   		  
		   var contracts="";   		  
			$.ajax({
					type : "POST",
					url : "../contract/contractList/getContract.do",
					async : false,
					dataType : "json",
					success : function(result) {
					   contracts = result.editoption; 				   	  
					}						
				});
		   return contracts;
		} 
