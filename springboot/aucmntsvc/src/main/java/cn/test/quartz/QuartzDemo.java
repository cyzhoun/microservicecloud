package cn.test.quartz;

import cn.test.service.UsersService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * quartz定时任务测试类
 * @author chongyu
 *
 */
public class QuartzDemo extends QuartzJobBean {
	
	@Autowired
	private UsersService userService;


	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		userService.usersQuartzTest();
	}
}
