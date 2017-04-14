package com.hjy.oa.service.impl;

import com.hjy.oa.dao.Impl.BaseDaoImpl;
import com.hjy.oa.dto.PageBean;
import com.hjy.oa.entity.Forum;
import com.hjy.oa.entity.Reply;
import com.hjy.oa.entity.Topic;
import com.hjy.oa.service.ReplyService;
import com.hjy.oa.util.HibernateCallBackUtil;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sheeran on 2017/4/12.
 */
@Component("replyServiceImpl")
@Transactional
public class ReplyServiceImpl extends BaseDaoImpl<Reply> implements ReplyService {
    @Override
    @SuppressWarnings("unchecked")
    public List<Reply> findByTopic(Topic model) {
        return (List<Reply>) getHibernateTemplate().find("from  Reply where topic = ? order by pushTime ASC ", model);
    }

    /**
     * 分页查找reply
     *
     * @param pageBean
     * @param model    对应的topic
     * @return 返回reply的pagebean对象
     */
    public PageBean<Reply> findByPage(PageBean<Reply> pageBean, Topic model) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        String hql = "FROM Reply where topic =? order by pushTime ASC";

        Object[] parameters = {model};
        List<Reply> list = hibernateTemplate.execute(new HibernateCallBackUtil<Reply>(pageBean.getBeginPage(), pageBean.getEndPage(), hql, parameters));
        List<Long> list1 = (List<Long>) hibernateTemplate.find("SELECT count (*) from Reply where topic =?", model);
        if (list1.size() != 0 || list1 != null) {
            Number number = list1.get(0);
            pageBean.setRowCount(number.intValue());
        }
        pageBean.setList(list);
        return pageBean;
    }

    /**
     * t添加新的回复
     *
     * @param reply
     */
    @Override
    public void add(Reply reply) {
        //对于topic中特殊字段进行维护
        Topic topic = reply.getTopic();
        topic.updateLastReply(reply);
        //对于forum中的特殊字段进行维护
        Forum forum = topic.getForum();
        forum.setArticleCount(forum.getArticleCount() + 1);

        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.save(reply);
        hibernateTemplate.save(topic);
        hibernateTemplate.update(forum);

    }
}
