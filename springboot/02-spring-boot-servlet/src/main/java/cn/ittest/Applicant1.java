package cn.ittest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * servlet方式一
 * springboot的启动类
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
