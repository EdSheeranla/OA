package com.hjy.oa.service.impl;

import com.hjy.oa.dao.DepartmentDao;
import com.hjy.oa.dao.Impl.BaseDaoImpl;
import com.hjy.oa.entity.Department;
import com.hjy.oa.service.DepartmentService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sheeran on 2017/3/18.
 */
@Component("departmentServiceImpl")
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentDao departmentDao;
    @Resource
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public Department finById(int parentid) {
        return departmentDao.findById(parentid);
    }

    @Override
    public void add(Department department) {
        departmentDao.add(department);
    }
}
