package cn.test.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import src.main.java.cn.test.springcloud.entities.Dept;

import java.util.List;

/**
 * <pre>
 * 	部门的mapper接口
 * </pre>
 *
 * @author ZhouChongyu
 * @version 1.0
 * @date 2020/6/11 - 15:30
 */
@Mapper
public interface DeptMapper {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
