package com.hjy.oa.service;

import com.hjy.oa.dao.BaseDao;
import com.hjy.oa.entity.Position;

import java.util.List;

/**
 * Created by sheeran on 2017/3/17.
 */
public interface PositionService  {

    List<Position> findAll();

    void add(Position position);

    void del(Position position);

    Position findById(int pid);

    void edit(Position position);
}
