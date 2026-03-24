package com.qffz.service.Impl;

import com.qffz.mapper.StuLogMapper;

import com.qffz.pojo.StuLog;

import com.qffz.service.StuLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StuLogServiceImpl implements StuLogService {

    @Autowired
    private StuLogMapper stuLogMapper;

    @Transactional
    @Override
    public void insertLog(StuLog stuLog) {
        stuLogMapper.insert(stuLog);
    }
}
