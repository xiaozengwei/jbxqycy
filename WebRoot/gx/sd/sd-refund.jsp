<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>sd/sd-refund.do" method="post" data-toggle="validate" data-reloadNavtab="false">
        <input type="hidden" name="rowId" value="${sdRechargeRecord.rowId}">
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td align="center"><h3>${sdRechargeRecord.rechargeType == '1' ? '水费退款' :'电费退款'}</h3></td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">房间号：</label>
                        <input type="text" value="${sdRechargeRecord.roomId}" data-rule="required">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">充值金额：</label>
                        <input type="text" value="${sdRechargeRecord.rechargeMoney}" readonly>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">账户余额：</label>
                        <input type="text" value="${balance}" readonly>
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">退款金额：</label>
                        <input name="refundMoney" type="text" value="${balance < sdRechargeRecord.rechargeMoney ? balance : sdRechargeRecord.rechargeMoney}" readonly>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">退款原因：</label>
                        <input name="refundDesc" type="text" data-rule="required">
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default">退款</button></li>
    </ul>
</div>