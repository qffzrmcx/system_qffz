package com.qffz.mapper;

import com.qffz.pojo.StuUpload;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuUploadMapper {
    void deleteByStuIds(List<Integer> ids);

    void addBatch(List<StuUpload> uploadList);
}
