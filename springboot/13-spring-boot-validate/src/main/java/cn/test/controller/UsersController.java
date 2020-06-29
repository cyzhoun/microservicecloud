package cn.test.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.test.pojo.Users;

/**
 * 用户的controller
 * @author chongyu
 *
 */
@Controller
public class UsersController {

	/*
	 * 进入添加用户的界面
	 * 解决异常的方式。可以在跳转页面的方法中注入一个Uesrs对象。
	 * 注意：由于springmvc会将该对象放入到Model中传递。key的名称会使用该对象的驼峰式的命名规则来作为key。
	 * 参数的变量名需要与对象的名称相同。将首字母小写。
	 */
	@RequestMapping("/addUser")
	public String showPage(Users users){
		return "add";
	}
	
	/*
	 * 添加用户
	 * @Valid 开启对Users对象的数据校验
	 * BindingResult:封装了校验的结果
	 */
	@RequestMapping("/save")
	public String addUser(@Valid Users users,BindingResult result){
		if (result.hasErrors()) {
			return "add";
		}
		System.out.println(users);
		return "ok";
	}
}
