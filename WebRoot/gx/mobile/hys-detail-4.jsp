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
    <img src="<%=basePath %>gx/mobile/hys-img/hys1-1.jpg" width="100%" alt="">
</header>
<div style="height: 30px;font-size: 15px;">
    <h4>会议室1</h4>
</div>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>基本信息</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 55%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_jzmj.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">建筑面积：<span style="color: #a4a1a1;">80m²</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 45%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_cc.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">长度*宽度：<span style="color: #a4a1a1;">8.8m*9m</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 55%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_pm.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">屏幕尺寸：<span style="color: #a4a1a1;">2656mm*1494mm</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 45%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_fbl.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">分辨率：<span style="color: #a4a1a1;">1280*800</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_cdf.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">场地费&nbsp;&nbsp;全天：<span style="color: #a4a1a1;">1500元</span>&nbsp;&nbsp;半天：<span style="color: #a4a1a1;">900元</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_zk.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">园区六折：&nbsp;&nbsp;全天：<span style="color: #a4a1a1;">900元</span>&nbsp;&nbsp;半天：<span style="color: #a4a1a1;">600元</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_rnrs.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">容纳人数&nbsp; &nbsp;课桌式：<span style="color: #a4a1a1;">/</span>&nbsp; &nbsp;剧院式：<span style="color: #a4a1a1;">/</span>&nbsp; &nbsp;U型：<span style="color: #a4a1a1;">19人</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_wz.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">位置：<span style="color: #a4a1a1;">华创路与江淼路交叉口西南100米腾飞大厦4楼401</span>
        </p>
    </a>
</div>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>增值服务</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 50%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_cs.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">茶水：<span style="color: #a4a1a1;">10元/杯</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 50%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_kqs.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">矿泉水：<span style="color: #a4a1a1;">70元/箱怡宝小瓶</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 50%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_jsry.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">信息化技术人员：<span style="color: #a4a1a1;">1000元/场</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 50%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_fwry.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">现场服务人员：<span style="color: #a4a1a1;">300元/人/场</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 50%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_xk.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">席卡：<span style="color: #a4a1a1;">5元/张</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 50%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_dy.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">打印费用：<span style="color: #a4a1a1;">1元/张</span>
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p class="weui-grid__label" style="text-align: left;font-size: 12px;">
            <img src="<%=basePath %>gx/mobile/images/img_zy.png" width="20px" alt="" align="absmiddle" style="margin-right: 5px;">桌椅摆放：<span style="color: #a4a1a1;">500元/场</span>
        </p>
    </a>
</div>
<div style="height: 30px;">
    <span style="line-height: 30px;font-size: 13px;font-weight: bold;"><span style="border-left:3px #5b93ee solid;line-height:18px;display: inline-block;width: 5px;margin-left: 5px;">&nbsp;</span>会议室使用守则</span>
</div>
<div class="weui-grids">
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;">
            1、园区企业，打款及时，信誉良好，会议室使用得当，可申请6.0折折扣
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;">
            2、腾飞大厦4楼报告厅及腾飞大厦2楼报告厅的场租包含专业技术人员一名，即电脑控制屏幕切换等，其他会议室场租费不包含专业技术人员
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;">
            3、有色饮料，茶歇，食品禁止进入会场，如发现，可开具罚单200元/次，如造成地毯污渍或损坏按实价赔偿
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;">
            4、会场内禁止吸烟、吐痰、乱扔果皮纸屑，如发现，可开具罚单200元/次，如造成地毯污渍或损坏按实价赔偿
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;">
            5、会场桌椅如需另外摆放，可自行解决，会后恢复原样即可，也可添加增值服务，由工作人员摆放
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;">
            6、会场可提前预定，按照预定顺序安排会议。以会议当日计算，最迟需在之前第三个工作日打款，如若延迟视为自动取消会议
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;">
            7、会场内所有设备仪器，灯光空调都包含于场租费内，不再额外收费
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;">
            8、会议室使用时间为9:00-17:00，全天8小时，半天4小时，超出时间按每小时300元场租费计算，其他附加服务另算
        </p>
    </a>
    <a class="weui-grid js_grid" style="padding:5px 5px;width: 100%;">
        <p style="text-align: left;font-size: 12px;color: #a4a1a1;">
            9、茶水服务需要同时增加现场服务人员，保障倒水及加水服务，服务人员数量与茶水数量可自定
        </p>
    </a>
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
