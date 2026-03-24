package com.qffz.mapper;

import com.qffz.pojo.Major;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MjMapper {
    @Select("select id, name, create_time, update_time from major order by update_time desc")
    List<Major> findAll();

    @Delete("delete from major where id = #{id}")
    void delete(Integer id);

    @Insert("insert into major(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void add(Major major);

    @Select("select id, name, create_time, update_time from major where id = #{id}")
    Major getById(Integer id);

    @Insert("update major set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Major major);
}
