<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<style type="text/css">
    .choose-btn { display: none; }
    .choose-label { box-shadow: #b1b1b1 0px 0px 0px 1px; width: 30px; height: 16px; display: inline-block; border-radius: 16px; position: relative; background-color: #bdbdbd; overflow: hidden; margin: 0; margin-top: 4px; cursor: pointer; vertical-align: middle; }
    .choose-label:before { content: ''; position: absolute; left: 0; width: 16px; height: 16px; display: inline-block; border-radius: 20px; background-color: #fff; z-index: 20; -webkit-transition: all 0.2s; transition: all 0.2s; }
    .choose-btn:checked + label.choose-label:before { left: 14px; }
    .choose-btn:checked + label.choose-label { background-color: #009cef; box-shadow: #009cef 0px 0px 0px 1px; }
    .choose-text { display: inline-block; vertical-align: middle; line-height: 20px; color: #888; font-size: 12px; margin-top: 4px; }
</style>
<script>
    $(".choose-btn").on("change", function(){

        $.ajax({
            url:'<%=basePath%>wechat/save.do',
            type:'get',
            async:false,
            cache:false,
            dataType:'json',
            data:{'checked':this.checked,'userId':$(this).attr('id')},
            success:function(json){


            }
        });
    });
</script>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>wechat/user-list.do" method="post">
        <input type="hidden" name="pageSize" value="${page.pageSize}"><!-- 页大小 -->
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}"><!-- 当前页 -->
        <input type="hidden" name="orderField" value="${param.orderField}"><!-- 排序字段 -->
        <input type="hidden" name="orderDirection" value="${param.orderDirection}"><!-- 排序方向 -->
        <label>姓名：</label><input type="text" value="${param.filter_LIKES_userName}" name="filter_LIKES_userName" class="form-control">&nbsp;
        <button type="submit" class="btn-default" data-icon="search">查询</button>
    </form>
</div>
<div class="bjui-pageContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <tr>
            <th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            <th width="5%" align="center">序号</th>
            <th width="15%" align="center">姓名</th>
            <th width="15%" align="center" >是否可以控制水电</th>
        </tr>
        <c:forEach items="${page.result}" var="view" varStatus="status">
            <tr data-id="${view.rowId}">
                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${view.rowId}"></td>
                <td align="center">${status.count }</td>
                <td align="center">${view.userName}</td>
                <td align="center">
                    <input type="checkbox" name="switch1" id="${view.userId}" class="choose-btn" data-toggle="通|断" ${view.dataStatus eq '1'?'checked':''}>
                    <label for="${view.userId}" class="choose-label"></label>
                    <span class="choose-text"></span>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="bjui-pageFooter">
    <div class="pages">
        <span>每页&nbsp;</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize">
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