package com.wsh.springboot.warehousetag.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WarehouseTagUpdateStatusVo {
    @NotNull(message = ParamUtil.WAREHOUSE_TAG + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotNull(message = ParamUtil.WAREHOUSE_TAG + ParamUtil.STATUS_NOTNULL)
    private Boolean status;

}
