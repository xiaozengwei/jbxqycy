<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageHeader">
<form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>ykt/ykt-task-list.do" method="post">
	        <input type="hidden" name="pageSize" value="${model.pageSize}">
	        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
	        <input type="hidden" name="orderField" value="${param.orderField}">
	        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
	        <div class="bjui-searchBar" style="line-height:60px">
	        	<label>姓名：</label><input type="text" name="filter_LIKES_applicantName" value="${param.filter_LIKES_applicantName }">&nbsp;
	            <label>公司名称：</label><input type="text" name="filter_LIKES_companyName" value="${param.filter_LIKES_companyName }">&nbsp;
	            <label>申请日期：</label>
	            <input type="text" name="filter_GED_createTime" value="${param.filter_GED_createTime}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly"> —
	            <input type="text" name="filter_LED_createTime" value="${param.filter_LED_createTime}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly">
	            &nbsp;
	            <button type="submit" class="btn-blue btn" data-icon="search">查询</button>&nbsp;
	            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
	        </div>
</form>
</div>
<div class="bjui-pageContent tableContent">
	<table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
		<thead>
			<tr>
				<th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
				<th width="5%" align="center">序号</th>
				<th width="10%" align="center">姓名</th>
				<th width="10%" align="center">手机号</th>
				<th width="20%" align="center">身份证</th>
				<th width="10%" align="center">办卡数目</th>
				<th width="20%" align="center">公司名称</th>
				<th width="10%" align="center">申请日期</th>
				<th align="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vYktInstAct" items="${yktList }" varStatus="status">
				<tr data-id="${vYktInstAct.rowId }">
					<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${vYktInstAct.rowId}"></td>
					<td align="center">${status.count}</td>
					<td align="center">${vYktInstAct.applicantName}</td>
					<td align="center">${vYktInstAct.applicantPhone}</td>
					<td align="center">${vYktInstAct.applicantIdCard}</td>
					<td align="center">${vYktInstAct.cardNumber}</td>
					<td align="center">${vYktInstAct.companyName}</td>
					<td align="center"><fmt:formatDate value="${vYktInstAct.createTime }" pattern="yyyy-MM-dd" /></td>
					<td align="center">
						<a class="btn btn-green" title="办理" href="<%=basePath%>ykt/ykt-handle-page.do?rowId=${vYktInstAct.rowId}"  data-toggle="navtab" data-id="${vYktInstAct.rowId}">办理</a>
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
	<div class="pagination-box" data-toggle="pagination"
		data-total="${page.totalCount }" data-page-size="${page.pageSize }"
		data-page-current="${page.pageCurrent }"></div>
</div>

<script type="text/javascript">
function printDJB(rowId, obj){
	$(obj).attr("class","btn btn-orange");
	window.open("<%=path %>/sp-tzsb-sg/print-djb.do?rowId="+rowId);
}
</script>