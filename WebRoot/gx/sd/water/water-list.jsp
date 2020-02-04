<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>water/water-list.do" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <div class="bjui-searchBar" style="line-height:60px">
            <label>房间号：</label><input type="text" name="filter_LIKES_roomName" value="${param.filter_LIKES_roomName}" style="width: 100px;">&nbsp;
            &nbsp;

            <select name="filter_EQS_time" data-toggle="selectpicker">
                <c:forEach var="date" items="${stringList}" varStatus="status">
                    <option value=${date} ${param.filter_EQS_time eq date?'selected':''}>${date}</option>
                </c:forEach>

            </select>

            <button type="submit" class="btn-blue btn" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            &nbsp;
            <button type="button" class="btn-green" data-url="<%=basePath%>water/bill-export.do" data-toggle="doexport" data-confirm-msg="确定要导出吗？" data-idname="delids" data-group="ids">导出</button>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th width="5%" align="center">序号</th>
            <th width="10%" align="center">房间号</th>
            <th width="10%" align="center">上次抄表</th>
            <th width="10%" align="center">本次抄表</th>
            <th width="10%" align="center">当月已用量</th>
            <th width="10%" align="center">账单费用</th>
            <th width="10%" align="center">余额</th>
            <th width="10%" align="center">上月结余</th>
            <th width="10%" align="center">时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="water" items="${page.result}" varStatus="status">
            <tr>
                <td align="center">${status.count}</td>
                <td align="center">${water.roomName}</td>
                <td align="center">${water.waterHistoryUse}</td>
                <td align="center">${water.waterCurrentUse}</td>
                <td align="center">${water.waterMonthUse}</td>
                <td align="center">${water.waterMonthMoney}</td>
                <td align="center">${water.waterBalance}</td>
                <td align="center">${water.waterBeforeBalance}</td>
                <td align="center">${water.timeSection}</td>
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
                <option value="1000">1000</option>
            </select>
        </div>
        <span>&nbsp;条，共 ${page.totalCount }条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination"
         data-total="${page.totalCount }" data-page-size="${page.pageSize }"
         data-page-current="${page.pageCurrent }"></div>
</div>
