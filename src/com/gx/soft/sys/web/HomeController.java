package com.gx.soft.sys.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.fwzl.persistence.domain.VFwzlInstAct;
import com.gx.soft.fwzl.persistence.manager.VFwzlInstActManager;
import com.gx.soft.hys.persistence.domain.VMeetInstAct;
import com.gx.soft.hys.persistence.manager.VMeetInstActManager;
import com.gx.soft.ykt.persistence.domain.OneCardApply;
import com.gx.soft.ykt.persistence.domain.VIndexAgency;
import com.gx.soft.ykt.persistence.manager.VIndexAgencyManager;
import com.gx.soft.ykt.persistence.manager.VYktInstActManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gx.soft.sys.persistence.domain.GxSysFunction;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.manager.SysFunctionManager;

/**
 * 进入主页方法
 * 
 * @author optimus
 * @version 1.0
 */
@Controller
@RequestMapping("home")
@SessionAttributes("user_session")
// Session 注解
public class HomeController {
	private static Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	@Resource(name = "sysFunctionManager")
	private SysFunctionManager sysFunctionManager;

	@Autowired
	private VFwzlInstActManager vFwzlInstActManager;
	@Autowired
	private VMeetInstActManager vMeetInstActManager;
	@Autowired
	private VYktInstActManager vYktInstActManager;
	@Autowired
	private VIndexAgencyManager vIndexAgencyManager;

	/**
	 * 前往首页页面跳转方法
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("go-home")
	public String goHome(@RequestParam(required = false) Long funId,
						 @ModelAttribute("user_session") GxSysUser user, Model model) {
		String hql = "from GxSysFunction f where  f.rowId in(select rhf.functionId from GxSysRoleHasFunction rhf where rhf.roleId in(select uhr.roleId from GxSysRoleHasUser uhr where uhr.userId=?)) order by f.dataOrder";
		List<GxSysFunction> functionList = sysFunctionManager.find(hql, user.getUserId());
		if(funId!= null ){
			GxSysFunction defaultFun = sysFunctionManager.get(funId);
			model.addAttribute("defaultFun", defaultFun);
		}
		model.addAttribute("functionList", functionList);
		model.addAttribute("userName", user.getUserName());
		return "home/home_index";
	}

	/**
	 * 到主页面
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("to-index-layout")
	public String toIndexLayout(@ModelAttribute("user_session") GxSysUser user, Model model) {
		Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("filter_EQS_handleUser", user.getUserName());
		parameterMap.put("filter_EQS_activeState", "激活");
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		Integer gyCount = vFwzlInstActManager.find(propertyFilters).size();
		Integer hysCount = vMeetInstActManager.find(propertyFilters).size();
		Integer yktCount = vYktInstActManager.find(propertyFilters).size();
		Page page = new Page();
		page.setOrderBy("createTime");
		page.setOrder("desc");
		page = vIndexAgencyManager.pagedQuery(page, propertyFilters);
		List<VIndexAgency> list = (List<VIndexAgency>) page.getResult();
		model.addAttribute("gyCount", gyCount);
		model.addAttribute("hysCount", hysCount);
		model.addAttribute("yktCount", yktCount);
		model.addAttribute("totalCount", page.getTotalCount());
		model.addAttribute("list", list);
		return "home/index_layout";
	}

	/**
	 * 待办事宜
	 * @param page
	 * @param orderField
	 * @param orderDirection
	 * @param user
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("db-list")
	public String dbList(Page page,
						 @RequestParam(required = false, defaultValue = "") String orderField,
						 @RequestParam(required = false, defaultValue = "") String orderDirection,
						 @ModelAttribute("user_session") GxSysUser user,
						 @RequestParam Map<String, Object> parameterMap, Model model){
		if (orderField.length() > 0 && orderDirection.length() > 0) {
			page.setOrderBy(orderField);
			page.setOrder(orderDirection);
		}else {
			page.setOrderBy("createTime");
			page.setOrder("desc");
		}
		//添加条件为根据当前用户查询
		parameterMap.put("filter_EQS_handleUser", user.getUserName());
		parameterMap.put("filter_EQS_activeState", "激活");
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = vIndexAgencyManager.pagedQuery(page,propertyFilters);
		List<VIndexAgency> list = (List<VIndexAgency>) page.getResult();
		page.setResult(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "home/db-list";
	}

}
