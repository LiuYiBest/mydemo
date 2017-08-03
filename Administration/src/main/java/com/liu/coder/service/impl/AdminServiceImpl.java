package com.liu.coder.service.impl;

import com.liu.coder.mapper.AdminMapper;
import com.liu.coder.pojo.Admin;
import com.liu.coder.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liuyidiao on 2017/7/15.
 */

@Service("adminService")
public class AdminServiceImpl implements AdminService{

    @Resource
    private AdminMapper adminMapper;

    public int insert(Admin pojo) {
        return adminMapper.insert(pojo);
    }

    public int insertSelective(Admin pojo) {
        return adminMapper.insertSelective(pojo);
    }

    public int insertList(List<Admin> pojos) {
        return adminMapper.insertList(pojos);
    }

    public int update(Admin pojo) {
        return adminMapper.update(pojo);
    }

    @Override
    public List<Admin> findAll(){
        return adminMapper.findAll();
    }

    @Override
    public Admin findByAdminName(String adminName) {
        return adminMapper.findByAdminName(adminName);
    }
}
