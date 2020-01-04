package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DiarySubTheme", description = "子主题，为日志大分类下的小分类，大分类是DiaryTheme")
public class DiarySubTheme {
    @ApiModelProperty(value = "diary_sub_theme表的id,自增")
    private int id = 0;
    @ApiModelProperty(value = "子主题ID")
    private int subThemeId = 1;
    @ApiModelProperty(value = "子主题名称")
    private String subThemeName = "";
    @ApiModelProperty(value = "主题ID")
    private int themeId = 1;
}
