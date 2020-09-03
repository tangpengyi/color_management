package com.cf.colorm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AddressDao {

    public Integer findIdByAddress(String address);

}
