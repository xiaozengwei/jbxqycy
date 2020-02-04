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
    var step4 = $("#step4");
    var step5 = $("#step5");
    if(instanceState == "申请"){
        step1.attr("class","step-start step-active");
        step2.attr("class","");
        step3.attr("class","");
        step4.attr("class","");
        step5.attr("class","step-end");
    }else if(instanceState == "企业服务部审核"){
        step1.attr("class","step-start step-done");
        step2.attr("class","step-active");
        step3.attr("class","");
        step4.attr("class","");
        step5.attr("class","step-end");
    }else if(instanceState == "投资促进与人才工作部审核"){
        step1.attr("class","step-start step-done");
        step2.attr("class","step-done");
        step3.attr("class","step-active");
        step4.attr("class","");
        step5.attr("class","step-end");
    }else if(instanceState == "力合创展物业管理部审核"){
        step1.attr("class","step-start step-done");
        step2.attr("class","step-done");
        step3.attr("class","step-done");
        step4.attr("class","step-active");
        step5.attr("class","step-end");
    }else{//结束
        step1.attr("class","step-start step-done");
        step2.attr("class","step-done");
        step3.attr("class","step-done");
        step4.attr("class","step-done");
        step5.attr("class","step-end step-active");
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
<div class="bjui-pageContent" >
	<div class="step">
		<div style="width:100%; height:80px; margin-top:20px">
			<ol class="ui-step ui-step-blue ui-step-5" style="height:150px">
				<li class="step-start" id="step1">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont"> <span class="ui-step-cont-number">1</span> <span class="ui-step-cont-text">申请</span> </div>
				</li>
				<li class="" id="step2">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont"> <span class="ui-step-cont-number">2</span> <span class="ui-step-cont-text">企业服务部审核</span> </div>
				</li>
				<li class="" id="step3">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont"> <span class="ui-step-cont-number">3</span> <span class="ui-step-cont-text">投资促进与人才工作部审核</span> </div>
				</li>
				<li class="" id="step4">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont"> <span class="ui-step-cont-number">4</span> <span class="ui-step-cont-text">力合创展物业管理部审核</span> </div>
				</li>
				<li class="step-end" id="step5">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont"> <span class="ui-step-cont-number">5</span> <span class="ui-step-cont-text">审核完成</span> </div>
				</li>
			</ol>
		</div>
	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" >
		<tr>
			<td  class="bdTableb"><TABLE id=tet cellSpacing=0 cellPadding=0 width="75%"
										 align=center border=0  style="margin-top:10px;margin-bottom:10px">
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
							<td height="100px" colspan="4" align="center"  class="swtitle" style="font-family:宋体, sans-serif"> 人才公寓租赁申请表 </td>
						</tr>
						<tr>
							<td height="40" class="Rborder Bborder Tborder Lborder" width="20%" align="center"><label class="control-label x100">申请企业名称</label></td>
							<td  class="Bborder Rborder Lborder Tborder"  width="30%"><input name="enterpriseName" value="${rcgyLeseApply.enterpriseName}" type="text" style="width: 100%;" readonly></td>
							<td height="40" class="Bborder Tborder Rborder Tborder"  width="20%" align="center"><label class="control-label x100">申请日期</label></td>
							<td  class="Bborder Rborder Lborder Tborder" width="30%"><input name="applyDate" value="${rcgyLeseApply.applyDate}" type="text" readonly="readonly" data-toggle="datepicker" size="12"></td>
						</tr>
						<tr>
							<td height="60"   valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100 ">企业经办人</label></td>
							<td   class="Bborder Rborder Lborder" align="left" valign="middle"><input name="enterpriseManager" value="${rcgyLeseApply.enterpriseManager}" type="text" style="width: 100%;" readonly></td>
							<td height="60"   valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100 ">联系电话</label></td>
							<td   class="Bborder Rborder Lborder" align="left" valign="middle"><input name="contactNumber" value="${rcgyLeseApply.contactNumber}" type="text" style="width: 100%;" readonly></td>
						</tr>
						<tr>
							<td height="60"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">需求公寓类型</label></td>
							<td  class="Bborder Rborder Lborder" align="left" valign="middle">
								<select name="apartmentType" data-toggle="selectpicker" disabled>
									<option value="标准间" ${rcgyLeseApply.apartmentType == '标准间'?'selected="selected"':''}>标准间</option>
									<option value="两室一厅" ${rcgyLeseApply.apartmentType == '两室一厅'?'selected="selected"':''}>两室一厅</option>
								</select>
							</td>
							<td height="60"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">需求公寓数量</label></td>
							<td  class="Bborder Rborder Lborder" align="left" valign="middle"><input name="apartmentNumber" value="${rcgyLeseApply.apartmentNumber}" type="text" style="width: 100%;" data-rule="digits" readonly></td>
						</tr>
						<tr>
							<td height="60"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">拟入住时间</label></td>
							<td  class="Bborder Rborder Lborder" align="left" ><input name="checkInTime" value="${rcgyLeseApply.checkInTime}" type="text" readonly="readonly" data-toggle="datepicker" size="12"></td>
							<td height="60"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">租赁期限</label></td>
							<td  class="Bborder Rborder Lborder" align="left" ><input name="leaseTerm" value="${rcgyLeseApply.leaseTerm}" type="text" style="width: 100%;" readonly></td>
						</tr>
						<tr>
							<td height="60"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">是否符合投资协议约定</label></td>
							<td colspan="3"  class="Bborder Rborder Lborder" align="center" >
								<input name="isAccordTzxyyd" type="radio"  data-toggle="icheck" value="是" data-label="是" ${rcgyLeseApply.isAccordTzxyyd == '是'?'checked="checked"':''} disabled>
								<input name="isAccordTzxyyd" type="radio"  data-toggle="icheck" value="否" data-label="否" ${rcgyLeseApply.isAccordTzxyyd == '否'?'checked="checked"':''} disabled>
							</td>
						</tr>
						<tr>
							<td height="180"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">申请人单位意见</label></td>
							<td colspan="3"  class="Bborder Rborder Lborder"><textarea id="rcgyzl_2" name="opinion" rows="8" style="width: 100%;" disabled="disabled"></textarea></td>
						</tr>
						<tr>
							<td height="180"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">企业服务部意见</label></td>
							<td colspan="3"  class="Bborder Rborder Lborder" valign="top"><textarea id="rcgyzl_3" name="opinion" rows="8" style="width: 100%;" disabled="disabled"></textarea></td>
						</tr>
						<tr>
							<td height="180"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">投资促进与人才工作部意见</label></td>
							<td colspan="3"  class="Bborder Rborder Lborder" valign="top"><textarea id="rcgyzl_4" name="opinion" rows="8" style="width: 100%;" disabled="disabled"></textarea></td>
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
