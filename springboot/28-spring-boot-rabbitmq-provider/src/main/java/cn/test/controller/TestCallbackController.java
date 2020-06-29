package cn.test.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.test.pojo.Users;

/**
 * 测试ConfirmCallback和ReturnCallback回调函数的测试类
 * 先从总体的情况分析，推送消息存在四种情况：
 * ①消息推送到server，但是在server里找不到交换机
 * ②消息推送到server，找到交换机了，但是没找到队列
 * ③消息推送到sever，交换机和队列啥都没找到
 * ④消息推送成功
 * @author chongyu
 *
 */
@RestController
public class TestCallbackController {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	/**
	 * ①消息推送到server，但是在server里找不到交换机
	 *  结论： ①这种情况触发的是 ConfirmCallback 回调函数。
	 */
	@RequestMapping("/TestCallback1")
	public String TestCallback1(){
		Users users = new Users();
		users.setId(2);
		users.setAge(60);
		users.setGender("男");
		users.setName("周哈哈");
		rabbitTemplate.convertAndSend("no-exchange", "TestDirectRouting", users);
		return "ok";
	}
	
	/**
	 *  ②消息推送到server，找到交换机了，但是没找到队列
	 *  结论：②这种情况触发的是 ConfirmCallback和RetrunCallback两个回调函数
	 */
	@RequestMapping("/TestCallback2")
	public String TestCallback2(){
		Users users = new Users();
		users.setId(2);
		users.setAge(60);
		users.setGender("男");
		users.setName("周哈哈");
		rabbitTemplate.convertAndSend("TestDirectExchange", "no-queue", users);
		return "ok";
	}
	
	/**
	 * ③消息推送到sever，交换机和队列啥都没找到 
	 *   结论： ③这种情况触发的是 ConfirmCallback 回调函数。
	 */
	@RequestMapping("/TestCallback3")
	public String TestCallback3(){
		Users users = new Users();
		users.setId(2);
		users.setAge(60);
		users.setGender("男");
		users.setName("周哈哈");
		rabbitTemplate.convertAndSend("no-exchange", "no-queue", users);
		return "ok";
	}
	
	/**
	 *  ④消息推送成功
	 *  结论： ④这种情况触发的是 ConfirmCallback 回调函数。
	 */
	@RequestMapping("/TestCallback4")
	public String TestCallback4(){
		Users users = new Users();
		users.setId(2);
		users.setAge(60);
		users.setGender("男");
		users.setName("周哈哈");
		rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", users);
		return "ok";
	}
}
