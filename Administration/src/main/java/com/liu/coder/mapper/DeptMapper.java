package com.liu.coder.mapper;

import com.liu.coder.utils.Page;
import com.liu.coder.pojo.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liuyidiao on 2017/7/25.
 */

@Repository("deptMapper")
public interface DeptMapper {
    int insert (@Param("pojo") Dept pojo);

    int insertSelective(@Param("pojo") Dept pojo);

    int insertList(@Param("pojos") List <Dept> pojo);

    int update(@Param("pojo") Dept pojo);

    List<Dept> findAll();

    List<Dept> findByPage(@Param("page") Page<Dept> page );

    Integer count();

    Dept findBydeptName(@Param("deptName") String deptName);

    Dept findByDeptId(@Param("deptId") Integer deptId);

    int deleteByDeptId(@Param("deptId") Integer deptId);
}
