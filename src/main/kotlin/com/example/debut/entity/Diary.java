package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@ApiModel(value = "Diary")
public class Diary{
    @ApiModelProperty(value = "日记diaryId")
    private String diaryId = "";
    @ApiModelProperty(value = "日记标题")
    private String title= "";
    @ApiModelProperty(value = "日记内容")
    private String content = "";
    @ApiModelProperty(value = "日记大分类")
    private int theme = 0;
    @ApiModelProperty(value = "日记小分类")
    private int subTheme = 0;
    @ApiModelProperty(value = "日记首次发布时间")
    private Date ctTime = new Date();
    @ApiModelProperty(value = "日记更新时间")
    private Date utTime = new Date();
    @ApiModelProperty(value = "发布人的userId")
    private String userId = "";
    @ApiModelProperty(value = "标签的tagId,用|隔开")
    private String tagId = "";
    @ApiModelProperty(value = "日记列表")
    private List<DiaryTag> diaryTags= new ArrayList<>();

    public String getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(String diaryId) {
        this.diaryId = diaryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public int getSubTheme() {
        return subTheme;
    }

    public void setSubTheme(int subTheme) {
        this.subTheme = subTheme;
    }

    public Date getCtTime() {
        return ctTime;
    }

    public void setCtTime(Date ctTime) {
        this.ctTime = ctTime;
    }

    public Date getUtTime() {
        return utTime;
    }

    public void setUtTime(Date utTime) {
        this.utTime = utTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<DiaryTag> getDiaryTags() {
        return diaryTags;
    }

    public void setDiaryTags(List<DiaryTag> diaryTags) {
        this.diaryTags = diaryTags;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }
}