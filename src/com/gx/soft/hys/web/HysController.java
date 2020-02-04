package com.gx.soft.hys.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.spring.TimeStampPropertyEditor;
import com.gx.soft.fwzl.persistence.domain.*;
import com.gx.soft.fwzl.persistence.manager.*;
import com.gx.soft.hys.persistence.domain.*;
import com.gx.soft.hys.persistence.manager.*;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.sys.persistence.domain.GxSysFunction;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.manager.GxRecordManager;
import com.gx.soft.sys.persistence.manager.GxSysOrgManager;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("hys")
@SessionAttributes("user_session")
public class HysController {
	static Logger logger = Logger.getLogger(HysController.class);
	@Autowired
	private GxSysOrgManager gxSysOrgManager;
	@Autowired
	private VUserManager vUserManager;
	@Autowired
	private MeetingRoomUseInfoManager meetingRoomUseInfoManager;
	@Autowired
	private MeetingRoomLeaseApplyManager meetingRoomLeaseApplyManager;
	@Autowired
	private MeetingRoomInfoManager meetingRoomInfoManager;
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
	private VMeetProcinstManager vMeetProcinstManager;
	@Autowired
	private VMeetInstActManager vMeetInstActManager;
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
     * 到会议室租赁申请页面
	 * @return
     */
	@RequestMapping("to-hys-apply")
	public String toHysApply(Model model) {
		String hql = "from ProcAct where processId = ? and backAct = ?";
		Object[] values = {"hyszl", "申请"};
		ProcAct procAct = procActManager.findUnique(hql, values);
		model.addAttribute("procAct",procAct);
		return "hys/hys-apply";
	}

	/**
	 * 会议室申请保存
	 * @param user
	 * @param meetingRoomLeaseApply
	 * @param attachmentId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "hys-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> hysSave(@ModelAttribute("user_session") GxSysUser user,
								 MeetingRoomLeaseApply meetingRoomLeaseApply, String attachmentId, Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		MeetingRoomLeaseApply dest = null;
		String rowId = meetingRoomLeaseApply.getRowId();
		try{
			if(rowId != null && rowId.length() > 0){
				dest = meetingRoomLeaseApplyManager.get(rowId);
				beanMapper.copy(meetingRoomLeaseApply, dest);
				dest.setModifyUserName(user.getUserName());
				dest.setModifyTime(ts);
				dest.setModifyUserId(user.getUserId());
			}else{
				dest = meetingRoomLeaseApply;
				dest.setCreateUserId(user.getUserId());
				dest.setCreateUserName(user.getUserName());
				dest.setCreateTime(ts);
			}
			meetingRoomLeaseApplyManager.save(dest);
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
			ProcTemplate procTemplate = procTemplateManager.findUniqueBy("processKey", "hyszl");
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
				procActInstance.setHandleUser1(act.getHandleUserName1());
				procActInstance.setActBack(act.getBackAct());
				procActInstance.setActNext(act.getNextAct());
				procActInstance.setActOrder(act.getActOrder());
				if(act.getActName().equals("申请")){
					procActInstance.setHandleUser(user.getUserName());
					procActInstance.setStepState("已同意");
					procActInstance.setFinishTime(ts);
				}else if(act.getActName().equals(actName)){
					procActInstance.setActiveState("激活");
					procActInstance.setActiveUserId(user.getUserId());
					procActInstance.setActiveUserName(user.getUserName());
					procActInstance.setActiveTime(ts);
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
	 * 会议室租赁进度查询
	 * @param page
	 * @param orderField
	 * @param orderDirection
	 * @param user
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("hys-progress-list")
	public String hysProgressList(Page page,
								   @RequestParam(required = false, defaultValue = "") String orderField,
								   @RequestParam(required = false, defaultValue = "") String orderDirection,
								   @ModelAttribute("user_session") GxSysUser user,
								   @RequestParam Map<String, Object> parameterMap, Model model){
		if (orderField.length() > 0 && orderDirection.length() > 0) {
			page.setOrderBy(orderField);
			page.setOrder(orderDirection);
		}else {
			page.setOrderBy("createTime");
			page.setOrder("ASC");
		}
		//添加条件为根据当前用户查询
		parameterMap.put("filter_EQS_createUserId", user.getUserId());
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = vMeetProcinstManager.pagedQuery(page,propertyFilters);
		List<VMeetProcinst> list = (List<VMeetProcinst>) page.getResult();
		page.setResult(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "hys/hys-progress-list";
	}

	/**
	 * 查看详情
	 * @param rowId 申请表ID
	 * @param model
	 * @return
	 */
	@RequestMapping("to-hys-view")
	public String toHysView(String rowId,Model model){
		VMeetProcinst vMeetProcinst = vMeetProcinstManager.get(rowId);
		String instanceId = vMeetProcinst.getInstanceId();
		String instanceState = vMeetProcinst.getInstanceState();
		model.addAttribute("instanceState", instanceState);
		//申请表
		MeetingRoomLeaseApply meetingRoomLeaseApply = meetingRoomLeaseApplyManager.get(rowId);
		model.addAttribute("meetingRoomLeaseApply", meetingRoomLeaseApply);
		//附件
		List<Attachment> attachList = attachmentManager.findBy("relationId", rowId);
		model.addAttribute("attachList", attachList);
		//历史意见
		List<HistoryOpinion> opinionList = historyOpinionManager.findBy("tableId", rowId);
		model.addAttribute("opinionList", opinionList);
		//节点意见
		String hql = "from ProcActInstance where instanceId = ? and actInstRemark is not null order by actOrder asc";
		Object[] values = {instanceId};
		List<ProcActInstance> list = procActInstanceManager.find(hql, values);
		model.addAttribute("list", list);
		return "hys/hys-view";
	}

	/**
	 * 待办件
	 * @param page
	 * @param orderField
	 * @param orderDirection
	 * @param user
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("hys-task-list")
	public String hysTaskList(Page page,
							   @RequestParam(required = false, defaultValue = "") String orderField,
							   @RequestParam(required = false, defaultValue = "") String orderDirection,
							   @ModelAttribute("user_session") GxSysUser user,
							   @RequestParam Map<String, Object> parameterMap,Model model){
		if (orderField.length() > 0 && orderDirection.length() > 0) {
			page.setOrderBy(orderField);
			page.setOrder(orderDirection);
		}else {
			page.setOrderBy("activeTime");
			page.setOrder("ASC");
		}
		//添加条件为根据当前用户查询
		parameterMap.put("filter_EQS_handleUser", user.getUserName());
		parameterMap.put("filter_EQS_activeState", "激活");
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = vMeetInstActManager.pagedQuery(page, propertyFilters);
		List<VMeetInstAct> list = (List<VMeetInstAct>) page.getResult();
		page.setResult(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "hys/hys-task-list";
	}

	/**
	 * 到办理页面
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("hys-handle-page")
	public String toProcessHandle(String rowId,Model model){
		VMeetInstAct vMeetInstAct = vMeetInstActManager.get(rowId);
		ProcActInstance currentAct = procActInstanceManager.get(rowId);
		model.addAttribute("currentAct", currentAct);
		String instanceId = vMeetInstAct.getInstanceId();
		String businessId = vMeetInstAct.getBusinessId();
		String hql = "from ProcActInstance where instanceId = ? and actName = ?";
		Object[] values = {instanceId, vMeetInstAct.getActNext()};
		ProcActInstance nextAct = procActInstanceManager.findUnique(hql, values);
		model.addAttribute("nextAct", nextAct);
		if(!currentAct.getActName().equals("申请")){
			Object[] values1 = {instanceId, vMeetInstAct.getActBack()};
			ProcActInstance backAct = procActInstanceManager.findUnique(hql, values1);
			model.addAttribute("backAct", backAct);
		}
		//申请表
		MeetingRoomLeaseApply meetingRoomLeaseApply = meetingRoomLeaseApplyManager.get(businessId);
		model.addAttribute("meetingRoomLeaseApply", meetingRoomLeaseApply);
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
		return "hys/hys-handle-page";
	}

	/**
	 * 会议室申请办理
	 * @param actInstRowId 节点ID
	 * @param selectAct 选择下一步
	 * @param opinion 意见
	 * @param meetingRoomLeaseApply 申请表
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "hys-handle", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> hysHandle(String actInstRowId, String selectAct, String opinion, MeetingRoomLeaseApply meetingRoomLeaseApply,
								   @ModelAttribute("user_session") GxSysUser user, Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功",tabid = "T3424";//待修改
		boolean closeCurrent = true;
		Timestamp ts = DateUtil.getDate();
		MeetingRoomLeaseApply dest = null;
		String rowId = meetingRoomLeaseApply.getRowId();
		try{
			if(rowId != null && rowId.length() > 0){
				dest = meetingRoomLeaseApplyManager.get(rowId);
				beanMapper.copy(meetingRoomLeaseApply, dest);
//				dest.setModifyTime(ts);
//				dest.setModifyUserId(user.getUserId());
//				dest.setModifyUserName(user.getUserName());
			}
			meetingRoomLeaseApplyManager.save(dest);
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
				procActInstance1.setStepState("正在执行");
				procActInstance1.setActiveUserId(user.getUserId());
				procActInstance1.setActiveUserName(user.getUserName());
				procActInstance1.setActiveTime(ts);
				procActInstanceManager.save(procActInstance1);
				historyOpinion.setHandleProcess(user.getUserName()+"提交给"+procActInstance1.getHandleUser());
			}
			procInstanceManager.save(procInstance);
			historyOpinionManager.save(historyOpinion);
		}catch (Exception e) {
			tabid = "";
			statusCode = "300";
			message = "办理失败";
			closeCurrent = false;
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", closeCurrent);
		resMap.put("tabid", tabid);
		return resMap;
	}

	/**
	 * 会议室管理列表
	 * @param page
	 * @param orderField
	 * @param orderDirection
	 * @param user
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("hys-manager-list")
	public String hysManagerList(Page page,
								  @RequestParam(required = false, defaultValue = "") String orderField,
								  @RequestParam(required = false, defaultValue = "") String orderDirection,
								  @ModelAttribute("user_session") GxSysUser user,
								  @RequestParam Map<String, Object> parameterMap, Model model){
		if (orderField.length() > 0 && orderDirection.length() > 0) {
			page.setOrderBy(orderField);
			page.setOrder(orderDirection);
		}else {
			page.setOrder("ASC");
			page.setOrderBy("createTime");
		}
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = meetingRoomInfoManager.pagedQuery(page,propertyFilters);
		List<MeetingRoomInfo> list = (List<MeetingRoomInfo>) page.getResult();
		page.setResult(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "hys/hys-manager-list";
	}

	/**
	 * 到新增会议室页面
	 * @return
	 */
	@RequestMapping("to-meet-input")
	public String toHysInput( @RequestParam(required = false, defaultValue = "") String rowId, Model model) {
		if(rowId != null){
			MeetingRoomInfo meetingRoomInfo = meetingRoomInfoManager.get(rowId);
			model.addAttribute("meetingRoomInfo",meetingRoomInfo);
		}
		return "hys/meet-input";
	}

	/**
	 * 会议室更新保存
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "meet-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> meetSave(@ModelAttribute("user_session") GxSysUser user, MeetingRoomInfo meetingRoomInfo) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "保存成功";
		boolean closeCurrent = true;
		Timestamp ts = DateUtil.getDate();
		MeetingRoomInfo dest = null;
		String rowId = meetingRoomInfo.getRowId();
		try{
			if(rowId != null && rowId.length() > 0){
				dest = meetingRoomInfoManager.get(rowId);
				beanMapper.copy(meetingRoomInfo, dest);
			}else{
				dest = meetingRoomInfo;
				dest.setRowId(null);
				dest.setCreateTime(ts);
			}
			meetingRoomInfoManager.save(dest);
		}catch (Exception e) {
			// TODO: handle exception
			statusCode = "300";
			closeCurrent = false;
			message = "保存失败！";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", closeCurrent);
		return resMap;
	}

	/**
	 * 会议室删除选中项
	 * @param delids
	 * @return
	 */
	@RequestMapping(value="meet-remove")
	public @ResponseBody
	Map<String, Object> meetRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					meetingRoomInfoManager.removeById(rowId);
				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "删除失败";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("reload", true);
		return resMap;
	}

}
