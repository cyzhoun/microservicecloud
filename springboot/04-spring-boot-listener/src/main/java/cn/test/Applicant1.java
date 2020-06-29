package cn.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * springboot 整合 listener 方式一
 * springboot 启动类
 * @author chongyu
 *
 */
@SpringBootApplication
@ServletComponentScan
public class Applicant1 {

	public static void main(String[] args) {
		SpringApplication.run(Applicant1.class, args);
	}
}
