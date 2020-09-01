package com.cf.colorm.dao;

import com.cf.colorm.entity.Store;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 仓库
 */

@Component
@Mapper
public interface StoreDao {

    public Store getStoreById(int id);

}
