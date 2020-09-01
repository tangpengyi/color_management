package com.cf.colorm.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "出仓信息")
public class TdFileCheckOut {

    private Integer id;

    @ApiModelProperty(value = "色卡资料id",example="1")
    private Integer fileId;

    @ApiModelProperty(value = "出仓类型")
    private String type;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "仓库id",example="1")
    private Integer storeId;

    @ApiModelProperty(value = "入仓人")
    private String check_out_user;

    @ApiModelProperty(value = "创建人id",example="1")
    private Integer createUser;

    @ApiModelProperty("创建时间")
    private String createDate;

    @ApiModelProperty(value = "修改人id",example="1")
    private Integer modifyUser;

    @ApiModelProperty(value = "修改时间")
    private String modifyDate;

}
