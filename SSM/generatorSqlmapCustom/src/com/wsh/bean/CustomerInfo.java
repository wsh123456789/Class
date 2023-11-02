package com.wsh.bean;

import java.util.Date;

public class CustomerInfo {
    private Integer customerId;

    private Integer conditionId;

    private Integer sourceId;

    private Integer userId;

    private Integer typeId;

    private String customerName;

    private String customerSex;

    private String customerMobile;

    private String customerQq;

    private String customerAddress;

    private String customerEmail;

    private String customerRemark;

    private String customerJob;

    private String customerBlog;

    private String customerTel;

    private String customerMsn;

    private Date birthDay;

    private Date customerAddtime;

    private String customerAddman;

    private Date customerChangtime;

    private String changeMan;

    private String customerCompany;

    private String isUsed;

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
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex == null ? null : customerSex.trim();
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile == null ? null : customerMobile.trim();
    }

    public String getCustomerQq() {
        return customerQq;
    }

    public void setCustomerQq(String customerQq) {
        this.customerQq = customerQq == null ? null : customerQq.trim();
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress == null ? null : customerAddress.trim();
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail == null ? null : customerEmail.trim();
    }

    public String getCustomerRemark() {
        return customerRemark;
    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark == null ? null : customerRemark.trim();
    }

    public String getCustomerJob() {
        return customerJob;
    }

    public void setCustomerJob(String customerJob) {
        this.customerJob = customerJob == null ? null : customerJob.trim();
    }

    public String getCustomerBlog() {
        return customerBlog;
    }

    public void setCustomerBlog(String customerBlog) {
        this.customerBlog = customerBlog == null ? null : customerBlog.trim();
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel == null ? null : customerTel.trim();
    }

    public String getCustomerMsn() {
        return customerMsn;
    }

    public void setCustomerMsn(String customerMsn) {
        this.customerMsn = customerMsn == null ? null : customerMsn.trim();
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getCustomerAddtime() {
        return customerAddtime;
    }

    public void setCustomerAddtime(Date customerAddtime) {
        this.customerAddtime = customerAddtime;
    }

    public String getCustomerAddman() {
        return customerAddman;
    }

    public void setCustomerAddman(String customerAddman) {
        this.customerAddman = customerAddman == null ? null : customerAddman.trim();
    }

    public Date getCustomerChangtime() {
        return customerChangtime;
    }

    public void setCustomerChangtime(Date customerChangtime) {
        this.customerChangtime = customerChangtime;
    }

    public String getChangeMan() {
        return changeMan;
    }

    public void setChangeMan(String changeMan) {
        this.changeMan = changeMan == null ? null : changeMan.trim();
    }

    public String getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(String customerCompany) {
        this.customerCompany = customerCompany == null ? null : customerCompany.trim();
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed == null ? null : isUsed.trim();
    }
}