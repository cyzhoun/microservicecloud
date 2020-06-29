package cn.test.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.test.pojo.Users;

public interface UsersService {

	List<Users> findUserAll();
	
	Users findUserById(Integer id);
	
	Page<Users> findUserByPage(Pageable pageable);
	
	void saveUser(Users users);
}
