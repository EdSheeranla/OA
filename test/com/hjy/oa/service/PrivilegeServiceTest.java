package com.hjy.oa.service;

import com.hjy.oa.entity.Privilege;
import com.hjy.oa.service.impl.PrivilegeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by sheeran on 2017/3/22.
 */
public class PrivilegeServiceTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testFindAllTopByName() {
        PrivilegeService privilegeService= (PrivilegeService) ac.getBean("privilegeServiceImpl");
        List<Privilege> list=privilegeService.findAllTopByName("admin");

    }
}
