package com.zephon.doctor.service;

import com.zephon.doctor.dao.PrescriptionDao;
import com.zephon.doctor.pojo.PresDrug;
import com.zephon.doctor.pojo.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.doctor.service
 * @date 2020/7/16 上午9:46
 * @Copyright ©
 */
@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionDao prescriptionDao;

    public void save(Prescription prescription) {
        List<PresDrug> drugList = prescription.getDrugList();
        for (PresDrug presDrug : drugList) {
            prescriptionDao.insert(presDrug);
        }
        prescriptionDao.updateRecord(prescription);
    }
}
