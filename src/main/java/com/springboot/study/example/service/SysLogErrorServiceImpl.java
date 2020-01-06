package com.springboot.study.example.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.springboot.study.example.mapper.SysLogErrorMapper;
import com.springboot.study.example.entity.SysLogError;
import com.springboot.study.example.service.SysLogErrorService;

@Service
public class SysLogErrorServiceImpl implements SysLogErrorService {

    @Resource
    private SysLogErrorMapper sysLogErrorMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysLogErrorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysLogError record) {
        return sysLogErrorMapper.insert(record);
    }

    @Override
    public int insertSelective(SysLogError record) {
        return sysLogErrorMapper.insertSelective(record);
    }

    @Override
    public SysLogError selectByPrimaryKey(Long id) {
        return sysLogErrorMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysLogError record) {
        return sysLogErrorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysLogError record) {
        return sysLogErrorMapper.updateByPrimaryKey(record);
    }

}


