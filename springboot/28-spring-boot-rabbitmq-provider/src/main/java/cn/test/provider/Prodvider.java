package cn.test.provider;

import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cn.test.constants.MQConstants;
import cn.test.pojo.Users;

@Service
public class Prodvider {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	/**
	 * direct点对点模式生产者(定时任务)
	 * @return
	 */
	//@Scheduled(cron="0/5 * * * * ?")
	public void sendDirectMessageForScheduled() {
        Users users = new Users();
        users.setId(1);
        users.setName("hello direct");
        users.setAge(80);
        users.setGender("男");
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend(MQConstants.TEST_DIRECT_EXCHANGE,MQConstants.TEST_DIRECT_ROUTING, users);
        System.out.println("DirectProvider生产消息:"+new Date());
    }
	
	/**
	 * topic主题模式生产者(定时任务)
	 * @return
	 */
	//@Scheduled(cron="0/5 * * * * ?")
	public void sendTopicMessageForScheduledOne() {
        Users users = new Users();
        users.setId(1);
        users.setName("hello topic man");
        users.setAge(80);
        users.setGender("男");
        //将消息携带绑定键值：TestTopicRouting.Man 发送到交换机TestTopicExchange
        rabbitTemplate.convertAndSend(MQConstants.TEST_TOPIC_EXCHANGE,MQConstants.TEST_TOPIC_ROUTING_MAN, users);
        System.out.println("DirectProvider生产消息:"+new Date());
    }
	
	/**
	 * topic主题模式生产者(定时任务)
	 * @return
	 */
	//@Scheduled(cron="0/5 * * * * ?")
	public void sendTopicMessageForScheduledSecond() {
        Users users = new Users();
        users.setId(1);
        users.setName("hello topic woman");
        users.setAge(80);
        users.setGender("女");
        //将消息携带绑定键值：TestTopicRouting.# 发送到交换机TestTopicExchange
        rabbitTemplate.convertAndSend(MQConstants.TEST_TOPIC_EXCHANGE,MQConstants.TEST_TOPIC_ROUTING_UNKNOW, users);
        System.out.println("TopicProvider生产消息:"+new Date());
    }
	
	/**
	 * fanout扇形模式生产者(定时任务)
	 * @return
	 */
	@Scheduled(cron="0/5 * * * * ?")
	public void sendFanoutMessageForScheduled() {
        Users users = new Users();
        users.setId(1);
        users.setName("hello topic woman");
        users.setAge(80);
        users.setGender("女");
        // 发送到交换机TestFanoutExchange
        rabbitTemplate.convertAndSend(MQConstants.TEST_FANOUT_EXCHANGE,null, users);
        System.out.println("FanoutProvider生产消息:"+new Date());
    }
}
