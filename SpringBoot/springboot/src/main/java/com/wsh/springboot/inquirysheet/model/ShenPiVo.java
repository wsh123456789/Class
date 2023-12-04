package com.wsh.springboot.inquirysheet.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

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
