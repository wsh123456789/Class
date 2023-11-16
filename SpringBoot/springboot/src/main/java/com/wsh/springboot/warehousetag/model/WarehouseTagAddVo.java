package com.wsh.springboot.warehousetag.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WarehouseTagAddVo {
    @NotBlank(message = ParamUtil.WAREHOUSE_TAG + ParamUtil.NAME_NOTNULL)
    private String name;
    @NotBlank(message = ParamUtil.WAREHOUSE_TAG + ParamUtil.CODE_NOTNULL)
    private String code;
    private String remark;
    private Boolean status;

}
