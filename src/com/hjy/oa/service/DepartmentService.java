package com.hjy.oa.service;

import com.hjy.oa.dao.BaseDao;
import com.hjy.oa.entity.Department;

import java.util.List;

/**
 * Created by sheeran on 2017/3/18.
 */
public interface DepartmentService extends BaseDao<Department> {
//    List<Department> findAll();
//
//    void add(Department department);
//
//   Department finById(int parentid);
//
  void del(int did);
}
