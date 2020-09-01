package com.cf.colorm.service.impl;

import com.cf.colorm.api.CommonsResult;
import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.dao.TdFileCheckOutDao;
import com.cf.colorm.dao.TdFileStoreDao;
import com.cf.colorm.entity.TdFileStore;
import com.cf.colorm.service.StoreOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreOutServiceImpl implements StoreOutService {

    @Autowired
    private TdFileCheckOutDao tdFileCheckOutDao;

    @Autowired
    private TdFileStoreDao tdFileStoreDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult storeOut(int id,String userName) {

        //判断库存中是否存在信息
        TdFileStore tdFileStore = tdFileStoreDao.findByFileId(id);
        if(tdFileStore == null){
            return CommonsResult.getFialResult("库存中不存在该资料");
        }

        //删除库存
        if(tdFileStoreDao.removeById(id) == 0){
            return CommonsResult.getFialResult("借出失败");
        }

        //删除成功，添加出仓信息


        return CommonsResult.getSuccessResult("出仓成功");
    }

}
