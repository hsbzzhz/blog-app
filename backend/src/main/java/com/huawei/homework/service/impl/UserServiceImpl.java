package com.huawei.homework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huawei.homework.entity.User;
import com.huawei.homework.mapper.UserMapper;
import com.huawei.homework.service.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService, ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("async初始化user info");
    }
}
