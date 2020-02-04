<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>sd/send-message.do" method="post" data-toggle="validate" data-reloadNavtab="false" id="formId">

                    <table cellpadding="0" cellspacing="0" width="100%" class="messagetable" >
                        <tbody>
                        <tr>
                            <td width="12%"  align="right" class="messagetr">
                                <label class="control-label x90">短信签名：</label></td>
                                <td  width="58%"><input type="text" id="messageSign" name="messageSign" data-rule="required" style="width: 300px;">
                            </td>
                            <td align="left" rowspan="4" width="30%" >
                                <p style="color: #333; font-size: 14px; font-weight: bold;">友情提示：</p>
                                <p style="color: #ff6600">1、手动输入号码请用英文逗号分隔。</p>
                                <p style="color: #ff6600">2、预定发送时间若不填，则立即发送</p>
                                <p style="color: #ff6600">3、内容编辑完成请先检查关键词再行发送。</p>
                                <p style="color: #ff6600">4、短信内容实际长度=【短信签名】+短信内容。</p>
                            </td>
                        </tr>
                        <tr>
                            <td  align="right" class="messagetr">
                                <label class="control-label x90">预定发送时间：</label></td>
                            <td><input type="text" name="sendTime" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" style="width: 300px;">
                            </td>
                        </tr>
                        <tr>
                            <td  align="right" class="messagetr">
                                <label class="control-label x90">短信内容：</label></td>
                            <td><textarea rows="5" style="width:  100%" id="messageContent" name="messageContent" data-rule="required"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" class="messagetr">
                                <label class="control-label x90">手机号码：</label></td>
                            <td><textarea rows="5" style="width:  100%" name="mobile" data-rule="required"></textarea>
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
    });
</script>