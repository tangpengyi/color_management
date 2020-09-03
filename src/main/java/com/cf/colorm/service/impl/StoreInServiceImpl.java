package com.cf.colorm.service.impl;

import com.cf.colorm.api.CommonsResult;
import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.dao.AddressDao;
import com.cf.colorm.dao.TdFileCheckInDao;
import com.cf.colorm.dao.TdFileDao;
import com.cf.colorm.dao.TdFileStoreDao;
import com.cf.colorm.entity.StoreInVO;
import com.cf.colorm.entity.TdFile;
import com.cf.colorm.entity.TdFileStore;
import com.cf.colorm.service.StoreInService;
import com.cf.colorm.utils.JWTUtls;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class StoreInServiceImpl implements StoreInService {

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

    @Autowired
    private AddressDao addressDao;

    @Override
    public ResponseResult storeIn(StoreInVO storeInVO) {

        //判断库存中否存在，存在无法添加
        if (tdFileStoreDao.findByColoeNo(storeInVO.getColorNo()) != null) {
            return CommonsResult.getFialResult("库存中已经存在数据");
        }

        //判断架位是否存在
        if (StringUtils.isEmpty(addressDao.findIdByAddress(storeInVO.getAddress()))) {
            return CommonsResult.getFialResult("该架位地址没有记录");
        }

        //判断该颜色是否报废
        TdFile tdFile = tdFileDao.findColorByColorNo(storeInVO.getColorNo());
        if ("报废".equals(tdFile.getStatus())) {
            return CommonsResult.getFialResult("此颜色已报废");
        }

        //获取资料id
        Integer fileId = tdFileDao.findFileIdByColorNo(storeInVO.getColorNo());

        //入仓 添加入库记录信息
        storeInVO.setFileId(fileId);
        storeInVO.setCreateUser(JWTUtls.getUserIdByRequest());

        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            if (tdFileCheckInDao.add(storeInVO) == 0) {
                return CommonsResult.getFialResult("入仓失败");
            }

            //获取入仓的编号
            storeInVO.setFileInId(tdFileCheckInDao.getIdByFileId(fileId));
            //添加库存信息
            if (tdFileStoreDao.add(storeInVO) == 0) {
                dataSourceTransactionManager.rollback(transactionStatus);
                return CommonsResult.getFialResult("入仓失败");
            }

            dataSourceTransactionManager.commit(transactionStatus);
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
            return CommonsResult.getFialResult("入仓失败" + e.getMessage());
        }
        return CommonsResult.getSuccessResult("入库成功",tdFileStoreDao.findByColoeNo(storeInVO.getColorNo()));
    }

    @Override
    public ResponseResult getAll() {
        List<TdFileStore> list = tdFileStoreDao.findAll();

        if (list == null || list.size() == 0) {
            return CommonsResult.getFialResult("没有库存信息");
        }
        return CommonsResult.getSuccessResult("查询成功", list);
    }


}
