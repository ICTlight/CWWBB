<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr >
		<form id="attrForm0" role="form" class="form-horizontal" enctype="multipart/form-data">
			<td align="left" width="80%" ><input type="file" name="attName" ></td>
			<td align="center" width="15%" ><input type="button" id="bt0" onclick="getFormId(this)" value="上传附件"/>
											<input type="hidden" id="fileUrl" name="fileUrl"></td>
			<td align="center" width="15%" ><input type="button" id="fileUrl" name="del" onclick='removeRow(this)' value="删除"></td>
		</form>
	</tr>
</table>

</body>
</html>