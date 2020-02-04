package com.gx.soft.sys.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.util.StringUtils;
import com.gx.soft.mobile.persistence.domain.WxUser;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.sys.persistence.domain.*;
import com.gx.soft.sys.persistence.manager.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 周边配套
 */
@Controller
@RequestMapping("zbpt")
@SessionAttributes("user_session")
public class ZbptController {
	@Autowired
	private PeripheralMatchingManager peripheralMatchingManager;
	@Autowired
	private ZbptAttachmentManager zbptAttachmentManager;

	private BeanMapper beanMapper = new BeanMapper();

	/**
	 * 前往周边配套列表页面
	 * 
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("zbpt-list")
	public String list(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model) {
		page.addOrder("dataOrder", "asc");
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = peripheralMatchingManager.pagedQuery(page, propertyFilters);
		List<PeripheralMatching> userList = (List<PeripheralMatching>) page.getResult();
		page.setResult(userList);
		model.addAttribute("page", page);
		return "sys/zbpt/zbpt-list";
	}

	/**
	 * 前往周边配套的添加/修改页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("zbpt-input")
	public String zbptInput(
			@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		PeripheralMatching peripheralMatching = null;
		if (rowId != null) {
			peripheralMatching = peripheralMatchingManager.get(rowId);
		}
		model.addAttribute("peripheralMatching", peripheralMatching);
		//得到配套图片
		List<ZbptAttachment> list = zbptAttachmentManager.findBy("relationId", rowId);
		model.addAttribute("attachmentList",list);
		return "sys/zbpt/zbpt-input";
	}

	/**
	 * 周边配套的保存/更新
	 * 
	 * @param peripheralMatching
	 * @return
	 */
	@RequestMapping(value = "zbpt-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> save(PeripheralMatching peripheralMatching,String attachmentId, @ModelAttribute("user_session") GxSysUser user) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		try {
			PeripheralMatching dest = null;
			String id = peripheralMatching.getRowId();
			if (id != null && id.length() > 0) {
				dest = peripheralMatchingManager.get(id);
				if (dest != null) {
					beanMapper.copy(peripheralMatching, dest);
					dest.setModifyTime(ts);
				}
			} else {
				dest = peripheralMatching;
				dest.setRowId(null);
				dest.setCreateTime(ts);
			}
			peripheralMatchingManager.save(dest);
			id = dest.getRowId();
			//关联配套图片
			if (attachmentId != null && attachmentId.length() > 0) {
				String[] idArr = attachmentId.split(",");
				for (int i = 0; i < idArr.length; i++) {
					ZbptAttachment spTzsbAttachment = zbptAttachmentManager.get(idArr[i]);
					spTzsbAttachment.setRelationId(id);
					zbptAttachmentManager.save(spTzsbAttachment);
				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		resMap.put("tabid", "T3446");
		return resMap;
	}

	/**
	 * 周边配套的删除
	 * 
	 * @param delids
	 * @return
	 */
	@RequestMapping("zbpt-remove")
	public @ResponseBody
	Map<String, Object> userRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					if (rowId != null) {
						PeripheralMatching peripheralMatching = peripheralMatchingManager.get(rowId);
						if (peripheralMatching != null) {
							peripheralMatchingManager.remove(peripheralMatching);
						}
						//删除图片
						List<ZbptAttachment> attachList = zbptAttachmentManager.findBy("relationId", rowId);
						com.gx.soft.office.util.FileUtil fileHelper = new com.gx.soft.office.util.FileUtil();
						if (attachList != null && attachList.size() > 0) {
							for (ZbptAttachment attach : attachList) {
								String filePath = attach.getAttachPath();
								fileHelper.deleteFile(filePath);
								zbptAttachmentManager.remove(attach);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "删除失败";
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("reload", true);
		return resMap;
	}

}
