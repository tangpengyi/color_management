package com.cf.colorm.dao;

import com.cf.colorm.entity.TdFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TdFileDao {

    public int add(TdFile tdFile);

}
