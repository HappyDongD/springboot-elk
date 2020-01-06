package com.springboot.study.example.service;

import com.springboot.study.example.entity.SysLogError;

public interface SysLogErrorService {


    int deleteByPrimaryKey(Long id);

    int insert(SysLogError record);

    int insertSelective(SysLogError record);

    SysLogError selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLogError record);

    int updateByPrimaryKey(SysLogError record);

}


