package cn.test.service;

import java.util.List;

import cn.test.pojo.Users;

public interface UsersService {
	public void insertUsers(Users users);
	
	public List<Users> selectUserAll();
	
	public Users selectUserById(Integer id);
	
	public void editUser(Users users);
	
	public void deleteUser(Integer id);
}
