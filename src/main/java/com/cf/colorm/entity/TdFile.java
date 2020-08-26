package com.cf.colorm.entity;

import lombok.Data;

/*
资料信息表
 */
@Data
public class TdFile {

    private Integer id;
    //颜色号
    private String colorNo;
    private String colorName;
    //资料类型
    private String type;
    //备注
    private String description;
    //仓库的ID
    private Integer storeId;
    //资料的状态
    private String status;
    private String editUser;
    private Integer createUser;
    private String createDate;
    private Integer modifyUser;
    private String modifyDate;

}
