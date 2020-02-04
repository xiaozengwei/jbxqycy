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
        <span class="span-title">Y9</span>
    </div>
</header>
<div style="height: 40px;">
    <span style="line-height: 20px;font-size: 13px;font-weight: bold;">8849-云驰街站-盛景华庭-张墩路-雨山路地铁站-行知路·雨合路-光电科技园-耀华-膜园</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">8849人才公寓<br>-膜园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间<br>（9:00）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间<br>（10:00）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间<br>（11:00）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间<br>（12:00）</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">擎天科技</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">12:00</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">中科创新广场</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">12:05</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">云驰街站</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">12:15</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">张墩路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">12:20</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">雨山路地铁站（1号出口前）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:23</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:23</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:23</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">12:23</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">行知路·雨合路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:28</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:28</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:28</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">12:28</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">光电科技园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">12:30</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">耀华</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">12:35</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">膜园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">9:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">10:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">11:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">12:40</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">车型</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
</div>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;">下午</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">8849人才公寓<br>-膜园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间<br>（13:00）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间<br>（14:00）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间<br>（15:00）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="font-weight:bold;">发车时间<br>（16:00）</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">擎天科技</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">13:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">15:00</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:00</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">中科创新广场</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">13:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">15:05</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:05</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">云驰街站</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">13:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">15:15</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:15</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">张墩路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">13:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">15:20</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:20</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">雨山路地铁站（1号出口前）</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">13:23</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:23</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">15:23</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:23</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">行知路·雨合路</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">13:28</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:28</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">15:28</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:28</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">光电科技园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">13:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">15:30</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:30</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">耀华</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">13:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">15:35</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:35</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">膜园</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">13:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">14:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">15:40</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">16:40</span>
        </p>
    </a>

    <a class="weui-grid js_grid" style="padding:2px 2px;width: 28%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">车型</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
        <p class="weui-grid__label" style="font-size: 12px;">
            <span style="color: #a4a1a1;">45座</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:2px 2px;width: 18%;">
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
