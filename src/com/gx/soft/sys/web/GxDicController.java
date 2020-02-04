package com.gx.soft.sys.web;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.sys.persistence.domain.GxSysDicIndex;
import com.gx.soft.sys.persistence.domain.GxSysDicRecord;
import com.gx.soft.sys.persistence.manager.GxIndexManager;
import com.gx.soft.sys.persistence.manager.GxRecordManager;

@Controller
@RequestMapping("dic")
@SessionAttributes("user_session")
public class GxDicController {
	@Autowired
	private GxIndexManager gxIndexManager;
	@Autowired
	private GxRecordManager gxRecordManager;

	private BeanMapper beanMapper = new BeanMapper();


	/**
	 * 前往数据字典索引列表
	 * 
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("dic-index-list")
	public String list(@ModelAttribute Page page,
			@RequestParam Map<String, Object> parameterMap, Model model) {
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page.setOrderBy("orderNum");
		page.setOrder("asc");
		page = gxIndexManager.pagedQuery(page, propertyFilters);
		@SuppressWarnings("unchecked")
		List<GxSysDicIndex> indexList = (List<GxSysDicIndex>) page.getResult();
		page.setResult(indexList);
		model.addAttribute("page", page);
		return "dic/index/dic-index-list";
	}

	/**
	 * 数据字典索引记录的添加/更新页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("dic-index-input")
	public String input(
			@RequestParam(value = "rowId", required = false) String id,
			Model model) {
		GxSysDicIndex dicIndex = null;
		if (id != null) {
			dicIndex = gxIndexManager.get(id);
		} else {
			dicIndex = new GxSysDicIndex();
		}
		model.addAttribute("model", dicIndex);
		return "dic/index/dic-index-input";

	}

	/**
	 * 更新或保存数据字典索引
	 * 
	 * @param dicIndex
	 * @return
	 */
	@RequestMapping("dic-index-save")
	public @ResponseBody
	Map<String, Object> save(GxSysDicIndex dicIndex) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		try {
			GxSysDicIndex dest = null;
			String id = dicIndex.getRowId();

			if (id != null && id.length() > 0) {
				dest = gxIndexManager.get(id);
				beanMapper.copy(dicIndex, dest);
				dest.setUpdateTime(ts);
			} else {
				dicIndex.setRowId(null);
				dest = dicIndex;
				dest.setCreateDate(ts);
			}
			gxIndexManager.save(dest);

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
	 * 数据字典索引的删除
	 * 
	 * @param delids
	 * @return
	 */
	@RequestMapping("dic-index-remove")
	public @ResponseBody
	Map<String, Object> dicIndexRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					if (rowId != null) {
						GxSysDicIndex dicIndex = gxIndexManager.get(rowId);
						String dicIndexRowId = dicIndex.getRowId();
						List<GxSysDicRecord> dicRecordList = gxRecordManager
								.findBy("tableId", dicIndexRowId);

						/* 删除数据字典索引关联的记录 */

						if (dicRecordList != null && dicRecordList.size() > 0) {
							for (GxSysDicRecord r : dicRecordList) {
								if (r != null) {
									gxRecordManager.remove(r);
								}
							}
						}

					}
					gxIndexManager.removeById(rowId);

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
	 * 前往数据字典关联记录界面
	 * 
	 * @param rowId
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("dic-record-list")
	public String userlist(String rowId, @ModelAttribute Page page,
			@RequestParam Map<String, Object> parameterMap, Model model) {
		page.setOrderBy("orderNum");
		page.setOrder("asc");
		parameterMap.put("filter_EQS_tableId", rowId);
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = gxRecordManager.pagedQuery(page, propertyFilters);
		model.addAttribute("page", page);
		model.addAttribute("rowId", rowId);
		return "dic/dic/dic-record-list";
	}

	/**
	 * 数据字典关联记录输入/更新页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("dic-record-input")
	public String dicRecordInput(
			@RequestParam(value = "rowId", required = false) String id,
			String indexId, Model model) {
		GxSysDicRecord dicRecord = null;
		if (id != null) {
			dicRecord = gxRecordManager.get(id);
		} else {
			dicRecord = new GxSysDicRecord();
		}
		model.addAttribute("model", dicRecord);
		model.addAttribute("indexId", indexId);
		return "dic/dic/dic-record-input";
	}
	
	/**
	 * 数据字典关联记录的保存
	 * 
	 * @param dicRecord
	 * @return
	 */
	@RequestMapping("dic-record-save")
	public @ResponseBody
	Map<String, Object> dicRecordSave(GxSysDicRecord dicRecord) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		try {
			GxSysDicRecord dest = null;
			String id = dicRecord.getRowId();
			if (id != null && id.length() > 0) {// operation:update
				dest = gxRecordManager.get(id);
				beanMapper.copy(dicRecord, dest);
				dest.setUpdateTime(ts);
			} else {// operation:insert
				dicRecord.setRowId(null);
				dest = dicRecord;
				dest.setCreateDate(ts);
			}
			gxRecordManager.save(dest);

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
	 * 数据字典关联记录的删除
	 * 
	 * @param delids
	 * @return
	 */
	@RequestMapping("dic-record-remove")
	public @ResponseBody
	Map<String, Object> dicRecordRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {

			if (delids != null && delids.length() > 0) {
				String[] rowids = delids.split(",");
				/* 其次遍历指定的rowId获取到指定的roleHasUser对象并删除 */
				for (String rowId : rowids) {
					gxRecordManager.removeById(rowId);
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
