package com.cf.colorm.dao;

import com.cf.colorm.entity.TdFileCheckOut;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 借出记录
 */
@Component
@Mapper
public interface TdFileCheckOutDao {

    public int getIdByFileId(int fileId);

    public int add(TdFileCheckOut tdFileCheckOut);

}
