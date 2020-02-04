package com.gx.soft.mobile.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.spring.TimeStampPropertyEditor;
import com.gx.core.util.Md5Utils;
import com.gx.core.util.StringUtils;
import com.gx.soft.common.util.*;
import com.gx.soft.common.wxpay.WXPay;
import com.gx.soft.common.wxpay.WXPayConfig;
import com.gx.soft.common.wxpay.WXPayConfigImpl;
import com.gx.soft.common.wxpay.WXPayUtil;
import com.gx.soft.fwzl.persistence.domain.*;
import com.gx.soft.fwzl.persistence.manager.*;
import com.gx.soft.hys.persistence.domain.MeetingRoomLeaseApply;
import com.gx.soft.hys.persistence.domain.VMeetProcinst;
import com.gx.soft.hys.persistence.manager.MeetingRoomLeaseApplyManager;
import com.gx.soft.hys.persistence.manager.VMeetProcinstManager;
import com.gx.soft.mobile.persistence.domain.*;
import com.gx.soft.mobile.persistence.manager.*;
import com.gx.soft.mobile.persistence.runnable.SdRechargeRunnable;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.sd.persistence.domain.*;
import com.gx.soft.sd.persistence.manager.*;
import com.gx.soft.sys.persistence.domain.GxSysDicRecord;
import com.gx.soft.sys.persistence.domain.PeripheralMatching;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.domain.ZbptAttachment;
import com.gx.soft.sys.persistence.manager.*;
import com.gx.soft.ykt.persistence.domain.*;
import com.gx.soft.ykt.persistence.manager.*;
import com.gx.soft.ykt.persistence.model.OneCardModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 微信端
 */
@Controller
@RequestMapping("mobile")
@SessionAttributes("wxUser")
public class MobileController {
	static Logger logger = Logger.getLogger(MobileController.class);
	@Autowired
	private VUserManager vUserManager;
	@Autowired
	private RcgyLeseApplyManager rcgyLeseApplyManager;
	@Autowired
	private ProcTemplateManager procTemplateManager;
	@Autowired
	private ProcInstanceManager procInstanceManager;
	@Autowired
	private ProcActManager procActManager;
	@Autowired
	protected ProcActInstanceManager procActInstanceManager;
	@Autowired
	private ProcSignatureManager procSignatureManager;
	@Autowired
	private GxRecordManager gxRecordManager;
	@Autowired
	protected VFwzlProcinstManager vFwzlProcinstManager;
	@Autowired
	protected VFwzlInstActManager vFwzlInstActManager;
	@Autowired
	protected HistoryOpinionManager historyOpinionManager;
	@Autowired
	private MeetingRoomLeaseApplyManager meetingRoomLeaseApplyManager;
	@Autowired
	private VMeetProcinstManager vMeetProcinstManager;
	@Autowired
	private OneCardApplyManager oneCardApplyManager;
	@Autowired
	private VYktProcinstManager vYktProcinstManager;
	@Autowired
	private WxUserManager wxUserManager;
	@Autowired
	private WxAttachmentManager wxAttachmentManager;
	@Autowired
	private WxMessageReleaseManager wxMessageReleaseManager;
	@Autowired
	private HysZzfwManager hysZzfwManager;
	@Autowired
	private WxUnifiedOrderManager wxUnifiedOrderManager;
	@Autowired
	protected WxPayResultManager wxPayResultManager;
	@Autowired
	private PeripheralMatchingManager peripheralMatchingManager;
	@Autowired
	private ZbptAttachmentManager zbptAttachmentManager;

	@Autowired
	private WxUserYktManager wxUserYktManager;
	@Autowired
	private SdMonthBillManager sdMonthBillManager;
	@Autowired
	private WaterDataRecordManager waterDataRecordManager;
	@Autowired
	private ElectricDataRecordManager electricDataRecordManager;
	@Autowired
	private FloorRoomManager floorRoomManager;
	@Autowired
	private SdRechargeRecordManager sdRechargeRecordManager;
	@Autowired
	private WxRefundResultManager wxRefundResultManager;

	@Autowired
	private FloorRoomInDeviceManager floorRoomInDeviceManager;

	@Autowired
	private WaterFloorRoomInDeviceManager waterFloorRoomInDeviceManager;

	@Autowired
	private WaterAccountManager waterAccountManager;

	@Autowired
	private ElectricMonthRecordManager electricMonthRecordManager;

	@Autowired
	private WaterMonthRecordManager waterMonthRecordManager;
	@Autowired
	private DeviceOnAndOffManager deviceOnAndOffManager;
	@Autowired
	private ElectricDayRecordManager electricDayRecordManager;
	@Autowired
	private SdRechargeFailRecordManager sdRechargeFailRecordManager;

	@Autowired
	private UserAgreementManager userAgreementManager;

	@Autowired
	private EnterpriseInfoManager enterpriseInfoManager;

	@Autowired
	private OneCardPersonDetailManager oneCardPersonDetailManager;

	@Autowired
	private OneCardImportRecordManager oneCardImportRecordManager;

	@Autowired
	private OneCardOrderManager oneCardOrderManager; //一卡通下单

	@Autowired
	private HolidayRecordManager holidayRecordManager;

	@Autowired
	private WeekendWeekRecordManager weekendWeekRecordManager;



	@Autowired
	private WxUserRoomManager wxUserRoomManager;
	
	private BeanMapper beanMapper = new BeanMapper();
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
							  ServletRequestDataBinder binder) throws Exception {
		// TODO Auto-generated method stub
		binder.registerCustomEditor(Timestamp.class,
				new TimeStampPropertyEditor());
	}

	/**
	 * 到主页面方法
	 * @param code
	 * @param state
	 * @param request
	 * @return
	 */
	@RequestMapping("to-mobile-index")
	public String toMobileIndex(String code, String state,HttpServletRequest request) {
		//通过code换取网页授权access_token
//		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxf14d663135422c5d&secret=0d0fff47f7ce518964a2c873abe2787d&code="+code+"&grant_type=authorization_code";//测试环境
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxe4bcb04f38969b18&secret=501c5dcbc459dc054d7ac47d2593cece&code="+code+"&grant_type=authorization_code";//正式环境
		String response = HttpClient.sendHttpRequest(url, "", "GET", "application/json;charset=utf-8");
		JSONObject result = JSONObject.parseObject(response);
		String access_token = (String) result.get("access_token");
		String openid = (String) result.get("openid");
		/**
		 * { "access_token":"ACCESS_TOKEN",
		 *"expires_in":7200,
		 *"refresh_token":"REFRESH_TOKEN",
		 *"openid":"OPENID",
		 *"scope":"SCOPE" }
		 */
		//拉取用户信息
		String url1 = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
		String response1 = HttpClient.sendHttpRequest(url1, "", "GET", "application/json;charset=utf-8");
		/**
		 * {    "openid":" OPENID",
		 " nickname": NICKNAME,
		 "sex":"1",
		 "province":"PROVINCE"
		 "city":"CITY",
		 "country":"COUNTRY",
		 "headimgurl":    "http://thirdwx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46",
		 "privilege":[ "PRIVILEGE1" "PRIVILEGE2"     ],
		 "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
		 }
		 */
		try{
			JSONObject result1 = JSONObject.parseObject(response1);
			String nickname = result1.getString("nickname");
			Integer sex = result1.getInteger("sex");
			String province = result1.getString("province");
			String city = result1.getString("city");
			String country = result1.getString("country");
			String headimgurl = result1.getString("headimgurl");
			String privilege = result1.get("privilege") == null ? "" : result1.get("privilege").toString();
			String unionid = result1.get("unionid") == null ? result1.getString("unionid"):null;
			//根据openid得到用户信息
			WxUser wxUser = wxUserManager.findUniqueBy("openid", openid);
			if(wxUser == null){
				wxUser = new WxUser();
				wxUser.setRowId(null);
			}
			wxUser.setOpenid(openid);
			wxUser.setNickname(nickname);
			wxUser.setSex(sex);
			wxUser.setProvince(province);
			wxUser.setCity(city);
			wxUser.setCountry(country);
			wxUser.setHeadimgurl(headimgurl);
			wxUser.setPrivilege(privilege);
			wxUser.setUnionid(unionid);
			wxUserManager.save(wxUser);
			// 放入session
			HttpSession session = request.getSession();
			session.setAttribute("wxUser", wxUser);
		}catch (Exception e){
			e.printStackTrace();
			return "mobile/fail";
		}
		return "redirect:index.do";
	}

	/**
	 * 到微信主页面
	 * @param model
	 * @return
	 */
	@RequestMapping("index")
	public String index(Model model, HttpServletRequest request) {
		//测试session
//		HttpSession session = request.getSession();
//		if(session.getAttribute("wxUser") == null){
//			WxUser wxUser = wxUserManager.findUniqueBy("openid", "o1WiuuBIshTJjxV9VeMVxONXtfFU");
//			session.setAttribute("wxUser", wxUser);
//		}
		//2019-12-06暂时提供测试权限
		HttpSession session = request.getSession();
		WxUser wxUser = (WxUser) session.getAttribute("wxUser");
		model.addAttribute("wxUser",wxUser);
		List<WxMessageRelease> list = wxMessageReleaseManager.getAll("createTime", false);
		model.addAttribute("wxMessageRelease",list.get(0));
		return "mobile/index-1";
	}

	/**
	 *
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@RequestMapping("validate")
	public @ResponseBody String validate(String signature, String timestamp, String nonce, String echostr){
		String sha1 = "";
		String token = "nanjing";
		String[] arr = {token,timestamp,nonce};
		Arrays.sort(arr);
		for (int i = 0;i<arr.length;i++){
			sha1 += arr[i];
		}
		if(SHA1Util.getSha1(sha1).equals(signature)){
			return echostr;
		}else{
			return null;
		}
	}

	/**
	 * 到房屋租赁申请页面
	 * @return
	 */
	@RequestMapping("to-fwzl-form")
	public String toFwzlForm(String rowId, Model model) {
		if(rowId != null && rowId.length() > 0){
			RcgyLeseApply rcgyLeseApply = rcgyLeseApplyManager.get(rowId);
			model.addAttribute("rcgyLeseApply",rcgyLeseApply);
		}
		return "mobile/fwzl-form";
	}

	/**
	 * 房屋租赁申请提交-微信端
	 * @param rcgyLeseApply
	 * @param attachmentId
	 * @return
	 */
	@RequestMapping(value = "fwzl-save", method = RequestMethod.POST)
	public String FwzlSave(@ModelAttribute("wxUser") WxUser wxUser,
			RcgyLeseApply rcgyLeseApply,String attachmentId) {
		String statusCode = "200";
		Timestamp ts = DateUtil.getDate();
		RcgyLeseApply dest = null;
		String rowId = rcgyLeseApply.getRowId();
		try{
			if(rowId != null && rowId.length() > 0){
				dest = rcgyLeseApplyManager.get(rowId);
				beanMapper.copy(rcgyLeseApply, dest);
				dest.setModifyTime(ts);
				dest.setModifyUserId(wxUser.getOpenid());
				dest.setModifyUserName(wxUser.getNickname());
			}else{
				dest = rcgyLeseApply;
				dest.setRowId(null);
				dest.setCreateTime(ts);
				dest.setCreateUserId(wxUser.getOpenid());
				dest.setCreateUserName(wxUser.getNickname());
			}
			rcgyLeseApplyManager.save(dest);
			//关联附件
			rowId = rcgyLeseApply.getRowId();
			relationFile(attachmentId, rowId);
			//判断新增还是编辑
			ProcInstance pi = procInstanceManager.findUniqueBy("businessId", rowId);
			if(pi == null){
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
				procInstance.setCreateUserId(wxUser.getOpenid());
				procInstance.setCreateUserName(wxUser.getNickname());
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
						procActInstance.setHandleUser(wxUser.getNickname());
						procActInstance.setHandleUser1(wxUser.getOpenid());
						procActInstance.setStepState("已同意");
						procActInstance.setFinishTime(ts);
					}else if(act.getActName().equals(actName)){
						procActInstance.setActiveTime(ts);
						procActInstance.setActiveState("激活");
						procActInstance.setActiveUserId(wxUser.getOpenid());
						procActInstance.setActiveUserName(wxUser.getNickname());
						procActInstance.setStepState("正在执行");
					}
					//保存节点实例
					procActInstanceManager.save(procActInstance);
					//创建历史意见表
					HistoryOpinion historyOpinion = new HistoryOpinion();
					historyOpinion.setTableId(rowId);
					historyOpinion.setPiId(instanceId);
					historyOpinion.setHandleStage("申请");
					historyOpinion.setHandleProcess(wxUser.getNickname()+"提交给"+procAct.getHandleUserName());
					historyOpinion.setHandleOpinion("");
					historyOpinion.setHandleUser(wxUser.getNickname());
					historyOpinion.setHandleTime(ts);
					historyOpinionManager.save(historyOpinion);
				}
			}else{
				//当前步骤取消激活状态
				String instanceId = pi.getRowId();
				String hql = "from ProcActInstance where instanceId = ? and actName = ?";
				Object[] values = {instanceId, "申请"};
				ProcActInstance currentAct = procActInstanceManager.findUnique(hql, values);
				currentAct.setActiveState(null);
				currentAct.setStepState("已同意");
				currentAct.setFinishTime(ts);
				procActInstanceManager.save(currentAct);
				//下一步设置激活状态
				String actNext = currentAct.getActNext();
				Object[] values1 = {instanceId,actNext};
				ProcActInstance NextAxt = procActInstanceManager.findUnique(hql, values1);
				NextAxt.setActiveUserId(wxUser.getOpenid());
				NextAxt.setActiveUserName(wxUser.getNickname());
				NextAxt.setActiveState("激活");
				NextAxt.setStepState("正在进行");
				NextAxt.setActiveTime(ts);
				procActInstanceManager.save(NextAxt);
				//设置流程实例状态
				pi.setInstanceState(actNext);
				procInstanceManager.save(pi);
				//创建历史意见表
				HistoryOpinion historyOpinion = new HistoryOpinion();
				historyOpinion.setTableId(rowId);
				historyOpinion.setPiId(instanceId);
				historyOpinion.setHandleStage("申请");
				historyOpinion.setHandleProcess(wxUser.getNickname()+"提交给"+NextAxt.getHandleUser());
				historyOpinion.setHandleOpinion("");
				historyOpinion.setHandleUser(wxUser.getNickname());
				historyOpinion.setHandleTime(ts);
				historyOpinionManager.save(historyOpinion);
			}
		}catch (Exception e) {
			// TODO: handle exception
			statusCode = "300";
			e.printStackTrace();
		}
		if(statusCode.equals("200")){
			return "mobile/apply-success";
		}else{
			return "mobile/apply-fail";
		}
	}

	/**
	 * 房屋租赁申请进度查询
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("fwzl-progress-list")
	public String fwzlProgressList(@ModelAttribute("wxUser") WxUser wxUser,
								   @RequestParam Map<String, Object> parameterMap,Model model){
		//添加条件为根据当前用户查询
		parameterMap.put("filter_EQS_createUserId", wxUser.getOpenid());
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		List<VFwzlProcinst> list = vFwzlProcinstManager.find(propertyFilters);
		model.addAttribute("list", list);
		model.addAttribute("parameterMap", parameterMap);
		return "mobile/fwzl-progress-list";
	}

	/**
	 * 房屋租赁查看详情
	 * @param model
	 * @return
	 */
	@RequestMapping("to-fwzl-view")
	public String toFwzlView(String rowId, Model model){
		VFwzlProcinst vFwzlProcinst = vFwzlProcinstManager.get(rowId);
		String instanceState = vFwzlProcinst.getInstanceState();
		model.addAttribute("instanceState", instanceState);
		//申请表
		RcgyLeseApply rcgyLeseApply = rcgyLeseApplyManager.get(rowId);
		model.addAttribute("rcgyLeseApply", rcgyLeseApply);
		//附件
		List<WxAttachment> attachList = wxAttachmentManager.findBy("relationId", rowId);
		model.addAttribute("attachList", attachList);
		//历史意见
//		List<HistoryOpinion> opinionList = historyOpinionManager.findBy("tableId", rowId);
//		model.addAttribute("opinionList", opinionList);
//		String hql = "from ProcActInstance where instanceId = ? and actInstRemark is not null order by actOrder asc";
//		Object[] values = {vFwzlProcinst.getInstanceId()};
//		List<ProcActInstance> list = procActInstanceManager.find(hql, values);
//		model.addAttribute("list", list);
		return "mobile/fwzl-view";
	}

	/**
	 * 到会议室租赁申请页面
	 * @return
	 */
	@RequestMapping("to-hys-form")
	public String toHysForm(String rowId, Model model) {
		if(rowId != null && rowId.length() > 0){
			MeetingRoomLeaseApply meetingRoomLeaseApply = meetingRoomLeaseApplyManager.get(rowId);
			model.addAttribute("meetingRoomLeaseApply",meetingRoomLeaseApply);
		}
		return "mobile/hys-form";
	}

	/**
	 * 会议室保存、到下一步选择增值服务页面
	 * @param meetingRoomLeaseApply
	 * @return
	 */
	@RequestMapping(value = "select-zzfw", method = RequestMethod.POST)
	public String selectZzfw(@ModelAttribute("wxUser") WxUser wxUser, MeetingRoomLeaseApply meetingRoomLeaseApply, Model model) {
		Timestamp ts = DateUtil.getDate();
		MeetingRoomLeaseApply dest = null;
		String rowId = meetingRoomLeaseApply.getRowId();
		try{
			if(rowId != null && rowId.length() > 0){
				dest = meetingRoomLeaseApplyManager.get(rowId);
				beanMapper.copy(meetingRoomLeaseApply, dest);
				dest.setModifyTime(ts);
				dest.setModifyUserName(wxUser.getNickname());
				dest.setModifyUserId(wxUser.getOpenid());
				//获取增值服务
				HysZzfw hysZzfw = hysZzfwManager.findUniqueBy("", rowId);
				model.addAttribute("hysZzfw",hysZzfw);
			}else{
				dest = meetingRoomLeaseApply;
				dest.setRowId(null);
				dest.setCreateTime(ts);
				dest.setCreateUserId(wxUser.getOpenid());
				dest.setCreateUserName(wxUser.getNickname());
			}
			meetingRoomLeaseApplyManager.save(dest);
		}catch (Exception e){
			e.printStackTrace();
		}
		rowId = dest.getRowId();
		model.addAttribute("rowId",rowId);
		return "mobile/select-zzfw";
	}

	/**
	 * 会议室租赁保存-微信端
	 * @return
	 */
	@RequestMapping(value = "hys-submit", method = RequestMethod.POST)
	public String hysSubmit(@ModelAttribute("wxUser") WxUser wxUser, String meetRowId, HysZzfw hysZzfw) {
		String statusCode = "200";
		Timestamp ts = DateUtil.getDate();
		HysZzfw dest = null;
		String rowId = hysZzfw.getRowId();
		try{
			if(rowId != null && rowId.length() > 0){
				dest = hysZzfwManager.get(rowId);
				beanMapper.copy(hysZzfw, dest);
				dest.setModifyTime(ts);
				dest.setModifyUserId(wxUser.getOpenid());
			}else{
				dest = hysZzfw;
				dest.setRowId(null);
				dest.setRelationId(meetRowId);
				dest.setCreateTime(ts);
				dest.setCreateUserId(wxUser.getOpenid());
			}
			hysZzfwManager.save(dest);
			//判断新增还是修改
			ProcInstance pi = procInstanceManager.findUniqueBy("businessId", rowId);
			if(pi == null){
				//创建流程实例
				ProcTemplate procTemplate = procTemplateManager.findUniqueBy("processKey", "hyszl");
				String processId = procTemplate.getProcessId();
				ProcInstance procInstance = new ProcInstance();
				procInstance.setProcessId(processId);
				procInstance.setProcessName(procTemplate.getProcessName());
				procInstance.setBusinessId(meetRowId);
				String hql = "from ProcAct where processId = ? and backAct = ?";
				Object[] values = {processId, "申请"};
				ProcAct procAct = procActManager.findUnique(hql, values);
				String actName = procAct.getActName();
				procInstance.setInstanceState(actName);
				procInstance.setActiveState("激活");
				procInstance.setCreateTime(ts);
				procInstance.setCreateUserId(wxUser.getOpenid());
				procInstance.setCreateUserName(wxUser.getNickname());
				procInstanceManager.save(procInstance);
				String instanceId = procInstance.getRowId();
				//创建节点实例
				List<ProcAct> actList = procActManager.findBy("processId", processId);
				for(ProcAct act : actList){
					ProcActInstance procActInstance = new ProcActInstance();
					procActInstance.setProcessId(processId);
					procActInstance.setInstanceId(instanceId);
					procActInstance.setBusinessId(meetRowId);
					procActInstance.setActId(act.getActId());
					procActInstance.setActName(act.getActName());
					procActInstance.setActBack(act.getBackAct());
					procActInstance.setActNext(act.getNextAct());
					procActInstance.setHandleUser(act.getHandleUserName());
					procActInstance.setHandleUser1(act.getHandleUserName1());
					procActInstance.setActOrder(act.getActOrder());
					if(act.getActName().equals("申请")){
						procActInstance.setHandleUser(wxUser.getNickname());
						procActInstance.setHandleUser1(wxUser.getOpenid());
						procActInstance.setStepState("已同意");
						procActInstance.setFinishTime(ts);
					}else if(act.getActName().equals(actName)){
						procActInstance.setActiveState("激活");
						procActInstance.setActiveUserId(wxUser.getOpenid());
						procActInstance.setActiveUserName(wxUser.getNickname());
						procActInstance.setActiveTime(ts);
						procActInstance.setStepState("正在执行");
					}
					//保存节点实例
					procActInstanceManager.save(procActInstance);
				}
				//创建历史意见表
				HistoryOpinion historyOpinion = new HistoryOpinion();
				historyOpinion.setTableId(meetRowId);
				historyOpinion.setPiId(instanceId);
				historyOpinion.setHandleStage("申请");
				historyOpinion.setHandleProcess(wxUser.getNickname()+"提交给"+procAct.getHandleUserName());
				historyOpinion.setHandleOpinion("");
				historyOpinion.setHandleUser(wxUser.getNickname());
				historyOpinion.setHandleTime(ts);
				historyOpinionManager.save(historyOpinion);
			}else{
				//当前步骤取消激活状态
				String instanceId = pi.getRowId();
				String hql = "from ProcActInstance where instanceId = ? and actName = ?";
				Object[] values = {instanceId, "申请"};
				ProcActInstance currentAct = procActInstanceManager.findUnique(hql, values);
				currentAct.setStepState("已同意");
				currentAct.setFinishTime(ts);
				currentAct.setActiveState(null);
				procActInstanceManager.save(currentAct);
				//下一步设置激活状态
				String actNext = currentAct.getActNext();
				Object[] values1 = {instanceId,actNext};
				ProcActInstance NextAxt = procActInstanceManager.findUnique(hql, values1);
				NextAxt.setActiveUserId(wxUser.getOpenid());
				NextAxt.setActiveUserName(wxUser.getNickname());
				NextAxt.setActiveState("激活");
				NextAxt.setStepState("正在进行");
				NextAxt.setActiveTime(ts);
				procActInstanceManager.save(NextAxt);
				//设置流程实例状态
				pi.setInstanceState(actNext);
				procInstanceManager.save(pi);
				//创建历史意见表
				HistoryOpinion historyOpinion = new HistoryOpinion();
				historyOpinion.setTableId(rowId);
				historyOpinion.setPiId(instanceId);
				historyOpinion.setHandleStage("申请");
				historyOpinion.setHandleProcess(wxUser.getNickname()+"提交给"+NextAxt.getHandleUser());
				historyOpinion.setHandleOpinion("");
				historyOpinion.setHandleUser(wxUser.getNickname());
				historyOpinion.setHandleTime(ts);
				historyOpinionManager.save(historyOpinion);
			}
		}catch (Exception e) {
			// TODO: handle exception
			statusCode = "300";
			e.printStackTrace();
		}
		if(statusCode.equals("200")){
			return "mobile/apply-success";
		}else{
			return "mobile/apply-fail";
		}
	}

	/**
	 * 会议室申请进度查询
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("hys-progress-list")
	public String hysProgressList(@ModelAttribute("wxUser") WxUser wxUser,
								  @RequestParam Map<String, Object> parameterMap, Model model){
		//添加条件为根据当前用户查询
		parameterMap.put("filter_EQS_createUserId", wxUser.getOpenid());
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		List<VMeetProcinst> list = vMeetProcinstManager.find(propertyFilters);
		model.addAttribute("list", list);
		model.addAttribute("parameterMap", parameterMap);
		return "mobile/hys-progress-list";
	}

	/**
	 * 会议室租赁查看详情
	 * @param model
	 * @return
	 */
	@RequestMapping("to-hys-view")
	public String toHysView(String rowId, Model model){
		VMeetProcinst vMeetProcinst = vMeetProcinstManager.get(rowId);
		String instanceState = vMeetProcinst.getInstanceState();
		model.addAttribute("instanceState", instanceState);
		//申请表
		MeetingRoomLeaseApply meetingRoomLeaseApply = meetingRoomLeaseApplyManager.get(rowId);
		model.addAttribute("meetingRoomLeaseApply", meetingRoomLeaseApply);
		//增值服务
		HysZzfw hysZzfw = hysZzfwManager.findUniqueBy("relationId", rowId);
		model.addAttribute("hysZzfw", hysZzfw);
		//节点意见
		String hql = "from ProcActInstance where instanceId = ? and actName = ?";
		Object[] values = {vMeetProcinst.getInstanceId(), "会务服务部审核"};
		ProcActInstance actInstance = procActInstanceManager.findUnique(hql,values);
		model.addAttribute("actInstance", actInstance);
		return "mobile/hys-view";
	}

	/**
	 * 到一卡通申请页面
	 * @return
	 */
//	@RequestMapping("to-ykt-form")
//	public String toYktForm() {
//		return "mobile/ykt-form";
//	}

	/**
	 * 会议室简介
	 * @return
	 */
	@RequestMapping("hys-show")
	public String hysShow() {
		return "mobile/hys-show";
	}

	/**
	 * 会议室详情
	 * @param hys
	 * @return
	 */
	@RequestMapping("hys-detail")
	public String hysDetail(String hys) {
		if(hys.equals("1")){
			return "mobile/hys-detail-1";
		}else if (hys.equals("2")){
			return "mobile/hys-detail-2";
		}else if (hys.equals("3")){
			return "mobile/hys-detail-3";
		}else if (hys.equals("4")){
			return "mobile/hys-detail-4";
		}else if (hys.equals("5")){
			return "mobile/hys-detail-5";
		}else if (hys.equals("6")){
			return "mobile/hys-detail-6";
		}else if (hys.equals("7")){
			return "mobile/hys-detail-7";
		}else {
			return "mobile/hys-detail-8";
		}
	}

	/**
	 * 样板间
	 * @return
	 */
	@RequestMapping("fwzl-ybj")
	public String fwzlYbj() {
		return "mobile/fwzl-ybj";
	}

	/**
	 * 周边配套列表页面
	 * @return
	 */
	@RequestMapping("peripheral-matching")
	public String PeriMpheralatching(Model model) {
		List<PeripheralMatching> list = peripheralMatchingManager.getAll();
		model.addAttribute("list",list);
		return "mobile/peripheral-matching";
	}

	/**
	 * 周边配套查看详情
	 * @param rowId
	 * @return
	 */
	@RequestMapping("pm-view")
	public String pmView(String rowId, Model model) {
		PeripheralMatching peripheralMatching = peripheralMatchingManager.get(rowId);
		model.addAttribute("peripheralMatching",peripheralMatching);
		String hql = "from ZbptAttachment where relationId = ? and pictureType = ?";
		Object[] values = {rowId, "1"};
		List<ZbptAttachment> picList = zbptAttachmentManager.find(hql,values);
		model.addAttribute("picList",picList);
		return "mobile/pm-detail";
	}

	/**
	 * 关联附件
	 * @param attachmentId
	 * @param rowId
	 */
	public void relationFile(String attachmentId, String rowId){
		if(attachmentId != null && attachmentId.length() > 0){
			String[] idArr = attachmentId.split(",");
			for (int i = 0; i < idArr.length; i++) {
				WxAttachment attachment = wxAttachmentManager.get(idArr[i]);
				attachment.setRelationId(rowId);
				wxAttachmentManager.save(attachment);
			}
		}
	}

	/**
	 * 机场大巴查询
	 */
	@RequestMapping("shuttle-bus")
	public String shuttleBusView() {
		return "mobile/shuttle-bus";
	}

	/**
	 * 代办中心
	 * @return
	 */
	@RequestMapping("agency-center")
	public String agencyCenter() {
		return "mobile/agency-center";
	}

	/**
	 * 运营商服务
	 * @return
	 */
	@RequestMapping("carrier-service")
	public String carrierService() {
		return "mobile/carrier-service";
	}

	/**
	 * 云服务器
	 *
	 */
	@RequestMapping("cloud-server")
	public String cloudServer() {
		return "mobile/cloud-server";
	}

	/**
	 * 云桌面
	 */
	@RequestMapping("cloud-desktop")
	public String cloudDesktop() { return "mobile/cloud-desktop"; }

	/**
	 * 广告发布
	 */
	@RequestMapping("advertising-release")
	public String advertisingRelease() { return "mobile/advertising-release"; }

	/**
	 * 班车查询
	 * @return
	 */
	@RequestMapping("regular-bus")
	public String regularBus() { return "mobile/regular-bus"; }

	/**
	 * 班车
	 * @return
	 */
	@RequestMapping("regular-bus-detail")
	public String regularBusDetail(String id) {
		if(id.equals("y1")){
			return "mobile/regular-bus-1";
		}else if(id.equals("y2")){
			return "mobile/regular-bus-2";
		}else if(id.equals("y3")){
			return "mobile/regular-bus-3";
		}else if(id.equals("y4")){
			return "mobile/regular-bus-4";
		}else if(id.equals("y5")){
			return "mobile/regular-bus-5";
		}else if(id.equals("y6")){
			return "mobile/regular-bus-6";
		}else if(id.equals("y7")){
			return "mobile/regular-bus-7";
		}else if(id.equals("y8")){
			return "mobile/regular-bus-8";
		}else if(id.equals("y9")){
			return "mobile/regular-bus-9";
		}else if(id.equals("y10")){
			return "mobile/regular-bus-10";
		}else if(id.equals("y11")){
			return "mobile/regular-bus-11";
		}else if(id.equals("y12")){
			return "mobile/regular-bus-12";
		}else if(id.equals("y13")){
			return "mobile/regular-bus-13";
		}else if(id.equals("y14")){
			return "mobile/regular-bus-14";
		}else if(id.equals("y15")){
			return "mobile/regular-bus-15";
		}else if(id.equals("y16")){
			return "mobile/regular-bus-16";
		}else if(id.equals("y17")){
			return "mobile/regular-bus-17";
		}else{
			return null;
		}
	}


	/**
	 * 统一下单
	 * @param wxUser
	 * @param request
	 * @return
	 */
	@RequestMapping("wx-order")
	public @ResponseBody
	Map<String,String> wxOrder(@ModelAttribute("wxUser") WxUser wxUser,HttpServletRequest request){
		Map<String, String> payMap = new HashMap<>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String openid = wxUser.getOpenid();//用户唯一标识
		String appid = "wxe4bcb04f38969b18";//公众账号ID
		String mch_id = "1404452802";//微信商户号
		String apiKey = "tN3Hi3VGsCX8ZY9ohsP6V51VLW9NI6Kn";//API秘钥
		//获取请求ip地址
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getRemoteAddr();
		}
		if(ip.indexOf(",")!=-1){
			String[] ips = ip.split(",");
			ip = ips[0].trim();
		}
		//组装请求参数
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("appid",appid);//公众账号ID
		paraMap.put("mch_id",mch_id);//商户号
		paraMap.put("nonce_str",WXPayUtil.generateNonceStr());//随机字符串
		paraMap.put("body","研创园-一卡通缴费");//商品描述
		paraMap.put("openid",openid);//用户标识，JSAPI支付此参数必传
		//根据当前系统时间加随机序列来生成订单号
		String out_trade_no = sdf.format(new Date()) + "-" + RandomStringUtils.randomAlphanumeric(10);
		paraMap.put("out_trade_no",out_trade_no);//商户订单号
		paraMap.put("total_fee","1");//标价金额，单位为分
		paraMap.put("spbill_create_ip",ip);//终端IP
		paraMap.put("trade_type","JSAPI");//交易类型
		paraMap.put("notify_url","http://watch.njitrip.cn/mobile/wx-pay-result.do");//通知地址，异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
		try {
		    //生成带有sign的XML格式字符串
			String xml = WXPayUtil.generateSignedXml(paraMap, apiKey);//待签名数据，API密钥
			// 统一下单 https://api.mch.weixin.qq.com/pay/unifiedorder
			String order_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
			//发送post请求"统一下单接口"返回预支付id:prepay_id
			String response = HttpClient.sendHttpRequest(order_url, xml, "POST", "application/xml;charset=utf-8");
			//返回前端页面的json数据
			if (response.indexOf("SUCCESS") != -1) {
				Map<String, String> map = WXPayUtil.xmlToMap(response);
				String prepay_id = map.get("prepay_id");//预支付id
				payMap.put("appId", "wxe4bcb04f38969b18");
				payMap.put("timeStamp", WXPayUtil.getCurrentTimestamp()+"");
				payMap.put("nonceStr", WXPayUtil.generateNonceStr());
				payMap.put("signType", "MD5");
				payMap.put("package", "prepay_id=" + prepay_id);
				String paySign = WXPayUtil.generateSignature(payMap, apiKey);//待签名数据，API密钥
				payMap.put("paySign", paySign);
				//保存到数据库
				WxUnifiedOrder wxUnifiedOrder = new WxUnifiedOrder();
				wxUnifiedOrder.setOutTradeNo(out_trade_no);
				wxUnifiedOrder.setOpenid(openid);
				wxUnifiedOrder.setPrepayId(prepay_id);
				wxUnifiedOrder.setSpbillCreateIp(ip);
				wxUnifiedOrder.setTotalFee(1);
				wxUnifiedOrder.setCreateTime(ts);
				wxUnifiedOrder.setOrderState("0");//下单
				wxUnifiedOrder.setDataDelete("1");
				wxUnifiedOrderManager.save(wxUnifiedOrder);
			}else{
				statusCode = "300";
				message = "支付失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = "300";
			message = "支付失败";
		}
		payMap.put("statusCode",statusCode);
		payMap.put("message",message);
		return payMap;
	}

	/**
	 * 微信支付结果通知
	 * @return
	 */
	@RequestMapping("wx-pay-result")
	public @ResponseBody
	String wxPayResult(HttpServletRequest request) {
		String apiKey = "tN3Hi3VGsCX8ZY9ohsP6V51VLW9NI6Kn";//API秘钥
		try {
			InputStream is = request.getInputStream();
			String xmlString = WXPayUtil.inputStream2String(is,"UTF-8");
			Map<String, String> paraMap = WXPayUtil.xmlToMap(xmlString);
			logger.info("http://watch.njitrip.cn/mobile/wx-pay-result.do:paraMap="+paraMap);
			String return_code = paraMap.get("return_code");
			if(return_code.equals("SUCCESS")){
				String result_code = paraMap.get("result_code");//业务结果
				String openid = paraMap.get("openid");//用户标识
				String is_subscribe = paraMap.get("is_subscribe");//是否关注公众账号
				String bank_type = paraMap.get("bank_type");//付款银行
				String total_fee = paraMap.get("total_fee");//订单金额
				String cash_fee = paraMap.get("cash_fee");//现金支付金额
				String transaction_id = paraMap.get("transaction_id");//微信支付订单号
				String out_trade_no = paraMap.get("out_trade_no");//商户订单号
				String time_end = paraMap.get("time_end");//支付完成时间
				//暂不需要
//				String settlement_total_fee = paraMap.get("settlement_total_fee");//应结订单金额
//				String fee_type = paraMap.get("fee_type");//货币种类
//				String cash_fee_type = paraMap.get("cash_fee_type");//现金支付货币类型
//				String coupon_fee = paraMap.get("coupon_fee");//总代金券金额
//				String coupon_count = paraMap.get("coupon_count");//代金券使用数量
//				String coupon_type_$n = paraMap.get("coupon_type_$n");//代金券类型
//				String coupon_id_$n = paraMap.get("coupon_id_$n");//代金券ID
//				String coupon_fee_$n = paraMap.get("coupon_fee_$n");//单个代金券支付金额
				//签名验证
				if(WXPayUtil.isSignatureValid(xmlString,apiKey)){
					//验证金额是否相同（暂不验证）
//					WxUnifiedOrder wxUnifiedOrder = wxUnifiedOrderManager.findUniqueBy("outTradeNo", out_trade_no);
//					Integer totalFee = wxUnifiedOrder.getTotalFee();
//					if(Integer.parseInt(total_fee) == totalFee){
//					}else{
//						logger.info(out_trade_no+"：金额不一致");
//					}
					/**
					 * 同样的通知可能会多次发送给商户系统。商户系统必须能够正确处理重复的通知
					 * 后台通知交互时，如果微信收到商户的应答不符合规范或超时，微信会判定本次通知失败，重新发送通知，直到成功为止
					 * （在通知一直不成功的情况下，微信总共会发起多次通知，通知频率为15s/15s/30s/3m/10m/20m/30m/30m/30m/60m/3h/3h/3h/6h/6h - 总计 24h4m）
					 * 但微信不保证通知最终一定能成功。
					 * 当收到通知进行处理时，首先检查对应业务数据的状态，判断该通知是否已经处理过，如果没有处理过再进行处理，如果处理过直接返回结果成功。
					 * 在对业务数据进行状态检查和处理之前，要采用数据锁进行并发控制，以避免函数重入造成的数据混乱。
					 */
					WxPayResult wxPayResult = wxPayResultManager.findUniqueBy("outTradeNo", out_trade_no);
					if(wxPayResult != null){
						//已处理通知，直接返回结果成功
						Map<String,String> resMap = new HashMap<>();
						resMap.put("return_code","SUCCESS");
						resMap.put("return_msg","OK");
						String xml = WXPayUtil.mapToXml(resMap);//将map转xml格式
						return xml;
					}else{
						//未处理通知
						wxPayResult = new WxPayResult();
						wxPayResult.setRowId(null);
						wxPayResult.setBankType(bank_type);
						wxPayResult.setCashFee(Integer.parseInt(cash_fee));
						wxPayResult.setIsSubscribe(is_subscribe);
						wxPayResult.setOpenid(openid);
						wxPayResult.setOutTradeNo(out_trade_no);
						wxPayResult.setResultCode(result_code);
						wxPayResult.setTotalFee(Integer.parseInt(total_fee));
						wxPayResult.setTransactionId(transaction_id);
						wxPayResult.setTimeEnd(time_end);
						wxPayResultManager.save(wxPayResult);
						//得到统一下单表
						WxUnifiedOrder wxUnifiedOrder = wxUnifiedOrderManager.findUniqueBy("outTradeNo", out_trade_no);
						String roomId = wxUnifiedOrder.getRoomId();
						String rechargeType = wxUnifiedOrder.getRechargeType();
						if(roomId != null && rechargeType != null){
							Timestamp ts = DateUtil.getDate();
							BigDecimal b1 = new BigDecimal(total_fee);
							BigDecimal b2 = new BigDecimal("100");
							Double rechargeMoney = b1.divide(b2,2,BigDecimal.ROUND_HALF_UP).doubleValue();
							if(rechargeType.equals("1")){
								//水费充值（2019-10-08）
								WaterFloorRoomInDevice waterFloorRoomInDevice = waterFloorRoomInDeviceManager.findUniqueBy("roomName", roomId);
								SdRechargeRecord sdRechargeRecord = new SdRechargeRecord();
								sdRechargeRecord.setRoomId(roomId);
								sdRechargeRecord.setRechargeType(rechargeType);
								sdRechargeRecord.setOutTradeNo(out_trade_no);
								sdRechargeRecord.setRechargeTime(ts);
								sdRechargeRecord.setDeviceId(waterFloorRoomInDevice.getDeviceId());
								sdRechargeRecord.setOpenId(wxUnifiedOrder.getOpenid());
								//修改根据openId查询（2019-09-08）
								List<WxUserRoom> wxUserRoomList = wxUserRoomManager.findBy("wxUserId", wxUnifiedOrder.getOpenid());
								if(wxUserRoomList != null && wxUserRoomList.size() > 0){
									sdRechargeRecord.setUserName(wxUserRoomList.get(0).getUserName());
									sdRechargeRecord.setUserIdCard(wxUserRoomList.get(0).getUserIdCard());
									sdRechargeRecord.setUserPhone(wxUserRoomList.get(0).getUserPhone());
								}
								sdRechargeRecord.setPayType("微信支付");
								sdRechargeRecord.setRechargeTime(ts);
								sdRechargeRecord.setRechargeMoney(rechargeMoney);//充值金额
								sdRechargeRecordManager.save(sdRechargeRecord);
								//同步水费余额表
								WaterAccount waterAccount = waterAccountManager.findUniqueBy("roomName", roomId);
								Double balance = waterAccount.getBalance();
								Double newBalance = add(balance, rechargeMoney);
								waterAccount.setBalance(newBalance);
								waterAccount.setLastRechargeMoney(rechargeMoney);
								waterAccount.setLastRechargeTime(new Timestamp(new Date().getTime()));
								waterAccount.setTotalMoney(waterAccount.getTotalMoney()==null?rechargeMoney:rechargeMoney+waterAccount.getTotalMoney());
								waterAccountManager.save(waterAccount);
								//充值水费后判断余额是否自动合闸
								if(waterAccount.getBalance()>0){
									FloorRoomInDevice roomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", roomId);
									String deviceId = roomInDevice.getDeviceId();
									SdRechargeRunnable sdRechargeRunnable = new SdRechargeRunnable(deviceId,deviceOnAndOffManager);
									Thread thread = new Thread(sdRechargeRunnable);
									thread.start();
								}
							}else{
								//电费充值调用接口往电表充值
								Map<String, String> map = electricRecharge1(wxUnifiedOrder.getOpenid(),roomId,rechargeType,rechargeMoney,out_trade_no);
								String statusCode = map.get("statusCode");
								if(statusCode.equals("200")){
									//调用接口送电
									FloorRoomInDevice roomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", roomId);
									String deviceId = roomInDevice.getDeviceId();
									SdRechargeRunnable sdRechargeRunnable = new SdRechargeRunnable(deviceId,deviceOnAndOffManager);
									Thread thread = new Thread(sdRechargeRunnable);
									thread.start();
								}
							}
						}
					}
				}else{
					logger.info("----------------------微信支付结果通知验证签名失败：----------订单号"+out_trade_no+"----------------------");
				}
			}
			//返回参数
			Map<String,String> resMap = new HashMap<>();
			resMap.put("return_code","SUCCESS");
			resMap.put("return_msg","OK");
			String xml = WXPayUtil.mapToXml(resMap);//将map转xml格式
			return xml;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 支付成功跳转页面
	 * @return
	 */
	@RequestMapping("wx-pay-success")
	public String wxPaySuccess() { return "mobile/wx-pay-success"; }



	/**********************************2019-07-31新增水电模块*****************************************/

	/**
	 * 水电智能服务
	 * @return
	 */
	@RequestMapping("water-electric")
	public String waterElectric() { return "mobile/water-electric"; }

	/**
	 * 到一卡通绑定页面
	 * @param wxUser
	 * @param model
	 * @return
	 */
	@RequestMapping("to-ykt-bind")
	public String yktBind(@ModelAttribute("wxUser") WxUser wxUser, Model model) {
		WxUserYkt wxUserYkt = wxUserYktManager.findUniqueBy("wxUserId", wxUser.getOpenid());
		if(wxUserYkt == null){
			return "mobile/ykt-bind-form";
		}else{
			model.addAttribute("yktId",wxUserYkt.getYktId());
			return "mobile/ykt-bind-finish";
		}
	}

	/**
	 * 一卡通解除绑定
	 * @param wxUser
	 * @return
	 */
	@RequestMapping("unbind-ykt")
	public String unbindYkt(@ModelAttribute("wxUser") WxUser wxUser) {
		WxUserYkt wxUserYkt = wxUserYktManager.findUniqueBy("wxUserId", wxUser.getOpenid());
		wxUserYktManager.remove(wxUserYkt);
		return "mobile/unbind-ykt-success";
	}


	/**
	 * 一卡通绑定保存
	 * @param wxUser
	 * @param wxUserYkt
	 * @return
	 */
	@RequestMapping(value = "ykt-bind-save", method = RequestMethod.POST)
	public String yktBindSave(@ModelAttribute("wxUser") WxUser wxUser, WxUserYkt wxUserYkt) {
		Timestamp ts = DateUtil.getDate();
		try{
			wxUserYkt.setRowId(null);
			wxUserYkt.setWxUserId(wxUser.getOpenid());
			wxUserYkt.setCreateTime(ts);
			wxUserYktManager.save(wxUserYkt);
		}catch (Exception e){
			e.printStackTrace();
			return "mobile/bind-fail";
		}
		return "mobile/bind-success";
	}


	/**
	 * 提供精准的加法运算(四舍五入保留两位有效数字)
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static Double add(Double value1, Double value2) {
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.add(b2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 水电月账单查询
	 * @param wxUser
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "sd-query")
	public String sdQuery(@ModelAttribute("wxUser") WxUser wxUser, Model model) {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		String year_month = year+"-"+month;
		if(month < 10){
			year_month = year+"-0"+month;
		}
		String openId = wxUser.getOpenid();
		List<WxUserRoom> wxUserRoomList = wxUserRoomManager.findBy("wxUserId", openId);
		if(wxUserRoomList != null && wxUserRoomList.size() >0){
			List<SdMonthBill> sdMonthBillList = new ArrayList<>();
			for (WxUserRoom wxUserRoom : wxUserRoomList){
				FloorRoomInDevice roomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", wxUserRoom.getRoomId());
				List<WaterFloorRoomInDevice> waterRoomList = waterFloorRoomInDeviceManager.findBy("roomName", wxUserRoom.getRoomId());
				if(roomInDevice != null && waterRoomList != null ){
					//电
					String electricDeviceId = roomInDevice.getDeviceId();
					String hql = "from ElectricMonthRecord where deviceId = ? and time = ?";
					Object[] values = {electricDeviceId, year_month};
					ElectricMonthRecord electricMonthRecord = electricMonthRecordManager.findUnique(hql, values);
					String e_monthEnergy = electricMonthRecord.getMonthEnergy();//电月用电量
					//得到电费单价
					GxSysDicRecord gxSysDicRecord = gxRecordManager.findUniqueBy("dicId", "electric_dj_1");
					Double electric_month_fee = DoubleUtil.mul1(gxSysDicRecord.getDicName(), e_monthEnergy);
					//水
					Double w_monthEnergy = 0.00;//电月用电量
					for(WaterFloorRoomInDevice waterFloorRoomInDevice : waterRoomList){
						Map<String, Object> parameterMap = new HashMap<>();
						parameterMap.put("filter_EQS_deviceId",waterFloorRoomInDevice.getDeviceId());
						List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
						List<WaterMonthRecord> waterMonthRecords = waterMonthRecordManager.find("time", false, propertyFilters);
						String water0 = waterMonthRecords.get(0).getTotalWater();
						String water1 = waterMonthRecords.get(1).getTotalWater();
						String TotalWater0 = water0.startsWith(".") == true ? "0"+water0 : water0;
						String TotalWater1 = water1.startsWith(".") == true ? "0"+water1 : water1;
						w_monthEnergy = add(w_monthEnergy, DoubleUtil.sub(TotalWater0, TotalWater1));
					}
					//得到水费单价
					GxSysDicRecord gxSysDicRecord1 = gxRecordManager.findUniqueBy("dicId", "water_dj_1");
					Double water_month_fee = DoubleUtil.mul(gxSysDicRecord1.getDicName(), w_monthEnergy);
					SdMonthBill sdMonthBill = new SdMonthBill();
					sdMonthBill.setRoomId(wxUserRoom.getRoomId());
					sdMonthBill.setYear(year+"");
					sdMonthBill.setMonth(month+"");
					sdMonthBill.setMonthElectricUse(Double.parseDouble(e_monthEnergy));
					sdMonthBill.setMonthElectricFee(electric_month_fee);
					sdMonthBill.setMonthWaterUse(w_monthEnergy);
					sdMonthBill.setMonthWaterFee(water_month_fee);
					sdMonthBillList.add(sdMonthBill);
				}else{
					//提示房间未绑定电表或水表
					return "mobile/sd-room-wbd";
				}
			}
			model.addAttribute("sdMonthBillList",sdMonthBillList);
		}else{
			//提示未绑定房间
			return "mobile/user-room-wbd";
		}
		return "mobile/sd-bill";
	}

	/**
	 * 到水电充值选择页面
	 * @return
	 */
	@RequestMapping("sd-recharge-select")
	public String sdRechargeSelect() { return "mobile/sd-recharge-select"; }

	/**
	 * 到水费、电费充值页面
	 * @param wxUser
	 * @param model
	 * @return
	 */
	@RequestMapping("to-sd-recharge")
	public String toSdRecharge(@ModelAttribute("wxUser") WxUser wxUser, String rechargeType, Model model) {
		List<WxUserRoom> wxUserRoomList = wxUserRoomManager.findBy("wxUserId", wxUser.getOpenid());
		if(wxUserRoomList != null && wxUserRoomList.size() == 1){
			model.addAttribute("roomId",wxUserRoomList.get(0).getRoomId());
		}
		String title = "电费充值";
		if(rechargeType.equals("1")){
			title = "水费充值";
		}else{
			//判断电表充值接口是否正常，如果断开提示无法充值
			// 获取连接客户端工具
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("http://221.226.66.78:9000/api/emcs/rechargeDevices");
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(8000).setConnectionRequestTimeout(8000).setSocketTimeout(8000).build();
			httpGet.setConfig(requestConfig);
			// 设置请求头消息User-Agent
			httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
			int statusCode = 0;
			try {
				CloseableHttpResponse response = httpClient.execute(httpGet);
				statusCode = response.getStatusLine().getStatusCode();
			} catch (SocketTimeoutException ex) {
			logger.info("请求连接超时" + ex.getMessage());
				statusCode = 504;
			} catch (Exception ex) {
			logger.info("其他异常" + ex.getMessage());
				statusCode = 500;
			}
			//状态码为200表示接口正常，其他表示失败
			if(statusCode != 200){
				//发送短信提示接口异常
				SendMessageUtil.sendMessage("13770715730,18021531010", "【研创园】电费充值接口异常！");
				return "mobile/sd-recharge-exception";
			}
		}
		model.addAttribute("title",title);
		model.addAttribute("rechargeType",rechargeType);
		return "mobile/sd-recharge";
	}

	/**
	 * 电费充值
	 * @param wxUser 微信用户
	 * @param roomId 房间号
	 * @param rechargeType 充值类型
	 * @param rechargeMoney 充值金额
	 * @param request
	 * @return
	 */
	@RequestMapping("sd-recharge")
	public @ResponseBody
	Map<String,String> electricRecharge(@ModelAttribute("wxUser") WxUser wxUser,String roomId, String rechargeType, Double rechargeMoney, HttpServletRequest request){
		//发送到前台的数据
		Map<String, String> payMap = new HashMap<>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String openid = wxUser.getOpenid();//用户唯一标识
		String appid = "wxe4bcb04f38969b18";//公众账号ID
		String mch_id = "1404452802";//微信商户号
		String apiKey = "tN3Hi3VGsCX8ZY9ohsP6V51VLW9NI6Kn";//API秘钥
		//将Double类型金额单位为元转成单位为分
		String total_fee = String.valueOf((int)(rechargeMoney*100));
		try {
			//判断房间号是否存在,房间是否绑定电表
			FloorRoom floorRoom = floorRoomManager.findUniqueBy("rowName", roomId);
			if(floorRoom != null){
				if(rechargeType.equals("1")){
					WaterFloorRoomInDevice waterFloorRoomInDevice = waterFloorRoomInDeviceManager.findUniqueBy("roomName", roomId);
					if(waterFloorRoomInDevice == null){
						statusCode = "300";
						message = "房间没有绑定水表";
						payMap.put("statusCode",statusCode);
						payMap.put("message",message);
						return payMap;
					}
				}else{
					FloorRoomInDevice roomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", roomId);
					if(roomInDevice == null){
						statusCode = "300";
						message = "房间没有绑定电表";
						payMap.put("statusCode",statusCode);
						payMap.put("message",message);
						return payMap;
					}
				}
			}else{
				statusCode = "300";
				message = "房间号不存在";
				payMap.put("statusCode",statusCode);
				payMap.put("message",message);
				return payMap;
			}
			//获取请求ip地址
			String ip = request.getHeader("x-forwarded-for");
			if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
				ip = request.getHeader("Proxy-Client-IP");
			}
			if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
				ip = request.getRemoteAddr();
			}
			if(ip.indexOf(",")!=-1){
				String[] ips = ip.split(",");
				ip = ips[0].trim();
			}
			//组装请求参数
			Map<String, String> paraMap = new HashMap<>();
			paraMap.put("appid",appid);//公众账号ID
			paraMap.put("mch_id",mch_id);//商户号
			paraMap.put("nonce_str",WXPayUtil.generateNonceStr());//随机字符串
			//根据当前系统时间加随机序列来生成订单号
			String out_trade_no = sdf.format(new Date()) + "-" + RandomStringUtils.randomAlphanumeric(10);
			//判断充值类型（1：水费充值 2：电费充值）
			String body = "研创园";
			if(rechargeType.equals("1")){
				out_trade_no += "-s";
				body += "-水费充值";
			}else{
				out_trade_no += "-d";
				body += "-电费充值";
			}
			paraMap.put("body",body);//商品描述
			paraMap.put("openid",openid);//用户标识，JSAPI支付此参数必传
			paraMap.put("out_trade_no",out_trade_no);//商户订单号
			paraMap.put("total_fee", total_fee);//标价金额，单位为分
			paraMap.put("spbill_create_ip",ip);//终端IP
			paraMap.put("trade_type","JSAPI");//交易类型
			paraMap.put("notify_url","http://watch.njitrip.cn/mobile/wx-pay-result.do");//通知地址，异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
			//生成带有sign的XML格式字符串
			String xml = WXPayUtil.generateSignedXml(paraMap, apiKey);//待签名数据，API密钥
			// 统一下单 https://api.mch.weixin.qq.com/pay/unifiedorder
			//发送post请求"统一下单接口"返回预支付id:prepay_id
			String response = HttpClient.sendHttpRequest("https://api.mch.weixin.qq.com/pay/unifiedorder", xml, "POST", "application/xml;charset=utf-8");

			//使用官方api（2019-11-07）
//			WXPayConfig wxPayConfig = new WXPayConfigImpl();
//			WXPay wxPay = new WXPay(wxPayConfig);
//			Map<String, String> resMap = wxPay.unifiedOrder(paraMap);

			//返回前端页面的json数据
			if (response.indexOf("SUCCESS") != -1) {
				Map<String, String> map = WXPayUtil.xmlToMap(response);
				String prepay_id = map.get("prepay_id");
				payMap.put("appId", appid);
				payMap.put("timeStamp", WXPayUtil.getCurrentTimestamp()+"");
				payMap.put("nonceStr", WXPayUtil.generateNonceStr());
				payMap.put("signType", "MD5");
				payMap.put("package", "prepay_id=" + prepay_id);
				String paySign = WXPayUtil.generateSignature(payMap, apiKey);//待签名数据，API密钥
				payMap.put("paySign", paySign);
				//保存到数据库
				WxUnifiedOrder wxUnifiedOrder = new WxUnifiedOrder();
				wxUnifiedOrder.setOutTradeNo(out_trade_no);
				wxUnifiedOrder.setOpenid(openid);
				wxUnifiedOrder.setPrepayId(prepay_id);
				wxUnifiedOrder.setSpbillCreateIp(ip);
				wxUnifiedOrder.setTotalFee((int)(rechargeMoney*100));
				wxUnifiedOrder.setCreateTime(ts);
				wxUnifiedOrder.setOrderState("0");//下单
				wxUnifiedOrder.setDataDelete("1");
				wxUnifiedOrder.setRoomId(roomId);//房间号（水电充值专用）
				wxUnifiedOrder.setRechargeType(rechargeType);//充值类型（水电充值专用）
				wxUnifiedOrderManager.save(wxUnifiedOrder);
			}else{
				statusCode = "300";
				message = "支付失败";
			}
			//保存充值记录表
		} catch (Exception e) {
			statusCode = "300";
			message = "充值失败";
			e.printStackTrace();
		}
		payMap.put("statusCode",statusCode);
		payMap.put("message",message);
		return payMap;
	}

	/**
	 * 调用电表充值接口
	 */
	public Map<String, String> electricRecharge1(String openId, String roomId, String rechargeType, Double rechargeMoney, String outTradeNo){
		logger.info("----------------------调用电表充值接口：electric-recharge----------------------");
		logger.info("----------------------商户订单号："+outTradeNo+"----------------------");
		logger.info("----------------------房间号："+roomId+"----------充值金额："+String.format("%.2f", rechargeMoney)+"----------------------");
		Map<String, String> resMap = new HashMap<>();
		String statusCode = "200", message = "充值成功";
		Timestamp ts = DateUtil.getDate();
		FloorRoomInDevice roomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", roomId);
		String deviceId = roomInDevice.getDeviceId();
		try{
			//调用接口充值
			List<NameValuePair> pairs = new ArrayList<>();
			NameValuePair pair1 = new BasicNameValuePair("deviceId",deviceId);
			NameValuePair pair2 = new BasicNameValuePair("money",String.format("%.2f", rechargeMoney));
			NameValuePair pair3 = new BasicNameValuePair("actionType","0");//1：充值 2：退款
			NameValuePair pair4 = new BasicNameValuePair("ipAddress","192.168.50.23");
			NameValuePair pair5 = new BasicNameValuePair("secret", Md5Utils.getMd5UpperCase(deviceId+String.format("%.2f", rechargeMoney)+"tiansu"));
			pairs.add(pair1);
			pairs.add(pair2);
			pairs.add(pair3);
			pairs.add(pair4);
			pairs.add(pair5);
			String result= HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/rechargeDevices",pairs,"application/x-www-form-urlencoded;charset=utf-8");
			JSONObject jsonObject= JSON.parseObject(result);
			JSONObject data = (JSONObject) jsonObject.get("data");
			JSONArray jsonArray= data.getJSONArray("datas");
			String success=((JSONObject)jsonArray.get(0)).getString("success");
			if(success.equals("true")) {
				logger.info("----------------------调用电表充值接口----------房间号："+roomId+"----------充值成功----------------------");
				//保存充值成功记录表
				SdRechargeRecord sdRechargeRecord = new SdRechargeRecord();
				sdRechargeRecord.setRoomId(roomId);
				sdRechargeRecord.setRechargeType(rechargeType);
				sdRechargeRecord.setOutTradeNo(outTradeNo);
				sdRechargeRecord.setRechargeTime(ts);
				sdRechargeRecord.setDeviceId(deviceId);
				sdRechargeRecord.setOpenId(openId);
				//修改根据openId查询（2019-09-08）
				List<WxUserRoom> wxUserRoomList = wxUserRoomManager.findBy("wxUserId", openId);
				if(wxUserRoomList != null && wxUserRoomList.size() > 0){
					sdRechargeRecord.setUserName(wxUserRoomList.get(0).getUserName());
					sdRechargeRecord.setUserIdCard(wxUserRoomList.get(0).getUserIdCard());
					sdRechargeRecord.setUserPhone(wxUserRoomList.get(0).getUserPhone());
				}
				sdRechargeRecord.setPayType("微信支付");
				sdRechargeRecord.setRechargeTime(ts);
				sdRechargeRecord.setRechargeMoney(rechargeMoney);//充值金额
				sdRechargeRecordManager.save(sdRechargeRecord);
				//同步电表实时余额（逻辑待修改2019-11-14）
				ElectricDayRecord electricDayRecord = electricDayRecordManager.findUniqueBy("deviceId", deviceId);
				electricDayRecord.setBalance(String.format("%.2f", rechargeMoney));
				electricDayRecordManager.save(electricDayRecord);
			}else {
				statusCode = "300";
				message = "充值失败";
				logger.info("----------------------调用电表充值接口----------房间号："+roomId+"----------充值失败----------------------");
				//保存充值失败记录表
				SdRechargeFailRecord sdRechargeFailRecord = new SdRechargeFailRecord();
				sdRechargeFailRecord.setRoomId(roomId);
				sdRechargeFailRecord.setRechargeType(rechargeType);
				sdRechargeFailRecord.setOutTradeNo(outTradeNo);
				sdRechargeFailRecord.setRechargeTime(ts);
				sdRechargeFailRecord.setDeviceId(deviceId);
				sdRechargeFailRecord.setOpenId(openId);
				List<WxUserRoom> wxUserRoomList = wxUserRoomManager.findBy("wxUserId", openId);
				if(wxUserRoomList != null && wxUserRoomList.size() > 0){
					sdRechargeFailRecord.setUserName(wxUserRoomList.get(0).getUserName());
					sdRechargeFailRecord.setUserIdCard(wxUserRoomList.get(0).getUserIdCard());
					sdRechargeFailRecord.setUserPhone(wxUserRoomList.get(0).getUserPhone());
				}
				sdRechargeFailRecord.setPayType("微信支付");
				sdRechargeFailRecord.setRechargeMoney(rechargeMoney);//充值金额
				sdRechargeFailRecord.setRechargeTime(ts);
				sdRechargeFailRecord.setDataStatus("充值失败");
				sdRechargeFailRecordManager.save(sdRechargeFailRecord);
			}
		}catch(Exception e){
			logger.info("----------------------调用电表充值接口----------房间号："+roomId+"----------接口异常----------------------");
			SdRechargeFailRecord sdRechargeFailRecord = new SdRechargeFailRecord();
			sdRechargeFailRecord.setRoomId(roomId);
			sdRechargeFailRecord.setRechargeType(rechargeType);
			sdRechargeFailRecord.setOutTradeNo(outTradeNo);
			sdRechargeFailRecord.setRechargeTime(ts);
			sdRechargeFailRecord.setDeviceId(deviceId);
			sdRechargeFailRecord.setOpenId(openId);
//			WxUserRoom wxUserRoom = wxUserRoomManager.findUniqueBy("wxUserId", openId);
			//2019-09-20修改
			List<WxUserRoom> wxUserRoomList = wxUserRoomManager.findBy("wxUserId", openId);
			if(wxUserRoomList != null && wxUserRoomList.size() > 0){
				sdRechargeFailRecord.setUserName(wxUserRoomList.get(0).getUserName());
				sdRechargeFailRecord.setUserIdCard(wxUserRoomList.get(0).getUserIdCard());
				sdRechargeFailRecord.setUserPhone(wxUserRoomList.get(0).getUserPhone());
			}
			sdRechargeFailRecord.setPayType("微信支付");
			sdRechargeFailRecord.setRechargeMoney(rechargeMoney);//充值金额
			sdRechargeFailRecord.setRechargeTime(ts);
			sdRechargeFailRecord.setDataStatus("接口异常");
			sdRechargeFailRecordManager.save(sdRechargeFailRecord);
			statusCode = "400";
			message = "系统报错";
			e.printStackTrace();
		}
		resMap.put("statusCode",statusCode);
		resMap.put("message",message);
		return resMap;
	}

	/**
	 * 水卡、电卡绑定页面
	 * @return
	 */
	@RequestMapping("sd-bind-select")
	public String sdBindSelect() {
		return "mobile/sd-bind-select";
	}

	/**
	 * 到绑定房间页面
	 * @param wxUser
	 * @param model
	 * @return
	 */
	@RequestMapping("to-room-bind")
	public String toRoomBind(@ModelAttribute("wxUser") WxUser wxUser, Model model) {
		List<WxUserRoom> wxUserRoomList = wxUserRoomManager.findBy("wxUserId", wxUser.getOpenid());
		if(wxUserRoomList != null && wxUserRoomList.size() > 0){
			String roomId = "";
			for(WxUserRoom wxUserRoom:wxUserRoomList){
				roomId += roomId == ""?wxUserRoom.getRoomId():","+wxUserRoom.getRoomId();
			}
			model.addAttribute("roomId",roomId);
			return "mobile/room-bind-finish";
		}else{
			return "mobile/room-bind-form";
		}
	}

	/**
	 * 解除房间绑定
	 * @param wxUser
	 * @return
	 */
	@RequestMapping("unbind-room")
	public String unbindRoom(@ModelAttribute("wxUser") WxUser wxUser) {
		List<WxUserRoom> wxUserRoomList = wxUserRoomManager.findBy("wxUserId", wxUser.getOpenid());
		if(wxUserRoomList != null && wxUserRoomList.size() > 0){
			for(WxUserRoom wxUserRoom:wxUserRoomList){
				wxUserRoomManager.remove(wxUserRoom);
			}
		}
		return "mobile/unbind-room-success";
	}

	/**
	 * 绑定房间
	 * 房间号验证（单个或者多个房间）
	 * @param roomIds
	 * @return
	 */
	@RequestMapping("room-validate")
	public @ResponseBody
	Map<String, Object> roomValidate(String roomIds){
		System.out.println("roomId = "+roomIds);
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		try{
			String[] roomArr = roomIds.split(",");
			for (int i=0;i<roomArr.length; i++){
				String roomId = roomArr[i];
				FloorRoom floorRoom = floorRoomManager.findUniqueBy("rowName", roomId);
				if(floorRoom == null){
					statusCode = "300";
					message = roomId+"，房间号不存在！";
					break;
				}else{
					WxUserRoom wxUserRoom = wxUserRoomManager.findUniqueBy("roomId", roomId);
					if(wxUserRoom != null){
						statusCode = "300";
						message = roomId+"，房间号已经被绑定！";
						break;
					}
				}
			}
		}catch(Exception e){
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		return resMap;
	}

	/**
	 * 绑定房间保存
	 * （一个用户可以绑定对个房间，一个房间只能被一个用户绑定）
	 * @param wxUser
	 * @param wxUserRoom
	 * @return
	 */
	@RequestMapping(value = "room-bind-save", method = RequestMethod.POST)
	public String roomBindSave(@ModelAttribute("wxUser") WxUser wxUser, WxUserRoom wxUserRoom) {
		Timestamp ts = DateUtil.getDate();
		try{
			String roomIds = wxUserRoom.getRoomId();
			String[] roomArr = roomIds.split(",");
			for (int i=0;i<roomArr.length; i++){
				wxUserRoom.setRowId(null);
				wxUserRoom.setBindTime(ts);
				wxUserRoom.setWxUserId(wxUser.getOpenid());
				wxUserRoom.setRoomId(roomArr[i]);
				wxUserRoomManager.save(wxUserRoom);
			}
		}catch (Exception e){
			e.printStackTrace();
			return "mobile/bind-fail";
		}
		return "mobile/bind-success";
	}

	/**
	 * 水电充值记录
	 */
	@RequestMapping("sd-recharge-list")
	public String sdRechargeList(@ModelAttribute("wxUser") WxUser wxUser,
								  @RequestParam Map<String, Object> parameterMap, Model model){
		//添加条件为根据当前用户查询
		parameterMap.put("filter_EQS_openId", wxUser.getOpenid());
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		List<SdRechargeRecord> list = sdRechargeRecordManager.find(propertyFilters);
		model.addAttribute("list", list);
		return "mobile/sd-recharge-list";
	}

	/**
	 * 到退款确认页面refund-confirm
	 */
	@RequestMapping(value = "to-refund-confirm")
	public String toRefundConfirm(String rowId, Model model) {
		SdRechargeRecord sdRechargeRecord = sdRechargeRecordManager.get(rowId);
		model.addAttribute("sdRechargeRecord",sdRechargeRecord);
		return "mobile/refund-confirm";
	}

	/**
	 * 退费申请保存
	 */
	@RequestMapping(value = "refund-save", method = RequestMethod.POST)
	public String refundSave(@ModelAttribute("wxUser") WxUser wxUser) {
		Timestamp ts = DateUtil.getDate();
		try{
			//保存退款申请表
		}catch (Exception e){
			e.printStackTrace();
			return "mobile/refund-apply-fail";
		}
		return "mobile/refund-apply-success";
	}

	/**
	 * 申请退款（测试使用）
	 * @return
	 */
	@RequestMapping("sd-refund")
	public @ResponseBody
	Map<String, String> sdRefund(){
		Map<String, String> resMap = new HashMap<>();
		String statusCode = "200", message = "退款成功";
		Timestamp ts = DateUtil.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String appid = "wxe4bcb04f38969b18";//公众账号ID
		String mch_id = "1404452802";//微信商户号
		String apiKey = "tN3Hi3VGsCX8ZY9ohsP6V51VLW9NI6Kn";//API秘钥
		//组装请求参数
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("appid",appid);//公众账号ID
		paraMap.put("mch_id",mch_id);//商户号
		paraMap.put("nonce_str",WXPayUtil.generateNonceStr());//随机字符串
		paraMap.put("out_trade_no","20190913202929-sHELtZx8e2");//商户订单号
		//根据当前系统时间加随机序列来生成退款单号
		String out_refund_no = sdf.format(new Date()) + "-" + RandomStringUtils.randomAlphanumeric(10);
		paraMap.put("out_refund_no",out_refund_no);//商户退款单号
		paraMap.put("total_fee","2");//订单金额，单位为分
		paraMap.put("refund_fee","1");//退款金额，单位为分
		paraMap.put("refund_desc", "测试退款");//退款原因
		try {
			String sign = WXPayUtil.generateSignature(paraMap, apiKey);
			paraMap.put("sign",sign);
			// 申请退款 https://api.mch.weixin.qq.com/secapi/pay/refund
			//发送post请求
			WXPayConfig wxPayConfig = new WXPayConfigImpl();
			WXPay wxPay = new WXPay(wxPayConfig);
			Map<String, String> map = wxPay.refund(paraMap);
			logger.info("------------退款返回结果--------------"+map);
			String return_code = map.get("return_code");
			String result_code = map.get("result_code");
			if(return_code.equals("SUCCESS")){
				if(result_code.equals("SUCCESS")){
					String transaction_id = map.get("transaction_id");//微信订单号
					String out_trade_no = map.get("out_trade_no");//商户订单号
					String out_refund_no1 = map.get("out_refund_no");//商户退款单号
					String refund_id = map.get("refund_id");//微信退款单号
					String refund_fee = map.get("refund_fee");//退款总金额,单位为分,可以做部分退款
					String total_fee = map.get("total_fee");//订单总金额，单位为分，只能为整数
					String cash_fee = map.get("cash_fee");//现金支付金额，单位为分，只能为整数
					//保存微信退款结果表
					WxRefundResult wxRefundResult = new WxRefundResult();
					wxRefundResult.setTransactionId(transaction_id);
					wxRefundResult.setOutTradeNo(out_trade_no);
					wxRefundResult.setOutRefundNo(out_refund_no1);
					wxRefundResult.setRefundId(refund_id);
					wxRefundResult.setRefundFee(Integer.parseInt(refund_fee));
					wxRefundResult.setTotalFee(Integer.parseInt(total_fee));
					wxRefundResult.setCashFee(Integer.parseInt(cash_fee));
					wxRefundResult.setRefundTimeEnd(ts);
					wxRefundResultManager.save(wxRefundResult);
				}else{
					logger.info("------------退款失败--------------result_code="+result_code);
				}
			}else{
				logger.info("------------退款失败--------------return_code="+return_code);
				statusCode = "300";
				message = "退款失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = "300";
			message = "退款失败，请联系管理员";
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		return resMap;
	}

	/**
	 * 电表余额查询
	 * @param wxUser
	 * @return
	 */
	@RequestMapping("to-electric-balance")
	public String toElectricBalance(@ModelAttribute("wxUser") WxUser wxUser , Model model) {
		List<WxUserRoom> wxUserRoomList = wxUserRoomManager.findBy("wxUserId", wxUser.getOpenid());
		if(wxUserRoomList != null && wxUserRoomList.size() == 1){
			model.addAttribute("roomId",wxUserRoomList.get(0).getRoomId());
		}
		return "mobile/to-electric-balance";
	}

	/**
	 * 到显示余额页面
	 * @param roomId
	 * @param model
	 * @return
	 */
	@RequestMapping("electric-balance")
	public String electricBalance(String roomId, Model model) {
		FloorRoomInDevice roomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", roomId);
		String deviceId = roomInDevice.getDeviceId();
		String balance = "";
		try{
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			NameValuePair pair3 = new BasicNameValuePair("deviceId", deviceId);
			pairs.add(pair3);
			String result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getEnergyInfoForRealTime", pairs, "application/x-www-form-urlencoded");
			JSONObject jsonObject = JSON.parseObject(result);
			Object code = jsonObject.get("errcode");
			if (code.toString().equals("0")) {
				if (!jsonObject.get("data").toString().equals("null")) {
					JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
					JSONArray jsonArray = (JSONArray) jsonObject1.get("datas");
					if (jsonArray.size() != 0) {
						JSONObject js = (JSONObject) jsonArray.get(0);
						balance = js.get("balance") != null ? js.getString("balance").toString() : "";
					}
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		model.addAttribute("roomId",roomId);
		model.addAttribute("balance",balance);
		return "mobile/electric-balance";
	}


	/**
	 * 房间号是否存在
	 * @param roomId
	 * @return
	 */
	@RequestMapping("room-validate1")
	public @ResponseBody
	Map<String, Object> roomValidate1(String roomId){
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		try{
			FloorRoom floorRoom = floorRoomManager.findUniqueBy("rowName", roomId);
			if(floorRoom == null){
				statusCode = "300";
				message = "该房间号不存在！";
			}else{
				//查询房间是否绑定电表
				FloorRoomInDevice roomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", roomId);
				if(roomInDevice == null){
					statusCode = "300";
					message = "该房间没有绑定电表！";
				}
			}
		}catch(Exception e){
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		return resMap;
	}


	/**
	 * 定时向电费余额不足的用户发送消息
	 */
	public void sendMessage(){
		//https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxf14d663135422c5d&secret=0d0fff47f7ce518964a2c873abe2787d";
		String response = HttpClient.sendHttpRequest(url, "", "GET", "application/json;charset=utf-8");
		JSONObject result = JSONObject.parseObject(response);
		String access_token = (String) result.get("access_token");
		//调用客服接口-发消息
		String url1 = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+access_token;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("touser","");//OPENID
		paramMap.put("msgtype","text");//消息格式：文本消息
		Map<String, String> textMap = new HashMap<>();
		textMap.put("content","余额不足，请及时充值。");
		paramMap.put("text",textMap);
		String param = JSON.toJSONString(paramMap);
		String response1 = HttpClient.sendHttpRequest(url1, param, "POST", "application/json;charset=utf-8");
		JSONObject result1 = JSONObject.parseObject(response1);
		System.out.println(result1);
	}


	/**
	 * 到水费余额查询页面
	 * @param wxUser
	 * @param model
	 * @return
	 */
	@RequestMapping("to-water-balance")
	public String toWaterBalance(@ModelAttribute("wxUser") WxUser wxUser , Model model) {
		List<WxUserRoom> wxUserRoomList = wxUserRoomManager.findBy("wxUserId", wxUser.getOpenid());
		if(wxUserRoomList != null && wxUserRoomList.size() == 1){
			model.addAttribute("roomId",wxUserRoomList.get(0).getRoomId());
		}
		return "mobile/to-water-balance";
	}


	/**
	 * 显示水费余额
	 * @param roomId
	 * @param model
	 * @return
	 */
	@RequestMapping("water-balance")
	public String waterBalance(String roomId, Model model) {
		Double balance =0.00;
		WaterAccount waterAccount = waterAccountManager.findUniqueBy("roomName", roomId);
		if(waterAccount != null){
			balance = waterAccount.getBalance();
		}
		model.addAttribute("roomId",roomId);
		model.addAttribute("balance",balance);
		return "mobile/water-balance";
	}

	/**********************************************2019-11-14**************************************************/

	/**
	 * 到用户协议页面,如果已同意则直接到企业登录页面（2019-12-04修改为已同意则直接到一卡通申请选择页面）
	 */
	@RequestMapping("user-agreement")
	public String userAgreement(@ModelAttribute("wxUser") WxUser wxUser , Model model) {
		//判断是否是工作日
//		String hql_1 = "select dayNo from HolidayRecord";
//		List<String> holidayList = holidayRecordManager.find(hql_1);
//		SimpleDateFormat sdf_1 = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sdf_2 = new SimpleDateFormat("HH:mm:ss");
//		Date date = new Date();
//		String curr_day = sdf_1.format(date);
//		if(holidayList.contains(curr_day)){
//			//节假日不能申请
//			return "mobile/prompt-unable";
//		}else{
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(date);
//			//判断当前日期是否为周末
//			if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
//				//判断周末是否上班
//				String hql_2 = "select dayNo from WeekendWeekRecord";
//				List<String> weekendWeekList = weekendWeekRecordManager.find(hql_2);
//				if(!weekendWeekList.contains(curr_day)){
//					//周末不能申请
//					return "mobile/prompt-unable";
//				}
//			}
//		}
//		//工作日判断是否在上班时间段（09:00:00-17:00:00）
//		String curr_time = sdf_2.format(date);
//		String start_time = "09:00:00";
//		String end_time = "18:00:00";
//		if(curr_time.compareTo(start_time) < 0 || curr_time.compareTo(end_time) > 0){
//			//提示非工作日时间段不能申请
//			return "mobile/prompt-unable";
//		}
		//判断当前用户是否已同意协议
		String hql = "from UserAgreement where openId = ? and agreementType = ?";
		Object[] values = {wxUser.getOpenid(), "ykt"};
		UserAgreement userAgreement = userAgreementManager.findUnique(hql, values);
		if(userAgreement != null){
			return "mobile/ykt-apply-select";
		}else{
			return "mobile/user-agreement";
		}
	}

	/**
	 * 到企业登录页面（已同意用户协议）
	 */
//	@RequestMapping("enterprise-login")
//	public String enterpriseLogin(@ModelAttribute("wxUser") WxUser wxUser, String type, Model model) {
//		//保存是否同意用户协议
//		UserAgreement userAgreement = new UserAgreement();
//		userAgreement.setOpenId(wxUser.getOpenid());
//		userAgreement.setAgreementType("ykt");
//		userAgreement.setIsAgree("1");
//		userAgreementManager.save(userAgreement);
//		model.addAttribute("type",type);
//		return "mobile/enterprise-login";
//	}

	/**
	 * 企业账号登录验证
	 * @param enterpriseId 账号
	 * @param password 密码
	 * @return
	 */
//	@RequestMapping("enterprise-validate")
//	public @ResponseBody
//	Map<String, Object> enterpriseValidate(String enterpriseId, String password){
//		Map<String, Object> resMap = new HashMap<String, Object>();
//		String statusCode = "200", message = "操作成功";
//		try{
//			String hql = "from EnterpriseInfo where enterpriseId = ? and password = ?";
//			Object[] values = {enterpriseId, password};
//			List<EnterpriseInfo> enterpriseInfoList = enterpriseInfoManager.find(hql, values);
//			if(enterpriseInfoList == null || enterpriseInfoList.size() == 0){
//				statusCode = "300";
//				message = "用户名或密码错误";
//			}
//		}catch(Exception e){
//			statusCode = "300";
//			message = "系统错误";
//			e.printStackTrace();
//		}
//		resMap.put("statusCode", statusCode);
//		resMap.put("message", message);
//		return resMap;
//	}

	/**
	 * 企业登录成功，判断是否首次登记，是则到企业信息完善页面，否则到一卡通申请选择页面
	 * @param enterpriseId
	 * @param password
	 * @return
	 */
//	@RequestMapping("to-ykt-select")
//	public String toYktSelect(String enterpriseId, String password, Model model) {
//		EnterpriseInfo enterpriseInfo = enterpriseInfoManager.findUniqueBy("enterpriseId", enterpriseId);
//		String isFirst = enterpriseInfo.getIsFirst() == null ? "":enterpriseInfo.getIsFirst();
//		if(isFirst.length() == 0){
//			model.addAttribute("enterpriseId",enterpriseId);
//			model.addAttribute("password",password);
//			return "mobile/enterprise-info";
//		}else{
//			model.addAttribute("enterpriseInfo",enterpriseInfo);
//			return "mobile/ykt-apply-select";
//		}
//	}


	/**
	 * 到一卡通申请选择页面（2019-12-04）
	 * @return
	 */
	@RequestMapping("to-ykt-select")
	public String toYktSelect(@ModelAttribute("wxUser") WxUser wxUser) {
		UserAgreement userAgreement = new UserAgreement();
		userAgreement.setOpenId(wxUser.getOpenid());
		userAgreement.setAgreementType("ykt");
		userAgreement.setIsAgree("1");
		userAgreementManager.save(userAgreement);
		return "mobile/ykt-apply-select";
	}

	/**
	 * 到选择一卡通申请表单页面（2019-12-04）
	 * @param type 选择个人申请/企业申请
	 * @return
	 */
	@RequestMapping("to-ykt-apply")
	public String toYktApply(String type) {
		if(type.equals("1")){
			return "mobile/ykt-form-1";
		}else{
			//选择企业申请，到输入企业名称页面
			return "mobile/enterprise-name-input";
//			return "mobile/ykt-form-2";
		}
	}

	/**
	 * 企业检验
	 * @param enterpriseName
	 * @return
	 */
	@RequestMapping("enterprise-validate")
	public @ResponseBody
	Map<String, Object> enterpriseValidate(String enterpriseName){
		Map<String, Object> resMap = new HashMap<>();
		String statusCode = "200", message = "验证成功";
		try{
			EnterpriseInfo enterpriseInfo = enterpriseInfoManager.findUniqueBy("enterpriseName", enterpriseName);
			if(enterpriseInfo == null){
				statusCode = "300";
				message = "企业名称不存在";
			}
		}catch(Exception e){
			statusCode = "300";
			message = "系统错误";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		return resMap;
	}


	/**
	 * 到企业一卡通申请页面
	 * @param enterpriseName
	 * @return
	 */
	@RequestMapping("to-ykt-apply-qy")
	public String toYktApplyQy(String enterpriseName, Model model) {
		EnterpriseInfo enterpriseInfo = enterpriseInfoManager.findUniqueBy("enterpriseName", enterpriseName);
		String isFirst = enterpriseInfo.getIsFirst() == null ? "" : enterpriseInfo.getIsFirst();
		model.addAttribute("enterpriseInfo", enterpriseInfo);
		if(isFirst.equals("")){
			return "mobile/enterprise-info";
		}else{
			return "mobile/ykt-form-2";
		}
	}


	/**
	 * 保存企业信息，到企业一卡通申请页面
	 */
	@RequestMapping("enterprise-save")
	public String enterpriseSave(@ModelAttribute("wxUser") WxUser wxUser, EnterpriseInfo enterpriseInfo,Model model) {
		Timestamp ts = DateUtil.getDate();
		EnterpriseInfo dest = enterpriseInfoManager.findUniqueBy("enterpriseName", enterpriseInfo.getEnterpriseName());
		beanMapper.copy(enterpriseInfo, dest);
		dest.setIsFirst("1");
		dest.setCreateTime(ts);
		dest.setCreateUserId(wxUser.getOpenid());
		enterpriseInfoManager.save(dest);
		model.addAttribute("enterpriseInfo",dest);

		//到企业申请表单页面（2019-12-04）
		return "mobile/ykt-form-2";

//		return "mobile/ykt-apply-select";
	}

	/**
	 * 到选择一卡通申请表单页面
	 * @return
	 */
//	@RequestMapping("to-ykt-apply")
//	public String toYktApply(String type, String enterpriseId, Model model) {
//		EnterpriseInfo enterpriseInfo = enterpriseInfoManager.findUniqueBy("enterpriseId", enterpriseId);
//		model.addAttribute("enterpriseInfo",enterpriseInfo);
//		if(type.equals("1")){
//			return "mobile/ykt-form-1";
//		}else{
//			return "mobile/ykt-form-2";
//		}
//	}

	/**
	 * 导入一卡通人员明细
	 * @param file
	 * @param session
	 * @param wxUser
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("import")
	public @ResponseBody
	Map<String, Object> oneCardImport(@RequestParam MultipartFile file,HttpSession session,
									  @ModelAttribute("wxUser") WxUser wxUser) throws IOException {
		System.out.println("------------进入导入后台--------------");
		String statusCode = "200", message = "导入成功";
		List<OneCardPersonDetail> list = new ArrayList<>();
		Map<String, Object> resMap = new HashMap<>();
		Timestamp ts = DateUtil.getDate();
		String fileOriginalName = file.getOriginalFilename();
		int index = fileOriginalName.lastIndexOf(".");
		String file_type = fileOriginalName.substring(index+1);
		OneCardImportRecord oneCardImportRecord;
		try {
			if (!StringUtils.isEmpty(fileOriginalName)) {
				FileUtil fileHelper = new FileUtil();
				String decodeFileName = fileHelper.getDecodeFileName(fileOriginalName);// 文件名编码
				String mFilePath = session.getServletContext().getRealPath(""); // 取得服务器路径
				mFilePath = mFilePath.substring(0, 2) + "\\jbxqycy" + "\\ykt\\" + decodeFileName;
				fileHelper.createFile(mFilePath, file.getBytes());
				oneCardImportRecord = new OneCardImportRecord();
				oneCardImportRecord.setFilePath(mFilePath);
				oneCardImportRecord.setFileName(fileOriginalName);
				oneCardImportRecord.setFileIdentifyName(decodeFileName);
				oneCardImportRecord.setFileType(file_type);
				oneCardImportRecord.setUploadUserId(wxUser.getOpenid());
				oneCardImportRecord.setUploadUserName(wxUser.getNickname());
				oneCardImportRecord.setUploadTime(ts);
				//保存
				oneCardImportRecordManager.save(oneCardImportRecord);
				int k=0;
				int flag = 0;   //指示指针所访问的位置
				String f = "true"; //当前行的列是否有空值 true为没有，false有空值，不继续保存，保存失败
				String reson = "";//导入失败原因
				String path=mFilePath;//获取文件的路径
				Workbook workbook = null;
				workbook = new XSSFWorkbook(path);//初始化workbook对象
				for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {       //读取每一个sheet
					System.out.println("2007版进入读取sheet的循环");
					if (null != workbook.getSheetAt(numSheets)) {
						XSSFSheet aSheet = (XSSFSheet) workbook.getSheetAt(numSheets);//定义Sheet对象
						for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) {
							//进入当前sheet的行的循环
							if (null != aSheet.getRow(rowNumOfSheet)) {
								XSSFRow aRow = aSheet.getRow(rowNumOfSheet); //定义行，并赋值
								OneCardPersonDetail oneCardPersonDetail = new OneCardPersonDetail();
								System.out.println(aRow.getLastCellNum()+"num"+"rowNumOfSheet"+rowNumOfSheet);
								for (int cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++) {    //读取rowNumOfSheet值所对应行的数据
									XSSFCell xCell = aRow.getCell(cellNumOfRow); //获得行的列数                                                           //获得列值
									//System.out.println("type="+xCell.getCellType());
									//读取每一个sheet
									if (null != aRow.getCell(cellNumOfRow)) {

										if (rowNumOfSheet == 0) {    // 如果rowNumOfSheet的值为0，则读取表头，判断excel的格式和预定格式是否相符
											if (xCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {

											} else if (xCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {

											} else if (xCell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
												if (cellNumOfRow == 0) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("物料种类")) {
														flag++;
													}
													if (!xCell.getStringCellValue().equals("姓名")) {
														statusCode = "300";
														message = "请按导入示例导入！";
													}
												} else if (cellNumOfRow == 1) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("物料名称")) {
														flag++;
													}
													if (!xCell.getStringCellValue().equals("身份证号")) {
														statusCode = "300";
														message = "请按导入示例导入！";
													}
												} else if (cellNumOfRow == 2) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("管理人员")) {
														flag++;
													}
													if (!xCell.getStringCellValue().equals("手机号")) {
														statusCode = "300";
														message = "请按导入示例导入！";
													}
												}
											}
										}else {
											// rowNumOfSheet != 0 即开始保存数据
											oneCardPersonDetail.setCreateUserId(wxUser.getOpenid());
											oneCardPersonDetail.setCreateTime(ts);
											if (cellNumOfRow == 0) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												oneCardPersonDetail.setUserName(xCell.getStringCellValue());
											} else if (cellNumOfRow == 1) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												oneCardPersonDetail.setUserIdCard(xCell.getStringCellValue());
											} else if (cellNumOfRow == 2) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												oneCardPersonDetail.setUserPhone(xCell.getStringCellValue());//申领单位
											}
											k++;
										}
									} //获得一行，即读取每一行
								}
								//保存
								if(!statusCode.equals("300")){
									if(oneCardPersonDetail.getCreateTime() != null){
										if(oneCardPersonDetail.getUserName()!=null && oneCardPersonDetail.getUserIdCard()!=null && oneCardPersonDetail.getUserPhone()!=null
												&& oneCardPersonDetail.getUserName()!="" && oneCardPersonDetail.getUserIdCard()!="" && oneCardPersonDetail.getUserPhone()!=""){
											oneCardImportRecordManager.save(oneCardPersonDetail);
											list.add(oneCardPersonDetail);
										}else{
											statusCode = "300";
											message = "所有项不能为空，请完善后再导入";
										}
									}
								}
							}
						}
					}
				}
			} else {
				message = "请选择导入文件";
				statusCode = "300";
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "导入失败";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("list", list);
		resMap.put("cardNumber", list.size());
		return resMap;
	}

	/**
	 * 一卡通申请保存-微信端
	 * @param wxUser
	 * @param model
	 * @param oneCardId 企业申请，人员明细ID字符串
	 * @param oneCardApply 一卡通申请表
	 * @param oneCardModel 一卡通人员明细list
	 * @param attachmentId 关联附件ID字符串
	 * @return
	 */
	@RequestMapping(value = "ykt-save")
	public String yktSave(@ModelAttribute("wxUser") WxUser wxUser,
						  String oneCardId, OneCardApply oneCardApply, OneCardModel oneCardModel, String attachmentId, Model model) {
		String[] idArr = (oneCardId == null || oneCardId == "") ? null : oneCardId.split(",");
		List<OneCardPersonDetail> oneCardList = oneCardModel.getOneCardList();
		String statusCode = "200";
		Timestamp ts = DateUtil.getDate();
		OneCardApply dest ;
		String rowId = oneCardApply.getRowId();
		try{
			if(rowId != null && rowId.length() > 0){
				dest = oneCardApplyManager.get(rowId);
				beanMapper.copy(oneCardApply, dest);
				dest.setModifyUserId(wxUser.getOpenid());
				dest.setModifyUserName(wxUser.getNickname());
				dest.setModifyTime(ts);
				dest.setPayMoney(oneCardApply.getCardNumber()*10);
			}else{
				dest = oneCardApply;
				dest.setRowId(null);
				dest.setCreateUserId(wxUser.getOpenid());
				dest.setCreateUserName(wxUser.getNickname());
				dest.setCreateTime(ts);
			}
			oneCardApplyManager.save(dest);
			rowId = dest.getRowId();
			//企业申请（手动录入）
			if(oneCardList != null && oneCardList.size() > 0){
				for (OneCardPersonDetail oneCardPersonDetail : oneCardList) {
					String personId = oneCardPersonDetail.getRowId() == null ? "":oneCardPersonDetail.getRowId();
					OneCardPersonDetail dest1;
					if(!personId.equals("")){
						dest1 = oneCardPersonDetailManager.get(personId);
						beanMapper.copy(oneCardPersonDetail, dest);
					}else{
						dest1 = oneCardPersonDetail;
						dest1.setRelationId(rowId);
						dest1.setCreateUserId(wxUser.getOpenid());
						dest1.setCreateTime(ts);
					}
					oneCardPersonDetailManager.save(dest1);
				}
			}
			//企业申请（excel导入）
			if(idArr != null && idArr.length > 1){
				for(int i=0;i<idArr.length;i++){
					OneCardPersonDetail oneCardPersonDetail = oneCardPersonDetailManager.get(idArr[i]);
					oneCardPersonDetail.setRelationId(rowId);
					oneCardPersonDetail.setCreateUserId(wxUser.getOpenid());
					oneCardPersonDetail.setCreateTime(ts);
					oneCardPersonDetailManager.save(oneCardPersonDetail);
				}
			}
			//关联附件
			relationFile(attachmentId, rowId);
			//判断新增还是修改
			ProcInstance pi = procInstanceManager.findUniqueBy("businessId", rowId);
			if(pi == null){
				//创建流程实例
				ProcTemplate procTemplate = procTemplateManager.findUniqueBy("processKey", "yktzzsq");
				String processId = procTemplate.getProcessId();
				ProcInstance procInstance = new ProcInstance();
				procInstance.setProcessId(processId);
				procInstance.setProcessName(procTemplate.getProcessName());
				procInstance.setBusinessId(rowId);
//				String hql = "from ProcAct where processId = ? and backAct = ? and dataType = ?";
//				Object[] values = {processId, "申请", dest.getReceivePlace()};
//				ProcAct procAct = procActManager.findUnique(hql, values);
//				String actName = procAct.getActName();
				procInstance.setInstanceState("申请");
				procInstance.setActiveState("激活");
				procInstance.setCreateTime(ts);
				procInstance.setCreateUserId(wxUser.getOpenid());
				procInstance.setCreateUserName(wxUser.getNickname());
				procInstanceManager.save(procInstance);
				String instanceId = procInstance.getRowId();
				//根据领取点生成节点实例（2019-11-15）
				String hql1 = "from ProcAct where processId = ? and dataType = ?";
				String dataType = dest.getReceivePlace();
				//临时修改（孵鹰大厦A、B、C、D座和腾飞大厦A、B、C座都在一个审核账号下面）
				if(dataType.indexOf("孵鹰大厦") != -1 || dataType.indexOf("孵鹰大厦") != -1){
					dataType = "孵鹰大厦";
				}
				Object[] values1 = {processId, dataType};
				List<ProcAct> actList = procActManager.find(hql1, values1);
				for(ProcAct act : actList){
					ProcActInstance procActInstance = new ProcActInstance();
					procActInstance.setProcessId(processId);
					procActInstance.setInstanceId(instanceId);
					procActInstance.setBusinessId(rowId);
					procActInstance.setActId(act.getActId());
					procActInstance.setActName(act.getActName());
					procActInstance.setActBack(act.getBackAct());
					procActInstance.setActNext(act.getNextAct());
					procActInstance.setActOrder(act.getActOrder());
					procActInstance.setHandleUser(act.getHandleUserName());
					procActInstance.setHandleUser1(act.getHandleUserName1());
					if(act.getActName().equals("申请")){
						procActInstance.setHandleUser(wxUser.getNickname());
						procActInstance.setHandleUser1(wxUser.getOpenid());
						procActInstance.setActiveState("激活");
						procActInstance.setStepState("正在执行");
						procActInstance.setFinishTime(ts);
					}
					//保存节点实例
					procActInstanceManager.save(procActInstance);
				}
			}else{
				if(dest.getOutTradeNo() != null && dest.getOutTradeNo() != ""){
					//当前步骤取消激活状态
					String instanceId = pi.getRowId();
					String hql = "from ProcActInstance where instanceId = ? and actName = ?";
					Object[] values = {instanceId, "申请"};
					ProcActInstance currentAct = procActInstanceManager.findUnique(hql, values);
					currentAct.setActiveState(null);
					currentAct.setStepState("已同意");
					currentAct.setFinishTime(ts);
					procActInstanceManager.save(currentAct);
					//下一步设置激活状态
					String actNext = currentAct.getActNext();
					Object[] values1 = {instanceId,actNext};
					ProcActInstance NextAxt = procActInstanceManager.findUnique(hql, values1);
					NextAxt.setActiveUserId(wxUser.getOpenid());
					NextAxt.setActiveUserName(wxUser.getNickname());
					NextAxt.setActiveTime(ts);
					NextAxt.setActiveState("激活");
					NextAxt.setStepState("正在进行");
					procActInstanceManager.save(NextAxt);
					//设置流程实例状态
					pi.setInstanceState(actNext);
					procInstanceManager.save(pi);
					//创建历史意见表
					HistoryOpinion historyOpinion = new HistoryOpinion();
					historyOpinion.setTableId(rowId);
					historyOpinion.setPiId(instanceId);
					historyOpinion.setHandleStage("申请");
					historyOpinion.setHandleProcess(wxUser.getNickname()+"提交给"+NextAxt.getHandleUser());
					historyOpinion.setHandleOpinion("");
					historyOpinion.setHandleUser(wxUser.getNickname());
					historyOpinion.setHandleTime(ts);
					historyOpinionManager.save(historyOpinion);
					return "mobile/apply-success";
				}

			}
		}catch (Exception e) {
			// TODO: handle exception
			statusCode = "300";
			e.printStackTrace();
		}
		if(statusCode.equals("200")){
			model.addAttribute("rowId",rowId);
			return "mobile/ykt-save-success";
		}else{
			return "mobile/apply-fail";
		}
	}

	/**
	 * 到一卡通支付页面
	 * @return
	 */
	@RequestMapping("to-ykt-pay")
	public String toYktPay(String rowId,Model model) {
		OneCardApply oneCardApply = oneCardApplyManager.get(rowId);
		Integer cardNumber = oneCardApply.getCardNumber();
		Integer payMoney = cardNumber * 10;
		model.addAttribute("cardNumber",cardNumber);
		model.addAttribute("rowId",rowId);
		model.addAttribute("payMoney",payMoney);
		return "mobile/ykt-pay";
	}

	/**
	 * 一卡通支付下单
	 * @param wxUser
	 * @param rowId
	 * @param payMoney
	 * @param request
	 * @return
	 */
	@RequestMapping("ykt-order")
	public @ResponseBody
	Map<String,String> yktOrder(@ModelAttribute("wxUser") WxUser wxUser,String rowId, Double payMoney, HttpServletRequest request){
		//发送到前台的数据
		Map<String, String> payMap = new HashMap<>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String openid = wxUser.getOpenid();//用户唯一标识
		String appid = "wxe4bcb04f38969b18";//公众账号ID
		String mch_id = "1404452802";//微信商户号
		String apiKey = "tN3Hi3VGsCX8ZY9ohsP6V51VLW9NI6Kn";//API秘钥
		String total_fee = String.valueOf((int)(payMoney*100));
		System.out.println("----------------------"+total_fee);
		try {
			//获取请求ip地址
			String ip = request.getHeader("x-forwarded-for");
			if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
				ip = request.getHeader("Proxy-Client-IP");
			}
			if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
				ip = request.getRemoteAddr();
			}
			if(ip.indexOf(",")!=-1){
				String[] ips = ip.split(",");
				ip = ips[0].trim();
			}
			//组装请求参数
			Map<String, String> paraMap = new HashMap<>();
			paraMap.put("appid",appid);//公众账号ID
			paraMap.put("mch_id",mch_id);//商户号
			paraMap.put("nonce_str",WXPayUtil.generateNonceStr());//随机字符串
			//根据当前系统时间加随机序列来生成订单号
			String out_trade_no = sdf.format(new Date()) + "-" + RandomStringUtils.randomAlphanumeric(10) + "-ykt";
			String body = "研创园-一卡通支付";
			paraMap.put("body",body);//商品描述
			paraMap.put("openid",openid);//用户标识，JSAPI支付此参数必传
			paraMap.put("out_trade_no",out_trade_no);//商户订单号
			paraMap.put("total_fee", "1");//标价金额，单位为分（暂时修改，测试使用）
			paraMap.put("spbill_create_ip",ip);//终端IP
			paraMap.put("trade_type","JSAPI");//交易类型
			paraMap.put("notify_url","http://watch.njitrip.cn/mobile/ykt-pay-result.do");//通知地址，异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
			//生成带有sign的XML格式字符串
			String xml = WXPayUtil.generateSignedXml(paraMap, apiKey);//待签名数据，API密钥
			// 统一下单 https://api.mch.weixin.qq.com/pay/unifiedorder
			//发送post请求"统一下单接口"返回预支付id:prepay_id
			String response = HttpClient.sendHttpRequest("https://api.mch.weixin.qq.com/pay/unifiedorder", xml, "POST", "application/xml;charset=utf-8");

			//返回前端页面的json数据
			if (response.indexOf("SUCCESS") != -1) {
				Map<String, String> map = WXPayUtil.xmlToMap(response);
				String prepay_id = map.get("prepay_id");
				payMap.put("appId", appid);
				payMap.put("timeStamp", WXPayUtil.getCurrentTimestamp()+"");
				payMap.put("nonceStr", WXPayUtil.generateNonceStr());
				payMap.put("signType", "MD5");
				payMap.put("package", "prepay_id=" + prepay_id);
				String paySign = WXPayUtil.generateSignature(payMap, apiKey);//待签名数据，API密钥
				payMap.put("paySign", paySign);
				//保存到数据库
				OneCardOrder oneCardOrder = new OneCardOrder();
				oneCardOrder.setOutTradeNo(out_trade_no);
				oneCardOrder.setOpenid(openid);
				oneCardOrder.setPrepayId(prepay_id);
				oneCardOrder.setSpbillCreateIp(ip);
				oneCardOrder.setTotalFee((int) (payMoney*100));
				oneCardOrder.setCreateTime(ts);
				oneCardOrder.setOrderState("0");//下单
				oneCardOrder.setDataDelete("1");
				oneCardOrder.setRelationId(rowId);
				oneCardOrderManager.save(oneCardOrder);
			}else{
				statusCode = "300";
				message = "支付失败";
			}
			//保存充值记录表
		} catch (Exception e) {
			statusCode = "300";
			message = "充值失败";
			e.printStackTrace();
		}
		payMap.put("statusCode",statusCode);
		payMap.put("message",message);
		return payMap;
	}


	/**
	 * 一卡通支付结果通知
	 * @param request
	 * @return
	 */
	@RequestMapping("ykt-pay-result")
	public @ResponseBody
	String yktPayResult(HttpServletRequest request) {
		Timestamp ts = DateUtil.getDate();
		String apiKey = "tN3Hi3VGsCX8ZY9ohsP6V51VLW9NI6Kn";//API秘钥
		try {
			InputStream is = request.getInputStream();
			String xmlString = WXPayUtil.inputStream2String(is,"UTF-8");
			Map<String, String> paraMap = WXPayUtil.xmlToMap(xmlString);
			logger.info("----------------------一卡通支付结果通知----------------------");
			String return_code = paraMap.get("return_code");
			if(return_code.equals("SUCCESS")){
				String result_code = paraMap.get("result_code");//业务结果
				String openid = paraMap.get("openid");//用户标识
				String is_subscribe = paraMap.get("is_subscribe");//是否关注公众账号
				String bank_type = paraMap.get("bank_type");//付款银行
				String total_fee = paraMap.get("total_fee");//订单金额
				String cash_fee = paraMap.get("cash_fee");//现金支付金额
				String transaction_id = paraMap.get("transaction_id");//微信支付订单号
				String out_trade_no = paraMap.get("out_trade_no");//商户订单号
				String time_end = paraMap.get("time_end");//支付完成时间
				//签名验证
				if(WXPayUtil.isSignatureValid(xmlString,apiKey)){
					/**
					 * 同样的通知可能会多次发送给商户系统。商户系统必须能够正确处理重复的通知
					 * 后台通知交互时，如果微信收到商户的应答不符合规范或超时，微信会判定本次通知失败，重新发送通知，直到成功为止
					 * （在通知一直不成功的情况下，微信总共会发起多次通知，通知频率为15s/15s/30s/3m/10m/20m/30m/30m/30m/60m/3h/3h/3h/6h/6h - 总计 24h4m）
					 * 但微信不保证通知最终一定能成功。
					 * 当收到通知进行处理时，首先检查对应业务数据的状态，判断该通知是否已经处理过，如果没有处理过再进行处理，如果处理过直接返回结果成功。
					 * 在对业务数据进行状态检查和处理之前，要采用数据锁进行并发控制，以避免函数重入造成的数据混乱。
					 */
					WxPayResult wxPayResult = wxPayResultManager.findUniqueBy("outTradeNo", out_trade_no);
					if(wxPayResult != null){
						//已处理通知，直接返回结果成功
						Map<String,String> resMap = new HashMap<>();
						resMap.put("return_msg","OK");
						resMap.put("return_code","SUCCESS");
						String xml = WXPayUtil.mapToXml(resMap);//将map转xml格式
						return xml;
					}else{
						//未处理通知
						wxPayResult = new WxPayResult();
						wxPayResult.setRowId(null);
						wxPayResult.setBankType(bank_type);
						wxPayResult.setCashFee(Integer.parseInt(cash_fee));
						wxPayResult.setIsSubscribe(is_subscribe);
						wxPayResult.setOpenid(openid);
						wxPayResult.setOutTradeNo(out_trade_no);
						wxPayResult.setResultCode(result_code);
						wxPayResult.setTotalFee(Integer.parseInt(total_fee));
						wxPayResult.setTransactionId(transaction_id);
						wxPayResult.setTimeEnd(time_end);
						wxPayResultManager.save(wxPayResult);
						//得到一卡通下单表
						OneCardOrder oneCardOrder = oneCardOrderManager.findUniqueBy("outTradeNo", out_trade_no);
						oneCardOrder.setOrderState("1");
						oneCardOrderManager.save(oneCardOrder);
						//得到一卡通申请表
						String relationId = oneCardOrder.getRelationId();
						OneCardApply oneCardApply = oneCardApplyManager.get(relationId);
						oneCardApply.setOutTradeNo(out_trade_no);
						oneCardApplyManager.save(oneCardApply);
						//当前流程提交下一步，审核
						ProcInstance pi = procInstanceManager.findUniqueBy("businessId", oneCardApply.getRowId());
						String instanceId = pi.getRowId();
						String hql = "from ProcActInstance where instanceId = ? and actName = ?";
						Object[] values = {instanceId, "申请"};
						ProcActInstance currentAct = procActInstanceManager.findUnique(hql, values);
						currentAct.setActiveState(null);
						currentAct.setStepState("已同意");
						currentAct.setFinishTime(ts);
						procActInstanceManager.save(currentAct);
						//下一步设置激活状态
						String actNext = currentAct.getActNext();
						Object[] values1 = {instanceId,actNext};
						ProcActInstance NextAxt = procActInstanceManager.findUnique(hql, values1);
						NextAxt.setActiveUserId(oneCardApply.getCreateUserId());
						NextAxt.setActiveUserName(oneCardApply.getCreateUserName());
						NextAxt.setActiveTime(ts);
						NextAxt.setActiveState("激活");
						NextAxt.setStepState("正在进行");
						procActInstanceManager.save(NextAxt);
						//设置流程实例状态
						pi.setInstanceState(actNext);
						procInstanceManager.save(pi);
						//创建历史意见表
						HistoryOpinion historyOpinion = new HistoryOpinion();
						historyOpinion.setTableId(relationId);
						historyOpinion.setPiId(instanceId);
						historyOpinion.setHandleStage("申请");
						historyOpinion.setHandleProcess(oneCardApply.getApplicantName()+"提交给"+NextAxt.getHandleUser());
						historyOpinion.setHandleOpinion("已缴费");
						historyOpinion.setHandleUser(oneCardApply.getApplicantName());
						historyOpinion.setHandleTime(ts);
						historyOpinionManager.save(historyOpinion);
						logger.info("----------------------一卡通支付结果通知成功----------订单号"+out_trade_no+"----------------------");
					}
				}else{
					logger.info("----------------------一卡通支付结果通知验证签名失败：----------订单号"+out_trade_no+"----------------------");
				}
			}
			//返回参数
			Map<String,String> resMap = new HashMap<>();
			resMap.put("return_code","SUCCESS");
			resMap.put("return_msg","OK");
			String xml = WXPayUtil.mapToXml(resMap);//将map转xml格式
			return xml;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 一卡通支付成功页面
	 * @return
	 */
	@RequestMapping("ykt-pay-success")
	public String yktPaySuccess() { return "mobile/ykt-pay-success"; }

	/**
	 * 一卡通申请进度查询
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("ykt-progress-list")
	public String yktProgressList(@ModelAttribute("wxUser") WxUser wxUser,
								  @RequestParam Map<String, Object> parameterMap, Model model){
		//添加条件为根据当前用户查询
		parameterMap.put("filter_EQS_createUserId", wxUser.getOpenid());
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		List<VYktProcinst> list = vYktProcinstManager.find("createTime", false ,propertyFilters);
		model.addAttribute("list", list);
		model.addAttribute("parameterMap", parameterMap);
		return "mobile/ykt-progress-list";
	}

	/**
	 * 一卡通申请查看详情
	 * @param model
	 * @return
	 */
	@RequestMapping("to-ykt-view")
	public String toYktView(String rowId, Model model){
		VYktProcinst vYktProcinst = vYktProcinstManager.get(rowId);
		String instanceState = vYktProcinst.getInstanceState();
		model.addAttribute("instanceState", instanceState);
		//申请表
		OneCardApply oneCardApply = oneCardApplyManager.get(rowId);
		model.addAttribute("model", oneCardApply);
		//人员明细表
		List<OneCardPersonDetail> oneCardPersonList = oneCardPersonDetailManager.findBy("relationId", rowId);
		model.addAttribute("oneCardPersonList", oneCardPersonList);
		//附件
		List<WxAttachment> attachList = wxAttachmentManager.findBy("relationId", rowId);
		model.addAttribute("attachList", attachList);
		//节点意见
		String hql = "from ProcActInstance where instanceId = ? and actInstRemark is not null order by actOrder asc";
		Object[] values = {vYktProcinst.getInstanceId()};
		List<ProcActInstance> list = procActInstanceManager.find(hql, values);
		model.addAttribute("list", list);
		if(instanceState.equals("申请")){
			return "mobile/ykt-form-update";
		}else{
			return "mobile/ykt-view";
		}
	}

}
