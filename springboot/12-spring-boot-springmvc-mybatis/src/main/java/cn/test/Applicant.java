package cn.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author chongyu
 *
 */
@SpringBootApplication
@MapperScan("cn.test.mapper")//@MapperScan 用户扫描MyBatis的Mapper接口
public class Applicant {

	public static void main(String[] args) {
		SpringApplication.run(Applicant.class, args);
	}
}
