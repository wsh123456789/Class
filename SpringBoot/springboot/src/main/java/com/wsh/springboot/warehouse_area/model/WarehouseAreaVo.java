package com.wsh.springboot.warehouse_area.model;

import lombok.Data;

@Data
public class WarehouseAreaVo {

    // 库区id
    private Integer id;
    // 库区状态
    private Boolean status;
    // 库区编码
    private String code;
    // 库区名称
    private String name;
    // 库区描述
    private String remark;
    // 库房id
    private Integer wareHouseId;
    // 库房编码
    private String wareHouseCode;
    // 库房名称
    private String wareHouseName;
    // 库房描述
    private String wareHouseRemark;

}
