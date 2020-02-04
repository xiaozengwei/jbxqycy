package com.gx.soft.fwzl.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.spring.TimeStampPropertyEditor;
import com.gx.soft.fwzl.persistence.domain.*;
import com.gx.soft.fwzl.persistence.manager.*;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.sys.persistence.domain.GxSysDicRecord;
import com.gx.soft.sys.persistence.domain.GxSysOrg;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.GxRecordManager;
import com.gx.soft.sys.persistence.manager.GxSysOrgManager;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("fwzl")
@SessionAttributes("user_session")
public class FwzlController {
	static Logger logger = Logger.getLogger(FwzlController.class);
	@Autowired
	private GxSysOrgManager gxSysOrgManager;
	@Autowired
	private VUserManager vUserManager;
	@Autowired
	private RcgyLeseApplyManager rcgyLeseApplyManager;
	@Autowired
	private AttachmentManager attachmentManager;
	@Autowired
	private ProcTemplateManager procTemplateManager;
	@Autowired
	private ProcInstanceManager procInstanceManager;
	@Autowired
	private ProcActManager procActManager;
	@Autowired
	private ProcActInstanceManager procActInstanceManager;
	@Autowired
	private ProcSignatureManager procSignatureManager;
	@Autowired
	private GxRecordManager gxRecordManager;
	@Autowired
	private VFwzlProcinstManager vFwzlProcinstManager;
	@Autowired
	private VFwzlInstActManager vFwzlInstActManager;
	@Autowired
	private HistoryOpinionManager historyOpinionManager;

	private BeanMapper beanMapper = new BeanMapper();
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
							  ServletRequestDataBinder binder) throws Exception {
		// TODO Auto-generated method stub
		binder.registerCustomEditor(Timestamp.class,
				new TimeStampPropertyEditor());
	}


	/**
	 * 到房屋租赁申请页面
	 * @return
	 */
	@RequestMapping("to-fwzl-apply")
	public String toFwzlApply() {
		return "fwzl/fwzl-apply";
	}

	/**
	 * 房屋租赁跟踪
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("fwzl-follow-list")
	public String list(@ModelAttribute Page page,
					   @RequestParam Map<String, Object> parameterMap, Model model) {
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = rcgyLeseApplyManager.pagedQuery(page, propertyFilters);
		List<RcgyLeseApply> list = (List<RcgyLeseApply>) page.getResult();
		page.setResult(list);
		model.addAttribute("page", page);
		model.addAttribute("list", list);

		return "fwzl/fwzl-follow-list";

	}

	/**
	 * 保存并提交申请
	 * @param user
	 * @param rcgyLeseApply
	 * @param attachmentId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "fwzl-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> FwzlSave(@ModelAttribute("user_session") GxSysUser user,
			RcgyLeseApply rcgyLeseApply,String attachmentId, Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		RcgyLeseApply dest = null;
		String rowId = rcgyLeseApply.getRowId();
		try{
			if(rowId != null && rowId.length() > 0){
				dest = rcgyLeseApplyManager.get(rowId);
				beanMapper.copy(rcgyLeseApply, dest);
				dest.setModifyUserId(user.getUserId());
				dest.setModifyUserName(user.getUserName());
				dest.setModifyTime(ts);
			}else{
				dest = rcgyLeseApply;
				dest.setCreateUserId(user.getUserId());
				dest.setCreateUserName(user.getUserName());
				dest.setCreateTime(ts);
			}
			rcgyLeseApplyManager.save(dest);
			//关联附件
			rowId = dest.getRowId();
			if(attachmentId != null && attachmentId.length() > 0){
				String[] idArr = attachmentId.split(",");
				for (int i = 0; i < idArr.length; i++) {
					// 根据主键得到附件对象
					Attachment attachment = attachmentManager.get(idArr[i]);
					attachment.setRelationId(rowId);
					attachmentManager.save(attachment);
				}
			}
			//保存意见
			//创建流程实例
			ProcTemplate procTemplate = procTemplateManager.findUniqueBy("processKey", "rcgyzl");
			String processId = procTemplate.getProcessId();
			ProcInstance procInstance = new ProcInstance();
			procInstance.setProcessId(processId);
			procInstance.setProcessName(procTemplate.getProcessName());
			procInstance.setBusinessId(rowId);
			String hql = "from ProcAct where processId = ? and backAct = ?";
			Object[] values = {processId, "申请"};
			ProcAct procAct = procActManager.findUnique(hql, values);
			String actName = procAct.getActName();
			procInstance.setInstanceState(actName);
			procInstance.setActiveState("激活");
			procInstance.setCreateTime(ts);
			procInstance.setCreateUserId(user.getUserId());
			procInstance.setCreateUserName(user.getUserName());
			procInstanceManager.save(procInstance);
			String instanceId = procInstance.getRowId();

			//创建节点实例
			List<ProcAct> actList = procActManager.findBy("processId", processId);
			for(ProcAct act : actList){
				ProcActInstance procActInstance = new ProcActInstance();
				procActInstance.setProcessId(processId);
				procActInstance.setInstanceId(instanceId);
				procActInstance.setBusinessId(rowId);
				procActInstance.setActId(act.getActId());
				procActInstance.setActName(act.getActName());
				procActInstance.setHandleUser(act.getHandleUserName());
				procActInstance.setActBack(act.getBackAct());
				procActInstance.setActNext(act.getNextAct());
				procActInstance.setActOrder(act.getActOrder());
				if(act.getActName().equals("申请")){
					procActInstance.setHandleUser(user.getUserName());
					procActInstance.setStepState("已同意");
					procActInstance.setFinishTime(ts);
				}else if(act.getActName().equals(actName)){
					procActInstance.setActiveTime(ts);
					procActInstance.setActiveState("激活");
					procActInstance.setActiveUserId(user.getUserId());
					procActInstance.setActiveUserName(user.getUserName());
					procActInstance.setStepState("正在执行");
				}
				//保存节点实例
				procActInstanceManager.save(procActInstance);
			}

			//创建历史意见表
			HistoryOpinion historyOpinion = new HistoryOpinion();
			historyOpinion.setTableId(rowId);
			historyOpinion.setPiId(instanceId);
			historyOpinion.setHandleStage("申请");
			historyOpinion.setHandleProcess(user.getUserName()+"提交给"+procAct.getHandleUserName());
			historyOpinion.setHandleOpinion("");
			historyOpinion.setHandleUser(user.getUserName());
			historyOpinion.setHandleTime(ts);
			historyOpinionManager.save(historyOpinion);
		}catch (Exception e) {
			// TODO: handle exception
			statusCode = "300";
			message = "操作失败！";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		return resMap;
	}

	/**
	 * 待办件（研创园人才公寓租赁列表）
	 */
	@RequestMapping("fwzl-task-list")
	public String fwzlTaskList(Page page,
								  @RequestParam(required = false, defaultValue = "") String orderField,
								  @RequestParam(required = false, defaultValue = "") String orderDirection,
								  @ModelAttribute("user_session") GxSysUser user,
								  @RequestParam Map<String, Object> parameterMap,Model model){
		if (orderField.length() > 0 && orderDirection.length() > 0) {
			page.setOrderBy(orderField);
			page.setOrder(orderDirection);
		}else {//默认按照申请时间升序
			page.setOrderBy("activeTime");
			page.setOrder("ASC");
		}
		//添加条件为根据当前用户查询
		parameterMap.put("filter_EQS_handleUser", user.getUserName());
		parameterMap.put("filter_EQS_activeState", "激活");
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = vFwzlInstActManager.pagedQuery(page, propertyFilters);
		List<VFwzlInstAct> list = (List<VFwzlInstAct>) page.getResult();
		page.setResult(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "fwzl/fwzl-task-list";
	}

	/**
	 * 到办理页面
	 * @param rowId 节点实例ID
	 * @param model
	 * @return
	 */
	@RequestMapping("fwzl-handle-page")
	public String toProcessHandle(String rowId,Model model){
		VFwzlInstAct vFwzlInstAct = vFwzlInstActManager.get(rowId);
		ProcActInstance currentAct = procActInstanceManager.get(rowId);
		model.addAttribute("currentAct", currentAct);
		String instanceId = vFwzlInstAct.getInstanceId();
		String businessId = vFwzlInstAct.getBusinessId();
		String hql = "from ProcActInstance where instanceId = ? and actName = ?";
		Object[] values = {instanceId, vFwzlInstAct.getActNext()};
		ProcActInstance nextAct = procActInstanceManager.findUnique(hql, values);
		model.addAttribute("nextAct", nextAct);
		if(!currentAct.getActName().equals("申请")){
			Object[] values1 = {instanceId, vFwzlInstAct.getActBack()};
			ProcActInstance backAct = procActInstanceManager.findUnique(hql, values1);
			model.addAttribute("backAct", backAct);
			if(currentAct.getActName().equals("企业服务部审核")){
				Object[] values2 = {instanceId, "结束"};
				ProcActInstance endAct = procActInstanceManager.findUnique(hql, values2);
				model.addAttribute("endAct", endAct);
			}
		}
		//申请表
		RcgyLeseApply rcgyLeseApply = rcgyLeseApplyManager.get(businessId);
		model.addAttribute("rcgyLeseApply", rcgyLeseApply);
		//附件
		List<Attachment> attachList = attachmentManager.findBy("relationId", businessId);
		model.addAttribute("attachList", attachList);
		//历史意见
		List<HistoryOpinion> opinionList = historyOpinionManager.findBy("tableId", businessId);
		model.addAttribute("opinionList", opinionList);
		//意见
		String hql2 = "from ProcActInstance where instanceId = ? and actInstRemark is not null order by actOrder asc";
		Object[] values2 = {instanceId};
		List<ProcActInstance> list = procActInstanceManager.find(hql2, values2);
		model.addAttribute("list", list);
		return "fwzl/fwzl-handle-page";
	}

	/**
	 * 房屋租赁办理
	 * @param actInstRowId
	 * @param selectAct
	 * @param opinion
	 * @param rcgyLeseApply
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "fwzl-handle", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> FwzlHandle(String actInstRowId, String selectAct, String opinion, RcgyLeseApply rcgyLeseApply,
								   @ModelAttribute("user_session") GxSysUser user, Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功",tabid = "T3424";
		boolean closeCurrent = true;
		Timestamp ts = DateUtil.getDate();
		RcgyLeseApply dest = null;
		String rowId = rcgyLeseApply.getRowId();
		try{
			if(rowId != null && rowId.length() > 0){
				dest = rcgyLeseApplyManager.get(rowId);
				beanMapper.copy(rcgyLeseApply, dest);
				dest.setModifyTime(ts);
				dest.setModifyUserId(user.getUserId());
				dest.setModifyUserName(user.getUserName());
			}
			rcgyLeseApplyManager.save(dest);
			//得到当前节点实例
			ProcActInstance procActInstance = procActInstanceManager.get(actInstRowId);
			String actBack = procActInstance.getActBack();
			String instanceId = procActInstance.getInstanceId();
			//当前节点取消激活状态
			procActInstance.setActInstRemark(opinion);
			procActInstance.setFinishTime(ts);
			procActInstance.setActiveState(null);
			if(selectAct.equals(actBack)){
				procActInstance.setStepState("已退回");
			}else{
				procActInstance.setStepState("已同意");
			}
			procActInstanceManager.save(procActInstance);
			//得到下一个节点
			Map<String, Object> parameterMap1 = new HashMap<String, Object>();
			parameterMap1.put("filter_EQS_actName", selectAct);
			parameterMap1.put("filter_EQS_instanceId", instanceId);
			List<PropertyFilter> propertyFilters1 = PropertyFilter.buildFromMap(parameterMap1);
			ProcActInstance procActInstance1 = procActInstanceManager.find(propertyFilters1).get(0);
			//得到当前流程实例
			ProcInstance procInstance = procInstanceManager.get(instanceId);
			procInstance.setInstanceState(selectAct);
			//创建历史意见表
			HistoryOpinion historyOpinion = new HistoryOpinion();
			historyOpinion.setTableId(rowId);
			historyOpinion.setPiId(instanceId);
			historyOpinion.setHandleStage(procActInstance.getActName());
			historyOpinion.setHandleOpinion(opinion);
			historyOpinion.setHandleUser(user.getUserName());
			historyOpinion.setHandleTime(ts);
			if(selectAct.equals("结束")){
				procInstance.setEndTime(ts);
				procInstance.setActiveState(null);
				historyOpinion.setHandleProcess(user.getUserName()+"提交给结束环节");
			}else{
				procActInstance1.setActiveState("激活");
				procActInstance1.setActiveUserId(user.getUserId());
				procActInstance1.setActiveUserName(user.getUserName());
				procActInstance1.setActiveTime(ts);
				procActInstance1.setStepState("正在执行");
				procActInstanceManager.save(procActInstance1);
				historyOpinion.setHandleProcess(user.getUserName()+"提交给"+procActInstance1.getHandleUser());
			}
			procInstanceManager.save(procInstance);
			historyOpinionManager.save(historyOpinion);
		}catch (Exception e) {
			// TODO: handle exception
			statusCode = "300";
			message = "办理失败";
			closeCurrent = false;
			tabid = "";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", closeCurrent);
		resMap.put("tabid", tabid);
		return resMap;
	}

	/**
	 * 人才公寓租赁查询
	 */
	@RequestMapping("fwzl-progress-list")
	public String fwzlProgressList(Page page,
								  @RequestParam(required = false, defaultValue = "") String orderField,
								  @RequestParam(required = false, defaultValue = "") String orderDirection,
								  @ModelAttribute("user_session") GxSysUser user,
								  @RequestParam Map<String, Object> parameterMap,Model model){
		if (orderField.length() > 0 && orderDirection.length() > 0) {
			page.setOrderBy(orderField);
			page.setOrder(orderDirection);
		}else {//默认按照申请时间升序
			page.setOrderBy("createTime");
			page.setOrder("ASC");
		}
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = vFwzlProcinstManager.pagedQuery(page,propertyFilters);
		List<VFwzlProcinst> list = (List<VFwzlProcinst>) page.getResult();
		page.setResult(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "fwzl/fwzl-progress-list";
	}

	/**
	 * 查看详情
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("to-fwzl-view")
	public String toFwzlView(String rowId,Model model){
		VFwzlProcinst vFwzlProcinst = vFwzlProcinstManager.get(rowId);
		String instanceId = vFwzlProcinst.getInstanceId();
		String instanceState = vFwzlProcinst.getInstanceState();
		model.addAttribute("instanceState", instanceState);
		//申请表
		RcgyLeseApply rcgyLeseApply = rcgyLeseApplyManager.get(rowId);
		model.addAttribute("rcgyLeseApply", rcgyLeseApply);
		//附件
		List<Attachment> attachList = attachmentManager.findBy("relationId", rowId);
		model.addAttribute("attachList", attachList);
		//历史意见
		List<HistoryOpinion> opinionList = historyOpinionManager.findBy("tableId", rowId);
		model.addAttribute("opinionList", opinionList);
		String hql = "from ProcActInstance where instanceId = ? and actInstRemark is not null order by actOrder asc";
		Object[] values = {instanceId};
		List<ProcActInstance> list = procActInstanceManager.find(hql, values);
		model.addAttribute("list", list);
		return "fwzl/fwzl-view";
	}

	//样板间-8849
	@RequestMapping("ybj-8849")
	public String ybjView1() {
		return "fwzl/ybj-8849";
	}

	//样板间-盛景华庭
	@RequestMapping("ybj-sjht")
	public String ybjView2() {
		return "fwzl/ybj-sjht";
	}

	/**
	 * 已完成办件管理
	 * @param page
	 * @param orderField
	 * @param orderDirection
	 * @param user
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("fwzl-finish-list")
	public String fwzlFinishList(Page page,
								   @RequestParam(required = false, defaultValue = "") String orderField,
								   @RequestParam(required = false, defaultValue = "") String orderDirection,
								   @ModelAttribute("user_session") GxSysUser user,
								   @RequestParam Map<String, Object> parameterMap,Model model){
		if (orderField.length() > 0 && orderDirection.length() > 0) {
			page.setOrderBy(orderField);
			page.setOrder(orderDirection);
		}else {//默认按照申请时间升序
			page.setOrderBy("createTime");
			page.setOrder("DESC");
		}
		parameterMap.put("filter_EQS_instanceState", "结束");
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = vFwzlProcinstManager.pagedQuery(page,propertyFilters);
		List<VFwzlProcinst> list = (List<VFwzlProcinst>) page.getResult();
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "fwzl/fwzl-finish-list";
	}

	/**
	 * 导出excel
	 * @param page
	 * @param orderField
	 * @param orderDirection
	 * @param parameterMap
	 * @param user
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "export-excel")
	public @ResponseBody
	Map<String, Object> exportExcel(Page page,
									@RequestParam(required = false, defaultValue = "") String orderField,
									@RequestParam(required = false, defaultValue = "") String orderDirection,
									@RequestParam Map<String, Object> parameterMap, @ModelAttribute("user_session") GxSysUser user,
									HttpServletResponse response, Model model){
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		// decode解码
		String filter_LIKES_enterpriseName = (String) parameterMap.get("filter_LIKES_enterpriseName");
		String filter_EQS_apartmentType = (String) parameterMap.get("filter_EQS_apartmentType");
		try {
			filter_LIKES_enterpriseName = URLDecoder.decode(filter_LIKES_enterpriseName, "UTF-8");
			parameterMap.put("filter_LIKES_enterpriseName", filter_LIKES_enterpriseName);
			filter_EQS_apartmentType = URLDecoder.decode(filter_EQS_apartmentType, "UTF-8");
			parameterMap.put("filter_EQS_apartmentType", filter_EQS_apartmentType);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		if (orderField.length() > 0 && orderDirection.length() > 0) {
			page.setOrderBy(orderField);
			page.setOrder(orderDirection);
		}else {
			page.setOrderBy("createTime");
			page.setOrder("ASC");
		}
		parameterMap.put("filter_EQS_instanceState", "结束");
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		List<VFwzlProcinst> vList = vFwzlProcinstManager.find(propertyFilters);
		// 文件名
		String fileName = "房屋租赁办件归档.xls";
		// 列名数组
		String[] headers = {"申请企业名称","申请日期","企业经办人","联系电话","需求公寓类型","需求公寓数量","拟入住时间","租赁期限","是否符合投资协议约定"};
		// 数据集合
		List<Map> list = new ArrayList<Map>();
		for (VFwzlProcinst vFwzlProcinst : vList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("申请企业名称", vFwzlProcinst.getEnterpriseName() == null?"":vFwzlProcinst.getEnterpriseName());
			map.put("申请日期", vFwzlProcinst.getApplyDate() == null?"":vFwzlProcinst.getApplyDate());
			map.put("企业经办人", vFwzlProcinst.getEnterpriseManager() == null?"":vFwzlProcinst.getEnterpriseManager());
			map.put("联系电话", vFwzlProcinst.getContactNumber() == null?"":vFwzlProcinst.getContactNumber());
			map.put("需求公寓类型", vFwzlProcinst.getApartmentType() == null?"":vFwzlProcinst.getApartmentType());
			map.put("需求公寓数量", vFwzlProcinst.getApartmentNumber() == null?"":vFwzlProcinst.getApartmentNumber());
			map.put("拟入住时间", vFwzlProcinst.getCheckInTime() == null?"":vFwzlProcinst.getCheckInTime());
			map.put("租赁期限", vFwzlProcinst.getLeaseTerm() == null?"":vFwzlProcinst.getLeaseTerm());
			map.put("是否符合投资协议约定", vFwzlProcinst.getIsAccordTzxyyd() == null?"":vFwzlProcinst.getIsAccordTzxyyd());
			list.add(map);
		}
		// 创建excel，填充数据
		int index = 0;
		try {
			Workbook workbook = new HSSFWorkbook();
			Sheet sheet = workbook.createSheet();
			sheet.setDefaultColumnWidth((short) 15);
			Row row = sheet.createRow(index++);
			for (short i = 0; i < headers.length; i++) {
				Cell cell = row.createCell(i);
				RichTextString text = new HSSFRichTextString(headers[i]);
				cell.setCellValue(text);
			}
			for (Map map : list) {
				row = sheet.createRow(index++);
				for (int i = 0; i < headers.length; i++) {
					row.createCell(i).setCellValue(map.get(headers[i]).toString());
				}
			}
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ new String(fileName.getBytes("gb2312"), "iso8859-1"));
			OutputStream out = response.getOutputStream();
			workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", false);
		return resMap;
	}
	
}
