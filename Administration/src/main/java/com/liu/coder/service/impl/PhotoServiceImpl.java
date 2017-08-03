package com.liu.coder.service.impl;

import com.liu.coder.mapper.PhotoMapper;
import com.liu.coder.pojo.Photo;
import com.liu.coder.service.PhotoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("photoService")
public class PhotoServiceImpl implements PhotoService {

    @Resource
    private PhotoMapper photoMapper;

    public int insert(Photo pojo){
        return photoMapper.insert(pojo);
    }

    public int insertSelective(Photo pojo){
        return photoMapper.insertSelective(pojo);
    }

    public int insertList(List<Photo> pojos){
        return photoMapper.insertList(pojos);
    }

    public int update(Photo pojo){
        return photoMapper.update(pojo);
    }
}
