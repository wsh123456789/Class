package com.ah.service;

import java.util.List;

import com.ah.bean.PageVo;
import com.ah.bean.User;
import com.ah.mapper.UserMapper;
import com.ah.utils.DButils;
import com.ah.utils.ParamUtils;

public class UserServiceImpl implements UserService {
	
	static UserMapper mapper = DButils.before().getMapper(UserMapper.class);
	// 登录功能
	@Override
	public boolean loginByUserNameAndPwd(String username, String password){
		
		// 校验登录
		User user = mapper.loginByUserNameAndPwd(username, password);

		DButils.after();
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	// 分页查询
	@Override
	public PageVo<User> queryUsersPage(int page) {

		Integer totalNum = mapper.queryTotalNum();
		System.out.println("totalNum" + totalNum);
		Integer totalPage = totalNum % ParamUtils.PAGE_COUNT == ParamUtils.ZERO ? totalNum / ParamUtils.PAGE_COUNT : totalNum / ParamUtils.PAGE_COUNT + ParamUtils.ONE;

		List<User> userList = mapper.queryUsersPage((page - ParamUtils.ONE) * ParamUtils.PAGE_COUNT, ParamUtils.PAGE_COUNT);

		PageVo<User> pageVo = new PageVo<>();
		pageVo.setCurrentPage(page);
		pageVo.setTotalNum(totalNum);
		pageVo.setTotalPage(totalPage);
		pageVo.setUserList(userList);
		return pageVo;
	}

	// 根据姓名查询
	@Override
	public boolean getUserByUsername(String username){
		List<User> userList = mapper.getUserByUsername(username);
		boolean flag = false;
		if (userList != null) {
			for (User user : userList) {
				if (username.equals(user.getUsername())) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	// 添加用户
	@Override
	public int addUser(User user){
		int line = mapper.addUser(user);
		DButils.after();
		return line;
	}

	// 根据id查询用户
	@Override
	public User getUsersById(int id){
		User user = mapper.getUsersById(id);
		DButils.after();
		return user;
	}

	// 根据姓名和id查询用户
	@Override
	public boolean getUserByNameAndId(int id, String username){
		User user = mapper.getUserByNameAndId(id, username);

		if (user == null) {
			return false;
		} else {
			return true;
		}
	}

	// 修改用户信息
	@Override
	public int updateUser(User user){
		int line = mapper.updateUser(user);
		DButils.after();
		return line;
	}

	// 删除用户（隐式删除）
	@Override
	public int deleteUser(int id){

		int line = mapper.deleteUser(id);
		DButils.after();
		return line;
	}

}
