package com.qffz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String stunum;
    private String name;
    private String password;
    private String image;
    private String gender;
    private Integer age;
    private Integer majorId;
    private String email;
    private LocalDateTime enterTime;
    private LocalDateTime updateTime;

    private String majorName;

    private List<StuUpload> UploadList;
}
