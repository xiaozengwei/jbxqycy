<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录</title>
    <link type="text/css" href="<%=path %>/gx/inside-login/css/js_yhzc_01.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<%=path %>/gx/inside-login/css/yhzc_gr.css">
<style>
#sendMobileCodeTime{
    display: block;
    width: 180px;
    height: 45px;
    position: absolute;
    top: 0px;
    left: 655px;
    background-color: #A5A599;
    border: none;
    font-size: 15px;
    line-height: 49px;
    color: #fff;
    text-align: center;
}
.c2 {
    float: left;
    width: 300px;
    height: 30px;
    position: relative;
	background:#f2f2f2;
}
.code_deg {
    float: left;
    width: 100px;
    height: 30px;
    border-right: 1px solid #d9d9d9;
    font-size: 15px;
    line-height: 30px;
    color: #fff;
    text-align: center;
}
</style>
<script type="text/javascript">
function loginValidate(){
	var username = $("#username").val();
	var pwd = $("#pwd").val();
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "<%=path %>/inside-login/form-validate.do",
        data: $("#loginform").serialize(),
        success: function (result) {
            if(result.statusCode == '200') {
            	
            }else{
            	alert("用户名或密码错误！");
            };
        },
        error : function() {
            alert("保存失败！");
        }
    });
}
</script>
 </head>
  <body style="background: #f2f2f2;position: relative;">
<!--top-->
<div class="top">
	<div class="top_main">
    	<div class="top_logo"><img src="<%=path %>/gx/inside-login/images/logo2.png"></div>
        <div class="top_tit"></div>
       
    </div>
</div>
<!--top-->

<!--主体部分-->
<div class="bt-main">
	<div class="zc_01 clearfloat">
        <div class="zc_01_02 clearfloat">
        	<div class="zc_01_21">用户登录</div>
            <p class="zc_01_22"><span></span></p>
        </div>
        <form action="" class="zc_01_03 clearfloat" id="loginform" method="post">
       		<div class="zc_01_31 clearfloat"  style="margin-top:80px;">
            	<span>用户名：<font color="#fe4242">*</font></span>
                <input id="username" name="username" type="text" placeholder="" maxlength="30">
            </div>
            <div class="zc_01_31 clearfloat">
            	<span>密码：<font color="#fe4242">*</font></span>
                <input id="pwd" name="pwd" type="password" value="" class="password1" maxlength="18" onkeyup="" onkeydown="" onpaste="return false" placeholder="">
            </div>
    		<div class="zc_01_31  verification_code clearfloat">
            	<span>图片验证码：<font color="#fe4242">*</font></span>
                <input id="" name="" type="text" style="width: 280px;" placeholder="请填写正确的图片验证码" maxlength="4">
                &nbsp;&nbsp;<img src="<%=path %>/gx/inside-login/images/timg.jpg" width="112" height="45">
            </div>
            <div class="zc_01_31 zc_01_33 clearfloat" style="margin-top:40px;">
                <input type="button" value="登录" class="next" onclick="loginValidate()">
                &nbsp;&nbsp;<a href="<%=path %>/inside-register/go-register.do">立即注册</a>
            </div>
        </form>
    </div>
</div>
<!--主体部分end--> 
<!--页脚开始-->
<div class="bt-footer" style="background: #cfcfcf;">
  <div class="bt-copyright">
    <div class="bt-copyright_02">
      <ul class="bt-copyright_21">
        <li class="clearfloat"><span>&nbsp;</span></li>
        <li class="clearfloat"><span>&nbsp;</span></li>
        <li class="clearfloat"><span style="text-align:center; display:inline-block; width:100%; color:#666; font-size:13px;">版权所有：南京市质量技术监督局 </span></li>
        <li class="clearfloat">&nbsp;</li>
      </ul>
      <div class="bt-copyright_22" ></div>
      <div class="bt-copyright_23">&nbsp;&nbsp;&nbsp;</div>
    </div>
    </div>
</div>
<!--页脚结束-->
</body>
</html>
