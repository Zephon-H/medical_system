package com.zephon.doctor.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.doctor.pojo
 * @date 2020/7/16 上午9:41
 * @Copyright ©
 */
@Data
public class PresDrug implements Serializable {
    private String recordId;
    private String drugId;
    private Integer count;
}
