package cn.test.constants;

/**
 * rabbitmq 配置常量
 * @author chongyu
 *
 */
public class MQConstants {

	// 交换机
	/**
	 * direct 点对点模式
	 * Exchange交换机
	 * direct测试交换机:TestDirectExchange
	 */
	public static final String TEST_DIRECT_EXCHANGE = "TestDirectExchange";
	
	/**
	 * topic 主题模式
	 * Exchange交换机
	 * topic测试交换机:TestTopicExchange
	 */
	public static final String TEST_TOPIC_EXCHANGE = "TestTopicExchange";
	
	/**
	 * fanout 扇形模式
	 * Exchange交换机
	 * fanout测试交换机:TestFanoutExchange
	 */
	public static final String TEST_FANOUT_EXCHANGE = "TestFanoutExchange";
	
	
	
	
	// 队列
	/**
	 * direct 点对点模式
	 * Queue 队列
	 * direct测试队列:TestDirectQueue
	 */
	public static final String TEST_DIRECT_QUEUE = "TestDirectQueue";
	
	/**
	 * topic 主题模式
	 * Queue 队列
	 * topic测试队列:TestTopicQueueMan
	 */
	public static final String TEST_TOPIC_QUEUE_MAN = "TestTopicQueueMan";
	
	/**
	 * topic 主题模式
	 * Queue 队列
	 * topic测试队列:TestTopicQueueWoman
	 */
	public static final String TEST_TOPIC_QUEUE_WOMAN = "TestTopicQueueWoman";
	
	/**
	 * fanout 扇形交换机
	 * Queue 队列
	 * fanout测试队列:Fanout.A
	 */
	public static final String TEST_FANOUT_QUEUE_A = "TestFanoutQueue.A";
	
	/**
	 * fanout 扇形交换机
	 * Queue 队列
	 * fanout测试队列:Fanout.B
	 */
	public static final String TEST_FANOUT_QUEUE_B = "TestFanoutQueue.B";
	
	/**
	 * fanout 扇形交换机
	 * Queue 队列
	 * fanout测试队列:Fanout.C
	 */
	public static final String TEST_FANOUT_QUEUE_C = "TestFanoutQueue.C";
	
	
	
	// 路由key的绑定关系
	/**
	 * direct 点对点模式
	 * Binding 绑定
	 * direct测试绑定关系:TestDirectRouting
	 */
	public static final String TEST_DIRECT_ROUTING = "TestDirectRouting";
	
	/**
	 * topic 主题模式
	 * Binding 绑定
	 * topic测试绑定关系:TestTopicRouting.Man
	 */
	public static final String TEST_TOPIC_ROUTING_MAN = "TestTopicRouting.Man";
	
	/**
	 * topic 主题模式
	 * Binding 绑定
	 * topic测试绑定关系:TestTopicRouting.Woman
	 */
	public static final String TEST_TOPIC_ROUTING_WOMAN = "TestTopicRouting.Woman";
	
	/**
	 * topic 主题模式
	 * Binding 绑定
	 * topic测试绑定关系:TestDirectRouting.#
	 */
	public static final String TEST_TOPIC_ROUTING_UNKNOW = "TestDirectRouting.#";
}
