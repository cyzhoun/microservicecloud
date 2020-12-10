package cn.test.config;

import cn.test.quartz.QuartzDemo;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Quartz 配置类
 * @author chongyu
 *
 */
@Configuration
public class QuartzConfig {

	@Bean
	public JobDetail myJobDetail(){
		JobDetail jobDetail = JobBuilder.newJob(QuartzDemo.class)
				.withIdentity("myJobDetail")
				.storeDurably()
				.build();
		return jobDetail;
	}

	@Bean
	public Trigger myTrigger(){
		Trigger trigger = TriggerBuilder.newTrigger()
				.forJob("myJobDetail")
				.withIdentity("myTrigger")
				.startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? 2020"))
				.build();
		return trigger;
	}
}
