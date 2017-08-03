package com.liu.coder.controller;

import com.alibaba.fastjson.JSON;
import com.liu.coder.pojo.Admin;
import com.liu.coder.service.AdminService;
import com.liu.coder.utils.Md5Utils;
import com.liu.coder.vo.SysMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by liuyidiao on 2017/7/2.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping("/nav")
    public String nav() {
        return "admin/nav";
    }

    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/checkLogin")
    @ResponseBody
    public SysMsg checkLogin(Admin admin, HttpSession session) {
        System.out.println(JSON.toJSON(admin));
        System.out.println(Md5Utils.md5encrypt(admin.getAdminPwd()));
        Admin adminInDB = adminService.findByAdminName(admin.getAdminName());
        System.out.println(JSON.toJSON(adminInDB));
        SysMsg sysMsg = new SysMsg();
        if (adminInDB == null) {
            sysMsg.setMsgCode(1);
            sysMsg.setMsg("用户名不存在！");
        } else if (adminInDB.getAdminLevel() == admin.getAdminLevel()
                && adminInDB.getAdminPwd() != null
                && adminInDB.getAdminPwd().equals(Md5Utils.md5encrypt(admin.getAdminPwd()))) {
            sysMsg.setMsgCode(0);
            sysMsg.setMsg("登陆成功！");
            //绑定用户信息
            session.setAttribute("admin", adminInDB);
        } else {
            sysMsg.setMsgCode(2);
            sysMsg.setMsg("密码或管理级别错误！");
        }
        return sysMsg;
    }

}
