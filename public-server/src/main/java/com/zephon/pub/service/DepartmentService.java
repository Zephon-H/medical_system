package com.zephon.pub.service;

import com.zephon.common.model.Department;
import com.zephon.common.service.BaseService;
import com.zephon.pub.dao.DepartmentDao;
import org.springframework.stereotype.Service;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.pub.service
 * @date 2020/7/12 下午8:14
 * @Copyright ©
 */
@Service
public class DepartmentService extends BaseService<DepartmentDao, Department> {
    @Override
    public Department save(Department department) throws Exception {
        return super.save(department);
    }
}
