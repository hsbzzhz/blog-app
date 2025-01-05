package com.tutorial.blog.service;

import com.tutorial.blog.dao.pojo.SysUser;

public interface UserService {
    public SysUser findUserById(Long userId);
}
