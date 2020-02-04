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
        <a href="<%=basePath %>mobile/index.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">企业登录</span>
    </div>
</header>
<form action="<%=basePath %>/mobile/to-ykt-select.do" method="post" id="enterpriseLogin">
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">账号</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" style="font-size: 15px;" name="enterpriseId" id="enterpriseId" type="text" placeholder="请输入账号" />
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">密码</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" style="font-size: 15px;" name="password" id="password" type="password" placeholder="请输入密码" />
            </div>
        </div>
    </div>
    <div class="weui-msg__opr-area">
        <p class="weui-btn-area">
            <a href="javascript:;" class="weui-btn weui-btn_primary" style="background-color: #387ef8;width: 80%;" id="submitId">登录</a>
        </p>
    </div>
<%--<div class="button_sp_area" align="center">
    <a href="javascript:;" class="weui-btn weui-btn_primary" style="background-color: #387ef8;" id="submitId">登录</a>
</div>--%>

</form>

<script>
    $(function() {
        FastClick.attach(document.body);
    });

    //登录
    $("#submitId").click(function() {
        var enterpriseId = $("#enterpriseId").val();
        var password = $("#password").val();
        if(enterpriseId == '' || password == ''){
            $.toptip('请输入账号密码', 'warning');
        }else{
            $.ajax({
                url : '<%=path %>/mobile/enterprise-validate.do',
                type : 'post',
                data : {'enterpriseId':enterpriseId, 'password':password},
                success : function(json) {
                    if (json.statusCode == '200') {
                        $("#enterpriseLogin").submit();
                    }else{
                        $.toptip(json.message, 'warning');
                    }
                }
            });
        }
    });

</script>

</body>

</html>
