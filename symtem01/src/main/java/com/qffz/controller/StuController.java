package com.qffz.controller;

import com.qffz.pojo.*;
import com.qffz.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/qffz_stu")
@RestController
public class StuController {
    @Autowired
    private StuService stuService;
    @GetMapping
    public Result page(StuQueryParam stuQueryParam){
        log.info("分页查询: {}", stuQueryParam);
        PageResult<Student> pagelist = stuService.page(stuQueryParam);
        return Result.success(pagelist);
    }

    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除部门: ids : {} ", ids);
        stuService.deleteByIds(ids);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("新增学生: {}" , student);
        stuService.add(student);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询, id: {}" , id);
        return Result.success(stuService.getById(id));
    }
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学生, stu: {}" , student);
        stuService.update(student);
        return Result.success();
    }
}
