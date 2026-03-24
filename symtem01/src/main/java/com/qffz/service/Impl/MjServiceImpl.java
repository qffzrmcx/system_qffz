package com.qffz.service.Impl;

import com.qffz.mapper.MjMapper;
import com.qffz.mapper.StuMapper;
import com.qffz.pojo.Major;
import com.qffz.pojo.Student;
import com.qffz.service.MjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MjServiceImpl implements MjService {
    @Autowired
    private MjMapper mjMapper;
    @Override
    public List<Major> findAll(){
        return mjMapper.findAll();
    }
    @Override
    public void delete(Integer id){
        mjMapper.delete(id);
    }
    @Override
    public void add(Major major){
        major.setCreateTime(LocalDateTime.now());
        major.setUpdateTime(LocalDateTime.now());
        mjMapper.add(major);
    }
    @Override
    public Major getById(Integer id){
        return mjMapper.getById(id);
    }
    @Override
    public void update(Major major){
        major.setUpdateTime(LocalDateTime.now());
        mjMapper.update(major);
    }
}
