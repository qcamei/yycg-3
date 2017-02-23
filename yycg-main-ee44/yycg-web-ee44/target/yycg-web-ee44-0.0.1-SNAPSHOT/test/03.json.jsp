<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<LINK rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css" />
<LINK rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.1.4.min.js"></script>

</head>
<table id="dg" ></table>


<script type="text/javascript">
var col_arr=[[{field :'productid',title:'编号',width : 100  },
              {field :'productname',title:'名称',width : 100  }]]
	$('#dg').datagrid({
		url : 'datagrid_data.json',
		columns : col_arr
	});
</script>
<body>

</body>
</html>