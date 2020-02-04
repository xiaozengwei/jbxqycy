<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>sd/check-out-save.do" method="post" data-toggle="validate" data-reloadNavtab="false">
        <input name="waterMeterNum" id="waterMeterNum" value="${waterMeterNum}" type="hidden">
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td align="center"><h3>退房</h3></td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">房间号：</label>
                        <input type="text" name="roomId" value="${model.roomId}" data-rule="required" style="width: 180px;">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">姓名：</label>
                        <input type="text" name="userName" value="${model.userName}" style="width: 180px;">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">身份证号：</label>
                        <input type="text" name="userIdCard" value="${model.userIdCard}" style="width: 180px;">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">手机号：</label>
                        <input type="text" name="userPhone" value="${model.userPhone}" style="width: 180px;">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">电费余额：</label>
                        <input type="text" name="electricBalance" id="electricBalance" value="${model.electricBalance}" data-rule="required" style="width: 180px;">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">水费余额：</label>
                        <input type="text" name="waterBalance" id="waterBalance" value="${model.waterBalance}" data-rule="required" style="width: 180px;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">水表数值：</label>
                        <input type="text" name="waterNumberOne" id="waterNumberOne" value="${model.waterNumberOne}" data-rule="required" style="width: 180px;">
                    </td>
                </tr>
                <c:if test="${waterMeterNum == 2}">
                    <tr>
                        <td>
                            <label class="control-label x90">水表2数值：</label>
                            <input type="text" name="waterNumberTwo" id="waterNumberTwo" value="${model.waterNumberTwo}" data-rule="required" style="width: 180px;">
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <label class="control-label x90">抄表时间：</label>
                        <input type="text" name="cbTime" value="<fmt:formatDate value="${model.cbTime}" pattern="yyyy-MM-dd"></fmt:formatDate>" data-toggle="datepicker" style="width: 180px;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">上次水表数值：</label>
                        <input type="text" name="lastWaterNumberOne" id="lastWaterNumberOne" value="${model.lastWaterNumberOne}" data-rule="required" style="width: 180px;">
                    </td>
                </tr>
                <c:if test="${waterMeterNum == 2}">
                    <tr>
                        <td>
                            <label class="control-label x90">上次水表2数值：</label>
                            <input type="text" name="lastWaterNumberTwo" id="lastWaterNumberTwo" value="${model.lastWaterNumberTwo}" data-rule="required" style="width: 180px;">
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <label class="control-label x90">上次抄表时间：</label>
                        <input type="text" name="lastCbTime" value="<fmt:formatDate value="${model.lastCbTime}" pattern="yyyy-MM-dd"></fmt:formatDate>" data-toggle="datepicker" style="width: 180px;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">用水量：</label>
                        <input type="text" name="waterUse" id="waterUse" value="${model.waterUse}" data-rule="required" style="width: 180px;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">退款金额：</label>
                        <input type="text" name="refundMoney" id="refundMoney" value="${model.refundMoney}" data-rule="required" style="width: 180px;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">补缴金额：</label>
                        <input type="text" name="backMoney" id="backMoney" value="${model.backMoney}" data-rule="required" style="width: 180px;">
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
    </ul>
</div>