package com.zephon.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.common.model
 * @date 2020/7/12 下午5:34
 * @Copyright ©
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Department extends BaseModel{
    private String departName;
    private String departCode;
}
