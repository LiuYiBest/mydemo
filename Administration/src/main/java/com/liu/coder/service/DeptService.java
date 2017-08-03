package com.liu.coder.service;

import com.liu.coder.pojo.Dept;
import com.liu.coder.utils.Page;

import java.util.List;

/**
 * Created by liuyidiao on 2017/7/13.
 */
public interface DeptService{

     int insert(Dept pojo);

     int insertSelective(Dept pojo);

     int insertList(List<Dept> pojos);

     int update(Dept pojo);

     List<Dept> findAll();

     Page<Dept> findDeptByPage(Page<Dept> page);

     Dept findByDeptName(Dept dept);

     Dept findByDeptId(Dept dept);

     Dept findByDeptId(Integer deptId);

     void deleteByDeptId(Integer deptId);
}
