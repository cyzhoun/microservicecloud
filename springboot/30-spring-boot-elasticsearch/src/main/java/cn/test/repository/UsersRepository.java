package cn.test.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import cn.test.pojo.Users;

/**
 * UsersRepository接口操作数据
 * @author issuser
 *
 */
public interface UsersRepository extends ElasticsearchRepository<Users, Integer>{
	
}
