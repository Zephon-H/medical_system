package com.zephon.pub.service;

import com.zephon.common.model.Employee;
import com.zephon.common.service.BaseService;
import com.zephon.pub.dao.DepartmentDao;
import com.zephon.pub.dao.EmployeeDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.pub.service
 * @date 2020/7/12 上午10:58
 * @Copyright ©
 */
@Service
@CacheConfig(cacheNames = "employees")
public class EmployeeService extends BaseService<EmployeeDao, Employee> {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private DepartmentService departmentService;

    @Override
    @CacheEvict(allEntries = true)
    public Employee save(Employee employee) throws Exception {
        if(StringUtils.isBlank(employee.getId())){
            String username = employee.getUsername();
            Employee e = new Employee();
            e.setUsername(username);
            Employee res = null;
            try {
                res = findByCondition(e);
            } catch (Exception exception) {
//            exception.printStackTrace();
            }
            if(res!=null)throw new Exception("用户已存在");
        }
        String password = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(password);
        departmentService.save(employee.getDepartment());
        return super.save(employee);
    }

    @Override
    public Employee findByCondition(Employee condition) {
        if(StringUtils.isNotBlank(condition.getPassword())){
            condition.setPassword(passwordEncoder.encode(condition.getPassword()));
        }
        return super.findByCondition(condition);
    }

    public Employee authLogin(Employee condition) throws Exception{
        String password = condition.getPassword();
        condition.setPassword(null);
        Employee employee = dao.findByCondition(condition);
        if(passwordEncoder.matches(password,employee.getPassword())){
            return employee;
        }
        return null;
    }
}
