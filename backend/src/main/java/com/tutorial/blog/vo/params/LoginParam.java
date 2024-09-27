package com.tutorial.blog.vo.params;


import lombok.Data;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/9/27
 */

@Data
public class LoginParam {

    private String account;

    private String password;

    private String nickname;
}
