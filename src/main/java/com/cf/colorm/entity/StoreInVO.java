package com.cf.colorm.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Api(value = "入仓接受数据")
@Data
public class StoreInVO {

    @ApiModelProperty(value = "颜色编号")
    private String colorNo;

    @ApiModelProperty(value = "颜色名称")
    private String colorName;

    @ApiModelProperty(value = "入仓类型")
    private String type;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "存放地址")
    private String address;

    @ApiModelProperty(value = "仓库编号",example="1")
    private Integer storeId;

    @ApiModelProperty(value = "入仓人")
    private String check_in_user;

    @ApiModelProperty(value = "资料id",example="1")
    private Integer fileId;

    @ApiModelProperty(value = "入仓id",example="1")
    private Integer fileInId;
}
