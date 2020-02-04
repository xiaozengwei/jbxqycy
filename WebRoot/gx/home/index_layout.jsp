<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script>
$(function(){
	//点击后未读状态取消
	$("#index_layout",$.CurrentNavtab).on("click",".a-href-read-status",function(){
		var read_img = $(this).next("img");
		if(read_img){
			read_img.remove();
		}
	});
});
</script>
<style>
	.rowdiv{  width:25%; float:left; height:125px; line-height:165px; text-align:center; }
	.coldiv{ border-radius:5px; width:100%; height:125px; line-height:125px; font-size:24px; color:#fff;}
	.bgred{ background:#ff5e7d}
	.bgblue{ background:#5eaaff}
	.bggrey{ background:#b9b9b8}
	.bgyellow{ background:#f8c44a}
	.bggreen{ background:#0fda4d}
</style>
<div class="bjui-pageContent" style="background:#FFF; " id="index_layout">
	<div style="padding: 0 15px;">
		<div class="row" style=" margin-top:10px;">
			<div class="rowdiv">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td style="padding:5px;"><div class="coldiv bgblue"><img src="<%=basePath %>gx/images/img_db.png" width="40"  hspace="5" />待办事宜  （${totalCount == null ? 0:totalCount }）</div></td>
					</tr>
				</table>
			</div>
			<div class="rowdiv">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td style="padding:5px;"><div class="coldiv bgyellow"><img src="<%=basePath %>gx/images/fcj/img_zcyx.png" width="40"  hspace="5"/>人才公寓管理  （${gyCount == null ? 0:gyCount}）</div></td>
					</tr>
				</table>
			</div>
			<div class="rowdiv">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td style="padding:5px;"><div class="coldiv bgred"><img src="<%=basePath %>gx/images/img_hys.png" width="40"  hspace="5" />会议室管理  （${hysCount == null ? 0:hysCount}）</div></td>
					</tr>
				</table>
			</div>
	<div class="rowdiv">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td style="padding:5px;"><div class="coldiv bggreen"><img src="<%=basePath %>gx/images/fcj/img_card.png" width="40" hspace="5" />一卡通管理  （${yktCount == null ? 0:yktCount}）</div></td>
			</tr>
	</table>
</div>
<div style="clear:both"></div>

<div  style="padding:5px;">
	<div  role="alert" style="margin:10px 0px 0px 0px; ">
		<div class="bt02"><i class="fa fa-file-text-o fa-lg imgp"></i>待办事宜
			<div style="float:right; line-height:28px; margin-right:10px">
				<a href="<%=basePath %>home/db-list.do" data-toggle="navtab" data-id="db_1" data-title="待办事宜">更多>></a>
			</div>
		</div>
		<table class="table table-bordered table-hover table-top" data-selected-multi="true" cellpadding="0" cellspacing="0" border="1">
			<thead>
			<tr>
				<th align="center" height="30px">事项名称</th>
				<th align="center">企业名称</th>
				<th align="center">申请人</th>
				<th align="center">申请时间</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="vIndexAgency" items="${list }" varStatus="status">
				<tr data-id="${vIndexAgency.rowId }">
					<td align="center">${vIndexAgency.processName}</td>
					<td align="center">
						<c:choose>
							<c:when test="${vIndexAgency.processId == 'rcgyzl'}"><a title="人才公寓租赁" href="<%=basePath%>fwzl/fwzl-handle-page.do?rowId=${vIndexAgency.rowId}" data-toggle="navtab" data-id="${vIndexAgency.rowId}">${vIndexAgency.companyName}</a></c:when>
							<c:when test="${vIndexAgency.processId == 'hyszl'}"><a title="会议室租赁" href="<%=basePath%>hys/hys-handle-page.do?rowId=${vIndexAgency.rowId}"  data-toggle="navtab" data-id="${vIndexAgency.rowId}">${vIndexAgency.companyName}</a></c:when>
							<c:otherwise><a title="一卡通申请" href="<%=basePath%>ykt/ykt-handle-page.do?rowId=${vIndexAgency.rowId}"  data-toggle="navtab" data-id="${vIndexAgency.rowId}">${vIndexAgency.companyName}</a></c:otherwise>
						</c:choose>
					</td>
					<td align="center">${vIndexAgency.applicantName}</td>
					<td align="center"><fmt:formatDate value="${vIndexAgency.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>



</div>
</div>
</div>

