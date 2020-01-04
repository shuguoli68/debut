package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CenterDiaryTheme", description = "日记和分类的中间表")
public class CenterDiaryTheme {
    @ApiModelProperty(value = "center_diary_theme表的id,自增")
    private int id = 0;
    @ApiModelProperty(value = "日记ID")
    private String diaryId = "";
    @ApiModelProperty(value = "大分类ID")
    private int themeId = 1;
    @ApiModelProperty(value = "小分类ID")
    private int subThemeId = 1;

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

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public int getSubThemeId() {
        return subThemeId;
    }

    public void setSubThemeId(int subThemeId) {
        this.subThemeId = subThemeId;
    }
}
