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
    <script src="<%=basePath %>gx/js/plupload.full.min.js"></script>

</head>

<body ontouchstart>

<header>
    <div class="div-title">
        <a href="<%=basePath %>mobile/water-electric.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">一卡通绑定</span>
    </div>
</header>
<form action="<%=basePath %>mobile/ykt-bind-save.do" method="post" id="yktBindForm">
<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">一卡通账号</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="yktId" type="text" placeholder="请输入一卡通账号">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">姓名</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="userName" type="text" placeholder="请输入姓名">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">身份证号</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="userIdCard" type="text" placeholder="请输入身份证号">
        </div>
    </div>
</div>
    <div class="weui-btn-area">
        <a href="javascript:;" class="weui-btn weui-btn_primary" id="submitId">绑定</a>
    </div>

</form>

<style>

</style>



<script>
    $(function() {
        FastClick.attach(document.body);
    });

    $("#submitId").click(function() {
        var flag = true;
        $("input.weui-input").each(function(){
            if($(this).val() == ""){
                $(this).css("background-color","#fad6d6");
                flag = false;
            }else{
                $(this).css("background-color","");
            }
        });
        if(flag == false){
            $.toptip('所有表单项均需填写！', 'warning');
            return;
        }
        $("#yktBindForm").submit();
    });
</script>

</body>

</html>
