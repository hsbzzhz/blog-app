package com.tutorial.blog.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tutorial.blog.dao.pojo.ArticleBody;
import com.tutorial.blog.dao.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/11/21
 */

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
