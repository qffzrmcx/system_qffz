package com.qffz.mapper;

import com.qffz.pojo.StuLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuLogMapper {
    //插入日志
    @Insert("insert into stu_log (operate_time, info) values (#{operateTime}, #{info})")
    public void insert(StuLog stuLog);
}
