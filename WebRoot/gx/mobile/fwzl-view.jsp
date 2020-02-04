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

<body ontouchstart>

<header>
    <div class="div-title">
        <a href="<%=basePath %>mobile/index.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">人才公寓租赁申请进度</span>
    </div>
</header>
<div class="step">
    <div style="width:100%; height:100px;text-align: center;margin-top: 10px">
        <ol class="ui-step ui-step-blue ui-step-5" style="width:90%;height:100px">
            <li class="step-start" id="step1">
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
                    <span class="ui-step-cont-text">企业服务部审核</span>
                </div>
            </li>
            <li class="" id="step3">
                <div class="ui-step-line"></div>
                <div class="ui-step-cont">
                    <span class="ui-step-cont-number">3</span>
                    <span class="ui-step-cont-text">投资促进与人才工作部审核</span>
                </div>
            </li>
            <li class="" id="step4">
                <div class="ui-step-line"></div>
                <div class="ui-step-cont">
                    <span class="ui-step-cont-number">4</span>
                    <span class="ui-step-cont-text">力合创展物业管理部审核</span>
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
<div class="weui-cells__title"><span style="color: blue;">申请信息</span></div>
<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">申请企业名称</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="enterpriseName" value="${rcgyLeseApply.enterpriseName}" type="text" readonly>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">申请日期</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="applyDate" value="${rcgyLeseApply.applyDate}" type="date" readonly>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">企业经办人</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="enterpriseManager" value="${rcgyLeseApply.enterpriseManager}" type="text" readonly>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">联系电话</label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="contactNumber" value="${rcgyLeseApply.contactNumber}" type="tel" readonly>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">需求公寓类型</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="apartmentType" value="${rcgyLeseApply.apartmentType}" type="text" readonly>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">需求公寓数量</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="apartmentNumber" value="${rcgyLeseApply.apartmentNumber}" type="number" readonly>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">是否符合投资协议约定</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="isAccordTzxyyd" value="${rcgyLeseApply.isAccordTzxyyd}" type="text" readonly>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">拟入住时间</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="checkInTime" value="${rcgyLeseApply.checkInTime}" type="date" readonly>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">租赁期限</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="leaseTerm" value="${rcgyLeseApply.leaseTerm}" type="text" readonly>
        </div>
    </div>
</div>
<div class="weui-cells__title"><span style="color: blue;">附件信息</span></div>
<div class="weui-cells" style="font-size: 15px;">
    <c:if test="${fn:length(attachList) > 0}">
        <c:forEach items="${attachList }" var="attach">
            <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;" href="">
                <div class="weui-cell__bd">
                    <p>${attach.attachName}</p>
                </div>
                <div class="weui-cell__ft"><fmt:formatDate value="${attach.uploadTime}" pattern="yyyy-MM-dd HH:mm" /></div>
            </a>
        </c:forEach>
    </c:if>
</div>
<div class="button_sp_area" align="center">
    <a href="<%=basePath %>mobile/fwzl-progress-list.do" class="weui-btn weui-btn_primary" style="background-color: #387ef8;">返回</a>
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
            step1.attr("class","step-start step-done");
            step2.attr("class","");
            step3.attr("class","");
            step4.attr("class","");
            step5.attr("class","step-end");
        }else if(instanceState == "企业服务部审核"){
            step1.attr("class","step-start step-done");
            step2.attr("class","step-done");
            step3.attr("class","");
            step4.attr("class","");
            step5.attr("class","step-end");
        }else if(instanceState == "投资促进与人才工作部审核"){
            step1.attr("class","step-start step-done");
            step2.attr("class","step-done");
            step3.attr("class","step-done");
            step4.attr("class","");
            step5.attr("class","step-end");
        }else if(instanceState == "力合创展物业管理部审核"){
            step1.attr("class","step-start step-done");
            step2.attr("class","step-done");
            step3.attr("class","step-done");
            step4.attr("class","step-done");
            step5.attr("class","step-end");
        }else{//结束
            step1.attr("class","step-start step-done");
            step2.attr("class","step-done");
            step3.attr("class","step-done");
            step4.attr("class","step-done");
            step5.attr("class","step-end step-done");
        }
    });
</script>

</body>

</html>
