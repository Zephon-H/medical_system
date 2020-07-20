package com.zephon.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.common.model
 * @date 2020/7/12 下午6:24
 * @Copyright ©
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MedicalRecord extends BaseModel {
    private String name;
    private String gender;
    private Employee doctor;
    private Integer age;
    private Department department;
    private String contract;
    private String payStatus;
    private Date payTime;
    private Employee operator;
    private BigDecimal amount; // 总金额
    private Double selfPaying;
}
