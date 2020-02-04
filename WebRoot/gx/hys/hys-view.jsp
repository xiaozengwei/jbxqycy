<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<head>
    <base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>gx/BJUI/themes/css/iF.step.css" />
<script type="text/javascript">
$(function() {
    <c:forEach items="${list }" var="act">
    $("#${act.actId}").val("${act.actInstRemark}");
    </c:forEach>
    var instanceState ="${instanceState }";
    var step1 = $("#step1");
    var step2 = $("#step2");
    var step3 = $("#step3");
    if(instanceState == "申请"){
        step1.attr("class","step-start step-active");
        step2.attr("class","");
        step3.attr("class","step-end");
    }else if(instanceState == "会务服务部审核"){
        step1.attr("class","step-start step-done");
        step2.attr("class","step-active");
        step3.attr("class","step-end");
    }else{//结束
        step1.attr("class","step-start step-done");
        step2.attr("class","step-done");
        step3.attr("class","step-end step-active");
    }

    //打印
    $("#btn-print").on("click",function(){
        $(".view-print").printArea({
            mode : "popup",
            popClose : false
        });
    });
})
</script>
</head>
  
<body>
<div class="bjui-pageContent">
	<div class="step">
		<div style="width:100%; height:80px; margin-top:20px">
			<ol class="ui-step ui-step-blue ui-step-3" style="height:150px">
				<li class="step-start step-active" id="step1">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<span class="ui-step-cont-number">1</span>
						<span class="ui-step-cont-text">申请</span>
					</div>
				</li>
				<li class="" id="step2">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<span class="ui-step-cont-number">2</span>
						<span class="ui-step-cont-text">会务服务部审核</span>
					</div>
				</li>
				<li class="step-end" id="step3">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<span class="ui-step-cont-number">3</span>
						<span class="ui-step-cont-text">结束</span>
					</div>
				</li>
			</ol>

		</div>
	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" >
		<tr>
			<td  class="bdTableb"><TABLE id=tet cellSpacing=0 cellPadding=0 width="75%" align=center border=0  style="margin-top:10px;margin-bottom:10px">
				<TBODY>
				<TR>
					<TD width=19 valign="bottom"  class="fileCorner1"></TD>
					<TD class="fileline01">&nbsp;</TD>
					<TD  valign="top" class="fileCorner2"></TD>
				</TR>
				<TR>
					<TD class="fileline02">&nbsp;</TD>
					<td><div class="view-print"><table width="600" align="center"  cellpadding="0" cellspacing="0" class="swborder">
						<tbody>
						<tr>
							<td height="100px" colspan="4" align="center"  class="swtitle" style="font-family:宋体, sans-serif"> 会议室租赁申请表 </td>
						</tr>
						<tr>
							<td height="40" class="Rborder Bborder Tborder Lborder" width="20%" align="center"><label class="control-label x100">姓名</label></td>
							<td  class="Bborder Rborder Lborder Tborder"  width="30%"><input name="applicantName" value="${meetingRoomLeaseApply.applicantName}" type="text" style="width: 100%;" data-rule="required" readonly></td>
							<td   class="Bborder Tborder Rborder Tborder"  width="20%" align="center"><label class="control-label x100">手机号</label></td>
							<td  class="Bborder Rborder Lborder Tborder" width="30%"><input name="applicantPhone" value="${meetingRoomLeaseApply.applicantPhone}" type="text" style="width: 100%;" data-rule="required;mobile" readonly></td>
						</tr>
						<tr>
							<td height="60"   valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100 ">身份证</label></td>
							<td   class="Bborder Rborder Lborder" align="left" valign="middle"><input name="applicantIdCard" value="${meetingRoomLeaseApply.applicantIdCard}" type="text" style="width: 100%;" data-rule="required;ID_card" readonly></td>
							<td height="60"   valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100 ">公司名称</label></td>
							<td   class="Bborder Rborder Lborder" align="left" valign="middle"><input name="companyName" value="${meetingRoomLeaseApply.companyName}" type="text" style="width: 100%;" data-rule="required" readonly></td>
						</tr>
						<tr>
							<td height="60"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">会议开始时间</label></td>
							<td  class="Bborder Rborder Lborder" align="left"><input name="startTime" value="<fmt:formatDate value="${meetingRoomLeaseApply.startTime}" pattern="yyyy-MM-dd HH:mm" />" type="text" data-pattern="yyyy-MM-dd HH:mm" style="width: 100%;"  data-rule="required" readonly></td>
							<td height="60"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">会议结束时间</label></td>
							<td  class="Bborder Rborder Lborder" align="left"><input name="endTime" value="<fmt:formatDate value="${meetingRoomLeaseApply.endTime}" pattern="yyyy-MM-dd HH:mm" />" type="text" data-pattern="yyyy-MM-dd HH:mm" style="width: 100%;" data-rule="required" readonly></td>
						</tr>
						<tr>
							<td height="60"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">选择会议室</label></td>
							<td  class="Bborder Rborder Lborder" align="left" colspan="3">
								<select name="selectedRoom" data-toggle="selectpicker" disabled>
									<option value="企业家俱乐部" ${meetingRoomLeaseApply.selectedRoom == '企业家俱乐部'?'selected="selected"':''}>企业家俱乐部</option>
									<option value="宣讲厅" ${meetingRoomLeaseApply.selectedRoom == '宣讲厅'?'selected="selected"':''}>宣讲厅</option>
									<option value="大报告厅" ${meetingRoomLeaseApply.selectedRoom == '大报告厅'?'selected="selected"':''}>大报告厅</option>
									<option value="会议室1" ${meetingRoomLeaseApply.selectedRoom == '会议室1'?'selected="selected"':''}>会议室1</option>
									<option value="会议室2" ${meetingRoomLeaseApply.selectedRoom == '会议室2'?'selected="selected"':''}>会议室2</option>
									<option value="会议室3" ${meetingRoomLeaseApply.selectedRoom == '会议室3'?'selected="selected"':''}>会议室3</option>
									<option value="会议室4" ${meetingRoomLeaseApply.selectedRoom == '会议室4'?'selected="selected"':''}>会议室4</option>
									<option value="路演厅" ${meetingRoomLeaseApply.selectedRoom == '路演厅'?'selected="selected"':''}>路演厅</option>
								</select>
							</td>
						</tr>
						<tr>
							<td height="180"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">会务服务部意见</label></td>
							<td colspan="3"  class="Bborder Rborder Lborder"><textarea id="hyszl_2" name="opinion" rows="8" style="width: 100%;" disabled="disabled"></textarea></td>
						</tr>
						</tr>
						</tbody>
					</table></div></td>
					<TD class="fileShadowR">&nbsp;</TD>
				</TR>
				<TR>
					<TD  class="fileCorner4">&nbsp;</TD>
					<TD class="fileShadowB">&nbsp;</TD>
					<TD class="fileCorner3" width="19px">&nbsp;</TD>
				</TR>
				</TBODY>
			</TABLE></td>
		</tr>
	</table>
		<div style="width:100%; margin-top:10px" >
			<fieldset>
				<legend>附件</legend>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td><table class="table table-bordered table-hover table-striped " data-selected-multi="true" style="margin-top:5px">
							<thead>
							<tr>
								<th align="center" height="30px" width="10%">序号</th>
								<th align="center">文件名称</th>
								<th align="center" width="10%">上传时间</th>
								<th align="center" width="10%">上传人</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${attachList}" var="attach" varStatus="status">
								<tr>
									<td align="center">${status.count}</td>
									<td align="center">${attach.attachName}</td>
									<td align="center"><fmt:formatDate value="${attach.uploadTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td align="center">${attach.uploadUserName}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table></td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div style="width:100%;">
			<fieldset>
				<legend>处理过程</legend>
				<table class="table table-bordered table-hover table-striped " data-selected-multi="true">
					<thead>
					<tr>
						<th align="center" height="30px" width="20%">办理阶段名称</th>
						<th align="center" width="25%">办理过程</th>
						<th align="center" width="15%">办理人</th>
						<th align="center" width="15%">办理时间</th>
						<th align="center">处理意见</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${opinionList}" var="opinion" varStatus="status">
						<tr>
							<th align="center">${opinion.handleStage}</th>
							<th align="center">${opinion.handleProcess}</th>
							<th align="center">${opinion.handleUser}</th>
							<th align="center"><fmt:formatDate value="${opinion.handleTime}" pattern="yyyy-MM-dd HH:mm:ss" /></th>
							<th align="center">${opinion.handleOpinion}</th>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</div>
	<div style="width:100%;">
		<fieldset>
			<legend>用户操作</legend>
			<div style="width:100%; text-align:center">
				<button id="btn-print" type="button" class="btn-default" data-icon="print">打印</button>
				<button type="button" class="btn-close" data-icon="close">取消</button>
			</div>
		</fieldset>
	</div>
</div>
</body>
