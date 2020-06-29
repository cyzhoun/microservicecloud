package cn.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.test.pojo.Users;

/**
 * springboot 整合 jsp
 * @author chongyu
 *
 */
@Controller
public class UserController {

	@RequestMapping("showUser")
	public String userList(Model model){
		List<Users> userList = new ArrayList<Users>();
		userList.add(new Users(1,"张三",21));
		userList.add(new Users(2,"张三",22));
		userList.add(new Users(3,"张三",23));
		userList.add(new Users(4,"张三",24));
		userList.add(new Users(5,"张三",25));
		userList.add(new Users(6,"张三",26));
		model.addAttribute("userList",userList);
		return "login.html";
	}
}
