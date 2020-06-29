package cn.test.exception;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * 通过SimpleMappingExceptionResolver全局异常处理
 * @author chongyu
 *
 */
@Configuration
public class GlobalException {

	/**
	 * 该方法必须要有返回值。返回值类型必须是：SimpleMappingExceptionResolver
	 */
	@Bean
	public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		
		/**
		 * 参数一：异常的类型，注意必须是异常类型的全名
		 * 参数二：视图名称
		 */
		Properties mappings = new Properties();
		mappings.put("java.lang.ArithmeticException", "error2");
		mappings.put("java.lang.NullPointerException","error3");
		
		// 设置异常和视图映射信息
		resolver.setExceptionMappings(mappings);
		return resolver;
	}
}
