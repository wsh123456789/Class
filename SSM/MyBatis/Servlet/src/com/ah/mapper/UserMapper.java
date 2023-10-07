package com.ah.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ah.bean.User;

public interface UserMapper {

	User loginByUserNameAndPwd(@Param("username")String username, @Param("password")String password);

	ArrayList<User> queryUsers();

	int queryTotalNum();

	List<User> queryUsersPage(@Param("page")int page, @Param("page_count")int page_count);

	List<User> getUserByUsername(String username);

	int addUser(User user);

	int updateUser(User user);

	User getUsersById(int id);

	User getUserByNameAndId(@Param("id")int id, @Param("username")String username);

	int deleteUser(int id);


}
