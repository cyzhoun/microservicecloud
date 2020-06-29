package cn.test;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot 集成 rabbitmq
 * @author chongyu
 *
 */
@SpringBootApplication
@EnableRabbit // 开启rabbitmq的注解模式
public class Applicant {

	public static void main(String[] args) {
		SpringApplication.run(Applicant.class, args);
	}
}
