<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css" />
	<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
	<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/styles/default.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.1.4.min.js"></script>
	<style type="text/css">
	.hover{
		border: 1px dashed rgb(153, 187, 232) !important;
	}
	</style>
	<script type="text/javascript">
	$(function(){
		$(".easyui-linkbutton").hover(function(){
			$(this).addClass("hover");
		},function(){
			$(this).removeClass("hover");
			})
	})
	
	function addtab(obj,url){
		var t = $(obj).text();
		var e = $("#tt").tabs("exists",t);
		if(e){
			$("#tt").tabs("select",t);
		}else{
		$('#tt').tabs('add',{    
		    title:t,    
		    content:'<iframe src="'+url+'" frameborder="0" scrolling="auto" width="100%" height="100%"></iframe>',    
		    closable:true,    
		
		});
		}
	}
		
	</script>
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
	    <div data-options="region:'west',title:'导航菜单',split:true" style="width:180px;"class="easyui-accordion" ;>
	    	  <!-- 导航start -->
				    <div title="测试菜单" data-options="iconCls:'icon icon-sys'" style="overflow:auto;padding:10px;">   
				        <h3 style="color:#0099FF;">Accordion for jQuery</h3>   
				        <p>Accordion is a part of easyui framework for jQuery.     
				        It lets you define your accordion component on web page more easily.</p>   
				    </div>   
				    <div title="系统管理" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">   
				        <a  href="#" class="easyui-linkbutton" onclick="addtab(this,'http://www.itheima.com')" data-options="iconCls:'icon icon-log',plain:true" style="width:95%;text-align:left;">用户管理</a>  
				        <a  href="#" class="easyui-linkbutton" onclick="addtab(this,'http://www.itheima.com')" data-options="iconCls:'icon icon-log',plain:true" style="width:95%;text-align:left;">角色授权</a>  
				        
				    </div>   
				    <div title="药品目录">   
				        content3    
				    </div>   
	    	  <!-- 导航end -->
	    </div>   
	    <div id="tt"data-options="region:'center'" style="" class="easyui-tabs">
			    <div title="欢迎使用" style="padding:20px;">   
			        tab1    
			    </div>   
			    
	    
	    </div>   
</body>
</html>