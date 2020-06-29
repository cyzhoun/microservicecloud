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
	
	/**
	 * java.lang.ArithmeticException
	 * 该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图的指定
	 * 参数Exception e:会将产生异常对象注入到方法中
	 */
	@ExceptionHandler(value={java.lang.ArithmeticException.class})
	public ModelAndView arithmeticException(Exception e){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("error", e.toString());
		modelAndView.setViewName("error2");
		return modelAndView;
	}
	
	/**
	 * java.lang.NullPointerException
	 * 该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图的指定
	 * 参数Exception e:会将产生异常对象注入到方法中
	 */
	@ExceptionHandler(value={java.lang.NullPointerException.class})
	public ModelAndView nullPointerException(Exception e){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("error", e.toString());
		modelAndView.setViewName("error3");
		return modelAndView;
	}
	
}
