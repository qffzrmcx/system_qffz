package com.qffz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录成功结果封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    private Integer id; //学生ID
    private String stunum; //学号
    private String name;//姓名
    private String token; //令牌
}

