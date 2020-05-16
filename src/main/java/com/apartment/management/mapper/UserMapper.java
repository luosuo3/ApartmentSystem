package com.apartment.management.mapper;

import com.apartment.management.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_name=#{user_name}")
    User selectUser(String username);
}