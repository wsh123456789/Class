package com.wsh.service;

import com.wsh.bean.User;

public interface UserService {

	User getUserByNameAndPs(String username, String password);
	
}
