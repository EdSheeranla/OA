package com.hjy.oa.service.impl;

import com.hjy.oa.dao.Impl.BaseDaoImpl;
import com.hjy.oa.entity.Forum;
import com.hjy.oa.entity.Topic;
import com.hjy.oa.service.ForumService;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sheeran on 2017/4/9.
 */
@Component("forumServiceImpl")
@Transactional
public class ForumServiceImpl extends BaseDaoImpl<Forum> implements ForumService {
    @Override
    public List<Topic> findTopicByPage(int id) {
        HibernateTemplate hibernateTemplate=getHibernateTemplate();

        return null;
    }
}
