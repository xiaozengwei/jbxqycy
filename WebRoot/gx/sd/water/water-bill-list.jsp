<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>water/water-bill-list.do" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <div class="bjui-searchBar" style="line-height:60px">
            <label>房间号：</label><input type="text" name="filter_LIKES_rowName" value="${param.filter_LIKES_rowName}" style="width: 100px;">&nbsp;
            &nbsp;
            <label>开始时间：</label>
            <select name="start" data-toggle="selectpicker" id="start">
                <c:forEach var="date" items="${stringList}" varStatus="status">
                    <option value=${date} ${date eq start?'selected':''}>${date}</option>
                </c:forEach>

            </select>
            &nbsp;

            <label>结束时间：</label>
            <select name="end" data-toggle="selectpicker" id="end">
                <c:forEach var="date" items="${stringList}" varStatus="status">
                    <option value=${date} ${date eq end?'selected':''}>${date}</option>
                </c:forEach>
            </select>

            &nbsp;
            <button type="submit" class="btn-blue btn" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            &nbsp;
            <button type="button" class="btn-green" data-url="<%=basePath%>water/water-export.do" data-toggle="doexport" data-confirm-msg="确定要导出吗？" data-idname="delids" data-group="ids">导出</button>
            &nbsp;
            &nbsp;
            <button type="button" class="btn-red" data-url="<%=basePath%>water/water-import.do"  data-toggle="dialog" data-target="water-input" data-id="water-input-dialog"  data-icon="plus" data-width="700" data-height="300">导入结算</button>&nbsp;

        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th width="5%" align="center">序号</th>
            <th width="5%" align="center">房间号</th>
            <th width="5%" align="center">上次抄表</th>
            <th width="5%" align="center">本次抄表</th>
            <th width="5%" align="center">当次耗水量</th>
            <th width="5%" align="center">当次消费金额</th>
            <th width="5%" align="center">时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="water" items="${list}" varStatus="status">
            <tr>
                <td align="center">${status.count}</td>
                <td align="center">${water.rowName}</td>
                <td align="center">${water.ext}</td>
                <td align="center">${water.totalWater}</td>
                <td align="center">${water.ext2}</td>
                <td align="center">${water.ext3}</td>
                <td align="center">${water.ext4}</td>
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
