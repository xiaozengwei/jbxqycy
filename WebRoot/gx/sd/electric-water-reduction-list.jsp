<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>electric/electric-water-reduction.do" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar" style="line-height:60px">
            <label>房间号：</label><input type="text" name="filter_LIKES_roomName" value="${param.filter_LIKES_roomName }" style="width: 100px;">&nbsp;

            <button type="submit" class="btn-blue btn" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>

            <button type="button" class="btn-green" data-url="<%=basePath%>electric/reduce-input.do?type=electric"  data-toggle="dialog" data-target="reduce-electric-input" data-id="reduce-electric-input"  data-icon="plus" data-width="450" data-height="400">电扣费</button>&nbsp;
            <button type="button" class="btn-green" data-url="<%=basePath%>electric/reduce-input.do?type=water"  data-toggle="dialog" data-target="reduce-water-input" data-id="reduce-water-input"  data-icon="plus" data-width="450" data-height="400">水扣费</button>&nbsp;
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th width="10%" align="center">序号</th>
            <th width="10%" align="center">时间</th>
            <th width="5%" align="center">房间号</th>
            <th width="5%" align="center">电表id</th>
            <th width="5%" align="center">扣费金额</th>
            <th width="10%" align="center">操作者</th>
            <th width="10%" align="center">水/电</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="queryModel" items="${page.result}" varStatus="status">
            <tr data-id="${queryModel.rowId }">
                <td align="center">${status.count}</td>
                <td align="center"><fmt:formatDate value="${queryModel.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td align="center">${queryModel.roomName}</td>
                <td align="center">${queryModel.deviceId}</td>
                <td align="center">${queryModel.money}</td>
                <td align="center">${queryModel.userId}</td>
                <td align="center">${queryModel.type eq "0" ?"电":"水"}</td>
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
