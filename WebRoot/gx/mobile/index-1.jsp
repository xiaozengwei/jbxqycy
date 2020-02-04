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
    <script src="<%=basePath %>gx/jquery-weui/lib/jquery-2.1.4.js"></script>
    <script src="<%=basePath %>gx/jquery-weui/lib/fastclick.js"></script>
    <script src="<%=basePath %>gx/jquery-weui/js/jquery-weui.js"></script>
    <script src='<%=basePath %>gx/jquery-weui/js/swiper.js'></script>

</head>

<body ontouchstart>

<header>
    <img src="<%=basePath %>gx/mobile/images/banner.jpg" width="100%">
</header>
<div style="height: 8px;background-color: #efefef;">
</div>
<div style="width: 100%;height: 30px;text-align: center">
    <iframe scrolling="no" src="https://tianqiapi.com/api.php?style=tb&skin=durian&align=center&fontsize=13&paddingtop=4" align="center" frameborder="0" width="100%" height="24" allowtransparency="true"></iframe>
</div>
<div style="height: 8px;background-color: #efefef;">
</div>
<div style="height: 50px;border-top: 1px solid #d9d9d9;">
    <span style="line-height: 50px;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>常用菜单</span>
</div>
<div class="weui-grids">
    <%--<a href="<%=basePath %>mobile/user-agreement.do" class="weui-grid js_grid" style="padding:10px 10px;">--%>
        <%--<div class="weui-grid__icon">--%>
            <%--<img src="<%=basePath %>gx/mobile/images/img_cardbd.png" width="48px" alt="">--%>
        <%--</div>--%>
        <%--<p class="weui-grid__label">--%>
            <%--一卡通办理--%>
        <%--</p>--%>
    <%--</a>--%>
    <a href="" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_cardbd.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            一卡通办理
        </p>
    </a>
    <a href="<%=basePath %>mobile/ykt-progress-list.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_cardbd.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            一卡通进度查询
        </p>
    </a>
    <a href="http://qywechat.17wanxiao.com/wxnewhtml/gotoUrl.action?customerCode=6069" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_cardbd.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            一卡通自助服务
        </p>
    </a>
    <a href="<%=basePath %>mobile/water-electric.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_hydropower.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            智能水电服务
        </p>
    </a>
    <a href="<%=basePath %>mobile/to-fwzl-form.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_ybj.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            房屋租赁申请
        </p>
    </a>
    <a href="<%=basePath %>mobile/fwzl-progress-list.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_ybj.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            房屋租赁查询
        </p>
    </a>
    <a href="<%=basePath %>mobile/hys-show.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_meeting.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            会议室简介
        </p>
    </a>
    <a href="<%=basePath %>mobile/to-hys-form.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_meeting.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            会议室申请
        </p>
    </a>
    <a href="<%=basePath %>mobile/hys-progress-list.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_meeting.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            会议室租赁查询
        </p>
    </a>
    <a href="<%=basePath %>mobile/regular-bus.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_car.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            班车查询
        </p>
    </a>
    <a href="<%=basePath %>mobile/shuttle-bus.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_plane.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            机场大巴查询
        </p>
    </a>
    <a href="https://cloud.keytop.cn/page/user/lpn/lpn_bind.html" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_stop.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            车位租赁
        </p>
    </a>
    <a href="<%=basePath %>mobile/cloud-server.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_cloud.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            云服务器
        </p>
    </a>
    <a href="<%=basePath %>mobile/cloud-desktop.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_desktop.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            云桌面
        </p>
    </a>
    <a href="<%=basePath %>mobile/advertising-release.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_adv01.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            广告发布
        </p>
    </a>
    <a href="<%=basePath %>mobile/agency-center.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_db.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            代办中心
        </p>
    </a>
    <a href="<%=basePath %>mobile/carrier-service.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_yys.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            运营商服务
        </p>
    </a>
    <a href="<%=basePath %>mobile/peripheral-matching.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_ambitus.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            周边配套
        </p>
    </a>
    <a href="<%=basePath %>mobile/fwzl-ybj.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_ybj.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            样板间
        </p>
    </a>
    <c:if test="${wxUser.dataType == '1'}">
        <a href="<%=basePath %>mobile/user-agreement.do" class="weui-grid js_grid" style="padding:10px 10px;">
            <div class="weui-grid__icon">
                <img src="<%=basePath %>gx/mobile/images/img_cardbd.png" width="48px" alt="">
            </div>
            <p class="weui-grid__label">
                一卡通办理(测试)
            </p>
        </a>
    </c:if>
</div>
<div class="weui-footer">
    <p class="weui-footer__text">南京江北新区产业技术研创园</p>
</div>

<style>
    .weui-footer {
        margin: 25px 0 10px 0;
    }
</style>



<script>
    $(function() {
        FastClick.attach(document.body);
    });
</script>

</body>

</html>
