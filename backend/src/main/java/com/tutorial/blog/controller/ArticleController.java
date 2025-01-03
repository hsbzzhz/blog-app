package com.tutorial.blog.controller;


import com.tutorial.blog.common.cache.Cache;
import com.tutorial.blog.service.ArticleService;
import com.tutorial.blog.vo.Result;
import com.tutorial.blog.vo.params.ArticleParam;
import com.tutorial.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/9/27
 */

@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 首页 文章列表
     * @param pageParams
     * @return
     */
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams) {
        //ArticleVo 页面接收的数据
        return articleService.listArticle(pageParams);
    }

    @PostMapping("hot")
    @Cache(expire = 5 * 60 * 1000,name = "hot_article")
    public Result hotArticle(){
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long id) {
        Result articleVo = articleService.findArticleById(id);

        return Result.success(articleVo);
    }

    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }
}
