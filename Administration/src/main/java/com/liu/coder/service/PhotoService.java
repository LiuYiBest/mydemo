package com.liu.coder.service;

import com.liu.coder.pojo.Photo;

import java.util.List;

/**
 * Created by liuyidiao on 2017/7/25.
 */
public interface PhotoService {

    int insert(Photo pojo);

    int insertSelective(Photo pojo);

    int insertList(List<Photo> pojos);

    int update(Photo pojo);
}
