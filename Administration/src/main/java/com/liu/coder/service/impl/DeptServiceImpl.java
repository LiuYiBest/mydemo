package com.liu.coder.service.impl;

import com.liu.coder.mapper.DeptMapper;
import com.liu.coder.mapper.EmpMapper;
import com.liu.coder.pojo.Dept;
import com.liu.coder.pojo.Emp;
import com.liu.coder.service.DeptService;
import com.liu.coder.utils.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liuyidiao on 2017/7/12.
 */


@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Resource(name = "deptMapper")
    private DeptMapper deptMapper;

    @Resource
    private EmpMapper empMapper;

    /**
     * 由配置文件读入值，由Spring框架提供支持
     */
    @Value("${page.size}")
    private Integer pageSize;

    @Override
    public int insert(Dept pojo) {
        return deptMapper.insert(pojo);
    }

    @Override
    public int insertSelective(Dept pojo) {
        return deptMapper.insertSelective(pojo);
    }

    @Override
    public int insertList(List<Dept> pojos) {
        return deptMapper.insertList(pojos);
    }

    @Override
    public int update(Dept pojo) {
        return deptMapper.update(pojo);
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public Page<Dept> findDeptByPage(Page<Dept> page) {
        // 获取 size
        page.setSize(pageSize);
        // 获取 total
        page.setTotal(deptMapper.count());
        page.setRows(deptMapper.findByPage(page));
        return page;
    }

    @Override
    public Dept findByDeptName(Dept dept) {
        return deptMapper.findBydeptName(dept.getDeptName());
    }

    @Override
    public Dept findByDeptId(Dept dept) {
        return deptMapper.findByDeptId(dept.getDeptId());
    }

    @Override
    public Dept findByDeptId(Integer deptId) {
        return deptMapper.findByDeptId(deptId);
    }

    /**
     * 按照 deptId
     * 先处理 dept 下面的 emp，将 emp 的 deptId 除去
     * 再删除 dept
     * 该方法需要事务支持
     *
     * @param deptId
     */
    @Override
    public void deleteByDeptId(Integer deptId) {
        if (empMapper.findByDepId(deptId).size() > 0) {
            //先保存 dept 下的 emp 信息，并移除每个 emp 下的 deptId
            List<Emp> empsNeedUpdateDepId = empMapper.findByDepId(deptId);
            for (Emp emp : empsNeedUpdateDepId) {
                emp.setDeptId(null);
            }
            //删除 dept 下的 emp
            int deleteRs = empMapper.deleteByDepId(deptId);
            //重新将 emp 加回去
            int addRs = empMapper.insertList(empsNeedUpdateDepId);
        }

        //然后删除 dept
        int deleteDeptRs = deptMapper.deleteByDeptId(deptId);
    }
}











