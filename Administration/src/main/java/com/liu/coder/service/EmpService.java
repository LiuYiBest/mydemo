package com.liu.coder.service;

import com.liu.coder.pojo.Emp;

import java.util.List;

/**
 * Created by liuyidiao on 2017/7/25.
 */
public interface EmpService {

    int insert(Emp pojo);

    int insertSelective(Emp pojo);

    int insertList(List<Emp> pojos);

    int update(Emp pojo);

    int countByDepId(Integer deptId);
}
