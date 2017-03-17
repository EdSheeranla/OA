package com.hjy.oa.service;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sheeran on 2017/3/17.
 */
public class ServiceTest {
    private ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void testEntity(){
        SessionFactory sessionFactory= (SessionFactory) ac.getBean("SessionFactory");
        System.out.println(sessionFactory);
    }
}
