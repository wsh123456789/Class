package com.example.inventory.warehouse_position.model;

import com.example.inventory.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WarehousePositionUpdateStatusVo {
    @NotNull(message = ParamUtil.WAREHOUSE_POSITION + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotNull(message = ParamUtil.WAREHOUSE_POSITION + ParamUtil.STATUS_NOTNULL)
    private Boolean status;
//    @NotNull(message = ParamUtil.SUBCLASS + ParamUtil.VERSION_NOTNULL)
//    private int version;
}
