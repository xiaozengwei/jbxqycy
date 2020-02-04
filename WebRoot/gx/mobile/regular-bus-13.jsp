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
        <span class="span-title">Y13</span>
    </div>
</header>
<div style="height: 60px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">膜园-行知路·雨合路-光电科技园-耀华-云驰街站-天浦路6号-天浦路1号-研发大厦-原高新区管委会-江北新区管委会</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">站点名称</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">回程时间（原路返回）</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">膜园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">12:11</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">行知路·雨合路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:16</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">12:01</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">光电科技园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:18</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:55</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">耀华</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:50</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">云驰街站</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:40</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">天浦路6号</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:34</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:21</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">天浦路1号</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:20</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">研发大厦</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:50</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:10</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">原高新管委会</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:07</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">税务局</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:05</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">江北新区管委会</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:00</span>
        </p>
    </a>
</div>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">下午</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">站点名称</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">回程时间（原路返回）</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">膜园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:11</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">行知路·雨合路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:16</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:01</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">光电科技园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:18</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:55</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">耀华</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:50</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">云驰街站</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:40</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">天浦路6号</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:34</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:21</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">天浦路1号</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:20</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">研发大厦</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:50</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:10</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">原高新管委会</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">15:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:07</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">税务局</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">15:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:05</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">江北新区管委会</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">15:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:00</span>
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
