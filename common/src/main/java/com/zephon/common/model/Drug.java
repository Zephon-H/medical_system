package com.zephon.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.common.model
 * @date 2020/7/12 下午5:33
 * @Copyright ©
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Drug extends BaseModel{
    private String drugCode;
    private String drugName;
    private String unit;
    private BigDecimal price;
}
