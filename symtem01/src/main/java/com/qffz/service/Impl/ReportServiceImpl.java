package com.qffz.service.Impl;

import com.qffz.mapper.StuMapper;
import com.qffz.pojo.Major;
import com.qffz.pojo.MajorOption;
import com.qffz.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public MajorOption getStuMajorData() {
        List<Map<String,Object>> list = stuMapper.countStuMajorData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new MajorOption(jobList, dataList);
    }
    @Override
    public List<Map> getStuGenderData() {
        return stuMapper.countStuGenderData();
    }
}
