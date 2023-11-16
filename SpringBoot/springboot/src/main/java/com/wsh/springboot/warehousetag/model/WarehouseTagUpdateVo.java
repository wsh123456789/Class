package com.wsh.springboot.warehousetag.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class WarehouseTagUpdateVo {

    @NotNull(message =  ParamUtil.WAREHOUSE_TAG + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotBlank(message =  ParamUtil.WAREHOUSE_TAG + ParamUtil.NAME_NOTNULL)
    private String name;
    private String remark;
    private int version;
}
