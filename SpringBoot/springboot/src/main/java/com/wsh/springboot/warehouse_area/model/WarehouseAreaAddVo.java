package com.wsh.springboot.warehouse_area.model;

import com.wsh.springboot.util.PageVo;
import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class WarehouseAreaAddVo {
    // 库区id
    private Integer id;
    // 库房编码
    @NotBlank(message = ParamUtil.WAREHOUSE + ParamUtil.CODE_NOTNULL)
    private String wareHouseCode;
    // 库区编码
    @NotBlank(message = ParamUtil.WAREHOUSE_AREA + ParamUtil.CODE_NOTNULL)
    private String code;
    // 库区名称
    @NotBlank(message = ParamUtil.WAREHOUSE_AREA + ParamUtil.NAME_NOTNULL)
    private String name;
    // 库区描述
    private String remark;
    // 库区状态
    private Boolean status;
    // 实行库位管理
    private Boolean warehouseManagement;
    // 与WMS集成
    private Boolean wmsIntegrate;
    // VIP库区
    private Boolean vipStorageSection;
    // 选中的库区业务属性编码列表
    private List<String> businessAttribute;

}
