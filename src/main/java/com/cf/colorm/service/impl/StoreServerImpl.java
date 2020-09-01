package com.cf.colorm.service.impl;

import com.cf.colorm.dao.StoreDao;
import com.cf.colorm.entity.Store;
import com.cf.colorm.service.StoreServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServerImpl implements StoreServer {

    @Autowired
    private StoreDao storeDao;

    @Override
    public Store findStoreByid(int id) {
        return storeDao.getStoreById(id);
    }

}
