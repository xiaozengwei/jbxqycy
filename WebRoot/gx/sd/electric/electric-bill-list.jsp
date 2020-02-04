<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script>
    function select(){
        var value=$("#on option:selected").val();
        var led=document.getElementById('led');
        var led1=document.getElementById('led1');
        var ged=document.getElementById('ged');
        var ged1=document.getElementById('ged1');
        if(value==1){
            led.style.display="none";
            led1.style.display="inline-block";
            ged.style.display="none";
            ged1.style.display="inline-block";
        }else {
            led1.style.display="none";
            led.style.display="inline-block";
            ged1.style.display="none";
            ged.style.display="inline-block";
        }
        console.info(value)
    }
    console.info($("#on option:selected").val())
</script>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>electric/electric-bill-list.do" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <div class="bjui-searchBar" style="line-height:60px">
            <label>房间号：</label><input type="text" name="filter_LIKES_rowName" value="${param.filter_LIKES_rowName}" style="width: 100px;">&nbsp;
            &nbsp;
            <label>账单周期：</label>
            <select name="type" data-toggle="selectpicker" id="on" onchange="select();">
                <option value="1" ${type eq '1'?'selected':''}>自定义时间菜单</option>
                <option value="0" ${type eq '0'?'selected':''}>月账单</option>
            </select>
            &nbsp;

            时间：
            <input id="ged1" type="text" name="ged1" value="${param.ged1}" data-pattern="yyyy-MM-dd" data-min-date="2019-01-01" data-max-date="%y-%M-{%d-1}" data-nobtn="true" data-toggle="datepicker" readonly="readonly" style='${type eq '0'?"display:none":"display: inline-block"}'>
            <input id="ged" type="text" name="ged" value="${param.ged}" data-pattern="yyyy-MM" data-min-date="2019-01" data-max-date="%y-%M-{%d-1}" data-nobtn="true" data-toggle="datepicker" readonly="readonly" style='${type eq '0'?"display: inline-block":"display:none"}'>—
            <input id="led1" type="text" name="led1" value="${param.led1}" data-pattern="yyyy-MM-dd" data-min-date="2019-01-01" data-max-date="%y-%M-{%d-1}" data-nobtn="true" data-toggle="datepicker" readonly="readonly" style='${type eq '0'?"display:none":"display: inline-block"}'>
            <input id="led" type="text" name="led" value="${param.led}" data-pattern="yyyy-MM" data-min-date="2019-01" data-max-date="%y-%M-{%d-1}" data-nobtn="true" data-toggle="datepicker" readonly="readonly" style='${type eq '0'?"display: inline-block":"display:none"}'>


            &nbsp;
            <button type="submit" class="btn-blue btn" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            &nbsp;
            <button type="button" class="btn-green" data-url="<%=basePath%>electric/export.do" data-toggle="doexport" data-confirm-msg="确定要导出吗？" data-idname="delids" data-group="ids">导出</button>
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
        <%--<th width="10%" align="center">总电量</th>--%>
            <%--<th width="10%" align="center">尖</th>--%>
            <%--<th width="10%" align="center">峰</th>--%>
            <%--<th width="10%" align="center">谷</th>--%>
            <%--<th width="10%" align="center">平</th>--%>
            <th width="10%" align="center">当月已用总电量</th>
            <th width="10%" align="center">账单费用</th>
            <th width="10%" align="center">余额</th>
            <th width="10%" align="center">模式</th>
            <th width="10%" align="center">时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="electric" items="${page.result}" varStatus="status">
            <tr>
                <td align="center">${status.count}</td>
                <td align="center">${electric.rowName}</td>
                <td align="center"><fmt:formatNumber type="float" value="${electric.totalEnergyStart}" pattern="#.00"/></td>
                <td align="center"><fmt:formatNumber type="float" value="${electric.totalEnergyEnd}" pattern="#.00"/></td>
            <%--<td align="center">${electric.tipEnergy}</td>--%>
                <%--<td align="center">${electric.peakEnergy}</td>--%>
                <%--<td align="center">${electric.valleyEnergy}</td>--%>
                <%--<td align="center">${electric.flatEnergy}</td>--%>
                <td align="center"><fmt:formatNumber type="float" value="${electric.totalEnergyEnd-electric.totalEnergyStart}" pattern="#.00"/></td>
                <td align="center"><fmt:formatNumber type="float" value="${(electric.totalEnergyEnd-electric.totalEnergyStart)*0.7364}" pattern="#.00"/></td>
                <td align="center">${electric.balance}</td>
                <td align="center">${electric.settleTypeName}</td>
                <td align="center">${type eq"0"?electric.time:electric.ext}</td>
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
