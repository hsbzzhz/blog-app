package com.huawei.homework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huawei.homework.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}