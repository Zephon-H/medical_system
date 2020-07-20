package com.zephon.doctor.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.doctor.pojo
 * @date 2020/7/16 上午9:37
 * @Copyright ©
 */
@Data
public class Prescription implements Serializable {
    private String recordId;
    private BigDecimal amount;
    private List<PresDrug> drugList;
}
