<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>electric/reduce.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="type" id="type" value=${type}>
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td align="center"><h3>${type eq 'electric' ?'电':'水'}扣费</h3></td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">房间号：</label>
                    <input type="text" name="roomName" data-rule="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">金额：</label>
                    <input type="text" name="money" data-rule="required">
                </td>

            </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default">扣费</button></li>
    </ul>
</div>