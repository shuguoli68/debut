package com.example.debut.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Banner", description = "首页banner图片")
public class Banner {
    @ApiModelProperty(value = "banner表的id,自增")
    private int id = 0;
    @ApiModelProperty(value = "图片地址")
    private String imgPath = "";
    @ApiModelProperty(value = "网页链接地址")
    private String urlPath = "";
    @ApiModelProperty(value = "标题")
    private String title = "";
    @ApiModelProperty(value = "简介，描述文字")
    private String des = "";
    @ApiModelProperty(value = "备用字段")
    private String mstr = "";

    public Banner() {
    }

    public Banner(int id, String imgPath, String urlPath, String title, String des, String mstr) {
        this.id = id;
        this.imgPath = imgPath;
        this.urlPath = urlPath;
        this.title = title;
        this.des = des;
        this.mstr = mstr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getMstr() {
        return mstr;
    }

    public void setMstr(String mstr) {
        this.mstr = mstr;
    }
}
