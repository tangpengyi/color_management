package com.cf.colorm.service.impl;

import com.cf.colorm.api.CommonsResult;
import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.dao.StoreDao;
import com.cf.colorm.dao.TdFileCheckOutDao;
import com.cf.colorm.entity.Store;
import com.cf.colorm.service.StoreOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreOutServiceImpl implements StoreOutService {

    @Autowired
    private TdFileCheckOutDao tdFileCheckOutDao;

    @Autowired
    private StoreDao storeDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult storeOut(int id) {

        //判断库存中是否存在信息
        Store store = storeDao.getStoreById(id);
        if(store == null){
            return CommonsResult.getSuccessResult("库存中不存在此资料");
        }
        //删除库存




        //删除成功，删除出仓信息
        return null;
    }

}
