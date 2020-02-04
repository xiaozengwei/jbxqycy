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

<body style="background-color: #efefef;">

<header>
    <div class="div-title">
        <a href="<%=basePath %>mobile/index.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">班车查询</span>
    </div>
</header>
<div class="weui-cells" style="margin-top: 2px;">
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y1">
        <div class="weui-cell__bd">
            <p>Y1</p>
            <p style="font-size: 0.6em;">临江地铁站（1号口）-部分经停8849人才公寓（B座）-云驰街</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y2">
        <div class="weui-cell__bd">
            <p>Y2</p>
            <p style="font-size: 0.6em;">盛景华庭（南苑南门）-云驰街站</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y3">
        <div class="weui-cell__bd">
            <p>Y3</p>
            <p style="font-size: 0.6em;">泰冯路地铁站-天浦路南京工业大学公交站-膜园</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y4">
        <div class="weui-cell__bd">
            <p>Y4</p>
            <p style="font-size: 0.6em;">临江地铁站-云驰街站-光电科技园-耀华-膜园</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y5">
        <div class="weui-cell__bd">
            <p>Y5</p>
            <p style="font-size: 0.6em;">8849-云驰街站-盛景华庭-张墩路-雨山路地铁站-行知路·雨合路-光电科技园-耀华-膜园</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y6">
        <div class="weui-cell__bd">
            <p>Y6</p>
            <p style="font-size: 0.6em;">盛景华庭-雨山路地铁站-行知路·雨合路-光电科技园-耀华-膜园</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y7">
        <div class="weui-cell__bd">
            <p>Y7</p>
            <p style="font-size: 0.6em;">雨山路地铁站—膜园</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y8">
        <div class="weui-cell__bd">
            <p>Y8</p>
            <p style="font-size: 0.6em;">膜园-耀华-光电科技园-行知路·雨合路-雨山路地铁站</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y9">
        <div class="weui-cell__bd">
            <p>Y9</p>
            <p style="font-size: 0.6em;">8849-云驰街站-中科创新广场-盛景华庭-张墩路-雨山路地铁站-行知路·雨合路-光电科技园-耀华-膜园</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y10">
        <div class="weui-cell__bd">
            <p>Y10</p>
            <p style="font-size: 0.6em;">兰花塘地铁站—光电科技园</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y11">
        <div class="weui-cell__bd">
            <p>Y11</p>
            <p style="font-size: 0.6em;">瑞斯丽酒店—台积电(7月6日起，已停运)</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y12">
        <div class="weui-cell__bd">
            <p>Y12</p>
            <p style="font-size: 0.6em;">云驰街站-天浦路6号-天浦路1号-研发大厦(丽景路2号)-原高新区管委会（高新路16号）-江北新区管委会（药谷大道9号）</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y13">
        <div class="weui-cell__bd">
            <p>Y13</p>
            <p style="font-size: 0.6em;">膜园-行知路·雨合路-光电科技园-耀华-云驰街站-天浦路6号-天浦路1号-研发大厦(丽景路2号)-原高新区管委会（高新路16号）-江北新区管委会（药谷大道9号）</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y14">
        <div class="weui-cell__bd">
            <p>Y14</p>
            <p style="font-size: 0.6em;">工大产业园中科创新广场班车</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y15">
        <div class="weui-cell__bd">
            <p>Y15</p>
            <p style="font-size: 0.6em;">江北新区候机楼-南京禄口机场</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y16">
        <div class="weui-cell__bd">
            <p>Y16</p>
            <p style="font-size: 0.6em;">星火路地铁站—云驰街</p>
        </div>
    </a>
    <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="<%=basePath %>mobile/regular-bus-detail.do?id=y17">
        <div class="weui-cell__bd">
            <p>Y17</p>
            <p style="font-size: 0.6em;">云驰街-研发大厦</p>
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
