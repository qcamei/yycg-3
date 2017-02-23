<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/tag.jsp"%>
<html>
  <head>
    <title>添加用户</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

<%@ include file="/common/common_css.jsp"%>
<%@ include file="/common/common_js.jsp"%>

	<script type="text/javascript">
	
	 $(function(){
		//***********按钮**************
			$('#submitbtn').linkbutton({   
	    		iconCls: 'icon-ok'  
			});  
			$('#closebtn').linkbutton({   
	    		iconCls: 'icon-cancel'  
			});
		/* 下拉框选项改变事件 */
		$("#sysuser_groupid").change(function(){
			var dictcode = $(this.options[this.selectedIndex]).data("dictcode");
			
			var params = {"sysUserQueryCustom.sysDictInfoByGroupid.dictcode":dictcode};
			var url="/user/findDwByDictcode.action"; 
			$.post(url,params,function(data){
				//设置默认值
				$("#dwSelect").html("<option value=''>--请选择--</option>");
				
				$.each(data,function(){
					$("#dwSelect").append("<option value='"+this.id+"'>"+this.mc+"</option>");
				})
				
					
				
			},"json")
		if(dictcode==1||dictcode==2){
			/* 设置name的属性 */
			$("#dwSelect").attr("name","sysUserCustom.dwWsy.id");
		}
		if(dictcode==3){
			/* 设置name的属性 */
			$("#dwSelect").attr("name","sysUserCustom.dwWss.id");
		}
		if(dictcode==4){
			/* 设置name的属性 */
			$("#dwSelect").attr("name","sysUserCustom.dwGys.id");
		}
		})
	})
	
	/* 保存客户 */
	function sysusersave(){
			jquerySubByFId("sysusereditform" ,submitForm_callback);
	 }
	 /* 回调函数 */
	 function submitForm_callback(data){
		 message_alert(data, sysusersave_message_callback)
		 
	 }
	 function sysusersave_message_callback(){
		 parent.closemodalwindow();
			//刷新datagrid
			parent.sysuserquery();
	 }
	
	</script>
 </HEAD>
<BODY>
<form id="sysusereditform" name="sysusereditform" action="${baseurl}/user/adduser_submit.action" method="post" >
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" bgColor=#c4d8ed>
		<TBODY>
			<TR>
				<TD background=images/r_0.gif width="100%">
					<TABLE cellSpacing=0 cellPadding=0 width="100%">
						<TBODY>
							<TR>
								<TD>&nbsp;系统用户信息</TD>
								<TD align=right>&nbsp;</TD>
							</TR>
						</TBODY>
					</TABLE>
				</TD>
			</TR>
			<TR>
				<TD>
					<TABLE class="toptable grid" border=1 cellSpacing=1 cellPadding=4
						align=center id="">
						<TBODY>
							
							<TR>
								<TD height=30 width="15%" align=right >用户账号：</TD>
								<TD class=category width="35%">
								<div>
								<input type="text" id="sysuser_usercode" name="sysUserCustom.usercode" />
								</div>
								<!-- 失败信息提示区域 sysuser_usercodeTip，命名规则：input的id + Tip-->
								<div id="sysuser_usercodeTip"></div>
								</TD>
								<TD height=30 width="15%" align=right >用户名称：</TD>
								<TD class=category width="35%">
								<div>
								<input type="text" id="sysuser_username" name="sysUserCustom.username"  />
								</div>
								<div id="sysuser_usernameTip"></div>
								</TD>
							</TR>
							
							
							<TR>
								<TD height=30 width="15%" align=right >用户密码：</TD>
								<TD class=category width="35%">
								<div>
									<input type="password" id="sysuser_password" name="sysUserCustom.pwd" />
									<!-- 加一个隐藏密码框，防止密码 自动填充 -->
									<input type="password" style="display:none"/>
								</div>
								<div id="sysuser_passwordTip"></div>
								</TD>
								<TD height=30 width="15%" align=right >用户类型：</TD>
								<TD class=category width="35%">
								<div>
								<select name="sysUserCustom.sysDictInfoByGroupid.id" id="sysuser_groupid">
									<option value="">请选择</option>
									<c:forEach items="${userGroupList}" var="dictinfo">
									  <c:if test="${dictinfo.dictcode > 0}">
									   <option data-dictcode="${dictinfo.dictcode}" value="${dictinfo.id}" >${dictinfo.info}</option>
									   <%-- <c:if test="${sysUserCustom.sysDictInfoByGroupid.id== dictinfo.id}">selected</c:if> --%>
									  </c:if>
									</c:forEach>
									
								</select>
								</div>
								<div id="sysuser_groupidTip"></div>
								</TD>

							</TR>
							<TR>
							    <TD height=30 width="15%" align=right >用户单位名称：</TD>
								<TD class=category width="35%">
								<!-- <input type="text" name="sysUserCustom.sysmc"/> -->
									<select id="dwSelect" name="">
										<option value="">--请选择--</option>
									</select>
								</TD>
								<TD height=30 width="15%" align=right>用户状态：</TD>
								<TD class=category width="35%">
								<c:forEach items="${userStateList}" var="dictinfo">
								   <input type="radio" name="sysUserCustom.sysDictInfoByUserstate.id" value="${dictinfo.id}" />${dictinfo.info}
							<%-- 	   <c:if test="${sysUserCustom.sysDictInfoByUserstate.id== dictinfo.id}">checked</c:if> --%>
								</c:forEach>								
								</TD>
							</TR>
							
							<tr>
							  <td colspan=4 align=center class=category>
								<a id="submitbtn" href="#" onclick="sysusersave()">提交</a>
								<a id="closebtn" href="#" onclick="parent.closemodalwindow()">关闭</a>
							  </td>
							</tr>
						
						</TBODY>
					</TABLE>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
</form>

</BODY>
</HTML>

