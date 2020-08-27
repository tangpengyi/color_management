package com.cf.colorm.dao;

import com.cf.colorm.entity.StoreInVO;
import com.cf.colorm.entity.TdFileCheckIn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 入仓信息
 */

@Mapper
@Component
public interface TdFileCheckInDao {

    public int add(StoreInVO storeInVO);

    public int getIdByFileId(int fileId);
}
