package com.hjy.oa.dao.Impl;

import com.hjy.oa.dao.PositionDao;
import com.hjy.oa.entity.Position;
import com.hjy.oa.service.PositionService;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by sheeran on 2017/3/17.
 */
@Component("positionDaoImpl")
public class PositionDaoImpl extends BaseDaoImpl<Position> implements PositionDao {

    public void svae(){
      System.out.println(this.getHibernateTemplate());
    }
}
