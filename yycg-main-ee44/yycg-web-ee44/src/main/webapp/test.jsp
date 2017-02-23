<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/tag.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common/common_css.jsp"%>
<%@ include file="/common/common_js.jsp"%>
<script src="${baseurl}/js/boostrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/first.js"></script>
<script type="text/javascript" src="js/easyui/jquery.edatagrid.js"></script>
<script type="text/javascript">
$(function(){
	$('#tt').edatagrid({    
	    url: 'menu.json',    
	   
	});   
})
</script>

</head>
<body>
<table id="tt" style="width:600px;height:200px"   
        title="Editable DataGrid"   
        singleSelect="true">   
    <thead>   
        <tr>   
            <th field="menuid" width="100" editor="{type:'validatebox',options:{required:true}}">menuid</th>   
            <th field="menuname" width="100" editor="text">menuname</th>   
            <th field="listprice" width="100" align="right" editor="{type:'numberbox',options:{precision:1}}">List Price</th>   
            <th field="unitcost" width="100" align="right" editor="numberbox">Unit Cost</th>   
            <th field="attr1" width="150" editor="text">Attribute</th>   
        </tr>   
    </thead>   
</table>  

</body>
</html>