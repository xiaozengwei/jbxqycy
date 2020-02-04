<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>message/send-message.do" method="post" data-toggle="validate" data-reloadNavtab="false" id="formId">
        <table cellpadding="0" cellspacing="0" width="100%" class="messagetable" >
            <tbody>
            <tr>
                	<td  width="12%"  align="right" class="messagetr">
                        <label class="control-label x90">短信签名：</label></td>
                <td width="58%"> <input type="text" id="messageSign" name="messageSign" data-rule="required">
                    </td>
                <td rowspan="4"  align="left" rowspan="4" width="30%" >
                    <p style="color: #333; font-size: 14px; font-weight: bold;">友情提示：</p>
                    <p style="color: #ff6600">1、手动输入号码请用英文逗号分隔。</p>
                    <p style="color: #ff6600">1、手动输入号码请用英文逗号分隔。</p>
                    <p style="color: #ff6600">2、内容编辑完成请先检查关键词再行发送。</p>
                    <p style="color: #ff6600">3、短信内容实际长度=【短信签名】+短信内容。</p></td>
                </tr>
                <tr>
                    <td align="right" class="messagetr">
                        <label class="control-label x90">预定发送时间：</label></td>
                    <td><input type="text" name="sendTime" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss">
                    </td>
                </tr>
                <tr>
                	<td align="right" class="messagetr">
                        <label class="control-label x90">短信内容：</label></td>
                    <td><textarea rows="5" style="width:  100%" id="messageContent" name="messageContent" data-rule="required"></textarea>
                    </td>
                </tr>
                <tr>
                	<td align="right" class="messagetr">
                        <label class="control-label x90">手机号码：</label></td>
                    <td> <textarea rows="5" style="width: 100%; margin-bottom: 10px;" name="mobile" id="mobile" data-rule="required"></textarea>
                        <input type="hidden" name="t1.roomId" />
                        <input type="hidden" name="t1.userPhone" id="t1" />
                        <input type="hidden" name="t2.cardNum" />
                        <input type="hidden" name="t2.userPhone" id="t2" />
                        <div>
                            <input type="button" class="btn btn-green" value="一键添加人才公寓住户" id="addMobile1"/>
                            <input type="button" class="btn btn-green" value="一键添加一卡通用户" id="addMobile2"/>
                            <input type="button" class="btn btn-green" value="一键添加内部人员" id="addMobile3"/>
                            <a href="<%=basePath%>message/mobile-lookup1.do" class="btn btn-green" data-toggle="lookupbtn" data-group="t1">选择人才公寓住户</a>
                            <a href="<%=basePath%>message/mobile-lookup2.do" class="btn btn-green" data-toggle="lookupbtn" data-group="t2">选择一卡通用户</a>
                            <input type="button" class="btn btn-red" value="清空手机号码" id="remove"/>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="button" class="btn-green" id="sendMessage">发送短信</button></li>
        <li><button type="button" class="btn-blue" id="validate">检查关键词</button></li>
    </ul>
</div>

<script type="text/javascript">
    $(function() {
        //检查屏蔽词
        $("#validate").on("click",function(){
            $.ajax({
                url : '<%=path %>/message/validate.do',
                type : 'post',
                data : {'messageContent':$("#messageContent").val(), 'messageSign':$("#messageSign").val()},
                dataType:'json',
                success : function(json) {
                    if (json.statusCode == '200') {
                        $(this).alertmsg('ok', json.message);
                    }else{
                        $(this).alertmsg('warn', json.message);
                    }
                }
            });

        });

        //发送短信
        $("#sendMessage").on("click",function(){
            $.ajax({
                url : '<%=path %>/message/send-message.do',
                type : 'post',
                data : $("#formId").serialize(),
                dataType:'json',
                success : function(json) {
                    if (json.statusCode == '200') {
                        $(this).alertmsg('ok', json.message);
                    }else{
                        $(this).alertmsg('warn', json.message);
                    }
                }
            });

        });

        //一键添加人才公寓住户
        $("#addMobile1").on("click",function(){
            $.ajax({
                url : '<%=path %>/message/addMobile1.do',
                type : 'post',
                data : {},
                dataType:'json',
                success : function(json) {
                    if (json.statusCode == '200') {
                       $("#mobile").val(json.mobile);
                        $(this).alertmsg('ok', json.message);
                    }else{
                        $(this).alertmsg('warn', json.message);
                    }
                }
            });

        });

        //一键添加一卡通用户
        $("#addMobile2").on("click",function(){
            $.ajax({
                url : '<%=path %>/message/addMobile2.do',
                type : 'post',
                data : {},
                dataType:'json',
                success : function(json) {
                    if (json.statusCode == '200') {
                        $("#mobile").val(json.mobile);
                        $(this).alertmsg('ok', json.message);
                    }else{
                        $(this).alertmsg('warn', json.message);
                    }
                }
            });

        });

        //一键添加内部人员
        $("#addMobile3").on("click",function(){
            $.ajax({
                url : '<%=path %>/message/addMobile3.do',
                type : 'post',
                data : {},
                dataType:'json',
                success : function(json) {
                    if (json.statusCode == '200') {
                        $("#mobile").val(json.mobile);
                        $(this).alertmsg('ok', json.message);
                    }else{
                        $(this).alertmsg('warn', json.message);
                    }
                }
            });

        });


        //清空手机号码
        $("#remove").on("click",function(){
            $("#mobile").val("");
        });

        //选择人才公寓住户，带回值后的事件
        $('#t1').on('afterchange.bjui.lookup', function(e, data) {
            var mobilePhone = data.value;
            var mobile = $("#mobile").val() == ""?"":$("#mobile").val()+",";
            mobile += mobilePhone;
            $("#mobile").val(mobile);
        });

        //选择一卡通用户，带回值后的事件
        $('#t2').on('afterchange.bjui.lookup', function(e, data) {
            var mobilePhone = data.value;
            var mobile = $("#mobile").val() == ""?"":$("#mobile").val()+",";
            mobile += mobilePhone;
            $("#mobile").val(mobile);
        });


    });
</script>