package com.hjy.oa.service.impl;

import com.hjy.oa.dao.PositionDao;
import com.hjy.oa.entity.Position;
import com.hjy.oa.service.PositionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sheeran on 2017/3/17.
 */
@Component("positionServiceImpl")
@Transactional
public class PositionServiceImpl  implements PositionService{
    private PositionDao positionDao;

    @Resource
    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    public List<Position> findAll() {
        return positionDao.findAll();
    }

    @Override
    public void add(Position position) {
        positionDao.add(position);
    }

    @Override
    public void edit(Position position) {

        positionDao.update(position);
    }

    @Override
    public Position findById(int pid) {
        return positionDao.findById(pid);
    }

    @Override
    public void del(Position position) {

        positionDao.del(position);
    }
}
