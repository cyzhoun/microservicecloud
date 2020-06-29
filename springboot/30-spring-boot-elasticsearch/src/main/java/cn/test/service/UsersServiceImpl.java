package cn.test.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import cn.test.pojo.Users;
import cn.test.repository.UsersRepository;
import cn.test.utils.DateHomeUtil;

/**
 * 业务层
 * 
 * @author issuser
 *
 */
@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	@Autowired
	private UsersRepository usersRepository;

	/**
	 * 用ElasticsearchTemplate进行高级查询(有时间区间的对象)
	 * 
	 * @param userid
	 * @param username
	 * @param address
	 * @param start
	 * @param end
	 * @param page
	 * @param size
	 * @return
	 */
	@Override
	public List<Users> advancedQueryAndDate(Integer userid, String username, String address, String start, String end,
			Integer page, Integer size) {
		// 校验参数
		if (StringUtils.isEmpty(page) || page < 0)
			page = 0; // if page is null, page = 0

		if (StringUtils.isEmpty(size) || size < 0)
			size = 10; // if size is null, size default 10

		// 构造分页对象
		Pageable pageable = new PageRequest(page, size);

		// BoolQueryBuilder (Elasticsearch Query)
		BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
		if (!StringUtils.isEmpty(userid)) {
			boolQueryBuilder.must(QueryBuilders.matchQuery("userid", userid));
		}

		if (!StringUtils.isEmpty(username)) {
			boolQueryBuilder.must(QueryBuilders.matchQuery("username", username));
		}

		if (!StringUtils.isEmpty(address)) {
			boolQueryBuilder.must(QueryBuilders.matchQuery("address", address));
		}

		// 对出生年月进行区间查询
		if (!StringUtils.isEmpty(start)) {// 最小时间
			Date startTime = DateHomeUtil.strToDate(start, "yyyy-MM-dd HH:mm:ss");
			boolQueryBuilder.must(QueryBuilders.rangeQuery("birthday").lt(startTime.getTime()));
		}

		if (!StringUtils.isEmpty(end)) {// 最大时间
			Date endTime = DateHomeUtil.strToDate(end, "yyyy-MM-dd HH:mm:ss");
			boolQueryBuilder.must(QueryBuilders.rangeQuery("birthday").gt(endTime.getTime()));
		}
		// BoolQueryBuilder (Spring Query)
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable).withQuery(boolQueryBuilder).build();

		// page search
		Page<Users> usersPage = elasticsearchTemplate.queryForPage(searchQuery, Users.class);

		return usersPage.getContent();
	}

	/**
	 * 保存users
	 * @param users
	 */
	@Override
	public void save(Users users) {
		usersRepository.index(users);
	}

}
