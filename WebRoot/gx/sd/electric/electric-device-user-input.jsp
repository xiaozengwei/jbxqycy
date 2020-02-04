<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>electric/user-room-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId"  value="${model.rowId}" >
        <input type="hidden" name="roomId" value="${roomId}">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>用户绑定</h3></td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">手机号：</label>
                    <input type="text" name="userMobileNum"  value="${model.userMobileNum}" data-toggle="lookup" data-url="<%=basePath %>electric/lookup-user-list.do" data-rule="required" size="20" data-title="选择人员">
                </td>
            </tr>

                <td>
                    <label class="control-label x90">审核状态：</label>
                    <select name="statu" id="j_dialog_statetype" data-toggle="selectpicker" size="30">
                        <option value="0" ${model.statu eq '0' ? 'selected="selected"':'' }>未审核</option>
                        <option value="1" ${model.statu eq '1' ? 'selected="selected"':'' }>已审核</option>
                    </select>
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