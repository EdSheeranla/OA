package com.hjy.oa.service;

import com.hjy.oa.dao.BaseDao;
import com.hjy.oa.entity.User;

/**
 * Created by sheeran on 2017/3/17.
 */
public interface UserService  extends BaseDao<User>{
    User checkloginname(String loginname);

    User loginCheck(User model);
}
