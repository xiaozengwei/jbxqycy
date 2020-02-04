<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>check/check-reduce.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td align="center"><h3>退费</h3></td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">房间号：</label>
                    <input type="text" name="roomName" value="${checkOutAmountRecord.roomName}" data-rule="required" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">姓名：</label>
                    <input type="text" name="userName" value="${checkOutAmountRecord.userName}"  readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">身份证：</label>
                    <input type="text" name="userIdCard" value="${checkOutAmountRecord.userIdCard}" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">手机：</label>
                    <input type="text" name="userPhone" value="${checkOutAmountRecord.userPhone}" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">电余额：</label>
                    <input type="text" name="electricBalance" value="${checkOutAmountRecord.electricBalance}" data-rule="required" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">水费用：</label>
                    <input type="text" name="waterMoney" value="${checkOutAmountRecord.waterMoney}" data-rule="required">
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default">退费</button></li>
    </ul>
</div>