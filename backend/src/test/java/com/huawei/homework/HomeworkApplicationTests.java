package com.huawei.homework;

import com.huawei.homework.entity.User;
import com.huawei.homework.mapper.UserMapper;
import com.huawei.homework.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HomeworkApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RedisService redisService;


	@Test
	void contextLoads() {
		String result = redisService.get("name");
		System.out.println(result);
	}

	@Test
	void getUsers(){
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}

	@Test
	void setRedisTest(){
		String key = "name";
		redisService.setEx(key,"今天呀测redis哦",10L);
		String result = redisService.get(key);
		System.out.println(result);
	}
}
