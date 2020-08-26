package com.cf.colorm.entity;

import lombok.Data;

/*
 *   仓 库
 */
@Data
public class Store {

    private Integer id;
    private String name;
    //备注
    private String description;
    //是否可用
    private short isEnabled;
    //仓库所属的公司的ID
    private Integer companyId;
    //创建用户ID
    private Integer createUser;
    private String createDate;
    private Integer modifyUser;
    private String modifyDate;
}
