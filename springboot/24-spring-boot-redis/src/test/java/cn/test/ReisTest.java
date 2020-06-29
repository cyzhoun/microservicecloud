package cn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.test.pojo.Users;

/**
 * spring data redis测试
 * @author chongyu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Applicant.class)
public class ReisTest {
	
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	
	/**
	 * 添加一个字符串
	 */
	@Test
	public void testSet(){
		redisTemplate.opsForValue().set("redis", "hello world!");
	}
	
	/**
	 * 查找一个字符串
	 */
	@Test
	public void testGet(){
		String value = (String) redisTemplate.opsForValue().get("redis");
		System.out.println(value);
	}
	
	/**
	 * 添加Users对象到redis中
	 */
	@Test
	public void testSetUsers(){
		Users users = new Users();
		users.setId(1);
		users.setAge(20);
		users.setName("周一");
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.opsForValue().set("users", users);
	}
	
	/**
	 * 添加Users对象到redis中
	 */
	@Test
	public void testGetUsers(){
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		Users users = (Users) redisTemplate.opsForValue().get("users");
		System.out.println(users);
	}

	/**
	 * 基于json格式存user对象
	 */
	@Test
	public void testSetUsersUseJson(){
		Users users = new Users();
		users.setId(2);
		users.setAge(22);
		users.setName("周二");
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		redisTemplate.opsForValue().set("users", users);
	}
	
	/**
	 * 基于json格式取user对象
	 */
	@Test
	public void testGetUsersUseJson(){
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		Users users = (Users) redisTemplate.opsForValue().get("users");
		System.out.println(users);
	}
}
