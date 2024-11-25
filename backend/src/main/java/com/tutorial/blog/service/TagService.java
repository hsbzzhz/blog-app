package com.tutorial.blog.service;

import com.tutorial.blog.vo.Result;
import com.tutorial.blog.vo.TagVo;

import java.util.List;

public interface TagService {

    List<TagVo> findTagsByArticleId(Long id);

    List<TagVo> hot(int limit);

    Result findAll();
}
