package com.gx.soft.sys.web;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.util.StringUtils;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.sys.persistence.domain.GxSysOrg;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.GxSysUserInOrg;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.GxSysOrgManager;
import com.gx.soft.sys.persistence.manager.GxSysUserInOrgManager;
import com.gx.soft.sys.persistence.manager.SysUserManager;
import com.gx.soft.sys.persistence.manager.VUserManager;

@Controller
@RequestMapping("sysuser")
@SessionAttributes("user_session")
public class GxSysUserController {
	private GxSysOrgManager gxSysOrgManager;
	private VUserManager vUserManager;
	private SysUserManager gxUserManager;
	private GxSysUserInOrgManager gxSysUserInOrgManger;
	private BeanMapper beanMapper = new BeanMapper();

	/**
	 * 前往用户列表页面
	 * 
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("user-list")
	public String list(@ModelAttribute Page page, String orgId,
			@RequestParam Map<String, Object> parameterMap, Model model) {
		parameterMap.put("filter_EQS_orgId", orgId);
		page.addOrder("dataOrder", "asc");
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = vUserManager.pagedQuery(page, propertyFilters);
		List<VUser> userList = (List<VUser>) page.getResult();

		page.setResult(userList);
		model.addAttribute("page", page);
		model.addAttribute("orgId", orgId);

		return "sys/user/user-list";

	}

	/**
	 * 前往用户的添加/修改页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("user-input")
	public String input(
			@RequestParam(value = "rowId", required = false) String rowId,
			String orgId, Model model) {
		GxSysUser gxSysUser = null;
		if (rowId != null) {
			gxSysUser = gxUserManager.get(rowId);
		} else {
			gxSysUser = new GxSysUser();
		}
		model.addAttribute("orgId", orgId);
		model.addAttribute("model", gxSysUser);
		return "sys/user/user-input";
	}

	/**
	 * 用户的保存/更新
	 * 
	 * @param gxsysUser
	 * @return
	 */
	@RequestMapping(value = "user-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> save(GxSysUser gxsysUser, String orgId,
			HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		GxSysUser gxuser = (GxSysUser) (session.getAttribute("user_session") == null ? null
				: session.getAttribute("user_session"));
		try {
			GxSysUser dest = null;
			String id = gxsysUser.getRowId();
			String opt = "save";
			String oldUserId = "";
			if (id != null && id.length() > 0) {
				dest = gxUserManager.get(id);
				oldUserId = dest.getUserId();
				if (dest != null) {
					beanMapper.copy(gxsysUser, dest);
					dest.setModifyTime(ts);
					opt = "update";
				}
			} else {
				dest = gxsysUser;
				dest.setRowId(null);
				dest.setCreateTime(ts);

			}
			gxUserManager.save(dest);
			if (opt.equals("save")) {// 保存操作：保存用户和组织机构关系
				GxSysUserInOrg gxSysUserInOrg = new GxSysUserInOrg();
				gxSysUserInOrg.setCreateTime(ts);
				gxSysUserInOrg.setCreateUserId(gxuser != null ? gxuser
						.getUserId() : "");
				gxSysUserInOrg.setOrgId(orgId);
				gxSysUserInOrg.setUserId(dest.getUserId());
				gxSysUserInOrg.setDataOrder(dest.getDataOrder());

				String hql = "SELECT max(t.dataOrder) FROM  GxSysUserInOrg t where t.orgId=?";
				List maxNum = gxSysUserInOrgManger.find(hql, orgId);
				int num = 1;
				if (maxNum.size() < 1) {
					num = 1;
				} else {
					Object obj = maxNum.get(0);
					num = !StringUtils.validateLong(obj) ? 1 : new BigDecimal(
							obj.toString()).intValue() + 1;

				}
				gxSysUserInOrg.setDataOrder(num);
				gxSysUserInOrgManger.save(gxSysUserInOrg);
				dest.setDataOrder(num);
				gxUserManager.save(dest);
			} else {// 更新操作
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				parameterMap.put("filter_EQS_orgId", orgId);
				parameterMap.put("filter_EQS_userId", oldUserId);
				List<PropertyFilter> propertyFilters = PropertyFilter
						.buildFromMap(parameterMap);
				List<GxSysUserInOrg> userInOrgList = gxSysUserInOrgManger
						.find(propertyFilters);
				GxSysUserInOrg uio = userInOrgList != null
						&& userInOrgList.size() > 0 ? userInOrgList.get(0)
						: null;
				if (uio != null) {
					uio.setDataOrder(dest.getDataOrder());// 更新排序状态
					uio.setUserId(dest.getUserId());// 更新userId
					gxSysUserInOrgManger.save(uio);
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
		resMap.put("divid", "user-manager-user-list");

		return resMap;

	}

	/**
	 * 用户的删除
	 * 
	 * @param delids
	 * @return
	 */
	@RequestMapping("user-remove")
	public @ResponseBody
	Map<String, Object> userRemove(String delids,
			@RequestParam(defaultValue = "####") String orgId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				String[] ids = delids.split(",");

				for (String rowId : ids) {

					if (rowId != null) {
						GxSysUser sysUser = gxUserManager.get(rowId);
						if (sysUser != null) {
							gxUserManager.remove(sysUser);
						}
						String userId = sysUser.getUserId();
						// 删除组织机构-人员关联关系
						parameterMap.put("filter_EQS_userId", userId);
						parameterMap.put("filter_EQS_orgId", orgId);
						List<PropertyFilter> propertyFilters = PropertyFilter
								.buildFromMap(parameterMap);
						List<GxSysUserInOrg> userInOrgList = gxSysUserInOrgManger
								.find(propertyFilters);
						for (GxSysUserInOrg o : userInOrgList) {
							gxSysUserInOrgManger.remove(o);
						}
						parameterMap.clear();

					}

				}

			}
		} catch (Exception e) {
			statusCode = "300";
			message = "删除失败";
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("divid", "user-manager-user-list");
		return resMap;
	}

	/**
	 * 前往人员管理总页面（左侧是组织树，右侧是人员管理）
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("user-manager-page")
	public String userManagerPage(Model model) {
		return "sys/user/user-manager";
	}

	/**
	 * 多组织人员添加页面
	 * 
	 * @param rowId
	 * @param orgId
	 * @param model
	 * @return
	 */
	@RequestMapping("user-input-orgs")
	public String orgsUserinput(
			@RequestParam(value = "rowId", required = false) String rowId,
			String orgId, Model model) {
		GxSysUser gxSysUser = null;
		if (rowId != null) {
			gxSysUser = gxUserManager.get(rowId);
		} else {
			gxSysUser = new GxSysUser();
		}
		model.addAttribute("orgId", orgId);
		model.addAttribute("model", gxSysUser);
		return "sys/user/add-orgs-user";
	}

	/**
	 * 多组织人员添加-保存操作
	 * 
	 * @param orgId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "orgsuser-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> orgsUserSave(String userId, String orgId,
			HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		GxSysUser gxuser = (GxSysUser) (session.getAttribute("user_session") == null ? null
				: session.getAttribute("user_session"));
		try {

			Map<String, Object> parameterMap = new HashMap<String, Object>();
			if (StringUtils.validateString(userId)) {
				String[] userIdArr = userId.split(",");
				for (String eUserId : userIdArr) {
					parameterMap.put("filter_EQS_orgId", orgId);
					parameterMap.put("filter_EQS_userId", eUserId);
					List<PropertyFilter> propertyFilters = PropertyFilter
							.buildFromMap(parameterMap);
					List<GxSysUserInOrg> userInOrgList = gxSysUserInOrgManger
							.find(propertyFilters);
					GxSysUserInOrg uio = userInOrgList != null
							&& userInOrgList.size() > 0 ? userInOrgList.get(0)
							: null;
					if (uio == null) {
						String hql = "SELECT max(t.dataOrder) FROM  GxSysUserInOrg t where t.orgId=?";
						List maxNum = gxSysUserInOrgManger.find(hql, orgId);
						int num = 1;
						if (maxNum.size() < 1) {
							num = 1;
						} else {
							Object obj = maxNum.get(0);
							num = !StringUtils.validateLong(obj) ? 1
									: new BigDecimal(obj.toString()).intValue() + 1;
						}

						GxSysUserInOrg gxSysUserInOrg = new GxSysUserInOrg();
						gxSysUserInOrg.setCreateTime(ts);
						gxSysUserInOrg.setCreateUserId(gxuser != null ? gxuser
								.getUserId() : "");
						gxSysUserInOrg.setOrgId(orgId);
						gxSysUserInOrg.setUserId(eUserId);
						gxSysUserInOrg.setDataOrder(num);
						gxSysUserInOrgManger.save(gxSysUserInOrg);
					}
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
		resMap.put("divid", "user-manager-user-list");

		return resMap;

	}

	/**
	 * 解除用户和组织关系
	 * 
	 * @param delids
	 * @param orgId
	 * @return
	 */
	@RequestMapping("user-orgs-remove")
	public @ResponseBody
	Map<String, Object> userOrgsRemove(String delids,
			@RequestParam(defaultValue = "####") String orgId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				String[] ids = delids.split(",");

				for (String rowId : ids) {

					if (rowId != null) {

						GxSysUser sysUser = gxUserManager.get(rowId);
						if (sysUser != null) {
							// gxUserManager.remove(sysUser);
							String userId = sysUser.getUserId();
							// 删除组织机构-人员关联关系
							parameterMap.put("filter_EQS_userId", userId);
							parameterMap.put("filter_EQS_orgId", orgId);
							List<PropertyFilter> propertyFilters = PropertyFilter
									.buildFromMap(parameterMap);
							List<GxSysUserInOrg> userInOrgList = gxSysUserInOrgManger
									.find(propertyFilters);
							for (GxSysUserInOrg o : userInOrgList) {
								gxSysUserInOrgManger.remove(o);
							}
							parameterMap.clear();
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
		resMap.put("divid", "user-manager-user-list");
		return resMap;
	}

	/**
	 * 选择关联用户页面
	 * 
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("userlookup")
	public String userlookup(@ModelAttribute Page page,
			@RequestParam Map<String, Object> parameterMap, Model model) {

		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = gxUserManager.pagedQuery(page, propertyFilters);
		List<GxSysUser> userList = (List<GxSysUser>) page.getResult();
		page.setResult(userList);
		model.addAttribute("page", page);
		return "sys/user/userlookup";
	}

	/**
	 * 文件的排序更新
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "updateOrder/{opt}", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> updateOrder(String uioRowId, @PathVariable String opt,
			@ModelAttribute("user_session") GxSysUser user, HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		try {
			GxSysUserInOrg srcUio = gxSysUserInOrgManger.get(uioRowId);
			String orgId = srcUio.getOrgId();
			String userId = srcUio.getUserId();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("filter_EQS_orgId", orgId);
			List<PropertyFilter> propertyFilters = PropertyFilter
					.buildFromMap(params);
			List<GxSysUserInOrg> userRList = gxSysUserInOrgManger.find(
					"dataOrder", true, propertyFilters);
			int srcIndex = userRList.indexOf(srcUio);// 该元素在列表中所在的索引号
			int count = userRList.size();
			int destCount = -1;// 准备交换的元素的索引
			if (srcIndex != -1) {// 不等于-1，表示在列表中能查找到

				int addend = 0;
				if (opt.equals("up")) {
					if (srcIndex != 0) {// 如果当前已经是第一个元素，不操作；否则查找上一个元素
						destCount = srcIndex - 1;
					} else {
						destCount = srcIndex;
					}
				} else if (opt.equals("down")) {// 若是降序操作，被加数为1
					if (srcIndex != count - 1) {// 如果当前已经是最后一个元素，不操作；否则查找下个元素
						destCount = srcIndex + 1;
					} else {
						destCount = srcIndex;
					}
				}
			}
			if (destCount != -1) {
				// 查找交换的实体，交换order后保存到数据库
				if (destCount == srcIndex) {// 当前元素索引和目标索引一致，说明是同一个元素，不需要调换顺序
					statusCode = "200";
					message = "当前已经是第一个/最后一个元素";
				} else {
					GxSysUserInOrg destUio = userRList.get(destCount);
					int srcOrder = srcUio.getDataOrder();
					int destOrder = destUio.getDataOrder();
					srcUio.setDataOrder(destOrder);
					destUio.setDataOrder(srcOrder);
					// 同步更新用户表中的排序字段
					GxSysUser srcUser = gxUserManager.findUniqueBy("userId",
							srcUio.getUserId());
					if (srcUser != null) {
						srcUser.setDataOrder(srcUio.getDataOrder());
						gxUserManager.save(srcUser);
					}
					GxSysUser destUser = gxUserManager.findUniqueBy("userId",
							destUio.getRowId());
					if (destUser != null) {
						destUser.setDataOrder(destUio.getDataOrder());
						gxUserManager.save(destUser);
					}

					gxSysUserInOrgManger.save(destUio);
					gxSysUserInOrgManger.save(srcUio);
				}
			}

		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("divid", "user-manager-user-list");
		return resMap;

	}

	/**
	 * 含有组织树总页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("org-page")
	public String getOrgs(
			String rowId,
			@RequestParam(defaultValue = "add", required = false) String group,
			@RequestParam(defaultValue = "", required = false) String boxId,
			@RequestParam(defaultValue = "navtab", required = false) String target,
			Model model) {
		String hql = "from GxSysOrg order by dataOrder asc";
		List<GxSysOrg> orgList = gxSysOrgManager.find(hql, new Object[] {});
		model.addAttribute("orgList", orgList);
		model.addAttribute("userId", rowId);
		model.addAttribute("target", target);
		model.addAttribute("group", group);
		model.addAttribute("boxId", boxId);
		return "sys/user/org-bring-back";
	}

	/**
	 * 用户的保存/更新
	 * 
	 * @return
	 */
	@RequestMapping(value = "user-org-update", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> updateOrg(String orgId, String userId,
			HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		if (statusCode.equals("200")) {
			try {
				GxSysUser dest = null;
				String oldUserId = "";
				if (StringUtils.validateString(userId)) {
					dest = gxUserManager.get(userId);
					oldUserId = dest.getUserId();
					// 更新操作
					Map<String, Object> parameterMap = new HashMap<String, Object>();
					// parameterMap.put("filter_EQS_orgId", orgId);
					parameterMap.put("filter_EQS_userId", oldUserId);
					List<PropertyFilter> propertyFilters = PropertyFilter
							.buildFromMap(parameterMap);
					List<GxSysUserInOrg> userInOrgList = gxSysUserInOrgManger
							.find(propertyFilters);
					GxSysUserInOrg uio = userInOrgList != null
							&& userInOrgList.size() > 0 ? userInOrgList.get(0)
							: null;
					if (uio != null) {
						// uio.setDataOrder(dest.getDataOrder());// 更新排序状态
						// uio.setUserId(dest.getUserId());// 更新userId
						uio.setOrgId(orgId);
						uio.setCreateTime(ts);
						gxSysUserInOrgManger.save(uio);
					}
				}

			} catch (Exception e) {
				statusCode = "300";
				message = "操作失败";
				e.printStackTrace();
			}
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		resMap.put("divid", "user-manager-user-list");

		return resMap;

	}

	@Resource
	public void setGxSysOrgManager(GxSysOrgManager gxSysOrgManager) {
		this.gxSysOrgManager = gxSysOrgManager;
	}

	@Resource
	public void setvUserManager(VUserManager vUserManager) {
		this.vUserManager = vUserManager;
	}

	@Resource
	public void setGxSysUserInOrgManger(
			GxSysUserInOrgManager gxSysUserInOrgManger) {
		this.gxSysUserInOrgManger = gxSysUserInOrgManger;
	}

	@Resource
	public void setGxUserManager(SysUserManager gxUserManager) {
		this.gxUserManager = gxUserManager;
	}

}
