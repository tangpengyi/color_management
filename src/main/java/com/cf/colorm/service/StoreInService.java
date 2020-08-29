package com.cf.colorm.service;

import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.entity.StoreInVO;

public interface StoreInService {

    public ResponseResult storeIn(StoreInVO storeInVO);

    public ResponseResult getAll();
}
