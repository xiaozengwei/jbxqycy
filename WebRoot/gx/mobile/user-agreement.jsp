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
<div style="height: 30px;font-size: 15px;">
    <h4>用户协议</h4>
</div>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>一卡通使用守则</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="font-size: 14px;">
            江北新区产业技术研创园一卡通卡片均为实名认证，为一人一卡制。不可转借，不可赠予。开换卡将收取10元卡成本费用，卡费不退，不给予开具发票或收据等票据
            关注江北研创园服务平台进行在线微信充值，充值之后需在圈存机上进行圈存（注：圈存时只需要将卡片放至圈存机上，无需再圈存机上做其他操作。如误操作将卡里金额刷至圈存机上我方不给予退还）。
            一卡通的消费金额均为商铺开具发票，我方不承担任何发票开具。
        </p>
    </a>
</div>
<div class="button_sp_area" align="center">
    <a href="<%=basePath %>mobile/to-ykt-select.do" class="weui-btn weui-btn_mini weui-btn_primary" style="background-color: #387ef8;" id="submitId">同意</a>
    <a href="<%=basePath %>mobile/to-mobile-index.do" class="weui-btn weui-btn_mini weui-btn_default">不同意</a>
</div>
<style>

</style>



<script>
    $(function() {
        FastClick.attach(document.body);
        $("#full_feature").swipeslider();
    });
</script>

</body>

</html>
