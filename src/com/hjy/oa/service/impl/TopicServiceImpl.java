package com.hjy.oa.service.impl;

import com.hjy.oa.dao.Impl.BaseDaoImpl;
import com.hjy.oa.dto.PageBean;
import com.hjy.oa.entity.Forum;
import com.hjy.oa.entity.Topic;
import com.hjy.oa.service.TopicService;
import com.hjy.oa.util.HibernateCallBackUtil;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sheeran on 2017/4/9.
 */
@Component("topicServiceImpl")
@Transactional
public class TopicServiceImpl extends BaseDaoImpl<Topic> implements TopicService {
    @Override
    public List<Topic> findByForum(Forum model) {
        HibernateTemplate hibernateTEmplate = getHibernateTemplate();
        @SuppressWarnings("unchecked")
        List<Topic> list = (List<Topic>) hibernateTEmplate.find("FROM Topic t where t.forum.id = ? order by isTop desc,lasetUpdate desc", model.getId());
        return list;
    }

    @Override
    public void modifyType(Topic model, int op) {
        Topic topic=findById(model.getId());
        topic.setType(op);
        if(op==Topic.TYPE_TOP ) topic.setIsTop(1);
        update(topic);
    }

    @Override
    public PageBean<Topic> findByPage(Forum model, PageBean<Topic> pageBean) {
        HibernateTemplate hibernateTemplate=getHibernateTemplate();
        String hql="FROM Topic t where t.forum = ? order by isTop desc,lasetUpdate desc";
        Object[] parameters={model};
        List<Topic> list = hibernateTemplate.execute(new HibernateCallBackUtil<Topic>(pageBean.getBeginPage(), pageBean.getEndPage(), hql, parameters));
        List<Long> list1 = (List<Long>) hibernateTemplate.find("SELECT count (*) from Topic where forum =?", model);
        if (list1.size() != 0 || list1 != null) {
            Number number = list1.get(0);
            pageBean.setRowCount(number.intValue());
        }
        pageBean.setList(list);
        return pageBean;
    }

    /**
     * 增加新的主题
     * @param topic
     */
    @Override
    public void add(Topic topic) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        topic.setLasetUpdate(topic.getPushTime());
        Forum forum = topic.getForum();
        forum.updateLastTopic(topic);
        hibernateTemplate.update(forum);
        hibernateTemplate.save(topic);

    }
}
