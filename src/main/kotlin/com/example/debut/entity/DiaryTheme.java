package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "DiaryTheme", description = "大分类，为日记分类，这是大分类，小分类是DiarySubTheme")
public class DiaryTheme {
    @ApiModelProperty(value = "diary_theme表的id,自增")
    private int id = 0;
    @ApiModelProperty(value = "大分类ID")
    private int themeId = 1;
    @ApiModelProperty(value = "大分类名称")
    private String themeName = "";
    @ApiModelProperty(value = "大分类下的小分类列表")
    private List<DiarySubTheme> subThemes = new ArrayList<>();

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

    public void setSubThemes(List<DiarySubTheme> subThemes) {
        this.subThemes = subThemes;
    }

    public List<DiarySubTheme> getSubThemes() {
        return subThemes;
    }
}
