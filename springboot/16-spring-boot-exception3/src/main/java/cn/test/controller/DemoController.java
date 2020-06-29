package cn.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * springboot异常处理1
 * 如果我们需要将所有的异常同一跳转到自定义的错误页面，
 * 需要再src/main/resources/templates目录下创建error.html页面。注意：名称必须叫error
 * @author chongyu
 *
 */
@Controller
public class DemoController {

	@RequestMapping("/show")
	public String showInfo(){
		String str = null;
		str.length();
		return "index";
	}
	
	@RequestMapping("/show2")
	public String showInfo2(){
		int i = 1/0;
		return "index";
	}
	

	
}
