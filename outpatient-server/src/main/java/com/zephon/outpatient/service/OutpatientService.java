package com.zephon.outpatient.service;

import com.zephon.common.model.Employee;
import com.zephon.outpatient.dao.OutpatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.outpatient.service
 * @date 2020/7/20 下午8:09
 * @Copyright ©
 */
@Service
public class OutpatientService {

    @Autowired
    private OutpatientDao outpatientDao;

    public List<Employee> findByDepartId(String departId) {
        return outpatientDao.findByDepartId(departId);
    }
}
