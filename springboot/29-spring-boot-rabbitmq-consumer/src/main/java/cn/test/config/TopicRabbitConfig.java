package cn.test.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.test.constants.MQConstants;

/**
 * topic 交换机,队列,绑定关系配置类
 * @author chongyu
 *
 */
@Configuration
public class TopicRabbitConfig {

	/**
	 * 创建队列1
	 * @return
	 */
	@Bean
	public Queue firstTopicQueue(){
		return new Queue(MQConstants.TEST_TOPIC_QUEUE_MAN, true);
	}
	
	/**
	 * 创建队列2
	 * @return
	 */
	@Bean
	public Queue secondTopicQueue(){
		return new Queue(MQConstants.TEST_TOPIC_QUEUE_WOMAN, true);
	}
	
	/**
	 * 创建交换机
	 * @return
	 */
	@Bean
	public TopicExchange topicExchange(){
		return new TopicExchange(MQConstants.TEST_TOPIC_EXCHANGE, true, false);
	}
	
	/**
	 * 创建绑定关系1
	 * 消息携带的路由键是TestDirectRouting.Man,会分发到该队列
	 */
	@Bean
	public Binding topicBinding(){
		return BindingBuilder.bind(firstTopicQueue()).to(topicExchange()).with(MQConstants.TEST_TOPIC_ROUTING_MAN);
	}
	
	/**
	 * 创建绑定关系2 模糊绑定
	 * 只要是消息携带的路由键是以TestDirectRouting.开头,都会分发到该队列
	 */
	@Bean
	public Binding topicBinding2(){
		return BindingBuilder.bind(firstTopicQueue()).to(topicExchange()).with(MQConstants.TEST_TOPIC_ROUTING_UNKNOW);
	}
	
	/**
	 * 创建绑定关系3 模糊绑定
	 * 只要是消息携带的路由键是以TestDirectRouting.开头,都会分发到该队列
	 */
	@Bean
	public Binding topicBinding3(){
		return BindingBuilder.bind(secondTopicQueue()).to(topicExchange()).with(MQConstants.TEST_TOPIC_ROUTING_UNKNOW);
	}
}
