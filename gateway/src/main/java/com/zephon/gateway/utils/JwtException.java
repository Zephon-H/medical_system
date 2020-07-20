package com.zephon.gateway.utils;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.gateway.utils
 * @date 2020/7/12 下午2:17
 * @Copyright ©
 */
public class JwtException extends Exception {
    public JwtException(String message) {
        super(message);
    }
}