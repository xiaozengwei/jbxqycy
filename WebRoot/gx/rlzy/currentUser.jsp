<%@ page language="java"
	import="java.util.*,com.gx.soft.hr.persistence.domain.VUserOrg"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%-- <%
	List<GxHrOrg> orgs = (List<GxHrOrg>)session.getAttribute("orgs");
%>
 --%><%@include file="/common/taglibs.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#j_custom_sale").val('${user.userLevel2}');
		$("#j_custom_sale1").val('${user.userDegree2}');
		$("#j_custom_sale4").val('${user.political}');

		var a = $("#text1").val();
		if (a.indexOf(",") != -1) {
			var n = a.split(",");
			for ( var i = 0; i < n.length; i++) {
				$("#j_custom_sale2 option").each(function() {
					var s = $(this).val();
					if (s == n[i]) {
						$(this).attr("selected", true);

					}
				});
			}
		} else {
			$("#j_custom_sale2").val('${user.userTitle}');
		}

		$(".doc-print", $.CurrentNavtab).click(function() {
			var _url = $(this).data("url");
			window.open(_url, '_blank');
		});
	})
	
</script>
<div class="bjui-pageContent">
	<table style="width: 80%;margin: auto auto">
		<tr>
			<td width="100%" valign="top" align="center">
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="rltable">
					<tr>
						<td colspan="4" height="60px" class="grtitle" align="center"
							style="">个人基本情况</td>
					</tr>
					<tr>
						<td class="control-label x100" width="25%">姓名：</td>
						<td colspan="2" align="left"><input type="text"
							data-rule="required" name="userName" style="font-size:12px"
							class="bdform-control" value="${user.userName }"></td>
						<td rowspan="6" align="center" valign="middle"><img
							src="<%=basePath %>readImage.do?filePath=${user.userPhoto}" width="100%" height="211" />
						</td>
					</tr>
					<tr>
						<td class="control-label x100">拼音：</td>
						<td colspan="2" align="left"><input type="text"
							name="userEnName" id="j_custom_passportno" data-rule="required"
							style="font-size:12px" class="bdform-control"
							value="${user.userEnName }">
						</td>
					</tr>
					<tr>
						<td class="control-label x100">性别：</td>
						<td colspan="2">${user.userSex }</td>
					</tr>
					<tr>
						<td class="control-label x100">出生日期：</td>
						<td colspan="2" align="left"><fmt:formatDate
								value="${user.userBirthday }" pattern="yyyy-MM-dd" />
						</td>
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
						<td width="25%" align="left"><input type="text"
							name="userBirthPlace" id="j_custom_passportno"
							data-rule="required" style="font-size:12px"
							class="bdform-control" value="${user.userBirthPlace }">
						</td>
					</tr>
					<tr>
						<td class="control-label x100">学历（第一学历）：</td>
						<td>${user.userLevel }</td>
						<td class="control-label x100" width="25%">学 位：</td>
						<td>${user.userDegree }</td>
					</tr>
					<tr>
						<td class="control-label x100">毕业院校：</td>
						<td align="left">${user.userSchool }</td>
						<td class="control-label x100" width="25%">专业：</td>
						<td align="left">${user.userMajor }</td>

					</tr>
					<tr>
						<td class="control-label x100">学历（第二学历）：</td>
						<td><select name="userLevel2" id="j_custom_sale"
							data-toggle="selectpicker" data-rule="required">
								<option value="无">无</option>
								<option value="文盲">文盲</option>
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
						<td><select name="userDegree2" id="j_custom_sale1"
							data-toggle="selectpicker" data-rule="required">
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
						<td align="left">${user.userSchool2 }</td>
						<td class="control-label x100" width="25%">专业：</td>
						<td align="left">${user.userMajor2 }</td>
					</tr>
					<tr>
						<td class="control-label x100">所属部门/企业：</td>
						<td colspan="3" align="left"><input type="text"
							name="org_name" id="j_ztree_menus2" data-toggle="selectztree"
							size="30" data-tree="#j_select_tree2" value="${org_name }"
							disabled="disabled"></td>
					</tr>
					<tr>
						<td class="control-label x100">职务(岗位)：</td>
						<td align="left">${user.userJob }</td>
						<td width="25%" class="control-label x100">职 称：</td>
						<td align="left"><input type="hidden" id="text1"
							value="${user.userTitle }" data-rule="required"
							style="font-size:12px" class="bdform-control"> <select
							name="userTitle" id="j_custom_sale2" data-toggle="selectpicker"
							data-rule="required" multiple="multiple">
								<option value="无">无</option>
								<option value="研究员级高级工程师">研究员级高级工程师</option>
								<option value="正高级经济师">正高级经济师</option>
								<option value="高级工程师">高级工程师</option>
								<option value="高级经济师">高级经济师</option>
								<option value="高级会计师">高级会计师</option>
								<option value="高级政工师">
									高级政工师
									</opztion>
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
						<td width="25%" class="control-label x100">参加工作时间：</td>
						<td align="left"><fmt:formatDate
								value="${user.jobTime }" pattern="yyyy-MM-dd" />
						</td>
						<td class="control-label x100" width="25%">加入本司时间：</td>
						<td align="left"><fmt:formatDate
								value="${user.companyTime }" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<td class="control-label x100">任现任时间：</td>
						<td align="left"><fmt:formatDate
								value="${user.incumbentTime }" pattern="yyyy-MM-dd" />
						</td>
						<td class="control-label x100">任现任级时间：</td>
						<td align="left"><fmt:formatDate
								value="${user.incumbentClassTime }" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<td class="control-label x100">劳动合同起止日期：</td>
						<td align="left" colspan="3"><fmt:formatDate
								value="${user.incumbentClassTime }" pattern="yyyy-MM-dd" /> —— <fmt:formatDate
								value="${user.contractEnd }" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<td class="control-label x100">政治面貌：</td>
						<td align="left"><select name="political"
							id="j_custom_sale4" data-toggle="selectpicker"
							data-rule="required">
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
						<td class="control-label x100" width="25%">入党时间：</td>
						<td align="left"><fmt:formatDate
								value="${user.partyTime }" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<td class="control-label x100">办公电话：</td>
						<td  align="left">${user.officePhone }</td>
						<td width="25%" class="control-label x100">手机：</td>
						<td align="left">${user.userMobileNum }</td>
					</tr>
					<tr>
						<td class="control-label x100">电子邮箱：</td>
						<td align="left">${user.userMail }</td>
						<td width="25%" class="control-label x100"></td>
						<td align="left"></td>
					</tr>
					<tr>
						<td class="control-label x100">家庭详细住址（家庭第一联系人）：</td>
						<td colspan="3" align="left">${user.homeAddress }</td>
					</tr>
					<tr>
						<td class="control-label x100">第一联系人姓名：</td>
						<td align="left">${user.firstContactName }</td>
						<td class="control-label x100" width="25%">第一联系人联系方式：</td>
						<td align="left">${user.firstContactDetail }</td>
					</tr>
					<tr>
						<td class="control-label x100">备注：</td>
						<td colspan="3" align="left"><textarea name="remark"
								id="j_custom_note" data-toggle="autoheight" cols="60" rows="3"
								style="font-size:12px" class="bdform-control">${user.remark }</textarea>
						</td>
					</tr>
					<tr>
						<td class="control-label x100">个人履历：</td>
						<td colspan="3" align="left">
						<textarea name="personalDetails" class="j-content" style="width:100%;" data-minheight="200" data-toggle="kindeditor" data-items="fontname, fontsize, |, forecolor, hilitecolor, bold, italic, underline, removeformat, |, justifyleft, justifycenter, justifyright, insertorderedlist, insertunorderedlist, |, link,source, |, undo, redo, |, preview, print, template" >
                        ${user.personalDetails }</textarea>
						</td>
					</tr>
				</table></td>
		</tr>
	</table>

</div>
<div class="bjui-pageFooter">
	<ul>
		<li class="pull-left"><button type="button"
				class="btn btn-blue doc-print" data-icon="print"
				data-url="<%=basePath%>hr/user-detail1-print.do"
				data-id="userDetail-print">打印</button>
		</li>
	</ul>
</div>