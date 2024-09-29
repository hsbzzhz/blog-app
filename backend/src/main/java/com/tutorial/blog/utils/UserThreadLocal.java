package com.tutorial.blog.utils;


import com.tutorial.blog.dao.pojo.SysUser;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/9/29
 */

public class UserThreadLocal {

    private UserThreadLocal(){}

    //线程变量隔离
    private static final ThreadLocal<SysUser> LOCAL = new ThreadLocal<>();

    public static void put(SysUser sysUser){
        LOCAL.set(sysUser);
    }

    public static SysUser get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
