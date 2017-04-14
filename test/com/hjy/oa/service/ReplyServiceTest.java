package com.hjy.oa.service;

import com.hjy.oa.dto.PageBean;
import com.hjy.oa.entity.Reply;
import com.hjy.oa.entity.Topic;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sheeran on 2017/4/12.
 */
public class ReplyServiceTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void testFindByPage() {
        ReplyService replyService= (ReplyService) ac.getBean("replyServiceImpl");
        PageBean<Reply> pageBean=new PageBean<Reply>(1,8);
        Topic topic= new Topic();
        topic.setId(7);
        replyService.findByPage(pageBean,topic);
    }
}
