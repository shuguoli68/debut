package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "token实体")
public class Token {
    @ApiModelProperty(value = "Id,自增")
    private int id = 0;
    @ApiModelProperty(value = "用户userId")
    private String user_id = "";
    @ApiModelProperty(value = "token,每次登录会重新生成")
    private String user_token = "";

    public Token() {
    }

    public Token(int id, String user_id, String user_token) {
        this.id = id;
        this.user_id = user_id;
        this.user_token = user_token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", user_token='" + user_token + '\'' +
                '}';
    }
}
