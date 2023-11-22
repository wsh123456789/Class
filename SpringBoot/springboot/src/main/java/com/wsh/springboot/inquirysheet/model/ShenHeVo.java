package com.wsh.springboot.inquirysheet.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ShenHeVo {
    @NotBlank(message = ParamUtil.ORDER_CODE_NOTNULL)
    private String requestForQuotationId;
    private String auditorExplain;
    @NotBlank(message = ParamUtil.AUDITOR_TIME_NOTNULL)
    private String auditorTime;
    @NotBlank(message = ParamUtil.AUDITOR_STATUS_NOTNULL)
    private Integer auditorStatus;
}
