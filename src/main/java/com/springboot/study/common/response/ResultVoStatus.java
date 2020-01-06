package com.springboot.study.common.response;

public enum ResultVoStatus {

    //枚举字段以逗号隔开，结尾是分号，必须写在前面
    OK(200,"请求成功"),
    Bad(400,"请求失败"),
    Faild(400,"exportTPdf的异常"),
    wordTopdf(400,"word生成pdf异常"),
    FileOK(200,"文件生成成功！"),
    Success(200,"保存成功"),
    Error(400,"服务异常，插入失败！"),
    ErrorUp(400,"OSS项目上传成功，更新数据失败"),
    FileNotFound(400,"文件未生成！") ,
    ErrorException(500,"内部服务异常"),
    test(500,"test");

    ;



    private  Integer status;
    private  String msg;

    private ResultVoStatus(Integer status, String msg){
        this.status=status;
        this.msg=msg;

    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
