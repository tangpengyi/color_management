package com.cf.colorm.dao;

import com.cf.colorm.entity.StoreInVO;
import com.cf.colorm.entity.TdFileStore;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 库存
 */

@Component
@Mapper
public interface TdFileStoreDao {

    public TdFileStore findByColoeNo(String colorNo);

    public int add(StoreInVO storeInVO);

    public List<TdFileStore> findAll();

    public TdFileStore findByFileId(Integer fileId);

    public int removeById(int Id);

    public int removeByFileId(int fileId);
}
