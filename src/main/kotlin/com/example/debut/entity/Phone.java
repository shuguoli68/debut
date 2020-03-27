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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }
}
