package com.ah.service;

import com.ah.bean.PageVo;
import com.ah.bean.User;

public interface UserService {

	boolean loginByUserNameAndPwd(String username, String password);

	PageVo<User> queryUsersPage(int page);

	boolean getUserByUsername(String username);

	int addUser(User user);

	User getUsersById(int id);

	boolean getUserByNameAndId(int id, String username);

	int updateUser(User user);

	int deleteUser(int id);

	

	

	

}
