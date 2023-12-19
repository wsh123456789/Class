package com.example.inventory.storagesection.model;

import com.example.inventory.util.ParamUtil;
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
