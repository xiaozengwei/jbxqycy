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
    <script src='<%=basePath %>gx/jquery-weui/js/swiper.js'></script>

</head>

<body ontouchstart style="background-color: #efefef;">

<header>
    <div class="div-title">
        <a href="<%=basePath %>mobile/index.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">样板间查看</span>
    </div>
</header>
<div style="margin-top: 20px;">
    <a href="javascript:;" id="photo8849" class="weui-btn weui-btn_primary">样板间-8849</a>
    <a href="javascript:;" id="photoSjht" class="weui-btn weui-btn_primary">样板间-盛景华庭</a>
</div>

<style>

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
            "<%=basePath %>gx/mobile/sjht/JIN_3307.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3309.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3309.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3315.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3318.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3320.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3321.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3323.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3325.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3327.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3330.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3331.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3336.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3339.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3340.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3341.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3342.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3346.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3347.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3349.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3353.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3354.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3356.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3361.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3366.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3368.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3370.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3372.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3373.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3374.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3375.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3377.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3379.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3380.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3383.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3388.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3391.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3394.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3396.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3397.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3399.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3400.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3404.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3409.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3410.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3413.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3418.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3422.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3424.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3426.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3428.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3429.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3431.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3433.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3435.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3437.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3440.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3441.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3444.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3446.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3448.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3453.jpg",
            "<%=basePath %>gx/mobile/sjht/JIN_3455.jpg"
        ]
    });
    $("#photoSjht").click(function(){
        pbSjht.open(0);
    });
</script>

</body>

</html>
