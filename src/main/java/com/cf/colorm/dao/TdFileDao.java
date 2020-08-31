package com.cf.colorm.dao;

import com.cf.colorm.entity.TdFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TdFileDao {

    public int add(TdFile tdFile);

    public TdFile findColorByColorNo(String colorNo);

    public Integer findFileIdByColorNo(String colorNo);

    public TdFile findColorByColorName(String colorName);

    public List<TdFile> findAll();

    public int modityTdfile(TdFile tdFile);

    public TdFile findColorById(int id);

}
