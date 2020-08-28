package com.cf.colorm.service.impl;

import com.cf.colorm.api.CommonsResult;
import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.dao.TdFileCheckInDao;
import com.cf.colorm.dao.TdFileDao;
import com.cf.colorm.dao.TdFileStoreDao;
import com.cf.colorm.entity.StoreInVO;
import com.cf.colorm.service.StoreInService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import java.util.List;

@Service
public class StoreInServiceImpl implements StoreInService {

    private static Log log = LogFactory.getLog(StoreInServiceImpl.class);

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    TransactionDefinition transactionDefinition;

    @Autowired
    private TdFileStoreDao tdFileStoreDao;

    @Autowired
    private TdFileCheckInDao tdFileCheckInDao;

    @Autowired
    private TdFileDao tdFileDao;

    @Override
    public ResponseResult storeIn(StoreInVO storeInVO) {

        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);

        try{
            //判断库存中否存在，存在无法添加
            if(tdFileStoreDao.findByColoeNo(storeInVO.getColorNo()) != null) {
                return CommonsResult.getFialResult("库存中已经在数据");
            }
            //获取资料id
            List<Integer> list = tdFileDao.findFileIdByColorNo(storeInVO.getColorNo());

            //入仓 添加入库记录信息
            storeInVO.setFileId(list.get(0));
            if(tdFileCheckInDao.add(storeInVO) == 0){
                dataSourceTransactionManager.rollback(transactionStatus);
                return CommonsResult.getFialResult("入仓失败");
            }

            //获取入仓的编号
            storeInVO.setFileInId(tdFileCheckInDao.getIdByFileId(list.get(0)));

            //添加库存信息
            tdFileStoreDao.add(storeInVO);
            dataSourceTransactionManager.commit(transactionStatus);
        }catch (Exception e){
            dataSourceTransactionManager.rollback(transactionStatus);
            log.info("存储库存失败"+e.getMessage());
            return CommonsResult.getFialResult("入仓失败");
        }
        return CommonsResult.getSuccessResult("入库成功");
    }
}