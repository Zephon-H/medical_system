package com.zephon.drug.pojo;

import com.zephon.common.model.Drug;
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
    private Drug drug;
    private Integer count;
}
