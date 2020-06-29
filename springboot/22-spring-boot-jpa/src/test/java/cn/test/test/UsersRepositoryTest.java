package cn.test.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.test.Applicant;
import cn.test.dao.UsersRepository;
import cn.test.dao.UsersRepositoryByName;
import cn.test.dao.UsersRepositoryCrudRepository;
import cn.test.dao.UsersRepositoryPagingAndSorting;
import cn.test.dao.UsersRepositoryQueryAnnotation;
import cn.test.dao.UsersRepositorySecification;
import cn.test.pojo.Users;

/**
 * 测试类
 * @author chongyu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Applicant.class})
public class UsersRepositoryTest {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UsersRepositoryByName usersRepositoryByName;
	
	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	
	@Autowired
	private UsersRepositoryCrudRepository usersRepositoryCrudRepository;
	
	@Autowired
	private UsersRepositoryPagingAndSorting usersRepositoryPagingAndSorting;
	
	@Autowired
	private UsersRepositorySecification usersRepositorySecification;
	
	@Test
	public void userSave(){
		Users users = new Users();
		users.setAddress("河北廊坊市");
		users.setName("李四");
		users.setAge(24);
		usersRepository.save(users);
	}
	
	/**
	 * Repository方法名称命名测试
	 */
	@Test
	public void findByName(){
		List<Users> findByName = usersRepositoryByName.findByName("韩二");
		System.out.println(findByName.toString());
	}
	
	/**
	 * Repository方法名称命名测试
	 */
	@Test
	public void findByNameAndAge(){
		List<Users> findByName = usersRepositoryByName.findByNameAndAge("韩二",22);
		System.out.println(findByName.toString());
	}
	
	/**
	 * Repository方法名称命名测试
	 */
	@Test
	public void findByNameLike(){
		List<Users> findByName = usersRepositoryByName.findByNameLike("李%");
		System.out.println(findByName.toString());
	}
	
	/**
	 * Repository 的@query 注解的使用
	 */
	@Test
	public void testFindByNameUseHQL(){
		List<Users> findByName = usersRepositoryQueryAnnotation.findByNameUseHQL("周一");
		System.out.println(findByName.toString());
	}
	
	/**
	 * Repository 的@query 注解的使用
	 */
	@Test
	public void testFindByNameUseSQL(){
		List<Users> findByName = usersRepositoryQueryAnnotation.findByNameUseSQL("周一");
		System.out.println(findByName.toString());
	}
	
	/**
	 * Repository 的@query 注解的使用
	 */
	@Test
	@Transactional// @Test和@Transactional一起使用时,事务是自动回滚的
	@Rollback(false)// 取消事务回滚
	public void testUpdateUserNameById(){
		usersRepositoryQueryAnnotation.updateUserNameById("周周", 1);
		List<Users> findByName = usersRepositoryQueryAnnotation.findByNameUseSQL("周周");
		System.out.println(findByName.toString());
	}
	
	
	/**
	 * CrudRepository的使用
	 */
	@Test
	public void testCrudSave(){
		Users users = new Users();
		users.setAddress("河北省衡水市");
		users.setAge(30);
		users.setName("哈哈大哥");
		usersRepositoryCrudRepository.save(users);
		Iterable<Users> findAll = usersRepositoryCrudRepository.findAll();
		for (Users user : findAll) {
			System.out.println(user);
		}
	}
	
	/**
	 * CrudRepository的使用
	 */
	@Test
	public void testCrudUpdate(){
		Users users = new Users();
		users.setId(7);
		users.setAddress("河北省邢台市");
		users.setAge(35);
		users.setName("哈哈老弟");
		usersRepositoryCrudRepository.save(users);
		Iterable<Users> findAll = usersRepositoryCrudRepository.findAll();
		for (Users user : findAll) {
			System.out.println(user);
		}
	}
	
	/**
	 * CrudRepository的使用
	 */
	@Test
	public void testCrudFindOne(){
		Users user = usersRepositoryCrudRepository.findOne(7);
		System.out.println(user);
	}
	
	/**
	 * CrudRepository的使用
	 */
	@Test
	public void testCrudFindAll(){
		Iterable<Users> findAll = usersRepositoryCrudRepository.findAll();
		for (Users user : findAll) {
			System.out.println(user);
		}
	}
	
	/**
	 * CrudRepository的使用
	 */
	@Test
	public void testCrudDelete(){
		usersRepositoryCrudRepository.delete(7);
		Iterable<Users> findAll = usersRepositoryCrudRepository.findAll();
		for (Users user : findAll) {
			System.out.println(user);
		}
	}
	
	/**
	 * PagingAndSortingRepository的排序测试的使用
	 */
	@Test
	public void testPagingAndSortingRepositorySort(){
		// Order 定义排序规则
		Order order = new Order(Direction.DESC,"id");
		// Sort对象封装了排序规则
		Sort sort = new Sort(order);
		List<Users> userList = (List<Users>) usersRepositoryPagingAndSorting.findAll(sort);
		for (Users user : userList) {
			System.out.println(user);
		}
	}
	
	/**
	 * PagingAndSortingRepository的分页测试的使用
	 */
	@Test
	public void testPagingAndSortingRepositoryPage(){
		// Pageable:封装了分页的参数,page当前页,size每页显示的条数.注意:当前页是从0开始的.
		// PageRequest(page, size):page当前页,size每页显示的条数
		Pageable pageable = new PageRequest(0, 4);
		Page<Users> userPage = usersRepositoryPagingAndSorting.findAll(pageable);
		System.out.println("总条数"+userPage.getTotalElements());
		System.out.println("总页数"+userPage.getTotalPages());
		List<Users> userList = userPage.getContent();
		for (Users user : userList) {
			System.out.println(user);
		}
	}
	
	/**
	 * PagingAndSortingRepository的排序+分页测试的使用
	 */
	@Test
	public void testPagingAndSortingRepositoryPagingAndSorting(){
		Sort sort = new Sort(new Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(0, 4, sort);
		Page<Users> userPage = usersRepositoryPagingAndSorting.findAll(pageable);
		System.out.println("总条数"+userPage.getTotalElements());
		System.out.println("总页数"+userPage.getTotalPages());
		List<Users> userList = userPage.getContent();
		for (Users user : userList) {
			System.out.println(user);
		}
	}
	
	/**
	 * JpaRepository的排序测试的使用
	 */
	@Test
	public void testJpaRepositorySort(){
		// Order 定义排序规则
		Order order = new Order(Direction.DESC,"id");
		// Sort对象封装了排序规则
		Sort sort = new Sort(order);
		List<Users> userList = usersRepository.findAll(sort);
		for (Users user : userList) {
			System.out.println(user);
		}
	}
	
	/**
	 * JpaRepository的分页测试的使用
	 */
	@Test
	public void testJpaRepositoryPage(){
		// Pageable:封装了分页的参数,page当前页,size每页显示的条数.注意:当前页是从0开始的.
		// PageRequest(page, size):page当前页,size每页显示的条数
		Pageable pageable = new PageRequest(0, 4);
		Page<Users> userPage = usersRepository.findAll(pageable);
		System.out.println("总条数"+userPage.getTotalElements());
		System.out.println("总页数"+userPage.getTotalPages());
		List<Users> userList = userPage.getContent();
		for (Users user : userList) {
			System.out.println(user);
		}
	}
	
	/**
	 * JpaRepository的排序+分页测试的使用
	 */
	@Test
	public void testJpaRepositoryPagingAndSorting(){
		Sort sort = new Sort(new Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(0, 4, sort);
		Page<Users> userPage = usersRepository.findAll(pageable);
		System.out.println("总条数"+userPage.getTotalElements());
		System.out.println("总页数"+userPage.getTotalPages());
		List<Users> userList = userPage.getContent();
		for (Users user : userList) {
			System.out.println(user);
		}
	}
	
	
	/**
	 * JPASecificationExcutor 单条件测试
	 */
	@Test
	public void testJpaRepositorySecification1(){
		
		/*
		 * Specification<Users> 用于封装查询参数
		 * Root<Users> root :查询对象的属性的封装
		 * CriteriaQuery<?> query :封装了我们要执行的查询中的各个部分信息,select from order等
		 * CriteriaBuilder cb :查询条件的构造器,定义不同的查询条件
		 */
		Specification<Users> spec = new Specification<Users>(){
			
			// Predicate封装了单个查询条件
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// where name='';
				/**
				 * 参数一:参数的查询属性
				 * 参数二:条件的值
				 */
				Predicate pre = cb.equal(root.get("name"), "周一");
				return pre;
			}
		};
		
		List<Users> userList = usersRepositorySecification.findAll(spec);
		for (Users user : userList) {
			System.out.println(user);
		}
	}
	
	/**
	 * JPASecificationExcutor 多条件测试
	 */
	@Test
	public void testJpaRepositorySecification2(){
		
		/*
		 * Specification<Users> 用于封装查询参数
		 * Root<Users> root :查询对象的属性的封装
		 * CriteriaQuery<?> query :封装了我们要执行的查询中的各个部分信息,select from order等
		 * CriteriaBuilder cb :查询条件的构造器,定义不同的查询条件
		 */
		Specification<Users> spec = new Specification<Users>(){
			
			// Predicate封装了单个查询条件
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// where name='' and age='';
				ArrayList<Predicate> preList = new ArrayList<Predicate>();
				preList.add(cb.equal(root.get("name"), "周一"));
				preList.add(cb.equal(root.get("age"), 21));
				Predicate[] preArray = new Predicate[preList.size()];
				return cb.and(preList.toArray(preArray));
			}
		};
		
		List<Users> userList = usersRepositorySecification.findAll(spec);
		for (Users user : userList) {
			System.out.println(user);
		}
	}
	
	/**
	 * JPASecificationExcutor 多条件查询第二种方法
	 */
	@Test
	public void testJpaRepositorySecification3(){
		
		/*
		 * Specification<Users> 用于封装查询参数
		 * Root<Users> root :查询对象的属性的封装
		 * CriteriaQuery<?> query :封装了我们要执行的查询中的各个部分信息,select from order等
		 * CriteriaBuilder cb :查询条件的构造器,定义不同的查询条件
		 */
		Specification<Users> spec = new Specification<Users>(){
			
			// Predicate封装了单个查询条件
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// where name='' and age='';
				/*ArrayList<Predicate> preList = new ArrayList<Predicate>();
				preList.add(cb.equal(root.get("name"), "周一"));
				preList.add(cb.equal(root.get("age"), 21));
				Predicate[] preArray = new Predicate[preList.size()];
				return cb.and(preList.toArray(preArray));*/
				return cb.or(cb.equal(root.get("name"), "周一"),cb.equal(root.get("age"), 21));
			}
		};
		Sort sort = new Sort(new Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(0, 4, sort);
		Page<Users> findAll = usersRepositorySecification.findAll(spec, pageable);
		for (Users user : findAll.getContent()) {
			System.out.println(user);
		}
	}
}
