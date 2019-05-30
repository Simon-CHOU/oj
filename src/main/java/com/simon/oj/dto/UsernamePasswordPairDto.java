package com.simon.oj.dto;

import lombok.Data;

/**
 * 登陆时，前端首先会传入用户输入的登陆信息
 */
@Data
public class UsernamePasswordPairDto {
    private String username;
    private String password;
}
