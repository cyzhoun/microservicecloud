package cn.test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**
 * spring data redis 配置类
 * 完成redis整合的一些配置
 * @author chongyu
 *
 */
@Configuration
public class RedisConfig {

	/**
	 * 1.创建JedisPoolConfig对象,在对象中完成一些链接池配置
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.redis.pool")
	public JedisPoolConfig jedisPoolConfig(){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		
		// 最大空闲数
		//jedisPoolConfig.setMaxIdle(10);
		
		// 最小空闲数
		//jedisPoolConfig.setMinIdle(5);
		
		// 最大连接数
		//jedisPoolConfig.setMaxTotal(20);
		
		return jedisPoolConfig;
	}
	
	/**
	 * 2.创建JedisConnectionFactory对象,配置redis连接信息
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.redis")
	public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		
		// 关联连接池的配置对象
		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
		
		// 配置连接redis的信息
		// 主机地址
		//jedisConnectionFactory.setHostName("127.0.0.1");
		//jedisConnectionFactory.setHostName("192.168.25.128");
		
		// 端口
		//jedisConnectionFactory.setPort(6379);
		
		return jedisConnectionFactory;
	}
	
	/**
	 * 3.创建RedisTemplate,用于执行redis操作的方法
	 */
	@Bean
	public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory){
		RedisTemplate<String,Object> redisTemplate = new RedisTemplate<String,Object>();
		
		// 关联
		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		
		// 为key配置序列化器
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		
		// 为value配置序列化器
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		
		return redisTemplate;
	}
}
