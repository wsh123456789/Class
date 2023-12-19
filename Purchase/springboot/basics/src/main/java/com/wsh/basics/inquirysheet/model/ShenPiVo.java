package com.wsh.basics.inquirysheet.model;

import com.wsh.basics.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ShenPiVo {
    @NotBlank(message = ParamUtil.ORDER_CODE_NOTNULL)
    private String requestForQuotationId;
    private String approverExplain;
    @NotBlank(message = ParamUtil.APPROVER_TIME_NOTNULL)
    private String approverTime;
    @NotBlank(message = ParamUtil.APPROVER_STATUS_NOTNULL)
    private Integer approverStatus;
}
