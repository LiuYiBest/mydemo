package com.liu.coder.service;

import com.liu.coder.pojo.Admin;

import java.util.List;

/**
 * Created by liuyidiao on 2017/7/25.
 */

public interface AdminService {

    int insert (Admin pojo);

    int insertSelective(Admin pojo);

    int insertList(List<Admin> pojos);

    int update(Admin pojo);

    List<Admin> findAll();

    Admin findByAdminName(String adminName);
}
