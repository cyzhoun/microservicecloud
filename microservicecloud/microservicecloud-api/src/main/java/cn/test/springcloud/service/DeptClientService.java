package cn.test.springcloud.service;

/**
 * <pre>
 * 	TODO: Fill this category with a brief description or other description.
 * </pre>
 *
 * @author ZhouChongyu
 * @version 1.0
 * @date 2020/6/17 - 14:57
 */

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-DEPT")
public interface DeptClientService {

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public src.main.java.cn.test.springcloud.entities.Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<src.main.java.cn.test.springcloud.entities.Dept> list();

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(src.main.java.cn.test.springcloud.entities.Dept dept);
}
