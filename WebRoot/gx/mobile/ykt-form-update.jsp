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
        <span class="span-title">一卡通办理</span>
    </div>
</header>
<form action="<%=basePath %>/mobile/ykt-save.do" method="post" id="yktForm">
    <input type="hidden" name="cardNumber" id="cardNumber" value="${model.cardNumber}">
    <input type="hidden" name="rowId" value="${model.rowId}">
    <div style="background-color: #f8f8f8;height: 40px;">
        <span style="line-height: 40px;color: #4a8ad1;font-size: 16px;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>申请信息</span>
    </div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">申请人姓名</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="applicantName" value="${model.applicantName}" type="text"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">身份证号</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="applicantIdCard" value="${model.applicantIdCard}" type="text"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">手机号</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="applicantPhone" value="${model.applicantPhone}" type="text"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">公司名称</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="companyName" value="${model.companyName}" type="text"/>
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
                <c:forEach items="${oneCardPersonList}" var="person" varStatus="status">
                    <tr>
                        <td style="width: 20%;text-align: center;">
                            <input type="hidden" name="oneCardList[${status.index}].rowId" value="${person.rowId}" style="width: 98%;">
                            <input type="text" name="oneCardList[${status.index}].userName" value="${person.userName}" style="width: 98%;">
                        </td>
                        <td style="width: 50%;text-align: center;"><input type="text" name="oneCardList[${status.index}].userIdCard" value="${person.userIdCard}"  style="width: 98%;"></td>
                        <td style="width: 30%;text-align: center;"><input type="text" name="oneCardList[${status.index}].userPhone" value="${person.userPhone}"  style="width: 98%;"></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>

    <div class="button_sp_area" align="center">
        <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary" style="background-color: #387ef8;" id="submitId">保存</a>
        <a href="<%=basePath %>mobile/to-mobile-index.do" class="weui-btn weui-btn_mini weui-btn_default">取消</a>
    </div>

</form>

<script>
    $(function() {
        FastClick.attach(document.body);

        $("#receivePlace").select({
            title: "领取点位置",
            items: ["孵鹰大厦A座","孵鹰大厦B座","孵鹰大厦C座","孵鹰大厦D座","腾飞大厦A座","腾飞大厦B座","腾飞大厦C座","光电科技园C座1楼物业办公室","浦潮创展大厦B座1楼大厅"]
        });

    });

    //提交表单
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
        $("#yktForm").submit();
    });

</script>

</body>

</html>
