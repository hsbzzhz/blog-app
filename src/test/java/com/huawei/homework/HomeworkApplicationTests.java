package com.huawei.homework;

import com.huawei.homework.entity.User;
import com.huawei.homework.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HomeworkApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void getUsers(){
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}
}
