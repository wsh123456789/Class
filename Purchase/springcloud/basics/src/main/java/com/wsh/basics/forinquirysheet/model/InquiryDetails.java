package com.wsh.basics.forinquirysheet.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class InquiryDetails {
    // 币别类型
    private String currencyCode;
    // 单位
    private String measurementUnit;
    // 备件编码
    private String spareCoding;
    // 备件名称
    private String spareName;
    // 询价类型
    private String type;
    // 询价数量
    private Integer inquiryQty;
    // MOQ
    private Integer moq;
    // 交货期限
    private Integer deliveryCycle;

}
