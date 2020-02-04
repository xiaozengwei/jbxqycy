package com.gx.soft.ht.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.spring.TimeStampPropertyEditor;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.manager.GxSysOrgManager;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.ykt.persistence.domain.VYktInstAct;
import com.gx.soft.ykt.persistence.domain.VYktProcinst;
import com.gx.soft.ykt.persistence.manager.OneCardApplyManager;
import com.gx.soft.ykt.persistence.manager.OneCardInfoManager;
import com.gx.soft.ykt.persistence.manager.VYktInstActManager;
import com.gx.soft.ykt.persistence.manager.VYktProcinstManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ht")
@SessionAttributes("user_session")
public class HtController {
	static Logger logger = Logger.getLogger(HtController.class);
	@Autowired
	private GxSysOrgManager gxSysOrgManager;
	@Autowired
	private VUserManager vUserManager;

	@Autowired
	private OneCardApplyManager oneCardApplyManager;

	@Autowired
	private OneCardInfoManager oneCardInfoManager;

	@Autowired
	private VYktInstActManager vYktInstActManager;

	@Autowired
	private VYktProcinstManager vYktProcinstManager;
	
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
	@RequestMapping("to-ykt-apply")
	public String toYktApply() {
		return "ykt/ykt-apply";
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
	@RequestMapping("ht-query-list")
	public String htQueryList(Page page,
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
//		parameterMap.put("filter_EQS_createUserId", user.getUserId());
//		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
//		page = vYktProcinstManager.pagedQuery(page,propertyFilters);
//		List<VYktProcinst> list = (List<VYktProcinst>) page.getResult();
//		page.setResult(list);
//		model.addAttribute("list", list);
//		model.addAttribute("page", page);
		return "ht/ht-query-list";
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
	@RequestMapping("ykt-task-list")
	public String yktTaskList(Page page,
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
		page = vYktInstActManager.pagedQuery(page, propertyFilters);
		List<VYktInstAct> list = (List<VYktInstAct>) page.getResult();
		page.setResult(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "ykt/ykt-task-list";
	}

	
}
