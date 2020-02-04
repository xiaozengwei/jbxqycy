package com.gx.soft.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.spring.TimeStampPropertyEditor;
import com.gx.core.util.Md5Utils;
import com.gx.soft.common.util.HttpClient;
import com.gx.soft.common.wxpay.WXPayUtil;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.sd.persistence.domain.*;
import com.gx.soft.sd.persistence.manager.*;
import com.gx.soft.sd.persistence.model.QueryModel;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.manager.GxSysOrgManager;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.ykt.persistence.domain.OneCardSolution;
import com.gx.soft.ykt.persistence.manager.OneCardInfoManager;
import com.gx.soft.ykt.persistence.manager.OneCardSolutionManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("message")
@SessionAttributes("user_session")
public class MessageController {
	static Logger logger = Logger.getLogger(MessageController.class);
	@Autowired
	private GxSysOrgManager gxSysOrgManager;
	@Autowired
	private VUserManager vUserManager;

	@Autowired
	private SdRechargeRecordManager sdRechargeRecordManager;

	@Autowired
	private WxUserRoomManager wxUserRoomManager;

	@Autowired
	private InsideUserManager insideUserManager;



    @Autowired
    private OneCardSolutionManager oneCardSolutionManager;
	
	private BeanMapper beanMapper = new BeanMapper();
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
							  ServletRequestDataBinder binder) throws Exception {
		// TODO Auto-generated method stub
		binder.registerCustomEditor(Timestamp.class,
				new TimeStampPropertyEditor());
	}

	/**
	 * 到测试发送短信页面
	 * @return
	 */
	@RequestMapping("to-test-message")
	public String toTestMessage() {
//		List<InsideUser> insideUserList = insideUserManager.getAll();
//		for (InsideUser insideUser:insideUserList) {
//			List<OneCardSolution> oneCardSolutionList = oneCardSolutionManager.findBy("userPhone",insideUser.getMobilePhone());
//			if(oneCardSolutionList != null && oneCardSolutionList.size() >0){
//				for (OneCardSolution oneCardSolution:oneCardSolutionList) {
//					oneCardSolutionManager.remove(oneCardSolution);
//				}
//			}
//		}
//		String PHONE_NUMBER_REG = "^(1[3-9])\\d{9}$";
//		String mobile = "";
//		try{
//			for (InsideUser insideUser:insideUserList) {
//				boolean flag = insideUser.getMobilePhone().matches(PHONE_NUMBER_REG);
//				if(flag == true){
//					if(mobile.equals("")){
//						mobile += insideUser.getMobilePhone();
//					}else{
//						if(!mobile.contains(insideUser.getMobilePhone())){
//							mobile += ","+insideUser.getMobilePhone();
//						}
//					}
//				}
//			}
//		}catch (Exception e){
//			e.printStackTrace();
//		}
		return "message/test-message";
	}

	/**
	 * 检查关键词
	 * @param user
	 * @param messageContent
	 * @return
	 */
	@RequestMapping(value = "validate", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> validate(@ModelAttribute("user_session") GxSysUser user, String messageSign, String messageContent) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "没有包含屏蔽词";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());
		String content = messageSign+messageContent;
		try {
			Map<String, String> param = new HashMap<String, String>();
			param.put("userid", "273");//企业ID,273
			param.put("timestamp", timestamp);//时间戳，系统当前时间字符串，年月日时分秒
			String signStr = "nanjinglhcz"+"nanjinglhcz"+timestamp;
			String sign = WXPayUtil.MD5Lower(signStr);
			param.put("sign", sign);//签名，使用 账号+密码+时间戳 生成MD5字符串作为签名。MD5生成32位，且需要小写
			param.put("action", "checkkeyword");//发送任务命令，固定为：checkkeyword
			param.put("content", content);//内容
			String paramStr = JSON.toJSONString(param);
			String url = "http://47.96.185.189:8088/v2sms.aspx?action=checkkeyword&userid=273&timestamp="+timestamp+"&sign="+sign+"&content="+content;
			String response = HttpClient.sendHttpRequest(url, paramStr,"POST", "application/xml;charset=utf-8");
			Map<String, String> responseMap = WXPayUtil.xmlToMap(response);
			if(responseMap.get("message").equals("包含非法字符")){
				statusCode = "300";
				message = "包含非法字符";
			}
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = "300";
			message = "系统错误";
		}
		resMap.put("statusCode",statusCode);
		resMap.put("message",message);
		return resMap;
	}


	/**
	 * 发送短信
	 * @param user
	 * @param messageSign 短信签名
	 * @param messageContent 短信内容
	 * @param mobile 手机号码
	 * @param sendTime 定时发送时间
	 * @return
	 */
	@RequestMapping(value = "send-message", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> sendMessage(@ModelAttribute("user_session") GxSysUser user, String messageSign, String messageContent, String mobile, String sendTime) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "发送成功";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());
		String content = messageSign+messageContent;
		String url = "http://47.96.185.189:8088/v2sms.aspx";
		try {
			String signStr = "nanjinglhcz"+"nanjinglhcz"+timestamp;
			String sign = WXPayUtil.MD5Lower(signStr);

//			Map<String, String> param = new HashMap<>();
//			param.put("userid", "273");//企业ID,273
//			param.put("timestamp", timestamp);//时间戳，系统当前时间字符串，年月日时分秒
//			param.put("sign", sign);//签名，使用 账号+密码+时间戳 生成MD5字符串作为签名。MD5生成32位，且需要小写
//			param.put("mobile", mobile);//全部被叫号码，多个号码之间用半角逗号隔开
//			param.put("content", content);//发送内容，内容需要UTF-8编码
//			param.put("sendTime", sendTime);//定时发送时间，为空表示立即发送，定时发送格式2010-10-24 09:08:10
//			param.put("action", "send");//发送任务命令，固定为：send
//			param.put("extno", "");//扩展子号，请先询问配置的通道是否支持扩展子号，如果不支持，请填空。子号只能为数字，且最多6位数。
//			String paramStr = JSON.toJSONString(param);
//			String url = "http://47.96.185.189:8088/v2sms.aspx?action=send&userid=273&timestamp="+timestamp+"&sign="+sign+"&mobile="+mobile+"&content="+content+"&sendTime="+sendTime+"&extno=";
//			String response = HttpClient.sendHttpRequest(url, paramStr,"POST", "application/xml;charset=utf-8");

			//2019-11-05修改
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			NameValuePair pair1 = new BasicNameValuePair("userid", "273");
			NameValuePair pair2 = new BasicNameValuePair("timestamp", timestamp);
			NameValuePair pair3 = new BasicNameValuePair("sign", sign);
			NameValuePair pair4 = new BasicNameValuePair("mobile", mobile);
			NameValuePair pair5 = new BasicNameValuePair("content", content);
			NameValuePair pair6 = new BasicNameValuePair("sendTime", sendTime);
			NameValuePair pair7 = new BasicNameValuePair("action", "send");
			NameValuePair pair8 = new BasicNameValuePair("extno", "");
			pairs.add(pair1);
			pairs.add(pair2);
			pairs.add(pair3);
			pairs.add(pair4);
			pairs.add(pair5);
			pairs.add(pair6);
			pairs.add(pair7);
			pairs.add(pair8);
			String response = HttpClient.sendHttpRequestPost(url, pairs, "application/x-www-form-urlencoded");
			Map<String, String> responseMap = WXPayUtil.xmlToMap(response);
			//{message=ok, successCounts=1, returnstatus=Success, remainpoint=21499, taskID=26810}
			if(!responseMap.get("message").equals("ok")){
				statusCode = "300";
				message = responseMap.get("message");
			}
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = "300";
			message = "发送失败";
		}
		resMap.put("statusCode",statusCode);
		resMap.put("message",message);
		return resMap;
	}


	/**
	 * 到正式发短信页面
	 * @return
	 */
	@RequestMapping("to-group-message")
	public String toGroupMessage() {
		return "message/group-message";
	}

	/**
	 * 选择人才公寓住户
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("mobile-lookup1")
	public String mobileLookup1(@ModelAttribute Page page,
							 @RequestParam Map<String, Object> parameterMap, Model model) {
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = wxUserRoomManager.pagedQuery(page, propertyFilters);
		List<WxUserRoom> wxUserRoomList = (List<WxUserRoom>) page.getResult();
		page.setResult(wxUserRoomList);
		model.addAttribute("wxUserRoomList", wxUserRoomList);
		model.addAttribute("page", page);
		return "message/mobile-lookup1";
	}


	/**
	 * 一键添加人才公寓用户
	 * @return
	 */
	@RequestMapping(value = "addMobile1", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> addMobile1() {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		String mobile = "";
        String PHONE_NUMBER_REG = "^(1[3-9])\\d{9}$";
		try{
			List<WxUserRoom> allList = wxUserRoomManager.getAll();
			for (WxUserRoom wxUserRoom:allList) {
                boolean flag = wxUserRoom.getUserPhone().matches(PHONE_NUMBER_REG);
                if(flag == true){
                    if(mobile.equals("")){
                        mobile += wxUserRoom.getUserPhone();
                    }else{
                        if(!mobile.contains(wxUserRoom.getUserPhone())){
                            mobile = mobile + ","+wxUserRoom.getUserPhone();
                        }
                    }
                }
			}
		}catch (Exception e){
			e.printStackTrace();
			statusCode = "300";
			message = "操作失败";
		}
		resMap.put("statusCode",statusCode);
		resMap.put("message",message);
		resMap.put("mobile",mobile);
		return resMap;
	}


	/**
	 * 添加所有内部人员
	 * @return
	 */
	@RequestMapping(value = "addMobile3", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> addMobile3() {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		String mobile = "";
		String PHONE_NUMBER_REG = "^(1[3-9])\\d{9}$";
		try{
			List<InsideUser> allList = insideUserManager.getAll();
			for (InsideUser insideUser:allList) {
				boolean flag = insideUser.getMobilePhone().matches(PHONE_NUMBER_REG);
				if(flag == true){
					if(mobile.equals("")){
						mobile += insideUser.getMobilePhone();
					}else{
						if(!mobile.contains(insideUser.getMobilePhone())){
							mobile = mobile + ","+insideUser.getMobilePhone();
						}
					}
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			statusCode = "300";
			message = "操作失败";
		}
		resMap.put("statusCode",statusCode);
		resMap.put("message",message);
		resMap.put("mobile",mobile);
		return resMap;
	}


    /**
     * 选择一卡通用户
     * @param page
     * @param parameterMap
     * @param model
     * @return
     */
    @RequestMapping("mobile-lookup2")
    public String mobileLookup2(@ModelAttribute Page page,
                                @RequestParam Map<String, Object> parameterMap, Model model) {
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page = oneCardSolutionManager.pagedQuery(page, propertyFilters);
        List<OneCardSolution> oneCardSolutionList = (List<OneCardSolution>) page.getResult();
        page.setResult(oneCardSolutionList);
        model.addAttribute("oneCardSolutionList", oneCardSolutionList);
        model.addAttribute("page", page);
        return "message/mobile-lookup2";
    }

    /**
     * 一键添加一卡通用户
     * @return
     */
    @RequestMapping(value = "addMobile2", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addMobile2() {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        String mobile = "";
        String PHONE_NUMBER_REG = "^(1[3-9])\\d{9}$";
        try{
            List<OneCardSolution> allList = oneCardSolutionManager.getAll();
            for (OneCardSolution oneCardSolution:allList) {
                boolean flag = oneCardSolution.getUserPhone().matches(PHONE_NUMBER_REG);
                if(flag == true){
                    if(mobile.equals("")){
                        mobile += oneCardSolution.getUserPhone();
                    }else{
                        if(!mobile.contains(oneCardSolution.getUserPhone())){
                            mobile += ","+oneCardSolution.getUserPhone();
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            statusCode = "300";
            message = "操作失败";
        }
        resMap.put("statusCode",statusCode);
        resMap.put("message",message);
        resMap.put("mobile",mobile);
        return resMap;
    }

	public void sendMessage() {
		String messageSign ="【江北新区研创园】";
		String messageContent = "金秋十月，普天同庆。热烈庆祝中华人民共和国成立70周年。江北新区研创园温馨提示：国庆长假，请园区企事业单位检查水电，关好门窗。祝您假期愉快，出行平安！";
		String mobile_all = "";
		String sendTime = "";
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "发送成功";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());
		String content = messageSign+messageContent;
		List<OneCardSolution> allList = oneCardSolutionManager.getAll();
		String PHONE_NUMBER_REG = "^(1[3-9])\\d{9}$";
		try {
			int n = 0;
			String mobile = "";
			for (OneCardSolution oneCardSolution:allList) {
				boolean flag = oneCardSolution.getUserPhone().matches(PHONE_NUMBER_REG);
				if(flag == true){
					if(!mobile_all.contains(oneCardSolution.getUserPhone())){
						n++;
						if(mobile.equals("")){
							mobile += oneCardSolution.getUserPhone();
						}else{
							mobile += ","+oneCardSolution.getUserPhone();
						}
					}
					if(mobile_all.equals("")){
						mobile_all += oneCardSolution.getUserPhone();
					}else{
						mobile_all += ","+oneCardSolution.getUserPhone();
					}
					if(n==100 || (allList.size() - 1 == allList.indexOf(oneCardSolution))){
						Map<String, String> param = new HashMap<>();
						param.put("userid", "273");//企业ID,273
						param.put("timestamp", timestamp);//时间戳，系统当前时间字符串，年月日时分秒
						String signStr = "nanjinglhcz"+"nanjinglhcz"+timestamp;
						String sign = WXPayUtil.MD5Lower(signStr);
						param.put("sign", sign);//签名，使用 账号+密码+时间戳 生成MD5字符串作为签名。MD5生成32位，且需要小写
						param.put("mobile", mobile);//全部被叫号码，多个号码之间用半角逗号隔开
						param.put("content", content);//发送内容，内容需要UTF-8编码
						param.put("sendTime", sendTime);//定时发送时间，为空表示立即发送，定时发送格式2010-10-24 09:08:10
						param.put("action", "send");//发送任务命令，固定为：send
						param.put("extno", "");//扩展子号，请先询问配置的通道是否支持扩展子号，如果不支持，请填空。子号只能为数字，且最多6位数。
						String paramStr = JSON.toJSONString(param);
						String url = "http://47.96.185.189:8088/v2sms.aspx?action=send&userid=273&timestamp="+timestamp+"&sign="+sign+"&mobile="+mobile+"&content="+content+"&sendTime="+sendTime+"&extno=";
						String response = HttpClient.sendHttpRequest(url, paramStr,"POST", "application/xml;charset=utf-8");
						Map<String, String> responseMap = WXPayUtil.xmlToMap(response);
						System.out.println(responseMap);
						if(responseMap.get("message").equals("ok")){
							n = 0;
							mobile = "";
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = "300";
			message = "发送失败";
		}
		resMap.put("statusCode",statusCode);
		resMap.put("message",message);
	}

}
