package com.wsh.springboot.spare.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SpareUpdateStatusVo {
    @NotNull(message = ParamUtil.SPARE + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotNull(message = ParamUtil.SPARE + ParamUtil.STATUS_NOTNULL)
    private Boolean status;
    @NotNull(message = ParamUtil.SPARE + ParamUtil.VERSION_NOTNULL)
    private Integer version;
}
