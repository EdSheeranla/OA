package com.hjy.oa.service.impl;

import com.hjy.oa.dao.Impl.BaseDaoImpl;
import com.hjy.oa.entity.Privilege;
import com.hjy.oa.service.PrivilegeService;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sheeran on 2017/3/21.
 */
@Component("privilegeServiceImpl")
public class PrivilegeServiceImpl extends BaseDaoImpl<Privilege> implements PrivilegeService {
    HibernateTemplate hibernateTemplate;
    @Override
    public List<Privilege> findAllTop() {
    hibernateTemplate=getHibernateTemplate();
    List<Privilege> list= (List<Privilege>) hibernateTemplate.find("from Privilege where parentId is null");
    return list;
    }
}
