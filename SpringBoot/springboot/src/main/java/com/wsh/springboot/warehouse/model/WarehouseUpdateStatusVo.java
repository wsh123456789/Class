package com.wsh.springboot.warehouse.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WarehouseUpdateStatusVo {
    @NotNull(message = ParamUtil.WAREHOUSE + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotNull(message = ParamUtil.WAREHOUSE + ParamUtil.STATUS_NOTNULL)
    private Boolean status;

}
