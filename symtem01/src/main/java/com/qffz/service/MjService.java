package com.qffz.service;

import java.util.List;
import com.qffz.pojo.Major;

public interface MjService {
    List<Major> findAll();

    void delete(Integer id);

    void add(Major student);

    Major getById(Integer id);

    void update(Major student);
}
