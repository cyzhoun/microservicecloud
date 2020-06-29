package cn.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * springboot 启动器
 * @author chongyu
 *
 */
@SpringBootApplication
@EnableCaching
public class Applicant {
	public static void main(String[] args) {
		SpringApplication.run(Applicant.class, args);
	}
}
