package com.tutorial.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tutorial.blog.dao.mapper.ArticleMapper;
import com.tutorial.blog.dao.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ThreadService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostConstruct
    public void initViewCount(){
        //为了 保证 启动项目的时候，redis中的浏览量 如果没有，读取数据库的数据，进行初始化
        //便于更新的时候 自增
        List<Article> articles = articleMapper.selectList(new LambdaQueryWrapper<>());
        for (Article article : articles) {
            String viewCountStr = (String) redisTemplate.opsForHash().get("view_count", String.valueOf(article.getId()));
            if (viewCountStr == null){
                //初始化
                redisTemplate.opsForHash().put("view_count", String.valueOf(article.getId()),String.valueOf(article.getViewCounts()));
            }
        }
    }

    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, Article article){

//        Article articleUpdate = new Article();
//        articleUpdate.setViewCounts(article.getViewCounts() + 1);
//        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Article::getId,article.getId());
//        queryWrapper.eq(Article::getViewCounts,article.getViewCounts());
//        articleMapper.update(articleUpdate,queryWrapper);
//        try {
//            //睡眠5秒 证明不会影响主线程的使用
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //采用redis进行浏览量的增加
        //hash结构 key 浏览量标识 field 文章id  后面1 表示自增加1
        redisTemplate.opsForHash().increment("view_count",String.valueOf(article.getId()),1);
        //定时任务在ViewCountHandler中

        //还有一种方式是，redis自增之后，直接发送消息到消息队列中，由消息队列进行消费 来同步数据库，比定时任务要好一些
    }
}
