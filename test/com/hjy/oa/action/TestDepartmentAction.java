package com.hjy.oa.action;

import com.hjy.oa.service.impl.DepartmentServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sheeran on 2017/3/20.
 */
public class TestDepartmentAction {
    private ApplicationContext ac=new ClassPathXmlApplicationContext("applictionContext.xml");
    @Test
    public void testDel(){
        DepartmentServiceImpl da= (DepartmentServiceImpl) ac.getBean("departmentServiceImpl");
    }

}
