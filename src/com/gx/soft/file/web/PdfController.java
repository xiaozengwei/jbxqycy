package com.gx.soft.file.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * pdf控制器
 * 
 * @author YING
 * @date 2016-1-13
 */
@Controller
@RequestMapping("pdf")
@SessionAttributes("user_session")
@Scope("prototype")
public class PdfController {

	/**
	 * pdf视图
	 * 
	 * @param file
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String viewPdf(String file, Model model) {
		model.addAttribute("file", file);
		return "pdfjs/viewer";

	}

}
