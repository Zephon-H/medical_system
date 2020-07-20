package com.zephon.common.model;

import com.zephon.common.utils.IdGenerator;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.common.model
 * @date 2020/7/12 上午9:13
 * @Copyright ©
 */
@Data
public class BaseModel implements Serializable {
    private String id;
    private Date updateTime;
    private String delFlag;

    public void preInsert(IdGenerator idGenerator) {
        this.id = idGenerator.generateId();
        this.updateTime = new Date();
    }

    public void preUpdate() {
        this.updateTime = new Date();
    }
}
