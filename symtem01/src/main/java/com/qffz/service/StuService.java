package com.qffz.service;

import java.util.List;

import com.qffz.pojo.*;

public interface StuService {
    PageResult<Student> page(StuQueryParam stuQueryParam);

    void add(Student student);

    Student getById(Integer id);

    void update(Student student);

    void deleteByIds(List<Integer> ids);

    Result login(Student student);
}
