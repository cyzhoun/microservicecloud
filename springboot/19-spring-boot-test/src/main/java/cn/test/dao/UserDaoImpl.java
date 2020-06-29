package cn.test.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl {
	
	public void saveUsers(){
		System.out.println("-----------user数据保存成功-------");
	}
}
