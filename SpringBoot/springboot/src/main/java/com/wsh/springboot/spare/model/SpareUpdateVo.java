package com.wsh.springboot.spare.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SpareUpdateVo {
    @NotNull(message = ParamUtil.SPARE + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotBlank(message = ParamUtil.SPARE + ParamUtil.NAME_NOTNULL)
    private String name;
    @NotNull(message = ParamUtil.SPARE + ParamUtil.STATUS_NOTNULL)
    private Boolean status;
    private String remark;
    @NotNull(message = ParamUtil.SPARE + ParamUtil.VERSION_NOTNULL)
    private Integer version;

}
