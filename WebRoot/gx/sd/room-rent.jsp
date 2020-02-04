<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
//    ResourceBundle resource = ResourceBundle.getBundle("workflowconfig");
//    String URL =resource.getString("URLVIEW");  //外网测试环境
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String mHttpUrlName=request.getRequestURI();
    String mScriptName=request.getServletPath();
    String mHttpUrl="http://"+request.getServerName()+":"+request.getServerPort()+mHttpUrlName.substring(0,mHttpUrlName.lastIndexOf(mScriptName)
    )+"/";
    long random = new Date().getTime();
 %>

<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>sd/room-bind-save.do" method="post" data-toggle="validate" data-reloadNavtab="false">
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td  align="center"><h3>房间租赁</h3></td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">乙方：</label>
                        <input type="text" name="yf" id="yf"  value="${model.yf}" data-rule="required" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">身份证号：</label>
                        <input type="text" name="idCard" id="idCard"  value="${model.idCard}" data-rule="required" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">房间号：</label>
                        <input type="text" name="roomId" id="roomId"  value="${model.roomId}" data-rule="required" >
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">建筑面积：</label>
                        <input type="text" name="buildArea" id="buildArea"  value="${model.buildArea}" data-rule="required" >
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">户型：</label>
                        <input type="text" name="roomType" id="roomType"  value="${model.roomType}" data-rule="required" >
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" onclick="taoHong()">套红预览</button></li>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default">保存</button></li>
    </ul>
</div>
<script type="text/javascript">
    var date = new Date();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var RecordID = date.getFullYear()+''+month+''+ strDate
        + date.getHours()+''+ date.getMinutes()
        + ''+date.getSeconds()+''+<%=random%>;

    //套红
    function taoHong(){
        var userName = "丁甲林";
        var file_name =RecordID;
        var yf = $("#yf").val(); //1标题
        var idCard = $("#idCard").val(); //1标题
        var roomId = $("#roomId").val(); //1标题
        var buildArea = $("#buildArea").val(); //1标题
        var roomType = $("#roomType").val(); //1标题
        Link("gx/iweboffice/DocumentTaoHongView.jsp?RecordID="+file_name+"&FileName="+file_name+".doc&EditType=1&userName="+userName+"&yf="+yf+"&idCard="+idCard+"&roomId="+roomId+"&buildArea="+buildArea+"&roomType="+roomType,0);
    }

    function Link(url,skin) {
        url=encodeURI(encodeURI(url));
        var  link = "KGBrowser://$link:<%=mHttpUrl%>"+url+"$skin="+skin+"$tabshow=1";   // skin  0灰色 1蓝色 2黄色 3绿色 4红色
        location.href = link;
        console.log(link+"link");
    }
</script>