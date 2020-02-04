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
        <span class="span-title">一卡通申请</span>
    </div>
</header>
<form action="<%=basePath %>mobile/ykt-save-gr.do" method="post" id="grYktForm">
    <input type="hidden" name="cardNumber" id="cardNumber" value="1">
    <input type="hidden" name="dataType" value="1">
    <div style="background-color: #f8f8f8;height: 40px;">
        <span style="line-height: 40px;color: #4a8ad1;font-size: 16px;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>申请信息</span>
    </div>
    <div class="weui-cells weui-cells_form" style="font-size: 16px;margin-top: 0px;">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">申请人姓名</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="applicantName" type="text" placeholder="请输入申请人姓名" />
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">身份证号</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="applicantIdCard" id="applicantIdCard" type="text" placeholder="请输入身份证号" />
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">手机号</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="applicantPhone" id="applicantPhone" type="text" placeholder="请输入手机号" />
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">公司名称</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="companyName" type="text" value="${enterpriseInfo.enterpriseName}"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">领取点位置</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="receivePlace" id="receivePlace" type="text" placeholder="请选择领取点位置">
            </div>
        </div>
    </div>

    <%--<div style="background-color: #f8f8f8;height: 40px;">
        <span style="line-height: 40px;color: #4a8ad1;font-size: 16px;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>办卡人员明细</span>
    </div>
    <div class="weui-cells weui-cells_form" style="font-size: 16px;margin-top: 0px;">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">姓名</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="oneCardList[0].userName" type="text" placeholder="请输入姓名" />
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">身份证号</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="oneCardList[0].userIdCard" type="text" placeholder="请输入身份证号" />
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">手机号</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input paddingLeft10" name="oneCardList[0].userPhone" type="tel" placeholder="请输入手机号" />
            </div>
        </div>
    </div>
    <div style="height: 35px;" id="addRoom">
        <img src="<%=basePath %>gx/mobile/images/img_add.png" width="25px" alt="" onclick="addOne()" style="margin-left: 10px;margin-top: 5px;">
        <img src="<%=basePath %>gx/mobile/images/img_del.png" width="25px" alt="" onclick="deleteOne()" style="margin-left: 5px;margin-top: 5px;">
    </div>--%>

    <%--<div style="background-color: #f8f8f8;height: 40px;">
        <span style="line-height: 40px;color: #4a8ad1;font-size: 16px;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>文件上传</span>
    </div>
    <div id="fileDiv">
        <div style="width: 100%;height: 30px;">
            <table style="width: 100%;height: 100%;">
                <tr>
                    <td align="right">
                        <input id="upload-file-list" type="text" style="border: 1px solid #ccc; height: 28px;width: 98%;" readonly/>
                        <input type="hidden" id="form_attachmentId" name="attachmentId" />
                    </td>
                    <td style="width: 130px;">
                        <button id="pickfiles" style="width: 60px;height: 30px;border-radius: 5px;background-color: #377df6;color: white;border: 0px;" type="button">浏览</button>
                        <button id="uploadfiles" style="width: 60px;height: 30px;border-radius: 5px;background-color: #377df6;color: white;border: 0px;" type="button">上传</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>--%>

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
            items: ["孵鹰大厦C座2楼206","光电科技园C座1楼物业办公室","浦潮创展大厦B座1楼大厅"]
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
        var zz_sfz = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
        if(!zz_sfz.test($("#applicantIdCard").val())){
            $.toptip('身份证号格式填写不正确！', 'warning');
            return;
        }
        var zz_sjh = /^(1[3-9])\d{9}$/;
        if(!zz_sjh.test($("#applicantPhone").val())){
            $.toptip('手机号格式填写不正确！', 'warning');
            return;
        }
        $("#grYktForm").submit();
    });


    /*添加一个人员*/
    //    function addOne(){
    //        var cardNumber = parseInt($("#cardNumber").val());
    //        if(cardNumber == 5){
    //            $.toptip('最多只能添加5个人员', 'warning');
    //        }else{
    //            $("#addRoom").before('<div class="weui-cells weui-cells_form" style="font-size: 16px;margin-top: 5px;" id="oneCard_'+cardNumber+'">\n' +
    //                '        <div class="weui-cell">\n' +
    //                '            <div class="weui-cell__hd"><label class="weui-label">姓名</label></div>\n' +
    //                '            <div class="weui-cell__bd">\n' +
    //                '                <input class="weui-input paddingLeft10" name="oneCardList['+cardNumber+'].userName" type="text" placeholder="请输入姓名" />\n' +
    //                '            </div>\n' +
    //                '        </div>\n' +
    //                '        <div class="weui-cell">\n' +
    //                '            <div class="weui-cell__hd"><label class="weui-label">身份证号</label></div>\n' +
    //                '            <div class="weui-cell__bd">\n' +
    //                '                <input class="weui-input paddingLeft10" name="oneCardList['+cardNumber+'].userIdCard" type="text" placeholder="请输入身份证号" />\n' +
    //                '            </div>\n' +
    //                '        </div>\n' +
    //                '        <div class="weui-cell">\n' +
    //                '            <div class="weui-cell__hd">\n' +
    //                '                <label class="weui-label">手机号</label>\n' +
    //                '            </div>\n' +
    //                '            <div class="weui-cell__bd">\n' +
    //                '                <input class="weui-input paddingLeft10" name="oneCardList['+cardNumber+'].userPhone" type="tel" placeholder="请输入手机号" />\n' +
    //                '            </div>\n' +
    //                '        </div>\n' +
    //                '    </div>');
    //            //人员数量+1
    //            $("#cardNumber").val(cardNumber+1);
    //            console.log(cardNumber);
    //        }
    //    }

    /*删除一个人员*/
    //    function deleteOne(){
    //        var cardNumber = parseInt($("#cardNumber").val());
    //        console.log(cardNumber);
    //        if(cardNumber >1){
    //            cardNumber = cardNumber - 1;
    //            $("#oneCard_"+cardNumber).remove();
    //            $("#cardNumber").val(cardNumber);
    //        }else{
    //            $.toptip('仅剩一个人员，无法删除', 'warning');
    //        }
    //    }

</script>

</body>

</html>
