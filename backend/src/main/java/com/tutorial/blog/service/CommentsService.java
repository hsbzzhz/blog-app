package com.tutorial.blog.service;

import com.tutorial.blog.vo.Result;
import com.tutorial.blog.vo.params.CommentParam;


public interface CommentsService {
    Result commentsByArticleId(Long articleId);

    Result comment(CommentParam commentParam);
}
