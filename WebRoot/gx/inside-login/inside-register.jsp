<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户注册</title>
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
        	<div class="zc_01_21">账号填写</div>
            <p class="zc_01_22"><span>以下带<font color="#fe4242">*</font>为必填项</span></p>
        </div>
        <form  class="zc_01_03 clearfloat" id="" method="post">
       
       		<div class="zc_01_31 clearfloat">
            	<span>用户名：<font color="#fe4242">*</font></span>
                <input id="" type="text" placeholder="长度为4-30个字符，支持字母和数字组成，字母开头" maxlength="30">
            </div>
            <div class="zc_01_31 clearfloat">
            	<span>密码：<font color="#fe4242">*</font></span>
                <input type="password" value="" class="password1" id="" maxlength="18" onkeyup="" onkeydown="" onpaste="return false" placeholder="长度为6-18个字符，强度要求中">
            </div>

            <div class="zc_01_31 clearfloat">
            	<span>确认密码：<font color="#fe4242">*</font></span>
                <input type="password" value="" class="password2" id="" maxlength="18" placeholder="两次密码必须一致">
            </div>
   <div class="zc_01_31 clearfloat">
            	<span>姓名：<font color="#fe4242">*</font></span>
                <input id="" type="text" placeholder="请输入您的姓名" maxlength="30">
            </div>
              <div class="zc_01_31 clearfloat">
            	<span>手机号：<font color="#fe4242">*</font></span>
                <input id="" type="text" placeholder="请输入您的手机号" maxlength="30">
            </div>
             <div class="zc_01_31 clearfloat">
            	<span>身份证号：<font color="#fe4242">*</font></span>
                <input id="" type="text" placeholder="请输入您的身份证号" maxlength="30">
            </div>
    <div class="zc_01_31  verification_code clearfloat">
            	<span>图片验证码：<font color="#fe4242">*</font></span>
                <input id="" name="" type="text" style="width: 280px;" placeholder="请填写正确的图片验证码" maxlength="4">
               &nbsp;&nbsp;<img src="<%=path %>/gx/inside-login/images/timg.jpg" width="112" height="45">
            </div>
           
            <div class="zc_01_31 zc_01_33 clearfloat">
                <input type="submit" value="注册" class="next">
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
