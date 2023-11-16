package com.wsh.springboot.warehouse_area.model;

import com.wsh.springboot.util.PageVo;
import lombok.Data;

@Data
public class WarehouseAreaSelectVo extends PageVo {

    // 库区编码
    private String code;
    // 库房编码
    private String wareHouseCode;
    // 库区状态
    private Boolean status;

}
