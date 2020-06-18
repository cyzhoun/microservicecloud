package cn.test.springcloud.service.impl;

import cn.test.springcloud.mapper.DeptMapper;
import cn.test.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.java.cn.test.springcloud.entities.Dept;

import java.util.List;

/**
 * <pre>
 * 	操作部门的service层
 * </pre>
 *
 * @author ZhouChongyu
 * @version 1.0
 * @date 2020/6/11 - 15:49
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept findById(Long id) {
        return deptMapper.findById(id);
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
