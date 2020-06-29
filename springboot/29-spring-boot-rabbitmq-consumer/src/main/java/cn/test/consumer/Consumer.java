package cn.test.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import cn.test.constants.MQConstants;
import cn.test.pojo.Users;

@Service
public class Consumer {
	
	/**/@RabbitListener(queues={MQConstants.TEST_DIRECT_QUEUE})
	public void directConsumer(Message message){
		System.out.println("消费者接受消息:"+message.toString());
	}
	
	/**
	 * direct 点对点模式消费者
	 * @param users
	 
	@RabbitListener(queues={MQConstants.TEST_DIRECT_QUEUE})
	public void directConsumer(Users users){
		System.out.println("DirectConsumer消费消息:"+users.toString());
	}*/
	
	/**
	 * topic 主题模式消费者 one
	 */
	@RabbitListener(queues={MQConstants.TEST_TOPIC_QUEUE_MAN})
	public void topicConsumer(Users users){
		System.out.println("TestTopicQueueMan消费消息:"+users.toString());
	}
	
	/**
	 * topic 主题模式消费者 two
	 */
	@RabbitListener(queues={MQConstants.TEST_TOPIC_QUEUE_WOMAN})
	public void topicConsumer2(Users users){
		System.out.println("TestTopicQueueWoman消费消息:"+users.toString());
	}
	
	/**
	 * fanout 扇形模式
	 */
	@RabbitListener(queues={MQConstants.TEST_FANOUT_QUEUE_A})
	public void fanoutConsumerA(Users users){
		System.out.println("TestFanoutQueueA消费消息:"+users.toString());
	}
	
	/**
	 * fanout 扇形模式
	 */
	@RabbitListener(queues={MQConstants.TEST_FANOUT_QUEUE_B})
	public void fanoutConsumerB(Users users){
		System.out.println("TestFanoutQueueB消费消息:"+users.toString());
	}
	
	/**
	 * fanout 扇形模式
	 */
	@RabbitListener(queues={MQConstants.TEST_FANOUT_QUEUE_C})
	public void fanoutConsumerC(Users users){
		System.out.println("TestFanoutQueueC消费消息:"+users.toString());
	}
}
