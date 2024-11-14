package com.tutorial.blog.controller;

import com.tutorial.blog.service.LoginService;
import com.tutorial.blog.vo.Result;
import com.tutorial.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private LoginService loginService;

    public Result register(@RequestBody LoginParam loginParam) {
        return loginService.register(loginParam);
    }
}
