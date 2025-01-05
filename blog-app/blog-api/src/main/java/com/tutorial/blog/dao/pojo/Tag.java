package com.tutorial.blog.dao.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description:
 * @Author: Hongzhi Zhang
 * @Date: 2024/9/26
 */

@Data
//@TableName("ms_tag")
public class Tag {
    private Long id;

    private String avatar;

    private String tagName;
}
