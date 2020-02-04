<%@page import="com.gx.soft.sys.persistence.domain.GxSysOrg"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="/common/taglibs.jsp"%>
<%
	List<GxSysOrg> orgs = (List<GxSysOrg>)session.getAttribute("orgs5");
%>
<script type="text/javascript">
$(function() {
	var a = $("#text5").val();
	var b = $("#text6").val();
	var x;
		$("#on option").each(function(){
			var s=$(this).val();
			if(a!=""){
			x=a;
			}else{
			x=b;
			}
			
			if(s==x){
				$(this).attr("selected",true);
			}	
			
		});
})

	function opNavtab1113(obj,user_row_id,org_name){
		var user_row_id=$("#"+user_row_id).val()
		var org_name=$("#"+org_name).val()
		org_name=encodeURI(encodeURI(org_name))
		$(obj).navtab({id:'mynavtab', url:'../hr/user-detail.do?user_row_id='+user_row_id+'&org_name='+org_name, title:'查看'});
	
	}
	
	function opNavtab_print2(obj,user_row_id,org_name){
		var user_row_id=$("#"+user_row_id).val()
		var org_name=$("#"+org_name).val()
		org_name=encodeURI(encodeURI(org_name))
		var _url = '../hr/user-detail2-print.do?user_row_id='+user_row_id+'&org_name='+org_name;
			 window.open(_url,'_blank');
	}
</script>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch"
				action="../hr/select-list/user-list2.do" method="post" style="margin-bottom: 0">
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
						type="hidden" id="text5" value="${param.filter_EQS_rowId}">
						<input type="hidden" id="text6" value="${v_row_Id2}">
					<select name="filter_EQS_rowId" data-toggle="selectpicker" id="on">
						<option value="">全部</option>
						<%
							for (int i = 0; i < orgs.size(); i++) {
								if (!("root".equals(orgs.get(i).getParentOrgId()))) {
							%>
						<option value="<%=orgs.get(i).getRowId()%>"><%=orgs.get(i).getOrgName()%></option>
						<%}} %>

					<button type="submit" class="btn-default" data-icon="search">查询</button>
					&nbsp;
				</div>
		<c:if test="${a==1 }">
			<div class="pull-left">
				<button type="button" class="btn-red" data-toggle="doajaxchecked"
					data-url="../hr/user-delete.do"
					data-confirm-msg="确定要删除选中项吗？" data-idname="delids" data-group="ids" data-icon="remove">删除选中</button>
				<button type="button" class="btn-green" data-toggle="dialog"  data-title="添加用户"
					data-url="../hr/user-add.do?org_name=${org_name}&org_rowId=${org_rowId}" data-id="add_user"
					data-icon="plus" data-width="750" data-height="800" >添加用户</button>
			</div>
		</c:if>
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
                <th width="17%">员工卡号</th>
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
              <td align="center"><c:if test="${a==1 }"><button  data-url="../hr/user-edit.do?user_row_id=${voi.userRowId }&org_name=${voi.orgName}&betweenId=${voi.betweenId}"  data-toggle="dialog" data-title="编辑用户"  data-height="750" data-width="800" data-id="rl-started" type="button" class="btn-default" id="selectaddworkpeo"  >编辑</button>
                </c:if>
				<button data-toggle="navtab" type="button" class="btn-default" data-height="750" data-width="800"  style="margin-right:8px"  data-title="查看用户"
					 onclick="opNavtab1113(this,'user_row_id${status.index+1 }','org_name${status.index+1 }')" >查看</button> <input type="hidden" id="user_row_id${status.index+1 }" value="${voi.userRowId}"> 
					<input type="hidden" id="org_name${status.index+1 }" value="${voi.orgName}">
					<button data-toggle="navtab" type="button" class="btn btn-blue doc-print"  data-icon="print"  data-id="userDetail-print"
					 onclick="opNavtab_print2(this,'user_row_id${status.index+1 }','org_name${status.index+1 }')" >打印</button>      
					 <button data-url="<%=basePath%>hr/setUserListOrder.do?betweenId=${voi.betweenId}&type=add&divId=layout-012" class="btn-blue btn-resort" data-toggle="doajax" data-icon="chevron-up" data-type="get">升序</button>
                    <button data-url="<%=basePath%>hr/setUserListOrder.do?betweenId=${voi.betweenId}&type=deg&divId=layout-012"  class="btn-blue btn-resort" data-toggle="doajax"  data-icon="chevron-down" data-type="get">降序</button>
				          
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

