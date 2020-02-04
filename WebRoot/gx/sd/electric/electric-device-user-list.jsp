<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch"  action="<%=basePath%>electric/user-room.do" method="post" data-reloadNavtab="false">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <input type="hidden" name="roomId" value="${roomId}">
        <div class="bjui-searchBar">
            <div class="pull-right">
                <br/>
                <button type="button" style="margin-right: 50px;width: 100px;" class="btn-green" data-url="http://localhost:8080/jbxqycy/electric/user-room-input.do?roomId=${roomId}"  data-toggle="dialog" data-target="device-input" data-id="device-input-dialog"  data-icon="plus" data-width="400" data-height="400">添加</button>&nbsp;
                <br/>
            </div>
        </div>

    </form>
</div>
<div class="bjui-pageContent">
    <table class="table table-bordered table-striped table-top" data-selected-multi="false">
        <thead>
        <tr>
            <th align="center" width="5%">排序</th>
            <th align="center" width="8%" >房间id</th>
            <th align="center" width="8%" >房间名</th>
            <th align="center" width="8%" >电表id</th>
            <th align="center" width="8%" >电表别名</th>
            <th align="center" width="8%">用户姓名</th>
            <th align="center" width="8%">用户手机号</th>
            <th align="center" width="8%">审核状态</th>
            <th align="center" width="8%">操作</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${page.result}" var="user" varStatus="status">
            <tr data-id="${user.rowId}">
                <td align="center">${status.index +1 }</td>
                <td align="center">${user.rowId}</td>
                <td align="center">${user.rowName}</td>
                <td align="center">${user.deviceId}</td>
                <td align="center">${user.deviceName}</td>
                <td align="center">${user.userName}</td>
                <td align="center">${user.userMobileNum }</td>
                <td align="center" style="${user.statu eq '0' ?'background-color:red':''}">${user.statu eq '0' ?'审核中':'已审核'}</td>
                <td align="center" >
                    <button type="button" class="btn-green" data-url="<%=basePath%>electric/user-room-input.do?userMobileNum=${user.userMobileNum}&roomId=${roomId}"  data-toggle="dialog"  data-id="device-update" data-target="device-update"  data-width="400" data-height="400">编辑</button>
                    <button type="button" class="btn-blue" data-url="<%=basePath %>electric/device-removeUser.do?rowId=${user.rowId}" data-toggle="doajax" data-confirm-msg="确定要删除选中项吗？" data-icon="remove">删除</button>
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