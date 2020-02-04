package com.gx.user.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.spring.MessageHelper;
import com.gx.core.util.ServletUtils;
import com.gx.ext.auth.CurrentUserHolder;
import com.gx.user.persistence.domain.UserBase;
import com.gx.user.persistence.manager.UserAttrManager;
import com.gx.user.persistence.manager.UserBaseManager;
import com.gx.user.persistence.manager.UserSchemaManager;
import com.gx.user.service.UserService;
import com.gx.user.support.UserBaseWrapper;



import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("user")
public class ProfileController {
    private UserBaseManager userBaseManager;
    private MessageHelper messageHelper;
    private BeanMapper beanMapper = new BeanMapper();
    private UserBaseWrapper userBaseWrapper;
    private UserService userService;
//    private CurrentUserHolder currentUserHolder;

    @RequestMapping("profile-list")
    public String list(Model model) {
        UserBase userBase = userBaseManager.findUniqueBy("username",
        		"111111111111");
        UserBaseWrapper userBaseWrapper = new UserBaseWrapper(userBase);
        model.addAttribute("model", userBase);
        model.addAttribute("userBaseWrapper", userBaseWrapper);

        return "user/profile-list";
    }

    @RequestMapping("profile-save")
    public String save(@ModelAttribute UserBase userBase,
            @RequestParam("userRepoId") Long userRepoId,
            @RequestParam Map<String, Object> parameterMap,
            RedirectAttributes redirectAttributes) throws Exception {
        Map<String, Object> parameters = ServletUtils
                .getParametersStartingWith(parameterMap, "_user_attr_");
        Long id = userBase.getId();

        // 再进行数据复制
        UserBase dest = null;

        if (id != null) {
            dest = userBaseManager.get(id);
            beanMapper.copy(userBase, dest);
            userService.updateUser(dest, userRepoId, parameters);
        } else {
            dest = userBase;
            userService.insertUser(dest, userRepoId, parameters);
        }

        messageHelper.addFlashMessage(redirectAttributes, "core.success.save",
                "保存成功");

        return "redirect:/user/profile-list.do";
    }

    // ~ ======================================================================
    @Resource
    public void setUserBaseManager(UserBaseManager userBaseManager) {
        this.userBaseManager = userBaseManager;
    }

    @Resource
    public void setMessageHelper(MessageHelper messageHelper) {
        this.messageHelper = messageHelper;
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

//    @Resource
//    public void setCurrentUserHolder(CurrentUserHolder currentUserHolder) {
//        this.currentUserHolder = currentUserHolder;
//    }
}
