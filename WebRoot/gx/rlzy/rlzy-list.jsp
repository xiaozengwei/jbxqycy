<%@ page language="java" pageEncoding="UTF-8"
	import="java.util.*"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
//自动有效日期
$(document).on('afterchange.bjui.datepicker', '.j_custom_issuedate', function(e, data) {
    var pattern = 'yyyy-MM-dd'
    var start   = end = data.value
    var $end    = $(this).closest('tr').find('.j_custom_indate')
    
    if ($end.length) {
        end.setFullYear(start.getFullYear() + 10)
        end.setDate(start.getDate() - 1)
        $end.val(end.formatDate(pattern))
    }
})
//上传图片完成回调
function custom_pic_upload_success(file, data, $upload) {
    var json = $.parseJSON(data)
    if (json[BJUI.keys.statusCode] == BJUI.statusCode.ok) {
        var pic = json.navTabId
        
        $upload.next().val(pic).next().html('<img src="'+ pic +'" width="80" />')
    }
}
function returnRLTreeJSON() {
	var jsont ;
	$.ajax({
		url:'<%=basePath%>sysorg/org-tree.do',
		type:'get',
		async:false,
		cache:false,
		dataType:'json',
		success:function(json){
			jsont = json;
		}
	});
	return jsont;
    
}

//ztree列表
		function userlist(event, treeId, treeNode){
			 if (treeNode.isParent) {
		        var zTree = $.fn.zTree.getZTreeObj(treeId)
		        zTree.expandNode(treeNode);
		        event.preventDefault();
		        return;
		     }
		     var w=$("#dp").val();//console.log(treeNode.id);
			$(event.target).bjuiajax('doLoad', {url:'<%=basePath%>hr/index-list.do', target:'#layout-01',data:'v_row_Id='+treeNode.id+'&a='+w});
			event.preventDefault();
		}

	
</script>
<div class="bjui-pageContent">
	<div style="float:left;">
		<div id="bjui-sidebar"
			style="width:250px;height:30px;margin-left:10px; margin-top:10px;">
			<div class="toggleCollapse">
				<h2>
					<i class="fa fa-bars"></i>
				</h2>
				<a href="javascript:;" class="lock"></a>
			</div>
			<div class="panel-group panel-main" data-toggle="accordion"
				id="bjui-accordionmenu" data-heightbox="#bjui-sidebar"
				data-offsety="26"></div>
		</div>
		<div
			style="float:left; width:250px;z-index:1;position:relative; height:620px; margin-bottom:0px; overflow:auto; margin-top:26px; margin-left:0px; border-right:1px #c3ced5 solid; border-bottom:1px #c3ced5 solid;border-left:1px #c3ced5 solid">
			<ul id="ztree1" class="ztree" data-toggle="ztree"
				data-on-click="userlist" data-expand-all="true" data-options="{nodes:'returnRLTreeJSON',
                        expandAll: true ,onClick:'userlist'}">
				<%--<c:forEach items="${orgs}" var="org">
					<c:if test="${org.parentOrgId eq 'root'}">
							<li data-id="${org.rowId}" data-pid="0"
							data-divid="#layout-01" data-tabid="${org.rowId}"
							data-faicon="users">${org.orgName}</li>
							<c:forEach items="${orgs}" var="org1">
								<c:if test="${org1.parentOrgId ne 'root'&&org.rowId==org1.parentOrgId }">
									<li data-id="${org1.rowId}"
									data-pid="${org1.parentOrgId}"
									data-divid="#layout-01" data-tabid="${org1.rowId+1000}"
									data-faicon="user">${org1.orgName}</li>
								</c:if>
							</c:forEach>
					</c:if>
				</c:forEach>

			--%></ul>
			<input type="hidden" value="${a}" id="dp">
		</div>
	</div>



	<div style="margin-left:255px; height:100%;border:1px #c3ced5 solid;"  id="layout-01"></div>

	</div>