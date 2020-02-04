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
        <span class="span-title">会议室租赁申请进度</span>
    </div>
</header>
<div class="step">
    <div style="width:100%; height:100px;text-align: center;margin-top: 10px">
        <ol class="ui-step ui-step-blue ui-step-3" style="width:90%;height:100px">
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
                    <span class="ui-step-cont-text">会务服务部审核</span>
                </div>
            </li>
            <li class="step-end" id="step3">
                <div class="ui-step-line"></div>
                <div class="ui-step-cont">
                    <span class="ui-step-cont-number">3</span>
                    <span class="ui-step-cont-text">结束</span>
                </div>
            </li>
        </ol>
    </div>
</div>
<div class="weui-cells__title"><span style="color: blue;">申请信息</span></div>
<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">姓名</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" value="${meetingRoomLeaseApply.applicantName}" type="text" placeholder="请输入姓名">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">身份证</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" value="${meetingRoomLeaseApply.applicantIdCard}" type="text">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">手机号</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" value="${meetingRoomLeaseApply.applicantPhone}" type="tel" placeholder="请输入联系人手机号">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">公司名称</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" value="${meetingRoomLeaseApply.companyName}" type="text" placeholder="请输入公司名称">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">开始时间</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10 time" value="<fmt:formatDate value="${meetingRoomLeaseApply.startTime}" pattern="yyyy-MM-dd HH:mm" />" id="time" type="text" value="">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">结束时间</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10 time" value="<fmt:formatDate value="${meetingRoomLeaseApply.endTime}" pattern="yyyy-MM-dd HH:mm" />" type="text" value="">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">选择会议室</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" value="${meetingRoomLeaseApply.selectedRoom}" type="text" placeholder="请选择会议室">
        </div>
    </div>
</div>
<div class="weui-cells__title"><span style="color: blue;">增值服务</span></div>
<div class="weui-cells" >
    <c:if test="${hysZzfw.teaNum > 0}">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>绿茶&nbsp;&nbsp;10元/杯</p>
            </div>
            <div class="weui-cell__ft">
                数量：${hysZzfw.teaNum}
            </div>
        </div>
    </c:if>
    <c:if test="${hysZzfw.waterNum > 0}">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>怡宝小瓶矿泉水&nbsp;&nbsp;70元/箱</p>
            </div>
            <div class="weui-cell__ft">
                数量：${hysZzfw.waterNum}
            </div>
        </div>
    </c:if>
    <c:if test="${hysZzfw.artisanNum > 0}">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>信息化技术人员&nbsp;&nbsp;1000元/天</p>
            </div>
            <div class="weui-cell__ft">
                数量：${hysZzfw.artisanNum}
            </div>
        </div>
    </c:if>
    <c:if test="${hysZzfw.ceremonyNum > 0}">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>礼仪服务&nbsp;&nbsp;300元/人/天</p>
            </div>
            <div class="weui-cell__ft">
                数量：${hysZzfw.ceremonyNum}
            </div>
        </div>
    </c:if>
    <c:if test="${hysZzfw.matNum > 0}">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>席卡&nbsp;&nbsp;5元/张</p>
            </div>
            <div class="weui-cell__ft">
                数量：${hysZzfw.matNum}
            </div>
        </div>
    </c:if>
    <c:if test="${hysZzfw.printNum > 0}">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>打印费用&nbsp;&nbsp;1元/张</p>
            </div>
            <div class="weui-cell__ft">
                数量：${hysZzfw.printNum}
            </div>
        </div>
    </c:if>
    <c:if test="${hysZzfw.cxLuxuryNum > 0}">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>茶歇豪华&nbsp;&nbsp;78元/人</p>
            </div>
            <div class="weui-cell__ft">
                数量：${hysZzfw.cxLuxuryNum}
            </div>
        </div>
    </c:if>
    <c:if test="${hysZzfw.cxHighNum > 0}">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>茶歇高档&nbsp;&nbsp;68元/人</p>
            </div>
            <div class="weui-cell__ft">
                数量：${hysZzfw.cxHighNum}
            </div>
        </div>
    </c:if>
    <c:if test="${hysZzfw.cxRoutineNum > 0}">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>茶歇常规&nbsp;&nbsp;58元/人</p>
            </div>
            <div class="weui-cell__ft">
                数量：${hysZzfw.cxRoutineNum}
            </div>
        </div>
    </c:if>
</div>
<div class="weui-cells__title"><span style="color: blue;">会务服务部审核</span></div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;">
            <c:choose>
                <c:when test="${actInstance.actInstRemark == null}" >
                    正在审核中
                </c:when>
                <c:otherwise>
                    ${actInstance.actInstRemark}
                </c:otherwise>
            </c:choose>
        </p>
    </a>
</div>
<div class="button_sp_area" align="center">
    <a href="<%=basePath %>mobile/hys-progress-list.do" class="weui-btn weui-btn_primary" style="background-color: #387ef8;">返回</a>
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
        if(instanceState == "申请"){
            step1.attr("class","step-start step-done");
            step2.attr("class","");
            step3.attr("class","step-end");
        }else if(instanceState == "会务服务部审核"){
            step1.attr("class","step-start step-done");
            step2.attr("class","step-done");
            step3.attr("class","step-end");
        }else{//结束
            step1.attr("class","step-start step-done");
            step2.attr("class","step-done");
            step3.attr("class","step-end step-done");
        }
    });
</script>

</body>

</html>
