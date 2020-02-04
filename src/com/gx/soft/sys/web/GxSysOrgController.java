package com.gx.soft.sys.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.sys.persistence.domain.GxSysOrg;
import com.gx.soft.sys.persistence.manager.GxSysOrgManager;
import com.gx.soft.sys.persistence.manager.SysUserManager;
import com.gx.soft.sys.vo.ZtreeData;

@Controller
@RequestMapping("sysorg")
public class GxSysOrgController {
	private GxSysOrgManager gxSysOrgManager;
	private SysUserManager gxUserManager;
	private BeanMapper beanMapper = new BeanMapper();

	/**
	 * 前往组织列表页面
	 * 
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("org-list")
	public String list(Page page, String orderField, String orderDirection,
			@RequestParam Map<String, Object> parameterMap, Model model) {

		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page.addOrder("dataOrder", "asc");
		page = gxSysOrgManager.pagedQuery(page, propertyFilters);

		// List<GxSysOrg> orgList = (List<GxSysOrg>) page.getResult();
		Map<String, GxSysOrg> orgIdAndNameMap = new HashMap<String, GxSysOrg>();
		List<GxSysOrg> orgList = gxSysOrgManager.find(propertyFilters);
		for (GxSysOrg org : orgList) {
			orgIdAndNameMap.put(org.getRowId(), org);
		}
		// page.setResult(orgList);
		model.addAttribute("page", page);
		model.addAttribute("orgIdAndNameMap", orgIdAndNameMap);
		model.addAttribute("orderField", orderField);
		model.addAttribute("orderDirection", orderDirection);

		return "sys/org/org-list";

	}

	/**
	 * 前往组织的添加/修改页面
	 * 
	 * @param roleId
	 * @param model
	 * @return
	 */
	@RequestMapping("org-input")
	public String input(
			@RequestParam(value = "rowId", required = false) String rowId,
			Model model) {
		GxSysOrg gxSysOrg = null;
		if (rowId != null) {
			gxSysOrg = gxSysOrgManager.get(rowId);
		} else {
			gxSysOrg = new GxSysOrg();
		}
		model.addAttribute("model", gxSysOrg);
		return "sys/org/org-input";
	}

	/**
	 * 组织的保存/更新
	 * 
	 * @param gxSysOrg
	 * @return
	 */
	@RequestMapping(value = "org-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> save(GxSysOrg gxSysOrg) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		try {
			GxSysOrg dest = null;
			String id = gxSysOrg.getRowId();

			if (id != null && id.length() > 0) {
				dest = gxSysOrgManager.get(id);
				if (dest != null) {
					beanMapper.copy(gxSysOrg, dest);
					dest.setModifyTime(ts);
				}
			} else {
				gxSysOrg.setRowId(null);
				dest = gxSysOrg;
				dest.setCreateTime(ts);
			}
			gxSysOrgManager.save(dest);

		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);

		return resMap;

	}

	/**
	 * 组织的删除
	 * 
	 * @param delids
	 * @return
	 */
	@RequestMapping("org-remove")
	public @ResponseBody
	Map<String, Object> orgRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					if (rowId != null) {
						GxSysOrg sysRole = gxSysOrgManager.get(rowId);
						if (sysRole != null) {
							gxSysOrgManager.remove(sysRole);
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

	/**
	 * 查找带回-组织页面
	 * 
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("lookup-org-list")
	public String orgLookupList(@ModelAttribute Page page,
			@RequestParam Map<String, Object> parameterMap, Model model) {

		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = gxSysOrgManager.pagedQuery(page, propertyFilters);
		List<GxSysOrg> orgList = (List<GxSysOrg>) page.getResult();
		page.setResult(orgList);
		model.addAttribute("page", page);

		return "sys/org/org-list-lookup";

	}

	/**
	 * 组织树Json
	 * 
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "org-tree", produces = "application/json")
	public @ResponseBody
	List<ZtreeData> orgTree(@RequestParam Map<String, Object> parameterMap,
			Model model) {
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		List<GxSysOrg> orgList = gxSysOrgManager.find("dataOrder", true,
				propertyFilters);
		List<ZtreeData> ztreeData = new ArrayList<ZtreeData>();
		for (GxSysOrg org : orgList) {
			ZtreeData zData = new ZtreeData(org.getRowId(),
					org.getParentOrgId(), org.getOrgName(), org.getOrgName());
			ztreeData.add(zData);
		}

		return ztreeData;

	}

	@Resource
	public void setGxSysOrgManager(GxSysOrgManager gxSysOrgManager) {
		this.gxSysOrgManager = gxSysOrgManager;
	}

}
