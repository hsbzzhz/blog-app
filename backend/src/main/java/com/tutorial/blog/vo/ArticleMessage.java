package com.tutorial.blog.vo;


import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2025/1/3
 */

@Data
public class ArticleMessage implements Serializable {
    private Long articleId;
}
