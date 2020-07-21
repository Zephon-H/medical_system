package com.zephon.outpatient.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.drug.pojo
 * @date 2020/7/17 下午2:23
 * @Copyright ©
 */
@Data
public class Prescription implements Serializable {
    private String recordId;
    private List<PresDrug> drugList;
}
