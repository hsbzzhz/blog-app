package com.tutorial.blog;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tutorial.blog.dao.pojo.Tag;
import com.tutorial.blog.dao.mapper.TagMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HomeworkApplicationTests {

	@Autowired
	TagMapper tagMapper;

	@Test
	void getTags(){
		// tagsService.findTagsByArticleId();
		LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(Tag::getTagName, "hasd");
		Tag tag = tagMapper.selectOne(queryWrapper);
		System.out.println(tag.getTagName());
	}
}
