package com.example.purchase.inquirysheet.model;

import com.example.purchase.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ModifyState {
    @NotBlank(message = ParamUtil.ORDER_CODE_NOTNULL)
    private String requestForQuotationId;
}
