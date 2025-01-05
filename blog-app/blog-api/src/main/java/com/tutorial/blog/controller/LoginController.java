package com.tutorial.blog.controller;


import com.tutorial.blog.service.LoginService;
import com.tutorial.blog.vo.Result;
import com.tutorial.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/9/27
 */

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public Result login(@RequestBody LoginParam loginParam){

        return loginService.login(loginParam);
    }

    @GetMapping("logout")
    public Result logout(@RequestHeader("Authorization") String token){
        return loginService.logout(token);
    }
}
