package com.tutorial.blog.service;

import com.tutorial.blog.vo.Result;
import com.tutorial.blog.vo.TagVo;
import com.tutorial.blog.vo.params.PageParams;

import java.util.List;

public interface TagService {

    List<TagVo> findTagsByArticleId(Long id);

    List<TagVo> hot(int limit);

    /**
     * 查询所有的文章标签
     * @return
     */
    Result findAll();

    Result findAllDetail();

    Result findDetailById(Long id);
}
