package com.wsh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

public interface UserMapper {

	Integer registerUser(UserInfo userInfo);

	UserInfo loginByUsernameAndPw(@Param("userName")String userName,@Param("userPw") String userPw);

	UserInfo getUserByUserName(@Param("userName")String userName);

	List<CustomerShow> getCustomer(@Param("current_page")int currentPage, @Param("page_count")int pageCount, @Param("queryType")String queryType,@Param("queryContent")String queryContent);

	PageBean getPageDetils();

	Integer getTotalSize(@Param("queryType")String queryType,@Param("queryContent")String queryContent);

	Integer addCustomer(CustomerInfo customerInfo);

	CustomerInfo getCustomerById(@Param("customerId")Integer customerId);

	Integer updateCustomer(CustomerInfo customerInfo);

	Integer deleteCustomer(@Param("customerId")Integer customerId);

	List<CustomerCondition> getCustomerCondition();

	List<CustomerSource> getCustomerSource();

	List<UserInfo> getUserInfo();

	List<CustomerType> getCustomerType();

	Integer deleteCustomerTypeById(@Param("typeId")Integer typeId);

	Integer deleteCustomerConditionById(@Param("conditionId")Integer conditionId);

	Integer deleteCustomerSourceById(@Param("sourceId")Integer sourceId);

	Integer addCustomerType(CustomerType customerType);

	Integer addCustomerCondition(CustomerCondition customerCondition);

	Integer addCustomerSource(CustomerSource customerSource);

	List<CustomerSourceBing> getSourceBingZhuang();

	List<PermissionVo> getPermission(@Param("userName")String userName);

	List<Role> queryRoleAll();

	List<UserInfo> getUserAll();

	void deleteRole(@Param("userId")Integer userId);

	Integer addRole(@Param("userId")Integer userId, @Param("roleId")List<Integer> roleId);

	List<PermissionVo> queryPermission();

	void deletePermission(@Param("roleId")Integer roleId);

	Integer addPermission(@Param("roleId")Integer roleId,@Param("permissionId") List<Integer> permissionId);

	@Select("SELECT DISTINCT pi.name FROM permission_interface pi LEFT JOIN permission p on pi.permission_id = p.id LEFT JOIN role_permission rp on p.id = rp.permissionId LEFT JOIN user_role ur ON rp.roleId = ur.role_id LEFT JOIN user_info ui ON ur.role_id = ui.role_id WHERE ui.user_name=#{userName}")
	List<String> queryPermissionInterfaceByUserName(String userName);
	
}
