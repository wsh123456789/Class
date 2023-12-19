package com.example.inventory.warehouse.model;

import com.example.inventory.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WarehouseUpdateStatusVo {
    @NotNull(message = ParamUtil.WAREHOUSE + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotNull(message = ParamUtil.WAREHOUSE + ParamUtil.STATUS_NOTNULL)
    private Boolean status;

}
