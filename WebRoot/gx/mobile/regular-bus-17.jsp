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
        <span class="span-title">Y17</span>
    </div>
</header>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">云驰街-创智大厦-研发大厦</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">车牌号/驾驶员/联系方式</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">云驰街站</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">创智大厦</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">研发大厦</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AU2599王爱彬186-2518-6674</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:50</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AZ6819王茂祥135-1253-0457</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AU2599王爱彬186-2518-6674</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AZ6819王茂祥135-1253-0457</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AU2599王爱彬186-2518-6674</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">13:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">13:55</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AZ6819郑从明186-0250-8019</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:55</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AU2599王爱彬186-2518-6674</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AZ6819郑从明186-0250-8019</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AP1525袁师傅139-1292-2245</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>

</div>

<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">研发大厦-创智大厦-云驰街</span>
</div>

<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">研发大厦</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">创智大厦</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">云驰街</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">车牌号/驾驶员/联系方式</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AZ6819王茂祥135-1253-0457</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AU2599王爱彬186-2518-6674</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AZ6819王茂祥135-1253-0457</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AZ6819王茂祥135-1253-0457</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">12:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">12:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">该班次不停靠云驰街</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">13:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">13:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AZ6819郑从明186-0250-8019</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AU2599王爱彬186-2518-6674</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AZ6819郑从明186-0250-8019</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 20%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">&nbsp;</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏AU2599王爱彬186-2518-6674</span>
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
