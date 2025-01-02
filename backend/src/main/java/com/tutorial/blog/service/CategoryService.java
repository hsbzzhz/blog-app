package com.tutorial.blog.service;

import com.tutorial.blog.vo.CategoryVo;
import com.tutorial.blog.vo.Result;

public interface CategoryService {
    CategoryVo findCategoryById(Long id);

    Result findAll();

    Result findAllDetail();
}
