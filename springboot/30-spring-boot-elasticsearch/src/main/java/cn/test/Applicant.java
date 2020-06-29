package cn.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot 集成 ElasticSearch
 * @author chongyu
 * 1,Client节点新clusterNodes;clusterName
 * 2,ElasticSearchTemlapte操作es
 * 3,编写一个ElasticSearchRepository的子接口来操作ES;
 * 两种用法:
 * 	1,编写一个ElasticSearchRepository接口
 *
 */
@SpringBootApplication
public class Applicant {

	public static void main(String[] args) {
		SpringApplication.run(Applicant.class, args);
	}
}
