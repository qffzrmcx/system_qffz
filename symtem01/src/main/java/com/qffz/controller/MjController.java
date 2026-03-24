package com.qffz.controller;

import com.qffz.pojo.Result;
import com.qffz.pojo.Major;
import com.qffz.service.MjService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/qffz_mj")
@RestController
public class MjController {
    @Autowired
    private MjService mjService;
    @GetMapping
    public Result findAll(){
        log.info("查询专业列表");
        List<Major> list = mjService.findAll();
        return Result.success(list);
    }
    @DeleteMapping
    public Result delete(Integer id){
        log.info("根据id删除专业, id: {}" , id);
        mjService.delete(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Major major){
        log.info("新增专业, dept: {}" , major);
        mjService.add(major);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询, id: {}" , id);
        return Result.success(mjService.getById(id));
    }
    @PutMapping
    public Result update(@RequestBody Major major){
        log.info("修改专业, dept: {}" , major);
        mjService.update(major);
        return Result.success();
    }
}
