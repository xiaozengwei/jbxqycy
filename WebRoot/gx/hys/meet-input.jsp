<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<script type="text/javascript">

</script>
<div class="bjui-pageContent">
               
 <form action="<%=basePath%>hys/meet-save.do" id="meet_input_form" class="pageForm" data-toggle="validate" data-reloadNavtab="true">
        <input name="rowId" type="hidden" value="${meetingRoomInfo.rowId }"/>
        <table class="table table-condensed table-hover">
            <tbody style="text-align:center;">
             <tr>
                  <td colspan="2">
                    <h3>会议室添加</h3>
                  </td>
             </tr>
             <tr style="margin:10px">
                 <td align="right" width="20%">
                     <label class="control-label">会议室名称：</label>
                 </td>
                 <td align="left">
                     <input type="text" name="roomName" style="width:300px" value="${meetingRoomInfo.roomName}" data-rule="required">
                 </td>
             </tr>
             <tr style="margin:10px">
                 <td align="right" width="20%">
                     <label class="control-label">地址：</label>
                 </td>
                 <td align="left">
                     <input type="text" name="roomAddress" style="width:300px" value="${meetingRoomInfo.roomAddress}" data-rule="required">
                 </td>
             </tr>
             <tr>
                  <td align="right" width="20%">
                    <label class="control-label">建筑面积：</label>
                  </td>
                 <td align="left">
                     <input type="text" name="buildArea" style="width:300px" value="${meetingRoomInfo.buildArea}">
                 </td>
             </tr>
             <tr>
                 <td align="right" width="20%">
                     <label class="control-label">长度*宽度：</label>
                 </td>
                 <td align="left">
                     <input type="text" name="lengthWidth" style="width:300px" value="${meetingRoomInfo.lengthWidth}">
                 </td>
             </tr>
             <tr>
                  <td align="right" width="20%">
                      <label class="control-label" >屏幕尺寸：</label>
                  </td>
                 <td align="left">
                     <input type="text" name="screenSize" style="width:300px" value="${meetingRoomInfo.screenSize}">
                 </td>
             </tr>
             <tr>
                 <td align="right" width="20%">
                     <label class="control-label">分辨率：</label>
                 </td>
                 <td align="left">
                     <input type="text" name="resolution" style="width:300px" value="${meetingRoomInfo.resolution}">
                 </td>
             </tr>
             <tr>
                 <td align="right" width="20%">
                     <label class="control-label">场地费：</label>
                 </td>
                 <td align="left">
                     <label class="control-label" >&nbsp;&nbsp;&nbsp;全天</label>
                     <input type="text" name="siteFeeAll" style="width:120px" value="${meetingRoomInfo.siteFeeAll}">
                     <label class="control-label" >&nbsp;&nbsp;&nbsp;半天</label>
                     <input type="text" name="siteFeeHalf" style="width:120px" value="${meetingRoomInfo.siteFeeHalf}">
                 </td>
             </tr>
             <tr>
                 <td align="right" width="20%">
                     <label class="control-label">园区六折：</label>
                 </td>
                 <td align="left">
                     <label class="control-label" >&nbsp;&nbsp;&nbsp;全天</label>
                     <input type="text" name="parkLzAll" style="width:120px" value="${meetingRoomInfo.parkLzAll}">
                     <label class="control-label" >&nbsp;&nbsp;&nbsp;半天</label>
                     <input type="text" name="parkLzHalf" style="width:120px" value="${meetingRoomInfo.parkLzHalf}">
                 </td>
             </tr>
             <tr>
                 <td align="right" width="20%">
                     <label class="control-label" >容纳人数：</label>
                 </td>
                 <td align="left">
                     <label class="control-label" >课桌式</label>
                     <input type="text" name="capacityKzs" style="width:120px" value="${meetingRoomInfo.capacityKzs}">
                     <label class="control-label" >剧院式</label>
                     <input type="text" name="capacityJys" style="width:120px" value="${meetingRoomInfo.capacityJys}">
                 </td>
             </tr>
             <tr>
                 <td align="right" width="20%">
                     <label class="control-label" >容纳人数：</label>
                 </td>
                 <td align="left">
                     <label class="control-label" >&nbsp;&nbsp;&nbsp;U型</label>
                     <input type="text" name="capacityUx" style="width:120px" value="${meetingRoomInfo.capacityUx}">
                     <label class="control-label" >&nbsp;&nbsp;&nbsp;状态</label>
                     <input type="text" name="roomStatus" style="width:120px" value="${meetingRoomInfo.roomStatus}">
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