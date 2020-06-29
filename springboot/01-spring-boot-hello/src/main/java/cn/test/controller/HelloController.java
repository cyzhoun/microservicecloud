package cn.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 学习springboot的第一天，hello world
 * @author chongyu
 *
 */
@Controller
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public Map<String,Object> showHelloWorld(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", "HelloWorld!");
		return map;
	}
}
