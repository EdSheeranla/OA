package com.hjy.oa.service;

import com.hjy.oa.dao.BaseDao;
import com.hjy.oa.dto.PageBean;
import com.hjy.oa.entity.Forum;
import com.hjy.oa.entity.Topic;

import java.util.List;

/**
 * Created by sheeran on 2017/4/9.
 */
public interface TopicService extends BaseDao<Topic>{

    /**
     * 查找指定版块下的所有主题
     * @param model
     * @return
     */

    List<Topic> findByForum(Forum model);

    /**
     * 更改主题的类型
     * @param model
     * @param op
     */

    void modifyType(Topic model, int op);

    /**
     * 分页查找指定版块下的所有主题
     * @param model
     * @param pageBean
     * @return
     */
    PageBean<Topic> findByPage(Forum model, PageBean<Topic> pageBean);
}
