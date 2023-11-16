package com.wsh.springboot.warehouse_position.model;

import com.wsh.springboot.util.PageVo;
import lombok.Data;

@Data
public class WarehousePositionSelectVo extends PageVo {
    private String code;
    private String storageSectionCode;
    private String wareHouseCode;
    private Boolean status;
}
