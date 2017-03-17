package com.hjy.oa.service.impl;

import com.hjy.oa.dao.Impl.BaseDaoImpl;
import com.hjy.oa.entity.User;
import com.hjy.oa.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Created by sheeran on 2017/3/17.
 */
@Component("userServiceImpl")
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService {

}
