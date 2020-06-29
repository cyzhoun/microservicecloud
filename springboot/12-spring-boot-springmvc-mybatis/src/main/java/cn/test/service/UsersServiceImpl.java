package cn.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.test.mapper.UsersMapper;
import cn.test.pojo.Users;

/**
 * 用户的service类
 * @author chongyu
 *
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;
	
	/*
	 * 插入用户信息
	 * @see cn.test.service.UsersService#insertUsers(cn.test.pojo.Users)
	 */
	@Override
	public void insertUsers(Users users) {
		usersMapper.insertUser(users);
	}

	/*
	 * 查询所有用户
	 * @see cn.test.service.UsersService#findUserAll()
	 */
	@Override
	public List<Users> selectUserAll() {
		return usersMapper.selectUserAll();
	}

	/*
	 * 通过id查用户
	 * @see cn.test.service.UsersService#selectUserById(java.lang.Integer)
	 */
	@Override
	public Users selectUserById(Integer id) {
		return usersMapper.selectUserById(id);
	}

	/*
	 * 通过ID更新用户信息
	 * @see cn.test.service.UsersService#editUser(cn.test.pojo.Users)
	 */
	@Override
	public void editUser(Users users) {
		usersMapper.updateUser(users);
	}

	/*
	 * 删除用户通过id
	 * @see cn.test.service.UsersService#deleteUser(java.lang.Integer)
	 */
	@Override
	public void deleteUser(Integer id) {
		usersMapper.deleteUser(id);
	}

}
