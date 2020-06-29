package cn.test.service;

import java.util.List;

import cn.test.pojo.Book;
import cn.test.pojo.Users;

/**
 * 用户查询的业务层接口
 * @author issuser
 *
 */
public interface UsersService {
	
	/**
	 * 保存users
	 * @param users
	 */
	void save(Users users);
	
	/**
	 * 用ElasticsearchTemplate进行高级查询(有时间区间的对象)
	 * @param userid
	 * @param username
	 * @param address
	 * @param start
	 * @param end
	 * @param page
	 * @param size
	 * @return
	 */
	List<Users> advancedQueryAndDate(Integer userid, String username, String address, String start, String end,Integer page, Integer size);

}
