package cn.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.test.pojo.Users;


/**
 * JpaSpecificationExecutor 测试类
 * @author chongyu
 *
 */
public interface UsersRepositorySecification extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

}
