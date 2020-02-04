<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">

<script type="text/javascript">
$("#otime").datepicker({
	pattern:'yyyy-MM-dd HH:mm:ss',
});
</script>

<div class="bjui-pageContent">
    <form action="<%=basePath%>fp-operation/op-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
    	<input type="hidden" name="rowId" value="${model.rowId}"/>
        <table class="table-bordered table-condensed">
            <tbody>
                <tr >
                    <td  align="center"><h2>操作日志信息</h2></td>
                </tr>
                
                <tr>
                	<td  >
                        <label class="control-label x120">主要记录：</label>
                        <input type="text" name="MRecord"  value="${model.MRecord}" data-rule="required" size="60">
                    </td>
                </tr>
                 <tr>
                    <td  >
                        <label class="control-label x120">模块名称：</label>
                        <input type="text" name="MModel"  value="${model.MModel}" data-rule="required" size="60">
                    </td>
                </tr>
                 <tr>
                    <td  >
                       <label class="control-label x120">操作人id：</label>
                        <input type="text" name="MUserid"  value="${model.MUserid}" data-rule="required" size="60">
                    </td>
                </tr>
                
                <tr>
                    <td  >
                        <label class="control-label x120">操作人姓名：</label>
                        <input type="text" name="MUsername"  value="${model.MUsername}" data-rule="required" size="60">
                    </td>
                </tr>
                
                 <tr>
                    <td  >
                        <label class="control-label x120">所属组织ID：</label>
                        <input type="text" name="MOrgId"  value="${model.MOrgId}" data-rule="required" size="60">
                    </td>
                </tr>
                
                 <tr>
                    <td  >
                        <label class="control-label x120">所属组织姓名：</label>
                        <input type="text" name="MOrgName"  value="${model.MOrgName}" data-rule="required" size="60">
                    </td>
                </tr>
                
                <tr>
                    <td  >
                        <label class="control-label x120">操作对象类：</label>
                        <input type="text" name="MClass"  value="${model.MClass}" data-rule="required" size="60">
                    </td>
                </tr>
                
                <tr>
                    <td  >
                        <label class="control-label x120">操作对象方法：</label>
                        <input type="text" name="MMethord"  value="${model.MMethord}" data-rule="required" size="60">
                    </td>
                </tr>
                          
                
                <tr>
                	<td>
                        <label class="control-label x120">操作时间：</label>
                        <input type="text" name="operationTime" data-toggle="datepicker" id="otime" readonly value="<fmt:formatDate value="${model.operationTime}" pattern="yyyy-MM-dd HH:mm:ss"  />"  size="20">
                    </td>
                </tr>   
                
                 <tr>
                    <td  >
                        <label class="control-label x120">状态：</label>
                        <input type="text" name="MStatus"  value="${model.MStatus}" data-rule="required" size="60">
                    </td>
                </tr>
                
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default">提交</button></li>
    </ul>
</div>