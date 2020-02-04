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
        <span class="span-title">Y6</span>
    </div>
</header>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">盛景华庭-雨山路地铁站-行知路·雨合路-光电科技园-耀华-膜园</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">盛景华庭-膜园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间（7:40）</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">盛景华庭（南苑南门）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:40</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">张墩路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:50</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">雨山路地铁站（1号出口）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:55</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">行知路·雨合路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:05</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">光电科技园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:10</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">耀华</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:15</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">膜园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:20</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">车型</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
</div>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">膜园-光电科技园-耀华玻璃厂-云驰街站-临江地铁站</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">膜园-盛景华庭</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间（17:15）</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">膜园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:15</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">耀华</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:20</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">光电科技园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:25</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">行知路·雨合路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:28</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">雨山路地铁站（2号出口）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:35</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">张墩路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:40</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">盛景华庭（南苑南门）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:50</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">车型</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 50%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
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
