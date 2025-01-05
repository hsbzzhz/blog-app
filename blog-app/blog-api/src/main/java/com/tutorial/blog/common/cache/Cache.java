package com.tutorial.blog.common.cache;


import java.lang.annotation.*;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2025/1/3
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    long expire() default 60 * 1000;

    String name() default "";
}
