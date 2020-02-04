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
        <span class="span-title">会议室租赁申请</span>
    </div>
</header>
<form action="<%=basePath %>mobile/select-zzfw.do" method="post" id="hysForm">
    <input type="hidden" name="rowId" value="${meetingRoomLeaseApply.rowId}">
<div class="weui-cells__title"><span style="color: blue;">申请信息</span></div>
<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">姓名</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" type="text" name="applicantName" value="${meetingRoomLeaseApply.applicantName}" placeholder="请输入姓名">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">身份证</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="applicantIdCard" value="${meetingRoomLeaseApply.applicantIdCard}" type="text">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">手机号</label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="applicantPhone" value="${meetingRoomLeaseApply.applicantPhone}" type="tel" placeholder="请输入联系人手机号">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">公司名称</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" name="companyName" value="${meetingRoomLeaseApply.companyName}" type="text" placeholder="请输入公司名称">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">开始时间</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10 time" name="startTime" value="<fmt:formatDate value="${meetingRoomLeaseApply.startTime}" pattern="yyyy-MM-dd HH:mm" />" id="time" type="text" value="">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">结束时间</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10 time" name="endTime" value="<fmt:formatDate value="${meetingRoomLeaseApply.endTime}" pattern="yyyy-MM-dd HH:mm" />" type="text" value="">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">选择会议室</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input paddingLeft10" id="hys" name="selectedRoom" value="${meetingRoomLeaseApply.selectedRoom}" type="text" placeholder="请选择会议室">
        </div>
    </div>
</div>
<div class="button_sp_area" align="center">
    <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary" style="background-color: #387ef8;" id="submitId">确定</a>
    <a href="<%=basePath %>mobile/to-mobile-index.do" class="weui-btn weui-btn_mini weui-btn_default">取消</a>
</div>

</form>

<script>
    $(function() {
        FastClick.attach(document.body);
    });

    $(".time").datetimePicker({
        title: '开始时间',
        onChange: function (picker, values, displayValues) {
            console.log(values);
        }
    });

    $("#hys").select({
        title: "选择会议室",
        items: ["企业家俱乐部", "宣讲厅","大报告厅","会议室1","会议室2","会议室3","会议室4","路演厅"]
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
        $("#hysForm").submit();
    });
</script>

</body>

</html>
