<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">
    .choose-btn { display: none; }
    .choose-label { box-shadow: #b1b1b1 0px 0px 0px 1px; width: 30px; height: 16px; display: inline-block; border-radius: 16px; position: relative; background-color: #bdbdbd; overflow: hidden; margin: 0; margin-top: 4px; cursor: pointer; vertical-align: middle; }
    .choose-label:before { content: ''; position: absolute; left: 0; width: 16px; height: 16px; display: inline-block; border-radius: 20px; background-color: #fff; z-index: 20; -webkit-transition: all 0.2s; transition: all 0.2s; }
    .choose-btn:checked + label.choose-label:before { left: 14px; }
    .choose-btn:checked + label.choose-label { background-color: #009cef; box-shadow: #009cef 0px 0px 0px 1px; }
    .choose-text { display: inline-block; vertical-align: middle; line-height: 20px; color: #888; font-size: 12px; margin-top: 4px; }
</style>
<script>
    $(".choose-btn").each(function(){
        var texts = $(this).attr('data-toggle').split('|');
        $(this).siblings('.choose-text').text(this.checked?texts[0]:texts[1]);
    });
    $(".choose-btn").on("change", function(){
        var texts = $(this).attr('data-toggle').split('|');
//        $(this).siblings('.choose-text').text(this.checked?texts[0]:texts[1]);//合
        var t=$(this).siblings('.choose-text');
        $.ajax({
            url:'<%=basePath%>electric/electric-control.do',
            type:'get',
            async:false,
            cache:false,
            dataType:'json',
            data:{'checked':this.checked,'deviceId':document.getElementById("device").innerHTML},
            success:function(json){
                if(json.statusCode==200){
                    t.text(json.checked?texts[0]:texts[1]);
                    document.getElementById("switch1").checked=json.checked;
                    $(this).alertmsg('info',json.message, {displayMode:'slide', title:'我是提示标题'});
                }else {
                    t.text(!json.checked?texts[0]:texts[1]);
                    document.getElementById("switch1").checked=!json.checked;
                    $(this).alertmsg('warn',json.message, {displayMode:'slide', title:'我是提示标题'});
                }

            }
        });
    });
//    $(".choose-btn").on("change", function(){
//        var texts = $(this).attr('data-toggle').split('|');
//        $(this).siblings('.choose-text').text(this.checked?texts[0]:texts[1]);
//    });
</script>
<base href="<%=basePath %>">
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch"  action="<%=basePath%>electric/electric-device-list.do?rowId=${rowId}" method="post">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <div class="bjui-searchBar">
            <div class="pull-right">
            </div>
        </div>

    </form>
</div>
<div class="bjui-pageContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th  width="5%"  align="center">序号</th>
            <th  width="5%"  align="center">房间号</th>
            <th width="5%"  align="center">电表id</th>
            <th width="5%" align="center">电表别名</th>
            <th width="5%" align="center">模式</th>
            <th width="2%" align="center">电表状态</th>
            <th width="10%" align="center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="device" varStatus="status">
            <tr data-id="${device.rowId}">
                <td align="center">${status.count }</td>
                <td align="center">${device.rowName}</td>
                <td align="center" id="device">${device.deviceId}</td>
                <td align="center">${device.deviceName}</td>
                <td align="center">${device.settleTypeName}</td>
            <%--<td align="center">${device.onAndOff eq '0'?'未知':device.onAndOff eq '1'?'合闸': device.onAndOff eq'2'?'分闸':''} </td>--%>
                <td>
                    <input type="checkbox" name="switch1" id="switch1" class="choose-btn" data-toggle="通|断" ${device.onAndOff eq '1'?'checked':''}>
                    <label for="switch1" class="choose-label"></label>
                    <span class="choose-text"></span>
                </td>
                <td align="center">
                    <%--<a href="<%=basePath%>electric/user-room.do?roomId=${device.rowId}"  data-toggle="navtab" data-id="user-room"  data-title="关联用户">关联用户</a>||--%>
                    <a href="<%=basePath%>electric/electric-day-list.do?deviceId=${device.deviceId}"  data-toggle="navtab" data-id="electric-day"  data-title="实时电量">实时</a>||
                    <a href="<%=basePath%>electric/electric-month-list.do?deviceId=${device.deviceId}"  data-toggle="navtab" data-id="electric-month"  data-title="历史电量">历史</a>
                    <%--<a href="<%=basePath%>electric/recharge-devices-input.do?vKey=${device.vKey}&opt=recharge"  data-toggle="dialog" data-id="recharge-devices" data-target="recharge-devices" data-width="400" data-height="400" data-title="充值">充值</a>||--%>
                    <%--<a href="<%=basePath%>electric/recharge-devices-input.do?vKey=${device.vKey}&opt=deduct"  data-toggle="dialog" data-id="reduce-devices" data-target="reduce-devices" data-width="400" data-height="400" data-title="扣费">扣费</a>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="bjui-pageFooter">
    <div class="pages">
        <span>每页&nbsp;</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker"
                    data-toggle-change="changepagesize">
                <option value="10">10</option>
                <option value="15">15</option>
                <option value="20">20</option>
                <option value="25">25</option>
            </select>
        </div>
        <span>&nbsp;条，共 ${page.totalCount }条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${page.totalCount }"
         data-page-size="${page.pageSize }" data-page-current="${page.pageCurrent }"></div>
</div>