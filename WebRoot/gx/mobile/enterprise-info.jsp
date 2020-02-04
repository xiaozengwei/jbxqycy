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
        <span class="span-title">企业信息</span>
    </div>
</header>
<form action="<%=basePath %>/mobile/enterprise-save.do" method="post" id="enterpriseLogin">
    <%--<input type="hidden" name="enterpriseId" value="${enterpriseId}">
    <input type="hidden" name="password" value="${password}">--%>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">公司全称</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="enterpriseName" value="${enterpriseInfo.enterpriseName}" type="text" readonly/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">联系人姓名</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="contactName" type="text" />
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">联系电话</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="contactPhone" type="text" />
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">地址</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="orgAddress" type="text" />
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">楼层</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="floorNum" id="floorNum" type="text" />
            </div>
        </div>
    </div>
    <div class="weui-msg__opr-area">
        <p class="weui-btn-area">
            <a href="javascript:;" class="weui-btn weui-btn_primary" style="background-color: #387ef8;width: 80%;" id="submitId">保存并申请</a>
        </p>
    </div>
    <%--<div class="button_sp_area" align="center">
        <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary" style="background-color: #387ef8;" id="submitId">保存并申请</a>
    </div>--%>

</form>

<script>
    $(function() {
        FastClick.attach(document.body);
    });

    //保存
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
        var zzs =  /^[1-9]+[0-9]*]*$/;
        if(!zzs.test($("#floorNum").val())){
            $.toptip('楼层请输入正整数！', 'warning');
            return;
        }
        $("#enterpriseLogin").submit();
    });

</script>

</body>

</html>
