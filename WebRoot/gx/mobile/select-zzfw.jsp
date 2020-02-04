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
<form action="<%=basePath %>mobile/hys-submit.do" method="post" id="hysForm">
    <input type="hidden" name="meetRowId" value="${rowId}">
    <input type="hidden" name="rowId" value="${hysZzfw.rowId}">
    <div class="bd">
        <div class="page__bd">
            <div class="weui-cells__title">增值服务</div>
            <div class="weui-cells" style="font-size: 14px;">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>绿茶&nbsp;&nbsp;10元/杯</p>
                    </div>
                    <div class="weui-cell__ft">
                        <div class="weui-count">
                            <a class="weui-count__btn weui-count__decrease"></a>
                            <input class="weui-count__number" type="number" value="${hysZzfw.teaNum == null ? 0:hysZzfw.teaNum}" name="teaNum"/>
                            <a class="weui-count__btn weui-count__increase"></a>
                        </div>
                    </div>
                </div>
                <div class="weui-cells__title" style="font-size: 12px;margin-top: 0px;">友情提醒：茶水服务需同时选择增加现场服务人员，保障倒水及加水服务。茶水数量与服务人员数量可自选。</div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>怡宝小瓶矿泉水&nbsp;&nbsp;70元/箱</p>
                    </div>
                    <div class="weui-cell__ft">
                        <div class="weui-count">
                            <a class="weui-count__btn weui-count__decrease"></a>
                            <input class="weui-count__number" type="number" value="${hysZzfw.waterNum == null ? 0:hysZzfw.waterNum}" name="waterNum"/>
                            <a class="weui-count__btn weui-count__increase"></a>
                        </div>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>信息化技术人员&nbsp;&nbsp;1000元/天</p>
                    </div>
                    <div class="weui-cell__ft">
                        <div class="weui-count">
                            <a class="weui-count__btn weui-count__decrease"></a>
                            <input class="weui-count__number" type="number" value="${hysZzfw.artisanNum == null ? 0:hysZzfw.artisanNum}" name="artisanNum"/>
                            <a class="weui-count__btn weui-count__increase"></a>
                        </div>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>礼仪服务&nbsp;&nbsp;300元/人/天</p>
                    </div>
                    <div class="weui-cell__ft">
                        <div class="weui-count">
                            <a class="weui-count__btn weui-count__decrease"></a>
                            <input class="weui-count__number" type="number" value="${hysZzfw.ceremonyNum == null ? 0:hysZzfw.ceremonyNum}" name="ceremonyNum"/>
                            <a class="weui-count__btn weui-count__increase"></a>
                        </div>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>席卡&nbsp;&nbsp;5元/张</p>
                    </div>
                    <div class="weui-cell__ft">
                        <div class="weui-count">
                            <a class="weui-count__btn weui-count__decrease"></a>
                            <input class="weui-count__number" type="number" value="${hysZzfw.matNum == null ? 0:hysZzfw.matNum}" name="matNum"/>
                            <a class="weui-count__btn weui-count__increase"></a>
                        </div>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>打印费用&nbsp;&nbsp;1元/张</p>
                    </div>
                    <div class="weui-cell__ft">
                        <div class="weui-count">
                            <a class="weui-count__btn weui-count__decrease"></a>
                            <input class="weui-count__number" type="number" value="${hysZzfw.printNum == null ? 0:hysZzfw.printNum}" name="printNum"/>
                            <a class="weui-count__btn weui-count__increase"></a>
                        </div>
                    </div>
                </div>
                <div class="weui-cells__title">茶歇服务（50人起订）</div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>豪华&nbsp;&nbsp;78元/人</p>
                    </div>
                    <div class="weui-cell__ft">
                        <div class="weui-count">
                            <a class="weui-count__btn weui-count__decrease"></a>
                            <input class="weui-count__number" type="number" value="${hysZzfw.cxLuxuryNum == null ? 0:hysZzfw.cxLuxuryNum}" name="cxLuxuryNum"/>
                            <a class="weui-count__btn weui-count__increase"></a>
                        </div>
                    </div>
                </div>
                <div class="weui-cells__title" style="font-size: 12px;margin-top: 0px;">甜品：8款&nbsp;&nbsp;饮品：果汁一种、茶饮一种、咖啡两种&nbsp;&nbsp;果盘：4份</div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>高档&nbsp;&nbsp;68元/人</p>
                    </div>
                    <div class="weui-cell__ft">
                        <div class="weui-count">
                            <a class="weui-count__btn weui-count__decrease"></a>
                            <input class="weui-count__number" type="number" value="${hysZzfw.cxHighNum == null ? 0:hysZzfw.cxHighNum}" name="cxHighNum"/>
                            <a class="weui-count__btn weui-count__increase"></a>
                        </div>
                    </div>
                </div>
                <div class="weui-cells__title" style="font-size: 12px;margin-top: 0px;">甜品：6款&nbsp;&nbsp;饮品：果汁一种、茶饮一种、咖啡一种&nbsp;&nbsp;果盘：3份</div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>常规&nbsp;&nbsp;58元/人</p>
                    </div>
                    <div class="weui-cell__ft">
                        <div class="weui-count">
                            <a class="weui-count__btn weui-count__decrease"></a>
                            <input class="weui-count__number" type="number" value="${hysZzfw.cxRoutineNum == null ? 0:hysZzfw.cxRoutineNum}" name="cxRoutineNum"/>
                            <a class="weui-count__btn weui-count__increase"></a>
                        </div>
                    </div>
                </div>
                <div class="weui-cells__title" style="font-size: 12px;margin-top: 0px;">甜品：4款&nbsp;&nbsp;饮品：果汁一种、茶饮一种&nbsp;&nbsp;果盘：2份</div>
            </div>
        </div>
    </div>
<div class="button_sp_area" align="center">
    <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary" style="background-color: #387ef8;" id="submitId">提交</a>
    <a href="<%=basePath %>mobile/to-mobile-index.do" class="weui-btn weui-btn_mini weui-btn_default">取消</a>
</div>

</form>

<script>
    $(function() {
        FastClick.attach(document.body);
    })

    var MIN = 0;
    //减
    $('.weui-count__decrease').click(function (e) {
        var $input = $(e.currentTarget).parent().find('.weui-count__number');
        var number = parseInt($input.val() || "0") - 1;
        if (number < MIN) number = MIN;
        $input.val(number);
    })
    //加
    $('.weui-count__increase').click(function (e) {
        var $input = $(e.currentTarget).parent().find('.weui-count__number');
        var number = parseInt($input.val() || "0") + 1;
        $input.val(number)
    })

    $("#submitId").click(function() {
        $("#hysForm").submit();
    })
</script>

</body>

</html>
