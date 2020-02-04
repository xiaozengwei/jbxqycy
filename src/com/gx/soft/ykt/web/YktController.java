package com.gx.soft.ykt.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.spring.TimeStampPropertyEditor;
import com.gx.soft.common.util.SendMessageUtil;
import com.gx.soft.fwzl.persistence.domain.*;
import com.gx.soft.fwzl.persistence.manager.*;
import com.gx.soft.hys.persistence.domain.MeetingRoomLeaseApply;
import com.gx.soft.mobile.persistence.domain.EnterpriseInfo;
import com.gx.soft.mobile.persistence.manager.EnterpriseInfoManager;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.sys.persistence.domain.GxSysFunction;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.manager.GxRecordManager;
import com.gx.soft.sys.persistence.manager.GxSysOrgManager;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.ykt.persistence.domain.*;
import com.gx.soft.ykt.persistence.manager.*;
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
import java.util.Random;

@Controller
@RequestMapping("ykt")
@SessionAttributes("user_session")
public class YktController {
	static Logger logger = Logger.getLogger(YktController.class);
	@Autowired
	private GxSysOrgManager gxSysOrgManager;
	@Autowired
	private VUserManager vUserManager;

	@Autowired
	private OneCardApplyManager oneCardApplyManager;

	@Autowired
	private OneCardInfoManager oneCardInfoManager;

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
	private HistoryOpinionManager historyOpinionManager;

	@Autowired
	private VYktInstActManager vYktInstActManager;

	@Autowired
	private VYktProcinstManager vYktProcinstManager;

	@Autowired
	protected EnterpriseInfoManager enterpriseInfoManager;

	@Autowired
	private OneCardPersonDetailManager oneCardPersonDetailManager;
	
	private BeanMapper beanMapper = new BeanMapper();
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
							  ServletRequestDataBinder binder) throws Exception {
		// TODO Auto-generated method stub
		binder.registerCustomEditor(Timestamp.class,
				new TimeStampPropertyEditor());
	}


	/**
	 * 到一卡通自助申请页面
	 * @return
	 */
//	@RequestMapping("to-ykt-apply")
	public String toYktApply(String state, Model model) {
		String hql = "from ProcAct where processId = ? and backAct = ?";
		Object[] values = {"hyszl", "申请"};
		ProcAct procAct = procActManager.findUnique(hql, values);
		model.addAttribute("procAct",procAct);
		model.addAttribute("state",state);
		return "ykt/ykt-apply";
	}

	/**
	 * 一卡通申请提交
	 * @param user
	 * @param oneCardApply
	 * @param attachmentId
	 * @param model
	 * @return
	 */
//	@RequestMapping(value = "ykt-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> yktSave(@ModelAttribute("user_session") GxSysUser user,
								OneCardApply oneCardApply, String attachmentId, Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		OneCardApply dest = null;
		String rowId = oneCardApply.getRowId();
		try{
			if(rowId != null && rowId.length() > 0){
				dest = oneCardApplyManager.get(rowId);
				beanMapper.copy(oneCardApply, dest);
				dest.setModifyUserId(user.getUserId());
				dest.setModifyTime(ts);
				dest.setModifyUserName(user.getUserName());
			}else{
				dest = oneCardApply;
				dest.setCreateUserId(user.getUserId());
				dest.setCreateUserName(user.getUserName());
				dest.setCreateTime(ts);
			}
			oneCardApplyManager.save(dest);
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
			ProcTemplate procTemplate = procTemplateManager.findUniqueBy("processKey", "yktzzsq");
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
				procActInstance.setActBack(act.getBackAct());
				procActInstance.setActNext(act.getNextAct());
				procActInstance.setHandleUser(act.getHandleUserName());
				procActInstance.setHandleUser1(act.getHandleUserName1());
				procActInstance.setActOrder(act.getActOrder());
				if(act.getActName().equals("申请")){
					procActInstance.setHandleUser(user.getUserName());
					procActInstance.setStepState("已同意");
					procActInstance.setFinishTime(ts);
				}else if(act.getActName().equals(actName)){
					procActInstance.setActiveState("激活");
					procActInstance.setStepState("正在执行");
					procActInstance.setActiveUserId(user.getUserId());
					procActInstance.setActiveUserName(user.getUserName());
					procActInstance.setActiveTime(ts);
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
	 * 一卡通申请进度查询
	 * @param page
	 * @param orderField
	 * @param orderDirection
	 * @param user
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("ykt-progress-list")
	public String yktProgressList(Page page,
								  @RequestParam(required = false, defaultValue = "createTime") String orderField,
								  @RequestParam(required = false, defaultValue = "desc") String orderDirection,
								  @ModelAttribute("user_session") GxSysUser user,
								  @RequestParam Map<String, Object> parameterMap, Model model){
		page.setOrderBy(orderField);
		page.setOrder(orderDirection);
		//添加条件为根据当前用户查询
		if(user.getDataStatus() != null && user.getDataStatus().length() > 0){
			parameterMap.put("filter_INS_receivePlace", user.getDataStatus());
		}
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = vYktProcinstManager.pagedQuery(page,propertyFilters);
		List<VYktProcinst> list = (List<VYktProcinst>) page.getResult();
		page.setResult(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "ykt/ykt-progress-list";
	}

	/**
	 * 一卡通申请查看详情
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("to-ykt-view")
	public String toYktView(String rowId,Model model){
		VYktProcinst vYktProcinst = vYktProcinstManager.get(rowId);
		String instanceState = vYktProcinst.getInstanceState();
		model.addAttribute("instanceState", instanceState);
		//申请表
		OneCardApply oneCardApply = oneCardApplyManager.get(rowId);
		model.addAttribute("oneCardApply", oneCardApply);
		//一卡通人员明细表
		List<OneCardPersonDetail> personList = oneCardPersonDetailManager.findBy("relationId", rowId);
		model.addAttribute("personList", personList);
		//历史意见
		List<HistoryOpinion> opinionList = historyOpinionManager.findBy("tableId", rowId);
		model.addAttribute("opinionList", opinionList);
		//附件
//		List<Attachment> attachList = attachmentManager.findBy("relationId", rowId);
//		model.addAttribute("attachList", attachList);
		//节点意见
//		String instanceId = vYktProcinst.getInstanceId();
//		String hql = "from ProcActInstance where instanceId = ? and actInstRemark is not null order by actOrder asc";
//		Object[] values = {instanceId};
//		List<ProcActInstance> list = procActInstanceManager.find(hql, values);
//		model.addAttribute("list", list);
		return "ykt/ykt-view";
	}


	/********************************web后台审核********************************/

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
	@RequestMapping("ykt-task-list")
	public String yktTaskList(Page page,
							  @RequestParam(required = false, defaultValue = "activeTime") String orderField,
							  @RequestParam(required = false, defaultValue = "ASC") String orderDirection,
							  @ModelAttribute("user_session") GxSysUser user,
							  @RequestParam Map<String, Object> parameterMap,Model model){
		page.setOrderBy(orderField);
		page.setOrder(orderDirection);
		//添加条件为根据当前用户查询
		parameterMap.put("filter_EQS_activeState", "激活");
		parameterMap.put("filter_EQS_handleUser", user.getUserName());
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = vYktInstActManager.pagedQuery(page, propertyFilters);
		List<VYktInstAct> list = (List<VYktInstAct>) page.getResult();
		page.setResult(list);
		model.addAttribute("yktList", list);
		model.addAttribute("page", page);
		return "ykt/ykt-task-list";
	}

	/**
	 * 到一卡通申请办理页面
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("ykt-handle-page")
	public String toProcessHandle(String rowId,Model model){
		System.out.println(rowId);
		VYktInstAct vYktInstAct = vYktInstActManager.get(rowId);
		ProcActInstance currentAct = procActInstanceManager.get(rowId);
		model.addAttribute("currentAct", currentAct);
		String instanceId = vYktInstAct.getInstanceId();
		String businessId = vYktInstAct.getBusinessId();
		String hql = "from ProcActInstance where instanceId = ? and actName = ?";
		Object[] values = {instanceId, vYktInstAct.getActNext()};
		ProcActInstance nextAct = procActInstanceManager.findUnique(hql, values);
		model.addAttribute("nextAct", nextAct);
		if(!currentAct.getActName().equals("申请")){
			Object[] values1 = {instanceId, vYktInstAct.getActBack()};
			ProcActInstance backAct = procActInstanceManager.findUnique(hql, values1);
			model.addAttribute("backAct", backAct);
		}
		//申请表
		OneCardApply oneCardApply = oneCardApplyManager.get(businessId);
		model.addAttribute("oneCardApply", oneCardApply);
		//一卡通人员明细表
		List<OneCardPersonDetail> personList = oneCardPersonDetailManager.findBy("relationId", businessId);
		model.addAttribute("personList", personList);
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
		return "ykt/ykt-handle-page";
	}

	/**
	 * 一卡通申请办理
	 * @param actInstRowId 节点实例ID
	 * @param selectAct 选择下一步
	 * @param opinion 意见
	 * @param oneCardApply 一卡通申请表
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "ykt-handle", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> yktHandle(String actInstRowId, String selectAct, String opinion, OneCardApply oneCardApply,
								  @ModelAttribute("user_session") GxSysUser user, Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功",tabid = "T3441";//2019-12-06修改
		boolean closeCurrent = true;
		Timestamp ts = DateUtil.getDate();
		OneCardApply dest = null;
		String rowId = oneCardApply.getRowId();
		try{
			//得到当前节点实例
			ProcActInstance procActInstance = procActInstanceManager.get(actInstRowId);
			String actName = procActInstance.getActName();
			String actBack = procActInstance.getActBack();
			String actNext = procActInstance.getActNext();
			String instanceId = procActInstance.getInstanceId();
			if(rowId != null && rowId.length() > 0){
				dest = oneCardApplyManager.get(rowId);
				beanMapper.copy(oneCardApply, dest);
				dest.setModifyUserName(user.getUserName());
				dest.setModifyUserId(user.getUserId());
				dest.setModifyTime(ts);
				if(actName.equals("审核") && selectAct.equals(actNext)){
					//判断是否已生成短信验证码
					String verifyCode = dest.getVerificationCode() == null ? "" : dest.getVerificationCode();
					if(verifyCode.equals("")){
						verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);//生成短信验证码
						dest.setVerificationCode(verifyCode);
						String content = "【研创园】您申请的卡片已经审核完成，请于收到通知后3个工作日前往"+dest.getReceivePlace()+"领取卡片，卡片验证码："+verifyCode+"，请勿泄露。备注："+opinion;
						SendMessageUtil.sendMessage(dest.getApplicantPhone(), content);
						logger.info("---------------审核通过----------------短信验证码="+verifyCode+"----------------rowId="+rowId);
					}
				}
			}
			oneCardApplyManager.save(dest);
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
				procInstance.setActiveState(null);
				procInstance.setEndTime(ts);
				historyOpinion.setHandleProcess(user.getUserName()+"提交给结束环节");
			}else{
				procActInstance1.setActiveTime(ts);
				procActInstance1.setActiveState("激活");
				procActInstance1.setActiveUserId(user.getUserId());
				procActInstance1.setActiveUserName(user.getUserName());
				procActInstance1.setStepState("正在执行");
				procActInstanceManager.save(procActInstance1);
				historyOpinion.setHandleProcess(user.getUserName()+"提交给"+procActInstance1.getHandleUser());
			}
			procInstanceManager.save(procInstance);
			historyOpinionManager.save(historyOpinion);
		}catch (Exception e) {
			message = "办理失败";
			statusCode = "300";
			tabid = "";
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
	 *
	 * 企业信息管理
	 */
	@RequestMapping("enterprise-list")
	public String enterpriseList(Page page,
							  @RequestParam(required = false, defaultValue = "createTime") String orderField,
							  @RequestParam(required = false, defaultValue = "ASC") String orderDirection,
							  @ModelAttribute("user_session") GxSysUser user,
							  @RequestParam Map<String, Object> parameterMap,Model model){
		page.setOrderBy(orderField);
		page.setOrder(orderDirection);
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = enterpriseInfoManager.pagedQuery(page, propertyFilters);
		List<EnterpriseInfo> list = (List<EnterpriseInfo>) page.getResult();
		page.setResult(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "ykt/enterprise-list";
	}


	/**
	 * 到企业添加/修改页面
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("enterprise-input")
	public String enterpriseInput(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		if (rowId != null) {
			EnterpriseInfo enterpriseInfo = enterpriseInfoManager.get(rowId);
			model.addAttribute("model",enterpriseInfo);
		}
		return "ykt/enterprise-input";
	}

	/**
	 * 企业信息保存
	 * @param enterpriseInfo
	 * @param user
	 * @return
	 */
	@RequestMapping("enterprise-save")
	public @ResponseBody
	Map<String, Object> enterpriseSave(EnterpriseInfo enterpriseInfo,  @ModelAttribute("user_session") GxSysUser user) {
		Map<String, Object> resMap = new HashMap<>();
		String statusCode = "200", message = "操作成功";
		Boolean closeCurrent = true, reload = true;
		Timestamp ts = DateUtil.getDate();
		try {
			EnterpriseInfo dest;
			String id = enterpriseInfo.getRowId();
			if (id != null && id.length() > 0) {
				dest = enterpriseInfoManager.get(id);
				beanMapper.copy(enterpriseInfo, dest);
			} else {
				enterpriseInfo.setRowId(null);
				dest = enterpriseInfo;
				dest.setCreateTime(ts);
				dest.setCreateUserId(user.getUserId());
			}
			enterpriseInfoManager.save(dest);
		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			closeCurrent = false;
			reload = false;
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", closeCurrent);
		resMap.put("reload", reload);
		return resMap;
	}

	/**
	 * 查看详情
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("enterprise-detail")
	public String enterpriseDetail(String rowId, Model model) {
		if (rowId != null) {
			EnterpriseInfo enterpriseInfo = enterpriseInfoManager.get(rowId);
			model.addAttribute("model",enterpriseInfo);
		}
		return "ykt/enterprise-detail";
	}

	/**
	 * 查询所有申请
	 */
	@RequestMapping("query-all-list")
	public String queryAll(Page page,
								  @RequestParam(required = false, defaultValue = "createTime") String orderField,
								  @RequestParam(required = false, defaultValue = "DESC") String orderDirection,
								  @ModelAttribute("user_session") GxSysUser user,
								  @RequestParam Map<String, Object> parameterMap, Model model){
		page.setOrderBy(orderField);
		page.setOrder(orderDirection);
		//添加条件为根据当前用户查询
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = vYktProcinstManager.pagedQuery(page,propertyFilters);
		List<VYktProcinst> list = (List<VYktProcinst>) page.getResult();
		page.setResult(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "ykt/query-all-list";
	}

	/**
	 * 卡片领取管理
	 */
	@RequestMapping("card-receive-list")
	public String cardReceive(Page page,
						   @RequestParam(required = false, defaultValue = "createTime") String orderField,
						   @RequestParam(required = false, defaultValue = "desc") String orderDirection,
						   @ModelAttribute("user_session") GxSysUser user,
						   @RequestParam Map<String, Object> parameterMap, Model model){
		page.setOrderBy(orderField);
		page.setOrder(orderDirection);
		//添加条件为根据当前用户查询
		String receivePlace = user.getDataStatus() == null ? "" : user.getDataStatus();
		parameterMap.put("filter_EQS_receivePlace",receivePlace);
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		String hql = "from OneCardApply where verificationCode is not null";
		page = oneCardApplyManager.pagedQuery1(hql,page,propertyFilters);
		List<OneCardApply> list = (List<OneCardApply>) page.getResult();
		page.setResult(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "ykt/card-receive-list";
	}

	/**
	 * 设置已领取
	 * @param rowId
	 * @param user
	 * @return
	 */
	@RequestMapping("receive-card")
	public @ResponseBody
	Map<String, Object> receiveCard(String rowId,  @ModelAttribute("user_session") GxSysUser user) {
		Map<String, Object> resMap = new HashMap<>();
		String statusCode = "200", message = "操作成功";
		Boolean reload = true;
		try {
			OneCardApply oneCardApply = oneCardApplyManager.get(rowId);
			oneCardApply.setIsReceive("是");
			oneCardApplyManager.save(oneCardApply);
		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			reload = false;
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("reload", reload);
		return resMap;
	}


}
