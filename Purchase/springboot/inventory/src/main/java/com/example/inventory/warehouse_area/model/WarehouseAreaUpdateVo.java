package com.example.inventory.warehouse_area.model;

import com.example.inventory.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class WarehouseAreaUpdateVo {
    // 库区id
    private Integer id;
    // 库区状态
    private Boolean status;
    // 库区名称
    @NotBlank(message = ParamUtil.WAREHOUSE_AREA + ParamUtil.NAME_NOTNULL)
    private String name;
    // 库区描述
    private String remark;
    // 实行库位管理
    private Boolean warehouseManagement;
    // 与WMS集成
    private Boolean wmsIntegrate;
    // VIP库区
    private Boolean vipStorageSection;
    // 选中的库区业务属性编码列表
    private List<String> businessAttribute;
    // 版本号
    private Integer version;

}
