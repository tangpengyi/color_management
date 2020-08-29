package com.cf.colorm.service.impl;

import com.cf.colorm.api.CommonsResult;
import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.dao.TdFileCheckInDao;
import com.cf.colorm.dao.TdFileDao;
import com.cf.colorm.dao.TdFileStoreDao;
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

    @Autowired
    private TdFileStoreDao tdFileStoreDao;

    @Autowired
    private TdFileCheckInDao tdFileCheckInDao;


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
        }else if("全部库存".equals(condition)){
            return CommonsResult.getSuccessResult("查询成功",tdFileDao.findAll());
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

    @Override
    public ResponseResult modityTdFile(TdFile tdFile) {

        TdFile color = tdFileDao.findColorById(tdFile.getId());
        if(color == null){
            return CommonsResult.getFialResult("该信息已被删除");
        }

        //判断该颜色是否借出，借出不法修改，未借出可以修改色号
        Integer fileId = tdFileCheckInDao.getIdByFileId(tdFile.getId());
        //不存在借出记录
        if(fileId != null || fileId > 0){
            return CommonsResult.getFialResult("该资料存在借出记录，无法修改色号");
        }

        int i = tdFileDao.modityTdfile(tdFile);
        if(i > 0){
            return CommonsResult.getSuccessResult("修改成功");
        }
        return CommonsResult.getFialResult("修改失败");
    }
}
