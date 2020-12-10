package cn.test.service;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class UsersService {

	public void usersQuartzTest(){
		System.out.println("定时任务触发"+new Date());
	}
}
