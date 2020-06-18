package cn.test.springcloud.service;

import src.main.java.cn.test.springcloud.entities.Dept;

import java.util.List;

/**
 * <pre>
 * 	部门的业务层接口
 * </pre>
 *
 * @author ZhouChongyu
 * @version 1.0
 * @date 2020/6/11 - 15:39
 */
public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
