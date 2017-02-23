<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/tag.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>系统用户信息查询</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${baseurl}/js/easyui/jquery.edatagrid.js"></script>
<%@ include file="/common/common_css.jsp"%>
<%@ include file="/common/common_js.jsp"%>
<script type="text/javascript">
 
 




$(function(){
	
		var col_arr=[[    
		               {field:'usercode',title:'用户账号',width:180 },    
		               {field:'username',title:'用户名称',width:180},  
		               
		               {field:'groupId',title:'用户类别',width:80,
							formatter:function(value,row,index){
								return row.sysDictInfoByGroupid.info;
							}
						},
						{field:'state',title:'用户状态',width:80,
							formatter:function(value,row){
								return row.sysDictInfoByUserstate.info;
							}
						},
						{field:'dw',title:'所属单位',width:180,
							formatter:function(value,row){
								//1 业务码
								var dictcode = row.sysDictInfoByGroupid.dictcode;
								
								//2 通过业务码 从不同的对象获得数据
								// * 卫生局 or 卫生院
								if(dictcode==1 || dictcode==2){
									return row.dwWsy.mc;
								}
								// * 卫生室
								if(dictcode==3){
									return row.dwWss.mc;
								}
								// * 供应商
								if(dictcode==4){
									return row.dwGys.mc;
								}
								return "";
								
							}
						},
						{field:'edit',title:'功能',width:180,width:40,formatter: function(value,rowData,rowIndex){
							return "<a onclick=\"edituser('"+rowData.id+"')\">修改</a>"; }},  
		           
		              
		           ]];  

			
			var toolbar_arr=[{
				iconCls: 'icon-add',
				text:"添加用户",
				handler: adduser
				},'-',{
				iconCls: 'icon-edit',
				text:"编辑用户",
				sortOrder:'asc',
				enableEditing:true,
				handler: function(){alert('帮助按钮')}
			}]
			var options={
					columns:col_arr ,
					title:'系统用户列表',			//标题
					toolbar: toolbar_arr,
					url:'/user/queryuser_result.action',
					rownumbers:true,				//行号
					pagination:true,				//分页条
					idField:'id',			//唯一表示
					
					
		
			}
			$('#sysuserlist').datagrid(options);
	
});
$(function(){
	$("#sysuser_groupid").change(function(){
		sysuserquery();
	})
	
})
function adduser(){
	createmodalwindow("添加用户",700,220,"${baseurl}/user/adduser.action");
}

//删除用户
function deluser(id){
	//点击确定执行function() 
	_confirm('您确定要执行删除操作吗?', null, function() {
		//将id赋值给sysuserdelid对象
		$("#sysuserdelid").val(id);
		jquerySubByFId('sysuserdelForm', sysuserdel_callback, null, "json");
	});
}
//修改用户
function edituser(id){
	//打一个模态窗口 
	var sendUrl = "${baseurl}/user/edituser.action?sysUserCustom.id="+id;
	//参数：1、窗口标题、2、宽、3：高、4、url
	createmodalwindow("修改用户信息", 800, 250, sendUrl);
	
}
function sysuserdel_callback(data) {
	_alert(data);
	//重新查询用户列表
	sysuserquery();
}
//添加用户
function sysuseradd(){
	//打一个模态窗口 
	var sendUrl = "${baseurl}/user/adduser.action";
	//参数：1、窗口标题、2、宽、3：高、4、url
	createmodalwindow("添加用户信息", 800, 250, sendUrl);
	
}
function sysuserquery(){
	//查询数据列表，执行load方法重新加载datagrid，重新请求返回json的url获取json数据
	//load方法的参数就是输入查询条件，格式是json
	//load的参数是json数据，将form表单的内容转json
	//sysuserqueryForm就是form的id
	var formdata = $("#sysuserqueryForm").serializeJson();
	/*  $('#sysuserlist').datagrid('load',{
		'sysUserCustom.usercode': 'cmzzzc'
	});  */
	$('#sysuserlist').datagrid('reload',formdata);
	

}

function sysuserquery(){
	var params = $("#sysuserqueryForm").serializeJson(); 
	$('#sysuserlist').datagrid('reload',params);


	
}

function findAll(){
	sysuserquery();
}

 function edituser(id){
	 createmodalwindow("编辑用户",650,220,"/user/edituser.action?sysUserCustom.id=" + id);
}
</script>
</head>
<body>
<!-- 先写布局 -->
<s:debug></s:debug>
<form id="sysuserqueryForm" name="sysuserqueryForm" method="post" action="">
			<TABLE class="table_search">
				<TBODY>
					<TR>
						<TD class="left" >用户账号：${sysUserCustom.usercode }</td>
						<td><INPUT id="code" onkeydown="findAll()" type="text" name="sysUserQueryCustom.usercode" /></TD>
						<TD class="left">用户名称：</TD>
						<td><INPUT type="text" onkeydown="findAll()" name="sysUserQueryCustom.username" /></TD>

						<TD class="left">用户类型：</TD>
						<td>
							<select id="sysuser_groupid" name="sysUserQueryCustom.sysDictInfoByGroupid.id">
								<option value="" >请选择</option>
								<c:forEach items="${userGroupList}" var="dictinfo">
								  <option  value="${dictinfo.id}">${dictinfo.info}</option>
								</c:forEach>
							</select>
						</TD>
						<td >
						<a id="btn" href="#" onclick="sysuserquery()"
							class="easyui-linkbutton" iconCls='icon-search'>查询</a>
							</td>
					</TR>


				</TBODY>
			</TABLE>
			
		</form>
		
<!-- datagrid -->
<TABLE border=0 cellSpacing=0 cellPadding=0 width="99%" align=center>
		<TBODY>
			<TR>
				<TD>
					<table id="sysuserlist"></table>
				</TD>
			</TR>
		</TBODY>
</TABLE>

<!-- 此form用于删除用户 -->
<form id="sysuserdelForm" action="${baseurl }/user/deleteuser.action" method="post">
	<!-- form中包括要删除用户的id -->
	<input type="hidden"  id="sysuserdelid" name="sysUserCustom.id"/>
</form>
</body>

</html>