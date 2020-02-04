<%@ page language="java"
	import="java.util.*,com.gx.soft.sys.persistence.domain.GxSysOrg"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<GxSysOrg> orgs = (List<GxSysOrg>)session.getAttribute("orgs");
%>
<%@include file="/common/taglibs.jsp"%>
<script type="text/javascript">

	function change1() {
		var a = null;
		$("#s1 option").each(function() {
			if ($(this).attr("selected")) {
				a = $(this).text();
				$("#pn").val(a);
			}
		});
	}
</script>
<div class="bjui-pageContent  tableContent"  >
	<table width="100%">
		<tr>
			<td>
				<form method="post" action="../hr/suOrg.do" data-toggle="validate"
					id="noticeContentForm" data-reloadNavtab="true">
					<input name="rowId" type="hidden"
						id="org_id"  value="${org_id }"/> 
					<table class="table table-condensed table-hover" width="100%">
						<tbody>
							<tr>
								<td><label for="j_custom_total" class="control-label x85">上一级部门：</label> <input name="parentOrgName"
						value="${parent_name }" type="hidden" id="pn">
									<select name="parentOrgId" data-toggle="selectpicker" id="s1" onchange="change1()">
										<c:if test="${parent_id eq 'root' }">
											<option value="${parent_id}"}>根目录</option>
										</c:if>
										<c:if test="${parent_id ne 'root' }">
											<option value="root" >根目录</option>
											<c:forEach items="${listOrg }" var="org">
												<option value="${org.rowId}"}  ${parent_id eq
											org.rowId ? 'selected="selected"':'' }  >${org.orgName }</option>
											</c:forEach>
										</c:if>
									</select>
								</td>
							</tr>
							<tr>
								<td><label for="j_custom_total" class="control-label x85">部门名：</label>
									<input type="text" name="orgName" id="j_custom_name"
									value="${org_name }" data-rule="required" size="15"></td>
							</tr>

						</tbody>
					</table>
				</form></td>
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