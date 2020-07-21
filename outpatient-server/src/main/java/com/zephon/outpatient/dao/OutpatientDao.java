package com.zephon.outpatient.dao;

import com.zephon.common.model.Employee;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.outpatient.dao
 * @date 2020/7/20 下午8:09
 * @Copyright ©
 */
@Repository
public interface OutpatientDao {
    @Cacheable(cacheNames = {"employees"},key = "#p0",unless = "#result == null")
    List<Employee> findByDepartId(String departId);

    void updateMedicalRecord(String id, Date date);
}
