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
        <span class="span-title">水费充值</span>
    </div>
</header>
<div style="margin-top: 20px;">
    <form action="" method="post" id="dfForm">
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">房间号</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input paddingLeft10" name="roomId" type="text" value="${roomId}" placeholder="请输入房间号">
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">充值金额</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input paddingLeft10" name="money" type="text" placeholder="请输入充值金额">
                </div>
            </div>
            <div class="weui-cell">
                <p style="text-align: left;font-size: 12px;color: #a4a1a1;">
                    温馨提示：充值前请先绑定并确认房间号，以防充错账户。
                </p>
            </div>
        </div>
    </form>
    <div class="weui-btn-area">
        <a href="javascript:;" class="weui-btn weui-btn_primary" id="dfPay">立即充值</a>
    </div>
</div>

<style>

</style>

<script>

    var appId;
    var timeStamp;
    var nonceStr;
    var package;
    var signType;
    var paySign;

    $("#dfPay").click(function() {
        $.ajax({
            url : '<%=path %>/mobile/df-recharge.do',
            type : 'post',
            data : $("#dfForm").serialize(),
            success : function(json) {
                if (json.statusCode == '200') {
                    appId = result.appId;
                    timeStamp = result.timeStamp;
                    nonceStr = result.nonceStr;
                    package = result.package;
                    signType = result.signType;
                    paySign = result.paySign;
                    if (typeof WeixinJSBridge == "undefined"){
                        if( document.addEventListener ){
                            document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
                        }else if (document.attachEvent){
                            document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                            document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
                        }
                    }else{
                        onBridgeReady();
                    }
                }else{
                    console.log("获取数据失败！");
                }
            }
        });
    });

    /**
     * 微信内H5调起支付
     */
    function onBridgeReady(){
        WeixinJSBridge.invoke(
            'getBrandWCPayRequest', {
                "appId":appId,     //公众号名称，由商户传入
                "timeStamp":timeStamp,         //时间戳，自1970年以来的秒数
                "nonceStr":nonceStr, //随机串
                "package":package,
                "signType":signType,         //微信签名方式：
                "paySign":paySign //微信签名
            },
            function(res){
                if(res.err_msg == "get_brand_wcpay_request:ok" ){
                    // 使用以上方式判断前端返回,微信团队郑重提示：
                    //res.err_msg将在用户支付成功后返回ok，但并不保证它绝对可靠。
                    console.log("pay success")
                    //跳转到支付成功页面
                    window.location.href ="<%=path %>/mobile/wx-pay-success.do";
                }else{
                    console.log("pay fail");
                    $.toptip('支付失败', 'error');
                }
            });
    }

    $(function() {
        FastClick.attach(document.body);
        $("#full_feature").swipeslider();
    });

</script>

</body>

</html>