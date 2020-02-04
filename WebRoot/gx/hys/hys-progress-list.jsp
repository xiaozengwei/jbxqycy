<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageHeader">
<form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>hys/hys-progress-list.do" method="post">
	        <input type="hidden" name="pageSize" value="${model.pageSize}">
	        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
	        <input type="hidden" name="orderField" value="${param.orderField}">
	        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
	        <div class="bjui-searchBar" style="line-height:60px">
	        	<label>公司名称：</label><input type="text" name="filter_LIKES_companyName" value="${param.filter_LIKES_companyName }">&nbsp;
	            <label>会议室：</label>
	            <select name="filter_EQS_selectedRoom" data-toggle="selectpicker" style="font-size:15px">
	                <option value="">全部</option>
					<option value="企业家俱乐部" ${param.filter_EQS_selectedRoom == '企业家俱乐部'?'selected="selected"':''}>企业家俱乐部</option>
					<option value="宣讲厅" ${param.filter_EQS_selectedRoom == '宣讲厅'?'selected="selected"':''}>宣讲厅</option>
					<option value="大报告厅" ${param.filter_EQS_selectedRoom == '大报告厅'?'selected="selected"':''}>大报告厅</option>
					<option value="会议室1" ${param.filter_EQS_selectedRoom == '会议室1'?'selected="selected"':''}>会议室1</option>
					<option value="会议室2" ${param.filter_EQS_selectedRoom == '会议室2'?'selected="selected"':''}>会议室2</option>
					<option value="会议室3" ${param.filter_EQS_selectedRoom == '会议室3'?'selected="selected"':''}>会议室3</option>
					<option value="会议室4" ${param.filter_EQS_selectedRoom == '会议室4'?'selected="selected"':''}>会议室4</option>
					<option value="路演厅" ${param.filter_EQS_selectedRoom == '路演厅'?'selected="selected"':''}>路演厅</option>
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
				<th width="10%" align="center">姓名</th>
				<th width="10%" align="center">手机号</th>
				<th width="15%" align="center">公司名称</th>
				<th width="10%" align="center">会议开始时间</th>
				<th width="10%" align="center">会议结束时间</th>
				<th width="10%" align="center">选择会议室</th>
				<th width="10%" align="center">申请日期</th>
				<th align="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vMeetProcinst" items="${list }" varStatus="status">
				<tr data-id="${vMeetProcinst.rowId }">
					<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${vMeetProcinst.rowId}"></td>
					<td align="center">${status.count}</td>
					<td align="center">${vMeetProcinst.applicantName}</td>
					<td align="center">${vMeetProcinst.applicantPhone}</td>
					<td align="center">${vMeetProcinst.companyName}</td>
					<td align="center"><fmt:formatDate value="${vMeetProcinst.meetStartTime }" pattern="yyyy-MM-dd HH:mm" /></td>
					<td align="center"><fmt:formatDate value="${vMeetProcinst.meetEndTime }" pattern="yyyy-MM-dd HH:mm" /></td>
					<td align="center">${vMeetProcinst.selectedRoom }</td>
					<td align="center"><fmt:formatDate value="${vMeetProcinst.createTime }" pattern="yyyy-MM-dd" /></td>
					<td align="center">
						<a class="btn btn-green" title="查看详情" href="<%=basePath%>hys/to-hys-view.do?rowId=${vMeetProcinst.rowId}"  data-toggle="navtab" data-id="${vMeetProcinst.rowId}">查看详情</a>
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