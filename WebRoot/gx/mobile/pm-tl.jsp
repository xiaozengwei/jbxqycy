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
                <img src="<%=basePath %>gx/mobile/zbpt-img/308926947513276022.jpg" width="100%" alt="">
            </li>
        </ul>
    </figure>
</header>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>泰俪精品酒店</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;padding: 5px; text-indent: 24px;">
            南京泰俪精品酒店坐落于南京江北高新区——南京江北新区产业技术研创园。
            酒店设计以现代简约为基调，弥漫着浓郁的东南亚风情，更有来自泰国纯手工的装饰：酒店大堂内的布置采用泰皇宫，庙宇的设计概念，金色穹形顶棚，金沙流水背景，赋予整个大堂神秘感，墙面的连续东南亚风格的纯手工墙绘，带来纯正的泰国风情。
            南京泰俪精品酒店拥有百余间客房，其中九十余间套房；套房的设计风格为高级度假公寓，简洁不简单。房内配备了42寸液晶电视，国内一线品牌的洁具及家具；套房内有开放式厨房，电陶炉、冰箱、抽油烟机等设备，可满足一些客人自主做饭的爱好，给宾客回家的感觉。
            <br>电话：9501 3760 8818
            <br>地址：南京 浦口区 团结路105号
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
