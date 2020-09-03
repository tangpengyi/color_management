package com.cf.colorm.service.impl;

import com.cf.colorm.api.CommonsResult;
import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.dao.TdFileStoreDao;
import com.cf.colorm.entity.TdFileStore;
import com.cf.colorm.service.FileStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileStoreServiceImpl implements FileStoreService {

    @Autowired
    private TdFileStoreDao tdFileStoreDao;

    @Override
    public ResponseResult getFileStoreByColorNo(String colorNo) {
        TdFileStore fileStore = tdFileStoreDao.findByColoeNo(colorNo);
        if(fileStore == null){
            return CommonsResult.getFialResult("此颜色没有库存");
        }
        return CommonsResult.getSuccessResult("查询成功",fileStore);
    }
}
