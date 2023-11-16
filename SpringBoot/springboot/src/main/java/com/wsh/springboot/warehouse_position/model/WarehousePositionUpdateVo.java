package com.wsh.springboot.warehouse_position.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WarehousePositionUpdateVo {
    @NotNull(message = ParamUtil.WAREHOUSE_POSITION + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotNull(message = ParamUtil.WAREHOUSE_POSITION + ParamUtil.NAME_NOTNULL)
    private String name;
    //    @NotNull(message = ParamUtil.SUBCLASS + ParamUtil.VERSION_NOTNULL)
//    private int version;
}
