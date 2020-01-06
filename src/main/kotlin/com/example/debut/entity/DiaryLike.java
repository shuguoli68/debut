package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DiaryLike", description = "用户对日记的操作，赞、踩、收藏")
public class DiaryLike {
    @ApiModelProperty(value = "diary_like表的id,自增")
    private int id = 0;
    @ApiModelProperty(value = "用户ID")
    private String userId = "";
    @ApiModelProperty(value = "日记ID")
    private String diaryId = "";
    @ApiModelProperty(value = "用户对日记的操作，赞(1)、踩(0),默认1")
    private int love = 1;
    @ApiModelProperty(value = "用户对日记的操作，收藏(1),取消收藏(0),默认0")
    private int collect = 0;

    public DiaryLike() {
    }

    public DiaryLike(int id, String userId, String diaryId, int love, int collect) {
        this.id = id;
        this.userId = userId;
        this.diaryId = diaryId;
        this.love = love;
        this.collect = collect;
    }

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

    public String getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(String diaryId) {
        this.diaryId = diaryId;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }
}
