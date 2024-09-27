package com.tutorial.blog.controller;


import com.tutorial.blog.service.TagService;
import com.tutorial.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/9/27
 */

@RestController
@RequestMapping("tags")
public class TagsController {

    @Autowired
    private TagService tagService;

    @GetMapping("/hot")
    public Result listHotTags() {
        return (Result) tagService.findTagsByArticleId(1L);
    }
}
