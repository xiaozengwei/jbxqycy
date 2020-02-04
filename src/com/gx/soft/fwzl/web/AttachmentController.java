package com.gx.soft.fwzl.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gx.soft.fwzl.persistence.domain.Attachment;
import com.gx.soft.fwzl.persistence.manager.AttachmentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gx.core.util.StringUtils;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.office.util.FileUtil;
import com.gx.soft.sys.persistence.domain.GxSysUser;
/**
 * 审批办理附件信息表
 * @author ShuaiBiLin
 *
 */
@Controller
@SessionAttributes("user_session")
@RequestMapping("file")
public class AttachmentController {
	private ObjectMapper objectMapper = null;
	private JsonGenerator jsonGenerator = null;
	@Autowired
	private AttachmentManager attachmentManager;

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	@RequestMapping(method = RequestMethod.GET)
	public void fileUploadForm() {
	}

	private AttachmentController() {
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
							  @RequestParam(required = false) String docId,
							  @RequestParam(required = false) String docType,
							  @ModelAttribute("user_session") GxSysUser user,
							  HttpServletResponse response, Model model, HttpSession session) throws IOException {
		model.addAttribute("message", "File '" + file.getOriginalFilename()+ "' uploaded successfully");
		String statusCode = "200", message = "上传成功";
		Map<String, Object> resMap = new HashMap<String, Object>();
		String fileOriginalName = file.getOriginalFilename();
		int index = fileOriginalName.lastIndexOf(".");
		String file_type = fileOriginalName.substring(index+1);
		Attachment attachment = null;
		try {
			if (!StringUtils.isEmpty(fileOriginalName)) {
				FileUtil fileHelper = new FileUtil();
				String decodeFileName = fileHelper
						.getDecodeFileName(fileOriginalName);// 文件名编码
				String mFilePath = session.getServletContext().getRealPath(""); // 取得服务器路径
				mFilePath = mFilePath.substring(0, 2) + "\\jbxqycy\\upload\\" + decodeFileName;
				fileHelper.createFile(mFilePath, file.getBytes());
				attachment = new Attachment();
				attachment.setRelationId(relationId);
				attachment.setAttachPath(mFilePath);
				attachment.setAttachName(fileOriginalName);
				attachment.setAttachType(file_type);
				attachment.setUploadUserId(user.getUserId());
				attachment.setUploadUserName(user.getUserName());
				attachment.setUploadTime(DateUtil.getDate());
				attachment.setAttachFileIdentifyName(decodeFileName);
				//保存
				attachmentManager.save(attachment);
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
		Attachment attachment = attachmentManager.get(fileId);
		attachmentManager.removeById(fileId);
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
		Attachment attachment = attachmentManager.get(fileId);
		String filePath = attachment.getAttachPath();
		String fileName = attachment.getAttachName();
		FileUtil fileHelper = new FileUtil();
		fileHelper.downloadFile(filePath, request, response, fileName);
	}

}
