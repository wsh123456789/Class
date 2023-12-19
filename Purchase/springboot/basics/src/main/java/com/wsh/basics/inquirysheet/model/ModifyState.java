package com.wsh.basics.inquirysheet.model;

import com.wsh.basics.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ModifyState {
    @NotBlank(message = ParamUtil.ORDER_CODE_NOTNULL)
    private String requestForQuotationId;
}
