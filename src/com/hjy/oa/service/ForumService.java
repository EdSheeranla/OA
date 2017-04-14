package com.hjy.oa.service;

import com.hjy.oa.dao.BaseDao;
import com.hjy.oa.entity.Forum;
import com.hjy.oa.entity.Topic;

import java.util.List;

/**
 * Created by sheeran on 2017/4/9.
 */
public interface ForumService extends BaseDao<Forum> {

    List<Topic> findTopicByPage(int id);
}
