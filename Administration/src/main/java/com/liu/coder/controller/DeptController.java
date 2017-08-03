package com.liu.coder.controller;

import com.liu.coder.pojo.Dept;
import com.liu.coder.service.DeptService;
import com.liu.coder.utils.Page;
import com.liu.coder.vo.SysMsg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by liuyidiao on 2017/7/25.
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Resource
    private DeptService deptService;

    /**
     * 不带 page 参数的页面，添加参数，然后请求转发
     */
    @RequestMapping("/view")
    public String firstView() {
        return "forward:/dept/view/1";  //请求转发
    }

    @RequestMapping("/view/{currPage}")
    public String view(@PathVariable Integer currPage, Model model) {
        Page<Dept> page = new Page<>();
        page.setCurrPage(currPage);
        deptService.findDeptByPage(page);
        model.addAttribute("viewPage", page);
        return "dept/deptview";
    }

    @RequestMapping("/add")
    public String add() {
        return "dept/addDept";
    }

    /**
     * 部门名称查重方法
     */
    @RequestMapping("/checkDeptName")
    @ResponseBody
    public SysMsg checkDeptName(Dept dept) {
        SysMsg sysMsg = new SysMsg();
        Dept deptInDB = deptService.findByDeptName(dept);
        if (deptInDB != null) {
            sysMsg.setMsg("部门名称已被占用！");
        } else {
            sysMsg.setMsg("✓");
        }
        return sysMsg;
    }

    /**
     * 部门编号查重方法
     */
    @RequestMapping("/checkDeptId")
    @ResponseBody
    public SysMsg checkDeptId(Dept dept) {
        SysMsg sysMsg = new SysMsg();
        Dept deptInDB = deptService.findByDeptId(dept);
        if (deptInDB != null) {
            sysMsg.setMsg("部门编号已被占用！");
        } else {
            sysMsg.setMsg("✓");
        }
        return sysMsg;
    }

    @RequestMapping("/doAdd")
    @ResponseBody
    public SysMsg doAdd(Dept dept) {
        SysMsg sysMsg = new SysMsg();
        int result = deptService.insert(dept);
        if (result > 0) {
            sysMsg.setMsgCode(10);
            sysMsg.setMsg("新部门添加成功！");
        } else {
            sysMsg.setMsgCode(11);
            sysMsg.setMsg("新部门添加失败！请修改后重新提交！");
        }
        return sysMsg;
    }

    /**
     * 不带 deptId 参数的页面，直接返回列表页
     */
    @RequestMapping("/update")
    public String update() {
        return "redirect:/dept/view";
    }

    @RequestMapping("/update/{deptId}")
    public String update(@PathVariable Integer deptId, Model model) {
        Dept deptInDB = deptService.findByDeptId(deptId);
        model.addAttribute("dept", deptInDB);
        return "dept/updateDept";
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public SysMsg doUpdate(Dept dept) {
        SysMsg sysMsg = new SysMsg();
        int result = deptService.update(dept);
        if (result > 0) {
            sysMsg.setMsgCode(100);//修改成功
            sysMsg.setMsg("部门信息修改成功！");
        } else {
            sysMsg.setMsgCode(101);
            sysMsg.setMsg("部门信息修改失败！请重试！");
        }
        return sysMsg;
    }

    @RequestMapping("/delete/{deptId}")
    @ResponseBody
    public SysMsg delete(@PathVariable Integer deptId) {
        SysMsg sysMsg = new SysMsg();
        try {
            deptService.deleteByDeptId(deptId);
        } catch (Exception e) {//删除失败
            e.printStackTrace();
            sysMsg.setMsg("删除失败！请稍后重试！");
            return sysMsg;
        }
        sysMsg.setMsg("删除成功！");
        return sysMsg;
    }

}


