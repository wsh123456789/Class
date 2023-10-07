package com.wsh.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsh.bean.User;

public interface UserMapper {

	List<User> getUserAll();

	List<User> getUserByUsernameAndPassword(@Param("username") String username, @Param("password")String password);

	List<User> getUserByUser(User user1);

	List<User> getUserByList(HashMap<String, String> hash);

	Integer addUser(User user);

	Integer updateUser(User user);

	Integer deleteUser(User user);

	List<User> getUserByUsernameAndAge(@Param("username")String username, @Param("ages")List<Integer> ages);
	
}
