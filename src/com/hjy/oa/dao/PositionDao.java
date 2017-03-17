package com.hjy.oa.dao;

import com.hjy.oa.dao.Impl.BaseDaoImpl;
import com.hjy.oa.entity.Position;
import org.springframework.stereotype.Component;

/**
 * Created by sheeran on 2017/3/17.
 */
public interface PositionDao extends BaseDao<Position> {
    public void svae();
}
