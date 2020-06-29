package cn.test.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import cn.test.pojo.Users;

/**
 * Repository接口的方法名称命名查询
 * @author chongyu
 *
 */
public interface UsersRepositoryByName extends Repository<Users, Integer> {

	// 方法的名称必须要遵循驼峰式命名规则.findBy(关键字)+属性名称(首字母要大写)+查询条件(首字母要大写)
	List<Users> findByName(String name);
	
	// 并且-And   或者Or
	List<Users> findByNameAndAge(String name,Integer age);
	
	List<Users> findByNameLike(String name);
}
