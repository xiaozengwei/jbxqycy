<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>sd/sd-recharge.do" method="post" data-toggle="validate" data-reloadNavtab="false">
        <input type="hidden" name="rechargeType" value="${rechargeType}">
        <input type="hidden" name="payType" value="现金支付">
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td align="center"><h3>${rechargeType == '1' ? '水费充值' :'电费充值'}</h3></td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">房间号：</label>
                        <input type="text" name="roomId" data-rule="required">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">姓名：</label>
                        <input type="text" name="userName" data-rule="required">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">身份证号：</label>
                        <input type="text" name="userIdCard" data-rule="required">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">手机号：</label>
                        <input type="text" name="userPhone" data-rule="required">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">充值金额：</label>
                        <input name="rechargeMoney" type="text" data-rule="required">
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default">充值</button></li>
    </ul>
</div>