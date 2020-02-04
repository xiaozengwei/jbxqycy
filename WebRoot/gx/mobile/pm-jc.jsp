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
    <figure id="full_feature" class="swipslider">
        <ul class="sw-slides">
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/9975453404176606.jpg" width="100%" alt="">
            </li>
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/188923394573190767.jpg" width="100%" alt="">
            </li>
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/283142408326263148.jpg" width="100%" alt="">
            </li>
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/286726746752261640.jpg" width="100%" alt="">
            </li>
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/326268074757688858.jpg" width="100%" alt="">
            </li>
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/417114309590789009.jpg" width="100%" alt="">
            </li>
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/463104130817112274.jpg" width="100%" alt="">
            </li>
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/625212645048523647.jpg" width="100%" alt="">
            </li>
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/701486798908648120.jpg" width="100%" alt="">
            </li>
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/870218127908526696.jpg" width="100%" alt="">
            </li>
        </ul>
    </figure>
</header>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>日本料理烤肉店</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;padding: 5px; text-indent: 24px;">
            江浦研创园人才公寓B座一楼乐臧日本料理烤肉店是一家以日本料理烤肉为主的餐厅，
            面积160平方，菜式纯正，价格便宜，适合同事家庭小聚的餐厅，有午间套餐，可以先打电话预约，提前做好，订餐电话02558186680，159-9628-9482
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
