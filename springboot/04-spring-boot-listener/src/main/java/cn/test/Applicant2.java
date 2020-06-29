package cn.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;

import cn.test.listener.SecondListener;

/**
 * springboot 整合 listener 方式一
 * springboot 启动类
 * @author chongyu
 *
 */
@SpringBootApplication
public class Applicant2 {

	public static void main(String[] args) {
		SpringApplication.run(Applicant2.class, args);
	}
	
	public ServletListenerRegistrationBean<SecondListener> getServletListenerRegistrationBean(){
		SecondListener secondListener = new SecondListener();
		ServletListenerRegistrationBean<SecondListener> listenerBean = new ServletListenerRegistrationBean<SecondListener>(secondListener);
		return listenerBean;
	}
}
