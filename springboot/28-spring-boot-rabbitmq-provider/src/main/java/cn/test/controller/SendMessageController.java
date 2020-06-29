package cn.test.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.test.pojo.Users;

/**
 * rabbitmq provider发送消息类
 * @author chongyu
 *
 */
@RestController
public class SendMessageController {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	/**
	 * direct点对点模式生产者(http请求)
	 * @return
	 */
	@RequestMapping("/sendDirectMessage")
	public String sendDirectMessage() {
        Users users = new Users();
        users.setId(1);
        users.setName("hello direct");
        users.setAge(80);
        users.setGender("男");
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", users);
        return "ok";
    }
}
