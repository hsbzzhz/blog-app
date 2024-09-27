package com.tutorial.blog.service;

import com.tutorial.blog.vo.TagVo;

import java.util.List;

public interface TagService {
    List<TagVo> findTagsByArticleId(Long id);
}
