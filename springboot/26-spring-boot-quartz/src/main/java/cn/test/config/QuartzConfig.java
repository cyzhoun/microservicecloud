package cn.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import cn.test.quartz.QuartzDemo;

/**
 * Quartz 配置类
 * @author chongyu
 *
 */
@Configuration
public class QuartzConfig {

	/**
	 * 1.创建job对象
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean(){
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		
		// 关联自己的job
		factory.setJobClass(QuartzDemo.class);
		
		return factory;
	}
	
	/**
	 * 2.创建Trigger对象(简单的Trigger)
	 */
	/*@Bean
	public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
		SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
		
		// 关联jobdetail对象
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		
		// 该参数表示一个执行的毫秒数
		factory.setRepeatInterval(2000);
		
		// 重复次数
		factory.setRepeatCount(5);
		
		return factory;
	}*/
	
	/**
	 * 基于cron的定时
	 * @param jobDetailFactoryBean
	 * @return
	 */
	@Bean
	public CronTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
		CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
		
		// 关联jobdetail对象
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		
		// cron表达式
		factory.setCronExpression("0/3 * * * * ?");
		
		return factory;
	}

	/**
	 * 3.创建 scheduled对象
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory){
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		
		// 关联trigger
		factory.setTriggers(cronTriggerFactoryBean.getObject());
		factory.setJobFactory(myAdaptableJobFactory);
		
		return factory;
	}
}
