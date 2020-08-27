package com.cf.colorm.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "色卡资料")
public class TdFile implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "颜色号")
    private String colorNo;

    private String colorName;

    @ApiModelProperty(value = "资料类型")
    private String type;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "仓库的ID")
    private Integer storeId;

    @ApiModelProperty(value = "资料的状态")
    private String status;

    @ApiModelProperty(value = "编辑人名")
    private String editUser;

    @ApiModelProperty(value = "创建人编号")
    private Integer createUser;

    @ApiModelProperty(value = "创建时间")
    private String createDate;

    @ApiModelProperty(value = "修改人编号")
    private Integer modifyUser;

    @ApiModelProperty(value = "修改时间")
    private String modifyDate;

}
