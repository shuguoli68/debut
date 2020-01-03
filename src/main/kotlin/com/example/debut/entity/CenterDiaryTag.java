package com.example.debut.entity;

public class CenterDiaryTag {
    private int id = 0;
    private String tagId ="";
    private String diaryId = "";

    public CenterDiaryTag() {
    }

    public CenterDiaryTag(int id,  String diaryId, String tagId) {
        this.id = id;
        this.tagId = tagId;
        this.diaryId = diaryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(String diaryId) {
        this.diaryId = diaryId;
    }
}
