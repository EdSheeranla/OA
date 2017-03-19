package com.hjy.oa.service;

import com.hjy.oa.entity.Department;

import java.util.List;

/**
 * Created by sheeran on 2017/3/18.
 */
public interface DepartmentService {
    List<Department> findAll();

    void add(Department department);

    Department finById(int parentid);
}
