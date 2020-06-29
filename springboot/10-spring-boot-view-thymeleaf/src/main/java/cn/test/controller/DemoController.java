package cn.test.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.test.pojo.Users;

/**
 * thymeleaf入门的demo
 * @author chongyu
 *
 */
@Controller
public class DemoController {

	@RequestMapping("show")
	public String showInfo(Model model){
		model.addAttribute("message", "Thymeleaf 的第一个案例");
		model.addAttribute("time", new Date());
		return "index";
	}
	
	/*
	 * thymeleaf对字符串操作
	 */
	@RequestMapping("show2")
	public String showInfo2(Model model){
		model.addAttribute("gender", "男");
		model.addAttribute("id", "1");
		return "index2";
	}
	
	/*
	 * thymeleaf对集合操作
	 * @param model
	 * @return
	 */
	@RequestMapping("show3")
	public String showInfo3(Model model){
		List<Users> userList = new ArrayList<Users>();
		userList.add(new Users(1,"张三",20));
		userList.add(new Users(2,"李四",21));
		userList.add(new Users(3,"王五",22));
		userList.add(new Users(4,"赵六",23));
		model.addAttribute("userList", userList);
		return "index3";
	}
	
	/*
	 * thymeleaf对hashmap操作
	 * @param model
	 * @return
	 */
	@RequestMapping("show4")
	public String showInfo4(Model model){
		Map<String,Users> userMap = new HashMap<String,Users>();
		userMap.put("a1",new Users(1,"张三",20));
		userMap.put("a2",new Users(2,"李四",21));
		userMap.put("a3",new Users(3,"王五",22));
		userMap.put("a4",new Users(4,"赵六",23));
		model.addAttribute("userMap", userMap);
		return "index4";
	}
	
	/*
	 * thymeleaf对域对象操作
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("show5")
	public String showInfo5(HttpServletRequest request, Model model){
		// HttpServletRequest
		request.setAttribute("rquest","httpServletRequest");
		
		// HttpSession
		request.getSession().setAttribute("sess", "httpsession");
		
		// ServletContext
		request.getSession().getServletContext().setAttribute("appli", "Application");
		return "index5";
	}
}
