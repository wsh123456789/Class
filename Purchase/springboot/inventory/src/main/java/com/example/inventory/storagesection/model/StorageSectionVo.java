package com.example.inventory.storagesection.model;

import lombok.Data;

import java.util.Date;
@Data
public class StorageSectionVo {
    private Integer id;
    private String name;
    private String code;
    private String remark;
    private String statusName;
    private Boolean status;
    private String wareHouseTCode;
    private Boolean warehouseManagement;
    private Boolean wmsIntegrate;
    private Boolean vipStorageSection;
    private String createName;
    private Date createTime;
    private String changeName;
    private Date changeTime;
    private int version;
}
