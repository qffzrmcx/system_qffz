package com.qffz.pojo;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StuUpload {
    private Integer id;
    private Integer stuId;
    private String content;
    private LocalDateTime uploadTime;
}
