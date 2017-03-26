package com.hjy.oa.dao;

import com.hjy.oa.entity.Privilege;

import java.util.List;

/**
 * Created by sheeran on 2017/3/17.
 */
public interface BaseDao <T>{
    T findById(Integer id);
    void update(T t);
    void del(T t);
    void add(T t);
    List<T> findAll();

}
