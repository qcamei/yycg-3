<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css" />
	<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.1.4.min.js"></script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:true" style="height:0px;">
	    <div style="background: url(${pageContext.request.contextPath}/images/layout-browser-hd-bg.gif) 50% 50% repeat-x rgb(127, 153, 190);">
	   		<img src="${pageContext.request.contextPath }/images/blocks.gif" height="20px" width="20px">
	   			<span style="color: #fff;font-size: 15px;">医药集采集系统</span>
	   			<span style="float:right;color:#fff;margin:5px 10px 0px 0px;">欢迎当前用户：   使用帮助    修改密码    退出系统  </span>
	    </div>
    </div>   
	    
	    <div data-options="region:'south',split:true" style="height:30px;background-color:#D2E0F2">
	    	<center>系统版本号:  发布日期</center>
	    </div>   
	    <div data-options="region:'west',title:'导航菜单',split:true" style="width:180px;"></div>   
	    <div data-options="region:'center'" style="padding:5px;"></div>   
</body>
</html>