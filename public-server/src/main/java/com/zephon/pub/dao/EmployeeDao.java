package com.zephon.pub.dao;

import com.zephon.common.dao.BaseDao;
import com.zephon.common.model.Employee;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.pub.dao
 * @date 2020/7/12 上午10:58
 * @Copyright ©
 */
@Repository
public interface EmployeeDao extends BaseDao<Employee> {
    @Override
    @Cacheable(cacheNames = {"employees"},key = "#p0.username",unless = "#result == null")
    Employee findByCondition(Employee employee);
}
