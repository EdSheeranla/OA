package com.hjy.oa.action;

import com.hjy.oa.entity.Position;
import com.hjy.oa.service.PositionService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sheeran on 2017/3/17.
 */
public class TestPositionAction {
    ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void testAdd(){
        Position position=new Position();
        position.setName("bbb");
        position.setDescription("bbbb");
        PositionService positionService= (PositionService) ac.getBean("positionServiceImpl");
        positionService.add(position);
    }
}
