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

    <script src="<%=basePath %>gx/jquery-weui/lib/jquery-2.1.4.js"></script>
    <script src="<%=basePath %>gx/jquery-weui/lib/fastclick.js"></script>
    <script src="<%=basePath %>gx/jquery-weui/js/jquery-weui.js"></script>

</head>

<body ontouchstart style="background-color: #efefef;">

<header>
    <div class="div-title">
        <a href="<%=basePath %>mobile/index.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">智能水电服务</span>
    </div>
</header>
<div class="weui-grids" style="background-color: white;">
    <a href="<%=basePath %>mobile/sd-bind-select.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_hydropower.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            水电绑定
        </p>
    </a>
    <a href="<%=basePath %>mobile/sd-recharge-select.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_hydropower.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            水电充值
        </p>
    </a>
    <a href="<%=basePath %>mobile/sd-query.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_hydropower.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            水电查询
        </p>
    </a>
    <a href="<%=basePath %>mobile/sd-recharge-list.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_hydropower.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            充值记录查询
        </p>
    </a>
    <a href="<%=basePath %>mobile/to-electric-balance.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_hydropower.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            电费余额查询
        </p>
    </a>
    <a href="<%=basePath %>mobile/to-water-balance.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_hydropower.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            水费余额查询
        </p>
    </a>
</div>

<style>

</style>



<script>
    $(function() {
        FastClick.attach(document.body);
    });
</script>

</body>

</html>
