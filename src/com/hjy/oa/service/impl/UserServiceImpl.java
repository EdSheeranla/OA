package com.hjy.oa.service.impl;

import com.hjy.oa.dao.Impl.BaseDaoImpl;
import com.hjy.oa.entity.User;
import com.hjy.oa.service.UserService;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sheeran on 2017/3/17.
 */
@Component("userServiceImpl")
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService {
    private List<User> list = new ArrayList<User>();
    private HibernateTemplate hibernateTemplate;
    @Override
    public User checkloginname(String loginname) {
        String hql = "from User where loginname= ?";
        hibernateTemplate=getHibernateTemplate();
        list= (List<User>) hibernateTemplate.find(hql);
        return getUser();
    }

    @Override
    public User loginCheck(User model) {
        String hql = "from User where loginname= ? and password = ? ";
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        list = (List<User>) hibernateTemplate.find(hql,model.getLoginname(),model.getPassword());
        return getUser();
    }

    private User getUser() {
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }
}
