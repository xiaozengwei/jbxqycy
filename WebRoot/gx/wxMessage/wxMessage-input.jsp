<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<script type="text/javascript">

</script>
<div class="bjui-pageContent">
    <form action="<%=basePath%>wxMessage/wxMessage-save.do" id="wxMessage_input_form" class="pageForm" data-toggle="validate" data-reloadNavtab="true">
        <input name="rowId" type="hidden" value="${wxMessageRelease.rowId }"/>
        <table class="table table-condensed table-hover">
            <tbody style="text-align:center;">
             <tr>
                  <td colspan="2">
                    <h3>微信发布信息添加</h3>
                  </td>
             </tr>
             <tr style="margin:10px">
                 <td align="center">
                     <textarea rows="5" name="wxMessage" data-rule="required" style="width: 80%;">${wxMessageRelease.wxMessage}</textarea>
                 </td>
             </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="submit" class="btn-default" >保存</button></li>
        <li><button type="button" class="btn-close" >关闭</button></li>
    </ul>
</div>