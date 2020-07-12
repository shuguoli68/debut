package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "Foot", description = "用户浏览表")
public class Foot {
    @ApiModelProperty(value = "foot表的id，自增")
    private int id=0;
    @ApiModelProperty(value = "userId,查看者",required = true)
    private String userId="";
    @ApiModelProperty(value = "toUserId,被查看者",required = true)
    private String toUserId="";
    @ApiModelProperty(value = "状态，0=未浏览，1=已浏览")
    private int foot = 1;
    @ApiModelProperty(value = "创建时间,只需要年月日")
    private Date ctTime = new Date();
    @ApiModelProperty(value = "创建时间,年月日时分秒")
    private Date strTime = new Date();
//    @ApiModelProperty(value = "别人的信息，我浏览过的人或浏览过我的人")
//    private User user = new User();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public int getFoot() {
        return foot;
    }

    public void setFoot(int foot) {
        this.foot = foot;
    }

    public Date getCtTime() {
        return ctTime;
    }

    public void setCtTime(Date ctTime) {
        this.ctTime = ctTime;
    }

    public Date getStrTime() {
        return strTime;
    }

    public void setStrTime(Date strTime) {
        this.strTime = strTime;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
