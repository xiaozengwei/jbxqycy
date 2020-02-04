<%@page import="com.gx.soft.sys.persistence.domain.GxSysOrg"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<GxSysOrg> orgs = (List<GxSysOrg>)session.getAttribute("orgs_1");
%>
<script type="text/javascript">
$(function() {
	var select_orgid = $("#text3").val();
	var current_orgid = select_orgid!="" ? select_orgid:$("#text4").val();
	$("#on option").each(function(){
		var s=$(this).val();
		if(s==current_orgid){
			$(this).attr("selected","selected");
		}	
			
	});
});

	function opNavtab12(obj,user_row_id,org_name){
		var user_row_id=$("#"+user_row_id,$.CurrentNavtab).val()
		var org_name=$("#"+org_name,$.CurrentNavtab).val()
		org_name=encodeURI(encodeURI(org_name))
		$(obj).navtab({id:'mynavtab', url:'<%=basePath%>hr/user-detail.do?user_row_id='+user_row_id+'&org_name='+org_name, title:'查看'});
	}
	
	function opNavtab_print1(obj,user_row_id,org_name){
		var user_row_id=$("#"+user_row_id,$.CurrentNavtab).val()
		var org_name=$("#"+org_name,$.CurrentNavtab).val()
		org_name=encodeURI(encodeURI(org_name))
		var _url = '<%=basePath%>hr/user-detail2-print.do?user_row_id='+user_row_id+'&org_name='+org_name;
			 window.open(_url,'_blank');
	}
</script>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch"
				action="<%=basePath%>hr/select-list/user-list1.do" method="post" style="margin-bottom: 0">
				<input type="hidden" name="orderField" value="${param.orderField}">
				<input type="hidden" name="orderDirection"
					value="${param.orderDirection}">
				<div class="bjui-searchBar">
					&nbsp;<label>姓名：</label><input type="text" id="customNo"
						name="filter_LIKES_userName" class="form-control" size="15"
						value="${param.filter_LIKES_userName }">&nbsp;&nbsp;&nbsp;&nbsp;
					<label>员工号：</label> <input type="text"
						name="filter_LIKES_userCardId"
						value="${param.filter_LIKES_userCardId }" class="form-control"
						size="15">&nbsp;&nbsp; <label>部门:</label><input
						type="hidden" id="text3" value="${param.filter_EQS_rowId}">
						<input type="hidden" id="text4" value="${v_row_Id1}">
					<select name="filter_EQS_rowId" data-toggle="selectpicker" id="on">
						<option value="">全部</option>
						<%
							for (int i = 0; i < orgs.size(); i++) {
								if (!("root".equals(orgs.get(i).getParentOrgId()))) {
							%>
						<option value="<%=orgs.get(i).getRowId()%>"><%=orgs.get(i).getOrgName()%></option>
						<%}} %>
					</select>
					<button type="submit" class="btn-default" data-icon="search">查询</button>
					&nbsp;
				</div>
		</form>
</div>
<div class="bjui-pageContent tableContent"  >
	
	<table class="table table-bordered table-hover table-striped table-top table-center" data-selected-multi="true" align="center" style="border-top:1px #dddddd solid">
        <thead>
            <tr>
            <th width="5%"><input type="checkbox" class="checkboxCtrl"
					data-group="ids" data-toggle="icheck">
				</th>
				<th width="5%">排序</th>
              <th height="30" width="9%" >序号</th>
              <th width="9%" >用户名</th>
                <th width="17%">员工号</th>
                <th align="center" width="10%">职务</th>
                <th  width="10%">部门</th>
                <th width="35%">操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listView}" var="voi" varStatus="status">
            <tr data-id="6">
            	<td><input type="checkbox" name="ids" data-toggle="icheck"  value="${voi.userOrgKey}">
			 	</td>
			  <td >${status.index+1 }</td>
              <td >${voi.rowId}</td>
              <td>${voi.userName}</td>
              <td>${voi.userCardId }</td>
              <td>${voi.userJob}</td>
              <td>${voi.orgName }</td>
              <td align="center">
				<button data-toggle="navtab" type="button" class="btn-default" data-height="750" data-width="800"  style=""  data-title="查看用户"
					onclick="opNavtab12(this,'user_row_id${status.index+1 }','org_name${status.index+1 }')">查看</button>
					<button data-toggle="navtab" type="button" class="btn btn-blue doc-print"  data-icon="print"  data-id="userDetail-print"
					 onclick="opNavtab_print1(this,'user_row_id${status.index+1 }','org_name${status.index+1 }')">打印</button>        
					<button data-url="<%=basePath%>hr/setUserListOrder.do?betweenId=${voi.betweenId}&type=add&divId=layout-011" class="btn-blue btn-resort" data-toggle="doajax" data-icon="chevron-up" data-type="get">升序</button>
                    <button data-url="<%=basePath%>hr/setUserListOrder.do?betweenId=${voi.betweenId}&type=deg&divId=layout-011"  class="btn-blue btn-resort" data-toggle="doajax"  data-icon="chevron-down" data-type="get">降序</button>
					<input type="hidden" id="user_row_id${status.index+1 }" value="${voi.userRowId}"> 
					<input type="hidden" id="org_name${status.index+1 }" value="${voi.orgName}">        
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
		data-page-size="${page.pageSize }" data-page-current="${page.pageCurrent }"></div>
</div>

