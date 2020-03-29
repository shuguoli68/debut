package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DiaryComment", description = "用户对日记的评论、回复")
public class DiaryComment {
    @ApiModelProperty(value = "diary_comment表的id,自增")
    private int id = 0;
    @ApiModelProperty(value = "评论者userID")
    private String userId = "";
    @ApiModelProperty(value = "评论者name")
    private String name = "";
    @ApiModelProperty(value = "日记ID")
    private String diaryId = "";
    @ApiModelProperty(value = "被评论、回复者userId")
    private int beUserId = 0;
    @ApiModelProperty(value = "被评论、回复者name")
    private int beName = 2;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(String diaryId) {
        this.diaryId = diaryId;
    }

    public int getBeUserId() {
        return beUserId;
    }

    public void setBeUserId(int beUserId) {
        this.beUserId = beUserId;
    }

    public int getBeName() {
        return beName;
    }

    public void setBeName(int beName) {
        this.beName = beName;
    }
}
