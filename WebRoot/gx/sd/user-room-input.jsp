<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>sd/room-bind-save.do" method="post" data-toggle="validate" data-reloadNavtab="false">
    <input type="hidden" name="rowId"  value="${model.rowId}" />
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td  align="center"><h3>房间绑定</h3></td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">房间号：</label>
                        <input type="text" name="roomId"  value="${model.roomId}" data-rule="required" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">姓名：</label>
                        <input type="text" name="userName"  value="${model.userName}" data-rule="required" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">身份证号：</label>
                        <input type="text" name="userIdCard"  value="${model.userIdCard}" data-rule="required" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">手机号：</label>
                        <input type="password" name="userPhone"  value="${model.userPhone}" data-rule="required" >
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">入住时间：</label>
                        <input name="inTime" value="${model.inTime}" type="text" data-toggle="datepicker" data-pattern="yyyy-MM-dd" readonly>
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">到期时间：</label>
                        <input name="outTime" value="${model.outTime}" type="text" data-toggle="datepicker" data-pattern="yyyy-MM-dd" readonly>
                    </td>
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