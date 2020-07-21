package com.zephon.doctor.dao;

import com.zephon.doctor.pojo.PresDrug;
import com.zephon.doctor.pojo.Prescription;
import org.springframework.stereotype.Repository;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.doctor.dao
 * @date 2020/7/16 上午9:46
 * @Copyright ©
 */
@Repository
public interface PrescriptionDao {

    void insert(PresDrug presDrug);

    void update(PresDrug presDrug);

    PresDrug findByDrugIdAndRecordId(PresDrug presDrug);

    void updateRecord(Prescription prescription);
}
