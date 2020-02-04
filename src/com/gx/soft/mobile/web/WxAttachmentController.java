package com.gx.soft.mobile.web;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gx.core.util.StringUtils;
import com.gx.soft.mobile.persistence.domain.WxAttachment;
import com.gx.soft.mobile.persistence.domain.WxUser;
import com.gx.soft.mobile.persistence.manager.WxAttachmentManager;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.office.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信端文件上传控制器
 * @author ShuaiBiLin
 *
 */
@Controller
@SessionAttributes("wxUser")
@RequestMapping("mobile-upload")
public class WxAttachmentController {
	private ObjectMapper objectMapper = null;
	private JsonGenerator jsonGenerator = null;
	@Autowired
	private WxAttachmentManager wxAttachmentManager;

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	@RequestMapping(method = RequestMethod.GET)
	public void fileUploadForm() {
	}

	private WxAttachmentController() {
		super();
		// TODO Auto-generated constructor stub
		objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(
					System.out, JsonEncoding.UTF8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 文件上传
	 * @param file
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.POST,value = "fileUpload")
	public void processUpload(String relationId,
							  @RequestParam MultipartFile file,
							  @ModelAttribute("user_session") WxUser wxUser,
							  @RequestParam(required = false) String docId,
							  @RequestParam(required = false) String docType,
							  HttpServletResponse response, Model model, HttpSession session) throws IOException {
		model.addAttribute("message", "File '" + file.getOriginalFilename()+ "' uploaded successfully");
		String statusCode = "200", message = "上传成功";
		System.out.println("--------------------");
		Map<String, Object> resMap = new HashMap<String, Object>();
		String fileOriginalName = file.getOriginalFilename();
		int index = fileOriginalName.lastIndexOf(".");
		String file_type = fileOriginalName.substring(index+1);
		WxAttachment attachment = null;
		try {
			if (!StringUtils.isEmpty(fileOriginalName)) {
				FileUtil fileHelper = new FileUtil();
				String decodeFileName = fileHelper
						.getDecodeFileName(fileOriginalName);// 文件名编码
				String mFilePath = session.getServletContext().getRealPath(""); // 取得服务器路径
				mFilePath = mFilePath.substring(0, 2) + "\\jbxqycy\\upload\\" + decodeFileName;
				fileHelper.createFile(mFilePath, file.getBytes());
				attachment = new WxAttachment();
				attachment.setRelationId(relationId);
				attachment.setAttachPath(mFilePath);
				attachment.setAttachName(fileOriginalName);
				attachment.setAttachType(file_type);
				attachment.setUploadUserId(wxUser.getOpenid());
				attachment.setUploadUserName(wxUser.getNickname());
				attachment.setUploadTime(DateUtil.getDate());
				attachment.setAttachFileIdentifyName(decodeFileName);
				//保存
				wxAttachmentManager.save(attachment);
				resMap.put("fileName", fileOriginalName);
				resMap.put("attachment", attachment);
			} else {
				message = "请选择上传文件";
				statusCode = "300";
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "上传失败";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		String returnString = objectMapper.writeValueAsString(resMap);
		response.setCharacterEncoding("UTF-8"); // 设置编码格式
		response.setContentType("text/html"); // 设置数据格式
		PrintWriter out = response.getWriter(); // 获取写入对象
		out.print(returnString); // 将json数据写入流中
		out.flush();
	}

	/**
	 * 附件删除
	 * @param fileId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "fileDelete", produces = "application/json")
	public @ResponseBody
	Map<String, Object> fileDelete(@RequestParam String fileId)
			throws IOException {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		WxAttachment attachment = wxAttachmentManager.get(fileId);
		wxAttachmentManager.removeById(fileId);
		String filePath = attachment.getAttachPath();
		FileUtil fileHelper = new FileUtil();
		boolean isDelete = true;
		try {
			fileHelper.deleteFile(filePath);
			if (!isDelete) {
				statusCode = "300";
				message = "删除失败";
			}
		} catch (Exception e) {
			statusCode = "300";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		return resMap;
	}

	/**
	 * 附件下载
	 *
	 * @param fileId
	 *            文件ID
	 * @return 下载
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "fileDownload")
	public void fileDownLoad(String fileId, HttpServletRequest request,
							 HttpServletResponse response) throws IOException {
		WxAttachment attachment = wxAttachmentManager.get(fileId);
		String filePath = attachment.getAttachPath();
		String fileName = attachment.getAttachName();
		FileUtil fileHelper = new FileUtil();
		fileHelper.downloadFile(filePath, request, response, fileName);
	}

	/**
	 *
	 * @param type
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "fwzl-fileDownload")
	public void FwzlFileDownLoad(String type, HttpServletRequest request,
							 HttpServletResponse response) throws IOException {
		String filePath = "";
		String fileName = "";
		if(type.equals("1")){
			filePath = "C:\\fwzl-file\\人才公寓租赁申请表.docx";
			fileName = "人才公寓租赁申请表.docx";
		}else if(type.equals("2")){
			filePath = "C:\\fwzl-file\\入住人员信息登记表.docx";
			fileName = "入住人员信息登记表.docx";
		}else{
			filePath = "C:\\fwzl-file\\单位承诺书.docx";
			fileName = "单位承诺书.docx";
		}
		FileUtil fileHelper = new FileUtil();
		fileHelper.downloadFile(filePath, request, response, fileName);
	}

	@RequestMapping(method = RequestMethod.GET, value = "ykt-excel-download")
	public void yktExcelDownLoad(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String filePath = "C:\\jbxqycy\\ykt\\人员明细表.xlsx";
		String fileName = "人员明细表.xlsx";
		FileUtil fileHelper = new FileUtil();
		fileHelper.downloadFile(filePath, request, response, fileName);
	}

}
