package com.gx.ext.export;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 导出接口
 * 
 * @author Ying 2016-1-31
 */
public interface Exportor {
	/**
	 * 普通导出记录
	 * 
	 * @param response
	 * @param tableModel
	 * @throws IOException
	 *             2016-1-31
	 */
	void export(HttpServletRequest request, HttpServletResponse response,
			TableModel tableModel) throws IOException;


	/**
	 * 导出办公用品列表
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void exportOfficeSupplies(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> conditions)
			throws IOException;

	/**
	 * 导出绩效评选的公示结果
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void exportPerfomanceAssessResult(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> conditions)
			throws IOException;

	/**
	 * 导出考试成绩
	 * 
	 * @param request
	 * @param response
	 * @param conditions
	 */
	void exportExamStatisticsVo(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> conditions)
			throws IOException;

}
