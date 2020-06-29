package cn.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.test.pojo.Roles;

/**
 * RolesRepository
 * @author chongyu
 *
 */
public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
