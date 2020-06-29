package cn.test.service;

import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.test.pojo.Book;
import cn.test.repository.BookRepository;

/**
 * book的业务层实现类
 * 
 * @author issuser
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	/**
	 * 保存book
	 */
	@Override
	public void save(Book book) {
		bookRepository.index(book);
	}

	/**
	 * 根据书名模糊查询图书
	 * 
	 * @param string
	 * @return
	 */
	@Override
	public List<Book> findByBookNameLike(String bookName) {
		return bookRepository.findByBookNameLike(bookName);
	}

	/**
	 * 查询所有
	 */
	@Override
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}

	/**
	 * 分页查询图书
	 * 
	 * @param keyword
	 * @param page
	 * @param size
	 */
	@Override
	public List<Book> findBookByPage(String keyword, int page, int size) {
		// 检验参数
		if (StringUtils.isEmpty(page)) {
			page = 0;
		}
		if (StringUtils.isEmpty(size)) {
			size = 10;
		}

		// 构造分页
		Pageable pageable = new PageRequest(page, size);

		// 构造查询
		NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder().withPageable(pageable);

		if (!StringUtils.isEmpty(keyword)) {
			// keyword must not null
			searchQueryBuilder.withQuery(QueryBuilders.queryStringQuery(keyword));
		}

		/*
		 * SearchQuery 这个很关键，这是搜索条件的入口， elasticsearchTemplate 会 使用它 进行搜索
		 */
		SearchQuery searchQuery = searchQueryBuilder.build();

		// page search
		Page<Book> phoneModelPage = elasticsearchTemplate.queryForPage(searchQuery, Book.class);

		return phoneModelPage.getContent();
	}

	/**
	 * 用ElasticsearchTemplate进行高级查询
	 * @param bookId	图书ID
	 * @param bookName	书名
	 * @param bookAuther	作者
	 * @param page 当前页，从0开始
	 * @param size 每页大小
	 */
	@Override
	public List<Book> advancedQuery(Integer bookId, String bookName, String bookAuther,Integer page,Integer size) {
		// 校验参数
		if (StringUtils.isEmpty(page) || page < 0)
			page = 0; // if page is null, page = 0

		if (StringUtils.isEmpty(size) || size < 0)
			size = 10; // if size is null, size default 10

		// 构造分页对象
		Pageable pageable = new PageRequest(page, size);

		// BoolQueryBuilder (Elasticsearch Query)
		BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
		if (!StringUtils.isEmpty(bookId)) {
			boolQueryBuilder.must(QueryBuilders.matchQuery("bookId", bookId));
		}

		if (!StringUtils.isEmpty(bookName)) {
			boolQueryBuilder.must(QueryBuilders.matchQuery("bookName", bookName));
		}

		if (!StringUtils.isEmpty(bookAuther)) {
			boolQueryBuilder.must(QueryBuilders.matchQuery("bookAuther", bookAuther));
		}

		// BoolQueryBuilder (Spring Query)
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable).withQuery(boolQueryBuilder).build();

		// page search
		Page<Book> bookPage = elasticsearchTemplate.queryForPage(searchQuery, Book.class);

		return bookPage.getContent();
	}
}
