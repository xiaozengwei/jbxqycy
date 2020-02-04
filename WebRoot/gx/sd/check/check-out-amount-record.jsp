<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
    function openMydialog(obj) {
        var roomName=document.getElementById("roomName").value
        if(!roomName.localeCompare("")){
            alert("不允许为空")
            return
        }
        $(obj).dialog({id:'check-out-amount-input',title:'退费', url:'<%=basePath%>check/check-out-amount-input.do?roomName='+roomName,toggle:'dialog',target:'check-out-amount-input',width:'400' ,height:'350' });
    }
</script>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>check/check-out-amount-record.do" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar" style="line-height:60px">
            <label>房间号：</label>
            <input type="text" id="roomName" name="roomName" style="width: 100px;" >&nbsp;
            <button type="button" class="btn-green" onclick="openMydialog(this)">退费</button>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th width="3%" align="center">序号</th>
            <th width="10%" align="center">时间</th>
            <th width="5%" align="center">房间号</th>
            <th width="5%" align="center">姓名</th>
            <th width="8%" align="center">身份证</th>
            <th width="7%" align="center">手机</th>
            <th width="5%" align="center">电余额</th>
            <th width="5%" align="center">应缴水费</th>
            <th width="5%" align="center">状态</th>
            <th width="5%" align="center">金额</th>
            <th width="8%" align="center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="record" items="${page.result}" varStatus="status">
            <tr data-id="${record.rowId }">
                <td align="center">${status.count}</td>
                <td align="center"><fmt:formatDate value="${record.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td align="center">${record.roomName}</td>
                <td align="center">${record.userName}</td>
                <td align="center">${record.userIdCard}</td>
                <td align="center">${record.userPhone}</td>
                <td align="center">${record.electricBalance}</td>
                <td align="center">${record.waterMoney}</td>
                <td align="center">${record.status eq "0" ?"已退款": record.status eq "1" ?"未退款": record.status eq "2" ?"欠费":"已补"}</td>
                <td align="center">${record.refundMoney}</td>
                <td align="center">
                    <c:if test="${record.status eq '1' ||record.status eq '2'}">
                        <a type="button" class="btn btn-orange" href="<%=basePath%>check/refund-complete.do?rowId=${record.rowId}&balance=${record.electricBalance}&roomName=${record.roomName}" data-toggle="doajax" data-confirm-msg="是否完成？">确认</a>
                    </c:if>
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
