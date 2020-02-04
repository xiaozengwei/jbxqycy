<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageHeader">
<form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>fwzl/fwzl-progress-list.do" method="post">
	        <input type="hidden" name="pageSize" value="${model.pageSize}">
	        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
	        <input type="hidden" name="orderField" value="${param.orderField}">
	        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
	        <div class="bjui-searchBar" style="line-height:60px">
	        	<label>申请企业名称：</label><input type="text" name="filter_LIKES_enterpriseName" value="${param.filter_LIKES_enterpriseName }">&nbsp;
	            <label>需求公寓类型：</label>
	            <select name="filter_EQS_apartmentType" data-toggle="selectpicker" style="font-size:15px">
	                <option value="">全部</option>
					<option value="标准间" ${param.filter_EQS_apartmentType eq '标准间' ? 'selected="selected"':'' }>标准间</option>
					<option value="大床房" ${param.filter_EQS_apartmentType eq '大床房' ? 'selected="selected"':'' }>大床房</option>
					<option value="两室一厅" ${param.filter_EQS_apartmentType eq '两室一厅' ? 'selected="selected"':'' }>两室一厅</option>
				</select>
				&nbsp;
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
				<th width="15%" align="center">申请企业名称</th>
				<th width="10%" align="center">企业经办人</th>
				<th width="10%" align="center">联系电话</th>
				<th width="10%" align="center">需求公寓类型</th>
				<th width="10%" align="center">需求公寓数量</th>
				<th width="10%" align="center">申请人</th>
				<th width="10%" align="center">申请日期</th>
				<th width="10%" align="center">办件状态</th>
				<th align="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vFwzlProcinst" items="${list }" varStatus="status">
				<tr data-id="${vFwzlProcinst.rowId }">
					<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${vFwzlProcinst.rowId}"></td>
					<td align="center">${status.count}</td>
					<td align="center">${vFwzlProcinst.enterpriseName}</td>
					<td align="center">${vFwzlProcinst.enterpriseManager}</td>
					<td align="center">${vFwzlProcinst.contactNumber}</td>
					<td align="center">${vFwzlProcinst.apartmentType }</td>
					<td align="center">${vFwzlProcinst.apartmentNumber }</td>
					<td align="center">${vFwzlProcinst.createUserName }</td>
					<td align="center"><fmt:formatDate value="${vFwzlProcinst.applyDate }" pattern="yyyy-MM-dd" /></td>
					<td align="center">
						<a class="btn btn-green" title="查看详情" href="<%=basePath%>fwzl/to-fwzl-view.do?rowId=${vFwzlProcinst.rowId}"  data-toggle="navtab" data-id="${vFwzlProcinst.rowId}">查看详情</a>
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