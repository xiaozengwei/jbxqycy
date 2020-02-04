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
        <span class="span-title">Y2</span>
    </div>
</header>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">盛景华庭→云驰街站</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">时间</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">车型</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">车牌号</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A18311D</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:50</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A18719F</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A18771D</span>
        </p>
    </a>


    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A90017</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A18719F</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A18311D</span>
        </p>
    </a>


    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A90017</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A18771D</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A18719F</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:50</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A90017</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A18771D</span>
        </p>
    </a>
</div>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">云驰街站→盛景华庭</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">时间</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">车型</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">车牌号</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 100%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:00至17:00每1小时发车一趟</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A18719F</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A90017</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A18719F</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17:50</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A90017</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">17座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A18771D</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A18719F</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A90017</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">18:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">苏A18771D</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 100%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">19:00至21:00每30分钟发车一趟</span>
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
