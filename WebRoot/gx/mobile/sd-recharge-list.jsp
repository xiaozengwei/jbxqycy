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
<script type="text/javascript">
    function refund(rowId){
        window.location.href = "<%=basePath %>mobile/to-refund-confirm.do?rowId="+rowId;
    }
</script>

<body ontouchstart style="background-color: #efefef;">

<header>
    <div class="div-title">
        <a href="<%=basePath %>mobile/water-electric.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">水电充值记录</span>
    </div>
</header>
<div class="weui-cells" >
    <c:forEach items="${list}" var="model">
        <div class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;padding: 10px 10px;" href="">
            <div class="weui-cell__bd">
                <div style="height: 40px;width: 80%;float: left;">
                    <p style="font-size: 0.6em;white-space: nowrap;text-overflow: ellipsis;overflow: hidden;">充值时间：<span style="color: #a4a1a1;"><fmt:formatDate value="${model.rechargeTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></span></p>
                    <p style="font-size: 0.6em;margin-top: 10px;">充值金额：<span style="color: #a4a1a1;">${model.rechargeMoney}&nbsp;元</span></p>
                </div>
                <%--<div style="float: left;width: 20%;height: 40px;">
                    <input type="button" style="width: 50px;height: 30px;" value="退款" onclick="refund('${model.rowId}')" disabled>
                </div>--%>
            </div>
        </div>
    </c:forEach>
</div>
<style>

</style>

<script>
    $(function() {
        FastClick.attach(document.body);
    });
</script>

</body>

</html>
