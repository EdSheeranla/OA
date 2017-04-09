package com.hjy.oa.service.impl;

import com.hjy.oa.dao.Impl.BaseDaoImpl;
import com.hjy.oa.entity.Forum;
import com.hjy.oa.service.ForumService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by sheeran on 2017/4/9.
 */
@Component("forumServiceImpl")
public class ForumServiceImpl extends BaseDaoImpl<Forum> implements ForumService {
}
