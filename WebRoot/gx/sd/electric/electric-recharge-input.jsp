<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>electric/recharge-save.do" method="post" data-toggle="validate" data-reloadNavtab="false">
        <input type="hidden" name="deviceId"  value="${model.deviceId}" >
        <input type="hidden" name="opt" value="${opt}">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>${opt eq 'recharge'?'充值':'扣费'}</h3></td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">房间号：</label>
                    <input type="text" name="rowName"  value="${model.rowName}" data-rule="required" size="20" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">余额：</label>
                    <input type="text" name="balance"  value="${balance}" data-rule="required" size="20" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">${opt eq 'recharge'?'充值金额':'扣费金额'}：</label>
                    <input type="text" name="money" data-rule="required" size="20">
                </td>
            </tr>

            </tr>

            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default">保存</button></li>
    </ul>
</div>