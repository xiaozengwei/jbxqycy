<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageHeader">
<form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>sd/sd-query-list.do" method="post">
	        <input type="hidden" name="pageSize" value="${model.pageSize}">
	        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
	        <input type="hidden" name="orderField" value="${param.orderField}">
	        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
	        <div class="bjui-searchBar" style="line-height:60px">
	        	<label>一卡通号：</label><input type="text" name="filter_LIKES_cardNumber" value="${param.filter_LIKES_cardNumber }">&nbsp;
	            <label>楼栋号：</label><input type="text" name="filter_LIKES_buildNum" value="${param.filter_LIKES_buildNum }" style="width: 100px;">&nbsp;
				<label>房间号：</label><input type="text" name="filter_LIKES_roomNum" value="${param.filter_LIKES_roomNum }" style="width: 100px;">&nbsp;
	            <label>时间段：</label>
	            <input type="text" name="startTime" value="${param.startTime}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly"> —
	            <input type="text" name="endTime" value="${param.endTime}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly">
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
				<th width="10%" align="center">一卡通</th>
				<th width="5%" align="center">姓名</th>
				<th width="5%" align="center">楼栋号</th>
				<th width="5%" align="center">房间号</th>
				<th width="10%" align="center">开始时间</th>
				<th width="10%" align="center">结束时间</th>
				<th width="5%" align="center">用水量</th>
				<th width="5%" align="center">用电量</th>
				<th width="5%" align="center">产生水价格</th>
				<th width="5%" align="center">产生电价格</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="queryModel" items="${modelList }" varStatus="status">
				<tr data-id="${queryModel.cardNumber }">
					<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${queryModel.cardNumber}"></td>
					<td align="center">${queryModel.cardNumber}</td>
					<td align="center">${queryModel.cardHolder}</td>
					<td align="center">${queryModel.buildNum}</td>
					<td align="center">${queryModel.roomNum}</td>
					<td align="center"><fmt:formatDate value="${queryModel.startTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td align="center"><fmt:formatDate value="${queryModel.endTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td align="center">${queryModel.waterNumber }</td>
					<td align="center">${queryModel.electricNumber }</td>
					<td align="center">${queryModel.waterMoney }</td>
					<td align="center">${queryModel.electricMoney }</td>
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