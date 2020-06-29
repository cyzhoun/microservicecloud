package cn.test.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

import cn.test.constants.MQConstants;


/**
 * 手动确认消息监听类 
 * 手动确认模式需要实现 ChannelAwareMessageListener
 * @author chongyu
 *
 */
@Service
public class MyAckReceiver implements ChannelAwareMessageListener{

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		long deliveryTag = message.getMessageProperties().getDeliveryTag();
		try {

			String messageBody = new String(message.getBody(),"UTF-8");
			if (MQConstants.TEST_FANOUT_QUEUE_A.equals(message.getMessageProperties().getConsumerQueue())) {
				System.out.println("手动ACK收到"+MQConstants.TEST_FANOUT_QUEUE_A+"的消息:" + messageBody);
			}else if (MQConstants.TEST_FANOUT_QUEUE_B.equals(message.getMessageProperties().getConsumerQueue())) {
				System.out.println("手动ACK收到"+MQConstants.TEST_FANOUT_QUEUE_B+"的消息:" + messageBody);
			}else if (MQConstants.TEST_FANOUT_QUEUE_C.equals(message.getMessageProperties().getConsumerQueue())) {
				System.out.println("手动ACK收到"+MQConstants.TEST_FANOUT_QUEUE_C+"的消息:" + messageBody);
			}
			
			// 确认消费
			channel.basicAck(deliveryTag, true);
			
			//channel.basicReject(deliveryTag, true);//为true会重新放回队列
		} catch (Exception e) {
			// 消息确认失败
			channel.basicReject(deliveryTag, false);
			e.printStackTrace();
		}
	}

	
}
