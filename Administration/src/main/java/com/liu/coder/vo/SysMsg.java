package com.liu.coder.vo;

/**
 * Created by liuyidiao on 2017/7/6.
 */
public class SysMsg {
    /**
     * 0 登入成功
     * 1 用户名不存在
     * 2 密码错误
     *
     * 10 dept添加成功
     * 11 dept添加失败
     * 100 dept修改成功
     * 101 dept修改失败
     *
     * 200 dept 下面没有员工
     * 201 dept 下面有员工
     */

    private Integer msgCode;
    private String msg;

    public SysMsg() {
    }

    public Integer getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(Integer msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

















