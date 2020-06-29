package cn.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.test.pojo.Book;
import cn.test.pojo.Users;
import cn.test.service.BookService;
import cn.test.service.UsersService;
import cn.test.utils.DateHomeUtil;


/**
 * ElasticSearch测试类
 * @author issuser
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Applicant.class})
public class ElasticSearchTest{
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UsersService usersService;

	
	/**
	 * ElasticSearch操作保存数据
	 */
	@Test
	public void testBookRepository(){
		// 创建book对象
		Book book = new Book();
		book.setBookId(12);
		book.setBookName("spring Date Elasticsearch 实战");
		book.setBookAuther("二三四");
		
		// 将book储存到elasticearch中
		bookService.save(book);
	}
	
	/**
	 * ElasticSearch操作查询数据通过书名
	 */
	@Test
	public void testFindBookByName(){
		List<Book> bookList = bookService.findByBookNameLike("西游");
		System.out.println(bookList);
	}
	
	/**
	 * ElasticSearch查询所有
	 */
	@Test
	public void testFindAll(){
		Iterable<Book> findAll = bookService.findAll();
		for (Book book : findAll) {
			System.out.println(book);
		}
	}
	
	/**
	 * 用ElasticsearchTemplate进行分页查询
	 */
	@Test
	public void testFindPage(){
		List<Book> bookList = bookService.findBookByPage("一二三",0,10);
		for (Book book : bookList) {
			System.out.println(book);
		}
	}
	
	/**
	 * 用ElasticsearchTemplate进行高级查询
	 * @param bookId	图书ID
	 * @param bookName	书名
	 * @param bookAuther	作者
	 * @param page 当前页，从0开始
	 * @param size 每页大小
	 */
	@Test
	public void testAdvancedQuery(){
		Integer bookId = null;
		String bookName = "spring";
		String bookAuther = "二三";
		Integer page = 0;
		Integer size = 10;
		List<Book> bookList = bookService.advancedQuery(bookId,bookName,bookAuther,page,size);
		for (Book book : bookList) {
			System.out.println(book);
		}
	}
	
	/**
	 * ElasticSearch操作保存数据
	 */
	@Test
	public void testUsrsRepository(){
		// 创建book对象
		Users users = new Users();
		users.setUserid(10);
		users.setUsername("星星之火");
		users.setAddress("上海市");
		users.setBirthday(DateHomeUtil.strToDate("2006-6-3 15:35:29","yyyy-MM-dd HH:mm:ss"));
		
		// 将book储存到elasticearch中
		usersService.save(users);
	}
	
	/**
	 * 用ElasticsearchTemplate进行高级查询(有时间区间的对象)
	 * @param userid	用户id
	 * @param username	用户名
	 * @param address	用户地址
	 * @param start		起始时间
	 * @param end		结束时间
	 * @param page 当前页，从0开始
	 * @param size 每页大小
	 */
	@Test
	public void testAdvancedQueryAndDate(){
		Integer userid = null;
		String username = "日期";
		String address = "北京市";
		String start = "2000-6-1 00:00:00";
		String end = "2003-6-2 00:00:00";
		Integer page = 0;
		Integer size = 10;
		List<Users> usersList = usersService.advancedQueryAndDate(userid,username,address,start,end,page,size);
		for (Users user : usersList) {
			System.out.println(user);
		}
	}
}
