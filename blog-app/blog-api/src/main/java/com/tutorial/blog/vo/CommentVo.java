package com.tutorial.blog.vo;


import lombok.Data;
import java.util.List;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/11/21
 */

@Data
public class CommentVo {

    private Long id;

    private UserVo author;

    private String content;

    private List<CommentVo> childrens;

    private String createDate;

    private Integer level;

    private UserVo toUser;
}
