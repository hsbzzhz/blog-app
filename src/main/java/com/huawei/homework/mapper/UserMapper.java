package com.huawei.homework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huawei.homework.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}


//https://www.fcors.com/%E6%8A%80%E6%9C%AF%E4%B8%8E%E6%A1%86%E6%9E%B6/sprintboot%E7%B3%BB%E5%88%97%EF%BC%88%E5%8D%81%E4%B8%80%EF%BC%89%EF%BC%9Aorm%E5%AE%9E%E6%88%98%E8%A7%86%E5%9B%BE%E5%AF%B9%E8%B1%A1vo%E5%B1%82/