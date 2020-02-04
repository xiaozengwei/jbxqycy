<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageHeader">
<form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>sd/room-bind-list.do" method="post">
	        <input type="hidden" name="pageSize" value="${model.pageSize}">
	        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
	        <input type="hidden" name="orderField" value="${param.orderField}">
	        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
	        <div class="bjui-searchBar" style="line-height:60px">
				<label>房间号：</label><input type="text" name="filter_LIKES_roomId" value="${param.filter_LIKES_roomId }" style="width: 100px;">&nbsp;
	            <label>充值时间：</label>
	            <input type="text" name="filter_GED_bindTime" value="${param.filter_GED_bindTime}" data-toggle="datepicker" readonly="readonly"> —
	            <input type="text" name="filter_LED_bindTime" value="${param.filter_LED_bindTime}" data-toggle="datepicker" readonly="readonly">
	            &nbsp;	            
	            <button type="submit" class="btn-blue btn" data-icon="search">查询</button>&nbsp;
	            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>

				<button type="button" class="btn-green" data-url="<%=basePath%>sd/to-user-room-input.do"  data-toggle="dialog" data-target="user-room-input" data-id="user-room-input"  data-icon="plus" data-width="450" data-height="400">房间绑定</button>&nbsp;

				<button type="button" class="btn-green" data-url="<%=basePath%>sd/to-room-rent.do"  data-toggle="dialog" data-target="room-rent" data-id="room-rent"  data-icon="plus" data-width="450" data-height="400">房间租赁</button>&nbsp;
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
				<th width="15%" align="center">身份证号</th>
				<th width="10%" align="center">手机号</th>
				<th width="10%" align="center">绑定时间</th>
				<th width="10%" align="center">解绑时间</th>
				<th width="10%" align="center">入住时间</th>
				<th width="10%" align="center">到期时间</th>
				<th width="15%" align="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="wxUserRoom" items="${wxUserRoomList }" varStatus="status">
				<tr data-id="${wxUserRoom.rowId }">
					<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${wxUserRoom.rowId}"></td>
					<td align="center">${wxUserRoom.roomId}</td>
					<td align="center">${wxUserRoom.userName}</td>
					<td align="center">${wxUserRoom.userIdCard}</td>
					<td align="center">${wxUserRoom.userPhone}</td>
					<td align="center"><fmt:formatDate value="${wxUserRoom.bindTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td align="center"><fmt:formatDate value="${wxUserRoom.unbindTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td align="center"><fmt:formatDate value="${wxUserRoom.inTime }" pattern="yyyy-MM-dd" /></td>
					<td align="center"><fmt:formatDate value="${wxUserRoom.outTime }" pattern="yyyy-MM-dd" /></td>
					<td align="center">
						<a class="btn btn-green" title="修改信息" href="<%=basePath%>sd/to-user-room-input.do?rowId=${wxUserRoom.rowId}" data-toggle="dialog" data-id="${wxUserRoom.rowId}" data-target="user-room-update"  data-width="500" data-height="400">修改信息</a>
						<a type="button" class="btn btn-orange" href="<%=basePath%>sd/room-unbind.do?rowId=${wxUserRoom.rowId}" data-toggle="doajax" data-confirm-msg="确定要解除绑定吗？">解除绑定</a>
						<button class="btn-blue" onclick="checkOut('${wxUserRoom.rowId}')">退房</button>
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
function checkOut(rowId){
    $.ajax({
        url : '<%=path %>/sd/check-out-validate.do',
        type : 'post',
        data : {},
        dataType : 'json',
        cache : false,
        success : function(result) {
            if (result.statusCode == '200') {
                $(this).dialog({id:rowId, url:'<%=basePath%>sd/check-out.do?rowId='+rowId, title:'退房', width:'450', height:'550'});
            }else{
                $(this).alertmsg('info', result.message);
            }
        }
    });

}
</script>