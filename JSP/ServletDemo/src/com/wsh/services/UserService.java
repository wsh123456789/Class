package com.wsh.services;

import com.wsh.bean.PageVo;
import com.wsh.bean.User;

import java.util.ArrayList;

public interface UserService {

    boolean loginByNameAndPwd(String username, String password);

    ArrayList<User> queryUsers();

    PageVo queryUsersPage(int page, int page_count);

    boolean addUsers(User user);

    boolean deleteUsers(Integer id);

    Integer updateUsers(User user);

    User getUserById(Integer id);

    boolean getUserByIdAndName(Integer id, String username);
}

