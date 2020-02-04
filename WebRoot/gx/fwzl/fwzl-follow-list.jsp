<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageHeader">
<form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath %>fwzl/fwzl-follow-list.do" method="post">
	        <input type="hidden" name="pageSize" value="${model.pageSize}">
	        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
	        <input type="hidden" name="orderField" value="${param.orderField}">
	        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
	        <div class="bjui-searchBar" style="line-height:60px">
	            <label>设备代码：</label><input type="text" name="filter_LIKES_equipmentCode" value="${param.filter_LIKES_equipmentCode}">&nbsp;
	            <label>施工类别：</label>
	            <select name="filter_EQS_constructType" data-toggle="selectpicker" style="font-size:15px">
	                <option value="">全部</option>
					<option value="安装" ${param.filter_EQS_constructType eq '安装' ? 'selected="selected"':'' }>安装</option>
					<option value="改造" ${param.filter_EQS_constructType eq '改造' ? 'selected="selected"':'' }>改造</option>
					<option value="维修" ${param.filter_EQS_constructType eq '维修' ? 'selected="selected"':'' }>维修</option>
				</select>
				&nbsp;
	            <label>审核时间：</label>
	            <input type="text" name="filter_GED_finishTime" value="${param.filter_GED_finishTime}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly"> —
	            <input type="text" name="filter_LED_finishTime" value="${param.filter_LED_finishTime}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly">
	            &nbsp;	            
	            <button type="submit" class="btn-blue btn" data-icon="search">查询</button>&nbsp;
	            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
	        </div>
</form>
</div>
<div class="bjui-pageContent tableContent">
	<table class="table table-bordered table-hover table-striped  table-center" data-selected-multi="true" align="center">
		<thead>
		<tr>
			<th height="30" ><input type="checkbox" name="ids" data-toggle="icheck" value="{pid:'1', name:''}"></th>
			<th>序号</th>
			<th >标题</th>
			<th>申请人</th>
			<th>申请时间</th>
			<th >操作</th>
		</tr>
		</thead>
		<tbody>
		<tr data-id="1">
			<td><input type="checkbox" name="ids" data-toggle="icheck" value="{pid:'1', name:''}"></td>
			<td>1</td>
			<td style="text-align:left">XXX企业提出8849公寓的申请</td>
			<td>&nbsp;</td>
			<td>2018-08-28</td>
			<td><input name="button"  data-url="doc/form/mylookup02.html"  data-height="473" data-width="800" data-toggle="dialog" title="" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onClick="peopleutil()" ></td>
		</tr>
		<tr data-id="2">
			<td><input type="checkbox" name="ids" data-toggle="icheck" value="{pid:'1', name:''}"></td>
			<td>2</td>
			<td style="text-align:left">XXX企业提出8849公寓的申请</td>
			<td>&nbsp;</td>
			<td>2018-08-28</td>
			<td><input name="button" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onClick="peopleutil()" ></td>
		</tr>
		<tr data-id="3">
			<td><input type="checkbox" name="ids" data-toggle="icheck" value="{pid:'1', name:''}"></td>
			<td>3</td>
			<td style="text-align:left">XXX企业提出8849公寓的申请</td>
			<td>&nbsp;</td>
			<td>2018-08-28</td>
			<td><input name="button" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onClick="peopleutil()" ></td>
		</tr>
		<tr data-id="4">
			<td><input type="checkbox" name="ids" data-toggle="icheck" value="{pid:'1', name:''}"></td>
			<td>4</td>
			<td style="text-align:left">XXX企业提出8849公寓的申请</td>
			<td>&nbsp;</td>
			<td>2018-08-28</td>
			<td><input name="button" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onClick="peopleutil()" ></td>
		</tr>
		<tr data-id="5">
			<td><input type="checkbox" name="ids" data-toggle="icheck" value="{pid:'1', name:''}"></td>
			<td>5</td>
			<td style="text-align:left">XXX企业提出8849公寓的申请</td>
			<td>&nbsp;</td>
			<td>2018-08-28</td>
			<td><input name="button" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onClick="peopleutil()" ></td>
		</tr>
		<tr data-id="6">
			<td><input type="checkbox" name="ids" data-toggle="icheck" value="{pid:'1', name:''}"></td>
			<td>6</td>
			<td style="text-align:left">XXX企业提出8849公寓的申请</td>
			<td>&nbsp;</td>
			<td>2018-08-28</td>
			<td><input name="button" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onClick="peopleutil()" ></td>
		</tr>
		<tr data-id="7">
			<td><input type="checkbox" name="ids" data-toggle="icheck" value="{pid:'1', name:''}"></td>
			<td>7</td>
			<td style="text-align:left">XXX企业提出8849公寓的申请</td>
			<td>&nbsp;</td>
			<td>2018-08-28</td>
			<td><input name="button" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onClick="peopleutil()" ></td>
		</tr>
		<tr data-id="8">
			<td><input type="checkbox" name="ids" data-toggle="icheck" value="{pid:'1', name:''}"></td>
			<td>8</td>
			<td style="text-align:left">XXX企业提出8849公寓的申请</td>
			<td>&nbsp;</td>
			<td>2018-08-28</td>
			<td><input name="button" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onClick="peopleutil()" ></td>
		</tr>
		<tr data-id="9">
			<td><input type="checkbox" name="ids" data-toggle="icheck" value="{pid:'1', name:''}"></td>
			<td>9</td>
			<td style="text-align:left">XXX企业提出8849公寓的申请</td>
			<td>&nbsp;</td>
			<td>2018-08-28</td>
			<td><input name="button" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onClick="peopleutil()" ></td>
		</tr>
		<tr data-id="10">
			<td><input type="checkbox" name="ids" data-toggle="icheck" value="{pid:'1', name:''}"></td>
			<td>10</td>
			<td style="text-align:left">XXX企业提出8849公寓的申请</td>
			<td>&nbsp;</td>
			<td>2018-08-28</td>
			<td><input name="button" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onClick="peopleutil()" ></td>
		</tr>

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
function printDJB(rowId, obj){
	$(obj).attr("class","btn btn-orange");
	window.open("<%=path %>/sp-tzsb-sg/print-djb.do?rowId="+rowId);
}
</script>