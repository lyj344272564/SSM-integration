package com.richard.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String accountName;
    private String account;
    private String password;
    private Integer deptId;
    private String email;
    private String mobile;
    private String tel;
    private Integer sex;
    private Date birthday;
}
