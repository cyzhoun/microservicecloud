package cn.test.mapper;

import java.util.List;

import cn.test.pojo.Users;

public interface UsersMapper {

	public void insertUser(Users users);
	
	public List<Users> selectUserAll();
	
	public Users selectUserById(Integer id);
	
	public void updateUser(Users users);
	
	public void deleteUser(Integer id);
}
