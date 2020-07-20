package com.zephon.common.service;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zephon.common.dao.BaseDao;
import com.zephon.common.model.BaseModel;
import com.zephon.common.model.Employee;
import com.zephon.common.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.common.service
 * @date 2020/7/12 上午9:24
 * @Copyright ©
 */
public class BaseService<D extends BaseDao<M>,M extends BaseModel> {
    /**
     * 范型不能用@Resource
     */
    @Autowired
    protected D dao;

    private IdGenerator idGenerator = IdUtil::fastSimpleUUID;

    public List<M> findAll(){
        return dao.findAll();
    }
    public M findByCondition(M condition){
        M m = dao.findByCondition(condition);
        if("1".equals(m.getDelFlag())) {
            return null;
        }
        return m;
    }
    public M findById(String id){
        M m = dao.findById(id);
        if("1".equals(m.getDelFlag())){
            return null;
        }
        return m;
    }
    public M save(M m) throws Exception {
        if(m.getId()!=null){
            if("1".equals(m.getDelFlag())){
                throw new Exception("更新失败");
            }
            m.preUpdate();
            dao.update(m);
        }else{
            m.preInsert(idGenerator);
            dao.insert(m);
        }
        return m;
    }
    public void deleteById(String id) throws Exception {
        M m = this.findById(id);
        if("1".equals(m.getDelFlag())){
            throw new Exception("不存在");
        }
        m.setDelFlag("1");
        dao.update(m);
    }

    public PageInfo<M> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<M> list = this.findAll();
        return new PageInfo<>(list);
    }
}
