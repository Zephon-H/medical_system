package com.zephon.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.common.model
 * @date 2020/7/12 上午9:13
 * @Copyright ©
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Employee extends BaseModel{
    private String username;
    private String password;
    private String name;
    private String phone;
    private Department department;
}
