package com.wsh.springboot.subclass.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SubClassAddVo {
    @NotBlank(message = ParamUtil.SUBCLASS + ParamUtil.NAME_NOTNULL)
    private String name;
    @NotBlank(message = ParamUtil.SUBCLASS + ParamUtil.CODE_NOTNULL)
    private String code;
    @NotNull(message = ParamUtil.SUBCLASS + ParamUtil.STATUS_NOTNULL)
    private Boolean status;
    private String remark;

}
