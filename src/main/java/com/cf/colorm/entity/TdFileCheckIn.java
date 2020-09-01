package com.cf.colorm.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "入仓信息")
public class TdFileCheckIn implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "色卡资料id",example="1001")
    private Integer fileId;

    @ApiModelProperty(value = "入仓类型")
    private String type;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "仓库id",example="1")
    private Integer store_id;

    @ApiModelProperty(value = "入仓人")
    private String check_in_user;

    @ApiModelProperty(value = "创建人id",example="1")
    private Integer createUser;

    @ApiModelProperty("创建时间")
    private String createDate;

    @ApiModelProperty(value = "修改人id",example="1")
    private Integer modifyUser;

    @ApiModelProperty(value = "修改时间")
    private String modifyDate;

}
