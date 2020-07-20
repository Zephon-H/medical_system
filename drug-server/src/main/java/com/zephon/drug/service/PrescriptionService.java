package com.zephon.drug.service;

import com.zephon.drug.dao.PrescriptionDao;
import com.zephon.drug.pojo.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.drug.service
 * @date 2020/7/17 下午2:21
 * @Copyright ©
 */
@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionDao prescriptionDao;

    public List<Prescription> findAll() {
        return prescriptionDao.findAll();
    }
}
