<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>南京江北新区产业技术研创园</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.">

    <link rel="stylesheet" href="<%=basePath %>gx/jquery-weui/lib/weui.min.css">
    <link rel="stylesheet" href="<%=basePath %>gx/jquery-weui/css/jquery-weui.css">
    <link rel="stylesheet" href="<%=basePath %>gx/mobile/css/style.css">
    <script src="<%=basePath %>gx/jquery-weui/lib/jquery-2.1.4.js"></script>
    <script src="<%=basePath %>gx/jquery-weui/lib/fastclick.js"></script>
    <script src="<%=basePath %>gx/jquery-weui/js/jquery-weui.js"></script>
    <script src="<%=basePath %>gx/js/plupload.full.min.js"></script>

</head>

<body ontouchstart>

<header>
    <div class="div-title">
        <a href="<%=basePath %>mobile/index.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">人才公寓租赁申请</span>
    </div>
</header>
<form action="<%=basePath %>/mobile/fwzl-save.do" method="post" id="fwzlForm">
    <input type="hidden" name="rowId" value="${rcgyLeseApply.rowId}">
<div class="weui-cells__title"><span style="color: blue;">申请信息</span></div>
<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">申请企业名称</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="enterpriseName" value="${rcgyLeseApply.enterpriseName}" type="text" placeholder="请输入企业名称">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">申请日期</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="applyDate" value="${rcgyLeseApply.applyDate}" type="date" value="">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">企业经办人</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="enterpriseManager" value="${rcgyLeseApply.enterpriseManager}" type="text" placeholder="请输入经办人">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">联系电话</label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="contactNumber" value="${rcgyLeseApply.contactNumber}" type="tel" placeholder="请输入联系电话">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">需求公寓类型</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="apartmentType" value="${rcgyLeseApply.apartmentType}" id="gylx" type="text" placeholder="请选择需求公寓类型">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">需求公寓数量</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="apartmentNumber" value="${rcgyLeseApply.apartmentNumber}" type="number" placeholder="请输入公寓数量">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">是否符合投资协议约定</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="isAccordTzxyyd" value="${rcgyLeseApply.isAccordTzxyyd}" id="tzxyyd" type="text" placeholder="请选择是否符合">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">拟入住时间</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="checkInTime" value="${rcgyLeseApply.checkInTime}" type="date" value="">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">租赁期限</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="leaseTerm" value="${rcgyLeseApply.leaseTerm}" id="leaseTerm" type="text" placeholder="请输入租赁期限">
        </div>
    </div>
</div>
    <div class="weui-cells__title"><span style="color: blue;">文件下载</span></div>
    <div class="weui-cells">
        <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;" href="<%=basePath %>mobile-upload/fwzl-fileDownload.do?type=1">
            <div class="weui-cell__bd">
                <p>人才公寓租赁申请表</p>
            </div>
        </a>
        <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;" href="<%=basePath %>mobile-upload/fwzl-fileDownload.do?type=2">
            <div class="weui-cell__bd">
                <p>入住人员信息登记表</p>
            </div>
        </a>
        <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;" href="<%=basePath %>mobile-upload/fwzl-fileDownload.do?type=3">
            <div class="weui-cell__bd">
                <p>单位承诺书</p>
            </div>
        </a>
    </div>
    <div class="weui-cells__title"><span style="color: blue;">文件上传</span></div>
    <div id="fileDiv">
        <div style="width: 100%;height: 30px;">
            <table style="width: 100%;height: 100%;">
                <tr>
                    <td align="right">
                        <input id="upload-file-list" type="text" style="border: 1px solid #ccc; height: 28px;width: 98%;" readonly/>
                        <input type="hidden" id="form_attachmentId" name="attachmentId" />
                    </td>
                    <td style="width: 130px;">
                        <button id="pickfiles" style="width: 60px;height: 30px;border-radius: 5px;background-color: #377df6;color: white;border: 0px;" type="button">浏览</button>
                        <button id="uploadfiles" style="width: 60px;height: 30px;border-radius: 5px;background-color: #377df6;color: white;border: 0px;" type="button">上传</button>
                    </td>
                </tr>
            </table>
        </div>
        <c:if test="${fn:length(attachList) > 0 }">
            <c:forEach items="${attachList}" var="attach">
                <div style="height: 30px;width:98%;margin-top: 5px;margin-left: 1%;">
                    <span style="font-size:15px;">${attach.attachName}</span>
                    <input type="button" style="width: 60px;height: 30px;border-radius: 5px;background-color: #377df6;color: white;border: 0px;float: right;" class="btn btn-orange btn_file_delete" data="${attach.rowId}" value="删除" />
                </div>
            </c:forEach>
        </c:if>
    </div>
<div class="button_sp_area" align="center">
    <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary" style="background-color: #387ef8;" id="submitId">提交</a>
    <a href="<%=basePath %>mobile/to-mobile-index.do" class="weui-btn weui-btn_mini weui-btn_default">取消</a>
</div>

</form>

<style>

</style>



<script>
    $(function() {
        FastClick.attach(document.body);

        //方法说明：获取某字符串在数组中的位置
        function getIndexOfStrArr(strs,target){
            var result = -1;
            var strLength = strs.length;
            for(var i = 0 ;i < strLength;i++){
                if(strs[i]== target){
                    result = i;
                    break;
                }
            }
            return result;
        }

        //删除指定的索引，并重新将数组组装成以逗号分隔符的字符串
        function removeAndJoinString(strs,char_index){
            strs.splice(char_index,1);
            var res = strs.join(',');
            return res;
        }

        //定义文件上传对象
        var uploader = new plupload.Uploader({
            runtimes : 'html5,flash,silverlight,html4',
            browse_button : 'pickfiles', // you can pass in id...
            //container: document.getElementById('container'), // ... or DOM Element itself
            url : '<%=path%>/mobile-upload/fileUpload.do',
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
                    upload_callback($.parseJSON(json));
                },
                Error: function(up, err) {
                    alert(err.message);
                }
            }
        });

        uploader.init();

        /**
         * 上传文件回调函数
         */
        function upload_callback(json) {
            var msg_type = 'success';
            var msg_context = "上传成功！";
            console.log(json);
            if (json.statusCode == '200') {//上传成功状态
                var attachment = json.attachment;
                var attachementId = attachment.rowId;
                // 字符串添加当前附件ID
                var formAttachment = $("#form_attachmentId");
                var _attachementId = formAttachment.val() || "";
                _attachementId = _attachementId.length > 0 ? _attachementId + ",": "";
                formAttachment.val(_attachementId + attachementId);
                // 填充数据
                var html = "<div style='height: 30px;width:98%;margin-top: 5px;margin-left: 1%;'><span style='font-size:15px;'>"+attachment.attachName+"</span><input type='button' style='width: 60px;height: 30px;border-radius: 5px;background-color: #377df6;color: white;border: 0px;float: right;' class='btn btn-orange btn_file_delete' data='"+attachementId+"' value='删除' /></div>";
                $("#fileDiv").append(html);
            } else {//如果状态码为300或其他，均为错误的状态
                msg_type = 'error';
                msg_context = "上传失败！";
            }
            $.toptip(msg_context, msg_type);
            $("#upload-file-list").val("");
        }

        //删除附件
        $("#fileDiv").on("click",".btn_file_delete",function(){
            var btn_this =  $(this);
            var rowId = btn_this.attr("data");
            var form_attachmentId = $("#form_attachmentId");
            var _attachementId = form_attachmentId.val() || "";
            var msg_type = 'success';
            var msg_context = "删除成功！";
            $.ajax({
                url : '<%=path %>/mobile-upload/fileDelete.do',
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
                        btn_this.parent().remove();
                    }else{
                        msg_type = 'error';
                        msg_context = "删除失败！";
                    }
                }
            });
            $.toptip(msg_context, msg_type);
        });
    });
    $("#gylx").select({
        title: "需求公寓类型",
        items: ["盛景华庭-标准间","盛景华庭-大床房","盛景华庭-两室一厅","8849-标准间","8849-大床房","8849-两室一厅"]
    });
    $("#tzxyyd").select({
        title: "是否符合投资协议约定",
        items: ["是", "否"],
        onChange: function(d) {
        },
        onOpen: function() {
        },
        onClose: function() {
            var value = $("#tzxyyd").val();
            if(value == "是"){
                $("#leaseTerm").val("12个月");
                $("#leaseTerm").attr("data-values","12个月");
                $("#leaseTerm").select("update", { items: ["6个月", "12个月"] });
            }else{
                $("#leaseTerm").val("6个月");
                $("#leaseTerm").attr("data-values","6个月");
                $("#leaseTerm").select("update", { items: ["6个月"] });
            }
        }
    });
    $("#leaseTerm").select({
        title: "租赁期限",
        items: ["6个月", "12个月"]
    });
    $("#submitId").click(function() {
        var flag = true;
        $("input.weui-input").each(function(){
            if($(this).val() == ""){
                $(this).css("background-color","#fad6d6");
                flag = false;
            }else{
                $(this).css("background-color","");
            }
        });
        if(flag == false){
            $.toptip('所有表单项均需填写！', 'warning');
            return;
        }
        $("#fwzlForm").submit();
    });
</script>

</body>

</html>
