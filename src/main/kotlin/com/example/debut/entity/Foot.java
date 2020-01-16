package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Foot", description = "用户浏览表")
public class Foot {
    @ApiModelProperty(value = "foot表的id，自增")
    private int id=0;
    @ApiModelProperty(value = "userId,查看者",required = true)
    private String userId="";
    @ApiModelProperty(value = "toUserId,被查看者",required = true)
    private String toUserId="";
    @ApiModelProperty(value = "状态，0=未浏览，1=已浏览")
    private int foot = 0;

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

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public int getFoot() {
        return foot;
    }

    public void setFoot(int foot) {
        this.foot = foot;
    }
}
