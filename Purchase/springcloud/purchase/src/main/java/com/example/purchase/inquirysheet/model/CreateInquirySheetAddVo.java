package com.example.purchase.inquirysheet.model;

import com.example.purchase.util.ParamUtil;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class CreateInquirySheetAddVo {
    // 创建人
    private String createName;
    // 创建时间
    private Date createTime;
    // 询价开始日期
    @NotNull(message = ParamUtil.INQUIRY +  ParamUtil.START_TIME_NOTNULL)
    private Date startTime;
    // 询价结束日期
    @NotNull(message = ParamUtil.INQUIRY +  ParamUtil.END_TIME_NOTNULL)
    private Date endTime;
    // 询价类型
    @NotBlank(message = ParamUtil.INQUIRY +  ParamUtil.TYPE_NOTNULL)
    private String type;
    // 币别
    @NotBlank(message = ParamUtil.INQUIRY +  ParamUtil.CURRENCY_NOTNULL)
    private String currencyCode;
    // 是否含税
    @NotBlank(message = ParamUtil.INQUIRY +  ParamUtil.IS_TAX_NOTNULL)
    private String isTax;
    // 法人id
    @NotNull(message = ParamUtil.LEGAL_PERSON + ParamUtil.NAME_NOTNULL)
    private Integer legalPersonId;
    // 法人code
    private Integer legalPersonCode;
    // 询价状态
    private Integer inquiryStatus;
    // 询价单号
    private String requestForQuotationId;
    // 待询价明细表
    @Valid
    @NotEmpty(message = ParamUtil.INQUIRY_DETAILS)
    private List<InquiryDetails> inquiryDetailsList;
    // 待报价供应商表
    @Valid
    @NotEmpty(message = ParamUtil.SUPPLIER_DETAILS)
    private List<SupplierDetails> supplierDetailsList;

}
