package cn.test.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 消息确认实现类,确认消息是否发送到交换机和队列
 * @author chongyu
 *
 */
@Configuration
public class RabbitConfig {

	/**
	 * ConfirmCallback 和RetrunCallback的监听器配置
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	public RabbitTemplate creatRabbitTemplate(ConnectionFactory connectionFactory){
		RabbitTemplate rabbitTemplate = new RabbitTemplate();
		rabbitTemplate.setConnectionFactory(connectionFactory);
		
		//设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
		rabbitTemplate.setMandatory(true);
		
		// 自定义json序列化规则
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		
		// ConfirmCallback回调函数判断消息是否发送到 Exchange(成功失败都回调)
		rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
			@Override
			public void confirm(CorrelationData correlationData, boolean ack, String cause) {
				System.out.println("ConfirmCallback:     "+"相关数据："+correlationData);
                System.out.println("ConfirmCallback:     "+"确认情况："+ack);
                System.out.println("ConfirmCallback:     "+"原因："+cause);
			}
		});
		
		// RetrunCallback回调函数判断消息是否发送到 Queue(失败时才回调)
		rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("ReturnCallback:     "+"消息："+message);
                System.out.println("ReturnCallback:     "+"回应码："+replyCode);
                System.out.println("ReturnCallback:     "+"回应信息："+replyText);
                System.out.println("ReturnCallback:     "+"交换机："+exchange);
                System.out.println("ReturnCallback:     "+"路由键："+routingKey);
            }
        });
		
		return rabbitTemplate;
	}
}
