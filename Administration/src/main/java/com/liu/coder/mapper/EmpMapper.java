package com.liu.coder.mapper;

import com.liu.coder.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpMapper {
    int insert(@Param("pojo") Emp pojo);

    int insertSelective(@Param("pojo") Emp pojo);

    int insertList(@Param("pojos") List<Emp> pojo);

    int update(@Param("pojo") Emp pojo);

    List<Emp> findAll();

	Integer countByDepId(@Param("deptId") Integer deptId);

    int deleteByDepId(@Param("deptId") Integer deptId);

    List<Emp> findByDepId(@Param("deptId") Integer deptId);



}
