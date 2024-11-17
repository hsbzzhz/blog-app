package com.tutorial.blog.vo;


import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/9/26
 */

@Data
public class ArticleVo {
    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    private int weight;
    /**
     * 创建时间
     */
    private String createDate;

    private String author;

    private ArticleBodyVo body;

    private List<TagVo> tags;

    private List<CategoryVo> categoryVos;
}
