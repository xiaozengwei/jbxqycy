package com.gx.soft.sys.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.office.util.DateUtil;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.WechatRecord;
import com.gx.soft.sys.persistence.manager.SysUserManager;
import com.gx.soft.sys.persistence.manager.WechatRecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/11/4.
 */
@Controller
@RequestMapping("wechat")
public class WeChatController {
    @Autowired
    private SysUserManager sysUserManager;
    @Autowired
    private WechatRecordManager wechatRecordManager;

//  判断微信小程序是否登录成功   1成功   0失败
    @RequestMapping("login")
    @ResponseBody
    public String login(String userId,String pwd) {
        List<GxSysUser>gxSysUserList=new ArrayList<>();
        gxSysUserList=sysUserManager.find("from GxSysUser where userId=? and userEnName=?",userId,pwd);
        Timestamp ts = DateUtil.getDate();
        if(gxSysUserList.size()>0){
            return "1";
        }else{
            return "0";
        }
    }
//    获取人员列表
    @RequestMapping("user-list")
    public String viewList(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model){
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page = sysUserManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        return "sys/wechat/wechat-list";
    }

//  控制人是否有控制水电的权限
    @RequestMapping("save")
    public void save(String userId,Boolean checked){
        GxSysUser gxSysUser=null;
        gxSysUser=sysUserManager.findUniqueBy("userId",userId);
        gxSysUser.setDataStatus(checked==true?"1":"0");
        sysUserManager.save(gxSysUser);
    }

//    获取微信小程序操控水电的权限  1有权限  0没有权限
    @RequestMapping("get-quanxian")
    @ResponseBody
    public String getQuanXian(String userId){
        GxSysUser gxSysUser=null;
        gxSysUser=sysUserManager.findUniqueBy("userId",userId);
        if(gxSysUser!=null) {
            return gxSysUser.getDataStatus() == null ? "0" : gxSysUser.getDataStatus();
        }else{
            return "0";
        }
    }

//   保存微信小程序的操控水电的记录
    @RequestMapping("save-record")
    @ResponseBody
    public String saveRecord(String userId,String pwd,String status){
        Timestamp ts = DateUtil.getDate();
        WechatRecord wechatRecord=new WechatRecord();
        GxSysUser gxSysUser=null;
        gxSysUser=sysUserManager.findUniqueBy("userId",userId);
        if(gxSysUser!=null){
            wechatRecord.setUserId(userId);
            wechatRecord.setPassword(pwd);
            wechatRecord.setTime(ts);
            wechatRecord.setUserName(gxSysUser.getUserName());
            wechatRecord.setStatus(status);
            wechatRecordManager.save(wechatRecord);
        } else {
            return "0";
        }
        return "1";
    }
}
