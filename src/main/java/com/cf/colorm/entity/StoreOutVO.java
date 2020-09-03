package com.cf.colorm.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Api(value = "出库信息")
@Data
public class StoreOutVO {

    private Integer id;
    @ApiModelProperty(value = "资料编号")
    private Integer fileId;
    @ApiModelProperty(value = "出仓类型")
    private String type;
    @ApiModelProperty(value = "备注")
    private String description;
    @ApiModelProperty(value = "仓库编号")
    private int storeId;
    @ApiModelProperty(value = "出仓人")
    private String check_out_user;

    private int createUser;
    private String createDate;
    private int modifyUser;
    private String modifyDate;

}
