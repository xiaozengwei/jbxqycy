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
        <a href="<%=basePath %>mobile/regular-bus.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">Y16</span>
    </div>
</header>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">星火路地铁站-云驰街-光电-行知路雨合路</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">星火路地铁站</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">云驰街</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">光电科技园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">行知路雨合路</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:20</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:50</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:50</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:40</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:45</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:50</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:10</span>
        </p>
    </a>
</div>

<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">行知路雨合路-光电科技园-云驰街-星火路地铁站</span>
</div>

<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">行知路雨合路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">光电科技园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">云驰街</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">星火路地铁站3号口公交站旁</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:45</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:25</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">19:00</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">19:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">19:30</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">20:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">20:30</span>
        </p>
    </a>

</div>

<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">光电科技园-云驰街-中科-星火路地铁站</span>
</div>

<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">光电科技园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">云驰街</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">中科</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">星火路地铁站3号口公交站旁</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:45</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:45</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">19:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">19:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">21:00</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">19:45</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">19:45</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">20:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">20:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">22:00</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">20:45</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">20:45</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">21:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">21:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">23:00</span>
        </p>
    </a>

</div>

<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">星火路-中科</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">星火路地铁站1号口东侧</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">中科创新广场</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:50</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:50</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>

</div>

<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">中科-星火路</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">中科创新广场</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">星火路地铁站1号口东侧</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>

</div>


<script>
    $(function() {
        FastClick.attach(document.body);
        $("#full_feature").swipeslider();
    });
</script>

</body>

</html>
