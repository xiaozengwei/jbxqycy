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
    //判断是个人申请还是企业申请
    var state = "${state}";
    if(state == 'personal'){
        $("#cardNumber").val(1);
        $("#cardNumber").attr("readonly","readonly");
	}

    var fileNo = 1;
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
	<form action="<%=basePath %>/ykt/ykt-save.do" method="post" id="formId" data-toggle="validate">
		<input type="hidden" id="form_attachmentId" name="attachmentId" />
	<div class="step">
		<div style="width:100%; height:80px; margin-top:20px">
			<ol class="ui-step ui-step-blue ui-step-4" style="height:150px">
				<li class="step-start step-active">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<span class="ui-step-cont-number">1</span>
						<span class="ui-step-cont-text">申请</span>
					</div>
				</li>
				<li class="">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<span class="ui-step-cont-number">2</span>
						<span class="ui-step-cont-text">正在审核</span>
					</div>
				</li>
				<li class="">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<span class="ui-step-cont-number">3</span>
						<span class="ui-step-cont-text">卡片制作中</span>
					</div>
				</li>
				<li class="step-end">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<span class="ui-step-cont-number">4</span>
						<span class="ui-step-cont-text">制卡完成</span>
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
							<td height="100px" colspan="4" align="center"  class="swtitle" style="font-family:宋体, sans-serif">一卡通自助申请表 </td>
						</tr>
						<tr>
							<td height="40" class="Rborder Bborder Tborder Lborder" width="20%" align="center"><label class="control-label x100">姓名</label></td>
							<td  class="Bborder Rborder Lborder Tborder"  width="30%"><input name="applicantName" type="text" style="width: 100%;"  data-rule="required"></td>
							<td   class="Bborder Tborder Rborder Tborder"  width="20%" align="center"><label class="control-label x100">手机号</label></td>
							<td  class="Bborder Rborder Lborder Tborder" width="30%"><input name="applicantPhone" type="text" style="width: 100%;" data-rule="required;mobile"></td>
						</tr>
						<tr>
							<td height="60"   valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100 ">身份证</label></td>
							<td   class="Bborder Rborder Lborder" align="left" valign="middle"><input name="applicantIdCard" type="text" style="width: 100%;" data-rule="required;ID_card"></td>
							<td height="60"   valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100 ">办卡数目</label></td>
							<td   class="Bborder Rborder Lborder" align="left" valign="middle"><input id="cardNumber" name="cardNumber" type="text" style="width: 100%;" data-rule="required;digits"></td>
						</tr>
						<tr>
							<td height="60"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">公司名称</label></td>
							<td colspan="3"  class="Bborder Rborder Lborder" align="middle"><input name="companyName" type="text" style="width: 100%;" data-rule="required"></td>
						</tr>
						<tr>
							<td height="180"  valign="middle" class="Bborder Rborder Lborder" align="center"><label class="control-label x100">公共事业服务部意见</label></td>
							<td colspan="3"  class="Bborder Rborder Lborder" valign="middle"><textarea rows="8" style="width: 100%;" disabled></textarea></td>
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
					<td><table id="attachmentTab" class="table table-bordered table-hover table-striped " data-selected-multi="true" style="margin-top:5px">
						<tr>
							<th align="center" height="30px" width="10%">序号</th>
							<th align="center">文件名称</th>
							<th align="center" width="10%">上传人</th>
							<th align="center" width="20%">上传时间</th>
							<th align="center" width="10%">操作</th>
						</tr>
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
					<th  align="center" height="30px" width="20%">办理阶段名称</th>
					<th align="center" width="25%">办理过程</th>
					<th align="center" width="15%">办理人</th>
					<th align="center" width="15%">办理时间</th>
					<th align="center">处理意见</th>
				</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</fieldset>
	</div>
	<div style="width:100%;">
		<fieldset>
			<legend>处理过程</legend>
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="table1_border">
				<tr>
					<td align="left" class="padding5">
						<table width="100%" cellpadding="0" cellspacing="0" border="0" id="commoncommit1">
							<tr>
								<td><table width="100%" border="0" cellspacing="0" cellpadding="0" class="line28">
									<tr>
										<td valign="top" style="padding-left:22px" width="100px"><div style="line-height:26px; margin-top:3px" >选择下一步：</div></td>
										<td>
											<input type="radio" data-toggle="icheck" value="${procAct.actName}" name="nextStep" data-label="${procAct.actName}" checked/>
										</td>
										<td>
											<span id="radioselectpeople1"> <span style="display:block;float:left; padding:0px auto; height:24px; line-height:24px; width:100px;text-align:right">下一步参与者：</span><span style="display:block;float:left">
												<input type="text" id="mumselect1" value="${procAct.handleUserName}" name="showname1" style="width:150px;" readonly>
											</span></span>
										</td>
									</tr>
								</table></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</fieldset>
	</div>
	<div style="width:100%;">
		<fieldset>
			<legend>用户操作</legend>
			<div style="width:100%; text-align:center">
				<button type="submit" class="btn-default" data-icon="save">保存</button>
				<button type="button" class="btn-close" data-icon="close">取消</button>
			</div>
		</fieldset>
	</div>
	</form>
</div>
</body>
