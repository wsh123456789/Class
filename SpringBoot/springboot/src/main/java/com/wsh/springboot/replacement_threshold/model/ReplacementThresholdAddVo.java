package com.wsh.springboot.replacement_threshold.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ReplacementThresholdAddVo {

    // 法人编码
    @NotBlank(message = ParamUtil.LEGAL_PERSON + ParamUtil.CODE_NOTNULL)
    private String legalPersonCode;
    // 备件编码
    @NotBlank(message = ParamUtil.REPLACEMENT + ParamUtil.CODE_NOTNULL)
    private String replacementCode;
    // 数量阈值
    @NotNull(message = ParamUtil.REPLACEMENT + ParamUtil.THRESHOLD_NOTNULL)
    @Max(value = ParamUtil.MAX_THRESHOLD, message = ParamUtil.THRESHOLD_MAX)
    private Integer threshold;
    // 备注
    private String remark;

}
