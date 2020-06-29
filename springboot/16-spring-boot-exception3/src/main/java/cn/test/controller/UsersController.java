package cn.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * users的测试异常controller
 * @author chongyu
 *
 */
@Controller
public class UsersController {
	
	@RequestMapping("/showUser")
	public String showUsers1(){
		String str = null;
		str.length();
		return "index";
	}
	
	@RequestMapping("/showUser2")
	public String showUsers2(){
		int a = 1/0;
		return "index";
	}
}
