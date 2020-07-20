package com.zephon.drug.dao;

import com.zephon.drug.pojo.Prescription;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.drug.dao
 * @date 2020/7/17 下午2:22
 * @Copyright ©
 */
@Repository
public interface PrescriptionDao {
    List<Prescription> findAll();
}
