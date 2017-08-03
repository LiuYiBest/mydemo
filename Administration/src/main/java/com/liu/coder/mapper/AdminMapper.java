package com.liu.coder.mapper;

import com.liu.coder.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liuyidiao on 2017/7/25.
 */

@Repository
public interface AdminMapper {
        int insert(@Param("pojo")Admin pojo);

        int insertSelective(@Param("pojo") Admin pojo);

        int insertList(@Param("pojos") List<Admin> pojo);

        int update (@Param("pojo") Admin pojo);

        List<Admin> findAll();

        Admin findByAdminName(@Param("adminName") String adminName);
}
