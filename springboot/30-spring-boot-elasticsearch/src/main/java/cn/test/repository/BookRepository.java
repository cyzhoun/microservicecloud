package cn.test.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import cn.test.pojo.Book;

/**
 * BookRepository接口操作数据
 * @author issuser
 *
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer>{

	List<Book> findByBookNameLike(String bookName);
}
