package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DiaryTheme", description = "主题，为日志分类，这是大分类，小分类是DiarySubTheme")
public class DiaryTheme {
    @ApiModelProperty(value = "diary_theme表的id,自增")
    private int id = 0;
    @ApiModelProperty(value = "主题ID")
    private int themeId = 1;
    @ApiModelProperty(value = "主题名称")
    private String themeName = "";


    public DiaryTheme() {
    }

    public DiaryTheme(int id, int themeId, String themeName) {
        this.id = id;
        this.themeId = themeId;
        this.themeName = themeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
}
