package com.liu.coder.service.impl;

import com.liu.coder.mapper.EmpMapper;
import com.liu.coder.pojo.Emp;
import com.liu.coder.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("empService")
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public int insert(Emp pojo) {
        return empMapper.insert(pojo);
    }

    @Override
    public int insertSelective(Emp pojo) {
        return empMapper.insertSelective(pojo);
    }

    @Override
    public int insertList(List<Emp> pojos) {
        return empMapper.insertList(pojos);
    }

    @Override
    public int update(Emp pojo) {
        return empMapper.update(pojo);
    }

    @Override
    public int countByDepId(Integer deptId) {
        return empMapper.countByDepId(deptId);
    }
}
