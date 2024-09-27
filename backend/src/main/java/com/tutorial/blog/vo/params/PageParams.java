package com.tutorial.blog.vo.params;


import lombok.Data;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/9/27
 */

@Data
public class PageParams {

    private int page = 1;

    private int pageSize = 10;
}
