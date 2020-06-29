package cn.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * springboot 启动类
 * @author chongyu
 *
 */
@SpringBootApplication
@EnableScheduling
public class Applicant {

	public static void main(String[] args) {
		SpringApplication.run(Applicant.class, args);
	}
}
