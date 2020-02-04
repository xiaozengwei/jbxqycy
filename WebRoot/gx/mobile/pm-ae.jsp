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
                <img src="<%=basePath %>gx/mobile/zbpt-img/66249046439861310.jpg" width="100%" alt="">
            </li>
            <li class="sw-slide">
                <img src="<%=basePath %>gx/mobile/zbpt-img/325893184099032482.jpg" width="100%" alt="">
            </li>
        </ul>
    </figure>
</header>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>爱尔健身</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;padding: 5px; text-indent: 24px;">
            南京爱尔健身服务有限公司是一家以为主的企业，公司办公地址位于南京市浦口区江浦街道象山路。
            南京爱尔健身服务有限公司秉承“诚信、专业”的经营理念,坚持用户至上、质量第一，
            经过不断的努力和超越已经成为一家在行业内具有相当规模、较大影响力、发展迅速的企业之一。
            希望广大企业、消费者与我们联系、洽谈，我们会用优秀的产品和服务让您满意！
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
