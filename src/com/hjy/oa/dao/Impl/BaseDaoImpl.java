package com.hjy.oa.dao.Impl;

import com.hjy.oa.dao.BaseDao;
import com.hjy.oa.entity.Privilege;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by sheeran on 2017/3/17.
 * 基础Dao 实现了增删改查功能
 */
@Component("baseDaoImpl")
@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao<T>{
    private HibernateTemplate hibernateTemplate;
    private Class<T> clazz;
    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public BaseDaoImpl() {
        //这里通过反射机制来获取了泛型所代表的真实类型
        ParameterizedType pt= (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class) (pt.getActualTypeArguments())[0];
    }

    @Override
    public T findById(Integer id) {
        return hibernateTemplate.load( clazz,id);
    }

    @Override
    public void update(T t) {
        hibernateTemplate.update(t);
    }

    @Override
    public void del(T t) {
        hibernateTemplate.delete(t);
    }

    @Override
    public void add(T t) {
        hibernateTemplate.save(t);
    }
    @Override
    public List<T> findAll() {
        return (List<T>) hibernateTemplate.find("from "+clazz.getSimpleName());
    }


}
