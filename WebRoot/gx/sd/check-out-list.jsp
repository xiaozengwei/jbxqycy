<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageHeader">
<form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>sd/check-out-list.do" method="post">
	        <input type="hidden" name="pageSize" value="${model.pageSize}">
	        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
	        <input type="hidden" name="orderField" value="${param.orderField}">
	        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
	        <div class="bjui-searchBar" style="line-height:60px">
				<label>房间号：</label><input type="text" name="filter_LIKES_roomId" value="${param.filter_LIKES_roomId }" style="width: 100px;">&nbsp;
	            <label>退房时间：</label>
	            <input type="text" name="filter_GED_createTime" value="${param.filter_GED_createTime}" data-toggle="datepicker" readonly="readonly"> —
	            <input type="text" name="filter_LED_createTime" value="${param.filter_LED_createTime}" data-toggle="datepicker" readonly="readonly">
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
				<th width="5%" align="center">房间号</th>
				<th width="5%" align="center">姓名</th>
				<th width="10%" align="center">手机号</th>
				<th width="8%" align="center">电费余额</th>
				<th width="8%" align="center">水费余额</th>
				<th width="8%" align="center">用水量</th>
				<th width="8%" align="center">退款金额</th>
				<th width="8%" align="center">补缴费用</th>
				<th width="10%" align="center">退房时间</th>
				<th width="15%" align="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="checkOutRoom" items="${list }" varStatus="status">
				<tr data-id="${checkOutRoom.rowId }">
					<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${checkOutRoom.rowId}"></td>
					<td align="center">${checkOutRoom.roomId}</td>
					<td align="center">${checkOutRoom.userName}</td>
					<td align="center">${checkOutRoom.userPhone}</td>
					<td align="center">${checkOutRoom.electricBalance}</td>
					<td align="center">${checkOutRoom.waterBalance}</td>
					<td align="center">${checkOutRoom.waterUse}</td>
					<td align="center">${checkOutRoom.refundMoney}</td>
					<td align="center">${checkOutRoom.backMoney}</td>
					<td align="center"><fmt:formatDate value="${checkOutRoom.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td align="center">
						<button type="button" data-title="查看详情" class="btn-green" data-url="<%=basePath%>sd/to-check-out-detail.do?rowId=${checkOutRoom.rowId}" data-toggle="dialog" data-id="${checkOutRoom.rowId}" data-width="450" data-height="550" >查看详情</button>
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