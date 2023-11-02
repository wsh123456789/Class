package com.wsh.bean;

import org.springframework.stereotype.Component;

@Component
public class CustomerShow {
	// 客户id
	private Integer customerId;
    // 客户姓名
	private String customerName;
	// 客户状态
	private String conditionName;
	// 客户来源
	private String sourceName;
	// 客户所属员工
	private String userName;
	// 客户类型
	private String typeName;
	// 客户性别
	private String customerSex;
	// 客户手机
	private String customerMobile;
	// 客户QQ
	private String customerQq;
	// 客户邮箱
	private String customerEmail;
	// 客户职位
	private String customerJob;
	// 客户公司
	private String customerCompany;
	// 客户备注
	private String customerRemark;
	
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getConditionName() {
		return conditionName;
	}
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerJob() {
		return customerJob;
	}
	public void setCustomerJob(String customerJob) {
		this.customerJob = customerJob;
	}
	public String getCustomerCompany() {
		return customerCompany;
	}
	public void setCustomerCompany(String customerCompany) {
		this.customerCompany = customerCompany;
	}
	public String getCustomerRemark() {
		return customerRemark;
	}
	public void setCustomerRemark(String customerRemark) {
		this.customerRemark = customerRemark;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "CustomerShow [customerId=" + customerId + ", customerName=" + customerName + ", conditionName="
				+ conditionName + ", sourceName=" + sourceName + ", userName=" + userName + ", typeName=" + typeName
				+ ", customerSex=" + customerSex + ", customerMobile=" + customerMobile + ", customerQq=" + customerQq
				+ ", customerEmail=" + customerEmail + ", customerJob=" + customerJob + ", customerCompany="
				+ customerCompany + ", customerRemark=" + customerRemark + "]";
	}
	
	
	
	
	
	
}
