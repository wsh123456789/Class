package com.example.purchase.inquirysheet.model;

import com.example.purchase.util.ParamUtil;
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
    @NotNull(message = ParamUtil.INQUIRY_COUNT + ParamUtil.NOT_ZERO )
    @Min(value = 1,message = ParamUtil.INQUIRY_COUNT + ParamUtil.NOT_ZERO )
    private Integer inquiryQty;
    // MOQ
    @NotNull(message = ParamUtil.MOQ + ParamUtil.NOT_ZERO )
    @Min(value = 1,message =  ParamUtil.MOQ + ParamUtil.NOT_ZERO)
    private Integer moq;
    // 交货期限
    @NotNull(message = ParamUtil.DELIVERY_CYCLE + ParamUtil.NOT_ZERO )
    @Min(value = 1,message =  ParamUtil.DELIVERY_CYCLE + ParamUtil.NOT_ZERO)
    private Integer deliveryCycle;

}
