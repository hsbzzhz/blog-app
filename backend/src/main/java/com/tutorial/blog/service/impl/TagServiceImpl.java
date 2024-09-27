package com.tutorial.blog.service.impl;


import com.tutorial.blog.dao.mapper.TagMapper;
import com.tutorial.blog.dao.pojo.Tag;
import com.tutorial.blog.service.TagService;
import com.tutorial.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/9/26
 */

@Service
public class TagServiceImpl implements TagService {

    @Override
    public List<TagVo> findTagsByArticleId(Long id) {
        return Collections.emptyList();
    }
}
