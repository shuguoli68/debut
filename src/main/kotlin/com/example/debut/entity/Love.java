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
}
