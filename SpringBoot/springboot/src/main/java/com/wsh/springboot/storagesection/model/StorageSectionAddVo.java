package com.wsh.springboot.storagesection.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StorageSectionAddVo {
    @NotBlank(message = ParamUtil.WAREHOUSE_AREA + ParamUtil.NAME_NOTNULL)
    private String name;
    @NotBlank(message = ParamUtil.WAREHOUSE_AREA + ParamUtil.CODE_NOTNULL)
    private String code;
    private String remark;
    private Boolean status;

}
