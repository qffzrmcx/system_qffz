package com.qffz.controller;

import com.qffz.pojo.MajorOption;
import com.qffz.pojo.Result;
import com.qffz.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计各个专业的学生人数
     */
    @GetMapping("/stuMajorData")
    public Result getEmpJobData(){
        log.info("统计各个专业的学生人数");
        MajorOption jobOption = reportService.getStuMajorData();
        return Result.success(jobOption);
    }
    /**
     * 统计学生性别信息
     */
    @GetMapping("/stuGenderData")
    public Result getStuGenderData(){
        log.info("统计学生性别信息");
        List<Map> genderList = reportService.getStuGenderData();
        return Result.success(genderList);
    }
}
