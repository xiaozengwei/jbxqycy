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
    var actId = "${currentAct.actId }";
    var actName ="${currentAct.actName }";
    $("#"+actId).removeAttr("disabled");
    var step1 = $("#step1");
    var step2 = $("#step2");
    var step3 = $("#step3");
    if(actName == "申请"){
        step1.attr("class","step-start step-active");
        step2.attr("class","");
        step3.attr("class","step-end");
    }else if(actName == "会务服务部审核"){
        step1.attr("class","step-start step-done");
        step2.attr("class","step-active");
        step3.attr("class","step-end");
    }else{//结束
        step1.attr("class","step-start step-done");
        step2.attr("class","step-done");
        step3.attr("class","step-end step-active");
    }

    var fileNo = ${fn:length(attachList) } + 1;
    var uploader = new plupload.Uploader({
        runtimes : 'html5,flash,silverlight,html4',
        browse_button : 'pickfiles', // you can pass in id...
        //container: document.getElementById('container'), // ... or DOM Element itself
        url : '<%=path%>/file/fileUpload.do',
        flash_swf_url : '<%=path%>/gx/js/Moxie.swf',
        silverlight_xap_url : '<%=path%>/gx/js/Moxie.xap',
        multi_selection:false,
        filters : {
            max_file_size : '50mb'
        },
        init : {
            PostInit: function() {
                document.getElementById('uploadfiles').onclick = function() {
                    uploader.start();
                    return false;
                };
            },
            FilesAdded:function(up,files){
                plupload.each(files, function(file) {
                    document.getElementById('upload-file-list').value = file.name ;
                });
            },
            FileUploaded:function(up,file,response){
                var json = response.response;
                upload_callback(JSON.parse(json));
            },
            Error: function(up, err) {
                alert("error", err.message);
            }
        }
    });

    uploader.init();

    /**
     * 上传文件回调函数
     */
    function upload_callback(json) {
        var msg_type = 'ok';
        var msg_context = "上传成功！";
        if (json.statusCode == '200') {//上传成功状态
            var attachment = json.attachment;
            var attachementId = attachment.rowId;
            // 字符串添加当前附件ID
            var formAttachment = $("#form_attachmentId");
            var _attachementId = formAttachment.val() || "";
            _attachementId = _attachementId.length > 0 ? _attachementId + ",": "";
            formAttachment.val(_attachementId + attachementId);
            var d = new Date();
            d.setTime(attachment.uploadTime);
            var uploadTime = d.format("yyyy-MM-dd HH:mm:ss");
            // 填充数据
            var upload_file_html = "<tr><td align='center'>"+fileNo+"</td><td align='center' class='blue'><a href='<%=path %>/file/fileDownload.do?fileId="+attachementId+"'>"
                + attachment.attachName
                + "</a></td><td align='center'>"
                + attachment.uploadUserName
                + "</td><td align='center'>"
                + uploadTime
                + "</td><td align='center'><input type='button' class='btn btn-orange btn_file_delete' data='"+attachementId+"' value='删除' /></td></tr>";
            var attachmentTab = $("#attachmentTab");
            attachmentTab.append(upload_file_html);
            fileNo++;
        } else {//如果状态码为300或其他，均为错误的状态
            msg_type = 'error';
            msg_context = "上传失败！";
        }
        attachmentTab.alertmsg(msg_type, msg_context);
        $("#upload-file-list").val("");
    }

    //删除附件
    $("#attachmentTab").on("click",".btn_file_delete",function(){
        var tr_this =  $(this);
        var rowId = tr_this.attr("data");
        var form_attachmentId = $("#form_attachmentId");
        var _attachementId = form_attachmentId.val() || "";
        var msg_type = 'ok';
        var msg_context = "删除成功！";
        $.ajax({
            url : '<%=path %>/file/fileDelete.do',
            type : 'post',
            data : {'fileId':rowId},
            success : function(json) {
                if (json.statusCode == '200') {
                    //将当前附件id从字符串去除
                    var strs = _attachementId.split(',');
                    var index_str = getIndexOfStrArr(strs,rowId);
                    var lastAttachmentIds = removeAndJoinString(strs,index_str);
                    form_attachmentId.val(lastAttachmentIds);
                    //删除此行
                    tr_this.parents("tr:first").remove();

                    fileNo--;
                }else{
                    msg_type = 'error';
                    msg_context = "删除失败！";
                }
            }
        });
        $("#attachmentTab").alertmsg(msg_type, msg_context);
    });
})
</script>
</head>
  
<body>
<div class="bjui-pageContent">
	<form action="<%=basePath %>/hys/hys-handle.do" method="post" id="formId" data-toggle="validate">
		<input type="hidden" name="actInstRowId" value="${currentAct.rowId }">
		<input type="hidden" id="rowId" name="rowId" value="${meetingRoomLeaseApply.rowId }">
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
					<td><table width="600" align="center"  cellpadding="0" cellspacing="0" class="swborder">
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
					</table></td>
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
						<td width="420px">
							<input id="upload-file-list" type="text" class="pinput" style="width:260px" readonly="readonly"/>
							<button id="pickfiles" type="button" class="btn-blue" data-icon="hand-o-up">浏览</button>
							<button id="uploadfiles" type="button" class="btn-green" data-icon="upload">上传</button>
							<input id="maxUploadIndex" value="0" type="hidden"/>
						</td>
					</tr>
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
				<legend>处理过程</legend>
				<table width="100%" border="0" align="center"
					   cellpadding="0" cellspacing="0" class="table1_border">
					<tr>
						<td align="left" class="padding5"><form name="procForm" action="runProcess.do" method="POST">
							<input name="method" type="hidden" value="runWorkItem" />
							<table width="100%" cellpadding="0" cellspacing="0" border="0" id="commoncommit1">
								<tr>
									<td><table width="100%" border="0" cellspacing="0" cellpadding="0" class="line28">
										<c:if test="${backAct != null}">
											<tr>
												<td valign="top" style="padding-left:22px" width="100px"><div style="line-height:26px; margin-top:3px" >选择下一步：</div></td>
												<td>
													<input type="radio" data-toggle="icheck" name="selectAct" value="${backAct.actName}" data-label="${backAct.actName}"/>
												</td>
												<td>
											<span id="radioselectpeople1"><span style="display:block;float:left; padding:0px auto; height:24px; line-height:24px; width:100px;text-align:right">下一步参与者：</span><span style="display:block;float:left">
												<input type="text" id="mumselect1" value="${backAct.handleUser}" name="showname1" style="width:150px;" readonly>
											</span></span>
												</td>
											</tr>
										</c:if>
										<tr>
											<td valign="top" style="padding-left:22px" width="100px"><div style="line-height:26px; margin-top:3px" >选择下一步：</div></td>
											<td>
												<input type="radio" data-toggle="icheck" name="selectAct" value="${nextAct.actName}" data-label="${nextAct.actName}" checked/>
											</td>
											<td>
											<span id="radioselectpeople2"><span style="display:block;float:left; padding:0px auto; height:24px; line-height:24px; width:100px;text-align:right">下一步参与者：</span><span style="display:block;float:left">
												<input type="text" id="mumselect2" value="${nextAct.handleUser}" name="showname1" style="width:150px;" readonly>
											</span></span>
											</td>
										</tr>
										<c:if test="${endAct != null}">
											<tr>
												<td valign="top" style="padding-left:22px" width="100px"><div style="line-height:26px; margin-top:3px" >选择下一步：</div></td>
												<td>
													<input type="radio" data-toggle="icheck" name="selectAct" value="${endAct.actName}" data-label="${endAct.actName}" checked/>
												</td>
												<td>
											<span id="radioselectpeople3"><span style="display:block;float:left; padding:0px auto; height:24px; line-height:24px; width:100px;text-align:right">下一步参与者：</span><span style="display:block;float:left">
												<input type="text" id="mumselect3" value="${endAct.handleUser}" name="showname1" style="width:150px;" readonly>
											</span></span>
												</td>
											</tr>
										</c:if>
									</table></td>
								</tr>
							</table>
						</form></td>
					</tr>
				</table>
			</fieldset>
		</div>
	<div style="width:100%;">
		<fieldset>
			<legend>用户操作</legend>
			<div style="width:100%; text-align:center">
				<button type="submit" class="btn-default" data-icon="save">提交</button>
				<button type="button" class="btn-close" data-icon="close">取消</button>
			</div>
		</fieldset>
	</div>
	</form>
</div>
</body>
