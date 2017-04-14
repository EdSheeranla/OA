package com.hjy.oa.service;

import com.hjy.oa.dao.BaseDao;
import com.hjy.oa.dto.PageBean;
import com.hjy.oa.entity.Reply;
import com.hjy.oa.entity.Topic;

import java.util.List;

/**
 * Created by sheeran on 2017/4/12.
 */
public interface ReplyService extends BaseDao<Reply> {
    List<Reply> findByTopic(Topic model);

    PageBean<Reply> findByPage(PageBean<Reply> pageBean,Topic model);
}
