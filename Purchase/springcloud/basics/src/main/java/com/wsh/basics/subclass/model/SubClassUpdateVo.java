package com.wsh.basics.subclass.model;

import com.wsh.basics.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SubClassUpdateVo {
    @NotNull(message = ParamUtil.SUBCLASS + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotBlank(message = ParamUtil.SUBCLASS + ParamUtil.NAME_NOTNULL)
    private String name;
    @NotNull(message = ParamUtil.SUBCLASS + ParamUtil.STATUS_NOTNULL)
    private Boolean status;

    private String remark;
    @NotNull(message = ParamUtil.SUBCLASS + ParamUtil.VERSION_NOTNULL)
    private int version;

}
