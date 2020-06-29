package cn.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.dao.UserDaoImpl;


/**
 * @author chongyu
 *
 */
@Service
public class UserServiceImpl {

	@Autowired
	private UserDaoImpl userDaoImpl;
	
	public void saveUers(){
		userDaoImpl.saveUsers();
	}
}
