package com.springboot.study.example.controller;


import com.springboot.study.common.exception.HdException;
import com.springboot.study.common.response.ResponseResultVo;
import com.springboot.study.common.response.ResultVoStatus;
import com.springboot.study.example.entity.SysLogError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("log")
    public void log(String name) {
        throw  new HdException(ResultVoStatus.Bad);
    }


}


