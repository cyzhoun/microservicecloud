package cn.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import cn.test.pojo.Users;


/**
 * Repository 的@Query注解的使用
 * @author chongyu
 *
 */
public interface UsersRepositoryQueryAnnotation extends Repository<Users, Integer> {
	
	@Query(" from Users where name=? ")
	List<Users> findByNameUseHQL(String name);
	
	@Query(value=" select * from t_users where name=? ",nativeQuery=true)
	List<Users> findByNameUseSQL(String name);
	
	@Query(" update Users set name=? where id=? ")
	@Modifying // 更新时需要加此注解
	void updateUserNameById(String name,Integer id);
}
