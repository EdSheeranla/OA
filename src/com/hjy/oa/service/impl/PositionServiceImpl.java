package com.hjy.oa.service.impl;

import com.hjy.oa.dao.Impl.BaseDaoImpl;
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
public class PositionServiceImpl extends BaseDaoImpl<Position> implements PositionService{

}
