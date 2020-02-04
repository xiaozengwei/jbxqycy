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
<div class="weui-grids">
    <a href="" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_house_1.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            房屋租赁
        </p>
    </a>
    <a href="" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_meeting_1.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            会议室租赁
        </p>
    </a>
    <a href="" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_card_1.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            一卡通自助办理
        </p>
    </a>
</div>
<div style="height: 8px;background-color: #efefef;">
</div>
<div style="height: 50px;border-top: 1px solid #d9d9d9;">
    <span style="line-height: 50px;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>常用菜单</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:10px 10px;" id="photoSjht">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_ybj.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            样板间-盛景华庭
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:10px 10px;" id="photo8849">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_ybj02.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            样板间-8849
        </p>
    </a>
    <a href="" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_ycy.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            研创园人才公寓租赁管理方法
        </p>
    </a>
    <a href="<%=basePath %>mobile/to-fwzl-form.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_ybj.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            人才公寓租赁申请
        </p>
    </a>
    <a href="<%=basePath %>mobile/fwzl-progress-list.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_search.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            人才公寓租赁进度查询
        </p>
    </a>
    <a href="" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_search.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            会议室查询
        </p>
    </a>
    <a href="<%=basePath %>mobile/to-hys-form.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_meeting1.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            会议室租赁申请
        </p>
    </a>
    <a href="<%=basePath %>mobile/hys-progress-list.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_ycy.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            会议室租赁查询
        </p>
    </a>
    <a href="<%=basePath %>mobile/to-ykt-form.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_ycy.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            个人一卡通自助申请
        </p>
    </a>
    <a href="<%=basePath %>mobile/ykt-progress-list.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_cards.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            个人一卡通申请查询
        </p>
    </a>
    <a href="http://qywechat.17wanxiao.com/wxnewhtml/gotoUrl.action?customerCode=6069" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_search.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            一卡通余额查询
        </p>
    </a>
    <a href="" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_cardbd.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            一卡通交易绑定
        </p>
    </a>
    <a href="<%=basePath %>mobile/to-ykt-form.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_cardsq.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            企业一卡通自助申请
        </p>
    </a>
    <a href="<%=basePath %>mobile/hys-show.do" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_meeting1.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            会议室简介
        </p>
    </a>
    <a href="https://www.gotoai.com.cn/zntc_web/index" class="weui-grid js_grid" style="padding:10px 10px;">
        <div class="weui-grid__icon">
            <img src="<%=basePath %>gx/mobile/images/img_meeting1.png" width="48px" alt="">
        </div>
        <p class="weui-grid__label">
            停车场
        </p>
    </a>
</div>
<div class="weui-footer">
    <p class="weui-footer__text">南京江北新区产业技术研创园</p>
</div>

<style>
    .weui-footer {
        margin: 25px 0 10px 0;
    }
    .border-bottom{
        border-bottom:1px #f2f2f2 solid;
    }
    .border-right{
        border-right:1px #f2f2f2 solid;
    }
</style>



<script>
    $(function() {
        FastClick.attach(document.body);

    });
    var pb8849 = $.photoBrowser({
        items: [
            "<%=basePath %>gx/mobile/8849/1.jpg",
            "<%=basePath %>gx/mobile/8849/2.jpg",
            "<%=basePath %>gx/mobile/8849/3.jpg",
            "<%=basePath %>gx/mobile/8849/4.jpg",
            "<%=basePath %>gx/mobile/8849/5.jpg",
            "<%=basePath %>gx/mobile/8849/6.jpg",
            "<%=basePath %>gx/mobile/8849/7.jpg",
            "<%=basePath %>gx/mobile/8849/8.jpg",
            "<%=basePath %>gx/mobile/8849/9.jpg",
            "<%=basePath %>gx/mobile/8849/10.jpg",
            "<%=basePath %>gx/mobile/8849/11.jpg"
        ]
    });
    $("#photo8849").click(function(){
        pb8849.open(0);
    });
    var pbSjht = $.photoBrowser({
        items: [
            "<%=basePath %>gx/mobile/sjht/JIN_3307.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3309.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3309.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3315.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3318.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3320.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3321.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3323.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3325.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3327.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3330.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3331.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3336.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3339.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3340.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3341.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3342.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3346.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3347.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3349.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3353.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3354.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3356.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3361.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3366.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3368.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3370.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3372.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3373.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3374.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3375.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3377.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3379.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3380.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3383.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3388.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3391.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3394.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3396.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3397.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3399.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3400.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3404.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3409.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3410.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3413.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3418.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3422.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3424.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3426.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3428.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3429.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3431.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3433.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3435.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3437.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3440.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3441.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3444.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3446.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3448.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3453.JPG",
            "<%=basePath %>gx/mobile/sjht/JIN_3455.JPG"
        ]
    });
    $("#photoSjht").click(function(){
        pbSjht.open(0);
    });
</script>

</body>

</html>
