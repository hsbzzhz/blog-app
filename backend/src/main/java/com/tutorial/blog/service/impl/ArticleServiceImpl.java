package com.tutorial.blog.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tutorial.blog.dao.mapper.ArticleMapper;
import com.tutorial.blog.dao.pojo.Article;
import com.tutorial.blog.dao.pojo.SysUser;
import com.tutorial.blog.service.ArticleService;
import com.tutorial.blog.service.TagService;
import com.tutorial.blog.vo.ArticleVo;
import com.tutorial.blog.vo.TagVo;
import com.tutorial.blog.vo.params.PageParams;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/9/27
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

//    @Autowired
//    private SysUserService sysUserService;

//    @Autowired
//    private TagService tagsService;

    public ArticleVo copy(Article article){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
//        if (isAuthor) {
//            SysUser sysUser = sysUserService.findSysUserById(article.getAuthorId());
//            articleVo.setAuthor(sysUser.getNickname());
//        }
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
//        if (isTags){
//            List<TagVo> tags = tagsService.findTagsByArticleId(article.getId());
//            articleVo.setTags(tags);
//        }
        return articleVo;
    }

    private List<ArticleVo> copyList(List<Article> records) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article article : records) {
            ArticleVo articleVo = copy(article);
            articleVoList.add(articleVo);
        }
        return articleVoList;
    }


    @Override
    public List<ArticleVo> listArticlesPage(PageParams pageParams) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        Page<Article> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<ArticleVo> articleVoList = copyList(articlePage.getRecords());
        return articleVoList;
    }

    @Override
    public ArticleVo findArticleById(Long id) {
        Article article = articleMapper.selectById(id);
        return copy(article);
    }
}
