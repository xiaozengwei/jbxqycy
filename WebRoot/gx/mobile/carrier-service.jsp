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
        <span class="span-title">运营商服务</span>
    </div>
</header>
<div class="weui-cells" >
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="">
        <div style="float: left">
            <img src="<%=basePath %>gx/mobile/images/china-mobile.png" width="120px" alt="" align="absmiddle" style="margin-right: 5px;">
        </div>
        <div style="float: left;">
            <p style="line-height: 20px;margin-top: 4px;">中国移动</p>
            <p style="line-height: 20px;margin-top: 4px;font-size: 13px;color: #a4a1a1;">客户经理：熊娟娟</p>
            <p style="line-height: 20px;margin-top: 4px;font-size: 13px;color: #a4a1a1;">手机：18860968198</p>
            <p style="font-size: 13px;color: #a4a1a1;">地址：孵鹰大厦A座大厅电梯口旁</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="">
        <div class="weui-cell__bd">
            <div style="float: left">
                <img src="<%=basePath %>gx/mobile/images/china-telecom.png" width="120px" alt="" align="absmiddle" style="margin-right: 5px;">
            </div>
            <div style="float: left;">
                <p style="line-height: 20px;margin-top: 4px;">中国电信</p>
                <p style="line-height: 20px;margin-top: 4px;font-size: 13px;color: #a4a1a1;">客户经理：徐勰蕾</p>
                <p style="line-height: 20px;margin-top: 4px;font-size: 13px;color: #a4a1a1;">手机：15335175031</p>
                <p style="font-size: 13px;color: #a4a1a1;">地址：孵鹰大厦D座一楼电信营业厅</p>
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