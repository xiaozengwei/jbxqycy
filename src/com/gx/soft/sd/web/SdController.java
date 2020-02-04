package com.gx.soft.sd.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.spring.TimeStampPropertyEditor;
import com.gx.core.util.Md5Utils;
import com.gx.soft.common.util.DoubleUtil;
import com.gx.soft.common.util.HttpClient;
import com.gx.soft.common.wxpay.WXPay;
import com.gx.soft.common.wxpay.WXPayConfig;
import com.gx.soft.common.wxpay.WXPayConfigImpl;
import com.gx.soft.common.wxpay.WXPayUtil;
import com.gx.soft.mobile.persistence.domain.WxRefundResult;
import com.gx.soft.mobile.persistence.manager.WxRefundResultManager;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.sd.persistence.domain.*;
import com.gx.soft.sd.persistence.manager.*;
import com.gx.soft.sd.persistence.model.QueryModel;
import com.gx.soft.sys.persistence.domain.GxSysDicRecord;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.manager.GxRecordManager;
import com.gx.soft.sys.persistence.manager.GxSysOrgManager;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.ykt.persistence.manager.OneCardInfoManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.net.ntp.TimeStamp;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("sd")
@SessionAttributes("user_session")
public class SdController {
	static Logger logger = Logger.getLogger(SdController.class);
	@Autowired
	private GxSysOrgManager gxSysOrgManager;
	@Autowired
	private VUserManager vUserManager;
	@Autowired
	private GxRecordManager gxRecordManager;

	@Autowired
	private OneCardInfoManager oneCardInfoManager;
	@Autowired
	private ElectricDataRecordManager electricDataRecordManager;

	@Autowired
	private ElectricDayRecordManager electricDayRecordManager;
	@Autowired
	private ElectricDeviceInfoManager electricDeviceInfoManager;
	@Autowired
	private UserDeviceRelationManager userDeviceRelationManager;
	@Autowired
	private VUserDeviceManager vUserDeviceManager;
	@Autowired
	private WaterDataRecordManager waterDataRecordManager;
	@Autowired
	private WaterDeviceInfoManager waterDeviceInfoManager;

	@Autowired
	private ElectricHistoryRecordManager electricHistoryRecordManager;

	@Autowired
	private SdRechargeRecordManager sdRechargeRecordManager;

	@Autowired
	private SdRechargeFailRecordManager sdRechargeFailRecordManager;

	@Autowired
	private WxUserRoomManager wxUserRoomManager;

	@Autowired
	private FloorRoomInDeviceManager floorRoomInDeviceManager;


	@Autowired
	private SdMonthBillManager sdMonthBillManager;

	@Autowired
	private SdRefundRecordManager sdRefundRecordManager;

	@Autowired
	private WaterAccountManager waterAccountManager;

	@Autowired
	private WaterMonthRecordManager waterMonthRecordManager;

	@Autowired
	private WaterNowRecordManager waterNowRecordManager;

	@Autowired
	private CheckOutRoomManager checkOutRoomManager;

	@Autowired
	private WaterMonthBillManager waterMonthBillManager;

	@Autowired
	private WaterFloorRoomInDeviceManager waterFloorRoomInDeviceManager;

	@Autowired
	private WxRefundResultManager wxRefundResultManager;

	@Autowired
	private SendMessageRecordManager sendMessageRecordManager;

	private BeanMapper beanMapper = new BeanMapper();
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
							  ServletRequestDataBinder binder) throws Exception {
		// TODO Auto-generated method stub
		binder.registerCustomEditor(Timestamp.class,
				new TimeStampPropertyEditor());
	}

	/**
	 * 水电综合查询
	 * @param page
	 * @param orderField
	 * @param orderDirection
	 * @param user
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("sd-query-list")
	public String yktProgressList(Page page,
								  @RequestParam(required = false, defaultValue = "createTime") String orderField,
								  @RequestParam(required = false, defaultValue = "asc") String orderDirection,
								  @ModelAttribute("user_session") GxSysUser user,
								  @RequestParam Map<String, Object> parameterMap, Model model){
		String startTime = parameterMap.get("startTime") == null ? "" : (String) parameterMap.get("startTime");
		String endTime = parameterMap.get("endTime") == null ? "" : (String) parameterMap.get("endTime");
		//设置排序字段
		page.setOrderBy(orderField);
		page.setOrder(orderDirection);
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = vUserDeviceManager.pagedQuery(page,propertyFilters);
		List<VUserDevice> list = (List<VUserDevice>) page.getResult();
		Map<String, Object> parameterMap1 = new HashMap<>();
		if(startTime.length()>0 && endTime.length()>0){
			parameterMap1.put("filter_GED_startTime",startTime);
			parameterMap1.put("filter_LED_endTime",endTime);
		}
		List<QueryModel> modelList = new ArrayList<>();
		for(VUserDevice vUserDevice : list){
			QueryModel queryModel = new QueryModel();
			queryModel.setCardNumber(vUserDevice.getCardNumber());
			queryModel.setUserIdCard(vUserDevice.getUserIdCard());
			queryModel.setCardHolder(vUserDevice.getCardHolder());
			queryModel.setBuildNum(vUserDevice.getBuildNum());
			queryModel.setRoomNum(vUserDevice.getRoomNum());
			queryModel.setWaterDeviceId(vUserDevice.getWaterDeviceId());
			queryModel.setElectricDeviceId(vUserDevice.getElectricDeviceId());
			//得到时间段用水量
			parameterMap1.put("filter_EQS_deviceId",vUserDevice.getWaterDeviceId());
			List<PropertyFilter> propertyFilters1 = PropertyFilter.buildFromMap(parameterMap1);
			List<WaterDataRecord> waterList = waterDataRecordManager.find("sendTime", true, propertyFilters1);
			double waterData = waterList.get(waterList.size() - 1).getCurrentNumber() - waterList.get(0).getCurrentNumber();
			double waterMoney = waterData * 0.55;
			//得到时间段用电量
//			parameterMap1.put("filter_EQS_deviceId",vUserDevice.getElectricDeviceId());
//			List<PropertyFilter> propertyFilters2 = PropertyFilter.buildFromMap(parameterMap1);
//			List<ElectricHistoryRecord> electricList = electricHistoryRecordManager.find("timeRecord", true, propertyFilters2);
//			double electricData = electricList.get(electricList.size() - 1).getTotalEnergy() - electricList.get(0).getTotalEnergy();
//			double electricMoney = electricData * 0.55;
//			queryModel.setWaterNumber(waterData);
//			queryModel.setWaterMoney(waterMoney);
//			queryModel.setElectricNumber(electricData);
//			queryModel.setElectricMoney(electricMoney);
//			queryModel.setStartTime(waterList.get(0).getSendTime());
//			queryModel.setEndTime(waterList.get(waterList.size() - 1).getSendTime());
			modelList.add(queryModel);
		}
		page.setResult(modelList);
		model.addAttribute("modelList", modelList);
		model.addAttribute("page", page);

		return "sd/sd-query-list";
	}

	/**
	 * 水电消耗统计
	 */

	@RequestMapping("sd-use-count")
	public String sdUseCount(Page page,
								  @RequestParam(required = false, defaultValue = "createTime") String orderField,
								  @RequestParam(required = false, defaultValue = "asc") String orderDirection,
								  @ModelAttribute("user_session") GxSysUser user,
								  @RequestParam Map<String, Object> parameterMap, Model model){
		String startTime = parameterMap.get("startTime") == null ? "" : (String) parameterMap.get("startTime");
		String endTime = parameterMap.get("endTime") == null ? "" : (String) parameterMap.get("endTime");
		//设置排序字段
		page.setOrderBy(orderField);
		page.setOrder(orderDirection);
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = sdMonthBillManager.pagedQuery(page,propertyFilters);
		List<SdMonthBill> list = (List<SdMonthBill>) page.getResult();
		Map<String, Object> parameterMap1 = new HashMap<>();
		if(startTime.length()>0 && endTime.length()>0){
			parameterMap1.put("filter_GED_startTime",startTime);
			parameterMap1.put("filter_LED_endTime",endTime);
		}
		List<QueryModel> modelList = new ArrayList<>();
		for(SdMonthBill sdMonthBill : list){
			//得到时间段用水量
//			parameterMap1.put("filter_EQS_deviceId",vUserDevice.getWaterDeviceId());
			List<PropertyFilter> propertyFilters1 = PropertyFilter.buildFromMap(parameterMap1);
			List<WaterDataRecord> waterList = waterDataRecordManager.find("sendTime", true, propertyFilters1);
			double waterData = waterList.get(waterList.size() - 1).getCurrentNumber() - waterList.get(0).getCurrentNumber();
			double waterMoney = waterData * 0.55;
			//得到时间段用电量
//			parameterMap1.put("filter_EQS_deviceId",vUserDevice.getElectricDeviceId());
			List<PropertyFilter> propertyFilters2 = PropertyFilter.buildFromMap(parameterMap1);
			List<ElectricDataRecord> electricList = electricDataRecordManager.find("sendTime", true, propertyFilters2);
			double electricData = electricList.get(electricList.size() - 1).getCurrentNumber() - electricList.get(0).getCurrentNumber();
			double electricMoney = electricData * 0.55;
		}
		page.setResult(modelList);
		model.addAttribute("modelList", modelList);
		model.addAttribute("page", page);

		return "sd/sd-use-count";
	}


	/**
	 * 水电充值记录
	 * @param page
	 * @param orderField
	 * @param orderDirection
	 * @param user
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("sd-recharge-list")
	public String sdRechargeList(Page page,
								  @RequestParam(required = false, defaultValue = "rechargeTime") String orderField,
								  @RequestParam(required = false, defaultValue = "desc") String orderDirection,
								  @ModelAttribute("user_session") GxSysUser user,
								  @RequestParam Map<String, Object> parameterMap, Model model){
		//设置排序字段
		page.setOrderBy(orderField);
		page.setOrder(orderDirection);
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = sdRechargeRecordManager.pagedQuery(page,propertyFilters);
		List<SdRechargeRecord> sdList = (List<SdRechargeRecord>) page.getResult();
		model.addAttribute("sdList", sdList);
		model.addAttribute("page", page);
		return "sd/sd-recharge-list";
	}

	@RequestMapping(value = "export-excel")
	public @ResponseBody
	Map<String, Object> exportExcel(
			@RequestParam(required = false, defaultValue = "rechargeTime") String orderField,
			@RequestParam(required = false, defaultValue = "desc") String orderDirection,
			@RequestParam Map<String, Object> parameterMap,
			HttpServletResponse response) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		// decode解码
		String filter_GED_rechargeTime = (String) parameterMap.get("filter_GED_rechargeTime");
		String filter_LED_rechargeTime = (String) parameterMap.get("filter_LED_rechargeTime");
		try {
			filter_GED_rechargeTime = URLDecoder.decode(filter_GED_rechargeTime, "UTF-8");
			parameterMap.put("filter_GED_rechargeTime", filter_GED_rechargeTime);
			filter_LED_rechargeTime = URLDecoder.decode(filter_LED_rechargeTime, "UTF-8");
			parameterMap.put("filter_LED_rechargeTime", filter_LED_rechargeTime);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}


		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		boolean flag = true;
		if(orderDirection.equals("desc")){
			flag = false;
		}
		List<SdRechargeRecord> sdRechargeRecordList = sdRechargeRecordManager.find(orderField, flag, propertyFilters);
		// 文件名
		String fileName = "水电充值记录表.xls";
		// 列名数组
		String[] headers = { "房间号", "姓名", "身份证号", "手机号", "充值金额", "商户订单号", "充值类型", "支付类型", "充值时间","备注"};
		// 数据集合
		List<Map> list = new ArrayList<Map>();
		for (SdRechargeRecord sdRechargeRecord : sdRechargeRecordList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("房间号", sdRechargeRecord.getRoomId() == null ? "":sdRechargeRecord.getRoomId());
			map.put("姓名", sdRechargeRecord.getUserName() == null ? "":sdRechargeRecord.getUserName());
			map.put("身份证号", sdRechargeRecord.getUserIdCard() == null ? "":sdRechargeRecord.getUserIdCard());
			map.put("手机号", sdRechargeRecord.getUserPhone() == null ? "":sdRechargeRecord.getUserPhone());
			map.put("充值金额", sdRechargeRecord.getRechargeMoney() == null ? "":sdRechargeRecord.getRechargeMoney());
			map.put("商户订单号", sdRechargeRecord.getOutTradeNo() == null ? "":sdRechargeRecord.getOutTradeNo());
			String rechargeType = sdRechargeRecord.getRechargeType() == null ? "":sdRechargeRecord.getRechargeType();
			if(rechargeType.equals("1")){
				rechargeType = "水费充值";
			}else if(rechargeType.equals("2")){
				rechargeType = "电费充值";
			}
			map.put("充值类型",rechargeType);
			map.put("支付类型", sdRechargeRecord.getPayType() == null ? "":sdRechargeRecord.getPayType());
			map.put("充值时间", sdRechargeRecord.getRechargeTime() == null ? "":sdf.format(sdRechargeRecord.getRechargeTime()));
			map.put("备注", sdRechargeRecord.getDataType() == null ? "":sdRechargeRecord.getDataType());
			list.add(map);
		}
		// 创建excel，填充数据
		int index = 0;
		try {
			Workbook workbook = new HSSFWorkbook();
			Sheet sheet = workbook.createSheet();
			sheet.setDefaultColumnWidth((short) 15);
			sheet.setDefaultRowHeight((short) (2 * 256));// 高度两个字符
			sheet.setHorizontallyCenter(true);// 水平居中
			sheet.setVerticallyCenter(true);// 垂直居中
			Row row = sheet.createRow(index++);
			for (short i = 0; i < headers.length; i++) {
				Cell cell = row.createCell(i);
				RichTextString text = new HSSFRichTextString(headers[i]);
				cell.setCellValue(text);
			}
			for (Map map : list) {
				row = sheet.createRow(index++);
				for (int i = 0; i < headers.length; i++) {
					row.createCell(i).setCellValue(
							map.get(headers[i]).toString());
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


	/**
	 * web端水费、电费充值
	 */
	@RequestMapping("to-sd-recharge")
	public String toSdCharge(String rechargeType, Model model) {
		model.addAttribute("rechargeType", rechargeType);
		return "sd/sd-recharge";
	}

	/**
	 * 水电充值
	 * @param user
	 * @param sdRechargeRecord
	 * @return
	 */
	@RequestMapping(value = "sd-recharge", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> sdRecharge(@ModelAttribute("user_session") GxSysUser user, SdRechargeRecord sdRechargeRecord) {
		Timestamp ts = DateUtil.getDate();
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Boolean closeCurrent = true;
		Boolean reload = true;
		try{
			String deviceId;
			if(sdRechargeRecord.getRechargeType().equals("1")){//水费充值
				WaterAccount waterAccount=waterAccountManager.findUniqueBy("roomName",sdRechargeRecord.getRoomId());
				waterAccount.setBalance(waterAccount.getBalance()+sdRechargeRecord.getRechargeMoney());
				waterAccount.setLastRechargeMoney(sdRechargeRecord.getRechargeMoney());
				waterAccount.setLastRechargeTime(new Timestamp(new Date().getTime()));
				waterAccount.setTotalMoney(waterAccount.getTotalMoney()==null?sdRechargeRecord.getRechargeMoney():waterAccount.getTotalMoney()+sdRechargeRecord.getRechargeMoney());
				waterAccountManager.save(waterAccount);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String out_trade_no = sdf.format(new Date()) + "-" + RandomStringUtils.randomAlphanumeric(10);
				sdRechargeRecord.setOutTradeNo(out_trade_no);
				sdRechargeRecord.setRechargeTime(ts);
				sdRechargeRecordManager.save(sdRechargeRecord);
			}else{//电费充值
				FloorRoomInDevice roomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", sdRechargeRecord.getRoomId());
				deviceId = roomInDevice.getDeviceId();
				//调用接口充值
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				NameValuePair pair1 = new BasicNameValuePair("deviceId",deviceId);
				NameValuePair pair2 = new BasicNameValuePair("money",String.format("%.2f", sdRechargeRecord.getRechargeMoney()));
				NameValuePair pair3 = new BasicNameValuePair("actionType","0");
				NameValuePair pair4 = new BasicNameValuePair("ipAddress","192.168.50.23");
				NameValuePair pair5 = new BasicNameValuePair("secret", Md5Utils.getMd5UpperCase(deviceId+String.format("%.2f", sdRechargeRecord.getRechargeMoney())+"tiansu"));
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
					//根据当前系统时间加随机序列来生成订单号
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					String out_trade_no = sdf.format(new Date()) + "-" + RandomStringUtils.randomAlphanumeric(10);
					sdRechargeRecord.setOutTradeNo(out_trade_no);
					sdRechargeRecord.setRechargeTime(ts);
					sdRechargeRecord.setDeviceId(deviceId);
					sdRechargeRecordManager.save(sdRechargeRecord);
				}else {
					statusCode = "300";
					message = "充值失败";
					closeCurrent = false;
					reload = false;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			statusCode = "300";
			message = "充值失败";
			closeCurrent = false;
			reload = false;
		}
		resMap.put("statusCode",statusCode);
		resMap.put("message",message);
		resMap.put("closeCurrent",closeCurrent);
		resMap.put("reload", reload);
		return resMap;
	}

	/**
	 * 到退款页面
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("to-sd-refund")
	public String toSdRefund(String rowId, Model model) {
		SdRechargeRecord sdRechargeRecord = sdRechargeRecordManager.get(rowId);
		model.addAttribute("sdRechargeRecord", sdRechargeRecord);
		FloorRoomInDevice roomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", sdRechargeRecord.getRoomId());
		String deviceId = roomInDevice.getDeviceId();
		String balance = "";
		try {
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			NameValuePair pair3 = new BasicNameValuePair("deviceId",deviceId);
			pairs.add(pair3);
			String result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getEnergyInfoForRealTime",pairs,"application/x-www-form-urlencoded");
			JSONObject jsonObject=JSON.parseObject(result);
			Object code = jsonObject.get("errcode");
			if(code.toString().equals("0")) {
				if (!jsonObject.get("data").toString().equals("null")) {
					JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
					JSONArray jsonArray = (JSONArray) jsonObject1.get("datas");
					JSONObject js = (JSONObject) jsonArray.get(0);
//					String deviceId = js.get("deviceId") != null ? js.getString("deviceId").toString() : "";
//					String totalEnergy = js.get("totalEnergy") != null ? js.getString("totalEnergy").toString() : "";
//					String tipEnergy = js.get("tipEnergy") != null ? js.getString("tipEnergy").toString() : "";
//					String peakEnergy = js.get("peakEnergy") != null ? js.getString("peakEnergy").toString() : "";
//					String valleyEnergy = js.get("valleyEnergy") != null ? js.getString("valleyEnergy").toString() : "";
//					String flatEnergy = js.get("flatEnergy") != null ? js.getString("flatEnergy").toString() : "";
//					String timeRecord = jsonObject1.get("actionTime") != null ? jsonObject1.getString("actionTime").toString() : "";
//					java.sql.Date date = new java.sql.Date(new Date().getTime());
					balance = js.get("balance") != null ? js.getString("balance").toString() : "";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("balance",balance);
		return "sd/sd-refund";
	}


	/**
	 * 水电退费
	 * @param user
	 * @param rowId
	 * @return
	 */
	@RequestMapping(value = "sd-refund", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> sdRefund(@ModelAttribute("user_session") GxSysUser user, String rowId,String refundDesc,Double refundMoney) {
		Timestamp ts = DateUtil.getDate();
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "退款成功";
		Boolean closeCurrent = true;
		Boolean reload = true;
		SdRechargeRecord sdRechargeRecord = sdRechargeRecordManager.get(rowId);
		try{
			String deviceId = "";
			if(sdRechargeRecord.getRechargeType().equals("1")){//水费退款
				WaterAccount waterAccount=waterAccountManager.findUniqueBy("roomName",sdRechargeRecord.getRoomId());
				waterAccount.setBalance(waterAccount.getBalance()-sdRechargeRecord.getRechargeMoney());
				waterAccount.setTotalMoney(waterAccount.getTotalMoney()-sdRechargeRecord.getRechargeMoney());
				waterAccountManager.save(waterAccount);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String out_refund_no = sdf.format(new Date()) + "-" + RandomStringUtils.randomAlphanumeric(10);
				sdRechargeRecord.setDataStatus("已退款");
				sdRechargeRecordManager.save(sdRechargeRecord);
				//保存退款记录表
				SdRefundRecord sdRefundRecord = new SdRefundRecord();
				sdRefundRecord.setOutTradeNo(sdRechargeRecord.getOutTradeNo());
				sdRefundRecord.setRoomId(sdRechargeRecord.getRoomId());
				sdRefundRecord.setDeviceId(deviceId);
				sdRefundRecord.setRefundType(sdRechargeRecord.getRechargeType());
				sdRefundRecord.setRefundMoney(refundMoney);
				sdRefundRecord.setRefundTime(ts);
				sdRefundRecord.setPayType("现金支付");
				sdRefundRecord.setOutRefundNo(out_refund_no);
				sdRefundRecord.setRefundUserId(sdRechargeRecord.getOpenId());
				sdRefundRecord.setRefundUserName(sdRechargeRecord.getUserName());
				sdRefundRecord.setOperateUserId(user.getUserId());
				sdRefundRecord.setOperateUserName(user.getUserName());
				sdRefundRecord.setRefundDesc(refundDesc);
				sdRefundRecordManager.save(sdRefundRecord);
			}else{//电费退款
				FloorRoomInDevice roomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", sdRechargeRecord.getRoomId());
				deviceId = roomInDevice.getDeviceId();
				//2019-10-16修改
				String success = refund(deviceId, sdRechargeRecord.getRechargeMoney());
				if(success.equals("true")) {
					//根据当前系统时间加随机序列来生成退款订单号
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					String out_refund_no = sdf.format(new Date()) + "-" + RandomStringUtils.randomAlphanumeric(10);
					sdRechargeRecord.setDataStatus("已退款");
					sdRechargeRecordManager.save(sdRechargeRecord);
					//保存退款记录表
					SdRefundRecord sdRefundRecord = new SdRefundRecord();
					sdRefundRecord.setOutTradeNo(sdRechargeRecord.getOutTradeNo());
					sdRefundRecord.setRoomId(sdRechargeRecord.getRoomId());
					sdRefundRecord.setDeviceId(deviceId);
					sdRefundRecord.setRefundType(sdRechargeRecord.getRechargeType());
					sdRefundRecord.setRefundMoney(refundMoney);
					sdRefundRecord.setRefundTime(ts);
					sdRefundRecord.setPayType("现金支付");
					sdRefundRecord.setOutRefundNo(out_refund_no);
					sdRefundRecord.setRefundUserId(sdRechargeRecord.getOpenId());
					sdRefundRecord.setRefundUserName(sdRechargeRecord.getUserName());
					sdRefundRecord.setOperateUserId(user.getUserId());
					sdRefundRecord.setOperateUserName(user.getUserName());
					sdRefundRecord.setRefundDesc(refundDesc);
					sdRefundRecordManager.save(sdRefundRecord);
				}else {
					statusCode = "300";
					message = "退款失败";
					closeCurrent = false;
					reload = false;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			reload = false;
			closeCurrent = false;
			statusCode = "300";
			message = "退款失败";
		}
		resMap.put("statusCode",statusCode);
		resMap.put("message",message);
		resMap.put("closeCurrent",closeCurrent);
		resMap.put("reload", reload);
		return resMap;
	}

	/**
	 * 房间绑定管理
	 * @param page
	 * @param orderField
	 * @param orderDirection
	 * @param user
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("room-bind-list")
	public String roomBindList(Page page,
								 @RequestParam(required = false, defaultValue = "bindTime") String orderField,
								 @RequestParam(required = false, defaultValue = "asc") String orderDirection,
								 @ModelAttribute("user_session") GxSysUser user,
								 @RequestParam Map<String, Object> parameterMap, Model model){
		//设置排序字段
		page.setOrderBy(orderField);
		page.setOrder(orderDirection);
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = wxUserRoomManager.pagedQuery(page,propertyFilters);
		List<WxUserRoom> wxUserRoomList = (List<WxUserRoom>) page.getResult();
		model.addAttribute("wxUserRoomList", wxUserRoomList);
		model.addAttribute("page", page);
		return "sd/room-bind-list";
	}

	/**
	 * 到房间绑定添加、修改页面
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("to-user-room-input")
	public String input(
			@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		WxUserRoom wxUserRoom = null;
		if (rowId != null) {
			wxUserRoom = wxUserRoomManager.get(rowId);
		} else {
			wxUserRoom = new WxUserRoom();
		}
		model.addAttribute("model", wxUserRoom);
		return "sd/user-room-input";
	}

	/**
	 * 房间绑定保存
	 * @param user
	 * @param wxUserRoom
	 * @return
	 */
	@RequestMapping(value = "room-bind-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> roomBindSave(@ModelAttribute("user_session") GxSysUser user, WxUserRoom wxUserRoom) {
		Timestamp ts = DateUtil.getDate();
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Boolean closeCurrent = true;
		Boolean reload = true;
		try{
			String rowId = wxUserRoom.getRowId();
			WxUserRoom dest = null;
			if(rowId != null && rowId.length()>0){
				dest = wxUserRoomManager.get(rowId);
				beanMapper.copy(wxUserRoom, dest);
			}else{
				dest = wxUserRoom;
				dest.setRowId(null);
				dest.setBindTime(ts);
			}
			wxUserRoomManager.save(dest);
		}catch(Exception e){
			e.printStackTrace();
			statusCode = "300";
			message = "操作失败";
			closeCurrent = false;
			reload = false;
		}
		resMap.put("statusCode",statusCode);
		resMap.put("message",message);
		resMap.put("closeCurrent",closeCurrent);
		resMap.put("reload",reload);
		return resMap;
	}


	/**
	 * 房间解除绑定
	 * @param rowId
	 * @return
	 */
	@RequestMapping("room-unbind")
	public @ResponseBody
	Map<String, Object> roomUnbind(String rowId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		boolean reload = true;
		try {
			if (rowId != null && rowId.length() > 0) {
				WxUserRoom wxUserRoom = wxUserRoomManager.get(rowId);
				wxUserRoomManager.remove(wxUserRoom);
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			reload = false;
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("reload", reload);
		return resMap;
	}

	/**
	 * 水电充值失败列表
	 * @param page
	 * @param orderField
	 * @param orderDirection
	 * @param user
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("sd-recharge-fail-list")
	public String sdRechargeFailList(Page page,
								 @RequestParam(required = false, defaultValue = "rechargeTime") String orderField,
								 @RequestParam(required = false, defaultValue = "desc") String orderDirection,
								 @ModelAttribute("user_session") GxSysUser user,
								 @RequestParam Map<String, Object> parameterMap, Model model){
		//设置排序字段
		page.setOrderBy(orderField);
		page.setOrder(orderDirection);
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = sdRechargeFailRecordManager.pagedQuery(page,propertyFilters);
		List<SdRechargeFailRecord> sdList = (List<SdRechargeFailRecord>) page.getResult();
		model.addAttribute("sdList", sdList);
		model.addAttribute("page", page);
		return "sd/sd-recharge-fail-list";
	}


	/**
	 * 到退房页面
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("check-out")
	public String checkOut(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String alertMessage = "";
		WxUserRoom wxUserRoom = wxUserRoomManager.get(rowId);
		String roomId = wxUserRoom.getRoomId();
		//根据房间号得到电费余额
		FloorRoomInDevice roomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", roomId);
		String deviceId = roomInDevice.getDeviceId();
		String electricBalance = "";
		List<NameValuePair> pairs = new ArrayList<>();
		NameValuePair pair = new BasicNameValuePair("deviceId", deviceId);
		pairs.add(pair);
		try {
			String result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getEnergyInfoForRealTime", pairs, "application/x-www-form-urlencoded");
			JSONObject jsonObject = JSON.parseObject(result);
			Object code = jsonObject.get("errcode");
			if (code.toString().equals("0")) {
				if (!jsonObject.get("data").toString().equals("null")) {
					JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
					JSONArray jsonArray = (JSONArray) jsonObject1.get("datas");
					if (jsonArray.size() != 0) {
						JSONObject js = (JSONObject) jsonArray.get(0);
						electricBalance = js.get("balance") != null ? js.getString("balance") : "";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//查询水费余额
		WaterAccount waterAccount = waterAccountManager.findUniqueBy("roomName", roomId);
		Double waterBalance = waterAccount.getBalance();
		//得到水表最新抄表记录
		int waterMeterNum = 1;
		Double waterNumber1 = 0.00;
		Double waterNumber2 = null;
		Date cbTime = new Date();
		List<WaterFloorRoomInDevice> waterFloorRoomInDevices = waterFloorRoomInDeviceManager.findBy("roomName", roomId);
		//查询房间几个水表
		if(waterFloorRoomInDevices != null && waterFloorRoomInDevices.size() >0){
			waterMeterNum = waterFloorRoomInDevices.size();
			String status1 = waterFloorRoomInDevices.get(0).getStatus() == null ? "":waterFloorRoomInDevices.get(0).getStatus();
			if(status1.equals("0")){
				//水表有问题，请手动抄表填写
			}else{
				WaterNowRecord waterNowRecord = waterNowRecordManager.findUniqueBy("deviceId", waterFloorRoomInDevices.get(0).getDeviceId());
				if(waterNowRecord != null){
					waterNumber1 = Double.valueOf(waterNowRecord.getTotalWater());
				}else{
					//水表数据没有同步过来，手动抄表
				}
			}
			//判断该房间存在两个水表
			if(waterFloorRoomInDevices.size() == 2){
				String status2 = waterFloorRoomInDevices.get(1).getStatus();
				if(status2.equals("0")){
					//水表有问题，请手动抄表填写
				}else{
					WaterNowRecord waterNowRecord = waterNowRecordManager.findUniqueBy("deviceId", waterFloorRoomInDevices.get(1).getDeviceId());
					if(waterNowRecord != null){
						waterNumber2 = Double.valueOf(waterNowRecord.getTotalWater());
					}else{
						//水表数据没有同步过来，手动抄表
					}
				}
			}
			//暂时不判断存在两个以上水表的情况
		}else{
			//房间没有绑定水表
			alertMessage = "房间没有水表，请手动抄表";
		}

		//得到上次水表数值
		Double lastWaterNumber1 = 0.00;
		Double lastWaterNumber2 = null;
		Date lastCbTime = null;
		//根据月账单查询上次抄表记录
		Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("filter_EQS_roomName",roomId);
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		List<WaterMonthBill> waterMonthBillList = waterMonthBillManager.find("localRecordTime", false, propertyFilters);
		if(waterMonthBillList != null && waterMonthBillList.size() > 0){
			WaterMonthBill waterMonthBill = waterMonthBillList.get(0);
            String timeSection = waterMonthBill.getTimeSection();
            String[] TimeArr = timeSection.split("/");
            String lastTime = TimeArr[1];
            System.out.println(lastTime);
            //查询从上次抄表以来有没有退房记录
            Map<String, Object> parameterMap1 = new HashMap<>();
			parameterMap1.put("filter_EQS_roomId",roomId);
            parameterMap1.put("filter_GED_createTime",lastTime);
            List<PropertyFilter> propertyFilters1 = PropertyFilter.buildFromMap(parameterMap1);
            List<CheckOutRoom> checkOutRoomList = checkOutRoomManager.find("createTime", false, propertyFilters1);
            if(checkOutRoomList != null && checkOutRoomList.size() > 0){
				lastWaterNumber1 = checkOutRoomList.get(0).getLastWaterNumberOne();
				lastWaterNumber2 = checkOutRoomList.get(0).getLastWaterNumberTwo();
				lastCbTime = checkOutRoomList.get(0).getCbTime();
            }else{
				lastWaterNumber1 = waterMonthBill.getWaterCurrentUse();
				if(waterMonthBillList.size() == 2){
					lastWaterNumber2 = waterMonthBillList.get(1).getWaterCurrentUse();
				}
				try {
					lastCbTime = sdf.parse(lastTime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
        }
		CheckOutRoom checkOutRoom = new CheckOutRoom();
		checkOutRoom.setRoomId(wxUserRoom.getRoomId());
		checkOutRoom.setUserName(wxUserRoom.getUserName());
		checkOutRoom.setUserIdCard(wxUserRoom.getUserIdCard());
		checkOutRoom.setUserPhone(wxUserRoom.getUserPhone());
		checkOutRoom.setElectricBalance(Double.valueOf(electricBalance));
		checkOutRoom.setWaterBalance(waterBalance);
		checkOutRoom.setLastWaterNumberOne(lastWaterNumber1);
		checkOutRoom.setLastWaterNumberTwo(lastWaterNumber2);
		checkOutRoom.setLastCbTime(lastCbTime);
		checkOutRoom.setWaterNumberOne(waterNumber1);
		checkOutRoom.setWaterNumberTwo(waterNumber2);
		checkOutRoom.setCbTime(cbTime);
		model.addAttribute("model", checkOutRoom);
		model.addAttribute("waterMeterNum", waterMeterNum);
		model.addAttribute("alertMessage",alertMessage);
		//得到水费单价
		GxSysDicRecord gxSysDicRecord1 = gxRecordManager.findUniqueBy("dicId", "water_dj_1");
		model.addAttribute("waterDj", gxSysDicRecord1.getDicName());
		return "sd/check-out";
	}

	/**
	 * 退房验证
	 * @return
	 */
	@RequestMapping("check-out-validate")
	public @ResponseBody
	Map<String, Object> checkOutValidate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		try {
			String time = sdf.format(new Date()) + " 00:00:00";
			Map<String, Object> parameterMap0 = new HashMap<>();
			parameterMap0.put("filter_GED_time",time);
			List<PropertyFilter> propertyFilters0 = PropertyFilter.buildFromMap(parameterMap0);
			List<WaterNowRecord> WaterNowRecordList = waterNowRecordManager.find(propertyFilters0);
			if(WaterNowRecordList == null || WaterNowRecordList.size() == 0){
				statusCode = "300";
				message = "暂时没有获取到今天的抄表记录，无法办理退房，请稍后再试";
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		return resMap;
	}


	/**
	 * 保存退房表
	 * @param checkOutRoom
	 * @param waterMeterNum
	 * @return
	 */
	@RequestMapping("check-out-save")
	public @ResponseBody
	Map<String, Object> checkOutSave(CheckOutRoom checkOutRoom, int waterMeterNum) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
		GxSysDicRecord gxSysDicRecord1 = gxRecordManager.findUniqueBy("dicId", "water_dj_1");
		String waterDj = gxSysDicRecord1.getDicName();
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Boolean closeCurrent = true;
		Boolean reload = true;
		String roomId = checkOutRoom.getRoomId();
		Timestamp ts = DateUtil.getDate();
		List<WaterFloorRoomInDevice> waterFloorRoomInDevices = waterFloorRoomInDeviceManager.findBy("roomName", roomId);
		try {
			//保存退房表
			checkOutRoom.setRowId(null);
			checkOutRoom.setCreateTime(ts);
			checkOutRoomManager.save(checkOutRoom);
			//保存水费月账单
			WaterMonthBill sdMonthBill = new WaterMonthBill();
			sdMonthBill.setRoomName(roomId);
			sdMonthBill.setDeviceId(waterFloorRoomInDevices.get(0).getDeviceId());
			sdMonthBill.setWaterHistoryUse(checkOutRoom.getLastWaterNumberOne());
			sdMonthBill.setWaterCurrentUse(checkOutRoom.getWaterNumberOne());
			Double waterUse = DoubleUtil.sub(String.valueOf(checkOutRoom.getWaterNumberOne()), String.valueOf(checkOutRoom.getLastWaterNumberOne()));
			sdMonthBill.setWaterMonthUse(waterUse);
			sdMonthBill.setWaterMonthMoney(DoubleUtil.mul1(String.valueOf(waterUse), waterDj));
			sdMonthBill.setWaterBalance(0.00);
			sdMonthBill.setWaterBeforeBalance(checkOutRoom.getWaterBalance());
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(new Date());
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
			int countFirst=waterMonthBillManager.findBy("time",simpleDateFormat.format(calendar.getTime())).size();
			String countFirstTime=simpleDateFormat.format(calendar.getTime());
			calendar.add(Calendar.MONTH, -1);
			int countSecond=waterMonthBillManager.findBy("time",simpleDateFormat.format(calendar.getTime())).size();
			String countSecondTime=simpleDateFormat.format(calendar.getTime());
			calendar.add(Calendar.MONTH, -1);
			int countThird=waterMonthBillManager.findBy("time",simpleDateFormat.format(calendar.getTime())).size();
			if(countThird>100&&countSecond>100&&countFirst<100){
				sdMonthBill.setTime(countFirstTime);
			}else {
				sdMonthBill.setTime(countSecondTime);
			}
//			sdMonthBill.setTime(sdf1.format(new Date()));
			sdMonthBill.setTimeSection(sdf.format(checkOutRoom.getLastCbTime())+"/"+sdf.format(checkOutRoom.getCbTime()));
			sdMonthBill.setLocalRecordTime(ts);
			sdMonthBillManager.save(sdMonthBill);
			//房间有两个水表
			if(waterMeterNum == 2){
				WaterMonthBill sdMonthBill1 = new WaterMonthBill();
				sdMonthBill1.setRoomName(roomId);
				sdMonthBill1.setDeviceId(waterFloorRoomInDevices.get(1).getDeviceId());
				sdMonthBill1.setWaterHistoryUse(checkOutRoom.getLastWaterNumberTwo());
				sdMonthBill1.setWaterCurrentUse(checkOutRoom.getWaterNumberTwo());
				Double waterUse1 = DoubleUtil.sub(String.valueOf(checkOutRoom.getWaterNumberTwo()), String.valueOf(checkOutRoom.getLastWaterNumberTwo()));
				sdMonthBill1.setWaterMonthUse(waterUse1);
				sdMonthBill1.setWaterMonthMoney(DoubleUtil.mul1(String.valueOf(waterUse1), waterDj));
				sdMonthBill1.setWaterBalance(0.00);
				sdMonthBill1.setWaterBeforeBalance(checkOutRoom.getWaterBalance());
				sdMonthBill1.setTime(sdf1.format(new Date()));
				sdMonthBill1.setTimeSection(sdf.format(checkOutRoom.getLastCbTime())+"/"+sdf.format(checkOutRoom.getCbTime()));
				sdMonthBill1.setLocalRecordTime(ts);
				sdMonthBillManager.save(sdMonthBill1);
			}
			//设置水表余额为0
			WaterAccount waterAccount = waterAccountManager.findUniqueBy("roomName", roomId);
			waterAccount.setBalance(0.00);
			waterAccount.setTotalMoney(null);
			waterAccount.setLastRechargeTime(null);
			waterAccount.setLastRechargeMoney(null);
			waterAccount.setRecentReduceMoney(null);
			waterAccount.setRecentReduceTime(null);
			waterAccountManager.save(waterAccount);
			//调用接口扣除剩余电费
			Double electricBalance = checkOutRoom.getElectricBalance();
			if(electricBalance > 0.1){
				FloorRoomInDevice floorRoomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", roomId);
				String success = refund(floorRoomInDevice.getDeviceId(), DoubleUtil.sub(String.valueOf(electricBalance), "0.1"));
				if(success.equals("true")){
					ElectricDayRecord electricDayRecord = electricDayRecordManager.get(floorRoomInDevice.getDeviceId());
					electricDayRecord.setBalance("0.00");
					electricDayRecordManager.save(electricDayRecord);
				}else{
					logger.info("----------退房----------调用接口扣费失败----------房间号："+roomId+"----------金额："+DoubleUtil.sub(String.valueOf(electricBalance), "0.1"));
				}
			}
			List<WxUserRoom> wxUserRoomList=wxUserRoomManager.findBy("roomId",checkOutRoom.getRoomId());
			if (wxUserRoomList.size()!=0){
				wxUserRoomManager.remove(wxUserRoomList.get(0));
			}
//			Double refundMoney = checkOutRoom.getRefundMoney();
//			//判断退款金额是否大于0
//			if(refundMoney > 0){
//				// 得到电费充值记录
//				String hql = "from SdRechargeRecord where roomId = ? order by rechargeTime desc";
//				Object[] values = {roomId};
//				List<SdRechargeRecord> sdRechargeRecordList = sdRechargeRecordManager.find(hql, values);
//				for (SdRechargeRecord sdRechargeRecord: sdRechargeRecordList) {
//					if(refundMoney > sdRechargeRecord.getRechargeMoney()){
//						//调用退款接口
//						sdRefund("退房",sdRechargeRecord.getRechargeMoney(), sdRechargeRecord.getRowId());
//						refundMoney = DoubleUtil.sub(String.valueOf(refundMoney), String.valueOf(sdRechargeRecord.getRechargeMoney()));
//					}else{
//						sdRefund("退房", refundMoney, sdRechargeRecord.getRowId());
//						break;
//					}
//				}
//			}
		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			closeCurrent = false;
			reload = false;
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", closeCurrent);
		resMap.put("reload", reload);
		return resMap;
	}


	/**
	 * 调用电费接口退款
	 * @param deviceId 设备ID
	 * @param money 金额
	 * @return
	 */
	public String refund(String deviceId, Double money){
		String success = "";
		try {
			//调用接口退款（actionType：1）
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			NameValuePair pair1 = new BasicNameValuePair("deviceId",deviceId);
			NameValuePair pair2 = new BasicNameValuePair("money",String.format("%.2f", money));
			NameValuePair pair3 = new BasicNameValuePair("actionType","1");
			NameValuePair pair4 = new BasicNameValuePair("ipAddress","192.168.50.23");
			NameValuePair pair5 = new BasicNameValuePair("secret", Md5Utils.getMd5UpperCase(deviceId+String.format("%.2f", money)+"tiansu"));
			pairs.add(pair1);
			pairs.add(pair2);
			pairs.add(pair3);
			pairs.add(pair4);
			pairs.add(pair5);
			String result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/rechargeDevices",pairs,"application/x-www-form-urlencoded;charset=utf-8");
			JSONObject jsonObject= JSON.parseObject(result);
			JSONObject data = (JSONObject) jsonObject.get("data");
			JSONArray jsonArray= data.getJSONArray("datas");
			success = ((JSONObject)jsonArray.get(0)).getString("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * 水电退款（微信支付）
	 * @param refundDesc 退款原因
	 * @param refundMoney 退款金额
	 * @param rowId 充值记录主键
	 * @return
	 */
	public Boolean sdRefund(String refundDesc, Double refundMoney, String rowId){
		Boolean success = true;
		Timestamp ts = DateUtil.getDate();
		//得到充值记录
		SdRechargeRecord sdRechargeRecord = sdRechargeRecordManager.get(rowId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String appid = "wxe4bcb04f38969b18";//公众账号ID
		String mch_id = "1404452802";//微信商户号
		String apiKey = "tN3Hi3VGsCX8ZY9ohsP6V51VLW9NI6Kn";//API秘钥
		//组装请求参数
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("appid",appid);//公众账号ID
		paraMap.put("mch_id",mch_id);//商户号
		paraMap.put("nonce_str",WXPayUtil.generateNonceStr());//随机字符串
		paraMap.put("out_trade_no",sdRechargeRecord.getOutTradeNo());//商户订单号
		//根据当前系统时间加随机序列来生成退款单号
		String out_refund_no = sdf.format(new Date()) + "-" + RandomStringUtils.randomAlphanumeric(10);
		paraMap.put("out_refund_no",out_refund_no);//商户退款单号
		paraMap.put("total_fee","2");//订单金额，单位为分
		paraMap.put("refund_fee","1");//退款金额，单位为分
		paraMap.put("refund_desc", refundDesc);//退款原因
		try {
			String sign = WXPayUtil.generateSignature(paraMap, apiKey);
			paraMap.put("sign",sign);
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
					wxRefundResult.setDataType(refundDesc);
					wxRefundResultManager.save(wxRefundResult);
				}else{
					logger.info("------------退款失败--------------result_code="+result_code);
				}
			}else{
				logger.info("------------退款失败--------------return_code="+return_code);
			}
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
			logger.info("----------微信退款失败----------金额----------"+refundMoney);
		}
		return success;
	}


	/**
	 * 每天监测账号电费水费，余额不足发送短信提醒
	 */
	@Scheduled(cron = "0 0 9 * * ?")
	public void sendMessage() throws Exception {
		String allPhone = "";
		Timestamp ts = DateUtil.getDate();
		String content = "【江北新区研创园】电费余额不足，请及时充值";
		String PHONE_NUMBER_REG = "^(1[3-9])\\d{9}$";
		//得到用户房间绑定所有记录
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());
		List<WxUserRoom> list = wxUserRoomManager.getAll();
		for(WxUserRoom wxUserRoom : list){
			FloorRoomInDevice floorRoomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", wxUserRoom.getRoomId());
			ElectricDayRecord electricDayRecord = electricDayRecordManager.get(floorRoomInDevice.getDeviceId());
			String balance = electricDayRecord.getBalance();
			if(Double.valueOf(balance) < 10.0){
				//验证手机号码
				boolean flag = wxUserRoom.getUserPhone().matches(PHONE_NUMBER_REG);
				if(flag == true && !allPhone.contains(wxUserRoom.getUserPhone())){
					Map<String, String> param = new HashMap<>();
					param.put("userid", "273");//企业ID,273
					param.put("timestamp", timestamp);//时间戳，系统当前时间字符串，年月日时分秒
					String signStr = "nanjinglhcz"+"nanjinglhcz"+timestamp;
					String sign = WXPayUtil.MD5Lower(signStr);
					param.put("sign", sign);//签名，使用 账号+密码+时间戳 生成MD5字符串作为签名。MD5生成32位，且需要小写
					param.put("mobile", wxUserRoom.getUserPhone());//全部被叫号码，多个号码之间用半角逗号隔开
					param.put("content", content);//发送内容，内容需要UTF-8编码
					param.put("sendTime", "");//定时发送时间，为空表示立即发送，定时发送格式2010-10-24 09:08:10
					param.put("action", "send");//发送任务命令，固定为：send
					param.put("extno", "");//扩展子号，请先询问配置的通道是否支持扩展子号，如果不支持，请填空。子号只能为数字，且最多6位数。
					String paramStr = JSON.toJSONString(param);
					String url = "http://47.96.185.189:8088/v2sms.aspx?action=send&userid=273&timestamp="+timestamp+"&sign="+sign+"&mobile="+wxUserRoom.getUserPhone()+"&content="+content+"&sendTime=&extno=";
					String response = HttpClient.sendHttpRequest(url, paramStr,"POST", "application/xml;charset=utf-8");
					Map<String, String> responseMap = WXPayUtil.xmlToMap(response);
					System.out.println(responseMap);
					if(responseMap.get("message").equals("ok")){
						allPhone += wxUserRoom.getUserPhone();
						//保存
						SendMessageRecord sendMessageRecord = new SendMessageRecord();
						sendMessageRecord.setRoomId(wxUserRoom.getRoomId());
						sendMessageRecord.setBalance(balance);
						sendMessageRecord.setUserName(wxUserRoom.getUserName());
						sendMessageRecord.setUserPhone(wxUserRoom.getUserPhone());
						sendMessageRecord.setTaskId(responseMap.get("taskID"));
						sendMessageRecord.setCreateTime(ts);
						sendMessageRecordManager.save(sendMessageRecord);
					}else{
						logger.info("----------短信发送失败----------"+wxUserRoom.getRoomId()+"----------"+wxUserRoom.getUserPhone());
					}
				}
			}
		}
	}

	/**
	 * 退房查询
	 */
	@RequestMapping("check-out-list")
	public String checkOutList(Page page,
									 @RequestParam(required = false, defaultValue = "createTime") String orderField,
									 @RequestParam(required = false, defaultValue = "desc") String orderDirection,
									 @ModelAttribute("user_session") GxSysUser user,
									 @RequestParam Map<String, Object> parameterMap, Model model){
		//设置排序字段
		page.setOrderBy(orderField);
		page.setOrder(orderDirection);
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = checkOutRoomManager.pagedQuery(page,propertyFilters);
		List<CheckOutRoom> list = (List<CheckOutRoom>) page.getResult();
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "sd/check-out-list";
	}

	/**
	 * 退房查看详情
	 * @param rowId 退房表主键
	 * @param model
	 * @return
	 */
	@RequestMapping("to-check-out-detail")
	public String checkOutDetail(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		if(rowId != null && rowId.length() > 0){
			CheckOutRoom checkOutRoom = checkOutRoomManager.get(rowId);
			model.addAttribute("model", checkOutRoom);
			List<WaterFloorRoomInDevice> waterFloorRoomInDevices = waterFloorRoomInDeviceManager.findBy("roomName", checkOutRoom.getRoomId());
			model.addAttribute("waterMeterNum", waterFloorRoomInDevices.size());
		}
		return "sd/check-out-detail";
	}

	@RequestMapping("to-room-rent")
	public String input() {
		return "sd/room-rent";
	}


	/**
	 * 尝试重新充值
	 */
	@RequestMapping("retry-recharge")
	public @ResponseBody
	Map<String, Object> retryRecharge(String rowId) {
		Map<String, Object> resMap = new HashMap<>();
		String statusCode = "200", message = "操作成功";
		Boolean reload = true;
		//得到充值失败记录
		SdRechargeFailRecord sdRechargeFailRecord = sdRechargeFailRecordManager.get(rowId);
		String roomId = sdRechargeFailRecord.getRoomId();
		Double rechargeMoney = sdRechargeFailRecord.getRechargeMoney();
		//调用电表充值接口重新充值
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
				logger.info("----------------------对充值失败记录进行重新充值----------房间号："+roomId+"----------充值成功----------------------");
				//保存充值成功记录表
				SdRechargeRecord sdRechargeRecord = new SdRechargeRecord();
				sdRechargeRecord.setRoomId(roomId);
				sdRechargeRecord.setRechargeType(sdRechargeFailRecord.getRechargeType());
				sdRechargeRecord.setOutTradeNo(sdRechargeFailRecord.getOutTradeNo());
				sdRechargeRecord.setRechargeTime(ts);
				sdRechargeRecord.setDeviceId(deviceId);
				sdRechargeRecord.setDataType("充值失败重新充值");
				sdRechargeRecord.setOpenId(sdRechargeFailRecord.getOpenId());
				//修改根据openId查询（2019-09-08）
				List<WxUserRoom> wxUserRoomList = wxUserRoomManager.findBy("wxUserId", sdRechargeFailRecord.getOpenId());
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
				String balance_old = electricDayRecord.getBalance();
				Double balance_new = DoubleUtil.add(Double.valueOf(balance_old), rechargeMoney);
				electricDayRecord.setBalance(String.format("%.2f", balance_new));
				electricDayRecordManager.save(electricDayRecord);
				//删除充值失败记录
				sdRechargeFailRecordManager.remove(sdRechargeFailRecord);
			}else {
				statusCode = "300";
				message = "充值失败";
				reload = false;
				logger.info("----------------------对充值失败记录进行重新充值----------房间号："+roomId+"----------充值失败----------------------");
			}
		}catch(Exception e){
			logger.info("----------------------对充值失败记录进行重新充值----------房间号："+roomId+"----------系统错误----------------------");
			statusCode = "400";
			message = "系统错误";
			reload = false;
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("reload", reload);
		return resMap;
	}

}
