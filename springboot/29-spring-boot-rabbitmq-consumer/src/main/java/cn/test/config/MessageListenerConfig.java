package cn.test.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.test.constants.MQConstants;
import cn.test.consumer.MyAckReceiver;

/**
 * 消费者接收到消息的消息确认机制(手动确认配置)
 * @author chongyu
 *
 */
@Configuration
public class MessageListenerConfig {

	@Autowired
	private CachingConnectionFactory cachingConnectionFactory;
	
	@Autowired
	private MyAckReceiver myAckReceiver;
	
	@Bean
	public SimpleMessageListenerContainer simpleMessageListenerContainer(){
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cachingConnectionFactory);
		container.setConcurrentConsumers(1);
		container.setMaxConcurrentConsumers(1);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);// RabbitMQ默认是自动确认，这里改为手动确认消息
		// 选用json作为转换方式
		container.setMessageConverter(new Jackson2JsonMessageConverter());
		
		// 设置一个队列
		//container.setQueueNames(MQConstants.TEST_DIRECT_QUEUE);
		
		//如果同时设置多个如下： 前提是队列都是必须已经创建存在的
        container.setQueueNames(MQConstants.TEST_FANOUT_QUEUE_A,MQConstants.TEST_FANOUT_QUEUE_B,MQConstants.TEST_FANOUT_QUEUE_C);
		
		//另一种设置队列的方法,如果使用这种情况,那么要设置多个,就使用addQueues
        //container.setQueues(new Queue("TestDirectQueue",true));
        //container.addQueues(new Queue("TestDirectQueue2",true));
        //container.addQueues(new Queue("TestDirectQueue3",true));
		
		container.setMessageListener(myAckReceiver);
		
		return container;
	}
	
}
