<%@ page language="java" import="java.util.*,com.gx.soft.sys.persistence.domain.GxSysOrg" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="/common/taglibs.jsp"%>
<%
	List<GxSysOrg> orgs = (List<GxSysOrg>)session.getAttribute("orgs1");
%>
<script type="text/javascript">
$(function() {
	var a = $("#text3").val();
		$("#j_custom option").each(function(){
			var s=$(this).val();
			if(s==a){
				$(this).attr("selected",true);
			}	
		}); 
})


function opendialog11(obj,a,b,c,d){
		var org_id=$("#"+a).val()
		var org_name=$("#"+b).val()
		var parent_id=$("#"+c).val()
		var parent_name=$("#"+d).val()
		org_name=encodeURI(encodeURI(org_name))
		parent_name=encodeURI(encodeURI(parent_name))
		$(obj).dialog({id:'rl-started', url:'<%=basePath %>hr/org-before/org-edit.do?org_id='+org_id+'&org_name='+org_name+'&parent_id='+parent_id+'&parent_name='+parent_name, title:'编辑'});
	
	}
</script>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch"  action="<%=basePath %>hr/org-select.do" method="post">
		<div class="bjui-searchBar">
			<label>部门号：</label><input type="text"
				name="filter_EQS_rowId" class="form-control" size="10" value="${param.filter_EQS_rowId }">&nbsp;
			<label>部门:</label>
			<input type="hidden" id="text3" value="${param.filter_LIKES_orgName}">
					<select name="filter_LIKES_orgName" data-toggle="selectpicker" id="j_custom">
						<option value="">全部</option>
						<%
							for (int i = 0; i < orgs.size(); i++) {
							%>
						<option value="<%=orgs.get(i).getOrgName()%>"><%=orgs.get(i).getOrgName()%></option>
						<%} %>
					</select>
			<button type="submit" class="btn-default" data-icon="search">查询</button>
			&nbsp; <a class="btn btn-orange" href="javascript:;"
				data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
			<div class="pull-right">
				<button type="button" class="btn-red" data-toggle="doajaxchecked"
					data-url="<%=basePath %>hr/org-delete.do"
					data-confirm-msg="确定要删除选中项吗？" data-idname="delids" data-group="ids" data-icon="remove">删除选中</button>
				<button type="button" class="btn-green" data-toggle="dialog"  data-title="添加"
					data-url="<%=basePath %>hr/org-before/org-add.do?org_id=0" data-id="add_user"
					data-icon="plus" data-width="400" data-height="300" >添加部门</button>
			</div>
		</div>
	</form>
</div>
<div class="bjui-pageContent tableContent"  >

	<table class="table table-bordered table-hover table-striped table-top " data-selected-multi="true" style="border-top:1px #dddddd solid">
        <thead>
            <tr>
            <th width="5%"><input type="checkbox" class="checkboxCtrl"
					data-group="ids" data-toggle="icheck">
				</th>
				<th width="9%">排序</th>
              <th height="30" width="13%" >部门号</th>
                <th width="20%">部门名</th>
                <th  width="15%">上一级部门编号</th>
                <th  width="22%">上一级部门</th>
                <th width="12%">操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${lo}" var="org" varStatus="status">
            <tr data-id="6">
            	<td><input type="checkbox" name="ids" data-toggle="icheck"  value="${org.rowId}">
			 	</td>
			  <td >${status.index+1 }</td>
              <td >${org.rowId}</td>
              <td>${org.orgName }</td>
              <td>${org.parentOrgId}</td>
              <td>${org.parentOrgName }</td>
              <td><button  onclick="opendialog11(this,'org_id${org.rowId}','org_name${org.rowId}','parent_id${org.rowId}','parent_name${org.rowId}')"  data-toggle="dialog"  data-height="300" data-width="400"  type="button" class="btn btn-green" >编辑</button>
               <input type="hidden" id="org_id${org.rowId}" value="${org.rowId }"> <input type="hidden" id="org_name${org.rowId}" value="${org.orgName }"> <input type="hidden" id="parent_id${org.rowId}" value="${org.parentOrgId }"> <input type="hidden" id="parent_name${org.rowId}" value="${org.parentOrgName }">
               </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
	
</div>
<div class="bjui-pageFooter">
	<div class="pages">
		<span>每页&nbsp;</span>
		<div class="selectPagesize">
			<select data-toggle="selectpicker"
				data-toggle-change="changepagesize">
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
				<option value="25">25</option>
			</select>
		</div>
		<span>&nbsp;条，共 ${page.totalCount }条</span>
	</div>
	<div class="pagination-box" data-toggle="pagination" data-total="${page.totalCount }"
		data-page-size="${page.pageSize}" data-page-current="${page.pageCurrent }"></div>
</div>

