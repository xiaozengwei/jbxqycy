<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<script type="text/javascript">
    var syRowId = "";
    $(function() {
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
        //日期格式化
        Date.prototype.format = function(format){
            var o = {
                "M+" : this.getMonth()+1, //month
                "d+" : this.getDate(), //day
                "H+" : this.getHours(), //hour
                "m+" : this.getMinutes(), //minute
                "s+" : this.getSeconds(), //second
                "q+" : Math.floor((this.getMonth()+3)/3), //quarter
                "S" : this.getMilliseconds() //millisecond
            }

            if(/(y+)/.test(format)) {
                format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
            }

            for(var k in o) {
                if(new RegExp("("+ k +")").test(format)) {
                    format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
                }
            }
            return format;
        }

        var uploader = new plupload.Uploader({
            runtimes : 'html5,flash,silverlight,html4',
            browse_button : 'pickfiles', // you can pass in id...
            url : '<%=path%>/zbpt-file/fileUpload.do',
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
            var maxUploadIndex = $("#maxUploadIndex");
            var msg_type = 'ok';
            if (json.statusCode = '200') {//上传成功状态
                var zbptAttachment = json.attachment;
                var attachementId = zbptAttachment.rowId;
                // 字符串添加当前附件ID
                var formAttachment = $("#form_attachmentId");
                var _attachementId = formAttachment.val() || "";
                _attachementId = _attachementId.length > 0 ? _attachementId + ",": "";
                formAttachment.val(_attachementId + attachementId);
                var d = new Date()
                d.setTime( zbptAttachment.uploadTime)
                var uploadTime =d.format("yyyy-MM-dd HH:mm:ss");
                var upload_file_html = "<tr><td align='center' class='blue'><a href='<%=path %>/zbpt-file/fileDownload.do?fileId="+attachementId+"'>"
                    + zbptAttachment.attachName
                    + "</a></td><td align='center'><input type='button' class='btn btn-red btn_file_delete' data='"+attachementId+"' value='删除' />  " +
                    "<input type='button' class='btn btn-green set-type' data='"+attachementId+"' value='设为列表图片' /></td></tr>";
                var attachmentTab = $("#attachmentTab");
                attachmentTab.append(upload_file_html);
            } else {//如果状态码为300或其他，均为错误的状态
                msg_type = 'error';
            }
            var fileupload_input = $("#upload-file-list");
            fileupload_input.val("");
        }

        //删除附件
        $("#attachmentTab").on("click",".btn_file_delete",function(){
            var tr_this =  $(this);
            var rowId = tr_this.attr("data");
            var msg_type = 'ok';
            $.ajax({
                url : '<%=path %>/zbpt-file/fileDelete.do',
                type : 'post',
                data : {'fileId':rowId},
                success : function(json) {
                    if (json.statusCode == '200') {
                        //删除此行
                        tr_this.parents("tr:first").remove();
                    }else{
                        msg_type = 'error';
                    }
                }
            });
        });

        //设置、取消列表图片
        $("#attachmentTab").on("click",".set-type",function(){
            var tr_this =  $(this);
            var rowId = tr_this.attr("data");
            var value = tr_this.val();
            var flag = "";
            if(value == "设为列表图片"){
                var flag1 = true;
                $("input.set-type").each(function(){
                    if($(this).val() == "取消列表图片"){
                        flag1 = false;
                    }
                });
                if(flag1 == false){
                    tr_this.alertmsg('info', '已经存在列表图片，请先取消列表图片！');
                    return;
                }
                flag = "0";
            }else{
                flag = "1";
            }
            var msg_type = 'ok';
            $.ajax({
                url : '<%=path %>/zbpt-file/set-type.do',
                type : 'post',
                data : {'fileId':rowId,"flag":flag},
                success : function(json) {
                    if (json.statusCode == '200') {
                        if(flag == "0"){
                            tr_this.val("取消列表图片");
                        }else{
                            tr_this.val("设为列表图片");
                        }
                    }else{
                        msg_type = 'error';
                    }
                    tr_this.alertmsg(msg_type, json.message);
                }
            });
        });
    });
</script>

<div class="bjui-pageContent">
    <form action="<%=basePath%>zbpt/zbpt-save.do" method="post" data-toggle="validate" data-reloadNavtab="false">
        <input type="hidden" name="rowId"  value="${peripheralMatching.rowId}" />
        <input id="form_attachmentId" name="attachmentId" type="hidden" />
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td  align="center"><h3>周边配套</h3></td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">名称：</label>
                        <input type="text" name="ptName"  value="${peripheralMatching.ptName}" data-rule="required" style="width:400px;">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">地址：</label>
                        <input type="text" name="ptAddress"  value="${peripheralMatching.ptAddress}" data-rule="required" style="width:400px;">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">详细信息：</label>
                        <textarea name="ptDetail" rows="5" cols="40" data-rule="required">${peripheralMatching.ptDetail}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">上传附件：</label>
                        <input id="upload-file-list" type="text" class="pinput" style="width:260px" readonly="readonly"/>
                        <button id="pickfiles" type="button" class="btn-blue" data-icon="hand-o-up">浏览</button>
                        <button id="uploadfiles" type="button" class="btn-green" data-icon="upload">上传</button>
                    </td>
                </tr>
                <tr>
                    <table width="98%" border="0" cellspacing="0" cellpadding="0" class="table table-bordered table-hover table-striped" id="attachmentTab">

                        <tr>
                            <th width="60%">附件名称</th>
                            <th >操作</th>
                        </tr>
                        <c:forEach items="${attachmentList }" var="attachment">
                            <tr>
                                <td align="center" class="blue"><a href="<%=path %>/zbpt-file/fileDownload.do?fileId=${attachment.rowId}">${attachment.attachName }</a></td>
                                <td align="center">
                                    <input type="button" class="btn btn-red btn_file_delete" data="${attachment.rowId }" value="删除" />
                                    <input type="button" class="btn btn-green set-type" data="${attachment.rowId }" ${attachment.pictureType == '1'?'value="设为列表图片"':'value="取消列表图片"'} value="" />
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </tr>
              </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default">保存</button></li>
    </ul>
</div>