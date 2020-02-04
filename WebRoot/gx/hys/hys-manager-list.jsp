<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageHeader">
<form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>hys/hys-manager-list.do" method="post">
	        <input type="hidden" name="pageSize" value="${model.pageSize}">
	        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
	        <input type="hidden" name="orderField" value="${param.orderField}">
	        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
	        <div class="bjui-searchBar" style="line-height:60px">
	            <label>会议室状态：</label>
	            <select name="filter_EQS_roomStatus" data-toggle="selectpicker" style="font-size:15px">
	                <option value="">全部</option>
					<option value="在用" ${param.filter_EQS_roomStatus == '在用'?'selected="selected"':''}>在用</option>
					<option value="冻结" ${param.filter_EQS_roomStatus == '冻结'?'selected="selected"':''}>冻结</option>
				</select>
				&nbsp;
	            <label>创建日期：</label>
	            <input type="text" name="filter_GED_createTime" value="${param.filter_GED_createTime}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly"> —
	            <input type="text" name="filter_LED_createTime" value="${param.filter_LED_createTime}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly">
	            &nbsp;
	            <button type="submit" class="btn-blue btn" data-icon="search">查询</button>&nbsp;
	            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
				<div class="pull-right">
					<button type="button" class="btn-green" data-url="<%=basePath%>hys/to-meet-input.do"  data-toggle="dialog" data-target="menu-input" data-id="menu-input-dialog"  data-icon="plus" data-width="500" data-height="450">新增会议室</button>&nbsp;
					<button type="button" class="btn-blue" data-url="<%=basePath %>hys/meet-remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids" >删除选中项</button>
				</div>
	        </div>
</form>
</div>
<div class="bjui-pageContent tableContent">
	<table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
		<thead>
			<tr>
				<th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
				<th width="5%" align="center">序号</th>
				<th width="10%" align="center">会议室名称</th>
				<th width="30%" align="center">地址</th>
				<th width="8%" align="center">会议室状态</th>
				<th width="8%" align="center">建筑面积</th>
				<th width="10%" align="center">长度*宽度</th>
				<th width="12%" align="center">屏幕尺寸</th>
				<th align="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="meetingRoomInfo" items="${list }" varStatus="status">
				<tr data-id="${meetingRoomInfo.rowId }">
					<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${meetingRoomInfo.rowId}"></td>
					<td align="center">${status.count}</td>
					<td align="center">${meetingRoomInfo.roomName}</td>
					<td align="center">${meetingRoomInfo.roomAddress}</td>
					<td align="center">${meetingRoomInfo.roomStatus}</td>
					<td align="center">${meetingRoomInfo.buildArea }</td>
					<td align="center">${meetingRoomInfo.lengthWidth }</td>
					<td align="center">${meetingRoomInfo.screenSize }</td>
					<td align="center">
						<button type="button" class="btn-green" data-url="<%=basePath%>hys/to-meet-input.do?rowId=${meetingRoomInfo.rowId}" data-toggle="dialog" data-id="meet-update" data-target="meet-update" data-width="500" data-height="450">编辑</button>
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

</script>