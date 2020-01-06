package com.example.debut.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DiaryLikeCount", description = "日记的赞、踩、收藏的数量")
public class DiaryLikeCount {
    @ApiModelProperty(value = "diary_like_count表的id,自增")
    private int id = 0;
    @ApiModelProperty(value = "日记ID")
    private String diaryId = "";
    @ApiModelProperty(value = "日记的赞数量")
    private int love = 0;
    @ApiModelProperty(value = "日记的踩数量")
    private int unlove = 0;
    @ApiModelProperty(value = "日记的收藏数量")
    private int collect = 0;

    public DiaryLikeCount() {
    }

    public DiaryLikeCount(int id, String diaryId, int love, int unlove, int collect) {
        this.id = id;
        this.diaryId = diaryId;
        this.love = love;
        this.unlove = unlove;
        this.collect = collect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUnlove() {
        return unlove;
    }

    public void setUnlove(int unlove) {
        this.unlove = unlove;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }
}
