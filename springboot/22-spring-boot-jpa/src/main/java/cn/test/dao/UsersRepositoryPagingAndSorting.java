package cn.test.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.test.pojo.Users;


/**
 * PagingAndSortingRepository接口的使用
 * @author chongyu
 *
 */
public interface UsersRepositoryPagingAndSorting extends PagingAndSortingRepository<Users, Integer> {

}
