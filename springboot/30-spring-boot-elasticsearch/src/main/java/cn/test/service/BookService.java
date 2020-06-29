package cn.test.service;

import java.util.List;

import cn.test.pojo.Book;

/**
 * 操作图书的业务层接口
 * @author issuser
 *
 */
public interface BookService {

	/**
	 * 保存book
	 * @param book
	 */
	void save(Book book);

	/**
	 * 根据书名模糊查询图书
	 * @param string
	 * @return
	 */
	List<Book> findByBookNameLike(String bookName);

	/**
	 * 查询所有
	 * @param string
	 * @return
	 */
	Iterable<Book> findAll();

	/**
	 * 分页查询图书
	 * @param keyword
	 * @param page
	 * @param size
	 */
	List<Book> findBookByPage(String keyword, int page, int size);

	/**
	 * 用ElasticsearchTemplate进行高级查询
	 * @param bookId	图书ID
	 * @param bookName	书名
	 * @param bookAuther	作者
	 * @param page 当前页，从0开始
	 * @param size 每页大小
	 */
	List<Book> advancedQuery(Integer bookId, String bookName, String bookAuther, Integer page, Integer size);
}
