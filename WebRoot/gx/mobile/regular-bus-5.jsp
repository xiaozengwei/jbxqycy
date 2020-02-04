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
        <span class="span-title">Y5</span>
    </div>
</header>
<div style="height: 40px;">
    <span style="line-height: 20px;font-size: 12px;font-weight: bold;">8849-云驰街站-盛景华庭（B座）-张墩路-雨山路地铁站（1号出口前）-行知路·雨合路-光电科技园-耀华-膜园</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">8849人才公寓-膜园<br>&nbsp;</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间<br>（7:40）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间<br>（7:50）</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8849人才公寓（B座）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:50</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">云驰街站</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:42</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:52</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">盛景华庭</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">7:55</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:15</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">张墩路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:25</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">雨山路地铁站</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:30</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">行知路·雨合路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:18</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:38</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">光电科技园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:40</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">耀华</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:22</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:42</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">膜园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">8:50</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 40%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">车型</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 30%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
</div>
<div style="height: 40px;">
    <span style="line-height: 20px;font-size: 12px;font-weight: bold;">膜园-耀华-光电科技园-行知路·雨合路-雨山路地铁站（2号出口）-张墩路-盛景华庭（B座）-云驰街站-8849</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 16%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span style="font-weight:bold;">膜园-8849<br>&nbsp;</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span style="font-weight:bold;">发车时间<br>（17:25）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span style="font-weight:bold;">发车时间<br>（17:35）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span style="font-weight:bold;">发车时间<br>（17:50）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span style="font-weight:bold;">发车时间<br>（18:20）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span style="font-weight:bold;">发车时间<br>（18:50）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span style="font-weight:bold;">发车时间<br>（19:50）</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 16%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">膜园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">17:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">17:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">17:50</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:50</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">19:50</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 16%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">耀华</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">17:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">17:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">17:55</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:55</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">19:55</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 16%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">光电科技园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">17:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">17:45</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">19:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">20:00</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 16%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">行知路·雨合路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">17:37</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">17:47</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:02</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:32</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">19:02</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">20:02</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 16%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">雨山路地铁站</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">17:45</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">17:55</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">19:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">20:10</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 16%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">张墩路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">17:50</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:45</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">19:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">20:15</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 16%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">盛景华庭</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:10</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:55</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">19:25</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">20:25</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 16%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">云驰街站</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">19:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">19:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">20:30</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 16%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">8849人才公寓</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:07</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:17</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">18:32</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">19:02</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">19:32</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">20:32</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 16%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">车型</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 14%;">
        <p class="weui-grid__label" style="font-size: 10px;">
            <span  style="color: #a4a1a1;">45座</span>
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
