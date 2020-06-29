package cn.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.test.pojo.Users;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Applicant.class})
public class RabbitTest {

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	private AmqpAdmin amqpAdmin;
	
	/**
	 * 1.exchange.direct 点对点
	 * 单播模式:点对点   发送数据(JDK默认的序列化规则)
	 * map集合
	 */
	@Test
	public void sendRabbitTest1(){
		
		// exchange:交换机,routingKey:路由,object:发送的消息体
		Map<String,String> sendMsg = new HashMap<String,String>();
		sendMsg.put("1", "rabbit mq hello");
		// 对象被默认序列化以后发送出去
		rabbitTemplate.convertAndSend("exchange.direct", "atguigu", sendMsg);
	}
	
	/**
	 * 1.exchange.direct 点对点
	 * 单播模式:点对点  接收数据(JDK默认的序列化规则)
	 *  map集合
	 */
	@Test
	public void receiveRabbitTest1(){
		
		Object receiveMsg = rabbitTemplate.receiveAndConvert("atguigu");
		System.out.println(receiveMsg.getClass());
		System.out.println(receiveMsg.toString());
	}
	
	/**
	 * 2.exchange.direct 点对点
	 * 单播模式:点对点   发送数据(json的序列化规则)
	 * 对象
	 */
	@Test
	public void sendRabbitTest2(){
		
		// exchange:交换机,routingKey:路由,object:发送的消息体
		Users users = new Users();
		users.setId(1);
		users.setName("哈哈哈");
		users.setAge(20);
		users.setGender("男");
		// 对象被默认序列化以后发送出去
		rabbitTemplate.convertAndSend("exchange.direct", "atguigu", users);
	}
	
	/**
	 * 2.exchange.direct 点对点
	 * 单播模式:点对点  接收数据(json的序列化规则)
	 *  对象
	 */
	@Test
	public void receiveRabbitTest2(){
		
		Object receiveMsg = rabbitTemplate.receiveAndConvert("atguigu");
		System.out.println(receiveMsg.getClass());
		System.out.println(receiveMsg.toString());
	}
	
	/**
	 * 3.exchange.fanout 广播模式
	 * 发送数据(json的序列化规则)
	 * 对象
	 */
	@Test
	public void sendRabbitTest3(){
		
		// exchange:交换机,routingKey:路由,object:发送的消息体
		Users users = new Users();
		users.setId(1);
		users.setName("哈哈哈");
		users.setAge(20);
		users.setGender("男");
		// 对象被默认序列化以后发送出去
		rabbitTemplate.convertAndSend("exchange.fanout", "", users);
	}
	
	/**
	 * 3.exchange.direct 广播模式
	 *  接收数据(json的序列化规则)
	 *  对象
	 */
	@Test
	public void receiveRabbitTest3(){
		
		Object receiveMsg = rabbitTemplate.receiveAndConvert("atguigu");
		System.out.println(receiveMsg.getClass());
		System.out.println(receiveMsg.toString());
	}
	
	
	
	/**
	 * 创建交换机
	 */
	@Test
	public void createExchange(){
		amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
	}
	
	/**
	 * 创建队列
	 */
	@Test
	public void createQueue(){
		amqpAdmin.declareQueue(new Queue("amqpAdmin.queue", true));
	}
	
	/**
	 * 绑定交换机和队列
	 */
	@Test
	public void createBinding(){
		amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", DestinationType.QUEUE, "amqpAdmin.exchange", "amqpAdmin.queue",null ));
	}
}
