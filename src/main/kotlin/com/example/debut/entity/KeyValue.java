package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "KeyValue")
public class KeyValue {
    @ApiModelProperty(value = "KeyValue中的key")
    @NotBlank(message = "key不能为空！")
    private String key;
    @ApiModelProperty(value = "KeyValue中的value")
    @NotBlank(message = "value不能为空！")
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
