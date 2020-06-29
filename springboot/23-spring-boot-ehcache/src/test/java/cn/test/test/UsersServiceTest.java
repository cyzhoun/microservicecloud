package cn.test.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.test.Applicant;
import cn.test.pojo.Users;
import cn.test.service.UsersService;

/**
 * UsersService的测试类
 * @author chongyu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Applicant.class})
public class UsersServiceTest {
	
	@Autowired
	private UsersService usersService;

	@Test
	public void testFindUserById(){
		System.out.println("第一次查询"+usersService.findUserById(1));
		System.out.println("第二次查询"+usersService.findUserById(1));
	}
	
	/**
	 * 测试注解@Cacheable(value="users",key="#pageable.PageSize")
	 */
	@Test
	public void testFindUserByPage(){
		Pageable pageable = new PageRequest(0, 4);
		System.out.println("第一次查询"+usersService.findUserByPage(pageable).getTotalElements());
		
		System.out.println("第二次查询"+usersService.findUserByPage(pageable).getTotalElements());
		
		Pageable pageable1 = new PageRequest(1, 4);
		System.out.println("第三次查询"+usersService.findUserByPage(pageable1).getTotalElements());
	}
	
	/**
	 * 测试注解@CacheEvict(value="users",allEntries=true) 清除缓存中以users缓存策略缓存的对象
	 */
	@Test
	public void testFindAll(){
		System.out.println("第一次查询"+usersService.findUserAll().size());
		
		Users users = new Users();
		users.setAddress("河北省邯郸市");
		users.setAge(30);
		users.setName("赵国");
		usersService.saveUser(users);
		
		System.out.println("第一次查询"+usersService.findUserAll().size());
	}
}
