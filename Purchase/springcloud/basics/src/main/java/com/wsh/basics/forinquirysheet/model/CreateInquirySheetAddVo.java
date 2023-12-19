package com.wsh.basics.forinquirysheet.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreateInquirySheetAddVo {
    // 创建人
    private String createName;
    // 创建时间
    private Date createTime;
    // 询价开始日期
    private Date startTime;
    // 询价结束日期
    private Date endTime;
    // 询价类型
    private String type;
    // 币别
    private String currencyCode;
    // 是否含税
    private String isTax;
    // 法人id
    private Integer legalPersonId;
    // 法人code
    private Integer legalPersonCode;
    // 询价状态
    private Integer inquiryStatus;
    // 询价单号
    private String requestForQuotationId;
    // 待询价明细表
    private List<InquiryDetails> inquiryDetailsList;
    // 待报价供应商表
    private List<SupplierDetails> supplierDetailsList;

}
