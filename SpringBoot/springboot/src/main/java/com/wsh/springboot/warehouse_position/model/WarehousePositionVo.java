package com.wsh.springboot.warehouse_position.model;

import lombok.Data;

import java.util.Date;

@Data
public class WarehousePositionVo {
    // 法人id
    private Integer legalPersonId;
    // 库位id
    private Integer id;
    // 库位状态
    private Boolean status;
    // 库位状态名称
    private String statusName;
    // 库位编码
    private String code;
    // 库位名称
    private String name;
    // 库区id
    private Integer storageSectionId;
    // 库区编码
    private String storageSectionCode;
    // 库区名称
    private String storageSectionName;
    // 库区描述
    private String storageSectionRemark;
    // 库房id
    private Integer wareHouseId;
    // 库房编码
    private String wareHouseCode;
    // 库房名称
    private String wareHouseName;
    // 库房描述
    private String wareHouseRemark;
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
}
