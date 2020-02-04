<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>water/water-arrearage.do" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">

        <div class="bjui-searchBar" style="line-height:60px">
            <label>房间号：</label><input type="text" name="roomName" value="${roomName}" style="width: 100px;">&nbsp;
            <label>状态：</label>
            <select name="type" data-toggle="selectpicker" id="on">
                <option value="0">全部</option>
                <option value="-1" ${type eq '-1'?'selected':''}>水欠费</option>
            </select>
            <button type="submit" class="btn-blue btn" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>

            <button type="button" class="btn-green" data-url="<%=basePath%>water/balance-export.do" data-toggle="doexport" data-confirm-msg="确定要导出吗？" data-idname="delids" data-group="ids">导出</button>

            <div class="pull-right" style="line-height:60px;">
                <label>水余额总额：${waterSum} </label>&nbsp&nbsp
                <label>电余额总额：${electricSum} </label>
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th width="1%" align="center">序号</th>
            <th width="1%" align="center">房间号</th>
            <th width="3%" align="center">水余额</th>
            <th width="3%" align="center">电余额</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="record" items="${page.result}" varStatus="status">
            <tr>
                <td align="center">${status.count}</td>
                <td align="center">${record.roomName}</td>
                <td align="center">${record.balance}</td>
                <td align="center">${record.ext}</td>
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
