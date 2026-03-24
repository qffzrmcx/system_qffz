package com.qffz.controller;

import com.qffz.pojo.Login;
import com.qffz.pojo.Result;
import com.qffz.pojo.Student;
import com.qffz.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private StuService stuService;

    @PostMapping("/login")
    public Result login(@RequestBody Student student){
        log.info("学生来登录啦 , {}", student);
        return stuService.login(student);
    }
}
