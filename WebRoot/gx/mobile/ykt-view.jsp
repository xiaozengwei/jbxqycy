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

    <style type="text/css">
        table
        {
            border-collapse:collapse;
        }

        table,th, td
        {
            border: 1px solid black;
        }
    </style>

</head>

<body ontouchstart>

<header>
    <div class="div-title">
        <a href="<%=basePath %>mobile/index.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">一卡通办理进度</span>
    </div>
</header>
<div class="step">
    <div style="width:100%; height:80px; margin-top:20px">
        <ol class="ui-step ui-step-blue ui-step-5" style="height:150px">
            <li class="step-start step-active" id="step1">
                <div class="ui-step-line"></div>
                <div class="ui-step-cont">
                    <span class="ui-step-cont-number">1</span>
                    <span class="ui-step-cont-text">申请</span>
                </div>
            </li>
            <li class="" id="step2">
                <div class="ui-step-line"></div>
                <div class="ui-step-cont">
                    <span class="ui-step-cont-number">2</span>
                    <span class="ui-step-cont-text">审核</span>
                </div>
            </li>
            <li class="" id="step3">
                <div class="ui-step-line"></div>
                <div class="ui-step-cont">
                    <span class="ui-step-cont-number">3</span>
                    <span class="ui-step-cont-text">制卡</span>
                </div>
            </li>
            <li class="" id="step4">
                <div class="ui-step-line"></div>
                <div class="ui-step-cont">
                    <span class="ui-step-cont-number">4</span>
                    <span class="ui-step-cont-text">发卡</span>
                </div>
            </li>
            <li class="step-end" id="step5">
                <div class="ui-step-line"></div>
                <div class="ui-step-cont">
                    <span class="ui-step-cont-number">5</span>
                    <span class="ui-step-cont-text">结束</span>
                </div>
            </li>
        </ol>

    </div>
</div>
<div style="background-color: #f8f8f8;height: 40px;">
    <span style="line-height: 40px;color: #4a8ad1;font-size: 16px;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>申请信息</span>
</div>
<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">申请人姓名</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="applicantName" value="${model.applicantName}" type="text" />
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">身份证号</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="applicantIdCard" value="${model.applicantIdCard}" type="text" />
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">手机号</label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="applicantPhone" value="${model.applicantPhone}" type="tel" />
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">公司名称</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="companyName" value="${model.companyName}" type="text" value="${enterpriseInfo.enterpriseName}"/>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">领取点位置</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="receivePlace" value="${model.receivePlace}" id="receivePlace" type="text">
        </div>
    </div>
</div>
<c:if test="${fn:length(oneCardPersonList) != 0}">
    <div style="background-color: #f8f8f8;height: 40px;">
        <span style="line-height: 40px;color: #4a8ad1;font-size: 16px;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>办卡人员明细</span>
    </div>
    <div class="weui-cells weui-cells_form">
        <table style="width: 100%;">
            <tr>
                <td style="width: 20%;text-align: center;">姓名</td>
                <td style="width: 45%;text-align: center;">身份证号</td>
                <td style="width: 35%;text-align: center;">手机号</td>
            </tr>
            <c:forEach items="${oneCardPersonList}" var="person">
                <tr>
                    <td style="width: 20%;text-align: center;">${person.userName}</td>
                    <td style="width: 50%;text-align: center;">${person.userIdCard}</td>
                    <td style="width: 30%;text-align: center;">${person.userPhone}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
<div class="weui-msg__opr-area">
    <p class="weui-btn-area">
        <a href="<%=basePath %>mobile/ykt-progress-list.do" class="weui-btn weui-btn_primary" style="background-color: #387ef8;width: 80%;" >返回</a>
    </p>
</div>

<style>

</style>



<script>
    $(function() {
        FastClick.attach(document.body);

        var instanceState ="${instanceState }";

        var step1 = $("#step1");
        var step2 = $("#step2");
        var step3 = $("#step3");
        var step4 = $("#step4");
        var step5 = $("#step5");
        if(instanceState == "申请"){
            step1.attr("class","step-start step-active");
            step2.attr("class","");
            step3.attr("class","");
            step4.attr("class","");
            step5.attr("class","step-end");
        }else if(instanceState == "审核"){
            step1.attr("class","step-start step-done");
            step2.attr("class","step-active");
            step3.attr("class","");
            step4.attr("class","");
            step5.attr("class","step-end");
        }else if(instanceState == "制卡"){
            step1.attr("class","step-start step-done");
            step2.attr("class","step-done");
            step3.attr("class","step-active");
            step4.attr("class","");
            step5.attr("class","step-end");
        }else if(instanceState == "发卡"){
            step1.attr("class","step-start step-done");
            step2.attr("class","step-done");
            step3.attr("class","step-done");
            step4.attr("class","step-active");
            step5.attr("class","step-end");
        }else{//结束
            step1.attr("class","step-start step-done");
            step2.attr("class","step-done");
            step3.attr("class","step-done");
            step4.attr("class","step-done");
            step5.attr("class","step-end step-active");
        }

    });
</script>

</body>

</html>
