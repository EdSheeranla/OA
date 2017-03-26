package com.hjy.oa.service.impl;

import com.hjy.oa.dao.Impl.BaseDaoImpl;
import com.hjy.oa.entity.Forum;
import com.hjy.oa.service.ForumManageService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sheeran on 2017/3/26.
 */
@Transactional
@Component("forumManageServiceImpl")
@SuppressWarnings("nochecked")
public class ForumManageServiceImpl extends BaseDaoImpl<Forum> implements ForumManageService {
    HibernateTemplate hibernateTemplate=null;
    Session session=null;
    @Override
    public void add(Forum forum) {
        hibernateTemplate=getHibernateTemplate();
        hibernateTemplate.save(forum);
        forum.setPosition(forum.getId());
    }
    public void moveUp(Forum forum){
        getCurrentSession();
        String hql="FROM Forum where position < ? order by position DESC ";
        Forum upForum = getForum(forum, hql);
        if(upForum==null)
            return;
        exchange(forum, upForum);
    }

    @Override
    public void moveDown(Forum forum) {
        getCurrentSession();;
        String hql="FROM Forum where position > ? order by position ";
        Forum downForum = getForum(forum,hql);
        if(downForum==null)
            return;
        exchange(forum,downForum);
    }

    @Override
    public List<Forum> findAll() {
        hibernateTemplate=getHibernateTemplate();
        return (List<Forum>) hibernateTemplate.find("FROM Forum order by position");
    }

    private void exchange(Forum forum, Forum upForum) {
        int temp=upForum.getPosition();
        upForum.setPosition(forum.getPosition());
        forum.setPosition(temp);
        session.save(upForum);
        session.save(forum);
    }

    private Forum getForum(Forum forum, String hql) {
        Query query=session.createQuery(hql);
        query.setParameter(0,forum.getPosition());
        query.setFirstResult(0);
        query.setMaxResults(1);
        return (Forum) query.uniqueResult();
    }
    private void getCurrentSession(){
        hibernateTemplate=getHibernateTemplate();
        session=hibernateTemplate.getSessionFactory().getCurrentSession();
    }
}
