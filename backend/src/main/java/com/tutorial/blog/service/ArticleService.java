package com.tutorial.blog.service;

import com.tutorial.blog.vo.ArticleVo;
import com.tutorial.blog.vo.params.PageParams;

import java.util.List;

public interface ArticleService {
    /**
     *
     * @param pageParams
     * @return
     */
    List<ArticleVo> listArticlesPage(PageParams pageParams);

    /**
     *
     * @param id
     * @return
     */
    ArticleVo findArticleById(Long id);
}
