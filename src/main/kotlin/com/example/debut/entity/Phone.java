package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Phone", description = "用户手机相关信息")
public class Phone {
    @ApiModelProperty(value = "phone表的id,自增")
    private int id = 0;
    @ApiModelProperty(value = "手机系统")
    private String os = "";
    @ApiModelProperty(value = "手机系统版本")
    private String version = "";
    @ApiModelProperty(value = "手机品牌")
    private String brand = "";
    @ApiModelProperty(value = "手机型号")
    private String model = "";
    @ApiModelProperty(value = "手机ID号，IMEI")
    private String imei = "";
    @ApiModelProperty(value = "使用过的用户，用|隔开")
    private String userIds = "";
}
