package com.wsh.service;

import java.util.List;

import com.wsh.bean.CustomerCondition;
import com.wsh.bean.CustomerInfo;
import com.wsh.bean.CustomerSource;
import com.wsh.bean.CustomerSourceBing;
import com.wsh.bean.CustomerType;
import com.wsh.bean.PageBean;
import com.wsh.bean.PermissionVo;
import com.wsh.bean.Role;
import com.wsh.bean.UserInfo;

public interface UserService {
	
	UserInfo getUserByUserName(String userName);
	
	boolean loginByUsernameAndPw(String userName, String userPw);

	Integer registerUser(UserInfo userInfo);

	PageBean getPageDetils(Integer currentPage,String queryType, String queryContent);

	Integer addCustomer(CustomerInfo customerInfo);

	CustomerInfo getCustomerById(Integer customerId);

	Integer updateCustomer(CustomerInfo customerInfo);

	Integer deleteCustomer(Integer customerId);

	List<CustomerType> getCustomerType();

	Integer deleteCustomerTypeById(Integer typeId);

	List<CustomerCondition> getCustomerCondition();

	Integer deleteCustomerConditionById(Integer conditionId);

	List<CustomerSource> getCustomerSource();

	Integer deleteCustomerSourceById(Integer sourceId);

	Integer addcustomerType(CustomerType customerType);

	Integer addCustomerCondition(CustomerCondition customerCondition);

	Integer addCustomerSource(CustomerSource customerSource);

	CustomerInfo getXiaLa();

	List<CustomerSourceBing> getSourceBingZhuang();

	List<PermissionVo> getPermission(String userName);

	List<Role> queryRoleAll();

	List<UserInfo> getUserAll();

	Integer distributerole(Integer userId, List<Integer> roleId);

	List<PermissionVo> queryPermission();

	Integer authorityOfDistribution(Integer roleId, List<Integer> permissionId);

	List<String> queryPermissionInterfaceByUserName(String userName);
	

}
