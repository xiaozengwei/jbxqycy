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
<script type="text/javascript">

</script>
<body ontouchstart>
<header>
    <div class="div-title">
        <a href="<%=basePath %>mobile/sd-recharge-list.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">${title}</span>
    </div>
</header>
<div style="margin-top: 20px;">
    <form action="<%=basePath %>mobile/refund-save.do" method="post" id="dfForm">
        <input type="hidden" value="${sdRechargeRecord.rowId}" name="rowId">
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">退款原因</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input paddingLeft10" id="refundDesc" name="refundDesc" type="text" placeholder="请输入退款原因">
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">房间号</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input paddingLeft10" name="roomId" type="text" value="${sdRechargeRecord.roomId}" readonly>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">充值金额</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input paddingLeft10" name="rechargeMoney" type="text" value="${sdRechargeRecord.rechargeMoney}" readonly>
                </div>
            </div>
        </div>
    </form>
    <div class="weui-btn-area">
        <a href="javascript:;" class="weui-btn weui-btn_primary" id="submitId" style="background-color: dodgerblue;">确认退款</a>
    </div>
    <div class="weui-cell">
        <p style="text-align: left;font-size: 10px;color: red;">
            温馨提示：提交退费申请后，系统将在5个工作日内完成退款！
        </p>
    </div>
</div>

<style>

</style>

<script>
    $(function() {
        FastClick.attach(document.body);
        $("#full_feature").swipeslider();
    });

    $("#submitId").click(function() {
        var refundReason = $("#refundReason").val();
        if(refundReason == ''){
            $.toast("请输入退款原因", "text");
            return;
        }
        $("#dfForm").submit();
    });

</script>

</body>

</html>
