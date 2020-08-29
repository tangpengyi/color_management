package com.cf.colorm.service;

import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.entity.TdFile;

public interface TdFileService {

    public ResponseResult add(TdFile tdFile);

    public ResponseResult findColorNameByNo(String colorNo);

    public ResponseResult findColorByCondition(String condition,String param);

    public ResponseResult findAll();
}
