package com.springboot.study.common.response;


import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

public class ResponseResultVo<T> {
    private static final long serialVersionUID = 1679552421651455773L;
    @ApiModelProperty(value = "是否成功")
    private String sucess;
    @ApiModelProperty(value = "状态码")
    private Integer status;
    @ApiModelProperty(value = "数据")
    private T data;
    @ApiModelProperty(value = "返回信息")
    private String msg;
    @ApiModelProperty("额外数据")
    private Map<String, Object> extra;


    public Map<String, Object> getExtra() {
        return extra;
    }

    public ResponseResultVo<T> setExtra(Map<String, Object> extra) {
        this.extra = extra;
        return this;
    }


    public String getSucess() {
        return sucess;
    }

    public ResponseResultVo<T> setSucess(String sucess) {
        this.sucess = sucess;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ResponseResultVo<T> setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResultVo<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseResultVo<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResponseResultVo() {
    }

    public static <T> ResponseResultVo<T> ok(ResultVoStatus resultVoStatus) {
        return new ResponseResultVo().setMsg(resultVoStatus.getMsg())
                .setStatus(resultVoStatus.getStatus())
                .setSucess("success");
    }


    public static <T> ResponseResultVo<T> sucess(T data) {
        return new ResponseResultVo()
                .setMsg(ResultVoStatus.OK.getMsg())
                .setData(data)
                .setStatus(ResultVoStatus.OK.getStatus())
                .setSucess("true");
    }

    public static <T> ResponseResultVo<T> sucess() {
        return new ResponseResultVo()
                .setMsg(ResultVoStatus.OK.getMsg())
                .setData("你的请求非常完美，我说的！")
                .setStatus(ResultVoStatus.OK.getStatus())
                .setSucess("true");
    }

    public static ResponseResultVo faild(ResultVoStatus resultVoStatus) {
        return new ResponseResultVo()
                .setSucess("false")
                .setStatus(resultVoStatus.getStatus())
                .setMsg(resultVoStatus.getMsg());
    }

    public static ResponseResultVo faild(Integer status, String msg) {
        return new ResponseResultVo()
                .setMsg(msg)
                .setStatus(status)
                .setSucess("false");
    }

    public ResponseResultVo<T> addExtraIfTrue(boolean bool, String key, Object value) {
        if (bool) {
            addExtra(key, value);
        }
        return this;
    }

    public ResponseResultVo<T> addExtra(String key, Object value) {
        extra = extra == null ? new HashMap<>(16) : extra;
        extra.put(key, value);
        return this;
    }
}
