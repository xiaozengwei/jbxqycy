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
                <img src="<%=basePath %>gx/mobile/zbpt-img/264180497438054691.jpg" width="100%" alt="">
            </li>
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/477594722014306512.jpg" width="100%" alt="">
            </li>
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/489509541028544742.jpg" width="100%" alt="">
            </li>
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/527277708037013399.jpg" width="100%" alt="">
            </li>
        </ul>
    </figure>
</header>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>老乡鸡</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;padding: 5px; text-indent: 24px;">
            老乡鸡，全国600多家直营店。
            2003年，老乡鸡第一家快餐店肥西老母鸡在合肥开业；2012年，品牌升级为老乡鸡；2016年老乡鸡入驻南京、武汉；
            品牌创办至今，老乡鸡在全国已经有600多家直营店，并持续高速发展中。
            老乡鸡是以180天土鸡与农夫山泉炖制的肥西老母鸡汤为特色；食材甄选一线品牌供应商深度合作，品质放心；
            餐厅设计透明化厨房，将烹饪全程呈现在顾客面前，干净卫生看得见。
            坚持健康营养的中式烹饪方式出品，深受消费者的认可和欢迎。
            作为日常就餐更好的选择，老乡鸡已经服务消费者4.5亿人次，顾客排队成为餐厅日常。
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
