package cn.test.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import cn.test.pojo.Users;

/**
 * 监听RabbitMQ消息
 * @author chongyu
 *
 */
@Service
public class UsersService{
	
	@RabbitListener(queues={"atguigu.news"})
	public void receive(Users users){
		System.out.println("atguigu.news队列收到消息!"+users);
	}
	
	@RabbitListener(queues={"atguigu"})
	public void receiveMessage(Message message){
		System.out.println("atguigu.news队列收到消息!"+message.getBody());
		System.out.println(message.getMessageProperties());
	}
}
