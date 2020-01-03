package com.example.debut.entity;

import java.util.ArrayList;
import java.util.List;

public class DiaryTag {
    private int id = 0;
    private String tagId = "";
    private String tagStr = "";

    public DiaryTag() {
    }

    public DiaryTag(int id, String tagId, String tagStr) {
        this.id = id;
        this.tagId = tagId;
        this.tagStr = tagStr;
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

    public String getTagStr() {
        return tagStr;
    }

    public void setTagStr(String tagStr) {
        this.tagStr = tagStr;
    }
}
