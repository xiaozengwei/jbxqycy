package com.gx.ext.export;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.core.util.ServletUtils;


public class CsvExportor implements Exportor {
	public void export(HttpServletRequest request,
			HttpServletResponse response, TableModel tableModel)
			throws IOException {
		StringBuilder buff = new StringBuilder();

		for (int i = 0; i < tableModel.getHeaderCount(); i++) {
			buff.append(tableModel.getHeader(i));

			if (i != (tableModel.getHeaderCount() - 1)) {
				buff.append(",");
			}
		}

		buff.append("\n");

		for (int i = 0; i < tableModel.getDataCount(); i++) {
			for (int j = 0; j < tableModel.getHeaderCount(); j++) {
				buff.append(tableModel.getValue(i, j));

				if (j != (tableModel.getHeaderCount() - 1)) {
					buff.append(",");
				}
			}

			buff.append("\n");
		}

		response.setContentType(ServletUtils.STREAM_TYPE);
		ServletUtils.setFileDownloadHeader(request, response,
				tableModel.getName() + ".csv");
		response.getOutputStream().write(buff.toString().getBytes("UTF-8"));
		response.getOutputStream().flush();
	}



	@Override
	public void exportOfficeSupplies(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> conditions)
			throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void exportPerfomanceAssessResult(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> conditions)
			throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void exportExamStatisticsVo(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> conditions)
			throws IOException {
		// TODO Auto-generated method stub

	}

}
