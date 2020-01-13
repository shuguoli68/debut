package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "Sign", description = "每日签到")
public class Sign {
    @ApiModelProperty(value = "sign表的id，自增")
    private int id = 0;
    @ApiModelProperty(value = "用户userId")
    private String userId="";
    @ApiModelProperty(value = "创建时间,只需要年月日")
    private Date ctTime = new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCtTime() {
        return ctTime;
    }

    public void setCtTime(Date ctTime) {
        this.ctTime = ctTime;
    }
}
