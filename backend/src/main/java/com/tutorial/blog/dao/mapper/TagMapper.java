package com.tutorial.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tutorial.blog.dao.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {
}
