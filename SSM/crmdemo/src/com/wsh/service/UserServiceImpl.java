package com.wsh.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsh.bean.CustomerCondition;
import com.wsh.bean.CustomerInfo;
import com.wsh.bean.CustomerShow;
import com.wsh.bean.CustomerSource;
import com.wsh.bean.CustomerSourceBing;
import com.wsh.bean.CustomerType;
import com.wsh.bean.PageBean;
import com.wsh.bean.PermissionVo;
import com.wsh.bean.Role;
import com.wsh.bean.UserInfo;
import com.wsh.mapper.UserMapper;
import com.wsh.utils.Md5Util;
import com.wsh.utils.MethodUtils;
import com.wsh.utils.ParamUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PageBean pageBean;

	// 根据用户名和密码登录
	@Override
	public boolean loginByUsernameAndPw(String userName, String userPw) {
		userPw = Md5Util.string2MD5(userPw);
		UserInfo userInfo = userMapper.loginByUsernameAndPw(userName, userPw);
		if (userInfo != null) {
			return true;
		} else {
			return false;
		}

	}

	// 注册用户信息
	@Override
	public Integer registerUser(UserInfo userInfo) {
		Integer line = 0;
		if (getUserByUserName(userInfo.getUserName()) == null) {
			userInfo.setUserPw(Md5Util.string2MD5(userInfo.getUserPw()));
			line = userMapper.registerUser(userInfo);
		}
		return line;

	}

	// 根据用户名查询用户
	@Override
	public UserInfo getUserByUserName(String userName) {

		return userMapper.getUserByUserName(userName);
	}

	// 获取总页数，当前页和总数据条数
	@Override
	public PageBean getPageDetils(Integer currentPage, String queryType, String queryContent) {

		if (currentPage == null) {
			currentPage = ParamUtils.ONE;
		}
		// 总数据条数
		Integer totalSize = userMapper.getTotalSize(queryType, queryContent);
		// 总页数
		Integer totalPage = totalSize % ParamUtils.PAGE_COUNT == ParamUtils.ZERO ? totalSize / ParamUtils.PAGE_COUNT
				: totalSize / ParamUtils.PAGE_COUNT + ParamUtils.ONE;

		// 客户展示信息列表
		List<CustomerShow> cList = userMapper.getCustomer((currentPage - ParamUtils.ONE) * ParamUtils.PAGE_COUNT,
				ParamUtils.PAGE_COUNT, queryType, queryContent);

		System.out.println("----------------------------" + cList);

		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalSize(totalSize);
		pageBean.setTotalPage(totalPage);
		pageBean.setQueryType(queryType);
		pageBean.setQueryContent(queryContent);
		pageBean.setCustomerList(cList);

		return pageBean;
	}

	// 添加用户
	@Override
	public Integer addCustomer(CustomerInfo customerInfo) {
		customerInfo.setCustomerAddTime(MethodUtils.getTime());
		Integer line = userMapper.addCustomer(customerInfo);
		return line;
	}

	// 通过id查询用户
	@Override
	public CustomerInfo getCustomerById(Integer customerId) {
		CustomerInfo customerInfo = userMapper.getCustomerById(customerId);
		// 用户状态表
		List<CustomerCondition> customerCondition = userMapper.getCustomerCondition();
		// 用户来源表
		List<CustomerSource> customerSource = userMapper.getCustomerSource();
		// 所属员工表
		List<UserInfo> userInfo = userMapper.getUserInfo();
		// 客户类型表
		List<CustomerType> customerType = userMapper.getCustomerType();
		customerInfo.setCustomerChangeTime(MethodUtils.getTime());
		customerInfo.setCustomerCondition(customerCondition);
		customerInfo.setCustomerSource(customerSource);
		customerInfo.setCustomerType(customerType);
		customerInfo.setUserInfo(userInfo);
		return customerInfo;
	}

	// 修改用户信息
	@Override
	public Integer updateCustomer(CustomerInfo customerInfo) {
		
		return userMapper.updateCustomer(customerInfo);
	}

	// 删除用户信息
	@Override
	public Integer deleteCustomer(Integer customerId) {

		return userMapper.deleteCustomer(customerId);
	}

	// 获取客户类型
	@Override
	public List<CustomerType> getCustomerType() {
		return userMapper.getCustomerType();
	}

	// 添加客户类型
	@Override
	public Integer addcustomerType(CustomerType customerType) {
		return userMapper.addCustomerType(customerType);
	}

	// 删除客户类型
	@Override
	public Integer deleteCustomerTypeById(Integer typeId) {
		return userMapper.deleteCustomerTypeById(typeId);
	}

	// 获取客户状态
	@Override
	public List<CustomerCondition> getCustomerCondition() {
		return userMapper.getCustomerCondition();
	}

	// 添加客户状态
	@Override
	public Integer addCustomerCondition(CustomerCondition customerCondition) {
		// TODO Auto-generated method stub
		return userMapper.addCustomerCondition(customerCondition);
	}

	// 删除客户状态
	@Override
	public Integer deleteCustomerConditionById(Integer conditionId) {
		return userMapper.deleteCustomerConditionById(conditionId);
	}

	// 查询客户来源
	@Override
	public List<CustomerSource> getCustomerSource() {
		return userMapper.getCustomerSource();
	}

	// 添加客户来源
	@Override
	public Integer addCustomerSource(CustomerSource customerSource) {

		return userMapper.addCustomerSource(customerSource);
	}

	// 删除客户来源
	@Override
	public Integer deleteCustomerSourceById(Integer sourceId) {
		return userMapper.deleteCustomerSourceById(sourceId);
	}

	// 获取下拉菜单
	@Override
	public CustomerInfo getXiaLa() {
		CustomerInfo customerInfo = new CustomerInfo();
		// 用户状态表
		List<CustomerCondition> customerCondition = userMapper.getCustomerCondition();
		// 用户来源表
		List<CustomerSource> customerSource = userMapper.getCustomerSource();
		// 所属员工表
		List<UserInfo> userInfo = userMapper.getUserInfo();
		// 客户类型表
		List<CustomerType> customerType = userMapper.getCustomerType();
		customerInfo.setCustomerChangeTime(MethodUtils.getTime());
		customerInfo.setCustomerCondition(customerCondition);
		customerInfo.setCustomerSource(customerSource);
		customerInfo.setCustomerType(customerType);
		customerInfo.setUserInfo(userInfo);
		return customerInfo;
	}

	// 获取客户来源饼状图数据
	@Override
	public List<CustomerSourceBing> getSourceBingZhuang() {
		return userMapper.getSourceBingZhuang();
	}

	// 获取权限
	@Override
	public List<PermissionVo> getPermission(String userName) {
		List<PermissionVo> pvList = userMapper.getPermission(userName);
		// 第一层
		List<PermissionVo> firstCity = new ArrayList<>();
		for (PermissionVo pv : pvList) {
			if (pv.getParentTop() == 1) {
				firstCity.add(pv);
			}
		}

		for (PermissionVo pv1 : firstCity) {
			List<PermissionVo> secondCity = new ArrayList<>();
			// 找第二层
			for (PermissionVo pv2 : pvList) {
				if (pv2.getParentId() == pv1.getId()) {
					secondCity.add(pv2);
				}

			}
			pv1.setSonList(secondCity);
		}
		System.out.println("================================================================================\n" + firstCity);
		return firstCity;
	}

	// 查询所有角色
	@Override
	public List<Role> queryRoleAll() {
		return userMapper.queryRoleAll();
	}

	// 查询所有用户
	@Override
	public List<UserInfo> getUserAll() {
		return userMapper.getUserAll();
	}

	// 角色分配修改
	@Override
	public Integer distributerole(Integer userId, List<Integer> roleId) {
		userMapper.deleteRole(userId);
		return userMapper.addRole(userId,roleId);
	}
	
	// 权限分配回显
	@Override
	public List<PermissionVo> queryPermission() {
		
		return userMapper.queryPermission();
	}

	// 权限分配修改
	@Override
	public Integer authorityOfDistribution(Integer roleId, List<Integer> permissionId) {
		userMapper.deletePermission(roleId);
		return userMapper.addPermission(roleId,permissionId);
	}

	// 获取url
	@Override
	public List<String> queryPermissionInterfaceByUserName(String userName) {
		// TODO Auto-generated method stub
		return userMapper.queryPermissionInterfaceByUserName(userName);
	}

}
