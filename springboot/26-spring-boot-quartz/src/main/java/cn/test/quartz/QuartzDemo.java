package cn.test.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.test.service.UsersService;

/**
 * quartz定时任务测试类
 * @author chongyu
 *
 */
public class QuartzDemo implements Job {
	
	@Autowired
	private UsersService userService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		userService.usersQuartzTest();
	}

}
