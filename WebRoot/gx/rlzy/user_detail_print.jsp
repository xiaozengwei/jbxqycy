<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>打印个人信息</title>
<!-- bootstrap - css -->
<link href="<%=request.getContextPath()%>/gx/BJUI/themes/css/bootstrap.css" rel="stylesheet">
<!-- core - css -->
<link href="<%=request.getContextPath()%>/gx/BJUI/themes/css/style.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/gx/BJUI/themes/purple/core.css" id="bjui-link-theme" rel="stylesheet">
<!-- plug - css -->
<link href="<%=request.getContextPath()%>/gx/BJUI/plugins/kindeditor_4.1.10/themes/default/default.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/gx/BJUI/plugins/colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/gx/BJUI/plugins/niceValidator/jquery.validator.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/gx/BJUI/plugins/bootstrapSelect/bootstrap-select.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/gx/BJUI/themes/css/FA/css/font-awesome.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/gx/BJUI/themes/css/style-my.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/gx/BJUI/js/jquery-1.7.2.min.js"></script>
 <script src="<%=request.getContextPath()%>/gx/BJUI/other/html5shiv.min.js"></script>
<!-- bootstrap plugins -->
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-core.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-regional.zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-frag.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-extends.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-basedrag.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-pagination.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-util.date.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-datagrid.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-tablefixed.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-tabledit.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-spinner.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-lookup.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-tags.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-initui.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-plugins.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-zmy.js"></script>

<!-- plugins -->
<!-- kindeditor -->
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/kindeditor_4.1.10/kindeditor-all.min.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/kindeditor_4.1.10/lang/zh_CN.js"></script>
<style>
.btn-blue {
  color: #428bca;
  background: #FFFFFF;
  border-color: #428bca;
}
.btn{
  height: 24px;
  padding: 2px 8px;
  line-height: 1.29758;
  border-radius: 3px;
 }

</style>
<script type="text/javascript">

    $(function() {
    	  BJUI.init({
        JSPATH       : '../gx/BJUI/',         //[可选]框架路径
        PLUGINPATH   : '../gx/BJUI/plugins/', //[可选]插件路径
        loginInfo    : {url:'login_timeout.html', title:'登录', width:400, height:200}, // 会话超时后弹出登录对话框
        keys         : {statusCode:'statusCode', message:'message'}, //[可选]
        ui           : {
                         windowWidth      : 0,    //框架可视宽度，0=100%宽，> 600为则居中显示
                       },
        debug        : false,    // [可选]调试模式 [true|false，默认false]
    })
    
		var tp_print = $("#userDetail-print",$.CurrentNavtab);
		tp_print.on("click",function(){
			$("#getcontent").text(KindEditor.instances[0].text())
			printTure("1");
	    });
	})
	
</script>
</head>
<body style="overflow: auto;"><div class="bjui-pageContent">
<table style="width: 80%;margin: auto auto" >
	<tbody>
		<tr>
			<td class="bdTableb">
			
				<table id="tet" cellspacing="0" cellpadding="0" width="75%"
					align="center" border="0" style="margin-top:30px">
				<tbody>
					<tr>
						<td width="19" valign="bottom" class="fileCorner1"></td>
						<td class="fileline01">&nbsp;</td>
						<td valign="top" class="fileCorner2"></td>
					</tr>
					<tr>
						<td class="fileline02">&nbsp;</td>
						<td><!--startprint-1-->
							<table width="90%" align="center" cellpadding="0" class="rltable"
								cellspacing="0">
								<tbody>
									 <tr>
									    <td colspan="4" height="60px" class="grtitle" align="center" style="" >个人基本情况</td>
									  </tr>
									  <tr>
									    <td class="control-label x100" width="25%">姓名：</td>
									    <td colspan="2" align="left"><input type="text" data-rule="required"  name="userName"  style="font-size:12px" class="bdform-control"  value="${user.userName }"> 	</td>
									    <td rowspan="6" align="center" valign="middle"><img src="<%=basePath %>readImage.do?filePath=${user.userPhoto}" width="211" height="211" /></td>
									  </tr>
									   <tr>
									    <td class="control-label x100" >拼音：</td>
									    <td colspan="2" align="left"><input type="text" name="userEnName" id="j_custom_passportno"  data-rule="required"    style="font-size:12px"   class="bdform-control"  value="${user.userEnName }" ></td>
									    </tr>
									   <tr>
									    <td class="control-label x100">性别：</td>
									    <td colspan="2"><!-- <select name="userSex" id="j_custom_sale" data-toggle="selectpicker" data-rule="required">
									      <option value="男">男</option>
									      <option value="女">女</option>
									</select> -->${user.userSex }</td>
									    </tr>
									     <tr>
									    <td class="control-label x100">出生日期：</td>
									    <td colspan="2" align="left"><fmt:formatDate value="${user.userBirthday }" pattern="yyyy-MM-dd"/></td>
									    </tr>
									       <tr>
									    <td class="control-label x100">民 族：</td>
									    <td colspan="2" align="left">${user.userTeam }</td>
									    </tr>
									         <tr>
									    <td class="control-label x100">身份证号码：</td>
									    <td colspan="2" align="left">${user.userCardId }</td>
									    </tr>
									         <tr>
									    <td class="control-label x100" width="25%">籍 贯：</td>
									    <td align="left">${user.userOrigin}</td>
									    <td width="25%" class="control-label x100">出生地：</td>
									    <td width="25%" align="left"><input type="text" name="userBirthPlace" id="j_custom_passportno"  data-rule="required"   style="font-size:12px"   class="bdform-control"  value="${user.userBirthPlace }" ></td>
									  </tr>
									           <tr>
									    <td class="control-label x100">学历（第一学历）：</td>
									    <td >${user.userLevel }</td>
									    <td  class="control-label x100" width="25%">学 位：</td>
									    <td >${user.userDegree }</td>
									  </tr>
									   <tr>
									    <td  class="control-label x100">毕业院校：</td>
									    <td  align="left">${user.userSchool }</td>
									    <td class="control-label x100" width="25%">专业：</td>
									    <td   align="left">${user.userMajor }</td>
									   
									  </tr>
									   <tr>
									    <td class="control-label x100">学历（第二学历）：</td>
									    <td >${user.userLevel2}</td>
									    <td  class="control-label x100" width="25%">学 位：</td>
									    <td >${user.userDegree2}</td>
									  </tr>
									  <tr>
									    <td  class="control-label x100">毕业院校：</td>
									    <td  align="left">${user.userSchool2 }</td>
									    <td class="control-label x100" width="25%">专业：</td>
									    <td   align="left">${user.userMajor2 }</td>
									  </tr>
									     <tr>
									    <td class="control-label x100">所属部门/企业：</td>
											<td colspan="3" align="left">${org_name }</td>
										 </tr>
									     <tr>
									    <td class="control-label x100">职务(岗位)：</td>
									    <td align="left">${user.userJob }</td>
									    <td width="25%" class="control-label x100">职 称：</td>
									    <td  align="left">${user.userTitle }</td>
									  </tr>
									   <tr>
									    <%-- <td class="control-label x100">职务级别：</td>
									    <td  align="left">${user.jobLevel }</td>
									    <td width="25%" class="control-label x100">身份属性：</td>
									    <td  align="left">${user.identityAttribute}</td> --%>
									      <td class="control-label x100">参加工作时间：</td>
									    <td align="left"><fmt:formatDate value="${user.jobTime }" pattern="yyyy-MM-dd"/></td>
									      <td width="25%" class="control-label x100">加入本司时间：</td>
									    <td align="left"><fmt:formatDate value="${user.companyTime }" pattern="yyyy-MM-dd"/></td>
									  </tr>
									     <tr>
									    <td class="control-label x100">任现任时间：</td>
									    <td align="left"><fmt:formatDate value="${user.incumbentTime }" pattern="yyyy-MM-dd"/></td>
									    <td  class="control-label x100">任现任级时间：</td>
									    <td align="left"><fmt:formatDate value="${user.incumbentClassTime }" pattern="yyyy-MM-dd"/></td>
									  </tr>
									  <tr>
									    <td class="control-label x100">劳动合同起止日期：</td>
									    <td align="left" colspan="3"><fmt:formatDate value="${user.incumbentClassTime }" pattern="yyyy-MM-dd"/> —— <fmt:formatDate value="${user.contractEnd }" pattern="yyyy-MM-dd"/></td>
									  </tr>
									     <tr>
										    <td class="control-label x100">政治面貌：</td>
										    <td  align="left">${user.political}</td>
										   <td class="control-label x100" width="25%">入党时间：</td>
									    <td  align="left"><fmt:formatDate value="${user.partyTime }" pattern="yyyy-MM-dd"/></td>
									
									  </tr>
									  <tr>
									    <td class="control-label x100">办公电话：</td>
									    <td align="left">${user.officePhone }</td>
									    <td width="25%" class="control-label x100">手机：</td>
									    <td align="left">${user.userMobileNum }</td>
									  </tr>
									  <tr>
									    <td class="control-label x100">电子邮箱：</td>
									    <td  align="left">${user.userMail }</td>
									    <td width="25%" class="control-label x100"></td>
									    <td align="left"></td>
									  </tr>
									  <tr>
									    <td class="control-label x100" >家庭详细住址（家庭第一联系人）：</td>
									    <td colspan="3" align="left">${user.homeAddress }</td>
									    </tr>
									    <tr>
									    <td class="control-label x100">第一联系人姓名：</td>
									    <td  align="left">${user.firstContactName }</td>
									    <td width="25%" class="control-label x100">第一联系人联系方式：</td>
									    <td  align="left">${user.firstContactDetail }</td>
									  </tr>
									  <tr>
										<td class="control-label x100">个人履历：</td>
										<td colspan="3" align="left" style="padding: 5px 5px" id="getcontent"></td>
										</tr>
								</tbody>
							</table><!--endprint-1--></td>
						<td class="fileShadowR">&nbsp;</td>
					</tr>
					<tr>
						<td class="fileCorner4">&nbsp;</td>
						<td class="fileShadowB">&nbsp;</td>
						<td class="fileCorner3" width="19px">&nbsp;</td>
					</tr>
				</tbody>
			</table>
			<div style="display: none;" id="chengContent"><textarea name="personalDetails" class="j-content" style="width:100%;" data-minheight="200" data-toggle="kindeditor" data-items="fontname, fontsize, |, forecolor, hilitecolor, bold, italic, underline, removeformat, |, justifyleft, justifycenter, justifyright, insertorderedlist, insertunorderedlist, |, link" >
                        ${user.personalDetails }</textarea></div>
			
			<div style="text-align:center; width:100%; line-height:50px;margin-top: 20px;">
			<button class="btn btn-blue " type="button" data-icon="print" id="userDetail-print"
					style="margin-right:8px">打印</button>
				</div></td>
		</tr>
	</tbody>
</table></div>
</body>
</html>