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

<body ontouchstart style="background-color: #efefef;">

<header>
    <div class="div-title">
        <a href="<%=basePath %>mobile/index.do" class="a-title"><img src="<%=basePath %>gx/mobile/images/arrow.png" width="25px" align="left" style="margin-top: 10px;"></a>
        <span class="span-title">一卡通申请进度查询</span>
    </div>
</header>
<div class="weui-cells" style="font-size: 15px;">
    <c:choose>
        <c:when test="${fn:length(list) > 0}">
            <c:forEach items="${list }" var="vYktProcinst">
                <a class="weui-cell weui-cell_access" style="background-color: white; margin: 0.2em; border-radius: 10px;" href="<%=basePath %>mobile/to-ykt-view.do?rowId=${vYktProcinst.rowId}">
                    <div class="weui-cell__bd">
                        <p>${vYktProcinst.applicantName }</p>
                        <p>${vYktProcinst.companyName }</p>
                    </div>
                    <div class="weui-cell__ft"><fmt:formatDate value="${vYktProcinst.createTime }" pattern="yyyy-MM-dd" /></div>
                </a>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <div class="weui-msg">
                <div class="weui-msg__icon-area"><i class="weui-icon-info weui-icon_msg"></i></div>
                <div class="weui-msg__text-area">
                    <h2 class="weui-msg__title">暂无数据</h2>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
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