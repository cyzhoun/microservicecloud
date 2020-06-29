package cn.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.test.dao.UsersRepository;
import cn.test.pojo.Users;

/**
 * UsersService接口实现类
 * @author chongyu
 *
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	@Cacheable(value="users")
	public List<Users> findUserAll() {
		return usersRepository.findAll();
	}

	@Override
	@Cacheable(value="users")
	public Users findUserById(Integer id) {
		return usersRepository.findOne(id);
	}

	@Override
	@Cacheable(value="users",key="#pageable.PageSize")
	public Page<Users> findUserByPage(Pageable pageable) {
		return usersRepository.findAll(pageable);
	}

	@Override
	@CacheEvict(value="users",allEntries=true)
	public void saveUser(Users users) {
		usersRepository.save(users);
	}

}
