package cn.test.scheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * scheduled定时任务
 * @author chongyu
 *
 */
@Component
public class ScheduledDemo {

	/**
	 * scheduled测试
	 */
	@Scheduled(cron="0/5 * * * * ?")
	public void testScheduled(){
		System.out.println("定时任务器触发"+new Date());
	}
}
