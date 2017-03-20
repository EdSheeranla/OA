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
public class DepartmentServiceImpl extends BaseDaoImpl<Department> implements DepartmentService{
    @Override
    public void del(int did) {
        Department department=findById(did);
        del(department);
    }
}
