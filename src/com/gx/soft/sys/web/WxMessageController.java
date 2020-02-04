package com.gx.soft.sys.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.mobile.persistence.domain.WxMessageRelease;
import com.gx.soft.mobile.persistence.manager.WxMessageReleaseManager;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.sys.persistence.domain.GxSysDicIndex;
import com.gx.soft.sys.persistence.domain.GxSysDicRecord;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.manager.GxIndexManager;
import com.gx.soft.sys.persistence.manager.GxRecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("wxMessage")
@SessionAttributes("user_session")
public class WxMessageController {
	@Autowired
	private WxMessageReleaseManager wxMessageReleaseManager;

	private BeanMapper beanMapper = new BeanMapper();


	/**
	 * 微信端信息列表
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("wx-message-list")
	public String list(@ModelAttribute Page page,
					   @RequestParam Map<String, Object> parameterMap, Model model) {
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page.setOrderBy("createTime");
		page.setOrder("DESC");
		page = wxMessageReleaseManager.pagedQuery(page, propertyFilters);
		List<WxMessageRelease> list = (List<WxMessageRelease>) page.getResult();
		page.setResult(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "wxMessage/wx-message-list";
	}

	/**
	 * 到消息添加更新页面
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("to-wxMessage-input")
	public String toHysInput( @RequestParam(required = false, defaultValue = "") String rowId, Model model) {
		if(rowId != null){
			WxMessageRelease wxMessageRelease = wxMessageReleaseManager.get(rowId);
			model.addAttribute("wxMessageRelease",wxMessageRelease);
		}
		return "wxMessage/wxMessage-input";
	}

	/**
	 * 微信端发布信息保存
	 * @param user
	 * @param wxMessageRelease
	 * @return
	 */
	@RequestMapping(value = "wxMessage-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> wxMessageSave(@ModelAttribute("user_session") GxSysUser user, WxMessageRelease wxMessageRelease) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "保存成功";
		boolean closeCurrent = true;
		Timestamp ts = DateUtil.getDate();
		WxMessageRelease dest = null;
		String rowId = wxMessageRelease.getRowId();
		try{
			if(rowId != null && rowId.length() > 0){
				dest = wxMessageReleaseManager.get(rowId);
				beanMapper.copy(wxMessageRelease, dest);
				dest.setModifyUserId(user.getUserId());
				dest.setModifyUserName(user.getUserName());
				dest.setModifyTime(ts);
			}else{
				dest = wxMessageRelease;
				dest.setRowId(null);
				dest.setCreateTime(ts);
				dest.setDataDelete("1");
				dest.setCreateUserId(user.getUserId());
				dest.setCreateUserName(user.getUserName());
				dest.setCreateTime(ts);
			}
			wxMessageReleaseManager.save(dest);
		}catch (Exception e) {
			// TODO: handle exception
			statusCode = "300";
			closeCurrent = false;
			message = "保存失败";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", closeCurrent);
		return resMap;
	}

	/**
	 * 微信端发布信息删除
	 * @param delids
	 * @return
	 */
	@RequestMapping(value="wxMessage-remove")
	public @ResponseBody
	Map<String, Object> wxMessageRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					wxMessageReleaseManager.removeById(rowId);
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
