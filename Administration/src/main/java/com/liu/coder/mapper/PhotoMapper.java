package com.liu.coder.mapper;

import com.liu.coder.pojo.Photo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoMapper {
    int insert(@Param("pojo") Photo pojo);

    int insertSelective(@Param("pojo") Photo pojo);

    int insertList(@Param("pojos") List<Photo> pojo);

    int update(@Param("pojo") Photo pojo);
}
