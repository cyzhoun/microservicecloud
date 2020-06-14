package cn.test.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <pre>
 * 	RestTemplate配置类
 * </pre>
 *
 * @author ZhouChongyu
 * @version 1.0
 * @date 2020/6/11 - 17:09
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced // ribbon负载均衡
    public RestTemplate getRestTemplate()
    {
         return new RestTemplate();
    }
}
