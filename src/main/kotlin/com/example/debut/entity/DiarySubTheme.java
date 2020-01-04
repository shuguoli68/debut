package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DiarySubTheme", description = "小分类，为日记大分类下的小分类，大分类是DiaryTheme")
public class DiarySubTheme {
    @ApiModelProperty(value = "diary_sub_theme表的id,自增")
    private int id = 0;
    @ApiModelProperty(value = "小分类ID")
    private int subThemeId = 1;
    @ApiModelProperty(value = "小分类名称")
    private String subThemeName = "";
    @ApiModelProperty(value = "大分类ID")
    private int themeId = 1;

    public DiarySubTheme() {
    }

    public DiarySubTheme(int id, int subThemeId, String subThemeName, int themeId) {
        this.id = id;
        this.subThemeId = subThemeId;
        this.subThemeName = subThemeName;
        this.themeId = themeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubThemeId() {
        return subThemeId;
    }

    public void setSubThemeId(int subThemeId) {
        this.subThemeId = subThemeId;
    }

    public String getSubThemeName() {
        return subThemeName;
    }

    public void setSubThemeName(String subThemeName) {
        this.subThemeName = subThemeName;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }
}
