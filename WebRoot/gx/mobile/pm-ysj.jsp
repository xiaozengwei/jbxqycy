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
        <a href="<%=basePath %>mobile/peripheral-matching.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">周边配套</span>
    </div>
    <div>
        <img src="<%=basePath %>gx/mobile/images/ysj-msgc.jpg" width="100%" alt="">
    </div>
</header>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>雲食集.美食广场</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;padding: 5px; text-indent: 24px;">
            美食一条街，内含多种餐饮小吃，世界茶饮、啵啵鱼、黄焖鸡米饭、传统牛肉面、慢时光炸鸡、铁板饭、淮南牛羊肉汤管、沙县小吃、川海风尚麻辣烫、大碗皮肚面、
            东北水饺、米可石板饭、煲仔饭、西安小吃等。
        </p>
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;padding: 5px; text-indent: 24px;">
            联系人：万鹏
        </p>
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;padding: 5px; text-indent: 24px;">
            手机号：18018051567
        </p>
    </a>
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
