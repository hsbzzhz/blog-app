package com.huawei.homework.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huawei.homework.entity.User;
import com.huawei.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usr")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public List<User> findAllUsers(){
        return userService.list();
    }

    @GetMapping("findByName/{name}")
    public User findByName(@PathVariable("name") String name){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("gender",name);
        return userService.getOne(wrapper);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/deleteByYear/{year}")
    public boolean deleteByYear(@PathVariable("year") Integer year){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("birth",year);
        return userService.remove(wrapper);
    }

//    改
//    https://blog.csdn.net/m0_67401660/article/details/126065902
}
