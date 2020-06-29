package cn.test.dao;

import org.springframework.data.repository.CrudRepository;

import cn.test.pojo.Users;


/**
 * CrudRepository 接口的使用
 * @author chongyu
 *
 */
public interface UsersRepositoryCrudRepository extends CrudRepository<Users, Integer> {
	
}
