package cn.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.test.pojo.Users;
import cn.test.service.UsersService;

/**
 * 用户的controller类
 * @author chongyu
 *
 */

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	/*
	 * 页面跳转的方法
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
	/*
	 * 添加用户
	 */
	@RequestMapping("/addUsers")
	public String insertUsers(Users users){
		usersService.insertUsers(users);
		return "success";
	}
	
	/*
	 * 查询所有用户
	 */
	@RequestMapping("/findUserAll")
	public String findUserAll(Model model){
		List<Users> findUserAll = usersService.selectUserAll();
		model.addAttribute("userList", findUserAll);
		return "showUsers";
	}
	
	/*
	 * 通过id查询用户信息
	 */
	@RequestMapping("/findUserById")
	public String findUserById(Model model,Integer id){
		Users user = usersService.selectUserById(id);
		model.addAttribute("user", user);
		return "updateUser";
	}
	
	@RequestMapping("/editUser")
	public String editUser(Users users){
		usersService.editUser(users);
		return "success";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUserById(Integer id){
		usersService.deleteUser(id);
		return "redirect:/users/findUserAll";
	}
}
