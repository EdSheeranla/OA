package com.hjy.oa.service;

import com.hjy.oa.dao.BaseDao;
import com.hjy.oa.entity.Forum;

import java.util.List;

/**
 * Created by sheeran on 2017/3/26.
 */
public interface ForumManageService extends BaseDao<Forum>{
    @Override
    void add(Forum forum);
    void moveUp(Forum forum);
    void moveDown(Forum forum);

    @Override
    List<Forum> findAll();
}
