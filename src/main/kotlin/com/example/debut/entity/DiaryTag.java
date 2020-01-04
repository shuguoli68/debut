package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "DiaryTag")
public class DiaryTag {
    @ApiModelProperty(value = "diary_tag表的id,自增")
    private int id = 0;
    @ApiModelProperty(value = "类别ID")
    private String tagId = "";
    @ApiModelProperty(value = "类别名称")
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
