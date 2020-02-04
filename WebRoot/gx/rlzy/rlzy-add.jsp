<%@page import="com.gx.soft.sys.persistence.domain.GxSysOrg"%>
<%@ page language="java"
	import="java.util.*,com.gx.soft.hr.persistence.domain.VUserOrg"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<GxSysOrg> orgs = (List<GxSysOrg>)session.getAttribute("orgs");
long random = new Date().getTime();
%>
<%@include file="/common/taglibs.jsp"%>
<script type="text/javascript">
	//自动有效日期
	$(document).on('afterchange.bjui.datepicker', '.j_custom_issuedate',
			function(e, data) {
				var pattern = 'yyyy-MM-dd'
				var start = end = data.value
				var $end = $(this).closest('tr').find('.j_custom_indate')

				if ($end.length) {
					end.setFullYear(start.getFullYear() + 10)
					end.setDate(start.getDate() - 1)
					$end.val(end.formatDate(pattern))
				}
			})
	
	function S_NodeCheck(e, treeId, treeNode){
	 var zTree = $.fn.zTree.getZTreeObj(treeId),
        nodes = zTree.getCheckedNodes(true)
    var ids = '', names = ''
    
    for (var i = 0; i < nodes.length; i++) {
        ids   += ','+ nodes[i].id
        names += ','+ nodes[i].name
    }
    if (ids.length > 0) {
        ids = ids.substr(1), names = names.substr(1);
    }
    
    var $from = $('#'+ treeId).data('fromObj');
    
    if ($from && $from.length) $from.val(names);
    
    $("#row").val(treeNode.tabid);
}

function S_NodeClick(event, treeId, treeNode){
	var zTree = $.fn.zTree.getZTreeObj(treeId)
    zTree.checkNode(treeNode, !treeNode.checked, true, true)
    event.preventDefault()
}


function check1(obj){
    var x=obj.value;
     var y=obj.name;
	$.ajax({
		type:"POST",
		url:"<%=basePath %>hr/check1.do",
		data:"a="+x+"&name="+y,
		success:function(json){
			if(json.fg==1){
				$("#card1").html(json.message);
				obj.value="";
			}else if(json.fg==2){
				$("#card2").html(json.message);
				obj.value="";
			}else{
			$("#card1").html("");
			$("#card2").html("");
			}
		}
	});
} 

$(function(){
	function custom_pic_upload_success(json) {
		if (json[BJUI.keys.statusCode] == BJUI.statusCode.ok) {
			$("#upload-file-list_<%=random %>",$.CurrentDialog).val(json.fileName);
			/* $(".pic-box").html(
					'<img src="../code.do?filePath="+json.fileName  width="100%" height="211"/>') */
			$("#getPath",$.CurrentDialog).attr("src","<%=basePath%>readImage.do?filePath="+json.fileName)		
		}
		
	}
	var uploader = new plupload.Uploader({
		runtimes : 'html5,flash,silverlight,html4',
		browse_button : 'pickfiles_<%=random %>', // you can pass in id...
		//container: document.getElementById('container'), // ... or DOM Element itself
		url : '<%=basePath%>fileupload/image-upload.do',
		flash_swf_url : '../js/Moxie.swf',
		silverlight_xap_url : '../js/Moxie.xap',
		multi_selection:false,
		filters : {
			max_file_size : '50mb',
			mime_types: [
			 			{title : "Image files", extensions : "jpg,png,gif,mpg,jpeg"}
			]
		},

		init: {
			PostInit: function() {
				document.getElementById('uploadfiles_<%=random %>').onclick = function() {
					uploader.start();
					return false;
				};
			},
			FilesAdded:function(up,files){
				plupload.each(files, function(file) {
					document.getElementById('upload-file-list_<%=random %>').value = file.name ;
				});
			},
			FileUploaded:function(up,file,response){
				var json = response.response;
				custom_pic_upload_success(JSON.parse(json));
			},
			Error: function(up, err) {
				$.CurrentDialog.alertmsg("error", err.message);
			}
		}
	});

	uploader.init();
});
</script>
<div class="bjui-pageContent  tableContent">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="100%" valign="top" align="center">
			<form method="post"  action="<%=basePath %>hr/saveOrUpdate.do"
					data-toggle="validate" id="userForm" data-reloadNavtab="false">
				<input name="sysUserId"  value="${sysUserId }" type="hidden">
				<input name="betweenId"  value="0" type="hidden">
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="rltable">
					<tr>
						<td colspan="4" height="60px" class="grtitle" align="center"  >个人基本情况</td>
					</tr>
					<tr>
						<td class="control-label x100"  width="25%">姓名：</td>
						<td colspan="2" align="left"><input type="text"  id="cs"  data-target="#cs"
							data-rule="required" name="userName" style="font-size:12px"
							class="bdform-control" value="${user.userName }"></td>
						<td rowspan="7" align="center" valign="middle"><span class="pic-box"><img id="getPath"
							src="" width="100%" height="211" /></span>
						</td>
					</tr>
					<tr>
						<td class="control-label x100">拼音：</td>
						<td colspan="2" align="left"><input type="text"
							name="userEnName" id="j_custom_passportno" 
							style="font-size:12px" class="bdform-control"
							value="">
						</td>
					</tr>
					<tr>
						<td class="control-label x100">性别：</td>
						<td colspan="2"><select name="userSex" id="j_custom_sale"
							data-toggle="selectpicker" data-rule="required">
								<option value="男">男</option>
								<option value="女">女</option>
						</select>
						</td>
					</tr>
					<tr>
						<td class="control-label x100">出生日期：</td>
						<td colspan="2" align="left"><input type="text"
							name="userBirthday" id="j_custom_issuedate"
							value="" data-toggle="datepicker"
							data-rule="date" size="15">
						</td>
					</tr>
					<tr>
						<td class="control-label x100">民 族：</td>
						<td colspan="2" align="left"><input type="text"
							name="userTeam"  value="${user.userTeam }" data-rule="required"
							style="font-size:12px" class="bdform-control">
						</td>
					</tr>
					<tr>
						<td class="control-label x100">身份证号码：</td>
						<td colspan="2" align="left"><input type="text"
							name="userCardId"  data-rule="required;ID_card" 
							style="font-size:12px" class="bdform-control" onblur="check1(this)"><span id="card1" style="color: red"></span>
						</td>
					</tr>

					<tr>
						<td class="control-label x100">照片上传(蓝底或白底二寸)：</td>
						<td colspan="2">
							<input id="upload-file-list_<%=random %>" size="15" readonly="readonly" name="userPhoto"/> 
							<button id="pickfiles_<%=random %>" class="btn-default " data-icon="hand-pointer-o">浏览</button> 
							 <button id="uploadfiles_<%=random %>" class="btn-blue" data-icon="upload">上传</button>
						</td>

					</tr>
					<tr>
						<td class="control-label x100">籍 贯：</td>
						<td width="25%" align="left"><input type="text"
							name="userOrigin" id="j_custom_passportno5"   data-target="#j_custom_passportno5"
							value="" data-rule="required"
							style="font-size:12px" class="bdform-control">
						</td>
						<td width="25%" class="control-label x100">出生地：</td>
						<td width="25%" align="left"><input type="text"
							name="userBirthPlace" id="j_custom_passportno"
							value="" 
							style="font-size:12px" class="bdform-control">
						</td>
					</tr>
					<tr>
						<td class="control-label x100">学历（第一学历）：</td>
						<td><select name="userLevel" id="j_custom_sale1"
							data-toggle="selectpicker" data-rule="required"  data-target="#j_custom_sale1">
								<option value="无">无</option>
								<option value="小学">小学</option>
								<option value="初中">初中</option>
								<option value="中专">中专</option>
								<option value="高中">高中</option>
								<option value="职高">职高</option>
								<option value="大专">大专</option>
								<option value="本科">本科</option>
								<option value="研究生">研究生</option>
								<option value="博士生">博士生</option>

						</select>
						</td>
						<td class="control-label x100" width="25%">学 位：</td>
						<td><select name="userDegree" id="j_custom_sale2"
							data-toggle="selectpicker"  data-target="#j_custom_sale2">
								<option value="无">无</option>
								<option value="学士">学士</option>
								<option value="双学士">双学士</option>
								<option value="硕士">硕士</option>
								<option value="博士">博士</option>

						</select>
						</td>
					</tr>
					<tr>
						<td class="control-label x100">毕业院校：</td>
						<td align="left"><input type="text" name="userSchool"
							id="j_custom_passportno4" value="${user.userSchool }"
							data-rule="required" style="font-size:12px"  data-target="#j_custom_passportno4"
							class="bdform-control">
						</td>
						<td class="control-label x100" width="25%">专业：</td>
						<td align="left"><input type="text" name="userMajor"
							id="j_custom_passportno3" value="${user.userMajor }"
							data-rule="required" style="font-size:12px"    data-target="#j_custom_passportno3"
							class="bdform-control">
						</td>

					</tr>
					<tr>
						<td class="control-label x100">学历（第二学历）：</td>
						<td><select name="userLevel2" id="j_custom_sale3"
							data-toggle="selectpicker" >
								<option value="无">无</option>
								<option value="小学">小学</option>
								<option value="初中">初中</option>
								<option value="中专">中专</option>
								<option value="高中">高中</option>
								<option value="职高">职高</option>
								<option value="大专">大专</option>
								<option value="本科">本科</option>
								<option value="研究生">研究生</option>
								<option value="博士生">博士生</option>

						</select>
						</td>
						<td class="control-label x100" width="25%">学 位：</td>
						<td><select name="userDegree2" id="j_custom_sale4"
							data-toggle="selectpicker" >
								<option value="无">无</option>
								<option value="学士">学士</option>
								<option value="双学士">双学士</option>
								<option value="硕士">硕士</option>
								<option value="博士">博士</option>
						</select>
						</td>
					</tr>
					<tr>
						<td class="control-label x100">毕业院校：</td>
						<td align="left"><input type="text" name="userSchool2"
							id="j_custom_passportno" value="${user.userSchool2}"
							 style="font-size:12px"   class="bdform-control">
						</td>
						<td class="control-label x100" width="25%">专业：</td>
						<td align="left"><input type="text" name="userMajor2"
							id="j_custom_passportno" value="${user.userMajor2 }"
							 style="font-size:12px"   class="bdform-control">
						</td>
					</tr>
					<tr>
						<td class="control-label x100">所属部门/企业：</td>
						<td colspan="3" align="left"><input type="text"  data-target="#j_ztree_menus2"
							name="org_name" id="j_ztree_menus2" data-toggle="selectztree"
							size="18" data-tree="#j_select_tree2" value="${org_name }"  data-rule="required"
							readonly>  <input type="hidden" name="org_rowId" id="row" value="${org_rowId }">
							<ul id="j_select_tree2" class="ztree hide" data-toggle="ztree"
								data-expand-all="true" data-check-enable="true"
								data-chk-style="radio" data-radio-type="all"
								data-on-check="S_NodeCheck" data-on-click="S_NodeClick">
								<%
									for (int i = 0; i < orgs.size(); i++) {
										if ("root".equals(orgs.get(i).getParentOrgId())) {
								%>
								<li data-id="<%=orgs.get(i).getRowId()%>" data-pid="0"
									data-divid="#layout-01"
									data-tabid="<%=orgs.get(i).getRowId()%>" data-faicon="users"><%=orgs.get(i).getOrgName()%></li>
								<%
									for (int j = 0; j < orgs.size(); j++) {
												if (orgs.get(j).getParentOrgId()
														.equals(orgs.get(i).getRowId().toString())) {
								%>
								<li data-id="<%=orgs.get(j).getRowId()%>"
									data-pid="<%=orgs.get(j).getParentOrgId()%>"
									data-divid="#layout-01"
									data-tabid="<%=orgs.get(j).getRowId()%>" data-faicon="user"><%=orgs.get(j).getOrgName()%></li>
								<%}}%>
								<%}}%>
							</ul></td>
					</tr>
					<tr>
						<td class="control-label x100">职务(岗位)：</td>
						<td align="left"><input type="text"
							name="userJob" id="j_custom_passportno2" value=""
							data-rule="required" style="font-size:12px"  data-target="#j_custom_passportno2"
							class="bdform-control">
						</td>
						<td width="25%" class="control-label x100">职 称：</td>
						<td  align="left">
						<select name="userTitle"   data-target="#j_custom_sale5"
							id="j_custom_sale5" data-toggle="selectpicker"
							data-rule="required" multiple="multiple" >
								<option value="无">无</option>
								<option value="研究员级高级工程师">研究员级高级工程师</option>
								<option value="正高级经济师">正高级经济师</option>
								<option value="高级工程师">高级工程师</option>
								<option value="高级经济师">高级经济师</option>
								<option value="高级会计师">高级会计师</option>
								<option value="高级政工师">高级政工师</opztion>
								<option value="工程师">工程师</option>
								<option value="经济师">经济师</option>
								<option value="会计师">会计师</option>
								<option value="政工师">政工师</option>
								<option value="助理工程师">助理工程师</option>
								<option value="助理经济师">助理经济师</option>
								<option value="助理会计师">助理会计师</option>
								<option value="助理政工师">助理政工师</option>
								<option value="其他">其他</option>
						</select></td>
					</tr>
					<tr>
						<!-- <td class="control-label x100">职务级别：</td>
						<td align="left"><input type="text"
							name="jobLevel" id="j_custom_passportno"
							value="" 
							style="font-size:12px" class="bdform-control">
						</td>
						<td class="control-label x100" width="25%">身份属性：</td>
						<td align="left"><select name="identityAttribute"
							id="j_custom_sale6" data-toggle="selectpicker"
							data-rule="required"  data-target="#j_custom_sale6">
								<option value="无">无</option>
								<option value="企业合同制">企业合同制</option>
								<option value="劳务派遣">劳务派遣</option>
								<option value="借用">借用</option>
								<option value="兼职">兼职</option>
								<option value="其他">其他</option>
						</select></td> -->
						<td class="control-label x100">参加工作时间：</td>
						<td align="left"><input type="text"
							name="jobTime" value="${fn:substring(user.jobTime,0,10) }"
							data-toggle="datepicker" data-rule="date" size="15">
						</td>
						<td class="control-label x100" width="25%">加入本司时间：</td>
						<td align="left"><input type="text"
							name="companyTime" value="${fn:substring(user.companyTime,0,10) }"
							data-toggle="datepicker" data-rule="date" size="15">
						</td>
					</tr>
					<tr>
						<td class="control-label x100">任现任时间：</td>
						<td align="left"><input type="text" name="incumbentTime" 
							value="${fn:substring(user.incumbentTime,0,10)}" data-toggle="datepicker"
							data-rule="date" size="15">
						</td>
						<td class="control-label x100">任现任级时间：</td>
						<td align="left"><input type="text"
							name="incumbentClassTime" id="j_custom_issuedate"
							value="${fn:substring(user.incumbentClassTime,0,10)}" data-toggle="datepicker"
							data-rule="date" size="15">
						</td>
					</tr>
					<tr>
						<td class="control-label x100">劳动合同起止日期：</td>
						<td align="left" colspan="3"><input type="text"
							name="contractStart" id="j_custom_issuedate"
							value="${fn:substring(user.contractStart, 0, 10)}" data-toggle="datepicker"
							data-rule="date" size="15"> —— <input
							type="text" name="contractEnd" id="j_custom_issuedate10"
							value="${fn:substring(user.contractEnd, 0, 10) }" data-toggle="datepicker"
							data-rule="match[gte, contractStart, date]" size="15" data-target="#j_custom_issuedate10">
						</td>
					</tr>
					<tr>
						<td class="control-label x100">政治面貌：</td>
						<td align="left"><select name="political"
							id="j_custom_sale7" data-toggle="selectpicker"  >
								<option value="群众">群众</option>
								<option value="团员">团员</option>
								<option value="预备党员">预备党员</option>
								<option value="党员">党员</option>
								<option value="中国国民党革命委员会">中国国民党革命委员会</option>
								<option value="中国民主同盟">中国民主同盟</option>
								<option value="中国民主建国会">中国民主建国会</option>
								<option value="中国民主促进会">中国民主促进会</option>
								<option value="中国农工民主党">中国农工民主党</option>
								<option value="中国致公党">中国致公党</option>
								<option value="九三学社">九三学社</option>
								<option value="台湾民主自治同盟">台湾民主自治同盟</option>
						</select></td>
						<%-- <td class="control-label x100" width="25%">OA帐号：</td>
						<td align="left"><input type="text" name="oaId"
							id="j_custom_passportno0" value="${user.oaId }"  data-target="#j_custom_passportno0"
							style="font-size:12px"  class="bdform-control"  data-rule="required"  onblur="check1(this)"><span id="card2" style="color: red"></span></td> --%>
							<td class="control-label x100" width="25%">入党时间：</td>
						<td align="left"><input type="text"
							name="partyTime" id="j_custom_issuedate"
							value="${fn:substring(user.partyTime,0,10) }" data-toggle="datepicker"
							data-rule="date" size="15">
						</td>
					</tr>
					<tr>
						<td class="control-label x100">办公电话：</td>
						<td align="left"><input type="text"
							name="officePhone" id="j_custom_passportno1"  data-target="#j_custom_passportno1"
							value="${user.officePhone }" data-rule="required;tel"
							style="font-size:12px" class="bdform-control">
						</td>
						<td class="control-label x100" width="25%">手机：</td>
						<td align="left"><input type="text"
							name="userMobileNum" id="j_custom_passportno"
							value="${user.userMobileNum }"  data-rule="mobile"
							style="font-size:12px" class="bdform-control">
						</td>
						<%-- <td class="control-label x100" width="25%">传真：</td>
						<td align="left"><input type="text"
							name="userFax" id="j_custom_passportno" value="${user.userFax }"
							 style="font-size:12px"   class="bdform-control">
						</td> --%>
					</tr>
					<tr>
						<%-- <td class="control-label x100">宅电：</td>
						<td align="left"><input type="text"
							name="homePhone" id="j_custom_passportno"
							value="${user.homePhone }"  data-rule="tel"
							style="font-size:12px" class="bdform-control">
						</td> --%>
					</tr>
					<tr>
						<td class="control-label x100">电子邮箱：</td>
						<td align="left"><input type="email"
							name="userMail" id="j_custom_passportno"
							value="${user.userMail }"   data-rule="email"
							style="font-size:12px" class="bdform-control">
						</td>
						<td width="25%" class="control-label x100"></td>
						<td align="left"></td>
						<%-- <td class="control-label x100" width="25%">手机2：</td>
						<td align="left"><input type="text"
							name="userMobile2" id="j_custom_passportno"
							value="${user.userMobile2 }"  data-rule="mobile"
							style="font-size:12px" class="bdform-control">
						</td> --%>
					</tr>
					<tr>
						<td class="control-label x100">家庭详细住址（家庭第一联系人）：</td>
						<td colspan="3" align="left"><input type="text"
							name="homeAddress" id="j_custom_passportno7"   data-target="#j_custom_passportno7"
							value="${user.homeAddress }" data-rule="required"
							style="font-size:12px" class="bdform-control" size="50">
						</td>
					</tr>
					<tr>
						<td class="control-label x100">第一联系人姓名：</td>
						<td align="left"><input type="text"
							name="firstContactName" id="j_custom_passportno"
							value="${user.firstContactName }" 
							style="font-size:12px" class="bdform-control">
						</td>
						<td class="control-label x100" width="25%">第一联系人联系方式：</td>
						<td align="left"><input type="text"
							name="firstContactDetail" id="j_custom_passportno"
							value="${user.firstContactDetail }" 
							style="font-size:12px" class="bdform-control">
						</td>
					</tr>
					<tr>
						<td class="control-label x100">备注：</td>
						<td colspan="3" align="left"><textarea name="remark"
								id="j_custom_note" data-toggle="autoheight"  rows="1"
								style="font-size:12px" class="bdform-control"  cols="50">${user.remark }</textarea>
						</td>
					</tr>
					<tr>
						<td class="control-label x100">个人履历：</td>
						<td colspan="3" align="left">
						<%-- <textarea name="personalDetails"
								id="j_custom_note" data-toggle="autoheight"  rows="1"
						style="font-size:12px" class="bdform-control"  cols="50">${user.remark }</textarea> --%>
						<textarea name="personalDetails" class="j-content" style="width:100%;" data-minheight="200" data-toggle="kindeditor" data-items="fontname, fontsize, |, forecolor, hilitecolor, bold, italic, underline, removeformat, |, justifyleft, justifycenter, justifyright, insertorderedlist, insertunorderedlist, |, link,source, |, undo, redo, |, preview, print, template" >
                            </textarea>
						</td>
					</tr>
				</table>
				</form>
				</td>
		</tr>
	</table>



</div>
<div class="bjui-pageFooter">
	<ul>
		<li><button type="button" class="btn-close" data-icon="close">取消</button>
		</li>
		<li><button type="submit" class="btn-default" data-icon="save">全部保存</button>
		</li>
	</ul>
</div>