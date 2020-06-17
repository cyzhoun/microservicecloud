package cn.test.springcloud.controller;

import cn.test.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import src.main.java.cn.test.springcloud.entities.Dept;

import java.util.List;

/**
 * <pre>
 * 	客户端的部门查询controller
 * </pre>
 *
 * @author ZhouChongyu
 * @version 1.0
 * @date 2020/6/11 - 17:14
 */
@RestController
public class DeptControllerFeign {

    @Autowired
    private DeptClientService service;


    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.service.get(id);
    }


    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return this.service.list();
    }


    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept) {
        return this.service.add(dept);
    }
}
