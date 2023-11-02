package com.wsh.mapper;

import org.apache.ibatis.annotations.Param;

import com.wsh.bean.User;

public interface UserMapper {

	User getUserByNameAndPs(@Param("username")String username, @Param("password")String password);

}
