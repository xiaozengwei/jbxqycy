package com.gx.soft.sys.web;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.util.StringUtils;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.office.util.FileUtil;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.ZbptAttachment;
import com.gx.soft.sys.persistence.manager.ZbptAttachmentManager;
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
import java.util.List;
import java.util.Map;

/**
 * 周边配套图片上传控制器
 * @author ShuaiBiLin
 *
 */
@Controller
@SessionAttributes("user_session")
@RequestMapping("zbpt-file")
public class ZbptAttachmentController {
	private ObjectMapper objectMapper = null;
	private JsonGenerator jsonGenerator = null;
	@Autowired
	private ZbptAttachmentManager zbptAttachmentManager;

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	@RequestMapping(method = RequestMethod.GET)
	public void fileUploadForm() {
	}

	private ZbptAttachmentController() {
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
							  @ModelAttribute("user_session") GxSysUser user,
							  @RequestParam(required = false) String docId,
							  @RequestParam(required = false) String docType,
							  HttpServletResponse response, Model model, HttpSession session) throws IOException {
		model.addAttribute("message", "File '" + file.getOriginalFilename()+ "' uploaded successfully");
		String statusCode = "200", message = "上传成功";
		Map<String, Object> resMap = new HashMap<String, Object>();
		String fileOriginalName = file.getOriginalFilename();
		ZbptAttachment zbptAttachment = null;
		try {
			if (!StringUtils.isEmpty(fileOriginalName)) {
				FileUtil fileHelper = new FileUtil();
				String decodeFileName = fileHelper.getDecodeFileName(fileOriginalName);// 文件名编码
				String mFilePath = session.getServletContext().getRealPath(""); // 取得服务器路径
				mFilePath = mFilePath.substring(0, 2) + "\\jbxqycy\\zbpt\\" + decodeFileName;
				fileHelper.createFile(mFilePath, file.getBytes());
				zbptAttachment = new ZbptAttachment();
				zbptAttachment.setRelationId(relationId);
				zbptAttachment.setAttachPath(mFilePath);
				zbptAttachment.setAttachName(fileOriginalName);
				zbptAttachment.setPictureType("1");
				zbptAttachment.setUploadUserId(user.getUserId());
				zbptAttachment.setUploadUserName(user.getUserName());
				zbptAttachment.setUploadTime(DateUtil.getDate());
				zbptAttachment.setAttachFileIdentifyName(decodeFileName);
				//保存
				zbptAttachmentManager.save(zbptAttachment);
				resMap.put("fileName", fileOriginalName);
				resMap.put("attachment", zbptAttachment);
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
	Map<String, Object> fileDelete(@RequestParam String fileId) throws IOException {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		ZbptAttachment zbptAttachment = zbptAttachmentManager.get(fileId);
		zbptAttachmentManager.removeById(fileId);
		String filePath = zbptAttachment.getAttachPath();
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
		ZbptAttachment zbptAttachment = zbptAttachmentManager.get(fileId);
		String filePath = zbptAttachment.getAttachPath();
		String fileName = zbptAttachment.getAttachName();
		FileUtil fileHelper = new FileUtil();
		fileHelper.downloadFile(filePath, request, response, fileName);
	}

	/**
	 * 图片展示
	 * @param relationId
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "pictureShow")
	public void pictureShow(@RequestParam(defaultValue = "") String relationId,@RequestParam(defaultValue = "") String rowId, HttpServletRequest request,
							 HttpServletResponse response) throws IOException {
		ZbptAttachment zbptAttachment = null;
		if(relationId.length() > 0){
			String hql = "from ZbptAttachment where relationId = ? and pictureType = ?";
			Object[] values = {relationId, "0"};
			zbptAttachment = zbptAttachmentManager.findUnique(hql, values);
		}
		if(rowId.length() > 0){
			zbptAttachment = zbptAttachmentManager.get(rowId);
		}
		String filePath = zbptAttachment.getAttachPath();
		System.out.println(filePath);
		String fileName = zbptAttachment.getAttachName();
		FileUtil fileHelper = new FileUtil();
		fileHelper.downloadFile(filePath, request, response, fileName);
	}

	/**
	 * 设置、取消列表图片
	 * @param fileId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("set-type")
	public @ResponseBody
	Map<String, Object> setType(@RequestParam String fileId,String flag) throws IOException {
		Map<String, Object> resMap = new HashMap<>();
		String statusCode = "200", message = "操作成功";
		try {
			ZbptAttachment zbptAttachment = zbptAttachmentManager.get(fileId);
			zbptAttachment.setPictureType(flag);
			zbptAttachmentManager.save(zbptAttachment);
		}catch (Exception e){
			e.printStackTrace();
			statusCode = "300";
			message = "操作失败";
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		return resMap;
	}


}
