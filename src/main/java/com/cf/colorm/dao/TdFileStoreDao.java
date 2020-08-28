package com.cf.colorm.dao;

import com.cf.colorm.entity.StoreInVO;
import com.cf.colorm.entity.TdFileStore;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

//库存

@Component
@Mapper
public interface TdFileStoreDao {

    public Integer findByColoeNo(String colorNo);

    public int add(StoreInVO storeInVO);

}