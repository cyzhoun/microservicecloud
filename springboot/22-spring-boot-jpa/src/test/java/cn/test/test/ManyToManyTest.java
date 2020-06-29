package cn.test.test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.test.Applicant;
import cn.test.dao.RolesRepository;
import cn.test.pojo.Menus;
import cn.test.pojo.Roles;

/**
 * 多对多关系映射的测试类
 * @author chongyu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Applicant.class)
public class ManyToManyTest {

	@Autowired
	private RolesRepository rolesRepository;
	
	/**
	 * 添加测试
	 */
	@Test
	public void manyToManyTest1(){
		// 创建角色队形
		Roles roles = new Roles();
		roles.setRolename("项目经理");
		// 创建菜单对象
		Menus menus = new Menus();
		menus.setMenusname("xxx管理系统");
		menus.setFatherid(0);
		Menus menus1 = new Menus();
		menus1.setMenusname("项目系统");
		menus1.setFatherid(1);
		// 多对多关系
		menus.getRoles().add(roles);
		menus1.getRoles().add(roles);
		roles.getMenus().add(menus);
		roles.getMenus().add(menus1);
		// 保存
		rolesRepository.save(roles);
	}
	
	/**
	 * 查询操作
	 */
	@Test
	public void manyToManyTest2(){
		Roles roles = rolesRepository.findOne(3);
		System.out.println(roles.getRolename());
		Set<Menus> menusSet = roles.getMenus();
		for (Menus menus : menusSet) {
			System.out.println(menus);
		}
	}
}
