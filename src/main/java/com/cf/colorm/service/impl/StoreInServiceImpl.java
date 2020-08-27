package com.cf.colorm.service.impl;

import com.cf.colorm.api.CommonsResult;
import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.dao.TdFileCheckInDao;
import com.cf.colorm.dao.TdFileStoreDao;
import com.cf.colorm.entity.StoreInVO;
import com.cf.colorm.entity.TdFileCheckIn;
import com.cf.colorm.entity.TdFileStore;
import com.cf.colorm.service.StoreInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreInServiceImpl implements StoreInService {


    @Autowired
    private TdFileStoreDao tdFileStoreDao;

    @Autowired
    private TdFileCheckInDao tdFileCheckInDao;

    @Override
    public ResponseResult storeIn(StoreInVO storeInVO) {

        //判断库存中否存在，存在无法添加
        Integer fileId = tdFileStoreDao.findByColoeNo(storeInVO.getColorNo());
        if(fileId != null) {
            return CommonsResult.getFialResult("库存中已经在数据");
        }
        //入仓 添加入库记录信息
        storeInVO.setFileId(fileId);
        tdFileCheckInDao.add(storeInVO);

        //获取入仓的编号
        int storeInId = tdFileCheckInDao.getIdByFileId(fileId);
        storeInVO.setFileInId(storeInId);

        //添加库存信息



        return CommonsResult.getSuccessResult("库存中不存在数据");
    }
}
