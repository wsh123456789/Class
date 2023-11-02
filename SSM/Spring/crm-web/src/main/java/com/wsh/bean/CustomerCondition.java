package com.wsh.bean;

import org.springframework.stereotype.Component;

@Component
public class CustomerCondition {
    private Integer conditionId;

    private String conditionName;

    private String conditionExplain;

    private String isUsed;

    private String customerName;

    private String customerSex;

    private String customerMobile;

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName == null ? null : conditionName.trim();
    }

    public String getConditionExplain() {
        return conditionExplain;
    }

    public void setConditionExplain(String conditionExplain) {
        this.conditionExplain = conditionExplain == null ? null : conditionExplain.trim();
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed == null ? null : isUsed.trim();
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
}