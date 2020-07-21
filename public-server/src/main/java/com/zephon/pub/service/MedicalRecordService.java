package com.zephon.pub.service;

import com.zephon.common.model.Department;
import com.zephon.common.model.Employee;
import com.zephon.common.model.MedicalRecord;
import com.zephon.common.service.BaseService;
import com.zephon.pub.dao.DepartmentDao;
import com.zephon.pub.dao.EmployeeDao;
import com.zephon.pub.dao.MedicalRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.pub.service
 * @date 2020/7/16 上午8:45
 * @Copyright ©
 */
@Service
public class MedicalRecordService extends BaseService<MedicalRecordDao, MedicalRecord> {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Override
    public MedicalRecord save(MedicalRecord medicalRecord) throws Exception {
        try {
            Employee doctor = employeeService.findById(medicalRecord.getDoctor().getId());
            medicalRecord.setDoctor(doctor);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        try {
            Employee o = employeeService.findById(medicalRecord.getOperator().getId());
            medicalRecord.setOperator(o);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        try {
            Department d = departmentService.findById(medicalRecord.getDepartment().getId());
            medicalRecord.setDepartment(d);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return super.save(medicalRecord);
    }
}
