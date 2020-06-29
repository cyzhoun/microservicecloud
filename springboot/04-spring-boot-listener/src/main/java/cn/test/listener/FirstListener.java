package cn.test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * springboot 整合 listener 方式一
 * @author chongyu
 *
 */
@WebListener
public class FirstListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("listener----destroyed----");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("listener----init----");
	}

}
