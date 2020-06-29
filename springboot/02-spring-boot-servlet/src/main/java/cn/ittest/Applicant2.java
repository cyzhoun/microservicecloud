package cn.ittest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import cn.ittest.servlet.SecondServlet;

/**
 * servlet方式二
 * springboot的启动类
 * @author chongyu
 *
 */
@SpringBootApplication
public class Applicant2 {

	public static void main(String[] args) {
		SpringApplication.run(Applicant2.class, args);
	}
	
	@Bean
	public ServletRegistrationBean getServletRegistrationBean(){
		SecondServlet secondServlet = new SecondServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(secondServlet);
		servletRegistrationBean.addUrlMappings("/second");
		return servletRegistrationBean;
	}
}
