package com.wsh.springboot.warehouse_area.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WarehouseAreaUpdateStatusVo {
    @NotNull(message = ParamUtil.SUBCLASS + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotNull(message = ParamUtil.SUBCLASS + ParamUtil.STATUS_NOTNULL)
    private Boolean status;
//    @NotNull(message = ParamUtil.SUBCLASS + ParamUtil.VERSION_NOTNULL)
//    private int version;
}
