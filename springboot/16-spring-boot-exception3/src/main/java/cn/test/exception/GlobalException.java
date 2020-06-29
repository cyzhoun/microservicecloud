package cn.test.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局处理异常类
 * @author chongyu
 *
 */
@ControllerAdvice
public class GlobalException {

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
}
