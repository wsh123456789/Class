package com.wsh.bean;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class CustomerInfo {
	// 客户id
    private Integer customerId;
    // 客户状态
    private Integer conditionId;
    // 客户来源
    private Integer sourceId;
    // 所属员工
    private Integer userId;
    // 客户类型
    private Integer typeId;
    // 客户姓名
    private String customerName;
    // 客户性别
    private String customerSex;
    // 客户手机
    private String customerMobile;
    // 客户QQ
    private String customerQq;
    // 客户地址
    private String customerAddress;
    // Email
    private String customerEmail;
    // 备注
    private String customerRemark;
    // 客户职位
    private String customerJob;
    // 客户微博
    private String customerBlog;
    // 客户座机
    private String customerTel;
 	// 客户MSN
    private String customerMsn;
    // 出生日期
    private String birthDay;
    // 创建人
    private String customerAddMan;
    // 修改人
    private String changeMan;
    // 客户公司
    private String customerCompany;
    // 添加时间
    private String customerAddTime;
    // 修改时间
    private String customerChangeTime;
    // 用户状态表
    private List<CustomerCondition> customerCondition;
    // 用户来源表
    private List<CustomerSource> customerSource;
    // 所属员工表
    private List<UserInfo> userInfo;
    // 客户类型表
    private List<CustomerType> customerType;
    
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getConditionId() {
		return conditionId;
	}
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerSex() {
		return customerSex;
	}
	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerQq() {
		return customerQq;
	}
	public void setCustomerQq(String customerQq) {
		this.customerQq = customerQq;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerRemark() {
		return customerRemark;
	}
	public void setCustomerRemark(String customerRemark) {
		this.customerRemark = customerRemark;
	}
	public String getCustomerJob() {
		return customerJob;
	}
	public void setCustomerJob(String customerJob) {
		this.customerJob = customerJob;
	}
	public String getCustomerBlog() {
		return customerBlog;
	}
	public void setCustomerBlog(String customerBlog) {
		this.customerBlog = customerBlog;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getCustomerMsn() {
		return customerMsn;
	}
	public void setCustomerMsn(String customerMsn) {
		this.customerMsn = customerMsn;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getChangeMan() {
		return changeMan;
	}
	public void setChangeMan(String changeMan) {
		this.changeMan = changeMan;
	}
	public String getCustomerCompany() {
		return customerCompany;
	}
	public void setCustomerCompany(String customerCompany) {
		this.customerCompany = customerCompany;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	
	
	public String getCustomerAddMan() {
		return customerAddMan;
	}
	public void setCustomerAddMan(String customerAddMan) {
		this.customerAddMan = customerAddMan;
	}
	
	public String getCustomerAddTime() {
		return customerAddTime;
	}
	public void setCustomerAddTime(String customerAddTime) {
		this.customerAddTime = customerAddTime;
	}
	public String getCustomerChangeTime() {
		return customerChangeTime;
	}
	public void setCustomerChangeTime(String customerChangeTime) {
		this.customerChangeTime = customerChangeTime;
	}
	
	
	
	public List<CustomerCondition> getCustomerCondition() {
		return customerCondition;
	}
	public void setCustomerCondition(List<CustomerCondition> customerCondition) {
		this.customerCondition = customerCondition;
	}
	public List<CustomerSource> getCustomerSource() {
		return customerSource;
	}
	public void setCustomerSource(List<CustomerSource> customerSource) {
		this.customerSource = customerSource;
	}
	public List<UserInfo> getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(List<UserInfo> userInfo) {
		this.userInfo = userInfo;
	}
	public List<CustomerType> getCustomerType() {
		return customerType;
	}
	public void setCustomerType(List<CustomerType> customerType) {
		this.customerType = customerType;
	}
	@Override
	public String toString() {
		return "CustomerInfo [customerId=" + customerId + ", conditionId=" + conditionId + ", sourceId=" + sourceId
				+ ", userId=" + userId + ", typeId=" + typeId + ", customerName=" + customerName + ", customerSex="
				+ customerSex + ", customerMobile=" + customerMobile + ", customerQq=" + customerQq
				+ ", customerAddress=" + customerAddress + ", customerEmail=" + customerEmail + ", customerRemark="
				+ customerRemark + ", customerJob=" + customerJob + ", customerBlog=" + customerBlog + ", customerTel="
				+ customerTel + ", customerMsn=" + customerMsn + ", birthDay=" + birthDay + ", customerAddMan="
				+ customerAddMan + ", changeMan=" + changeMan + ", customerCompany=" + customerCompany
				+ ", customerAddTime=" + customerAddTime + ", customerChangeTime=" + customerChangeTime
				+ ", customerCondition=" + customerCondition + ", customerSource=" + customerSource + ", userInfo="
				+ userInfo + ", customerType=" + customerType + "]";
	}
	
	
    
    
}