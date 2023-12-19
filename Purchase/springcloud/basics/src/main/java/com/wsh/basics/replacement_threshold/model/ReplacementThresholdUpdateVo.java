package com.wsh.basics.replacement_threshold.model;

import com.wsh.basics.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
public class ReplacementThresholdUpdateVo {
    // 备件Id
    @NotNull(message = ParamUtil.REPLACEMENT + ParamUtil.ID_NOTNULL)
    private Integer thresholdId;
    // 数量阈值
    @NotNull(message = ParamUtil.REPLACEMENT + ParamUtil.THRESHOLD_NOTNULL)
    @Max(value = ParamUtil.MAX_THRESHOLD, message = ParamUtil.THRESHOLD_MAX)
    private Integer threshold;
    // 备注
    private String remark;
    @NotNull(message = ParamUtil.VERSION_NOTNULL)
    private Integer version;
}
