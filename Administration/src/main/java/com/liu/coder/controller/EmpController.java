package com.liu.coder.controller;

import com.liu.coder.service.EmpService;
import com.liu.coder.vo.SysMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by liuyidiao on 2017/7/6.
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Resource
    private EmpService empService;

    @RequestMapping("/lookFk2dept/{deptId}")
    @ResponseBody
    public SysMsg lookFk2dept(@PathVariable Integer deptId) {
        SysMsg sysMsg = new SysMsg();
        int fks = empService.countByDepId(deptId);
        if (fks > 0) {//dept 下面有员工，msgCode = 201;无的话为 200
            sysMsg.setMsg("该部门下有员工！");
            sysMsg.setMsgCode(201);
        } else {
            sysMsg.setMsgCode(200);
        }
        return sysMsg;
    }

}

