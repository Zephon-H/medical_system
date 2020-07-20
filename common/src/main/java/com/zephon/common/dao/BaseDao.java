package com.zephon.common.dao;

import com.zephon.common.model.BaseModel;

import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.common.dao
 * @date 2020/7/12 上午9:18
 * @Copyright ©
 */
public interface BaseDao<M extends BaseModel> {
    List<M> findAll();
    M findById(String id);
    M findByCondition(M m);
    void insert(M m);
    void update(M m);
}
