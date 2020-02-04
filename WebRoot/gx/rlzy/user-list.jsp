<%@page import="com.gx.soft.sys.persistence.domain.GxSysOrg"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="/common/taglibs.jsp"%>
<%
	List<GxSysOrg> orgs = (List<GxSysOrg>)session.getAttribute("orgs");
%>
<script type="text/javascript">
$(function() {
	var a = $("#text1").val();
	var b = $("#text2").val();
	var x;
		$("#one option").each(function(){
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

	function opNavtab11(obj,user_row_id,org_name){
		var user_row_id=$("#"+user_row_id,$.CurrentNavtab).val()
		var org_name=$("#"+org_name,$.CurrentNavtab).val()
		org_name=encodeURI(encodeURI(org_name))
		$(obj).navtab({id:'mynavtab', url:'<%=basePath%>hr/user-detail.do?user_row_id='+user_row_id+'&org_name='+org_name,title:$(obj).data("title")});
	
	}
	function opNavtab_print(obj,user_row_id,org_name){
		var user_row_id=$("#"+user_row_id,$.CurrentNavtab).val()
		var org_name=$("#"+org_name,$.CurrentNavtab).val()
		org_name=encodeURI(encodeURI(org_name))
		var _url = '<%=basePath%>hr/user-detail2-print.do?user_row_id='+user_row_id+'&org_name='+org_name;
			 window.open(_url,'_blank');
	}
	function opdialog(obj,org_rowId01,org_name01){
		var org_rowId=$("#"+org_rowId01,$.CurrentNavtab).val()
		var org_name=$("#"+org_name01,$.CurrentNavtab).val()
		org_name=encodeURI(encodeURI(org_name))
		$(obj).dialog({ url:'<%=basePath%>hr/user-add.do?org_rowId='+org_rowId+'&org_name='+org_name,width:'750',height:'800',title:'添加'});
	}
	function opdialog1(obj,user_row_id,org_name01,betweenId){
		var user_row_id=$("#"+user_row_id,$.CurrentNavtab).val()
		var org_name=$("#"+org_name01,$.CurrentNavtab).val()
		org_name=encodeURI(encodeURI(org_name))
		var betweenId=$("#"+betweenId,$.CurrentNavtab).val()
		$(obj).dialog({ url:'<%=basePath%>hr/user-edit.do?user_row_id='+user_row_id+'&org_name='+org_name+'&betweenId='+betweenId,width:'750',height:'800',title:'编辑'});
	}
</script>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch"
				action="../hr/select-list/user-list.do" method="post" style="margin-bottom: 0">
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
						type="hidden" id="text1" value="${param.filter_EQS_rowId}">
						<input type="hidden"  name="fitler_EQS_rowId" id="text2" value="${v_row_Id}">
					<select name="filter_EQS_rowId" data-toggle="selectpicker" id="one">
						<option value="">全部</option>
						<%
							for (int i = 0; i < orgs.size(); i++) {
								if (!("root".equals(orgs.get(i).getParentOrgId()))) {
							%>
						<option value="<%=orgs.get(i).getRowId()%>"><%=orgs.get(i).getOrgName()%></option>
						<%}} %>
					<input type="hidden" value="${a }" name="a">
					<button type="submit" class="btn-default" data-icon="search">查询</button>
					&nbsp;
				</div>
		<c:if test="${a==1 }">
			<div class="pull-left">
				<button type="button" class="btn-red" data-toggle="doajaxchecked"
					data-url="<%=basePath%>hr/user-delete.do"
					data-confirm-msg="确定要删除选中项吗？" data-idname="delids" data-group="ids" data-icon="remove">删除选中</button>
				<button type="button" class="btn-green" data-toggle="dialog" 
					onclick="opdialog(this,'org_rowId01','org_name01')" data-title="添加用户"
					data-icon="plus"  data-id="add_user">添加用户</button>
					
					<button type="button" class="btn-green" data-url="<%=basePath%>hr/user-input-orgs.do?orgId=${v_row_Id}"  
					data-toggle="dialog" data-target="sysuser-input"
					 data-icon="plus" data-width="600" data-height="400">添加多组织人员</button>
					 
					<button type="button" class="btn-blue" data-url="<%=basePath %>hr/user-orgs-remove.do" 
					data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" 
					data-idname="delids" data-group="ids" >解除组织关系</button>
					<input type="hidden" id="org_rowId01" value="${org_rowId}"> 
					<input type="hidden" id="org_name01" value="${org_name}">
			</div>
		</c:if>
		</form>
</div>
<div class="bjui-pageContent tableContent"  >
	
	<table class="table table-bordered table-hover table-striped table-top table-center" data-selected-multi="true"  style="border-top:1px #dddddd solid">
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
            <tr data-id="0">
            	<td><input type="checkbox" name="ids" data-toggle="icheck"  value="${voi.userOrgKey}">
			 	</td>
			  <td >${status.index+1 }</td>
              <td >${voi.rowId}</td>
              <td>${voi.userName}</td>
              <td>${voi.userCardId }</td>
              <td>${voi.userJob}</td>
              <td>${voi.orgName }</td>
              <td><c:if test="${a==1 }"><button data-id="rl-started" onclick="opdialog1(this,'user_row_id${status.index+1 }','org_name${status.index+1 }','betweenId${status.index+1 }')"  data-title="编辑用户" data-toggle="dialog" type="button" class="btn-default" id="selectaddworkpeo" >编辑</button>
                </c:if>
                <button data-toggle="navtab" type="button" class="btn-default" style=""  data-title="查看用户"
					 onclick="opNavtab11(this,'user_row_id${status.index+1 }','org_name${status.index+1 }')" >查看</button> 
					<button data-toggle="navtab" type="button" class="btn btn-blue doc-print"  data-icon="print"  data-id="userDetail-print"
					 onclick="opNavtab_print(this,'user_row_id${status.index+1 }','org_name${status.index+1 }')" >打印</button>
					 <button data-url="<%=basePath%>hr/setUserListOrder.do?betweenId=${voi.betweenId}&type=add&divId=layout-01" class="btn-blue btn-resort" data-toggle="doajax" data-icon="chevron-up" data-type="get">升序</button>
                    <button data-url="<%=basePath%>hr/setUserListOrder.do?betweenId=${voi.betweenId}&type=deg&divId=layout-01"  class="btn-blue btn-resort" data-toggle="doajax"  data-icon="chevron-down" data-type="get">降序</button>
               		<input type="hidden" id="user_row_id${status.index+1 }" value="${voi.userRowId}"> 
					<input type="hidden" id="org_name${status.index+1 }" value="${voi.orgName}">
					<input type="hidden" id="betweenId${status.index+1 }" value="${voi.betweenId}">
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

