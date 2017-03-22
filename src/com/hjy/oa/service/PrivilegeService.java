package com.hjy.oa.service;

import com.hjy.oa.dao.BaseDao;
import com.hjy.oa.entity.Privilege;

import java.util.List;

/**
 * Created by sheeran on 2017/3/21.
 */
public interface PrivilegeService extends BaseDao<Privilege> {

    List<Privilege> findAllTop();
    
}
