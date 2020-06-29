package cn.test.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.test.Applicant;
import cn.test.dao.UsersRepository;
import cn.test.pojo.Roles;
import cn.test.pojo.Users;

/**
 * 一对多关联关系测试类
 * @author chongyu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Applicant.class})
public class OneToManyTest {
	
	@Autowired
	private UsersRepository usersRepository;

	/**
	 * 一对多关联关系的保存测试
	 */
	@Test
	public void testSave(){
		// 创建一个用户
		Users users = new Users();
		users.setAge(30);
		users.setAddress("河北省沧州市");
		users.setName("小沧州");
		// 创建一个角色
		Roles roles = new Roles();
		roles.setRolename("管理员");
		// 关联
		users.setRoles(roles);
		roles.getUsers().add(users);
		// 保存
		usersRepository.save(users);
	}
	
	/**
	 * 一对多关联关系的查询测试
	 */
	@Test
	public void testFind(){
		Users findOne = usersRepository.findOne(8);
		System.out.println("用户:" + findOne);
		Roles roles = findOne.getRoles();
		System.out.println("角色:" + roles);
	}
}
