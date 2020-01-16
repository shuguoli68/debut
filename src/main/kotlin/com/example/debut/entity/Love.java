package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Love", description = "用户关注表")
public class Love {
    @ApiModelProperty(value = "love表的id，自增")
    private int id=0;
    @ApiModelProperty(value = "userId,关注者",required = true)
    private String userId="";
    @ApiModelProperty(value = "toUserId,被关注者",required = true)
    private String toUserId="";
    @ApiModelProperty(value = "状态，0=未关注，1=已关注")
    private int love = 0;

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

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }
}
