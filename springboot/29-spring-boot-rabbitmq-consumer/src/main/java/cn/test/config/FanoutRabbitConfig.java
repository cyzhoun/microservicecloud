package cn.test.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.test.constants.MQConstants;

/**
 * 扇形交换机Fanout配置类
 * @author chongyu
 *
 */
@Configuration
public class FanoutRabbitConfig {

	 /**
     *  创建三个队列 ：fanout.A   fanout.B  fanout.C
     *  将三个队列都绑定在交换机 fanoutExchange 上
     *  因为是扇型交换机, 路由键无需配置,配置也不起作用
     */
	@Bean
	public Queue fanoutQueueA(){
		return new Queue(MQConstants.TEST_FANOUT_QUEUE_A, true);
	}
	@Bean
	public Queue fanoutQueueB(){
		return new Queue(MQConstants.TEST_FANOUT_QUEUE_B, true);
	}
	@Bean
	public Queue fanoutQueueC(){
		return new Queue(MQConstants.TEST_FANOUT_QUEUE_C, true);
	}
	
	/**
	 * 扇形交换机
	 * @return
	 */
	@Bean
	public FanoutExchange fanoutExchange(){
		return new FanoutExchange(MQConstants.TEST_FANOUT_EXCHANGE, true, false);
	}
	
	/**
	 * 绑定关系
	 * @return
	 */
	@Bean
	public Binding fanoutBinding1(){
		return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
	}
	@Bean
	public Binding fanoutBinding2(){
		return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
	}
	@Bean
	public Binding fanoutBinding3(){
		return BindingBuilder.bind(fanoutQueueC()).to(fanoutExchange());
	}
}
