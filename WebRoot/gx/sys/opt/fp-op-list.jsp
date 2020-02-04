<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch"
		action="<%=basePath %>fp-operation/fp-op-list.do" method="post">
		<input type="hidden" name="pageSize" value="${model.pageSize}">
		<input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
		<input type="hidden" name="orderField" value="${param.orderField}">
		<input type="hidden" name="orderDirection"
			value="${param.orderDirection}">
		<div class="bjui-searchBar" style="line-height:60px">
			<label>主要记录：</label><input type="text"
				value="${param.filter_LIKES_MRecord }"
				name="filter_LIKES_MRecord" class="form-control" size="15">	
			&nbsp;&nbsp; <label>操作人姓名:</label><input type="text"
				value="${param.filter_LIKES_MUsername }" name="filter_LIKES_MUsername"
				class="form-control" size="10">&nbsp;&nbsp; <label>操作日期：</label><input
				type="text" name="filter_GED_operationTime"
				value="${param.filter_GED_operationTime}" data-toggle="datepicker"
				data-rule="date" size="15">&nbsp;-&nbsp;<input type="text"
				name="filter_LED_operationTime" id="j_custom_issuedate"
				data-toggle="datepicker" data-rule="date" size="15"
				value="${param.filter_LED_operationTime}"> &nbsp;&nbsp;
			<button type="submit" class="btn-blue btn" data-icon="search">查询</button>
			&nbsp; <a class="btn btn-orange" href="javascript:;"
				data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>&nbsp;
                <button type="button" class="btn-green" data-url="<%=basePath %>fp-operation/op-edit.do"  data-toggle="dialog" data-target="sysorg-input" data-id="role-input-dialog"  data-icon="plus" data-width="800" data-height="600">添加</button>
                <button type="button" class="btn-blue" data-url="<%=basePath %>fp-operation/op-remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids" >删除选中</button>		</div>
	</form>
</div>
<div class="bjui-pageContent tableContent">
	<table class="table table-bordered table-hover table-striped table-top"
		data-selected-multi="true">
		<thead>
			<tr>
			<th width="3%" align="center"><input type="checkbox" class="checkboxCtrl"
                    data-group="ids" data-toggle="icheck"></th>
				<th width="3%" align="center">序号</th>
				<th width="9%" align="center">主要记录</th>
				<th width="9%" align="center">模块名称</th>
				<th width="6%" align="center">操作人名</th>			
				<th width="6%" align="center">所属组织名</th>
				<th width="6%" align="center">操作对象类</th>
				<th width="6%" align="center">操作对象方法</th>
				<th width="6%" align="center">操作时间</th>
				<th width="6%" align="center">状态</th>
				<th width="6%" align="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="op" items="${page.result }" varStatus="status">
				<tr data-id="${op.rowId }">
				<td align="center"><input type="checkbox" name="ids" data-toggle="icheck"
                        value="${op.rowId}"></td>
					<td align="center">${status.index +1}</td>
					<td align="center">${op.MRecord}</td>
					<td align="center">${op.MModel}</td>
					<td align="center">${op.MUsername }</td>
					<td align="center">${op.MOrgName }</td>
					<td align="center">${op.MClass }</td>
					<td align="center">${op.MMethord }</td>
					<td align="center"><fmt:formatDate value="${op.operationTime}"
                            pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td align="center">${op.MStatus }</td>				
					<td align="center">
					<button data-url="<%=basePath %>fp-operation/op-edit.do?rowId=${op.rowId}"  data-toggle="dialog" data-id="column-update" data-width="800" data-height="600"  data-title="编辑" class="btn-blue">编辑</button>
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
<script type="text/javascript">
$(function(){
	$("#docFromOrgName-select",$.CurrentNavtab).on("change",function(){
		$("#docFromOrgName-input",$.CurrentNavtab).val($(this).find("option:selected").text());
	});
	$(".doc-print",$.CurrentNavtab).click(function(){
		var _url = $(this).data("url");
		 window.open(_url,'_blank');  
	});
});
</script>
