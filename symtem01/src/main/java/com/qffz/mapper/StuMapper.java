package com.qffz.mapper;

import com.qffz.pojo.StuQueryParam;
import com.qffz.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StuMapper {

    List<Student> list(StuQueryParam stuQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into student(stunum, name, password, image, gender, age, major_id, email, enter_time, update_time) values" +
            "(#{stunum}, #{name}, #{password}, #{image}, #{gender}, #{age}, #{majorId}, #{email}, #{enterTime}, #{updateTime})")
    void add(Student student);

    Student getById(Integer id);
    //修改的注释
    @Insert("update student set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Student student);

    void deleteByIds(List<Integer> ids);

    void updateById(Student student);

    @MapKey("pos")
    List<Map<String,Object>> countStuMajorData();

    List<Map> countStuGenderData();

    @Select("select id, stunum, name from student where stunum = #{stunum}")
    Student getStunum(Student student);

    @Select("select id, password, name from student where password = #{password}")
    Student getPassword(Student student);
}
