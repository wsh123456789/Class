package com.wsh.springboot.warehouse_area.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class WarehouseAreaVo<T> {

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
    // 实行库位管理
    private Boolean warehouseManagement;
    // 与WMS集成
    private Boolean wmsIntegrate;
    // VIP库区
    private Boolean vipStorageSection;
    // 选中的库区业务属性编码列表
    // 创建人员
    private String createName;
    // 创建时间
    private Date createTime;
    // 最后修改人
    private String changeName;
    // 最后修改时间
    private Date changeTime;
    // 版本号
    private Integer version;
    // 选中的库区业务属性编码列表
    private List<T> businessAttribute;
}
