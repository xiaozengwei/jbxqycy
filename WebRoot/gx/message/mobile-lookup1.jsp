<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>message/mobile-lookup1.do" method="post">
    <input type="hidden" name="pageSize" value="${page.pageSize}">
    <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <div class="bjui-searchBar">
            <label>房间号：</label><input type="text" value="${param.filter_LIKES_roomId}" name="filter_LIKES_roomId" size="10" />&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>&nbsp;
            <div class="pull-right">
                <input type="checkbox" name="lookupType" value="1" data-toggle="icheck" data-label="追加" checked>
                <button type="button" class="btn-blue" data-toggle="lookupback" data-lookupid="ids" data-warn="请至少选择一个用户" data-icon="check-square-o">选择选中</button>
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageContent">
    <table data-toggle="tablefixed" data-width="100%">
        <thead>
            <tr>
                <th data-order-field="order">序号</th>
                <th data-order-field="roomId">房间号</th>
                <th data-order-field="userName">姓名</th>
                <th data-order-field="userPhone">手机号</th>
                <th width="28"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
                <th width="74">操作</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${wxUserRoomList}" var="wxUserRoom" varStatus="status">
        		 <tr>
               		 <td>${status.count}</td>
                	 <td>${wxUserRoom.roomId }</td>
                     <td>${wxUserRoom.userName }</td>
                     <td>${wxUserRoom.userPhone }</td>
                	  <td><input type="checkbox" name="ids" data-toggle="icheck" value="{roomId:'${wxUserRoom.roomId}', userPhone:'${wxUserRoom.userPhone}'}"></td>
                	 <td>
                    	 <a href="javascript:;" data-toggle="lookupback" data-args="{roomId:'${wxUserRoom.roomId}', userPhone:'${wxUserRoom.userPhone}'}" class="btn btn-blue" title="选择本项" data-icon="check">选择</a>
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