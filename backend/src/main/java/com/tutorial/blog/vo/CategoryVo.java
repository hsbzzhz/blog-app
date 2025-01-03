package com.tutorial.blog.vo;


import lombok.Data;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/9/26
 */

@Data
public class CategoryVo {

    private Long id;

    private String avatar;

    private String categoryName;

    private String description;
}
