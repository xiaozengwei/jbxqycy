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
    <link rel="stylesheet" href="<%=basePath %>gx/mobile/css/swipeslider.css">

    <script src="<%=basePath %>gx/jquery-weui/lib/jquery-2.1.4.js"></script>
    <script src="<%=basePath %>gx/jquery-weui/lib/fastclick.js"></script>
    <script src="<%=basePath %>gx/jquery-weui/js/jquery-weui.js"></script>
    <script src="<%=basePath %>gx/mobile/js/swipeslider.min.js"></script>

</head>

<body ontouchstart>

<header>
    <div class="div-title">
        <a href="<%=basePath %>mobile/water-electric.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">水电账单信息</span>
    </div>
</header>
<c:forEach items="${sdMonthBillList}" var="sdMonthBill">
    <div style="height: 30px;">
        <span style="line-height: 30px;font-size: 13px;font-weight: bold;">${sdMonthBill.roomId}</span>
    </div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">月份</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" type="text" value="${sdMonthBill.year}年${sdMonthBill.month}月">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">当月水消耗</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="yktId" type="text" value="${sdMonthBill.monthWaterUse}&nbsp;吨">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">当月水费</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="userName" type="text" value="${sdMonthBill.monthWaterFee}&nbsp;元">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">当月电消耗</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="userIdCard" type="text" value="${sdMonthBill.monthElectricUse}&nbsp;度">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">当月电费</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="userIdCard" type="text" value="${sdMonthBill.monthElectricFee}&nbsp;元">
            </div>
        </div>
    </div>
</c:forEach>


<script>
    $(function() {
        FastClick.attach(document.body);
    });
</script>

</body>

</html>