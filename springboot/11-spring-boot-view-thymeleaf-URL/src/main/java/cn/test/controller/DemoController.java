package cn.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;import ch.qos.logback.core.joran.conditional.IfAction;

/**
 * thymeleaf入门的demo
 * @author chongyu
 *
 */
@Controller
public class DemoController {

	@RequestMapping("/{page}")
	public String showInfo(@PathVariable String page){
		return page;
	}
	
	@RequestMapping("/show1")
	public String showInfo1(Integer id,String username){
		System.out.println("id:"+id+",username:"+username);
		return "show";
	}
}
