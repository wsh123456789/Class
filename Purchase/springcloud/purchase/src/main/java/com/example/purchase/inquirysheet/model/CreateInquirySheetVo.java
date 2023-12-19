package com.example.purchase.inquirysheet.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreateInquirySheetVo {
    // 询价表id
    private Integer id;
    // 询价单号
    private String requestForQuotationId;
    // 备件编码
    private String replacementCode;
    // 备件名称
    private String replacementName;
    // 计量单位
    private String unit;
    // 询价数量
    private Integer inquiryQty;
    // 币别
    private String currency;
    // MOQ最小询价数量
    private Integer moq;
    // 交货周期
    private Integer delivery;
    // 供应商编码
    private String code;
    // 供应商名称
    private String name;
    // 创建人
    private String createName;
    // 询价状态
    private Integer inquiryStatus;
    // 创建时间
    private Date createTime;
    // 修改人人
    private String changeName;
    // 修改时间
    private Date changeTime;
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
    // 待询价明细表
    private List<InquiryDetails> inquiryDetailsList;
    // 待报价供应商表
    private List<SupplierDetails> supplierDetailsList;
}
