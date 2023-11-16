package com.wsh.springboot.storagesection.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StorageSectionUpdateStatusVo {
    @NotNull(message = ParamUtil.WAREHOUSE_AREA + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotNull(message = ParamUtil.WAREHOUSE_AREA + ParamUtil.STATUS_NOTNULL)
    private Boolean status;

}
