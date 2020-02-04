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
    <link rel="stylesheet" href="<%=basePath %>gx/mobile/css/iF.step.css">
    <link rel="stylesheet" href="<%=basePath %>gx/mobile/css/swipeslider.css">

    <script src="<%=basePath %>gx/jquery-weui/lib/jquery-2.1.4.js"></script>
    <script src="<%=basePath %>gx/jquery-weui/lib/fastclick.js"></script>
    <script src="<%=basePath %>gx/jquery-weui/js/jquery-weui.js"></script>
    <script src="<%=basePath %>gx/mobile/js/swipeslider.min.js"></script>

</head>

<body ontouchstart>

<header>
    <div class="div-title">
        <a href="<%=basePath %>mobile/sd-bind-select.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">水电绑定</span>
    </div>
</header>
<form action="<%=basePath %>/mobile/room-bind-save.do" method="post" id="roomBindForm">
<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">房间号</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" id="roomId" name="roomId" type="text" placeholder="请输入房间号">
        </div>
    </div>
    <div class="weui-cell" id="addRoom">
        <span style="font-size: 13px;color: #00a2d4;" onclick="addRoom()">添加更多</span>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">姓名</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" id="userName" name="userName" type="text" placeholder="请输入姓名">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">身份证号</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" id="userIdCard" name="userIdCard" type="text" placeholder="请输入身份证号">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">手机号码</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" id="userPhone" name="userPhone" type="text" placeholder="请输入手机号码">
        </div>
    </div>
</div>
    <div class="weui-btn-area">
        <a href="javascript:;" class="weui-btn weui-btn_primary" id="submitId">绑定</a>
    </div>
    <div class="weui-cell">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;">
            温馨提示：微信用户通过绑定房间号与电表、水表关联，即可查询电费、水费使用情况，每个用户只能绑定一个房间。
        </p>
    </div>
</form>


<style>

</style>



<script>
    $(function() {
        FastClick.attach(document.body);
    });

    /**
     * 添加多个房间
     */
    function addRoom(){
        $("#addRoom").before("<div class='weui-cell'>\n" +
            "        <div class='weui-cell__hd'><label class='weui-label'>房间号</label></div>\n" +
            "        <div class='weui-cell__bd'>\n" +
            "            <input class='weui-input paddingLeft10 roomId' name='roomId' type='text' placeholder='请输入房间号'>\n" +
            "        </div>\n" +
            "    </div>");
    }

    /**
     * 绑定房间
     */
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
        //得到所有房间号
        var roomIds = "";
        $("input[name='roomId']").each(function(){
            if(roomIds.length == 0){
                roomIds += $(this).val();
            }else{
                roomIds += ","+$(this).val();
            }
        });
        //判断房间号是否存在
        $.ajax({
            type: "post",
            url: "<%=path %>/mobile/room-validate.do",
            data: {"roomIds" : roomIds},
            dataType: "json",
            success: function(data){
                var statusCode = data.statusCode;
                if(statusCode == "200"){
                    $("#roomBindForm").submit();
                }else{
                    $.toptip(data.message, 'warning');
                }
            }
        });
    });
</script>

</body>

</html>
