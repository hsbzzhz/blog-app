package com.huawei.homework.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huawei.homework.entity.User;
import com.huawei.homework.service.UserService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import resp.CommonResp;

import java.util.List;

@RestController
@RequestMapping("/usr")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public List<User> findAllUsers(){
        return userService.list();
    }

    @GetMapping("findByName/{name}")
    public User findByName(@Length(min = 3, message = "name最少为3") @PathVariable("name") String name){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("gender",name);
        return userService.getOne(wrapper);
    }

    @PostMapping("/add")
    public CommonResp add(@Validated @RequestBody User user){
        CommonResp resp = new CommonResp();
        userService.save(user);
        return resp;
    }

    @DeleteMapping("/deleteByYear/{year}")
    public boolean deleteByYear(@PathVariable("year") Integer year){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("birth",year);
        return userService.remove(wrapper);
    }
}
