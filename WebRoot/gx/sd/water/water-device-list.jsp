<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch"  action="<%=basePath%>water/water-device-list.do" method="post">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <input type="hidden" name="rowId" value="${rowId}">
        <div class="bjui-searchBar">
            <div class="pull-right">
            </div>
        </div>

    </form>
</div>
<div class="bjui-pageContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th  width="5%"  align="center">序号</th>
            <th  width="5%"  align="center">房间号</th>
            <th width="5%"  align="center">水表addr</th>
            <th width="10%" align="center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="device" varStatus="status">
            <tr data-id="${device.rowId}">
                <td align="center">${status.count}</td>
                <td align="center">${device.rowName}</td>
                <td align="center" id="device">${device.addr}</td>
                <td align="center">
                    <%--<a href="<%=basePath%>water/water-user-room.do?roomId=${device.rowId}"  data-toggle="navtab" data-id="user-room"  data-title="关联用户">关联用户</a>||--%>
                    <a href="<%=basePath%>water/water-day-list.do?deviceId=${device.deviceId}"  data-toggle="navtab" data-id="water-day"  data-title="最新抄表">最新抄表</a>||
                    <a href="<%=basePath%>water/water-month-list.do?deviceId=${device.deviceId}"  data-toggle="navtab" data-id="water-month"  data-title="历史抄表">历史抄表</a>
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