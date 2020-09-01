package com.cf.colorm.service.impl;

import com.cf.colorm.api.CommonsResult;
import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.dao.TdFileCheckInDao;
import com.cf.colorm.dao.TdFileCheckOutDao;
import com.cf.colorm.dao.TdFileDao;
import com.cf.colorm.dao.TdFileStoreDao;
import com.cf.colorm.entity.TdFile;
import com.cf.colorm.entity.TdFileStore;
import com.cf.colorm.service.TdFileService;
import com.cf.colorm.utils.JWTUtls;
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

    @Autowired
    private TdFileCheckOutDao tdFileCheckOutDao;

    @Override
    public ResponseResult add(TdFile tdFile) {

        tdFile.setCreateUser(JWTUtls.getUserIdByRequest());
        tdFile.setEditUser(JWTUtls.getUserIdByRequest()+"");
        //判断颜色资料是否存在
        if (tdFileDao.findFileIdByColorNo(tdFile.getColorNo()) != null) {
            return CommonsResult.getFialResult("色卡资料已经存在");
        }

        int add = tdFileDao.add(tdFile);
        if (add == 1) {
            return CommonsResult.getSuccessResult("新增成功");
        }
        return CommonsResult.getFialResult("新增失败");
    }

    @Override
    public ResponseResult findColorNameByNo(String colorNo) {
        TdFile tdFile = tdFileDao.findColorByColorNo(colorNo);
        if (tdFile == null) {
            return CommonsResult.getFialResult("资料信息中无此颜色");
        }
        return CommonsResult.getSuccessResult("查询成功", tdFile.getColorName());
    }

    @Override
    public ResponseResult findColorByCondition(String condition, String param) {
        TdFile tdFile = null;
        if ("色号".equals(condition)) {
            tdFile = tdFileDao.findColorByColorNo(param);
        } else if ("色名".equals(condition)) {
            tdFile = tdFileDao.findColorByColorName(param);
        } else if ("缸号".equals(condition)) {
            return CommonsResult.getSuccessResult("查询成功", tdFileDao.findColorByColorName(param));
        } else if ("全部库存".equals(condition)) {
            return CommonsResult.getSuccessResult("查询成功", tdFileDao.findAll());
        }

        if (tdFile == null) {
            return CommonsResult.getFialResult("查询失败");
        }
        return CommonsResult.getSuccessResult("查询成功", tdFile);
    }

    @Override
    public ResponseResult findAll() {
        List<TdFile> list = tdFileDao.findAll();
        if (list.size() == 0 || list == null) {
            return CommonsResult.getFialResult("无色卡信息");
        }
        return CommonsResult.getSuccessResult("查询成功", list);
    }

    @Override
    public ResponseResult modityTdFile(TdFile tdFile) {

        TdFile color = tdFileDao.findColorById(tdFile.getId());
        if (color == null) {
            return CommonsResult.getFialResult("该信息已被删除");
        }

        //需要修改色号
        if (!color.getColorNo().equals(tdFile.getColorNo())) {

            //判断该颜色是否借出，借出无法修改，未借出可以修改色号
            Integer fileId = tdFileCheckInDao.getIdByFileId(tdFile.getId());
            //不存在借出记录
            if (fileId != null) {
                return CommonsResult.getFialResult("该资料存在借出记录，无法修改色号");
            }

            //判断是否存入仓数据
            int idByFileId = tdFileCheckOutDao.getIdByFileId(tdFile.getId());
            if (fileId != null) {
                return CommonsResult.getFialResult("该资料存在入仓记录，无法修改色号");
            }
        }

        tdFile.setModifyUser(JWTUtls.getUserIdByRequest());
        //不需要修改色号   无借出，入仓记录
        int i = tdFileDao.modityTdfile(tdFile);
        if (i > 0) {
            return CommonsResult.getSuccessResult("修改成功");
        }

        return CommonsResult.getFialResult("修改失败");
    }

    @Override
    public ResponseResult removeById(Integer id) {

        TdFile tdFile = new TdFile();
        tdFile.setId(id);
        tdFile.setModifyUser(JWTUtls.getUserIdByRequest());

        //查询库存
        TdFileStore tdFileStore = tdFileStoreDao.findByFileId(id);
        //不存在库存直接删除
        if(tdFileStore == null){
            if(tdFileDao.removeById(tdFile) > 0){
                return CommonsResult.getSuccessResult("删除成功!");
            }

            return CommonsResult.getFialResult("删除失败!");
        }


        //有库存，删除库存（添加出仓信息，删除库存信息）
        int add = tdFileCheckOutDao.add(null);


        //再删除资料信息


        return null;
    }
}
