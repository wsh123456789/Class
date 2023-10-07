package com.wsh.services;

import com.wsh.bean.PageVo;
import com.wsh.bean.User;
import com.wsh.dao.UserDao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDao();
    // 每页展示多少条数据
    int page_count = 5;

    // 用户登录
    @Override
    public boolean loginByNameAndPwd(String username, String password) {

        if (username.matches("[^0]\\d{10}")){
            return userDao.loginByNameAndPwd(username, password);
        }else {
            return false;
        }
    }

    // 查询用户所有信息
    @Override
    public ArrayList<User> queryUsers() {
        return userDao.queryUsers();

    }

    // 分页查询数据
    @Override
    public PageVo queryUsersPage(int page, int count) {

        if (count !=  page_count){
            page_count = count;
        }

        // 查询总条数
        int totalNum = userDao.queryTotalNum();

        // 计算总页数 每页展示多少条数据
        int totalPage = totalNum % page_count == 0 ? totalNum / page_count : (totalNum / page_count) + 1;

        //每页展示的数据
        List<User> userList = userDao.queryUsersPage(page, page_count);

        // 赋值
        PageVo pageVo = new PageVo<>();
        pageVo.setCurrentPage(page);
        pageVo.setTotalNum(totalNum);
        pageVo.setTotalPage(totalPage);
        pageVo.setUserList(userList);
        pageVo.setPageCount(page_count);
        return pageVo;
    }

    @Override
    public boolean addUsers(User user) {
        // 判断用户是否存在
        if (user.getId() == null || userDao.getUserById(user.getId()) == null) {
            return userDao.addUsers(user);
        } else {
            return false;
        }

    }

    @Override
    public boolean deleteUsers(Integer id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            return userDao.deleteUsers(id);
        } else {
            return false;
        }
    }


    @Override
    public Integer updateUsers(User user) {

        return userDao.updateUsers(user);
    }

    @Override
    public User getUserById(Integer id) {

        return userDao.getUserById(id);
    }

    @Override
    public boolean getUserByIdAndName(Integer id, String username) {
        return userDao.getUserByIdAndName(id, username);
    }


}