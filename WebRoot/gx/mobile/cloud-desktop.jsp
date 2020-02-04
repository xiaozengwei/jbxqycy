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
        <a href="<%=basePath %>mobile/index.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">云桌面</span>
    </div>
    <div>
        <img src="<%=basePath %>gx/mobile/images/cloud-desktop.jpg" width="100%" alt="">
    </div>
</header>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>云桌面</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;padding: 5px; text-indent: 24px;">
            云桌面是云计算时代的典型应用，包括个人级应用与组织级应用。
        </p>
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;padding: 5px; text-indent: 24px;">
            云桌面可以把数据空间、管理服务，提供桌面化的方式发布给操作者，适合作为平板、手机等微持化移动应用的网络操作系统，也可以将传统PC升级为网络操作。
        </p>
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;padding: 5px; text-indent: 24px;">
            基于数据空间的云桌面，主要通过虚拟化应用，将云端资源发布给各操作终端，仍属于数据平台云操作系统。
        </p>
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;padding: 5px; text-indent: 24px;">
            基于管理服务的云桌面，主要是通过SOA理念，将ESB（企业服务总线）和EBB（企业业务总线）的内容，发布给各操作终端，属于业务平台云操作系统。
        </p>
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;padding: 5px; text-indent: 24px;">
            联系人：洪超
        </p>
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;padding: 5px; text-indent: 24px;">
            手机号：18951826818
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
