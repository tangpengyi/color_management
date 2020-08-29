package com.cf.colorm.service.impl;

import com.cf.colorm.api.CommonsResult;
import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.dao.TdFileDao;
import com.cf.colorm.entity.TdFile;
import com.cf.colorm.service.TdFileService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TdFileServiceImpl implements TdFileService {

    private static Log log = LogFactory.getLog(TdFileServiceImpl.class);

    @Autowired
    private TdFileDao tdFileDao;

    @Override
    public ResponseResult add(TdFile tdFile) {

        //判断颜色资料是否存在
        if( tdFileDao.findFileIdByColorNo(tdFile.getColorNo()) != null){
            return CommonsResult.getFialResult("色卡资料已经存在");
        }

        int add = tdFileDao.add(tdFile);
        if(add == 1){
            return CommonsResult.getSuccessResult("新增成功");
        }
        return CommonsResult.getFialResult("新增失败");
    }

    @Override
    public ResponseResult findColorNameByNo(String colorNo) {
        TdFile tdFile = tdFileDao.findColorByColorNo(colorNo);
        if(tdFile == null){
            return CommonsResult.getFialResult("资料信息中无此颜色");
        }
        return CommonsResult.getSuccessResult("查询成功",tdFile.getColorName());
    }

    @Override
    public ResponseResult findColorByCondition(String condition, String param) {
        TdFile tdFile = null;
        if("色号".equals(condition)){
            tdFile = tdFileDao.findColorByColorNo(param);
        }else if("色名".equals(condition)){
            tdFile = tdFileDao.findColorByColorName(param);
        }else if("缸号".equals(condition)){
            return CommonsResult.getSuccessResult("查询成功",tdFileDao.findColorByColorName(param));
        }

        if(tdFile == null){
            return CommonsResult.getFialResult("查询失败");
        }
        return CommonsResult.getSuccessResult("查询成功",tdFile);
    }

    @Override
    public ResponseResult findAll() {
        List<TdFile> list = tdFileDao.findAll();
        if(list.size() == 0 || list == null){
            return CommonsResult.getFialResult("无色卡信息");
        }
        return  CommonsResult.getSuccessResult("查询成功",list);
    }
}
