package com.qffz.service;

import com.qffz.pojo.MajorOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    MajorOption getStuMajorData();

    List<Map> getStuGenderData();
}
