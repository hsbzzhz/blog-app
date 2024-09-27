package com.tutorial.blog.service.impl;


import com.tutorial.blog.dao.mapper.SysUserMapper;
import com.tutorial.blog.dao.pojo.SysUser;
import com.tutorial.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/9/27
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long userId) {
        return sysUserMapper.selectById(userId);
    }
}
