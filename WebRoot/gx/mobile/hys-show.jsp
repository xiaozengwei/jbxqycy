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
        <span class="span-title">会议室简介</span>
    </div>
</header>
<div class="weui-cells" >
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/hys-detail.do?hys=1">
        <div class="weui-cell__bd">
           <div style="float: left; width: 120px; height: 45px;"><h4 style="margin-top: 10px"><span style="width: 0.5em;height: 0.5em;border-radius: 50%;background-color: #f7c236;display: inline-block;margin-right: 5px;"></span>企业家俱乐部</h4></div>
            <div style="height: 45px;width: 100%;margin-left: 120px;">
                <div style="font-size: 0.6em;white-space: nowrap;text-overflow: ellipsis;overflow: hidden;">课桌式：<span style="color: #a4a1a1;">60-110人</span> 剧院式：<span style="color: #a4a1a1;">110-130人</span> U型：<span style="color: #a4a1a1;">32-48人</span></div>
                <p style="font-size: 0.6em;margin-top: 20px;">位置：<span style="color: #a4a1a1;">南京市江北新区团结路99号研创园孵鹰大厦A座316会议室</span></p>
            </div>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/hys-detail.do?hys=2">
        <div class="weui-cell__bd">
            <div style="float: left; width: 120px; height: 45px;"><h4 style="margin-top: 10px"><span style="width: 0.5em;height: 0.5em;border-radius: 50%;background-color: #f7c236;display: inline-block;margin-right: 5px;"></span>宣讲厅</h4></div>
            <div style="height: 45px;width: 100%;margin-left: 120px;">
                <p style="font-size: 0.6em;white-space: nowrap;text-overflow: ellipsis;overflow: hidden;">课桌式：<span style="color: #a4a1a1;">60-110人</span> 剧院式：<span style="color: #a4a1a1;">120-150人</span> U型：<span style="color: #a4a1a1;">26-30人</span></p>
                <p style="font-size: 0.6em;margin-top: 20px;">地址：<span style="color: #a4a1a1;">南京市江北新区团结路99号研创园孵鹰大厦C座204会议室</span></p>
            </div>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/hys-detail.do?hys=3">
        <div class="weui-cell__bd">
            <div style="float: left; width: 120px; height: 45px;"><h4 style="margin-top: 10px"><span style="width: 0.5em;height: 0.5em;border-radius: 50%;background-color: #f7c236;display: inline-block;margin-right: 5px;"></span>大报告厅</h4></div>
            <div style="height: 45px;width: 100%;margin-left: 120px;">
                <p style="font-size: 0.6em;white-space: nowrap;text-overflow: ellipsis;overflow: hidden;">课桌式：<span style="color: #a4a1a1;">150-180人</span> 剧院式：<span style="color: #a4a1a1;">260-300人</span> U型：<span style="color: #a4a1a1;">28-36人</span></p>
                <p style="font-size: 0.6em;margin-top: 20px;">地址：<span style="color: #a4a1a1;">南京市江北新区江淼路88号研创园腾飞大厦D座4楼大报告厅</span></p>
            </div>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/hys-detail.do?hys=4">
        <div class="weui-cell__bd">
            <div style="float: left; width: 120px; height: 45px;"><h4 style="margin-top: 10px"><span style="width: 0.5em;height: 0.5em;border-radius: 50%;background-color: #f7c236;display: inline-block;margin-right: 5px;"></span>会议室1</h4></div>
            <div style="height: 45px;width: 100%;margin-left: 120px;">
                <p style="font-size: 0.6em;white-space: nowrap;text-overflow: ellipsis;overflow: hidden;">课桌式：<span style="color: #a4a1a1;">/</span> 剧院式：<span style="color: #a4a1a1;">/</span> U型：<span style="color: #a4a1a1;">19人</span></p>
                <p style="font-size: 0.6em;margin-top: 20px;">地址：<span style="color: #a4a1a1;">腾飞大厦4楼401</span></p>
            </div>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/hys-detail.do?hys=5">
        <div class="weui-cell__bd">
            <div style="float: left; width: 120px; height: 45px;"><h4 style="margin-top: 10px"><span style="width: 0.5em;height: 0.5em;border-radius: 50%;background-color: #f7c236;display: inline-block;margin-right: 5px;"></span>会议室2</h4></div>
            <div style="height: 45px;width: 100%;margin-left: 120px;">
                <p style="font-size: 0.6em;white-space: nowrap;text-overflow: ellipsis;overflow: hidden;">课桌式：<span style="color: #a4a1a1;">/</span> 剧院式：<span style="color: #a4a1a1;">/</span> U型：<span style="color: #a4a1a1;">30人</span></p>
                <p style="font-size: 0.6em;margin-top: 20px;">地址：<span style="color: #a4a1a1;">腾飞大厦4楼402</span></p>
            </div>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/hys-detail.do?hys=8">
        <div class="weui-cell__bd">
            <div style="float: left; width: 120px; height: 45px;"><h4 style="margin-top: 10px"><span style="width: 0.5em;height: 0.5em;border-radius: 50%;background-color: #f7c236;display: inline-block;margin-right: 5px;"></span>媒体发布中心</h4></div>
            <div style="height: 45px;width: 100%;margin-left: 120px;">
                <p style="font-size: 0.6em;white-space: nowrap;text-overflow: ellipsis;overflow: hidden;">课桌式：<span style="color: #a4a1a1;">80人</span> 剧院式：<span style="color: #a4a1a1;">60-80人</span> U型：<span style="color: #a4a1a1;">16-48人</span></p>
                <p style="font-size: 0.6em;margin-top: 20px;">地址：<span style="color: #a4a1a1;">南京市江北新区江淼路88号研创园腾飞大厦A座2楼媒体发布中心</span></p>
            </div>
        </div>
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
