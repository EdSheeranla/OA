package com.hjy.oa.service.impl;

import com.hjy.oa.dao.Impl.BaseDaoImpl;
import com.hjy.oa.entity.User;
import com.hjy.oa.service.UserService;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sheeran on 2017/3/17.
 */
@Component("userServiceImpl")
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService {

    @Override
    public User checkloginname(String loginname) {
        HibernateTemplate hibernateTemplate=getHibernateTemplate();
        String hql="from User where loginname= ?";
        List<User> list= (List<User>) hibernateTemplate.find(hql,loginname);
        if(list==null||list.size()==0){
            return null;
        }else
        {
            return list.get(0);
        }

    }
}
