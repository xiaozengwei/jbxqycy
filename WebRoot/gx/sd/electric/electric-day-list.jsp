<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>electric/electric-month-list.do" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar" style="line-height:60px">

        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th width="5%" align="center">序号</th>
            <th width="10%" align="center">房间号</th>
            <th width="10%" align="center">电表id</th>
            <th width="10%" align="center">总电量</th>
            <%--<th width="10%" align="center">尖</th>--%>
            <%--<th width="10%" align="center">峰</th>--%>
            <%--<th width="10%" align="center">谷</th>--%>
            <%--<th width="10%" align="center">平</th>--%>
            <th width="10%" align="center">当月已用总电量</th>
            <th width="10%" align="center">余额</th>
            <th width="10%" align="center">时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="electric" items="${page.result}" varStatus="status">
            <tr>
                <td align="center">${status.count}</td>
                <td align="center">${electric.flatEnergy}</td>
                <td align="center">${electric.deviceId}</td>
                <td align="center">${electric.totalEnergy}</td>
                <%--<td align="center">${electric.tipEnergy}</td>--%>
                <%--<td align="center">${electric.peakEnergy}</td>--%>
                <%--<td align="center">${electric.valleyEnergy}</td>--%>
                <%--<td align="center">${electric.flatEnergy}</td>--%>
                <td align="center">${electric.ext}</td>
                <td align="center">${electric.balance}</td>
                <td align="center">${electric.time}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%--<div class="bjui-pageFooter">--%>
<%--<div class="pages">--%>
<%--<span>每页&nbsp;</span>--%>
<%--<div class="selectPagesize">--%>
<%--<select data-toggle="selectpicker"--%>
<%--data-toggle-change="changepagesize">--%>
<%--<option value="10">10</option>--%>
<%--<option value="15">15</option>--%>
<%--<option value="20">20</option>--%>
<%--<option value="25">25</option>--%>
<%--</select>--%>
<%--</div>--%>
<%--<span>&nbsp;条，共 ${page.totalCount }条</span>--%>
<%--</div>--%>
<%--<div class="pagination-box" data-toggle="pagination"--%>
<%--data-total="${page.totalCount }" data-page-size="${page.pageSize }"--%>
<%--data-page-current="${page.pageCurrent }"></div>--%>
<%--</div>--%>
