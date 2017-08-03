package com.liu.coder.mapper;

import com.liu.coder.pojo.Job;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobMapper {
    int insert(@Param("pojo") Job pojo);

    int insertSelective(@Param("pojo") Job pojo);

    int insertList(@Param("pojos") List<Job> pojo);

    int update(@Param("pojo") Job pojo);
}
