package com.wsh.basics.spare.model;

import com.wsh.basics.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SpareAddVo {
    @NotBlank(message = ParamUtil.SPARE + ParamUtil.NAME_NOTNULL)
    private String name;
    @NotBlank(message = ParamUtil.SPARE + ParamUtil.CODE_NOTNULL)
    private String code;
    @NotNull(message = ParamUtil.SPARE + ParamUtil.STATUS_NOTNULL)
    private Boolean status;
    private String remark;

}
