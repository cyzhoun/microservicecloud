package cn.test.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 通过实现HandlerExceptionResolver接口做全局异常处理
 * @author chongyu
 *
 */
@Configuration
public class GlobalException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		
		// 判断不同的异常类型,进行异常跳转
		if (exception instanceof ArithmeticException) {
			modelAndView.setViewName("error2");
		}
		if (exception instanceof NullPointerException) {
			modelAndView.setViewName("error3");
		}
		modelAndView.addObject("error", exception.toString());
		return modelAndView;
	}

	
}
