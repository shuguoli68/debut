package com.example.debut.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Diary{
    private String diaryId = "";
    private String title= "";
    private String content = "";
    private int theme = 0;
    private int subTheme = 0;
    private Date ctTime = new Date();
    private Date utTime = new Date();
    private String userId = "";
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
}