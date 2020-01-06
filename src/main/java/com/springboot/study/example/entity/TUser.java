package com.springboot.study.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com.springboot.study.example.entity.TUser")
@Data
public class TUser {
    @ApiModelProperty(value="null")
    private Integer id;

    @ApiModelProperty(value="null")
    private String userName;

    @ApiModelProperty(value="null")
    private Integer sex;

    @ApiModelProperty(value="null")
    private String note;
}