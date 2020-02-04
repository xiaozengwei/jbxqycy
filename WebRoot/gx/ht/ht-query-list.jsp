<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageContent">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="15%" valign="top"><div id="bjui-sidebar" style=" width:250px; margin-left:10px; margin-top:10px;">
				<div class="toggleCollapse"><h2><i class="fa fa-bars"></i> </h2><a href="javascript:;" class="lock"></a></div>
				<div class="panel-group panel-main" data-toggle="accordion" id="bjui-accordionmenu" data-heightbox="#bjui-sidebar" data-offsety="26">
				</div>
			</div>
				<div style="float:left; width:250px; height:568px; margin-bottom:0px; overflow:auto; margin-top:26px; margin-left:0px; border-right:1px #c3ced5 solid; border-bottom:1px #c3ced5 solid;border-left:1px #c3ced5 solid">
					<ul id="ztree1" class="ztree" data-toggle="ztree"
						data-options="{
                        expandAll: true,
                        onClick: 'ZtreeClick'
                    }">

						<li data-id="4" data-pid="0" data-faicon="users">南京体育产业集团</li>
						<li data-id="40" data-pid="4" data-url="" data-tabid="table" data-faicon="user">集团领导</li>
						<li data-id="40" data-pid="4" data-url="" data-tabid="table" data-faicon="user">综合办公室党群工作与人力资源部</li>
						<li data-id="40" data-pid="4" data-url="" data-tabid="table" data-faicon="user">计划财务部</li>
						<li data-id="40" data-pid="4" data-url="" data-tabid="table" data-faicon="user">投资发展部</li>
						<li data-id="40" data-pid="4" data-url="" data-tabid="table" data-faicon="user">资产运营部</li>
						<li data-id="40" data-pid="4" data-url="" data-tabid="table" data-faicon="user">体育交易平台项目组</li>
						<li data-id="40" data-pid="4" data-url="" data-tabid="table" data-faicon="user">O2O平台项目组</li>



					</ul>
				</div></td>
			<td width="85%" valign="top" align="center" style="padding-left:5px">
				<form id="pagerForm" data-toggle="ajaxsearch" action="table.html" method="post">

					<div class="bjui-searchBar" style="line-height:60px">&nbsp;姓名
						<label>：</label><input type="text" id="customNo" value="" name="code" class="form-control" size="15">&nbsp;&nbsp;&nbsp;&nbsp;
						<label>员工号：</label>
						<input type="text" value="" name="name" class="form-control" size="15">&nbsp;&nbsp;
						<label>部门:</label>
						<select name="type" data-toggle="selectpicker">
							<option value="">请选择</option>
						</select>&nbsp;&nbsp;
						<label>用户登录名:</label>
						<span class="bjui-searchBar" style="line-height:60px">
                        <label></label>
                        <input type="text" id="customNo2" value="" name="customNo" class="form-control" size="15" />
                        </span>&nbsp;&nbsp;

						<button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
					</div>

				</form>

				<div class="tableContent">
					<table class="table table-bordered table-hover table-striped table-top table-center" data-selected-multi="true" align="center" style="border-top:1px #dddddd solid">
						<thead>
						<tr>
							<th height="30" width="10%" >序号</th>
							<th width="10%">排序</th>
							<th width="13%">员工卡号</th>
							<th align="center" data-order-field="operation" width="15%">用户登录名</th>
							<th width="15%" >用户名</th>
							<th  width="22%">部门</th>
							<th >操作</th>
						</tr>
						</thead>
						<tbody>
						<tr data-id="6">
							<td  >1</td>
							<td  >1</td>
							<td>&nbsp;</td>
							<td>miao_ch</td>
							<td>缪晨虹</td>
							<td>综合办公室党群工作与人力资源部</td>
							<td align="center"><input name="selectaddworkpeo2"  data-url="rlzy.html"  data-toggle="navtab" data-title="编辑"  data-id="rl-started" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onclick="peopleutil()" />
								<input name="selectaddworkpeo" type="button" class="btn-default" id="selectaddworkpeo2" value="查看" onclick="peopleutil()" /></td>
						</tr>
						<tr data-id="7">
							<td  >2</td>
							<td  >2</td>
							<td>&nbsp;</td>
							<td>ren_d</td>
							<td>任  丹</td>
							<td>综合办公室党群工作与人力资源部</td>
							<td align="center"><input name="selectaddworkpeo2" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onclick="peopleutil()" />
								<input name="selectaddworkpeo" type="button" class="btn-default" id="selectaddworkpeo2" value="查看" onclick="peopleutil()" /></td>
						</tr>
						<tr data-id="8">
							<td  >3</td>
							<td  >3</td>
							<td>&nbsp;</td>
							<td>sun_ls</td>
							<td>孙龙升</td>
							<td>综合办公室党群工作与人力资源部</td>
							<td align="center"><input name="selectaddworkpeo2" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onclick="peopleutil()" />
								<input name="selectaddworkpeo" type="button" class="btn-default" id="selectaddworkpeo2" value="查看" onclick="peopleutil()" /></td>
						</tr>
						<tr data-id="7">
							<td  >4</td>
							<td  >4</td>
							<td>&nbsp;</td>
							<td>niu_z</td>
							<td>牛哲</td>
							<td>综合办公室党群工作与人力资源部</td>
							<td align="center"><input name="selectaddworkpeo2" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onclick="peopleutil()" />
								<input name="selectaddworkpeo" type="button" class="btn-default" id="selectaddworkpeo2" value="查看" onclick="peopleutil()" /></td>
						</tr>
						<tr data-id="8">
							<td  >5</td>
							<td  >5</td>
							<td>&nbsp;</td>
							<td>chang_bl</td>
							<td>常白璐</td>
							<td>综合办公室党群工作与人力资源部</td>
							<td align="center"><input name="selectaddworkpeo2" type="button" class="btn-default" id="selectaddworkpeo" value="编辑" onclick="peopleutil()" />
								<input name="selectaddworkpeo" type="button" class="btn-default" id="selectaddworkpeo2" value="查看" onclick="peopleutil()" /></td>
						</tr>
						</tbody>
					</table>
				</div>
			</td>
		</tr>
	</table>
</div>

<script type="text/javascript">
function printDJB(rowId, obj){
	$(obj).attr("class","btn btn-orange");
	window.open("<%=path %>/sp-tzsb-sg/print-djb.do?rowId="+rowId);
}
</script>