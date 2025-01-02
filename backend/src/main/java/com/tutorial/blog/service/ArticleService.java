package com.tutorial.blog.service;

import com.tutorial.blog.vo.ArticleVo;
import com.tutorial.blog.vo.Result;
import com.tutorial.blog.vo.params.ArticleParam;
import com.tutorial.blog.vo.params.PageParams;

import java.util.List;

public interface ArticleService {
    /**
     * 分页查询 文章列表
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);


    /**
     * 最热文章
     * @param limit
     * @return
     */
    Result hotArticle(int limit);

    /**
     * 最新文章
     * @param limit
     * @return
     */
    Result newArticles(int limit);

    /**
     * 文章归档
     * @return
     */
    Result listArchives();

    /**
     * 查看文章详情
     * @param id
     * @return
     */
    Result findArticleById(Long id);

    /**
     * 文章发布服务
     * @param articleParam
     * @return
     */
    Result publish(ArticleParam articleParam);

    /**
     * 文章搜索
     * @param search
     * @return
     */
    Result searchArticle(String search);
}
