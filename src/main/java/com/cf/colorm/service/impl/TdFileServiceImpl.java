package com.cf.colorm.service.impl;

import com.cf.colorm.api.CommonsResult;
import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.dao.TdFileDao;
import com.cf.colorm.entity.TdFile;
import com.cf.colorm.service.TdFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TdFileServiceImpl implements TdFileService {

    @Autowired
    private TdFileDao tdFileDao;

    @Override
    public ResponseResult add(TdFile tdFile) {
        int add = tdFileDao.add(tdFile);
        if(add == 1){
            return CommonsResult.getSuccessResult("新增成功");
        }
        return CommonsResult.getFialResult("新增失败");
    }

    @Override
    public ResponseResult findColorNameByNo(String colorNo) {
        String colorNameByColorNo = tdFileDao.findColorNameByColorNo(colorNo);
        if(colorNameByColorNo == null){
            return CommonsResult.getFialResult("资料无此颜色");
        }
        return CommonsResult.getSuccessResult("查询成功",colorNameByColorNo);
    }
}
