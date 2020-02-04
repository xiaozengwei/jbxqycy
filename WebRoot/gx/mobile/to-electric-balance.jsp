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
        <a href="<%=basePath %>mobile/water-electric.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">电费余额查询</span>
    </div>
</header>
<div style="margin-top: 20px;">
    <form action="<%=basePath %>mobile/electric-balance.do" method="post" id="yeForm">
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">房间号</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input paddingLeft10" id="roomId" name="roomId" type="text" value="${roomId}" placeholder="请输入房间号">
                </div>
            </div>
        </div>
    </form>
    <div class="weui-btn-area">
        <a href="javascript:;" class="weui-btn weui-btn_primary" id="submitId">查询</a>
    </div>
</div>

<style>

</style>

<script>

    $("#submitId").click(function() {
        //判断房间号是否存在
        $.ajax({
            type: "post",
            url: "<%=path %>/mobile/room-validate1.do",
            data: {"roomId" : $("#roomId").val()},
            dataType: "json",
            success: function(data){
                var statusCode = data.statusCode;
                if(statusCode == "200"){
                    $("#yeForm").submit();
                }else{
                    $.toptip(data.message, 'warning');
                }
            }
        });
    });

    $(function() {
        FastClick.attach(document.body);
    });

</script>

</body>

</html>
