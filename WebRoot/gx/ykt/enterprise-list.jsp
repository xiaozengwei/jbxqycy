<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageHeader">
<form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>ykt/enterprise-list.do" method="post">
	        <input type="hidden" name="pageSize" value="${model.pageSize}">
	        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
	        <input type="hidden" name="orderField" value="${param.orderField}">
	        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
	        <div class="bjui-searchBar" style="line-height:60px">
	            <label>公司名称：</label><input type="text" name="filter_LIKES_enterpriseName" value="${param.filter_LIKES_enterpriseName }">&nbsp;
	            <label>创建时间：</label>
	            <input type="text" name="filter_GED_createTime" value="${param.filter_GED_createTime}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly"> —
	            <input type="text" name="filter_LED_createTime" value="${param.filter_LED_createTime}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly">
	            &nbsp;
	            <button type="submit" class="btn-blue btn" data-icon="search">查询</button>&nbsp;
	            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
				&nbsp;
				<button type="button" data-title="公司添加" class="btn-green" data-url="<%=basePath%>ykt/enterprise-input.do" data-toggle="dialog" data-id="${enterpriseInfo.rowId}_input" data-width="400" data-height="400" >公司添加</button>
	        </div>
</form>
</div>
<div class="bjui-pageContent tableContent">
	<table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
		<thead>
			<tr>
				<th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
				<th width="5%" align="center">序号</th>
				<th width="20%" align="center">公司名称</th>
				<th width="10%" align="center">账号</th>
				<th width="20%" align="center">地址</th>
				<th width="10%" align="center">联系人</th>
				<th width="10%" align="center">联系电话</th>
				<th width="10%" align="center">创建时间</th>
				<th align="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="enterpriseInfo" items="${list }" varStatus="status">
				<tr data-id="${enterpriseInfo.rowId }">
					<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${enterpriseInfo.rowId}"></td>
					<td align="center">${status.count}</td>
					<td align="center">${enterpriseInfo.enterpriseName}</td>
					<td align="center">${enterpriseInfo.enterpriseId}</td>
					<td align="center">${enterpriseInfo.orgAddress}</td>
					<td align="center">${enterpriseInfo.contactName}</td>
					<td align="center">${enterpriseInfo.contactPhone}</td>
					<td align="center"><fmt:formatDate value="${enterpriseInfo.createTime }" pattern="yyyy-MM-dd" /></td>
					<td align="center">
						<button type="button" data-title="修改" class="btn-green" data-url="<%=basePath%>ykt/enterprise-input.do?rowId=${enterpriseInfo.rowId}" data-toggle="dialog" data-id="${enterpriseInfo.rowId}_input" data-width="400" data-height="400" >修改</button>
						<button type="button" data-title="查看" class="btn-green" data-url="<%=basePath%>ykt/enterprise-detail.do?rowId=${enterpriseInfo.rowId}" data-toggle="dialog" data-id="${enterpriseInfo.rowId}_detail" data-width="400" data-height="400" >查看</button>
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