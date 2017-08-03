package com.liu.coder.service.impl;

import com.liu.coder.mapper.JobMapper;
import com.liu.coder.pojo.Job;
import com.liu.coder.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("jobService")
public class JobServiceImpl implements JobService {

    @Resource
    private JobMapper jobMapper;

    public int insert(Job pojo){
        return jobMapper.insert(pojo);
    }

    public int insertSelective(Job pojo){
        return jobMapper.insertSelective(pojo);
    }

    public int insertList(List<Job> pojos){
        return jobMapper.insertList(pojos);
    }

    public int update(Job pojo){
        return jobMapper.update(pojo);
    }
}
