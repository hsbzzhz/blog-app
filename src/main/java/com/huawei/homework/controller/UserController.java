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
    // https://blog.csdn.net/Bug_Lian/article/details/111040146?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-111040146-blog-100664897.t5_download_comparev1&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-111040146-blog-100664897.t5_download_comparev1&utm_relevant_index=1

    @DeleteMapping("/deleteByYear/{year}")
    public boolean deleteByYear(@PathVariable("year") Integer year){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("birth",year);
        return userService.remove(wrapper);
    }

//    改
//    https://blog.csdn.net/m0_67401660/article/details/126065902
}
