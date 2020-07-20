package com.zephon.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.common.pojo
 * @date 2020/7/12 上午9:53
 * @Copyright ©
 */
@Data
@NoArgsConstructor
public class Result implements Serializable {
    private String message;
    private Integer code;
    private Object data;

    public Result(String message, Integer code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public Result(String message, Integer code) {
        this(message,code,null);
    }
}
