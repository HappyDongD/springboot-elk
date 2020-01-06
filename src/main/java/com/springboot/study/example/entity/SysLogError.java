package com.springboot.study.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@ApiModel(value = "com.springboot.study.example.entity.SysLogError")
@Data
@Table(name = "sys_log_error")
public class SysLogError {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 请求URI
     */
    @Column(name = "request_uri")
    @ApiModelProperty(value = "请求URI")
    private String requestUri;

    /**
     * 请求方式
     */
    @Column(name = "request_method")
    @ApiModelProperty(value = "请求方式")
    private String requestMethod;

    /**
     * 请求参数
     */
    @Column(name = "request_params")
    @ApiModelProperty(value = "请求参数")
    private String requestParams;

    /**
     * 用户代理
     */
    @Column(name = "user_agent")
    @ApiModelProperty(value = "用户代理")
    private String userAgent;

    /**
     * 操作IP
     */
    @Column(name = "ip")
    @ApiModelProperty(value = "操作IP")
    private String ip;

    /**
     * 异常信息
     */
    @Column(name = "error_info")
    @ApiModelProperty(value = "异常信息")
    private String errorInfo;

    /**
     * 创建者
     */
    @Column(name = "creator")
    @ApiModelProperty(value = "创建者")
    private Long creator;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
}