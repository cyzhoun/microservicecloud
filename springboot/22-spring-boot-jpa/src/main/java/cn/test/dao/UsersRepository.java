package cn.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.test.pojo.Users;


/**
 * 参数一:T  当前需要映射的实体
 * 参数二:ID 当前映射实体中的OID类型
 * @author chongyu
 *
 */
public interface UsersRepository extends JpaRepository<Users, Integer>{

}
