package com.qffz.controller;

import com.qffz.pojo.Result;
import com.qffz.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
public class UpImageController {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/up_image")
    public Result upload(MultipartFile file) throws Exception {
        log.info("上传文件：{}", file);
        // 上传文件
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("上传成功，文件地址为：{}", url);
        return Result.success(url);

    }

}
