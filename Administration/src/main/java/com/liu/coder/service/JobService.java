package com.liu.coder.service;

import com.liu.coder.pojo.Job;

import java.util.List;

/**
 * Created by liuyidiao on 2017/7/25.
 */
public interface JobService {

    int insert(Job pojo);

    int insertSelective(Job pojo);

    int insertList(List<Job> pojos);

    int update(Job pojo);
}
