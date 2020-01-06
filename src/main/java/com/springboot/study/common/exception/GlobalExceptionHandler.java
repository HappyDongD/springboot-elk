package com.springboot.study.common.exception;


import com.springboot.study.common.response.ResponseResultVo;
import com.springboot.study.common.response.ResultVoStatus;
import com.springboot.study.common.util.IpUtil;
import com.springboot.study.example.entity.SysLogError;
import com.springboot.study.example.mapper.SysLogErrorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    SysLogErrorMapper sysLogErrorMapper;

    @ExceptionHandler(HdException.class)
    public ResponseResultVo handleException(HttpServletRequest request,
                                            HttpServletResponse response, HdException e) {

        Exception f=e;
        if(e.getE()!=null){
            f=e.getE();
        }
        StackTraceElement stackTraceElement = f.getStackTrace()[0];
        List<String> strings = Arrays.asList("文件名：" + stackTraceElement.getFileName()
                , "类名：" + stackTraceElement.getClassName()
                , "方法名：" + stackTraceElement.getMethodName()
                , "抛出异常行号：" + stackTraceElement.getLineNumber()
                , "产生的异常为：" + e
        );
        return ResponseResultVo.faild(ResultVoStatus.ErrorException)
                .addExtra("errormsg", f.getMessage())
                .addExtra("exceptionMessage", strings);

    }

    @ExceptionHandler({Exception.class})
    public ResponseResultVo handleServiceException(HttpServletRequest request, Exception e) {
        savelog(request, e);
        return ResponseResultVo.faild(ResultVoStatus.ErrorException)
                .addExtra("stackTrace", e.getStackTrace())
                .addExtra("exceptionMessage", e.getClass().getName() + ": " + e.getMessage());

    }


    private void savelog(HttpServletRequest request,
                         HdException e) {
        SysLogError sysLogError = new SysLogError();
        //获取IP
        String IP = IpUtil.getIpAddrByRequest(request);
        //获取请求路径
        String requestURI = request.getRequestURI();

        //获取请求参数
        Map<String, String[]> maps = request.getParameterMap();
        String cs = null;
        for (Map.Entry<String, String[]> entry : maps.entrySet()) {
            cs = entry.getKey() + ":" + Arrays.toString(entry.getValue()) + ";";
        }
        Exception f = null;
        if (e.getE() != null) {
            f = e.getE();
        } else {
            f = e;
        }
        StackTraceElement stackTraceElement = f.getStackTrace()[0];
        String errorMsg = "文件名：" + stackTraceElement.getFileName() +
                "\r\n类名：" + stackTraceElement.getClassName() +
                "\r\n方法名：" + stackTraceElement.getMethodName() +
                "\r\n抛出异常行号：" + stackTraceElement.getLineNumber() +
                "\r\n产生的异常为：" + e;

        //获取请求类型
        String type = request.getMethod();
        //头信息
        String header = request.getHeader(HttpHeaders.USER_AGENT);
        sysLogError.setCreateDate(new Date());
        sysLogError.setIp(IP);
        sysLogError.setRequestMethod(type);
        sysLogError.setRequestParams(cs);
        sysLogError.setRequestUri(requestURI);
        sysLogError.setUserAgent(header);
        sysLogError.setErrorInfo(errorMsg);
        sysLogErrorMapper.insertSelective(sysLogError);
    }

    private void savelog(HttpServletRequest request,
                         Exception e) {
        SysLogError sysLogError = new SysLogError();
        //获取IP
        String IP = IpUtil.getIpAddrByRequest(request);
        //获取请求路径
        String requestURI = request.getRequestURI();

        //获取请求参数
        Map<String, String[]> maps = request.getParameterMap();
        String cs = null;
        for (Map.Entry<String, String[]> entry : maps.entrySet()) {
            cs = entry.getKey() + ":" + Arrays.toString(entry.getValue()) + ";";
        }

        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        String errorMsg = "文件名：" + stackTraceElement.getFileName() +
                "\r\n类名：" + stackTraceElement.getClassName() +
                "\r\n方法名：" + stackTraceElement.getMethodName() +
                "\r\n抛出异常行号：" + stackTraceElement.getLineNumber() +
                "\r\n产生的异常为：" + e;

        //获取请求类型
        String type = request.getMethod();
        //头信息
        String header = request.getHeader(HttpHeaders.USER_AGENT);
        sysLogError.setCreateDate(new Date());
        sysLogError.setIp(IP);
        sysLogError.setRequestMethod(type);
        sysLogError.setRequestParams(cs);
        sysLogError.setRequestUri(requestURI);
        sysLogError.setUserAgent(header);
        sysLogError.setErrorInfo(errorMsg);
        for (int i = 30; i < 200000000; i++) {
            sysLogError.setId(i);
            sysLogErrorMapper.insertSelective(sysLogError);
        }


    }


}
