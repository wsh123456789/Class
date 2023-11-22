package com.wsh.springboot.inquirysheet.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SeeVo {
    private  Integer inquiryStatus;
    // 询价单号
    private String requestForQuotationId;
    // 询价日期
    private Date createTime;
    // 询价人员
    private String createName;
    // 法人名称
    private String legalPersonName;
    // 询价类型
    private String type;
    // 询价币别
    private String currencyCode;
    // 是否含税
    private String isTax;
    // 询价开始日期
    private Date startTime;
    // 询价结束日期
    private Date endTime;
    // 待询价明细表
    private List<InquiryDetails> inquiryDetailsList;
    // 待报价供应商表
    private List<SupplierDetails> supplierDetailsList;


}
