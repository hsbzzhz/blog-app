package com.tutorial.blog.service;

import com.tutorial.blog.vo.CategoryVo;

public interface CategoryService {
    CategoryVo findCategoryById(Long id);
}
