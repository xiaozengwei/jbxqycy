<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<script type="text/javascript">
</script>
<div class="bjui-pageContent">
    <form action="<%=basePath%>ykt/enterprise-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input name="rowId" id="rowId" value="${model.rowId}" type="hidden">
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td align="center"><h3>企业信息</h3></td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">企业名称：</label>
                        <input type="text" name="enterpriseName" value="${model.enterpriseName}" data-rule="required" style="width: 200px;">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">账号：</label>
                        <input type="text" name="enterpriseId" value="${model.enterpriseId}" data-rule="required" style="width: 200px;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">密码：</label>
                        <input type="text" name="password" value="${model.password == null ? 'njsp123456':model.password}" data-rule="required" style="width: 200px;">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">地址：</label>
                        <input type="text" name="orgAddress" value="${model.orgAddress}" style="width: 200px;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">楼层：</label>
                        <input type="text" name="floorNum" value="${model.floorNum}" style="width: 200px;">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">联系人姓名：</label>
                        <input type="text" name="contactName" value="${model.contactName}" style="width: 200px;">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">联系电话：</label>
                        <input type="text" name="contactPhone" value="${model.contactPhone}" style="width: 200px;">
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